package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
//import com.w2a.base.*;
public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void bankManagerLoginTest() throws InterruptedException, IOException
	{
		//System.out.println("hello");
	//driver.findElement(By.cssSelector("div > div > .container-fluid.ng-scope"))
		//driver.switchTo().frame("//iframe[contains(@src,'FUN_UnitList_FilterByLevelIndexOne')]");
		//try {
		//verifyEquals("abc", "xyz");
		Thread.sleep(5000);
		//}catch (Throwable t)
		//{
		//	System.out.println("inside catch");
		//}
		log.debug("inside Login Test");
		driver.findElement(By.cssSelector(OR.getProperty("BKMBtn"))).click();
		
		log.debug("object found and clicked");
		Thread.sleep(3000);
		
		//Assert.assertEquals(null, null);
		
		
	}
	
	

}
