
package org.mule.modules.module.mongo.processors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
 * FindObjectsUsingQueryMapMessageProcessor invokes the {@link MongoCloudConnector#findObjectsUsingQueryMap(java.lang.String, java.util.Map, java.util.List, java.lang.Integer, java.lang.Integer, com.mongodb.DBObject)} method in {@link MongoCloudConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class FindObjectsUsingQueryMapMessageProcessor
        extends AbstractConnectedProcessor
        implements MessageProcessor {

    protected Object collection;
    protected String _collectionType;
    protected Object queryAttributes;
    protected Map<String, Object> _queryAttributesType;
    protected Object fields;
    protected List<String> _fieldsType;
    protected Object numToSkip;
    protected Integer _numToSkipType;
    protected Object limit;
    protected Integer _limitType;
    protected Object sortBy;
    protected DBObject _sortByType;

    public FindObjectsUsingQueryMapMessageProcessor(String operationName) {
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
     * Sets limit
     *
     * @param value Value to set
     */
    public void setLimit(Object value) {
        this.limit = value;
    }

    /**
     * Sets sortBy
     *
     * @param value Value to set
     */
    public void setSortBy(Object value) {
        this.sortBy = value;
    }

    /**
     * Sets numToSkip
     *
     * @param value Value to set
     */
    public void setNumToSkip(Object value) {
        this.numToSkip = value;
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
     * Sets fields
     *
     * @param value Value to set
     */
    public void setFields(Object value) {
        this.fields = value;
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
            final String _transformedCollection = ((String) evaluateAndTransform(getMuleContext(), event, FindObjectsUsingQueryMapMessageProcessor.class.getDeclaredField("_collectionType").getGenericType(), null, collection));
            final Map<String, Object> _transformedQueryAttributes = ((Map<String, Object>) evaluateAndTransform(getMuleContext(), event, FindObjectsUsingQueryMapMessageProcessor.class.getDeclaredField("_queryAttributesType").getGenericType(), null, queryAttributes));
            final List<String> _transformedFields = ((List<String>) evaluateAndTransform(getMuleContext(), event, FindObjectsUsingQueryMapMessageProcessor.class.getDeclaredField("_fieldsType").getGenericType(), null, fields));
            final Integer _transformedNumToSkip = ((Integer) evaluateAndTransform(getMuleContext(), event, FindObjectsUsingQueryMapMessageProcessor.class.getDeclaredField("_numToSkipType").getGenericType(), null, numToSkip));
            final Integer _transformedLimit = ((Integer) evaluateAndTransform(getMuleContext(), event, FindObjectsUsingQueryMapMessageProcessor.class.getDeclaredField("_limitType").getGenericType(), null, limit));
            final DBObject _transformedSortBy = ((DBObject) evaluateAndTransform(getMuleContext(), event, FindObjectsUsingQueryMapMessageProcessor.class.getDeclaredField("_sortByType").getGenericType(), null, sortBy));
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
                                                            return ((MongoCloudConnector) object).findObjectsUsingQueryMap(_transformedCollection, _transformedQueryAttributes, _transformedFields, _transformedNumToSkip, _transformedLimit, _transformedSortBy);
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
