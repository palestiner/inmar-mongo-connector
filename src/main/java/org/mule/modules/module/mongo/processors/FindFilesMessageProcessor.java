
package org.mule.modules.module.mongo.processors;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;

import com.mongodb.DBObject;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.module.mongo.connectivity.MongoCloudConnectorConnectionManager;
import org.mule.modules.module.mongo.MongoCloudConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * FindFilesMessageProcessor invokes the {@link MongoCloudConnector#findFiles(com.mongodb.DBObject)} method in {@link MongoCloudConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class FindFilesMessageProcessor
        extends AbstractConnectedProcessor
        implements MessageProcessor {

    protected Object query;
    protected DBObject _queryType;

    public FindFilesMessageProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     *
     * @throws InitialisationException
     */
    public void initialise()
            throws InitialisationException {
    }

    @Override
    public void start()
            throws MuleException {
        super.start();
    }

    @Override
    public void stop()
            throws MuleException {
        super.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets query
     *
     * @param value Value to set
     */
    public void setQuery(Object value) {
        this.query = value;
    }

    /**
     * Invokes the MessageProcessor.
     *
     * @param event MuleEvent to be processed
     * @throws Exception
     */
    public MuleEvent doProcess(final MuleEvent event)
            throws Exception {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(MongoCloudConnectorConnectionManager.class, false, event);
            final DBObject _transformedQuery = ((DBObject) evaluateAndTransform(getMuleContext(), event, FindFilesMessageProcessor.class.getDeclaredField("_queryType").getGenericType(), null, query));
            Object resultPayload;
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object>) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object, Object>() {


                                                        public List<Class<? extends Exception>> getManagedExceptions() {
                                                            return Arrays.asList(((Class<? extends Exception>[]) new Class[]{IllegalStateException.class}));
                                                        }

                                                        public boolean isProtected() {
                                                            return false;
                                                        }

                                                        public Object process(Object object)
                                                                throws Exception {
                                                            return ((MongoCloudConnector) object).findFiles(_transformedQuery);
                                                        }

                                                    }
                    , this, event);
            event.getMessage().setPayload(resultPayload);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

}
