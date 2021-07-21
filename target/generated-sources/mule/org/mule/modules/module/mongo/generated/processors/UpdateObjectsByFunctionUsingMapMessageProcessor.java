
package org.mule.modules.module.mongo.generated.processors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.config.ConfigurationException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.registry.RegistrationException;
import org.mule.common.DefaultResult;
import org.mule.common.FailureType;
import org.mule.common.Result;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultMetaDataKey;
import org.mule.common.metadata.DefaultPojoMetaDataModel;
import org.mule.common.metadata.DefaultSimpleMetaDataModel;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.OperationMetaDataEnabled;
import org.mule.common.metadata.datatype.DataType;
import org.mule.common.metadata.datatype.DataTypeFactory;
import org.mule.devkit.internal.metadata.fixes.STUDIO7157;
import org.mule.modules.module.mongo.MongoCloudConnector;
import org.mule.modules.module.mongo.api.WriteConcern;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * UpdateObjectsByFunctionUsingMapMessageProcessor invokes the {@link org.mule.modules.module.mongo.MongoCloudConnector#updateObjectsByFunctionUsingMap(java.lang.String, java.lang.String, java.util.Map, java.util.Map, boolean, boolean, org.mule.modules.module.mongo.api.WriteConcern)} method in {@link MongoCloudConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2021-06-09T06:46:06+07:00", comments = "Build UNNAMED.2810.4347dd1")
public class UpdateObjectsByFunctionUsingMapMessageProcessor
    extends AbstractConnectedProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object collection;
    protected String _collectionType;
    protected Object function;
    protected String _functionType;
    protected Object queryAttributes;
    protected Map<String, Object> _queryAttributesType;
    protected Object elementAttributes;
    protected Map<String, Object> _elementAttributesType;
    protected Object upsert;
    protected boolean _upsertType;
    protected Object multi;
    protected boolean _multiType;
    protected Object writeConcern;
    protected WriteConcern _writeConcernType;

    public UpdateObjectsByFunctionUsingMapMessageProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    @Override
    public void start()
        throws MuleException
    {
        super.start();
    }

    @Override
    public void stop()
        throws MuleException
    {
        super.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
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
     * Sets elementAttributes
     * 
     * @param value Value to set
     */
    public void setElementAttributes(Object value) {
        this.elementAttributes = value;
    }

    /**
     * Sets function
     * 
     * @param value Value to set
     */
    public void setFunction(Object value) {
        this.function = value;
    }

    /**
     * Sets upsert
     * 
     * @param value Value to set
     */
    public void setUpsert(Object value) {
        this.upsert = value;
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
     * Sets multi
     * 
     * @param value Value to set
     */
    public void setMulti(Object value) {
        this.multi = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws Exception
     */
    public MuleEvent doProcess(final MuleEvent event)
        throws Exception
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(null, false, event);
            final String _transformedCollection = ((String) evaluateAndTransform(getMuleContext(), event, UpdateObjectsByFunctionUsingMapMessageProcessor.class.getDeclaredField("_collectionType").getGenericType(), null, collection));
            final String _transformedFunction = ((String) evaluateAndTransform(getMuleContext(), event, UpdateObjectsByFunctionUsingMapMessageProcessor.class.getDeclaredField("_functionType").getGenericType(), null, function));
            final Map<String, Object> _transformedQueryAttributes = ((Map<String, Object> ) evaluateAndTransform(getMuleContext(), event, UpdateObjectsByFunctionUsingMapMessageProcessor.class.getDeclaredField("_queryAttributesType").getGenericType(), null, queryAttributes));
            final Map<String, Object> _transformedElementAttributes = ((Map<String, Object> ) evaluateAndTransform(getMuleContext(), event, UpdateObjectsByFunctionUsingMapMessageProcessor.class.getDeclaredField("_elementAttributesType").getGenericType(), null, elementAttributes));
            final Boolean _transformedUpsert = ((Boolean) evaluateAndTransform(getMuleContext(), event, UpdateObjectsByFunctionUsingMapMessageProcessor.class.getDeclaredField("_upsertType").getGenericType(), null, upsert));
            final Boolean _transformedMulti = ((Boolean) evaluateAndTransform(getMuleContext(), event, UpdateObjectsByFunctionUsingMapMessageProcessor.class.getDeclaredField("_multiType").getGenericType(), null, multi));
            final WriteConcern _transformedWriteConcern = ((WriteConcern) evaluateAndTransform(getMuleContext(), event, UpdateObjectsByFunctionUsingMapMessageProcessor.class.getDeclaredField("_writeConcernType").getGenericType(), null, writeConcern));
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class<? extends Exception>> getManagedExceptions() {
                    return Arrays.asList(((Class<? extends Exception> []) new Class[] {IllegalStateException.class }));
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    ((MongoCloudConnector) object).updateObjectsByFunctionUsingMap(_transformedCollection, _transformedFunction, _transformedQueryAttributes, _transformedElementAttributes, _transformedUpsert, _transformedMulti, _transformedWriteConcern);
                    return null;
                }

            }
            , this, event);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        return new DefaultResult<MetaData>(null, (Result.Status.SUCCESS));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        MetaDataModel metaDataPayload = getPojoOrSimpleModel(void.class);
        DefaultMetaDataKey keyForStudio = new DefaultMetaDataKey("OUTPUT_METADATA", null);
        metaDataPayload.addProperty(STUDIO7157 .getStructureIdentifierMetaDataModelProperty(keyForStudio, false, false));
        return new DefaultResult<MetaData>(new DefaultMetaData(metaDataPayload));
    }

    private MetaDataModel getPojoOrSimpleModel(Class clazz) {
        DataType dataType = DataTypeFactory.getInstance().getDataType(clazz);
        if (DataType.POJO.equals(dataType)) {
            return new DefaultPojoMetaDataModel(clazz);
        } else {
            return new DefaultSimpleMetaDataModel(dataType);
        }
    }

    public Result<MetaData> getGenericMetaData(MetaDataKey metaDataKey) {
        ConnectorMetaDataEnabled connector;
        try {
            connector = ((ConnectorMetaDataEnabled) findOrCreate(null, false, null));
            try {
                Result<MetaData> metadata = connector.getMetaData(metaDataKey);
                if ((Result.Status.FAILURE).equals(metadata.getStatus())) {
                    return metadata;
                }
                if (metadata.get() == null) {
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at MongoCloudConnector at updateObjectsByFunctionUsingMap retrieving was successful but result is null");
                }
                return metadata;
            } catch (Exception e) {
                return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
            }
        } catch (ClassCastException cast) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error getting metadata, there was no connection manager available. Maybe you're trying to use metadata from an Oauth connector");
        } catch (ConfigurationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (RegistrationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (IllegalAccessException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (InstantiationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (Exception e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        }
    }

}
