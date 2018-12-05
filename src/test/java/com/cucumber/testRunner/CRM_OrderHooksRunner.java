package com.cucumber.testRunner;

import java.io.File;

import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/com/cucumber/features/CRM_OrderHooks.feature",
                 glue= {"com/cucumber/setpDefinations"},
                 dryRun=false,
                 monochrome=true,
                // tags= {"@SmokeTest,@RegressionTest,@End2EndTest"}, 
                 plugin= {"pretty:cucumberreports/cucumber-pretty.txt",
                		 "html:cucumberreports/cucumber-html-report" ,
                		 "json:cucumberreports/cucumber-json-report/cucumber.json",
                		 "junit:cucumberreports/cucuber-junit-xml/junit.xml",
                		 "usage:cucumberreports/cucumber-usage-report/usage.json",
                		 "com.cucumber.listener.ExtentCucumberFormatter:cucumberreports/extentReport_OrderHooks.html"
                		})

     //OR -->tags= {"@SmokeTest,@RegressionTest,@End2EndTest"}, --> Executes All the Test Cases with that tags
     //And -->tags= {"@SmokeTest","@RegressionTest","@End2EndTest"}, --> Executes only combination of these tags
    /*The very important thing to note here is:
       @Before(order = int) : This runs in increment order, means value 0 would run first and 1 would be after 0.
       @After(order = int) : This runs in decrements order, means apposite of @Before. Value 1 would run first and 0 would be after 1.
       */
public class CRM_OrderHooksRunner extends AbstractTestNGCucumberTests{

	@AfterClass
	 public static void reportSetUp() {
		
    // Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	 Reporter.loadXMLConfig(new File("src/test/java/com/cucumber/features/extent-config.xml"));
	 Reporter.setSystemInfo("UserName", System.getProperty("user.name"));
	 Reporter.setSystemInfo("ProjectName", "CRM");
	 Reporter.setSystemInfo("Selenium", "3.14.0");
	 Reporter.setSystemInfo("Maven", "3.3.9");
	 Reporter.setSystemInfo("Java Version", "1.8.0_191");
	 }
	
}
