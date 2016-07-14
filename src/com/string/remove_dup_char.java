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
/* another approach
import java.util.Arrays;
 
public class RemoveDuplicatesJavaExample 
{   
    static void removeDuplicates(int[] arrayWithDuplicates)
    {
        System.out.println("Array With Duplicates : ");
         
        for (int i = 0; i < arrayWithDuplicates.length; i++)
        {
            System.out.print(arrayWithDuplicates[i]+"\t");
        }
         
        //Assuming all elements in input array are unique
         
        int noOfUniqueElements = arrayWithDuplicates.length;
         
        //Comparing each element with all other elements
         
        for (int i = 0; i < noOfUniqueElements; i++) 
        {
            for (int j = i+1; j < noOfUniqueElements; j++)
            {
                //If any two elements are found equal
                 
                if(arrayWithDuplicates[i] == arrayWithDuplicates[j])
                {
                    //Replace duplicate element with last unique element
                     
                    arrayWithDuplicates[j] = arrayWithDuplicates[noOfUniqueElements-1];
                     
                    //Decrementing noOfUniqueElements
                     
                    noOfUniqueElements--;
                     
                    //Decrementing j
                     
                    j--;
                }
            }
        }
         
        //Copying only unique elements of arrayWithDuplicates into arrayWithoutDuplicates
         
        int[] arrayWithoutDuplicates = Arrays.copyOf(arrayWithDuplicates, noOfUniqueElements);
         
        //Printing arrayWithoutDuplicates
         
        System.out.println();
         
        System.out.println("Array Without Duplicates : ");
         
        for (int i = 0; i < arrayWithoutDuplicates.length; i++)
        {
            System.out.print(arrayWithoutDuplicates[i]+"\t");
        }
         
        System.out.println();
         
        System.out.println("==============================");
    }
     
    public static void main(String[] args) 
    {        
        removeDuplicates(new int[] {4, 3, 2, 4, 9, 2});
         
        removeDuplicates(new int[] {1, 2, 1, 2, 1, 2});
         
        removeDuplicates(new int[] {15, 21, 11, 21, 51, 21, 11});
         
        removeDuplicates(new int[] {7, 3, 21, 7, 34, 18, 3, 21});
    }    
} 
*/