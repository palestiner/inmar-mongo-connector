
package org.mule.modules.module.mongo.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MetadataAware;
import org.mule.modules.module.mongo.MongoCloudConnector;


/**
 * A <code>MongoCloudConnectorMetadataAdapter</code> is a wrapper around {@link MongoCloudConnector } that adds support for querying metadata about the extension.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2021-06-09T06:46:06+07:00", comments = "Build UNNAMED.2810.4347dd1")
public class MongoCloudConnectorMetadataAdapter
    extends MongoCloudConnectorCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "Mongo DB";
    private final static String MODULE_VERSION = "1.0.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.9.4";
    private final static String DEVKIT_BUILD = "UNNAMED.2810.4347dd1";
    private final static String MIN_MULE_VERSION = "3.5";

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

    public String getMinMuleVersion() {
        return MIN_MULE_VERSION;
    }

}
