package com.hashmap;
import java.util.*;

class PhoneNumber {
	public String code;
	public String number;
	public PhoneNumber(String code, String number) {
	this.code = code;
	this.number = number;
	}

   @Override
   public int hashCode() {
      return Integer.valueOf(this.code);
   }

   public String toString() {
      return "Area Code : " + this.code;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      PhoneNumber other = (PhoneNumber) obj;
      if (this.code != other.code)
         return false;
      return true;
   }
} 

public class HashSet_equality {
	public static void main(String[] args) {
		HashSet<PhoneNumber> set = new HashSet<PhoneNumber>();
		set.add(new PhoneNumber("732", "408-3241"));
		set.add(new PhoneNumber("732", "408-3241"));
		System.out.println(set.size()); // will it return 1 or 2 ? 
										// answer is 2 if no overwrite equals and hashcode
										// answer is 1 after we overwrite equals and hashcode 
		
		System.out.println(new PhoneNumber("732", "408-3241"));

	}
}
