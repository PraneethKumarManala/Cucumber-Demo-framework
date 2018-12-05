package com.cucumber.setpDefinations;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import com.cucumber.accelerators.ActionDrivers;
import com.cucumber.accelerators.Base;
import com.cucumber.definedMethods.CRMApplication;
import com.cucumber.factory.ComplexReportFactory;
import com.cucumber.listener.Reporter;
import com.mongodb.diagnostics.logging.Loggers;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CRMLoginFunctionality extends ActionDrivers {

	private static final Logger loger = Logger.getLogger(CRMLoginFunctionality.class.getName());
	    
	//WebDriver driver;
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
	/*@Before
	public void extentRepotLogger() {
		
		logger= ComplexReportFactory.getTest();	
		logger.assignCategory("CRM Login Functionality");
	
	}*/
	
	@Given("^Open the Browser and Enter URL$")
	public void open_the_Browser_and_Enter_URL() throws MalformedURLException {
	   
	  Base.setUp();
	  crm.enterURL();
	   
	}

	@Then("^Verify Title of Login Page$")
	public void Verify_Title_of_Login_Page() throws IOException {
		
		crm.compareTitle();
	   // takeScreenShotForINFO("Verify Login Page Title", "Comparing Title of Login Page", "", "", "", logger);
	}
	@When("^User enters Username and Password and Click on Login button$")
	public void user_enters_Username_and_Password_and_Click_on_Login_button() throws MalformedURLException, InterruptedException  {
	   
		crm.enterUnamePass();
		crm.clickLoginBtn();
	}

	
	
	@Then("^Verify Home Page$")
	public void verify_Home_Page() throws IOException  {
		
		 crm.homePage();
		// takeScreenShotForINFO("Verify Home Page Title", "Comparing Title of Home Page", "", "", "", loggers);
	}

	
	
}
