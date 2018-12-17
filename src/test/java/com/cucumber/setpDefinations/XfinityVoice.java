package com.cucumber.setpDefinations;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.cucumber.accelerators.Base;
import com.cucumber.definedMethods.CRMApplication;
import com.cucumber.factory.ComplexReportFactory;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class XfinityVoice {



private static final Logger loger = Logger.getLogger(XfinityVoice.class.getName());
    

	ExtentTest logger=ComplexReportFactory.getTest();	
	
	CRMApplication crm= new CRMApplication();
	
	
	@Before(order=1)
	public void log4Jexecution() {
		
		Base.log4J();
	
	}
	
	@After
	public void closeBrowser() {
		
		Base.tearDown();
	}
	

	@Before(order = 0)
	public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor("CharterGlobal - PraneethKumarManala");
	}
	
	@Given("^click on XFINITY Voice link$")
	public void click_on_XFINITY_Voice_link() {
		 
		  Base.setUp();
		  crm.enterURL();
		  crm.xfinityVoicelink();
		
	}

}
