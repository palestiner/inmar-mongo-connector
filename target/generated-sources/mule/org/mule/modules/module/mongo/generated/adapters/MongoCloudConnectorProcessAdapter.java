
package org.mule.modules.module.mongo.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.module.mongo.MongoCloudConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>MongoCloudConnectorProcessAdapter</code> is a wrapper around {@link MongoCloudConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2021-06-09T06:46:06+07:00", comments = "Build UNNAMED.2810.4347dd1")
public class MongoCloudConnectorProcessAdapter
    extends MongoCloudConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<MongoCloudConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, MongoCloudConnectorCapabilitiesAdapter> getProcessTemplate() {
        final MongoCloudConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,MongoCloudConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, MongoCloudConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, MongoCloudConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
