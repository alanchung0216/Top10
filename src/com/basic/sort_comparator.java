package com.basic;

import java.util.Comparator;

/*
Write a Comparator in Java to compare two employees based upon 
there name, departments and age?
This is pure Java based Coding exercise. In order to solve this 
Java coding or programming interview question you need to know 
What is comparator in Java and How to use compare method in Java 
for sorting Object. Sorting is one of the most logical and 
practical question on technical interview and ability to sort 
Java object is must to code in Java.  

This article 
	http://java67.blogspot.com/2012/10/
	how-to-sort-object-in-java-comparator-comparable-example.html

help you to solve this Java coding question by 
explaining how to sort object in Java using Comparable and Comparator. 
Just remember that Comparable has compareTo() method and use to 
sort object based upon there natural order e.g. numeric order 
for number, and alphabetic order for String, while Comparator 
can define any arbitrary sorting. A good follow up question can 
also be difference between Comparator and Comparable in Java, 
so be ready for that.


Read more: http://java67.blogspot.com/2012/08/10-java-coding-interview-questions-and.html#ixzz4BxhGhKWK
 */

import java.util.*;

class Dog implements Comparator<Dog>, Comparable<Dog>{
   private String name;
   private int age;
   Dog(){
   }

   Dog(String n, int a){
      name = n;
      age = a;
   }

   public String getDogName(){
      return name;
   }

   public int getDogAge(){
      return age;
   }

   // Overriding the compareTo method
   public int compareTo(Dog d){
      return (this.name).compareTo(d.name);
   }

   // Overriding the compare method to sort the age 
   public int compare(Dog d, Dog d1){
      return d.age - d1.age; // primitive can't use compareTo
   }
}

public class sort_comparator{

   public static void main(String args[]){
      // Takes a list o Dog objects
      List<Dog> list = new ArrayList<Dog>();

      list.add(new Dog("Shaggy",3));
      list.add(new Dog("Lacy",2));
      list.add(new Dog("Roger",10));
      list.add(new Dog("Tommy",4));
      list.add(new Dog("Tammy",1));
      Collections.sort(list);// Sorts the array list

      for(Dog a: list)//printing the sorted list of names
         System.out.print(a.getDogName() + ", ");

      // Sorts the array list using comparator
      Collections.sort(list, new Dog());
      System.out.println(" ");
      for(Dog a: list)//printing the sorted list of ages
         System.out.print(a.getDogName() +"  : "+
		 a.getDogAge() + ", ");
   }
}

/*
class employee implements Comparable {
	
	String name;
	String dept;
	int age;

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		employee ep = (employee) o;
		return this.name.compareTo(ep.name);
	}
	
}
class employee2 implements Comparator {
	
	String name;
	String dept;
	int age;
//	private static int compare(Object p1, Object p2) {
		public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		employee2 ep1 = (employee2) o1;
		employee2 ep2 = (employee2) o2;
		return ep1.age - ep2.age;
	}
	
}
public class sort_comparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		employee ep1 = new employee();
		ep1.name = "Alan";
		employee ep2 = new employee();
		ep2.name = "Grace";		
		if (ep1.compareTo(ep2) > 0)
			System.out.println(ep1.name + " greater than " + ep2.name);
		else if (ep1.compareTo(ep2) < 0)
			System.out.println(ep1.name + " less than " + ep2.name);
		else
			System.out.println(ep1.name + " equal " + ep2.name);	

		employee2 p1 = new employee2();
		p1.age = 62;
		employee2 p2 = new employee2();
		p2.age = 56;		
		if (compare((Object) p1, (Object) p2) > 0)
			System.out.println(p1.age + " older than " + p2.age);
		else if (compare(p1, p2) < 0)
			System.out.println(p1.age + " younger than " + p2.age);
		else
			System.out.println(p1.age + " equal " + p2.age);				
	}

	private static int compare(Object p1, Object p2) {
		// TODO Auto-generated method stub
		employee2 ep1 = (employee2) p1;
		employee2 ep2 = (employee2) p2;
		return ep1.age - ep2.age;		
	}

}
*/
