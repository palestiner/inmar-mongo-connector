/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 * <p>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */


package org.mule.modules.module.mongo.tools;

import java.io.File;
import java.util.regex.Pattern;


public class BackupUtils {
    private static final String SYSTEM_COLLECTION_PREFIX = "system.";
    private static final String BSON_EXTENSION = "bson";

    private BackupUtils() {
    }

    public static boolean isBsonFile(File file) {
        return hasExtension(file, BSON_EXTENSION);
    }

    public static boolean hasExtension(File file, String extension) {
        return file.getName().endsWith("." + extension);
    }

    public static String getCollectionName(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    public static boolean isSystemCollection(String collection) {
        return collection.startsWith(SYSTEM_COLLECTION_PREFIX);
    }

    public static boolean isUserCollection(String collection) {
        return collection.endsWith(SYSTEM_COLLECTION_PREFIX + "user");
    }

    public static String removeExtension(String path) {
        return path.substring(0, path.lastIndexOf("."));
    }

    public static Pattern getNamespacePattern(String database) {
        return Pattern.compile("^" + database + ".*");
    }

}
