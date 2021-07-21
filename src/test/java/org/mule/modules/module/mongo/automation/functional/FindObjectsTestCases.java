package org.mule.modules.module.mongo.automation.functional;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.modules.module.mongo.MongoCloudConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class FindObjectsTestCases extends AbstractTestCase<MongoCloudConnector> {

	public FindObjectsTestCases() {
		super(MongoCloudConnector.class);
	}

	@Before
	public void setup() {
		// TODO
	}

	@After
	public void tearDown() {
		// TODO
	}

	@Test
	public void verify() {
		java.lang.Iterable<com.mongodb.DBObject> expected = null;
		java.lang.String collection = null;
		com.mongodb.DBObject query = null;
		java.util.List<java.lang.String> fields = null;
		java.lang.Integer numToSkip = null;
		java.lang.Integer limit = null;
		com.mongodb.DBObject sortBy = null;
		assertEquals(getConnector().findObjects(collection, query, fields, numToSkip, limit, sortBy), expected);
	}

}