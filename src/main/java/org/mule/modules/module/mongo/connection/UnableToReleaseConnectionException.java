
package org.mule.modules.module.mongo.connection;

import javax.annotation.Generated;


/**
 * Exception thrown when the release connection operation of the
 * connection manager fails.
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2015-02-27T11:35:16-03:00", comments = "Build UNNAMED.2039.0541b23")
public class UnableToReleaseConnectionException
        extends Exception {

    /**
     * Create a new exception
     *
     * @param throwable Inner exception
     */
    public UnableToReleaseConnectionException(Throwable throwable) {
        super(throwable);
    }
}
