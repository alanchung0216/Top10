package com.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class first_non_repeat_char {
	public static char first_non_rep_char_lh(String s) {
		// use LinkedHashMap which will maintain order
		// this save one loop
		HashMap<Character, Integer> lh = new LinkedHashMap<>();
		char[] ca = s.toCharArray();
		for (int i=0; i<ca.length; i++){
			if (lh.containsKey(ca[i])) {
				lh.put(ca[i], lh.get(ca[i])+1);
				
			} else {
				lh.put(ca[i], 1);
			}
		}
		Set<Map.Entry<Character,Integer>> entry = lh.entrySet();
		for (Map.Entry<Character,Integer> e: entry){
			if (e.getValue() == 1) return e.getKey();			
		}
		//return (char) ' ';
		throw new RuntimeException("didn't find any non repeated Character");

	}
	public static char first_non_rep_char(String s){
		// assign count into Hash Entry pair
		HashMap<Character,Integer> hm = new HashMap<>();
		for (int i=0; i<s.length(); i++){
			if (hm.containsKey(s.charAt(i))) {
				hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
			} else
				hm.put(s.charAt(i), 1);
		}
		for (int i=0; i<s.length(); i++){
			if (hm.get(s.charAt(i)) == 1) return s.charAt(i);
		}
		return (char) ' ';
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "GeeksforGeeks"; // answer should be f
		//String str = "GeeksGeeks"; // throw exception
		System.out.println(first_non_rep_char_lh(str));
		System.out.println(first_non_rep_char(str));
	}

}
