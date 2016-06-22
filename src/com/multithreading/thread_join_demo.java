package com.multithreading;

class EventThread implements Runnable {
	String name;
	int sleep;
	EventThread(String nm, int sleep) {
		name = nm;
		this.sleep = sleep;
	}
	public void run() {
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" Thread "
							+ name + " sleep " + sleep+"ms");
	}
}

public class thread_join_demo {
/*
To quote from the Thread.join() method javadocs:

	Waits for this thread to die.
	
So the thread that is running your example code 
(the main thread) calls t1.join() to wait (main thread stops) 
for the t1 thread to finish. Then it calls t2.join() 
to wait (main thread stops) for the t2 thread to finish. 
The 2 threads have been running in parallel but the 
thread that started them (again, the main thread) needs 
to wait for them to finish before continuing. 
That's a common pattern.

In terms of the try/catch, the join() throws InterruptedException 
meaning that the thread that is calling join() was interrupted. 
In this case the main thread would be the one that might be 
interrupted by another thread.

by proving two thread running parallel and I saw 
"t1 join done" displayed after 10 second first 
then 1 second later I saw "t2 join done" 

 */

	public static void main(String[] args) {
		Thread t1 = new Thread(new EventThread("e1",10000));
		t1.start();
		Thread t2 = new Thread(new EventThread("e2",11000));
		t2.start();
		while (true) {
		   try {
		      t1.join();
		      System.out.println("t1 join done");
		      t2.join();
		      System.out.println("t2 join done");
		      break;
		   } catch (InterruptedException e) {
		      e.printStackTrace();
		   }
		}		
	}
}
