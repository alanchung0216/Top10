package com.algorithm;

import java.util.Arrays;
import java.util.Collections;

public class binary_search {
	
	
	public static int binary_search_1(int[] ia, int key){
		int begin=0;
		int end=ia.length-1;
		while (begin <= end){
			int mid = (begin+end)/2;
			if (key == ia[mid]) 
				return mid;
			else if (key > ia[mid]) {
				begin = mid + 1;
			} else {
				end = mid -1;
			}
		}
		return -1;
	}

    public int binarySearch(int[] inputArr, int key) {
         
        int start = 0;
        int end = inputArr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == inputArr[mid]) {
                return mid;
            }
            if (key < inputArr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
  
    public static void main(String[] args) {
         
    	binary_search mbs = new binary_search();
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
        System.out.println("Key 14's position: "+mbs.binarySearch(arr, 14));
        int[] arr1 = {6,34,78,123,432,900};
        System.out.println("Key 432's position: "+mbs.binarySearch(arr1, 432));
        
        // alan added
        int[] ia = {8, 2, 10, 6, 12, 4, 16, 14};
        Arrays.sort(ia);
        System.out.println("Key 14 : " + binary_search_1(ia, 14));
    }
}

//Output:
//Key 14's position: 6
//Key 432's position: 4
