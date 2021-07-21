/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 * <p>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.module.mongo.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    private static final String ZIP_EXTENSION = "zip";

    private ZipUtils() {
    }

    public static void zipDirectory(String dbDumpPath) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(dbDumpPath + ".zip");
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        File dumpDirectory = new File(dbDumpPath);

        addDirectory(zipOutputStream, dumpDirectory);

        zipOutputStream.close();

    }

    private static void addDirectory(ZipOutputStream zipOutputStream, File dumpDirectory) throws IOException {
        File[] files = dumpDirectory.listFiles();

        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                addDirectory(zipOutputStream, file);
                continue;
            }
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                byte[] buffer = new byte[1024];
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));

                int length;
                while ((length = fileInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, length);
                }
                zipOutputStream.closeEntry();
            }
        }
    }

    public static boolean isZipFile(File file) {
        return BackupUtils.hasExtension(file, ZIP_EXTENSION);
    }
}
