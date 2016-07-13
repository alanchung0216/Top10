package com.sort;

public class bubble_sort {
	
	public static String bubble(int[] ia){
		for (int i=0; i<ia.length; i++){
			for (int j=i+1; j<ia.length; j++){
				if (ia[i] > ia[j]) {
					int temp = ia[i];
					ia[i] = ia[j];
					ia[j] = temp;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<ia.length; i++){
			sb.append(ia[i]).append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		int[] ia = {4,7,2,6};
		System.out.println(bubble(ia));

	}

}
