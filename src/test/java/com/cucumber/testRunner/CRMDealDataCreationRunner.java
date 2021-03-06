package com.cucumber.testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features= "src/test/java/com/cucumber/features/dealMap.feature",
glue= {"com/cucumber/setpDefinations"},
dryRun=false,
monochrome=true,
plugin= {"pretty:cucumberreports/cucumber-pretty.txt",
		 "html:cucumberreports/cucumber-html-report" ,
		 "json:cucumberreports/cucumber-json-report/cucumber.json",
		 "junit:cucumberreports/cucuber-junit-xml/junit.xml",
		 "usage:cucumberreports/cucumber-usage-report/usage.json"})
public class CRMDealDataCreationRunner extends AbstractTestNGCucumberTests {

}
