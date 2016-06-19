package com.algorithm;

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
	}

}
