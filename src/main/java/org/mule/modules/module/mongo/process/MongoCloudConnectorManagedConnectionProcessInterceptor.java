
package org.mule.modules.module.mongo.process;

import java.util.List;
import javax.annotation.Generated;

import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessInterceptor;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.modules.module.mongo.adapters.MongoCloudConnectorConnectionIdentifierAdapter;
import org.mule.modules.module.mongo.connection.ConnectionManager;
import org.mule.modules.module.mongo.connection.UnableToAcquireConnectionException;
import org.mule.modules.module.mongo.connection.UnableToReleaseConnectionException;
import org.mule.modules.module.mongo.connectivity.MongoCloudConnectorConnectionKey;
import org.mule.modules.module.mongo.processors.ConnectivityProcessor;
import org.mule.security.oauth.callback.ProcessCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class MongoCloudConnectorManagedConnectionProcessInterceptor<T>
        extends ExpressionEvaluatorSupport
        implements ProcessInterceptor<T, MongoCloudConnectorConnectionIdentifierAdapter> {

    private static Logger logger = LoggerFactory.getLogger(MongoCloudConnectorManagedConnectionProcessInterceptor.class);
    private final ConnectionManager<MongoCloudConnectorConnectionKey, MongoCloudConnectorConnectionIdentifierAdapter> connectionManager;
    private final MuleContext muleContext;
    private final ProcessInterceptor<T, MongoCloudConnectorConnectionIdentifierAdapter> next;

    public MongoCloudConnectorManagedConnectionProcessInterceptor(ProcessInterceptor<T, MongoCloudConnectorConnectionIdentifierAdapter> next, ConnectionManager<MongoCloudConnectorConnectionKey, MongoCloudConnectorConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        this.next = next;
        this.connectionManager = connectionManager;
        this.muleContext = muleContext;
    }

    @Override
    public T execute(ProcessCallback<T, MongoCloudConnectorConnectionIdentifierAdapter> processCallback, MongoCloudConnectorConnectionIdentifierAdapter object, MessageProcessor messageProcessor, MuleEvent event)
            throws Exception {
        MongoCloudConnectorConnectionIdentifierAdapter connection = null;
        MongoCloudConnectorConnectionKey key = null;
        if (hasConnectionKeysOverride(messageProcessor)) {
            ConnectivityProcessor connectivityProcessor = ((ConnectivityProcessor) messageProcessor);
            final String _transformedUsername = ((String) evaluateAndTransform(muleContext, event, connectivityProcessor.typeFor("_usernameType"), null, connectivityProcessor.getUsername()));
            if (_transformedUsername == null) {
                throw new UnableToAcquireConnectionException("Parameter username in method connect can't be null because is not @Optional");
            }
            final String _transformedPassword = ((String) evaluateAndTransform(muleContext, event, connectivityProcessor.typeFor("_passwordType"), null, connectivityProcessor.getPassword()));
            final String _transformedDatabase = ((String) evaluateAndTransform(muleContext, event, connectivityProcessor.typeFor("_databaseType"), null, connectivityProcessor.getDatabase()));
            if (_transformedDatabase == null) {
                throw new UnableToAcquireConnectionException("Parameter database in method connect can't be null because is not @Optional");
            }
            key = new MongoCloudConnectorConnectionKey(_transformedUsername, _transformedPassword, _transformedDatabase);
        } else {
            key = connectionManager.getEvaluatedConnectionKey(event);
        }
        try {
            if (logger.isDebugEnabled()) {
                logger.debug(("Attempting to acquire connection using " + key.toString()));
            }
            connection = connectionManager.acquireConnection(key);
            if (connection == null) {
                throw new UnableToAcquireConnectionException();
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug((("Connection has been acquired with [id=" + connection.getConnectionIdentifier()) + "]"));
                }
            }
            return next.execute(processCallback, connection, messageProcessor, event);
        } catch (Exception e) {
            if (processCallback.getManagedExceptions() != null) {
                for (Class exceptionClass : ((List<Class<? extends Exception>>) processCallback.getManagedExceptions())) {
                    if (exceptionClass.isInstance(e)) {
                        if (logger.isDebugEnabled()) {
                            logger.debug((((("An exception ( " + exceptionClass.getName()) + ") has been thrown. Destroying the connection with [id=") + connection.getConnectionIdentifier()) + "]"));
                        }
                        try {
                            if (connection != null) {
                                connectionManager.destroyConnection(key, connection);
                                connection = null;
                            }
                        } catch (Exception innerException) {
                            logger.error(innerException.getMessage(), innerException);
                        }
                    }
                }
            }
            throw e;
        } finally {
            try {
                if (connection != null) {
                    if (logger.isDebugEnabled()) {
                        logger.debug((("Releasing the connection back into the pool [id=" + connection.getConnectionIdentifier()) + "]"));
                    }
                    connectionManager.releaseConnection(key, connection);
                }
            } catch (Exception e) {
                throw new UnableToReleaseConnectionException(e);
            }
        }
    }

    /**
     * Validates that the current message processor has changed any of its connection parameters at processor level. If so, a new MongoCloudConnectorConnectionKey must be generated
     *
     * @param messageProcessor the message processor to test against the keys
     * @return true if any of the parameters in @Connect method annotated with @ConnectionKey was override in the XML, false otherwise
     */
    private Boolean hasConnectionKeysOverride(MessageProcessor messageProcessor) {
        if ((messageProcessor == null) || (!(messageProcessor instanceof ConnectivityProcessor))) {
            return false;
        }
        ConnectivityProcessor connectivityProcessor = ((ConnectivityProcessor) messageProcessor);
        if (connectivityProcessor.getUsername() != null) {
            return true;
        }
        if (connectivityProcessor.getDatabase() != null) {
            return true;
        }
        return false;
    }

    public T execute(ProcessCallback<T, MongoCloudConnectorConnectionIdentifierAdapter> processCallback, MongoCloudConnectorConnectionIdentifierAdapter object, Filter filter, MuleMessage message)
            throws Exception {
        throw new UnsupportedOperationException();
    }

}
