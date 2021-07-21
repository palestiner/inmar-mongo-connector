
package org.mule.modules.module.mongo.processors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.module.mongo.connectivity.MongoCloudConnectorConnectionManager;
import org.mule.modules.module.mongo.MongoCloudConnector;
import org.mule.modules.module.mongo.api.WriteConcern;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * RemoveObjectsUsingQueryMapMessageProcessor invokes the {@link MongoCloudConnector#removeObjectsUsingQueryMap(java.lang.String, java.util.Map, WriteConcern)} method in {@link MongoCloudConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class RemoveObjectsUsingQueryMapMessageProcessor
        extends AbstractConnectedProcessor
        implements MessageProcessor {

    protected Object collection;
    protected String _collectionType;
    protected Object queryAttributes;
    protected Map<String, Object> _queryAttributesType;
    protected Object writeConcern;
    protected WriteConcern _writeConcernType;

    public RemoveObjectsUsingQueryMapMessageProcessor(String operationName) {
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
     * Sets writeConcern
     *
     * @param value Value to set
     */
    public void setWriteConcern(Object value) {
        this.writeConcern = value;
    }

    /**
     * Sets collection
     *
     * @param value Value to set
     */
    public void setCollection(Object value) {
        this.collection = value;
    }

    /**
     * Sets queryAttributes
     *
     * @param value Value to set
     */
    public void setQueryAttributes(Object value) {
        this.queryAttributes = value;
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
            final String _transformedCollection = ((String) evaluateAndTransform(getMuleContext(), event, RemoveObjectsUsingQueryMapMessageProcessor.class.getDeclaredField("_collectionType").getGenericType(), null, collection));
            final Map<String, Object> _transformedQueryAttributes = ((Map<String, Object>) evaluateAndTransform(getMuleContext(), event, RemoveObjectsUsingQueryMapMessageProcessor.class.getDeclaredField("_queryAttributesType").getGenericType(), null, queryAttributes));
            final WriteConcern _transformedWriteConcern = ((WriteConcern) evaluateAndTransform(getMuleContext(), event, RemoveObjectsUsingQueryMapMessageProcessor.class.getDeclaredField("_writeConcernType").getGenericType(), null, writeConcern));
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object>) moduleObject).getProcessTemplate();
            processTemplate.execute(new ProcessCallback<Object, Object>() {


                                        public List<Class<? extends Exception>> getManagedExceptions() {
                                            return Arrays.asList(((Class<? extends Exception>[]) new Class[]{IllegalStateException.class}));
                                        }

                                        public boolean isProtected() {
                                            return false;
                                        }

                                        public Object process(Object object)
                                                throws Exception {
                                            ((MongoCloudConnector) object).removeObjectsUsingQueryMap(_transformedCollection, _transformedQueryAttributes, _transformedWriteConcern);
                                            return null;
                                        }

                                    }
                    , this, event);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

}
