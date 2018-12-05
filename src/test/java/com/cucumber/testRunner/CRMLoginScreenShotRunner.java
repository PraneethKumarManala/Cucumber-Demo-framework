package com.cucumber.testRunner;

import java.io.File;

import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import managers.FileReaderManager;

@CucumberOptions(features="src/test/java/com/cucumber/features/CRMLoginScreenShot.feature",
                 glue= {"com/cucumber/setpDefinations"},
                 dryRun=false,
                 monochrome=true,
                 plugin= {"pretty:cucumberreports/cucumber-pretty.txt",
                		 "html:cucumberreports/cucumber-html-report" ,
                		 "json:cucumberreports/cucumber-json-report/cucumber.json",
                		 "junit:cucumberreports/cucuber-junit-xml/junit.xml",
                		 "usage:cucumberreports/cucumber-usage-report/usage.json",
                		 "com.cucumber.listener.ExtentCucumberFormatter:cucumberreports/extentReport.html"})

public class CRMLoginScreenShotRunner extends AbstractTestNGCucumberTests{

	//5419190402882891 11/23 514
	
    @AfterClass
	 public static void reportSetUp() {
		
     // Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	 Reporter.loadXMLConfig(new File("extent-config.xml"));
	 Reporter.setSystemInfo("UserName", System.getProperty("user.name"));
	 Reporter.setSystemInfo("ProjectName", "CRM");
	 Reporter.setSystemInfo("Selenium", "3.14.0");
	 Reporter.setSystemInfo("Maven", "3.3.9");
	 Reporter.setSystemInfo("Java Version", "1.8.0_191");
	
    }
	
}
