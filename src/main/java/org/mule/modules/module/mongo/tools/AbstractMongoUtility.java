/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 * <p>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */


package org.mule.modules.module.mongo.tools;

import java.util.concurrent.Future;

public abstract class AbstractMongoUtility {
    public void propagateException(Future<Void> future) {
        try {
            future.get();
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            future.cancel(true);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

}
