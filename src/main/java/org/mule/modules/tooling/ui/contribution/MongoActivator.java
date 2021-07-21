
package org.mule.modules.tooling.ui.contribution;

import javax.annotation.Generated;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


/**
 * The activator class controls the plug-in life cycle
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class MongoActivator
        extends AbstractUIPlugin {

    public final static String PLUGIN_ID = "org.mule.tooling.ui.contribution.mongo";
    private static MongoActivator plugin;

    public void start(BundleContext context)
            throws Exception {
        super.start(context);
        plugin = this;
    }

    public void stop(BundleContext context)
            throws Exception {
        plugin = null;
        super.stop(context);
    }

    public static MongoActivator getDefault() {
        return plugin;
    }

}
