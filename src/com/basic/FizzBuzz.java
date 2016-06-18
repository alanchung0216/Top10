package com.basic;
/*
FizzBuzz problem : Write a Java program that prints the numbers 
from 1 to 50. But for multiples of three print "Fizz" instead of 
the number and for the multiples of five print "Buzz". For numbers 
which are multiples of both three and five print "FizzBuzz"
This is also one of the classical programming questions, which is
 asked on any Java programming or technical interviews. This 
 questions is very basic but can be very trick for programmers, 
 who can't code, that's why it is used to differentiate programmers 
 who can do coding and who can't. Here is a sample Java program to 
 solve FizzBuzz problem :

Read more: http://java67.blogspot.com/2012/08/10-java-coding-interview-questions-and.html#ixzz4Bxd2liVe
 */
public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=1; i <=50; i++)	{
			if (i%15 == 0) 
				System.out.println("FizzBuzz");
			else if (i%3 == 0)
				System.out.println("Fizz");
			else if (i%5 == 0)
				System.out.println("Buzz");
			else
				System.out.println(i);
			
		}
	}
}
