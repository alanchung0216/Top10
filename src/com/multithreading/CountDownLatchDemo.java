package com.multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * Java Program to demonstrate how to use CountDownLatch, Its used when a thread
 * needs to wait for other threads before starting its work.
 * 
 * @author Javin Paul
 */
/*
CountDowaLatch is a high-level synchronization utility which is 
used to prevent a particular thread to start processing until all 
threads are ready. This is achieved by a countdown. The thread, 
which needs to wait for starts with a counter, each thread them 
make the count down by 1 when they become ready, once the last 
thread call countDown() method, then the latch is broken and the 
thread waiting with counter starts running. CountDownLatch is a 
useful synchronizer and used heavily in multi-threaded testing.
 You can use this class to simulate truly concurrent 
 behavior i.e. trying to access something at the same time once 
 every thread is ready. Worth noting is that CountDownLatch starts 
 with a fixed number of counts which cannot be changed later, 
 though this restriction is re-mediated in Java 7 by introducing 
 a similar but flexible concurrency utility called Phaser.

There is another similar utility called CyclicBarrier, which can 
also be used in this situation, where one thread needs to wait 
for other threads before they start processing. Only difference 
between CyclicBarrier and CountDownLatch is that you can reuse 
the barrier even after its broker but you cannot reuse the count 
down latch, once count reaches to zero.

Mastering Concurrency is not easy but if you seriously wants
 to become an expert Java programmer, you got to tame this horse. 
 One thing which can help you in your journey is the 
 Brian Goetz classic, Java Concurrency in Practice. 
 One of the most recommended book for Java programmer.


How to use CountDownLatch in Java?
Theory is easy to read but you cannot understand it until you 
see it live in action, this is even more true with concurrency 
and multi-threading. So let's see how to use CountDownLatch in 
Java with a simple demo. In this example, we have a main thread 
which is required to wait until all worker thread finished their
 task. In order to achieve this, I have created a CountDownLatch
  with number of count equal to 4, which is the total number of 
  worker threads. I then passed this CountDownLatch to each 
  worker thread, whenever they complete their task, they 
  call countDown() method, once last worker thread calls the 
  countDown() method then the latch is broken and main thread 
  which has been waiting on latch start running again and 
  finished its execution.

 */
public class CountDownLatchDemo {

    public static void main(String args[]) throws InterruptedException {
        
        CountDownLatch latch = new CountDownLatch(4);
        Worker first = new Worker(1000, latch, "WORKER-1");
        Worker second = new Worker(2000, latch, "WORKER-2");
        Worker third = new Worker(3000, latch, "WORKER-3");
        Worker fourth = new Worker(4000, latch, "WORKER-4");
        
        first.start();
        second.start();
        third.start();
        fourth.start();
        
        // Main thread will wait until all thread finished
        latch.await();
        
        System.out.println(Thread.currentThread().getName() + " has finished");

    }

}

class Worker extends Thread {
    private int delay;
    private CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch, String name) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " has finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/*
Output
WORKER-1 has finished
WORKER-2 has finished
WORKER-3 has finished
WORKER-4 has finished
main has finished

If you call latch.await() again, after count reaches to zero, 
it will not stop the main thread again, neither it will throw 
any Exception, it will just pass through it, as shown below :

// Main thread will wait until all thread finished
latch.await();
        
System.out.println(Thread.currentThread().getName() + " has started running again");
        
latch.await();
System.out.println(Thread.currentThread().getName() + " has finished");

Output
main has started running again
main has finished

This is where CountDownLatch is different than CyclicBarrier 
because you can reuse the barrier to stop the thread even 
after barrier is broken.

*/
