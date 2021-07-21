
package org.mule.modules.module.mongo.transformers;

import java.lang.reflect.Method;
import javax.annotation.Generated;

import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.module.mongo.MongoCloudConnector;
import org.mule.modules.module.mongo.api.MongoCollection;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class MongoCollectionToJsonTransformer
        extends AbstractTransformer
        implements DiscoverableTransformer {

    private int weighting = (DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING + 5);

    public MongoCollectionToJsonTransformer() {
        registerSourceType(DataTypeFactory.create(MongoCollection.class));
        try {
            Method method = MongoCloudConnector.class.getMethod("mongoCollectionToJson", MongoCollection.class);
            DataType dataType = DataTypeFactory.createFromReturnType(method);
            setReturnDataType(dataType);
        } catch (NoSuchMethodException _x) {
            throw new RuntimeException("Unable to find method mongoCollectionToJson");
        }
        setName("MongoCollectionToJsonTransformer");
    }

    protected Object doTransform(Object src, String encoding)
            throws TransformerException {
        String result = null;
        try {
            result = MongoCloudConnector.mongoCollectionToJson(((MongoCollection) src));
        } catch (Exception exception) {
            throw new TransformerException(CoreMessages.transformFailed(src.getClass().getName(), "java.lang.String"), this, exception);
        }
        return result;
    }

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

}
