
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
 * AddUserMessageProcessor invokes the {@link MongoCloudConnector#addUser(java.lang.String, java.lang.String)} method in {@link MongoCloudConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class AddUserMessageProcessor
        extends AbstractConnectedProcessor
        implements MessageProcessor {

    protected Object newUsername;
    protected String _newUsernameType;
    protected Object newPassword;
    protected String _newPasswordType;

    public AddUserMessageProcessor(String operationName) {
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
     * Sets newUsername
     *
     * @param value Value to set
     */
    public void setNewUsername(Object value) {
        this.newUsername = value;
    }

    /**
     * Sets newPassword
     *
     * @param value Value to set
     */
    public void setNewPassword(Object value) {
        this.newPassword = value;
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
            final String _transformedNewUsername = ((String) evaluateAndTransform(getMuleContext(), event, AddUserMessageProcessor.class.getDeclaredField("_newUsernameType").getGenericType(), null, newUsername));
            final String _transformedNewPassword = ((String) evaluateAndTransform(getMuleContext(), event, AddUserMessageProcessor.class.getDeclaredField("_newPasswordType").getGenericType(), null, newPassword));
            Object resultPayload;
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object>) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(
                    new ProcessCallback<Object, Object>() {

                        @Override
                        public List<Class<? extends Exception>> getManagedExceptions() {
                            return Arrays.asList(((Class<? extends Exception>[]) new Class[]{IllegalStateException.class}));
                        }

                        @Override
                        public boolean isProtected() {
                            return false;
                        }

                        @Override
                        public Object process(Object object)
                                throws Exception {
                            ((MongoCloudConnector) object).addUser(_transformedNewUsername, _transformedNewPassword);
                            return ((MongoCloudConnector) object);
                        }

                    }, this, event);
            event.getMessage().setPayload(resultPayload);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

}
