package com.w2a.testcases;

import static org.testng.Assert.assertTrue;
//import org.openqa.selenium.Alert;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase {
	
	//@Test(dataProvider="getdata")
	
	@Test(dataProviderClass = TestUtil.class,dataProvider ="dp")
	
	public void addCustomerTest(Hashtable<String,String> data) throws InterruptedException{
		
		if(!data.get("runmode").equals("Y"))
		{
			throw new SkipException("skipping the testcase as run mode is N");
		}
		
		driver.findElement(By.cssSelector(OR.getProperty("AddCust"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(data.get("FirstName"));
		driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(data.get("LastName"));
		driver.findElement(By.cssSelector(OR.getProperty("postalcode"))).sendKeys(data.get("PostalCode"));
		driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();
		Thread.sleep(3000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		// ((Object) alert).authenticateUsing(new UsernameAndPassword("<username>","<password>"));
		//driver.switchTo().alert().authenticateUsing(new UsernameAndPassword("uname", "Password"));
		//alert.SetAuthenticationCredentials("username", "password");
		alert.
		Assert.assertTrue(alert.getText().contains(data.get("AlertText")));
		alert.accept();
		Thread.sleep(3000);
	}
		
//	@DataProvider
//	public Object[][] getdata() {
		
//String sheetName = "AddCustomerTest"; 
//int rows = excel.getRowCount(sheetName);
//int cols = excel.getColumnCount(sheetName);

//Object[][] data = new Object[rows-1] [cols];

//for (int rowNum=2; rowNum<= rows; rowNum++)
//{
	//for(int colNum=0;colNum<= cols-1; colNum++)
	//{
		//data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
	//}
//}
//return data;
	//}
	
	}
