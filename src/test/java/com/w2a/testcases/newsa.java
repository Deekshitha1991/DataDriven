package com.w2a.testcases;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.w2a.base.TestBase;

public class newsa extends TestBase  {

	public static void main(String[] args) {
	//	
				    // create Scanner to read user input
		    
		
		List<WebElement> link = driver.findElements(By.tagName("a"));
		for(int i=0;i< link.size();i++)
		{
			WebElement element = link.get(i);
			String url = element.getAttribute("href");
			//verifylink(url)
		
		
		
		Scanner sc = new Scanner(System.in);

		    System.out.println("Please enter a String");
		    String input = sc.nextLine();

		    if (isUnique(input)) {
		      System.out.println("All characters of String are unique");
		    } else {
		      System.out.println("All characters of String are not unique");
		    }

		    sc.close();
		  }


		Read more: https://www.java67.com/2017/08/how-to-determine-if-string-has-all-unique-characters-in-java.html#ixzz84Fkfe1ut

		// TODO Auto-generated method stub

	}

}
