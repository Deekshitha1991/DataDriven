package com.w2a.rough;
//import java.io.FileInputStream;
import java.io.IOException;
//import java.util.*;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestProperties {
	
	public static void main(String[] args) throws IOException
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\dmudi\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

	}
	}
