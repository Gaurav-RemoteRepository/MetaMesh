package com.stepdefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "com.stepdefinitions", plugin = { "pretty",
		"html:target/cucumber-reports" })
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
