package com.rest.test.stepdefs;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {
				"pretty",
				"json:target/cucumber-reports/cucumber.json",
		        "html:target/cuc-html",
		}
		)

public class RunCukesTest {

}
