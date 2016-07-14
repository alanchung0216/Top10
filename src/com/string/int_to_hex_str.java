package com.string;

import java.util.ArrayList;
import java.util.List;

public class int_to_hex_str {
	
	static char toHex(int num){
		char hx;
		switch (num) {
		case 10:
			hx = 'A';
			break;
		case 11:
			hx = 'B';
			break;
		case 12:
			hx = 'C';
			break;
		case 13:
			hx = 'D';
			break;
		case 14:
			hx = 'E';
			break;
		case 15:
			hx = 'F';
			break;
		default:
			hx = (char) (num + '0');
		}
		return hx;
	}

	static String convert(int num){
		// convert integer to hex
		//int q=0;
		int r=0;
		List<Character> lc = new ArrayList<Character>();
		StringBuilder sb = new StringBuilder();
		//while (num / 16 != 0){
		while (num != 0){
			r = num % 16;
			num = num / 16;
			//num = q;
			lc.add(toHex(r));
			sb.append(toHex(r));
		}
		//lc.add(toHex(q));
		char[] ca= new char[lc.size()];
		for (int i=0, j=lc.size()-1; i<lc.size(); i++, j--){
			ca[j] = lc.get(i);
		}
		return sb.toString();
		//return new String(ca);
	}
	public static void main(String[] args) {
		String str=convert(43);
		System.out.println("0x"+str);
	}

}
