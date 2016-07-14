package com.hashmap;

import java.util.HashSet;
import java.util.Set;

class pair {
	int i;
	int j;
	int k;
	pair(int i, int j, int k) {
		this.i = i;
		this.j = j;
		this.k = k;
	}
	int hashcode() {
		return Integer.valueOf(this.i*this.j+1311);
	}
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		pair other = (pair) obj;
		if (((this.i + this.j) == this.k) &&
			((other.i + other.j) == other.k)) { // differ pairs but same result
			return true;
		}
		if ((this.i != other.i) || (this.j != other.j)) return false;

		return true;
	}
}


public class count_unique_pair {
	static int find_pair(int[] A, int k) {
		Set<pair> hs = new HashSet<pair>();
		for (int i=0; i<A.length; i++) {
			for (int j=i+1; j<A.length; j++) {
				if ((A[i] + A[j]) == k) {
					pair p = new pair(A[i],A[j],k);
					hs.add(p);
				}
			}
		}
		return hs.size();
	}

	public static void main(String[] args) {
		int[] ia = {1, 4, 7, 40, 7, 46, 32};
		int k = 47;
		System.out.println(find_pair(ia,k));  // result should be 1 but I got 3.
	}
}
