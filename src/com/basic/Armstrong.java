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

For example, 9474 is an Armstrong number of 4 digits 
because 9^4 + 4^4 + 7^4 + 4^4 = 6561 + 256 + 2401 = 9474 ]

Read more: http://java67.blogspot.com/2012/07/java-program-to-find-armstrong-numbers.html#ixzz4C35MkT9u

Read more: http://java67.blogspot.com/2012/08/10-java-coding-interview-questions-and.html#ixzz4C2klcduA
 */
import java.util.Scanner;
/*
public class Armstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read in number from console
		// then find out if this number is Armstrong
		int num;
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("enter num: ");
		while (sc.hasNextLine()){ // control D will terminate the loop
			str = sc.nextLine();
			num = Integer.valueOf(str);
			//System.out.println(num);
			char[] ca = str.toCharArray();
			int total=0;
			for (int i=0; i < ca.length; i++){
				int d = Integer.valueOf(ca[i]-'0');
				int d_total=1;
				for (int j=0; j< ca.length; j++){
					d_total *= d;
					//System.out.println("d_total  " + d_total);
				}
				total += d_total;
			}
			System.out.println("total " + total);
			if (total == num){
				System.out.println("this is an Armstrong number");
			}
			
			System.out.println("enter num: ");
		}
		System.out.println("exit ");
		sc.close();
	}

}
*/
// another implementation using % remainder
public class Armstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read in number from console
		// then find out if this number is Armstrong
		int num;
		int orig;
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("enter num: ");
		while (sc.hasNextLine()){ // control D will terminate the loop
			str = sc.nextLine();
			num = Integer.valueOf(str);
			orig=num;
			
			//System.out.println(num);
			char[] ca = str.toCharArray();
			int len = ca.length;
			int total=0;
			int rem;
			while ((rem=num%10) != 0){
				num /= 10;
				int d_total=1;
				for (int j=0; j< len; j++){
					d_total *= rem;
					System.out.println("d_total  " + d_total);
				}
				total += d_total;
			}
			System.out.println("total " + total);
			if (total == orig){
				System.out.println("this is an Armstrong number");
			}
			
			System.out.println("enter num: ");
		}
		System.out.println("exit ");
		sc.close();
	}

}
