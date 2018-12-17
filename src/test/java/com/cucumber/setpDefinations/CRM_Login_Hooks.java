package com.cucumber.setpDefinations;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.cucumber.accelerators.ActionDrivers;
import com.cucumber.accelerators.Base;
import com.cucumber.definedMethods.CRMApplication;
import com.cucumber.factory.ComplexReportFactory;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CRM_Login_Hooks extends ActionDrivers{
	
	private static final Logger loger = Logger.getLogger(CRM_Login_Hooks.class.getName());
    
	//WebDriver driver;
	ExtentTest logger=ComplexReportFactory.getTest();	
	
	CRMApplication crm= new CRMApplication();
	
	@Before
	public void log4Jexecution() {
		
		Base.log4J();
	
	}
	
	@After
	public void closeBrowser() {
		
		Base.tearDown();
	}
	
	@Given("^Open the Browser and Enter URLHooks$")
	public void open_the_Browser_and_Enter_URL() throws MalformedURLException {
	   
	  Base.setUp();
	  crm.enterURL();
	   
	}

	@Then("^Verify Title of Login PageHooks$")
	public void Verify_Title_of_Login_Page() throws IOException {
		
		crm.compareTitle();
		takeScreenShotForPass("Verify Login Page Title", "Comparing Title of Login Page", "", "", "");
	}
	
	@When("^User enters Username and Password and Click on Login buttonHooks$")
	public void user_enters_Username_and_Password_and_Click_on_Login_button() throws MalformedURLException, InterruptedException  {
	   
		crm.enterUnamePass();
		crm.clickLoginBtn();
	}

	
	
	@Then("^Verify Home PageHooks$")
	public void verify_Home_Page1() throws IOException  {
		
		 crm.homePage();
		 takeScreenShotForPass("Verify Home Page Title", "Comparing Title of Home Page", "", "", "");
	}
	
	@When("^User enters \"(.*)\" and \"(.*)\" and Click on Login buttonHooks2$")
	public void user_enters_Username_and_Password_and_Click_on_Login_button(String username ,String password) throws MalformedURLException, InterruptedException  {
	   
		crm.enterUnamePasswithExample(username,password);
		crm.clickLoginBtn();
	
	}
	
	@Then("^moves to new deal pageHooks3$")
	public void moves_to_new_deal_page() throws Throwable {
	   
		crm.movesToNewDealPage();
	}

	@Then("^user enters deal detailsHooks3$")
	public void user_enters_deal_details(DataTable dealdata) throws Throwable {
		
		crm.userEntersDealDetails(dealdata);	
	}
}
