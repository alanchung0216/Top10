package com.string;
/*
Write a Java program to replace certain characters from String like

public String replace(String str, char ch)

This is a tricky Java coding interview question is asked in one 
of the written test my friend had appeared recently. This Java 
coding question can be solved in multiple way e.g. by using 
charAt() or subString() method,  but any approach throws couple 
of follow-up question e.g. you may be asked to write two version 
to solve this coding exercise, one by using recursion and other 
by using Iteration. They may also ask you to write JUnit test 
for this function which means handling null, empty string etc. 
By the way this programming question is quite common on technical 
interviews not just Java but also C, C++ or Scala, but knowing 
API definitely helps to produce better solution quickly.

Read more: http://java67.blogspot.com
/2012/08/10-java-coding-interview-questions-and.html#ixzz4BwzZPSE7
 
*/
public class replace_string {
	public static String repl(String str, char oldc, char newc ){
		char[] ca = str.toCharArray();
		for (int i=0; i<ca.length; i++){
			if (ca[i] == oldc) {
				ca[i] = newc;
				break;
			}
		}
		//for (int i=0; i<ca.length; i++){
		//	System.out.printf("%c", ca[i]);
		//}
		//System.out.println();
		
		return String.valueOf(ca);
		// or
		//return new String(ca);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hallo world";
		char oldc = 'a';
		char newc = 'e';
		String out = repl(str, oldc, newc);
		System.out.println(str);
		System.out.println(out);

	}

}
