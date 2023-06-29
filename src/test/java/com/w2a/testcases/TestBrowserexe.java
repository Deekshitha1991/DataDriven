package com.w2a.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;

public class TestBrowserexe {
	
	//public static void main(String[] args) {
	public static void main(String arg[]) {
		
		SeleniumManager.getInstance();
		
		WebDriver driver = new ChromeDriver();
		
	}

}
