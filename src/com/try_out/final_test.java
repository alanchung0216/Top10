package com.try_out;

class dataset {
	int da;
	dataset(int i){
		da=i;
	}
}
public class final_test {
	final static dataset num = new dataset(7);
	final static int num1 = 2;
	static int num2 = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num.da = 10; //ok
		//num = new dataset(8); //not ok
		//num1 = 5; // not ok;
		num2 = 7; // ok
	}

}
