package com.design_pattern;

import com.design_pattern.single_by_threads.EasySingleton;

// this code is inspired from top 20 core java interview questions
// http://javarevisited.blogspot.com/2011/04/
//	top-20-core-java-interview-questions.html
// related to singleton question
// http://javarevisited.blogspot.com/2014/05/
//        double-checked-locking-on-singleton-in-java.html
class mySingleton {
	private static mySingleton instance;
	private int value;
	private mySingleton(){
		// private won't allow anyone to construct this object
		value = 5;
	}
	public static mySingleton getInstance() {
		if (instance == null){
			instance = new mySingleton();
		}
		return instance;
	}
	public int getValue(){
		return value;
	}
}
class single_by_threads {
	private static single_by_threads instance;
	private static single_by_threads instance_2;
	//private static volatile single_by_threads instance_3;
	private volatile static single_by_threads instance_3;
	private int value;
	private single_by_threads() {
		value = 8;
	}
	// version 1 - single lock check
	// this may create multiple instances if both threads
	// are checking the instance same time
	// solution: add synchronized on instance will solve it
	// but not efficient. see version 2
	public static single_by_threads getInstance(){
		if (instance == null) {
			instance = new single_by_threads();
		}
		return instance;
	}
	// version 2 - double lock check
	// this will solve version 1 by add
	// synchronized on instance on second check
	// note:first check should work most of time but
	// if not then test second lock will always work.
	// 
	// well , almost, it may still break 
	// see version 3
	
	public static single_by_threads getInstance_2(){
		if (instance_2 == null) {
			// does not work, causing NullPointerException
			// synchronized(instance_2){
			synchronized(single_by_threads.class){
				if (instance_2 == null){
					instance_2 = new single_by_threads();
				}
			}
		}
		return instance_2;
	}
	// version 3 - complete solution
	// double lock check with volatile control
	// this will solve version 2 by adding volatile that
	// will make sure writing variable need to complete totally
	// (not half way write as prior to java 1.5)
	// java 1.5 introduced volatile and that solved the issue.
	/*
	 Without volatile modifier it's possible for another thread in 
	 Java to see half initialized state of instance variable, 
	 but with volatile variable guaranteeing happens-before 
	 relationship, all the write will happen on volatile instance 
	 before any read of instance variable.

	 This was not the case prior to Java 5, and that's why double 
	 checked locking was broken before. Now, with happens-before 
	 guarantee, you can safely assume that this will work.

	 */

	
	public static single_by_threads getInstance_3(){
		if (instance_3 == null) {
			synchronized(single_by_threads.class){	
				if (instance_3 == null){
					instance_3 = new single_by_threads();
				}
			}
		}
		return instance_3;
	}
	// Singleton using Enum in Java
	// Very easy version
	// But I don't see any useful case to take advantage of
	// because if we want to use the object we still need to create
	// the object instance then we will need to use version 3 to
	// handle it.
	
	// This is the way we generally declare Enum Singleton , 
	// it may contain instance variable and instance method but 
	// for sake of simplicity I haven’t used any, just beware that 
	// if you are using any instance method than you need to ensure 
	// thread-safety of that method if at all it affect the state 
	// of object. By default creation of Enum instance is thread safe 
	// but any other method on Enum is programmers responsibility.
	
	// You can acess it by EasySingleton.INSTANCE, much easier than 
	// calling getInstance() method on Singleton.

	/**
	* Singleton pattern example using Java Enum
	*/
	public enum EasySingleton{
	    INSTANCE;
	}

	public int getValue(){
		return value;
	}
}
class myThread extends Thread {
	String name;
	myThread(String nm){
		name = nm;
	}
	public void run() {
		//single_by_threads ins = single_by_threads.getInstance();
		//single_by_threads ins = single_by_threads.getInstance_2();
		single_by_threads ins = single_by_threads.getInstance_3();
		
		EasySingleton ez = EasySingleton.INSTANCE;
		
		System.out.println("Thread "+name+" my first singleton "
							+ins+" value is "
							+ins.getValue());	
		System.out.println("Thread "+name+" easy singleton "
							+ez);
	}
}
public class singleton_DoubleCheckLock {

	public static void main(String[] args) {
		// this will work because there is only one main thread
		// to create this singleton. However if will fail if there
		// are multiple threads calling this getInstance
		mySingleton s = mySingleton.getInstance();
		System.out.println("Main - my first singleton "+s
							+" "+s.getValue());
		
		// test multi threads for singleton
		Thread ta = new Thread(new myThread("A"));
		Thread tb = new Thread(new myThread("B"));
		ta.start();
		tb.start();
	}

}
