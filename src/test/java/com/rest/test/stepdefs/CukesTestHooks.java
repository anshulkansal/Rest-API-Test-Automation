package com.rest.test.stepdefs;

import java.io.IOException;
import java.util.Properties;

import org.assertj.core.api.BDDSoftAssertions;
import org.junit.Rule;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import junit.framework.Assert;

public class CukesTestHooks {
	public static final Properties PROPERTIES = new Properties();
	public static final String ENDPOINT = "endpoint";
	
	@Rule
	public static BDDSoftAssertions soft = new BDDSoftAssertions();
	
	static {
		try {
			PROPERTIES.load(CukesTestHooks.class.getClassLoader().getResourceAsStream("test.properties"));
			
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Before
	public void setUpEnvironment(Scenario scenario) throws Exception {
		RestUtil.endPointUrl = PROPERTIES.getProperty(ENDPOINT);
		
	}
	

}
