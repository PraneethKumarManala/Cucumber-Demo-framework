package com.cucumber.accelerators;

//Importing In-Build Jar files
import java.io.File;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import com.cucumber.utilities.Property;
import cucumber.api.DataTable;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Base extends Parameters {

	 private static final Logger loger = Logger.getLogger(Base.class.getName());
	
	public static Property configProps=new Property("config.properties");
	
	public static String username = configProps.getProperty("username");
	public static String password = configProps.getProperty("password");
     
	public static String URL=configProps.getProperty("URL");
	public static String url1=configProps.getProperty("url1");
	public static String url2=configProps.getProperty("url2");
	public static String runScripts=configProps.getProperty("runScripts");
	public static String browser=configProps.getProperty("browser");
	public static String firefoxbrowser=configProps.getProperty("firefoxbrowser");
	public static String timeStamp=timeStamp().replace(" ", "_").replace(":", "_").replace(".", "_");
	
	public int Response_Status_Code_200=200;
	public int Response_Status_Code_404=404;
	public int Response_Status_Code_201=201;
	
	public static WebDriver driver;
	
	//@org.testng.annotations.Parameters({"browser"})
	@BeforeMethod
	public static void setUp() {
		if(browser.equalsIgnoreCase("chrome")) {
			
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		loger.info("Chrome Browser is launched");
		driver.manage().window().maximize();
		loger.info("Chrome Browser is maximised");
		
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
			loger.info("Firefox Browser is launched");
			driver.manage().window().maximize();
			loger.info("Firefox Browser is maximised");
		}
		
	}
	
    @AfterMethod
	public static void tearDown() {
		
    	driver.close();
    	//driver.quit();
    	loger.info("Browser is Closed");
	}

    
   
    
	 @BeforeTest
	 public static void log4J() {
		 
		 String log4jPath=System.getProperty("user.dir")+"/log4j.properties";
		 PropertyConfigurator.configure(log4jPath);
	
	 }
    
    public static String timeStamp() {
		
        java.util.Date today = new java.util.Date();
       // System.out.println("The Sql Time is :"+new java.sql.Timestamp(today.getTime()).toString());
        return new java.sql.Timestamp(today.getTime()).toString();
     
}
   
    public static String getReportConfigPath(){
     String reportConfigPath = configProps.getProperty("reportConfigPath");
    		
     if(reportConfigPath!= null) return reportConfigPath;
     else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
    }
    
    public static String filepath() {
    	
    	String strDir="";
    	
    	if(browser.equalsIgnoreCase("firefox")) {
    		strDir="Firefox/FireFox";
    	}
    	if(browser.equalsIgnoreCase("chrome")) {
    		strDir="chrome/chrome";
    	}
    	if(strDir!="") {
    	   // System.out.println("After Time Stamp:"+timeStamp);
    		new File(configProps.getProperty("screenShotPath")+strDir+"_"+timeStamp).mkdirs();
    	}
    	return configProps.getProperty("screenShotPath")+strDir+"_"+timeStamp+"/";
    }
    
   

}
