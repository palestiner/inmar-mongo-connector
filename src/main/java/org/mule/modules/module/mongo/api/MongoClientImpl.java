/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 * <p>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.module.mongo.api;

import com.mongodb.*;
import com.mongodb.MapReduceCommand.OutputType;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import org.apache.commons.lang.Validate;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

public class MongoClientImpl implements MongoClient {
    private static final Logger logger = LoggerFactory.getLogger(MongoClientImpl.class);

    private final DB db;

    public MongoClientImpl(final DB db) {
        Validate.notNull(db);
        this.db = db;
    }

    public void close() throws IOException {
        try {
            db.getMongoClient().close();
        } catch (final Exception e) {
            logger.warn("Failed to properly clean cursors of db: " + db, e);
        }

        try {
            db.command("requestDone");
        } catch (final Exception e) {
            logger.warn("Failed to properly set request done for db: " + db, e);
        }
    }

    public long countObjects(@NotNull final String collection, final DBObject query) {
        Validate.notNull(collection);
        if (query == null) {
            return db.getCollection(collection).getCount();
        }
        return db.getCollection(collection).getCount(query);
    }

    public void createCollection(@NotNull final String collection,
                                 final boolean capped,
                                 final Integer maxObjects,
                                 final Integer size) {
        Validate.notNull(collection);
        final BasicDBObject options = new BasicDBObject("capped", capped);
        if (maxObjects != null) {
            options.put("maxObject", maxObjects);
        }
        if (size != null) {
            options.put("size", size);
        }
        db.createCollection(collection, options);
    }

    public DBCollection getCollection(@NotNull final String collection) {
        Validate.notNull(collection);
        return db.getCollection(collection);
    }

    public void addUser(final String username, final String password) {
        Validate.notNull(username);
        Validate.notNull(password);
        db.addUser(username, password.toCharArray());
    }

    public void dropDatabase() {
        db.dropDatabase();
    }

    public void dropCollection(@NotNull final String collection) {
        Validate.notNull(collection);
        db.getCollection(collection).drop();
    }

    public boolean existsCollection(@NotNull final String collection) {
        Validate.notNull(collection);
        return db.getCollectionNames().contains(collection);
    }

    @Override
    public Iterable<DBObject> findObjects(@NotNull final String collection,
                                          final DBObject query,
                                          final List<String> fields,
                                          final Integer numToSkip,
                                          final Integer limit,
                                          DBObject sortBy) {
        Validate.notNull(collection);

        DBCursor dbCursor = db.getCollection(collection).find(query, FieldsSet.from(fields));
        if (numToSkip != null) {
            dbCursor = dbCursor.skip(numToSkip);
        }
        if (limit != null) {
            dbCursor = dbCursor.limit(limit);
        }
        if (sortBy != null) {
            dbCursor.sort(sortBy);
        }

        return bug5588Workaround(dbCursor);
    }

    public DBObject findOneObject(@NotNull final String collection,
                                  final DBObject query,
                                  final List<String> fields, boolean failOnNotFound) {
        Validate.notNull(collection);
        final DBObject element = db.getCollection(collection).findOne(query,
                FieldsSet.from(fields));

        if (element == null && failOnNotFound) {
            throw new MongoException("No object found for query " + query);
        }
        return element;
    }

    public String insertObject(@NotNull final String collection,
                               @NotNull final DBObject object,
                               @NotNull final org.mule.modules.module.mongo.api.WriteConcern writeConcern) {
        Validate.notNull(collection);
        Validate.notNull(object);
        Validate.notNull(writeConcern);
        db.getCollection(collection).insert(object);
        final ObjectId id = (ObjectId) object.get("_id");
        if (id == null) {
            return null;
        }

        return id.toStringMongod();
    }

    public Collection<String> listCollections() {
        return db.getCollectionNames();
    }

    public Iterable<DBObject> mapReduceObjects(@NotNull final String collection,
                                               @NotNull final String mapFunction,
                                               @NotNull final String reduceFunction,
                                               final String outputCollection) {
        Validate.notNull(collection);
        Validate.notEmpty(mapFunction);
        Validate.notEmpty(reduceFunction);
        return bug5588Workaround(db.getCollection(collection)
                .mapReduce(mapFunction, reduceFunction, outputCollection, null)
                .results());
    }

    private OutputType outputTypeFor(final String outputCollection) {
        return outputCollection != null ? OutputType.REPLACE : OutputType.INLINE;
    }

    public void removeObjects(@NotNull final String collection,
                              final DBObject query,
                              @NotNull final org.mule.modules.module.mongo.api.WriteConcern writeConcern) {
        Validate.notNull(collection);
        Validate.notNull(writeConcern);
        db.getCollection(collection).remove(query != null ? query : new BasicDBObject());
    }

    public void saveObject(@NotNull final String collection,
                           @NotNull final DBObject object,
                           @NotNull final org.mule.modules.module.mongo.api.WriteConcern writeConcern) {
        Validate.notNull(collection);
        Validate.notNull(object);
        Validate.notNull(writeConcern);
        db.getCollection(collection).save(object);
    }

    public void updateObjects(@NotNull final String collection,
                              final DBObject query,
                              final DBObject object,
                              final boolean upsert,
                              final boolean multi,
                              final WriteConcern writeConcern) {
        Validate.notNull(collection);
        Validate.notNull(writeConcern);
        db.getCollection(collection).update(query, object, upsert, multi);

    }

    public void createIndex(final String collection, final String field, final IndexOrder order) {
        db.getCollection(collection).createIndex(new BasicDBObject(field, order.getValue()));
    }

    public void dropIndex(final String collection, final String name) {
        db.getCollection(collection).dropIndex(name);
    }

    public Collection<DBObject> listIndices(final String collection) {
        return db.getCollection(collection).getIndexInfo();
    }

    public DBObject createFile(final InputStream content,
                               final String filename,
                               final String contentType,
                               final DBObject metadata) {
        Validate.notNull(filename);
        Validate.notNull(content);
        final GridFSInputFile file = getGridFs().createFile(content);
        file.setFilename(filename);
        file.setContentType(contentType);
        if (metadata != null) {
            file.put("metadata", metadata);
        }
        file.save();
        return file;
    }

    public Iterable<DBObject> findFiles(final DBObject query) {
        return bug5588Workaround(getGridFs().find(query));
    }

    public DBObject findOneFile(final DBObject query) {
        Validate.notNull(query);
        final GridFSDBFile file = getGridFs().findOne(query);
        if (file == null) {
            throw new MongoException("No file found for query " + query);
        }
        return file;
    }

    public InputStream getFileContent(final DBObject query) {
        Validate.notNull(query);
        return ((GridFSDBFile) findOneFile(query)).getInputStream();
    }

    public Iterable<DBObject> listFiles(final DBObject query) {
        return bug5588Workaround(getGridFs().getFileList(query));
    }

    public void removeFiles(final DBObject query) {
        getGridFs().remove(query);
    }

    public DBObject executeComamnd(final DBObject command) {
        return db.command(command);
    }

    public void requestStart() {
        db.command("requestStart");
    }

    public void requestDone() {
        db.command("requestDone");
    }

    protected GridFS getGridFs() {
        return new GridFS(db);
    }

    /*
     * see http://www.mulesoft.org/jira/browse/MULE-5588
     */
    @SuppressWarnings("unchecked")
    private Iterable<DBObject> bug5588Workaround(final Iterable<? extends DBObject> o) {
        if (o instanceof Collection<?>) {
            return (Iterable<DBObject>) o;
        }
        return new MongoCollection(o);
    }

    public DB getDb() {
        return db;
    }

}
