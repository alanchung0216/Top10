package com.string;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class remove_spaces_sentence {

	public static String remove_spaces(String s){
		char[] ca = s.toCharArray();
		List<Character> lc = new ArrayList<Character>();
		char pre=ca[0];
		if (ca[0] != ' ') lc.add(ca[0]);
		for (int i=0; i<s.length(); i++){
			if ((ca[i] != ' ') || ((pre != ' ') && (i != s.length()-1))) {
				lc.add(ca[i]);
			}			
			pre = ca[i];				
		}
		// convert ArrayList character to String
		StringBuffer sb = new StringBuffer(lc.size());
		for (Character c:lc){
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static String remove_spaces_1(String str) {
		
		String[] s = str.trim().split("\\s+"); // or "[ ]+"
		StringBuffer sb = new StringBuffer();
		for (int i=0; i< s.length; i++){
			if (i == s.length-1)
				sb = sb.append(s[i]);
			else
				sb = sb.append(s[i]).append(" ");
		}
		
		/* this works too
	        StringTokenizer st = new StringTokenizer(str, " ");
	        StringBuffer sb = new StringBuffer();
	        while(st.hasMoreElements()){
	            sb.append(st.nextElement()).append(" ");
	        }
		 */
		return sb.toString();
	}
	public static void main(String a[]){
	        String str = "  String    With Multiple      Spaces  ";
	        // this version work because regex match one space or more
	        System.out.println(remove_spaces(str));
	        System.out.println(remove_spaces_1(str));
	}
}

