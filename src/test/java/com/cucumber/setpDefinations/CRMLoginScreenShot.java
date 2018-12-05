package com.cucumber.setpDefinations;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.cucumber.accelerators.ActionDrivers;
import com.cucumber.accelerators.Base;
import com.cucumber.definedMethods.CRMApplication;
import com.cucumber.factory.ComplexReportFactory;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.toolsQA.cucumber.TestContext;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class CRMLoginScreenShot extends ActionDrivers {

	private static final Logger loger = Logger.getLogger(CRMLoginFunctionality.class.getName());

	WebDriver driver;
	ExtentTest logger = ComplexReportFactory.getTest();

	CRMApplication crm = new CRMApplication();

	TestContext testContext;

	/*public CRMLoginScreenShot(TestContext context) {
		testContext = context;
	}*/

	@Before(order = 2)
	public void afterScenario(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				// This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);

				// Building up the destination path for the screenshot to save
				// Also make sure to create a folder 'screenshots' with in the cucumber-report
				// folder
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
						+ screenshotName + ".png");

				// Copy taken screenshot from source location to destination location
				FileUtils.copyFile(sourcePath, destinationPath);
				//Files.copy(sourcePath, destinationPath);

				// This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			
			} catch (IOException e) {
			}
		}
	}


	@Before(order = 1)
	public void log4Jexecution() {

		Base.log4J();

	}

	@After(order = 0)
	public void closeBrowser() {

		//testContext.getWebDriverManager().closeDriver();
		Base.tearDown();
	}

	@Before(order = 0)
	public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor("CharterGlobal - PraneethKumarManala");
	}

	/*
	 * @Before 
	 * public void extentRepotLogger() {
	 * 
	 * logger= ComplexReportFactory.getTest();
	 * logger.assignCategory("CRM Login Functionality");
	 * 
	 * }
	 */

	@Given("^Open the Browser and Enter URLS$")
	public void open_the_Browser_and_Enter_URLS() throws MalformedURLException {

		Base.setUp();
		crm.enterURL();
      
	}

	@Then("^Verify Title of Login PageS$")
	public void Verify_Title_of_Login_PageS() throws IOException {

		crm.compareTitle();
		takeScreenShotForPass("Verify Login Page Title", "Comparing Title of Login Page", "", "", "");
	}

	@When("^User enters Username and Password and Click on Login buttonS$")
	public void user_enters_Username_and_Password_and_Click_on_Login_buttonS()
			throws MalformedURLException, InterruptedException {

		crm.enterUnamePass();
		crm.clickLoginBtn();
	}

	@Then("^Verify Home PageS$")
	public void verify_Home_PageS() throws IOException {

		crm.homePage();
		takeScreenShotForPass("Verify Home Page Title", "Comparing Title of Home Page", "", "", "");
	}

}
