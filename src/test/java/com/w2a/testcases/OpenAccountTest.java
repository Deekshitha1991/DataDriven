package com.w2a.testcases;

import static org.testng.Assert.assertTrue;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class OpenAccountTest extends TestBase {
	
	@Test(dataProviderClass = TestUtil.class,dataProvider = "dp")
	
	public void openAccountTest(Hashtable<String,String> data) throws InterruptedException{
		
		if(!data.get("runmode").equals("Y"))
		{
			throw new SkipException("skipping the testcase as run mode is N");
		}
		
		//driver.findElement(By.cssSelector(OR.getProperty("openacctbtn"))).click();
		Thread.sleep(4000);
		Click("openacctbtn");
		select("Customer_fld",data.get("Customer"));
		Thread.sleep(4000);
		select("Currency_fld",data.get("Currency"));
		//driver.findElement(By.cssSelector(OR.getProperty("Customer"))).sendKeys(Customer);
		//driver.findElement(By.cssSelector(OR.getProperty("Currency"))).sendKeys(Currency);
		//driver.findElement(By.cssSelector(OR.getProperty("postalcode"))).sendKeys(PostalCode);
		Thread.sleep(4000);
		driver.findElement(By.cssSelector(OR.getProperty("Processbtn"))).click();
		Thread.sleep(3000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//Assert.assertTrue(alert.getText().contains(AlertText));
		alert.accept();
		Thread.sleep(3000);
	}
		
	
	
	}
