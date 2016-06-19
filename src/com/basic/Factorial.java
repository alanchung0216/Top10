package com.basic;
/*
Factorials are very simple things. They're just products, 
indicated by an exclamation mark. For instance, "four factorial" 
is written as "4!" and means 1×2×3×4 = 24. 
In general, n! ("enn factorial") means the product of all the 
whole numbers from 1 to n; that is, n! = 1×2×3×...×n.
 */
import java.util.Scanner;

public class Factorial {

	public static int fact(int n){
		int total=1;
		for (int i=1; i<=n; i++) {
			total *= i;
		}
		return total;
	}
	
	public static int fact_recur(int n) {
		if (n == 1) return 1;
		return fact_recur(n-1)*n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number :");
		while (sc.hasNextLine()) {
			int num = sc.nextInt();
			System.out.println(num + "! factorial is " + fact(num));
			System.out.println(num + 
					"! factorial recursive is " + fact_recur(num));
		}
	}

}
