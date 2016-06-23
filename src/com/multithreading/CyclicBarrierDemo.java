package com.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	/**
	 * Java Program to demonstrate how to use CyclicBarrier, Its used when number of threads
	 * needs to wait for each other before starting again.
	 * 
	 * @author Javin Paul
	 */
/*
You just cannot understand concurrency without an example, 
seeing is believing here. It's difficult to comprehend words 
like worker thread, parties, waiting for each other at a point, 
until you see it live in action. In this program, we have four 
worker threads and one main thread, which is running your main method. 
We have an object of CyclicBarrier, which is initialized with 
parties = 4, the argument we passed in CyclicBarrier constructor 
is nothing but number of party, which is actually number of 
threads to stop at barrier. The barrier will not be broken 
until all parties are arrived. A party (thread) is said to be 
arrived with it call barrier.await() method.

In our example setup, we have given each worker thread a 
different name, starting from PARTY-1 to PARTY-4 just to 
have a meaningful output. We have passed the same instance
 of the cyclic barrier to each thread. If you look at their 
 Runnable implementation, you will find that each party sleep 
 for some seconds and then call await() method on the barrier.

The sleep is introduced so that every thread calls barrier method 
after some time.  Sleep time is also in increasing order, which 
means PARTY-4 should be the last one to call await. So as per 
our theory, every thread (party) should wait after calling 
await() until the last thread (PARTY-4) calls the await() method, 
after that every thread should wake up and start processing.

Of-course they need to compete for CPU and they will start 
running once they got the CPU from thread scheduler, but what 
is more important is that once the barrier is broken, each 
thread (party) becomes eligible for scheduling. By the way, 
you can reuse the barrier even after its broken this is where 
CyclicBarrier is different than CountDownLatch.


Read more: http://java67.blogspot.com/2015/06/how-to-use-cyclicbarrier-in-java.html#ixzz4CPuTuHXY

 */
	    public static void main(String args[]) throws InterruptedException, BrokenBarrierException {
	        
	        CyclicBarrier barrier = new CyclicBarrier(4);
	        Party first = new Party(1000, barrier, "PARTY-1");
	        Party second = new Party(2000, barrier, "PARTY-2");
	        Party third = new Party(3000, barrier, "PARTY-3");
	        Party fourth = new Party(4000, barrier, "PARTY-4");
	        
	        first.start();
	        second.start();
	        third.start();
	        fourth.start();
	        
	        System.out.println(Thread.currentThread().getName() + " has finished");

	    }

	}

	class Party extends Thread {
	    private int duration;
	    private CyclicBarrier barrier;

	    public Party(int duration, CyclicBarrier barrier, String name) {
	        super(name);
	        this.duration = duration;
	        this.barrier = barrier;
	    }

	    @Override
	    public void run() {
	        try {
	            Thread.sleep(duration);
	            System.out.println(Thread.currentThread().getName() + " is calling await()");
	            barrier.await();
	            System.out.println(Thread.currentThread().getName() + " has started running again");
	        } catch (InterruptedException | BrokenBarrierException e) {
	            e.printStackTrace();
	        }
	    }
	}

/*
	Output
	main has finished
	PARTY-1 is calling await()
	PARTY-2 is calling await()
	PARTY-3 is calling await()
	PARTY-4 is calling await()
	PARTY-4 has started running again
	PARTY-1 has started running again
	PARTY-2 has started running again
	PARTY-3 has started running again
	
If you look at the output is exactly matches with our theory. 
Each worker thread (PARTY 1 - 3) calls the await() method and then 
they stop processing until PARTY-4 comes and call await() method,
 after that every thread gets a wake up call and started execution 
 again, depending upon when they are scheduled by Java thread 
 scheduler.

This is how CyclicBarrier class works. You can still reuse the 
barrier object and if a thread calls barrier.await() again, 
it will wait for four worker thread before it gets wake up call. 
By the way,  If barrier is broken before a thread calls await() 
then this method will throw BrokenBarrierException. See Core 
Java Volume 1 - Fundamentals by Cay S. Horstmann to learn more 
about these higher level concurrency utilities in Java.
*/

