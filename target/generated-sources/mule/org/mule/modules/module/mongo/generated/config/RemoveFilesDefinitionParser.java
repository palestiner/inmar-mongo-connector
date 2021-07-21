
package org.mule.modules.module.mongo.generated.config;

import javax.annotation.Generated;
import org.mule.common.MuleVersion;
import org.mule.config.MuleManifest;
import org.mule.modules.module.mongo.generated.processors.RemoveFilesMessageProcessor;
import org.mule.modules.module.mongo.generated.processors.RemoveFilesMessageProcessorDebuggable;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2021-06-09T06:46:06+07:00", comments = "Build UNNAMED.2810.4347dd1")
public class RemoveFilesDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(RemoveFilesDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            MuleVersion muleVersion = new MuleVersion(MuleManifest.getProductVersion());
            BeanDefinitionBuilder beanDefinitionBuilder;
            if (muleVersion.atLeastBase("3.8.0")) {
                beanDefinitionBuilder = beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(RemoveFilesMessageProcessorDebuggable.class.getName());
            } else {
                beanDefinitionBuilder = beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(RemoveFilesMessageProcessor.class.getName());
            }
            return beanDefinitionBuilder;
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [remove-files] within the connector [mongo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [remove-files] within the connector [mongo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("removeFiles");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [remove-files] within the connector [mongo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (hasAttribute(element, "query-ref")) {
            if (element.getAttribute("query-ref").startsWith("#")) {
                builder.addPropertyValue("query", element.getAttribute("query-ref"));
            } else {
                builder.addPropertyValue("query", (("#[registry:"+ element.getAttribute("query-ref"))+"]"));
            }
        }
        parseProperty(builder, element, "username", "username");
        parseProperty(builder, element, "password", "password");
        parseProperty(builder, element, "database", "database");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
