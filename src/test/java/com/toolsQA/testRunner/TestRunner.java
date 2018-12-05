package com.toolsQA.testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "/Users/pmanala/workspace_New/automation-cucumber-demo/src/test/resources/functionalTests_FeatureFiles",
				glue= {"com/toolsQA/stepDefinations"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {
}
