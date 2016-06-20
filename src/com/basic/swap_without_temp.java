package com.basic;

class myInt {
	public int n;
}

public class swap_without_temp {
	// this is pass by value because a and b are primitive int
	// in java non object is pass by value
	public static void swap_no_temp(int a, int b){
		// a 10, b 4
		a = a + b;
		b = a - b; // b 10
		a = a - b; // a 4
	}
	// this is pass by reference. in Java you need to pass object to
	// be pass by reference
	public static void swap_no_temp_reference(myInt A, myInt B){
		// A.n 10, B.n 4
		A.n = A.n + B.n;
		B.n = A.n - B.n;
		A.n = A.n - B.n;
	}
	// this is pass by reference. in Java you need to pass object to
	// be pass by reference
	public static void swap_reference(myInt A, myInt B){
		// A 10, B 4
		int temp;
		temp = A.n;
		A.n = B.n;
		B.n = temp;
	}	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		int b=4;
		System.out.println("before a " + a + " b " + b);
		swap_no_temp(a, b);
		System.out.println("after a " + a + " b " + b);
		
		System.out.println("swap failed because call by value " +
							"with primitive"+"\n");
		System.out.println("try again using call by value " + 
							"using object \"myInt\" containing " +
							"the primitive \"int\"");
		myInt A = new myInt();
		myInt B = new myInt();
		A.n = 10;
		B.n = 4;
		System.out.println("before A " + A.n + " B " + B.n);
		swap_reference(A, B);
		System.out.println("after A " + A.n + " B " + B.n);		
		System.out.println("\nswap without using temp");
		System.out.println("before A " + A.n + " B " + B.n);
		swap_no_temp_reference(A, B);
		System.out.println("after A " + A.n + " B " + B.n);				
	}
}
