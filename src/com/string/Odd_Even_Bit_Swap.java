package com.string;

import java.util.ArrayList;
import java.util.List;

public class Odd_Even_Bit_Swap {
	public static int even_odd_swap(int n){
		int even = n & 0xAAAAAAAA;
		int odd = n & 0x55555555;
		even = even >> 1;
		odd = odd << 1;
		return even | odd;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 7; // 0111 -> 1011
		System.out.println(even_odd_swap(i));
	}

}
