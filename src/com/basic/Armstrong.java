package com.basic;
/*
Write a Java program to check if a number is Armstrong or not ?
Another popular logical coding interview questions in Java, 
which is based on programming logic. In order to answer this
 programming question, you need to know what is Armstrong number, 
 but that is not a problem because question may specify that and 
 even provide sample input and output. Key thing to demonstrate 
 is logic to check if a number is Armstrong or not. In most cases, 
 you can not use utility methods defined by logic and you need 
 to produce logic by yourself by using basic operators and methods. 
 By the way this is also one of the basic programming questions 
 and I have already provided a solution for this. I suggest to 
 see this Java program to find Armstrong Number in Java  
 http://java67.blogspot.com/2012/07/
 java-program-to-find-armstrong-numbers.html 
 to answer this coding question
 
An example of Armstrong number is 153 as 153= 1+ 125+27 
which is equal to 1^3+5^3+3^3. 
One more example of the Armstrong number is 371 because 
it is the sum of 27 + 343 + 1 which is equal to 3^3 + 7^3 + 1^3 .

Read more: http://java67.blogspot.com/2012/08/10-java-coding-interview-questions-and.html#ixzz4C2klcduA
 */
import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read in three digit number from console
		// then find out if this number is Armstrong
		int num;
		Scanner sc = new Scanner(System.in);
		while (true){
			num = sc.nextInt();
			if (num == 0) break;
		}
		System.out.println(num);
		
	}

}
