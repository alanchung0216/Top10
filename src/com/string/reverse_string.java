package com.string;
/*
Write Java program to reverse String in Java without using API functions ?
Another classic Java programming or coding exercise mostly asked 
on 2 to 5 years experienced Java interviews. Despite being simple 
answering this coding question is not easy, specially if you are 
not coding frequently. Its best to prepare this programming 
question in advance to avoid any embarrassment during interviews. 
I suggest to see this post which shows How to reverse String 
using recursion in Java

Read more: http://java67.blogspot.com/2012/08/10-java-coding-interview-questions-and.html#ixzz4C3MIfzm2
 */
import java.util.Scanner;

public class reverse_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("enter string : ");
		while (sc.hasNextLine()){
			str=sc.nextLine().trim();
			char[] ca = str.toCharArray();
			for (int i=0; i<ca.length/2; i++){
				char temp = ca[i];
				ca[i] = ca[ca.length-1-i];
				ca[ca.length-1-i] = temp;				
			}
			System.out.println(String.valueOf(ca));
			System.out.println("enter string : ");
		}
		sc.close();
	}

}
