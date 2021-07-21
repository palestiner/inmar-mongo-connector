/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 * <p>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 * <p>
 * fi * Mule MongoDB Cloud Connector
 * <p>
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * <p>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 * <p>
 * This file was automatically generated by the Mule Cloud Connector Development Kit
 * <p>
 * fi * Mule MongoDB Cloud Connector
 * <p>
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * <p>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 * <p>
 * This file was automatically generated by the Mule Cloud Connector Development Kit
 */

/**
 fi * Mule MongoDB Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/**
 * This file was automatically generated by the Mule Cloud Connector Development Kit
 */

package org.mule.modules.module.mongo;

import org.mule.modules.module.mongo.api.MongoClient;

public class MongoSession {

    private String username;
    private MongoClient client;

    public MongoSession(String username, MongoClient client) {
        this.username = username;
        this.client = client;
    }

    public String getUsername() {
        return username;
    }

    public MongoClient getClient() {
        return client;
    }
}
