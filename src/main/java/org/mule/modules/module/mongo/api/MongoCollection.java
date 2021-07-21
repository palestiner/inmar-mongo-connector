/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 * <p>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.module.mongo.api;

import com.mongodb.DBObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MongoCollection extends AbstractCollection<DBObject> {
    private static final Logger logger = LoggerFactory.getLogger(MongoCollection.class);
    private Iterable<? extends DBObject> o;

    public MongoCollection(Iterable<? extends DBObject> o) {
        this.o = o;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<DBObject> iterator() {
        return (Iterator<DBObject>) o.iterator();
    }

    @Override
    public Object[] toArray() {
        warnEagerMessage("toArray");
        List<Object> l = new LinkedList<Object>(this);
        return l.toArray();
    }

    @Override
    public int size() {
        warnEagerMessage("size");
        int i = 0;
        for (DBObject dbObject : o) {
            i++;
        }
        return i;
    }

    /**
     * Same impl that those found in Object, in order to avoid eager elements
     * consumption
     */
    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    /**
     * Warns that sending the given message implied processing all the elements,
     * which is not efficient at all, and most times is a bad idea, as lazy iterables
     * should be traversed only once and in a lazy manner.
     *
     * @param message
     */
    private void warnEagerMessage(String message) {
        if (logger.isWarnEnabled()) {
            logger.warn(
                    "Method {} needs to consume all the element. It is inefficient and thus should be used with care",
                    message);
        }
    }

}
