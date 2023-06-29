package com.w2a.testcases;

public class samplestring {

	public static void main(String[] args) {
		// no of words in string
		
		String s = "hello world";
				int j = s.split("\\s").length;
				System.out.println(j);
				
				//remove given characters in string
		String s1 = "hello";
		String c = s1.replace("h", "b");
		System.out.println(c);
		
		//reverse string using string buffer
		String str = "hekjik";
		StringBuffer sb = new StringBuffer(str);
		StringBuffer revst = sb.reverse();
		System.out.println(revst);
		
		//without using string buffer
		String se = "jfkkjepdjk hfbkjn";
		for(int i= se.length()-1;i>=0;i--)
		{
			System.out.println(se.charAt(i));
		}
		
		
		
		
		
	}

}
