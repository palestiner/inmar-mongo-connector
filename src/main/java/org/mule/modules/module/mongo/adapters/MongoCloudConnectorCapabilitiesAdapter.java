
package org.mule.modules.module.mongo.adapters;

import javax.annotation.Generated;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.modules.module.mongo.MongoCloudConnector;


/**
 * A <code>MongoCloudConnectorCapabilitiesAdapter</code> is a wrapper around {@link MongoCloudConnector } that implements {@link org.mule.api.Capabilities} interface.
 *
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class MongoCloudConnectorCapabilitiesAdapter
    extends MongoCloudConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     *
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == ModuleCapability.CONNECTION_MANAGEMENT_CAPABLE) {
            return true;
        }
        return false;
    }

}
