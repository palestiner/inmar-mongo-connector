/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 * <p>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.module.mongo.tools;

public class BackupConstants {
    public static final String OPLOG = "oplog";
    public static final String ADMIN_DB = "admin";
    public static final String LOCAL_DB = "local";
    public static final String TIMESTAMP_FIELD = "ts";
    public static final String NAMESPACE_FIELD = "ns";

    private BackupConstants() {
    }
}
