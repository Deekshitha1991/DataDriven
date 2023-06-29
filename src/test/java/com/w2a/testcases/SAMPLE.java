package com.w2a.testcases;

import java.util.Set;

public class SAMPLE {

	public static void main(String[] args) {
		
	//Occurance of string
		
		String s  = "Hello World";
		int a = s.length();
		System.out.println (a);
		
		int count = 0;
		for (int i=1; i< s.length(); i++)
		{
			if(s.charAt(i)== 'e' )
			{
				count++;
			}
		}
		
		System.out.println ("count is " +count);
		
		//Print duplicate in the given string
		
		String test = "getgetsetsety";
		char[] array1= test.toCharArray();
		for(int i=array1.length-1;i>=0;i--) {
			System.out.print(array1[i]);
			
		}
		
		
		
	
		int count1;
		char[] string = test.toCharArray();
			
		for(int i=0; i< string.length;i++)
			
		{
			count1=1;
		for(int j=i+1;j<string.length;j++)
		{
			if(string[i]==string[j] && string[i]!=' ')
			{
				count1++;
				string[j]='0';
				
			}
			}
		
		if(count1>1 && string[i]!='0')
		{
			System.out.println(string[i]);
			
		}
		}
		}}
		
		
		
		
	