package com.try_out;

import java.util.ArrayList;
import java.util.List;

class producer implements Runnable {
	List<Integer> li;
	int size;
	producer(List<Integer> list, int size){
		li = list;
		this.size = size;
	}
	public void run() {
		// write some data into 
		for (int i=0; i<10; i++){
			System.out.println("producer: "+i);
			while (li.size() == size) {
				synchronized(li){
					// let's wait and for to be notified
					try {
						System.out.println(" producer waiting");
						li.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}										
			}
			synchronized (li) {
				li.notifyAll();
				li.add(i);	
			}
		}
	}
	
}

class consumer implements Runnable {
	List<Integer> li;
	consumer(List<Integer> list){
		li = list;
	}
	public void run() {
		// read data when data available
		while (true) {
			while (li.isEmpty()) {
				synchronized(li){
					// let wait and to be notified
					try {
						System.out.println(" consumer waiting");
						li.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//break;
			}
			synchronized(li){
				li.notifyAll();
				int n = li.remove(0);
				System.out.println("consumer: "+n);				
			}
			// add delay so that we can cause producer waiting
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
		
		List<Integer> list = new ArrayList<>();
		Thread tp = new Thread(new producer(list, 5));
		Thread tc = new Thread(new consumer(list));
		tc.start();
		tp.start();
	}
}