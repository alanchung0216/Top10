package com.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class producer_blockingQ extends Thread {
	BlockingQueue sharedQueue;
	producer_blockingQ(BlockingQueue bq){
		sharedQueue = bq;
	}
	public void run() {
		for (int i=0; i<10; i++){
			try {
				sharedQueue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("producer put "+i+" to Blocking Queue"+
								" size "+sharedQueue.size());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class consumer_blockingQ extends Thread {
	BlockingQueue sharedQueue;
	consumer_blockingQ(BlockingQueue bq){
		sharedQueue = bq;
	}
	public void run() {
		while (true) {
			int i=0;
			try {
				i = (int) sharedQueue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("consumer take "+i+" from Blocking Queue"+
					" size "+sharedQueue.size());
		}
	}
}
public class P_C_BlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new LinkedBlockingQueue<Integer>(5);
		Thread tp = new Thread(new producer_blockingQ(bq));
		Thread tc = new Thread(new consumer_blockingQ(bq));
		tc.start();
		tp.start();
	}

}
