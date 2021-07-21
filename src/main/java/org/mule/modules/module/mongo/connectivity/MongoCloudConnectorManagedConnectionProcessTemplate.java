
package org.mule.modules.module.mongo.connectivity;

import javax.annotation.Generated;

import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessInterceptor;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.module.mongo.adapters.MongoCloudConnectorConnectionIdentifierAdapter;
import org.mule.modules.module.mongo.connection.ConnectionManager;
import org.mule.modules.module.mongo.process.MongoCloudConnectorManagedConnectionProcessInterceptor;
import org.mule.security.oauth.callback.ProcessCallback;
import org.mule.security.oauth.process.ProcessCallbackProcessInterceptor;
import org.mule.security.oauth.process.RetryProcessInterceptor;

@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class MongoCloudConnectorManagedConnectionProcessTemplate<P> implements ProcessTemplate<P, MongoCloudConnectorConnectionIdentifierAdapter> {

    private final ProcessInterceptor<P, MongoCloudConnectorConnectionIdentifierAdapter> processInterceptor;

    public MongoCloudConnectorManagedConnectionProcessTemplate(ConnectionManager<MongoCloudConnectorConnectionKey, MongoCloudConnectorConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        ProcessInterceptor<P, MongoCloudConnectorConnectionIdentifierAdapter> processCallbackProcessInterceptor = new ProcessCallbackProcessInterceptor<P, MongoCloudConnectorConnectionIdentifierAdapter>();
        ProcessInterceptor<P, MongoCloudConnectorConnectionIdentifierAdapter> managedConnectionProcessInterceptor = new MongoCloudConnectorManagedConnectionProcessInterceptor<P>(processCallbackProcessInterceptor, connectionManager, muleContext);
        ProcessInterceptor<P, MongoCloudConnectorConnectionIdentifierAdapter> retryProcessInterceptor = new RetryProcessInterceptor<P, MongoCloudConnectorConnectionIdentifierAdapter>(managedConnectionProcessInterceptor, muleContext, connectionManager.getRetryPolicyTemplate());
        processInterceptor = retryProcessInterceptor;
    }

    public P execute(ProcessCallback<P, MongoCloudConnectorConnectionIdentifierAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
            throws Exception {
        return processInterceptor.execute(processCallback, null, messageProcessor, event);
    }

    public P execute(ProcessCallback<P, MongoCloudConnectorConnectionIdentifierAdapter> processCallback, Filter filter, MuleMessage message)
            throws Exception {
        return processInterceptor.execute(processCallback, null, filter, message);
    }

}
