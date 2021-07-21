
package org.mule.modules.module.mongo.generated.connectivity;

import javax.annotation.Generated;
import org.mule.api.ConnectionException;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionAdapter;
import org.mule.modules.module.mongo.MongoCloudConnector;
import org.mule.modules.module.mongo.generated.adapters.MongoCloudConnectorConnectionManagementAdapter;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2021-06-09T06:46:06+07:00", comments = "Build UNNAMED.2810.4347dd1")
public class MongoCloudConnectorAdapter
    extends MongoCloudConnectorConnectionManagementAdapter
    implements ConnectionManagementConnectionAdapter<Object, MongoCloudConnectorConnectionKey>
{


    @Override
    public void connect(MongoCloudConnectorConnectionKey connectionKey)
        throws ConnectionException
    {
        super.connect(connectionKey.getUsername(), connectionKey.getPassword(), connectionKey.getDatabase());
    }

    @Override
    public void disconnect() {
        super.disconnect();
    }

    @Override
    public String connectionId() {
        return super.connectionId();
    }

    @Override
    public boolean isConnected() {
        return super.isConnected();
    }

    @Override
    public MongoCloudConnector getStrategy() {
        return this;
    }

}
