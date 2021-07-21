
package org.mule.modules.module.mongo.adapters;

import javax.annotation.Generated;

import org.mule.modules.module.mongo.connection.Connection;
import org.mule.modules.module.mongo.MongoCloudConnector;


/**
 * A <code>MongoCloudConnectorConnectionIdentifierAdapter</code> is a wrapper around {@link MongoCloudConnector } that implements {@link org.mule.devkit.dynamic.api.helper.Connection} interface.
 *
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class MongoCloudConnectorConnectionIdentifierAdapter
    extends MongoCloudConnectorProcessAdapter
    implements Connection
{


    public String getConnectionIdentifier() {
        return super.connectionId();
    }

}
