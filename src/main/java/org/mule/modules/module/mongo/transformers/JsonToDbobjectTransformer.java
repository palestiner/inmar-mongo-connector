
package org.mule.modules.module.mongo.transformers;

import java.lang.reflect.Method;
import javax.annotation.Generated;

import com.mongodb.DBObject;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.module.mongo.MongoCloudConnector;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class JsonToDbobjectTransformer
        extends AbstractTransformer
        implements DiscoverableTransformer {

    private int weighting = (DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING + 5);

    public JsonToDbobjectTransformer() {
        registerSourceType(DataTypeFactory.create(String.class));
        try {
            Method method = MongoCloudConnector.class.getMethod("jsonToDbobject", String.class);
            DataType dataType = DataTypeFactory.createFromReturnType(method);
            setReturnDataType(dataType);
        } catch (NoSuchMethodException _x) {
            throw new RuntimeException("Unable to find method jsonToDbobject");
        }
        setName("JsonToDbobjectTransformer");
    }

    protected Object doTransform(Object src, String encoding)
            throws TransformerException {
        DBObject result = null;
        try {
            result = MongoCloudConnector.jsonToDbobject(((String) src));
        } catch (Exception exception) {
            throw new TransformerException(CoreMessages.transformFailed(src.getClass().getName(), "com.mongodb.DBObject"), this, exception);
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
