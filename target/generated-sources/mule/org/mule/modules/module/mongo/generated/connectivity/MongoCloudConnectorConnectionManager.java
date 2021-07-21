
package org.mule.modules.module.mongo.generated.connectivity;

import javax.annotation.Generated;
import org.apache.commons.pool.KeyedObjectPool;
import org.mule.api.MetadataAware;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.config.MuleProperties;
import org.mule.api.context.MuleContextAware;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.retry.RetryPolicyTemplate;
import org.mule.common.DefaultTestResult;
import org.mule.common.TestResult;
import org.mule.common.Testable;
import org.mule.config.PoolingProfile;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionAdapter;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionManager;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectorAdapter;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectorFactory;
import org.mule.devkit.internal.connection.management.ConnectionManagementProcessTemplate;
import org.mule.devkit.internal.connection.management.UnableToAcquireConnectionException;
import org.mule.devkit.internal.connectivity.ConnectivityTestingErrorHandler;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.modules.module.mongo.MongoCloudConnector;
import org.mule.modules.module.mongo.generated.pooling.DevkitGenericKeyedObjectPool;
import org.mule.modules.module.mongo.generated.processors.ConnectivityProcessor;


/**
 * A {@code MongoCloudConnectorConnectionManager} is a wrapper around {@link MongoCloudConnector } that adds connection management capabilities to the pojo.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2021-06-09T06:46:06+07:00", comments = "Build UNNAMED.2810.4347dd1")
public class MongoCloudConnectorConnectionManager
    extends ExpressionEvaluatorSupport
    implements MetadataAware, MuleContextAware, ProcessAdapter<MongoCloudConnectorAdapter> , Capabilities, Disposable, Initialisable, Testable, ConnectionManagementConnectionManager<MongoCloudConnectorConnectionKey, MongoCloudConnectorAdapter, Object>
{

    /**
     * 
     */
    private String username;
    /**
     * 
     */
    private String password;
    /**
     * 
     */
    private String database;
    private String host;
    private int port;
    private Integer connectionsPerHost;
    private Integer threadsAllowedToBlockForConnectionMultiplier;
    private Integer maxWaitTime;
    private Integer connectTimeout;
    private Integer socketTimeout;
    private Boolean autoConnectRetry;
    /**
     * Mule Context
     * 
     */
    protected MuleContext muleContext;
    /**
     * Connector Pool
     * 
     */
    private KeyedObjectPool connectionPool;
    protected PoolingProfile poolingProfile;
    protected RetryPolicyTemplate retryPolicyTemplate;
    private final static String MODULE_NAME = "Mongo DB";
    private final static String MODULE_VERSION = "1.0.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.9.4";
    private final static String DEVKIT_BUILD = "UNNAMED.2810.4347dd1";
    private final static String MIN_MULE_VERSION = "3.5";

    /**
     * Sets password
     * 
     * @param value Value to set
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Retrieves password
     * 
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets database
     * 
     * @param value Value to set
     */
    public void setDatabase(String value) {
        this.database = value;
    }

    /**
     * Retrieves database
     * 
     */
    public String getDatabase() {
        return this.database;
    }

    /**
     * Sets username
     * 
     * @param value Value to set
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Retrieves username
     * 
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets host
     * 
     * @param value Value to set
     */
    public void setHost(String value) {
        this.host = value;
    }

    /**
     * Retrieves host
     * 
     */
    public String getHost() {
        return this.host;
    }

    /**
     * Sets port
     * 
     * @param value Value to set
     */
    public void setPort(int value) {
        this.port = value;
    }

    /**
     * Retrieves port
     * 
     */
    public int getPort() {
        return this.port;
    }

    /**
     * Sets connectionsPerHost
     * 
     * @param value Value to set
     */
    public void setConnectionsPerHost(Integer value) {
        this.connectionsPerHost = value;
    }

    /**
     * Retrieves connectionsPerHost
     * 
     */
    public Integer getConnectionsPerHost() {
        return this.connectionsPerHost;
    }

    /**
     * Sets threadsAllowedToBlockForConnectionMultiplier
     * 
     * @param value Value to set
     */
    public void setThreadsAllowedToBlockForConnectionMultiplier(Integer value) {
        this.threadsAllowedToBlockForConnectionMultiplier = value;
    }

    /**
     * Retrieves threadsAllowedToBlockForConnectionMultiplier
     * 
     */
    public Integer getThreadsAllowedToBlockForConnectionMultiplier() {
        return this.threadsAllowedToBlockForConnectionMultiplier;
    }

    /**
     * Sets maxWaitTime
     * 
     * @param value Value to set
     */
    public void setMaxWaitTime(Integer value) {
        this.maxWaitTime = value;
    }

    /**
     * Retrieves maxWaitTime
     * 
     */
    public Integer getMaxWaitTime() {
        return this.maxWaitTime;
    }

    /**
     * Sets connectTimeout
     * 
     * @param value Value to set
     */
    public void setConnectTimeout(Integer value) {
        this.connectTimeout = value;
    }

    /**
     * Retrieves connectTimeout
     * 
     */
    public Integer getConnectTimeout() {
        return this.connectTimeout;
    }

    /**
     * Sets socketTimeout
     * 
     * @param value Value to set
     */
    public void setSocketTimeout(Integer value) {
        this.socketTimeout = value;
    }

    /**
     * Retrieves socketTimeout
     * 
     */
    public Integer getSocketTimeout() {
        return this.socketTimeout;
    }

    /**
     * Sets autoConnectRetry
     * 
     * @param value Value to set
     */
    public void setAutoConnectRetry(Boolean value) {
        this.autoConnectRetry = value;
    }

    /**
     * Retrieves autoConnectRetry
     * 
     */
    public Boolean getAutoConnectRetry() {
        return this.autoConnectRetry;
    }

    /**
     * Sets muleContext
     * 
     * @param value Value to set
     */
    public void setMuleContext(MuleContext value) {
        this.muleContext = value;
    }

    /**
     * Retrieves muleContext
     * 
     */
    public MuleContext getMuleContext() {
        return this.muleContext;
    }

    /**
     * Sets poolingProfile
     * 
     * @param value Value to set
     */
    public void setPoolingProfile(PoolingProfile value) {
        this.poolingProfile = value;
    }

    /**
     * Retrieves poolingProfile
     * 
     */
    public PoolingProfile getPoolingProfile() {
        return this.poolingProfile;
    }

    /**
     * Sets retryPolicyTemplate
     * 
     * @param value Value to set
     */
    public void setRetryPolicyTemplate(RetryPolicyTemplate value) {
        this.retryPolicyTemplate = value;
    }

    /**
     * Retrieves retryPolicyTemplate
     * 
     */
    public RetryPolicyTemplate getRetryPolicyTemplate() {
        return this.retryPolicyTemplate;
    }

    public void initialise() {
        connectionPool = new DevkitGenericKeyedObjectPool(new ConnectionManagementConnectorFactory(this), poolingProfile);
        if (retryPolicyTemplate == null) {
            retryPolicyTemplate = muleContext.getRegistry().lookupObject(MuleProperties.OBJECT_DEFAULT_RETRY_POLICY_TEMPLATE);
        }
    }

    @Override
    public void dispose() {
        try {
            connectionPool.close();
        } catch (Exception e) {
        }
    }

    public MongoCloudConnectorAdapter acquireConnection(MongoCloudConnectorConnectionKey key)
        throws Exception
    {
        return ((MongoCloudConnectorAdapter) connectionPool.borrowObject(key));
    }

    public void releaseConnection(MongoCloudConnectorConnectionKey key, MongoCloudConnectorAdapter connection)
        throws Exception
    {
        connectionPool.returnObject(key, connection);
    }

    public void destroyConnection(MongoCloudConnectorConnectionKey key, MongoCloudConnectorAdapter connection)
        throws Exception
    {
        connectionPool.invalidateObject(key, connection);
    }

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

    @Override
    public<P >ProcessTemplate<P, MongoCloudConnectorAdapter> getProcessTemplate() {
        return new ConnectionManagementProcessTemplate(this, muleContext);
    }

    @Override
    public MongoCloudConnectorConnectionKey getDefaultConnectionKey() {
        return new MongoCloudConnectorConnectionKey(getUsername(), getPassword(), getDatabase());
    }

    @Override
    public MongoCloudConnectorConnectionKey getEvaluatedConnectionKey(MuleEvent event)
        throws Exception
    {
        if (event!= null) {
            final String _transformedUsername = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("username").getGenericType(), null, getUsername()));
            if (_transformedUsername == null) {
                throw new UnableToAcquireConnectionException("Parameter username in method connect can't be null because is not @Optional");
            }
            final String _transformedPassword = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("password").getGenericType(), null, getPassword()));
            final String _transformedDatabase = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("database").getGenericType(), null, getDatabase()));
            if (_transformedDatabase == null) {
                throw new UnableToAcquireConnectionException("Parameter database in method connect can't be null because is not @Optional");
            }
            return new MongoCloudConnectorConnectionKey(_transformedUsername, _transformedPassword, _transformedDatabase);
        }
        return getDefaultConnectionKey();
    }

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

    @Override
    public MongoCloudConnectorConnectionKey getConnectionKey(MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
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
            return new MongoCloudConnectorConnectionKey(_transformedUsername, _transformedPassword, _transformedDatabase);
        } else {
            return getEvaluatedConnectionKey(event);
        }
    }

    /**
     * Validates that the current message processor has changed any of its connection parameters at processor level. If so, a new MongoCloudConnectorConnectionKey must be generated
     * 
     * @param messageProcessor
     *     the message processor to test against the keys
     * @return
     *     true if any of the parameters in @Connect method annotated with @ConnectionKey was override in the XML, false otherwise  
     */
    private Boolean hasConnectionKeysOverride(MessageProcessor messageProcessor) {
        if ((messageProcessor == null)||(!(messageProcessor instanceof ConnectivityProcessor))) {
            return false;
        }
        ConnectivityProcessor connectivityProcessor = ((ConnectivityProcessor) messageProcessor);
        if (connectivityProcessor.getUsername()!= null) {
            return true;
        }
        if (connectivityProcessor.getDatabase()!= null) {
            return true;
        }
        return false;
    }

    @Override
    public ConnectionManagementConnectionAdapter newConnection() {
        MongoCloudConnectorAdapter connector = new MongoCloudConnectorAdapter();
        connector.setPort(getPort());
        connector.setMaxWaitTime(getMaxWaitTime());
        connector.setConnectionsPerHost(getConnectionsPerHost());
        connector.setSocketTimeout(getSocketTimeout());
        connector.setAutoConnectRetry(getAutoConnectRetry());
        connector.setHost(getHost());
        connector.setConnectTimeout(getConnectTimeout());
        connector.setThreadsAllowedToBlockForConnectionMultiplier(getThreadsAllowedToBlockForConnectionMultiplier());
        return connector;
    }

    @Override
    public ConnectionManagementConnectorAdapter newConnector(ConnectionManagementConnectionAdapter<Object, MongoCloudConnectorConnectionKey> connection) {
        return ((ConnectionManagementConnectorAdapter) connection);
    }

    public ConnectionManagementConnectionAdapter getConnectionAdapter(ConnectionManagementConnectorAdapter adapter) {
        return ((ConnectionManagementConnectionAdapter) adapter);
    }

    public TestResult test() {
        MongoCloudConnectorAdapter connection = null;
        DefaultTestResult result;
        MongoCloudConnectorConnectionKey key = getDefaultConnectionKey();
        try {
            connection = acquireConnection(key);
            result = new DefaultTestResult(org.mule.common.Result.Status.SUCCESS);
        } catch (Exception e) {
            try {
                destroyConnection(key, connection);
            } catch (Exception ie) {
            }
            result = ((DefaultTestResult) ConnectivityTestingErrorHandler.buildFailureTestResult(e));
        } finally {
            if (connection!= null) {
                try {
                    releaseConnection(key, connection);
                } catch (Exception ie) {
                }
            }
        }
        return result;
    }

}
