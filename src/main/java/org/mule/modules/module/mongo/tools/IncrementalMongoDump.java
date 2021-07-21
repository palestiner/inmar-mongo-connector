/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 * <p>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.module.mongo.tools;

import com.mongodb.DB;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class IncrementalMongoDump extends AbstractMongoUtility {
    private Map<String, DB> dbs = new HashMap<String, DB>();
    private String incrementalTimestampFile;

    public void dump(String outputDirectory, String database) throws IOException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        IncrementalOplogDump incrementalOplogDump = new IncrementalOplogDump();
        incrementalOplogDump.setOutputDirectory(outputDirectory);
        incrementalOplogDump.setDatabase(database);
        incrementalOplogDump.setIncrementalTimestampFile(incrementalTimestampFile);
        incrementalOplogDump.setDBs(dbs);
        Future<Void> future = executor.submit(incrementalOplogDump);
        propagateException(future);
    }

    public void addDB(DB db) {
        dbs.put(db.getName(), db);
    }

    public void setIncrementalTimestampFile(String incrementalTimestampFile) {
        this.incrementalTimestampFile = incrementalTimestampFile;
    }
}
