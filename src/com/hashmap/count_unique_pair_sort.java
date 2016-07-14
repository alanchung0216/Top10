package com.hashmap;

import java.util.Arrays;

/*
1) Initialize count as 0
2) Sort all numbers in increasing order.
3) Remove duplicates from array.
4) Do following for each element arr[i]
   a) Binary Search for arr[i] + k in subarray from i+1 to n-1.
   b) If arr[i] + k found, increment count. 
5) Return count. 
 */
public class count_unique_pair_sort {

	public static void main(String[] args) {
		
		int[] ia = {1, 4, 7, 40, 7, 46, 32};
		int k = 47;
		Arrays.sort(ia);
		for (int i=0; i<ia.length; i++){
			System.out.println(ia[i]);
		}		
		// eliminate duplicates
		int[] ib = new int[ia.length];
		ib[0] = ia[0];
		int pre = ia[0];
		for (int i=1, j=1; i<ia.length; i++, j++){
			if (ia[i] == pre) {
				j--;
				continue;
			} else{
				ib[j] = ia[i];
				pre = ia[i];
			}
		}
		System.out.println();
		for (int i=0; i<ib.length; i++){
			System.out.println(ib[i]);
		}
		// find non zero count
		int count = 0;
		for (int i=0; i<ib.length ; i++)
			if (ib[i] != 0) count++;
		int[] ic = new int[count];
		for (int i=0; i<ic.length; i++) {
			ic[i] = ib[i];
		}
		System.out.println();
		for (int i=0; i<ic.length; i++){
			System.out.println(ic[i]);
		}		
	}

}
