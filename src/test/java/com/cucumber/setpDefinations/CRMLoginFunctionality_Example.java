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
import com.mongodb.diagnostics.logging.Loggers;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CRMLoginFunctionality_Example extends ActionDrivers {

	private static final Logger loger = Logger.getLogger(CRMLoginFunctionality_Example.class.getName());
	    
	//WebDriver driver;
	
	ExtentTest logger;
	CRMApplication crm= new CRMApplication();
	
	@Before
	public void log4Jexecution() {
		
		Base.log4J();
	
	}
	
	@After(order=0)
	public void closeBrowser() {
		
		Base.tearDown();
	}
	@After(order=1)
	public void extentReport() {
		
		logger=ComplexReportFactory.getTest();	
	}
	

	@Given("^Open the Browser and Enter URLE$")
	public void open_the_Browser_and_Enter_URLE() throws MalformedURLException {
	   
	  Base.setUp();
	  crm.enterURL();
	   
	}

	@Then("^Verify Title of Login PageE$")
	public void Verify_Title_of_Login_PageE() throws IOException {
		
		crm.compareTitle();
		takeScreenShotForPass("Verify Login Page Title", "Comparing Title of Login Page", "", "", "");
	}
	@When("^User enters \"(.*)\" and \"(.*)\" and Click on Login buttonE$")
	public void user_enters_Username_and_Password_and_Click_on_Login_buttonE(String username ,String password) throws MalformedURLException, InterruptedException  {
	   
		crm.enterUnamePasswithExample(username,password);
		crm.clickLoginBtn();
	
	}

	
	
	@Then("^Verify Home PageE$")
	public void verify_Home_PageE() throws IOException  {
		
		 crm.homePage();
		 takeScreenShotForPass("Verify Home Page Title", "Comparing Title of Home Page", "", "", "");
	}

	
}
