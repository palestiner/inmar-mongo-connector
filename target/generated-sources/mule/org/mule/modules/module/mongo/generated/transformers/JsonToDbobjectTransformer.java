
package org.mule.modules.module.mongo.generated.transformers;

import com.mongodb.DBObject;
import java.lang.reflect.Method;
import javax.annotation.Generated;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.module.mongo.MongoCloudConnector;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2021-06-09T06:46:06+07:00", comments = "Build UNNAMED.2810.4347dd1")
public class JsonToDbobjectTransformer
    extends AbstractTransformer
    implements DiscoverableTransformer
{

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
        throws TransformerException
    {
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
