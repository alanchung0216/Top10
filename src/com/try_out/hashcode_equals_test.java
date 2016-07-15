package com.try_out;
import java.util.*;

class PhoneNumber {

	public String code; // area code
	
	public String number;
	
	public PhoneNumber(String code, String number) {
	
	this.code = code;
	
	this.number = number;
	
	}



   @Override

   public int hashCode() {
	  
      return (Integer.valueOf((this.code))*1171);

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
public class hashcode_equals_test {

	public static void main(String[] args) {

	HashSet<PhoneNumber> set = new HashSet<PhoneNumber>();

	set.add(new PhoneNumber("732", "408-3241"));

	set.add(new PhoneNumber("732", "408-3241"));

	// without overwrite hashcode and equals
	// the return will be 2.
	
	// with hashcode and equals 
	// the return will be 1;
	System.out.print(set.size()); // will it return 1 or 2 ?
	System.out.println();
	System.out.println(new PhoneNumber("732", "408-3241"));

	}

}
