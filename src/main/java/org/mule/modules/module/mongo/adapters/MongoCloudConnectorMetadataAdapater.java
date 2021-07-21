
package org.mule.modules.module.mongo.adapters;

import javax.annotation.Generated;
import org.mule.api.MetadataAware;
import org.mule.modules.module.mongo.MongoCloudConnector;


/**
 * A <code>MongoCloudConnectorMetadataAdapater</code> is a wrapper around {@link MongoCloudConnector } that adds support for querying metadata about the extension.
 *
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class MongoCloudConnectorMetadataAdapater
    extends MongoCloudConnectorCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "Mongo DB";
    private final static String MODULE_VERSION = "3.6.1";
    private final static String DEVKIT_VERSION = "3.5.2";
    private final static String DEVKIT_BUILD = "UNNAMED.2039.0541b23";
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
