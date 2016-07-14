package com.multithreading;

import java.util.ArrayList;
import java.util.List;

class producer implements Runnable {
	private final List<Integer> sharedQueue;
	private final int SIZE;
	producer(List<Integer> l, int sz){
		sharedQueue = l;
		SIZE = sz;
	}
	public void run() {
		// add data into queue
		for (int i=0; i<8; i++){
			while (sharedQueue.size() == SIZE) {
				synchronized(sharedQueue){
					System.out.println(" producer waiting");
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
			}
			synchronized(sharedQueue){
				sharedQueue.notifyAll();
				sharedQueue.add(i);
				System.out.println("add "+i
				+" and size is "+sharedQueue.size());
			}
			/*
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			
		}		
	}
}

class consumer implements Runnable {
	
	private final List<Integer> sharedQueue;
	
	consumer(List<Integer> l){
		sharedQueue = l;
	}
	public void run() {
		while (true){
			while (sharedQueue.isEmpty()) {
				synchronized(sharedQueue){
					System.out.println(" consumer waiting");
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//break;
			}
			synchronized(sharedQueue){
				//int rem = sharedQueue.get(0);
				sharedQueue.notifyAll();
				sharedQueue.remove(0);
				System.out.println("remove and size is "
						+sharedQueue.size());
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

public class P_C_wait_notify_ArrayList {

	public static void main(String[] args) {

		// create a queue
		List<Integer> queue = new ArrayList<Integer>();
		Thread tp = new Thread(new producer(queue, 4));
		Thread tc = new Thread(new consumer(queue));
		tc.start();
		tp.start(); // this one first works  if it sleep a little

	}
}