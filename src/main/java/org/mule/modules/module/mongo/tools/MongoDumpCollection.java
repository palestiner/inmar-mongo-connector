/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 * <p>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.module.mongo.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoDumpCollection implements Callable<Void> {
    private final DBCollection collection;
    private DumpWriter dumpWriter;
    private DBObject query;
    private String name;
    private final List<Integer> options = new ArrayList<Integer>();

    public MongoDumpCollection(final DBCollection collection) {
        this.collection = collection;
    }

    public Void call() throws Exception {
        final DBCursor cursor = query != null ? collection.find(query) : collection.find();
        cursor.sort(new BasicDBObject("_id", 1));

        for (final Integer option : options) {
            cursor.addOption(option);
        }

        while (cursor.hasNext()) {
            final BasicDBObject dbObject = (BasicDBObject) cursor.next();
            dumpWriter.writeObject(name != null ? name : collection.getName(), dbObject);
        }
        return null;
    }

    public void setDumpWriter(final DumpWriter dumpWriter) {
        this.dumpWriter = dumpWriter;
    }

    public void setQuery(final DBObject query) {
        this.query = query;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void addOption(final Integer option) {
        this.options.add(option);
    }

}
