package com.string;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

//count all distinct subsets of strings


public class counting_substrings {
	public static int count_substring(String s){
		// no need LinkedHashSet,only if we care about order
		//Set<String> lhs = new LinkedHashSet<String>(); 
		Set<String> lhs = new HashSet<String>();
		for (int i=0; i<s.length(); i++){
			for (int j=i; j<s.length(); j++)
				// if they ask only palindrome substring
				// if (isPalidrime(s.substring(i,j+1))
				lhs.add(s.substring(i,j+1));
		}
		return lhs.size();
	}
	
	public static int count_substring_recur(String s){
		// to be done
		return 1;
	}
	public static void main(String[] args) {
		String str = "Hee";
		System.out.println(count_substring(str));

	}

}
