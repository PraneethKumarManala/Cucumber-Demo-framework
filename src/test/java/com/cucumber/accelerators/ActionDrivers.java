package com.cucumber.accelerators;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cucumber.listener.Reporter;


public class ActionDrivers extends Base{


	public static int num = 1;
	Alert alert;
	
	
	public static void takeScreenShotForPass(String TestCaseName,String stepName,String stepDetails,String Expected,String Actual) throws IOException
	{
		//if(configProps.getProperty("browser").equalsIgnoreCase("Firefox"))
		//{
		++num;
		String screenShotFullName=TestCaseName+num+"_"+Base.timeStamp+".png";
		String Name = captureScreenShot(System.getProperty("user.dir")+"/"+Base.filepath()+screenShotFullName);			
	    Reporter.addScreenCaptureFromPath(Name.toString());
	    // logger.log(Status.PASS, stepName+"<br>"+stepDetails +Expected +Actual ,MediaEntityBuilder.createScreenCaptureFromPath(screenShotFullName).build());
	
		//logger.addScreenCaptureFromPath(screenShotFullName);
		++num;	
		//}else if(configProps.getProperty("browser").equalsIgnoreCase("Chrome"))
		//{
		//}
	}
	
	/*public static String captureScreenShot(String fileName) {

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//TakesScreenshot
			// Now you can do whatever you need to do with it, for example copy
			// somewhere
			FileUtils.copyFile(scrFile, new File(fileName));
			System.out.println("Screenshot taken");
			return fileName;
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: "+e.getMessage());
			return e.getMessage();
		}
	}*/


	/**
	 * Author - Murari
	 * 
	 * This Method for take screen shot for Failed test case and save in specific location
	 * @throws IOException 
	 * */
	public static void takeScreenShotForFail(String TestCaseName,String stepName,String stepDetails,String Expected,String Actual,ExtentTest logger) throws IOException
	{
		num++;
		String screenShotFullName=TestCaseName+num+"_"+Base.timeStamp+".png";
		captureScreenShot(System.getProperty("user.dir")+"/"+Base.filepath()+screenShotFullName);			
		logger.log(Status.FAIL, stepName+"<br>"+stepDetails +Expected +Actual ,MediaEntityBuilder.createScreenCaptureFromPath(screenShotFullName).build());
		//MediaEntityBuilder.createScreenCaptureFromPath(screenShotFullName).build()
		++num;		
		Assert.fail();
	}

	/**
	 * Author - Murari
	 * 
	 * This Method for take screen shot for Failed test case and save in specific location and without Assert(i.e : with out stop script)
	 * @throws IOException 
	 * */
	public static void takeScreenShotForFailWithoutAssert(String TestCaseName,String stepName,String stepDetails,String Expected,String Actual,ExtentTest logger) throws IOException
	{
		num++;
		String screenShotFullName=TestCaseName+num+"_"+Base.timeStamp+".png";
		captureScreenShot(System.getProperty("user.dir")+"/"+Base.filepath()+screenShotFullName);			
		logger.log(Status.FAIL, stepName+"<br>"+stepDetails +Expected +Actual,MediaEntityBuilder.createScreenCaptureFromPath(screenShotFullName).build());
		++num;	
		//Assert.fail();
	}

	/**
	 * Author - Murari
	 * 
	 * This Method for take screen shot for Verification InFo test case and save in specific location
	 * @throws IOException 
	 * */
	public static void takeScreenShotForINFO(String TestCaseName,String stepName,String stepDetails,String Expected,String Actual,ExtentTest logger) throws IOException
	{
		num++;
		String screenShotFullName=TestCaseName+num+"_"+Base.timeStamp+".png";
		captureScreenShot(System.getProperty("user.dir")+"/"+Base.filepath()+screenShotFullName);			
		logger.log(Status.INFO, stepName+"<br>"+stepDetails +Expected +Actual ,MediaEntityBuilder.createScreenCaptureFromPath(screenShotFullName).build());
		++num;

	}

	/**
	 * Author - Murari
	 * 
	 * This Method for Pass Without Screen shot
	 * */
	public static void takeWithoutScreenShotForPass(String TestCaseName,String stepName,String stepDetails,String Expected,String Actual,ExtentTest logger)
	{

		String screenShotFullName=TestCaseName+num+"_"+Base.timeStamp+".png";
		captureScreenShot(System.getProperty("user.dir")+"/"+Base.filepath()+screenShotFullName);			
		logger.log(Status.PASS, stepName+"<br>"+stepDetails +Expected +Actual);


	}

	public static String captureScreenShot(String fileName) {

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//TakesScreenshot
			// Now you can do whatever you need to do with it, for example copy
			// somewhere
			FileUtils.copyFile(scrFile, new File(fileName));
			System.out.println("Screenshot taken");
			return fileName;
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: "+e.getMessage());
			return e.getMessage();
		}
	}

	
	 
}
