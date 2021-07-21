
package org.mule.modules.module.mongo.generated.connectivity;

import javax.annotation.Generated;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionKey;


/**
 * A tuple of connection parameters
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2021-06-09T06:46:06+07:00", comments = "Build UNNAMED.2810.4347dd1")
public class MongoCloudConnectorConnectionKey implements ConnectionManagementConnectionKey
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

    public MongoCloudConnectorConnectionKey(String username, String password, String database) {
        this.username = username;
        this.password = password;
        this.database = database;
    }

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

    @Override
    public int hashCode() {
        int result = ((this.username!= null)?this.username.hashCode(): 0);
        result = ((31 *result)+((this.database!= null)?this.database.hashCode(): 0));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MongoCloudConnectorConnectionKey)) {
            return false;
        }
        MongoCloudConnectorConnectionKey that = ((MongoCloudConnectorConnectionKey) o);
        if (((this.username!= null)?(!this.username.equals(that.username)):(that.username!= null))) {
            return false;
        }
        if (((this.database!= null)?(!this.database.equals(that.database)):(that.database!= null))) {
            return false;
        }
        return true;
    }

}
