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

public class reverse_int_or_str {
	
	public static int rev_int(int n) {
		String str = String.valueOf(n);
		String rev = rev_str(str);
		return Integer.valueOf(rev);
		
	}
	public static String rev_str(String s){
		char[] ca = s.toCharArray();
		for (int i=0; i<ca.length/2; i++){
			char temp= ca[ca.length-1-i];
			ca[ca.length-1-i] = ca[i];
			ca[i] = temp;
		}
		return String.valueOf(ca);
	}
	
	public static String rev_str_recur(String s){
		if (s.length()  < 2) return s;
		return rev_str_recur(s.substring(1,s.length())) + s.charAt(0);
		//return rev_str_recur(s.substring(1)) + s.charAt(0);
		//return s.charAt(s.length()-1) + rev_str_recur(s.substring(0, s.length()-1));
	}
	
	public static void main(String args[]){
		
		//String str = "Hello World";
		System.out.println(" enter string : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(rev_int(Integer.valueOf(str)));
		System.out.println(rev_str(str));	
		System.out.println(rev_str_recur(str));
		sc.close();
	}
}
/*
public class reverse_string {
	// iterative version
	public static String rev_string(String s){
		char[] ca = s.toCharArray();
		for (int i=0; i<ca.length/2; i++){
			char temp = ca[i];
			ca[i] = ca[ca.length-1-i];
			ca[ca.length-1-i] = temp;				
		}
		return String.valueOf(ca);
	}
	
	public static String recur_rev_string(String str){

		if (str.length() > 1){
			System.out.println(str.length());
			//reverse from end
			//return str.charAt(str.length()-1)
			//		+ recur_rev_string(str.substring(0,str.length()-1));
			
			// reverse from begin. got same result
			return recur_rev_string(str.substring(1))
					+ str.charAt(0);	
		} else {
			return str;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("enter string : ");
		while (sc.hasNextLine()){
			str=sc.nextLine().trim();
			
			// using API
			//StringBuffer buf = new StringBuffer(str);
			//StringBuffer rev = buf.reverse();
			//System.out.println(rev);
			
			// using iterative method
			//System.out.println(rev_string(str));
			
			// using recursive method
			System.out.println(recur_rev_string(str));
			
			System.out.println("enter string : ");
		}
		sc.close();
	}

}
*/
