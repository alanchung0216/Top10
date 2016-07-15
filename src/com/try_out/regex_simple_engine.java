package com.try_out;

public class regex_simple_engine {
	
// not done - incorrect
// need recursive implementation
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "cassst";
		String pat = "c*t"; // dog will fail
		boolean result = true;
		char[] ca = input.toCharArray();
		char[] p = pat.toCharArray();
		for (int i=0; i<p.length; i++){
			for (int j=0; j<ca.length; j++){
				if (p[i] == '*') {
					result = true;
					break;
				}
				if (p[i] != ca[j]) {
					result = false;
					break;
				}
			}
			if (result == false){
				break;
			}
		}
		if (result) 
			System.out.println("YES");
		else
			System.out.println("NO");

	}
}
