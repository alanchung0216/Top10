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
      return Integer.valueOf(this.code) ^ Integer.valueOf(this.number); 
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
      if ((this.code != other.code) || (this.number != other.number))
         return false;
      return true;
   }
} 

public class HashSet_equality {
	public static void main(String[] args) {
		HashSet<PhoneNumber> set = new HashSet<PhoneNumber>();
		set.add(new PhoneNumber("732", "4083241"));
		set.add(new PhoneNumber("732", "4083241"));
		//set.add(new PhoneNumber("732", "4083242"));
		System.out.println(set.size()); // will it return 1 or 2 ? 
										// answer is 2 if no overwrite equals and hashcode
										// because super.hashcode will create two different
										// hashcode ( two "new" will create objects on two memory heap
										// locations) which will fall into two different buckets.
										// That means two different key objects so the count is two
										// (which is wrong!!!)
										// correct answer should be 1 after we overwrite equals and hashcode 
										// and hashcode return (area code^phone number) and  this will cause
										// my equals to be called
		
		System.out.println(new PhoneNumber("732", "408-3241"));

	}
}

