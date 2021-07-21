
package org.mule.modules.module.mongo.processors;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;

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
 * DumpMessageProcessor invokes the {@link MongoCloudConnector#dump(java.lang.String, java.lang.String, boolean, boolean, int)} method in {@link MongoCloudConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class DumpMessageProcessor
        extends AbstractConnectedProcessor
        implements MessageProcessor {

    protected Object outputDirectory;
    protected String _outputDirectoryType;
    protected Object outputName;
    protected String _outputNameType;
    protected Object zip;
    protected boolean _zipType;
    protected Object oplog;
    protected boolean _oplogType;
    protected Object threads;
    protected int _threadsType;

    public DumpMessageProcessor(String operationName) {
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
     * Sets zip
     *
     * @param value Value to set
     */
    public void setZip(Object value) {
        this.zip = value;
    }

    /**
     * Sets threads
     *
     * @param value Value to set
     */
    public void setThreads(Object value) {
        this.threads = value;
    }

    /**
     * Sets outputName
     *
     * @param value Value to set
     */
    public void setOutputName(Object value) {
        this.outputName = value;
    }

    /**
     * Sets oplog
     *
     * @param value Value to set
     */
    public void setOplog(Object value) {
        this.oplog = value;
    }

    /**
     * Sets outputDirectory
     *
     * @param value Value to set
     */
    public void setOutputDirectory(Object value) {
        this.outputDirectory = value;
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
            final String _transformedOutputDirectory = ((String) evaluateAndTransform(getMuleContext(), event, DumpMessageProcessor.class.getDeclaredField("_outputDirectoryType").getGenericType(), null, outputDirectory));
            final String _transformedOutputName = ((String) evaluateAndTransform(getMuleContext(), event, DumpMessageProcessor.class.getDeclaredField("_outputNameType").getGenericType(), null, outputName));
            final Boolean _transformedZip = ((Boolean) evaluateAndTransform(getMuleContext(), event, DumpMessageProcessor.class.getDeclaredField("_zipType").getGenericType(), null, zip));
            final Boolean _transformedOplog = ((Boolean) evaluateAndTransform(getMuleContext(), event, DumpMessageProcessor.class.getDeclaredField("_oplogType").getGenericType(), null, oplog));
            final Integer _transformedThreads = ((Integer) evaluateAndTransform(getMuleContext(), event, DumpMessageProcessor.class.getDeclaredField("_threadsType").getGenericType(), null, threads));
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object>) moduleObject).getProcessTemplate();
            processTemplate.execute(new ProcessCallback<Object, Object>() {


                                        public List<Class<? extends Exception>> getManagedExceptions() {
                                            return Arrays.asList(((Class<? extends Exception>[]) new Class[]{IllegalStateException.class}));
                                        }

                                        public boolean isProtected() {
                                            return false;
                                        }

                                        public Object process(Object object)
                                                throws Exception {
                                            ((MongoCloudConnector) object).dump(_transformedOutputDirectory, _transformedOutputName, _transformedZip, _transformedOplog, _transformedThreads);
                                            return null;
                                        }

                                    }
                    , this, event);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

}
