
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
 * InsertObjectFromMapMessageProcessor invokes the {@link MongoCloudConnector#insertObjectFromMap(java.lang.String, java.util.Map, WriteConcern)} method in {@link MongoCloudConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class InsertObjectFromMapMessageProcessor
        extends AbstractConnectedProcessor
        implements MessageProcessor {

    protected Object collection;
    protected String _collectionType;
    protected Object elementAttributes;
    protected Map<String, Object> _elementAttributesType;
    protected Object writeConcern;
    protected WriteConcern _writeConcernType;

    public InsertObjectFromMapMessageProcessor(String operationName) {
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
     * Sets elementAttributes
     *
     * @param value Value to set
     */
    public void setElementAttributes(Object value) {
        this.elementAttributes = value;
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
            final String _transformedCollection = ((String) evaluateAndTransform(getMuleContext(), event, InsertObjectFromMapMessageProcessor.class.getDeclaredField("_collectionType").getGenericType(), null, collection));
            final Map<String, Object> _transformedElementAttributes = ((Map<String, Object>) evaluateAndTransform(getMuleContext(), event, InsertObjectFromMapMessageProcessor.class.getDeclaredField("_elementAttributesType").getGenericType(), null, elementAttributes));
            final WriteConcern _transformedWriteConcern = ((WriteConcern) evaluateAndTransform(getMuleContext(), event, InsertObjectFromMapMessageProcessor.class.getDeclaredField("_writeConcernType").getGenericType(), null, writeConcern));
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
                                                            return ((MongoCloudConnector) object).insertObjectFromMap(_transformedCollection, _transformedElementAttributes, _transformedWriteConcern);
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
