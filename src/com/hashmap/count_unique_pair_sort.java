package com.hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

// this approach does not use hashcode/equals
// but it's clean solution
		
// first we  use HashSet to remove duplicates
		

		int[] id = {1, 4, 7, 40, 7, 46, 32};
		int k = 47;
		Set<Integer> hs = new HashSet<Integer>();
		for (Integer i:id){
			hs.add(i);
		}
		// copy set to ik array
		int[] ik = new int[hs.size()];
		Iterator<Integer> iter = hs.iterator();
		int m=0;
		while (iter.hasNext()){
			ik[m] = iter.next();
			m++;
		}

		// we then sort ik
		Arrays.sort(ik);

		// finally it's an easy part
		// simple walk through array to find
		// if items added is 47
		int count=0;
		for (int i=0; i<ik.length; i++) {
			for (int j=i+1; j<ik.length; j++){
				if ((ik[i] + ik[j]) == k){
					count++;
				}				
			}
		}
		System.out.println("count " + count);

	}

}
