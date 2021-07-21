/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.module.mongo.api;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author flbulgarelli
 */
public interface MongoClient extends Closeable
{
    Collection<String> listCollections();

    DBCollection getCollection(@NotNull String name);

    boolean existsCollection(@NotNull String name);

    void dropCollection(@NotNull String name);

    void createCollection(@NotNull String name, boolean capped, Integer maxObjects, Integer size);

    String insertObject(@NotNull String collection,
                        @NotNull DBObject object,
                        @NotNull WriteConcern writeConcern);

    void updateObjects(@NotNull String collection,
                       DBObject query,
                       DBObject object,
                       boolean upsert,
                       boolean multi,
                       @NotNull WriteConcern writeConcern);

    void saveObject(@NotNull String collection, @NotNull DBObject object, @NotNull WriteConcern writeConcern);

    void removeObjects(@NotNull String collection, DBObject query, @NotNull WriteConcern writeConcern);

    Iterable<DBObject> mapReduceObjects(@NotNull String collection,
                                        @NotNull String mapFunction,
                                        @NotNull String reduceFunction,
                                        String outputCollection);

    long countObjects(@NotNull String collection, DBObject query);

    Iterable<DBObject> findObjects(@NotNull String collection,
                                   DBObject query,
                                   List<String> fields,
                                   Integer numToSkip,
                                   Integer limit,
                                   DBObject sortBy);

    DBObject findOneObject(@NotNull String collection, DBObject query, List<String> fields, boolean failOnNotFound);

    void createIndex(String collection, String field, IndexOrder order);

    void dropIndex(String collection, String name);

    Collection<DBObject> listIndices(String collection);

    DBObject createFile(InputStream content, String filename, String contentType, DBObject metadata);

    Iterable<DBObject> findFiles(DBObject query);

    DBObject findOneFile(DBObject query);

    InputStream getFileContent(DBObject query);

    Iterable<DBObject> listFiles(DBObject query);

    void removeFiles(DBObject query);

    DBObject executeComamnd(DBObject command);

    void addUser(String username, String password);

    void dropDatabase();

    void requestStart();

    void requestDone();
}
