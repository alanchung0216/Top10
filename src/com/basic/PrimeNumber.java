package com.basic;

/*
Write a Java program to find if a number is prime number or not
One more basic Java program, which made it's way to Interviews. 
One of the simplest coding question and also a very popular 
Java programming exercise. Beauty of these kinds of logical 
questions is that, they can really test basic programming skills 
or a coder, programmer or developer. Not just problem solving, 
you can also check there coding style and thought process. 
By the way. you can  check this article for answer of this Java 
coding interview question.
http://javarevisited.blogspot.com/
2012/04/java-program-to-print-prime-numbers-in.html


Read more: http://java67.blogspot.com/2012/08/10-java-coding-interview-questions-and.html#ixzz4C3cJ04rh
 */

import java.util.Scanner;
// 7/7/2016
public class PrimeNumber {
	public static void main(String args[]){
		int num = 12;
		boolean prime = true;
		for (int i=2; i<num; i++){
			if (num % i == 0) {
				prime = false;
				break;
			}
			
		}
		System.out.println((prime) ? "true" : "false");
	}
}
/*
public class PrimeNumber {
	
	//A number is called prime number if its not divisible by 
	//any number other than 1 or itself

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long num;
		System.out.println("enter num: ");
		while (sc.hasNextLine()){
			num=sc.nextLong();
			boolean prime=true;
			for (long i=2; i<num; i++){
				if ((num % i) == 0) {
					System.out.println(num + " it's not prime dividible by " + i);
					prime=false;
					break;
				}
			}
			if (prime) System.out.println(num + " it's a prime");
			
			System.out.println("enter num: ");
		}
		sc.close();
	}

}
*/
