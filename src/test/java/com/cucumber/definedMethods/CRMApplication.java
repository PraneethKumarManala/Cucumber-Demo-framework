package com.cucumber.definedMethods;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.cucumber.accelerators.Base;
//import com.cucumber.setpDefinations.CRMLoginFunctionality;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class CRMApplication extends Base {

	private static final Logger loger = Logger.getLogger(CRMApplication.class.getName());

	public void enterURL() {

		driver.get(URL);
		loger.info("Ented URL is : " + URL);

	}

	
	public void compareTitle() {

		String actual_title = driver.getTitle();
		loger.info("Login Page Title is Captured");
		System.out.println("The Actual title of the FreeCRM is: " + actual_title);
		String exptect_title = "#1 Free CRM software in the cloud for sales and service";
		Assert.assertEquals(exptect_title, actual_title);
		System.out.println("The Expected title of the FreeCRM is: " + exptect_title);
		System.out.println("Expected and Actual Titles are Matched");
	}

	public void enterUnamePass() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys(username);
		loger.info("The entered UserName is : " + username);
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys(password);
		loger.info("The entered Password is : " + password);

	}
	public void enterUnamePasswithExample(String username,String password) throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys(username);
		loger.info("The entered UserName is : " + username);
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys(password);
		loger.info("The entered Password is : " + password);

	}

	public void clickLoginBtn() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@type='submit']")).click();
		loger.info("Submit Button is Clicked");
	}

	public void homePage() {

		String actHomepage_title = driver.getTitle();
		loger.info("Home Page Title is Captured");
		System.out.println("The Actual Home Page title is:" + actHomepage_title);
		String expHomepage_title = "CRMPRO";
		System.out.println("The Expected Home Page title is:" + expHomepage_title);
		Assert.assertEquals(expHomepage_title, actHomepage_title);
		System.out.println("The Expected and Actual Home Page Titles are matched ");
	}

	public void movesToNewDealPage() throws Throwable {

		driver.switchTo().frame("mainpanel");
		loger.info("Swithed to MainPanel Frame");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(".//*[@title='Deals']"))).build().perform();
		driver.findElement(By.xpath(".//*[@title='New Deal']")).click();
		loger.info("Clicked on New Deal Link in MainPanel Frame");

	}
	
	
	public void userEntersDealDetails(DataTable dealdata) throws Throwable {
        int num=1;
		for (Map<String, String> ddata : dealdata.asMaps(String.class, String.class)) {
			
			Thread.sleep(2000);
			driver.findElement(By.id("title")).sendKeys(ddata.get("title"));
			Thread.sleep(1000);
			driver.findElement(By.id("amount")).sendKeys(ddata.get("amount"));
			Thread.sleep(1000);
			driver.findElement(By.id("probability")).sendKeys(ddata.get("probobility"));
			Thread.sleep(1000);
			driver.findElement(By.id("commission")).sendKeys(ddata.get("commission"));
			Thread.sleep(1000);
            loger.info("Entered the Deal Data "+num);
            num++;
			driver.findElement(By.xpath(".//*[@value='Save']")).click();
			loger.info("Clicked on Save button");
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath(".//*[@title='Deals']"))).build().perform();
			driver.findElement(By.xpath(".//*[@title='New Deal']")).click();

		}
	}
}
