package com.string;

import java.util.LinkedHashSet;
import java.util.Set;

public class remove_dup_char {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "bananas"; // --> "bans"
		Set<Character> s = new LinkedHashSet<Character>();
		char[] ca = str.toCharArray();
		for (int i=0; i<ca.length; i++){
			if (s.contains(ca[i]) == false) {
				s.add(ca[i]);
			}
			// or we simply do
			// s.add(ca[i]) without the check because Set do not allow duplicates
			// this will work because ca[i] is char.
			
			// however if ca[i] is a user define object (ex PhoneBook)
			// then we need to overwrite hashcode() and equals() for HashSet
			// to validate the equality
		}
		for (Character c:s){
			System.out.printf("%c",c);
		}
	}

}
