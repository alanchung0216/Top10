package com.algorithm;
/*
Write a Java program to print Fibonacci series upto 100?
This is one of the most popular coding interview question 
asked in Java programming language. Even though, Writing program 
for Fibonacci series is one of the basic Java program, not every 
Java developer get it right in interview. Again interview can ask 
to solve this programming interview question, by using recursion 
or Iteration. This Java programming question also test your 
problem solving skills and if you come up with an original 
solution, that may even help. See here for complete code 
example of Fibonacci series in Java 
http://java67.blogspot.com/2016/05/
fibonacci-series-in-java-using-recursion.html

Read more: http://java67.blogspot.com/2012/08/10-java-coding-interview-questions-and.html#ixzz4BxJtnqGM
*/

// 7/7/2016

public class fibonacci {
	// fibonacci series upto 15 (start from 0 till 15)
	public static int fib(int n){
		// f(n) = f(n-2) + f(n-1)
		if (n==0) return 0;
		if (n==1) return 1;
		int f_n_2 = 0;
		int f_n_1 = 1;
		int f_n = 0;
		for (int i=2; i<=n; i++){
			f_n = f_n_2 + f_n_1;
			f_n_2 = f_n_1;
			f_n_1 = f_n;
		}
		return f_n;
	}
	public static int fib_recur(int n){
		if (n==0) return 0;
		if (n==1) return 1;
		return fib_recur(n-2) + fib_recur(n-1);
	}
	
	public static void main(String args[]){
		for (int i=0; i<=15; i++){
			//System.out.println(fib(i));
			System.out.println(fib_recur(i));
		}
	}
}
/*

public class fibonacci {
	// fibonacci series upto 15 (start from 0 till 15)
	// 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610
	// f(n) = f(n-2) + f(n-1)
	//
	public static long fib_loop(int n){
		if (n == 0) return 0;
		if ((n == 1) || (n == 2)) return 1;
		long fn_2=1;
		long fn_1=1;
		long fn=0;
		for (int i = 3; i<=n; i++){
			fn = fn_2 + fn_1;
			fn_2 = fn_1;
			fn_1 = fn;
		}
		return fn;
	}
	public static long fib_recur(int n){
		if (n==0) return 0;
		if ((n == 1) || (n == 2)) return 1;
		return fib_recur(n-2) + fib_recur(n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0; i<= 15; i++) {
			//System.out.print(fib_loop(i) + " ");
			System.out.print(fib_recur(i) + " ");
		}
	}
}
*/
