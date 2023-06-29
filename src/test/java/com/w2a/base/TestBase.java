package com.w2a.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.support.ui.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.listners.CustomListeners;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.TestUtil;

import org.openqa.selenium.*;
public class TestBase {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static FileInputStream fis1;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader("C:\\Users\\dmudi\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	
	
	@BeforeSuite
	public void setUp(){
		
		if(driver== null)
		{
			try {
				fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\properties\\ Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			fis1 = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.debug("Config file is loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis1);
			log.debug("OR File is loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 if(config.getProperty("Browser").equals("chrome")) {
			 System.setProperty("webdriver.chrome.silentOutput","true");
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\dmudi\\Downloads\\chromedriver_win32\\chromedriver.exe");

			 driver = new ChromeDriver();
			 log.debug("Chrome Browser is launched");
		 } 
		 else if(config.getProperty("Browser").equals("Firefox")) {
			 System.setProperty("webdriver.gecko.driver","C:\\Users\\dmudi\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe");

		     driver = new FirefoxDriver();
		     log.debug("Firefox browser is loaded");
		    // driver.get(config.getProperty("TestsiteURL"));
		 }
        		 
		 driver.get(config.getProperty("TestsiteURL"));
		 log.debug("navigated to :" +config.getProperty("TestsiteURL"));
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("Implicit.wait")), TimeUnit.SECONDS);
	    // wait = new WebDriverWait(driver,10);
		
		}
		
		
	}
	
	public void Click(String Locator)
	{
		driver.findElement(By.cssSelector(OR.getProperty(Locator))).click();
		
	}
	
	public void Type(String Locator, String Value)
	{
		driver.findElement(By.cssSelector(OR.getProperty(Locator))).sendKeys(Value);
	}
	
	static WebElement dropdown;
	
	public void select(String Locator, String Value)
	{
		dropdown = driver.findElement(By.cssSelector(OR.getProperty(Locator)));
		Select select = new Select(dropdown);
		select.selectByVisibleText(Value);
	}
	
	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			TestUtil.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			//CustomListeners.testReport.get().log(Status.FAIL, " Verification failed with exception : " + t.getMessage());
			//CustomListeners.testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
				//	MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName)
				//	.build());
			   test.log(LogStatus.FAIL, "Verification Failed Exception: " +t.getMessage());
			   test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));	

		}

	}

	
	@AfterSuite
	public void TearDown()
	{
		if(driver!=null)
		{
			driver.close();
		}
	}
	
	
			
	}
