package com.multithreading;

class sharedData {
	public int value;
}
class sharedName {
	public int name;
}

class thread_A implements Runnable {
	sharedData data;
	sharedName name;
	thread_A(sharedData sd, sharedName name){
		data = sd;
		this.name = name;	
	}
	public void run(){
		synchronized(data) {
			data.value = 1;
			System.out.println("A updated shared value "+data.value);
			synchronized(name){
				name.name = 5;
				System.out.println("A updated shared name "+name.name);			
		}
		}
	}
}
class thread_B implements Runnable {
	sharedData data;
	sharedName name;
	thread_B(sharedData sd, sharedName name){
		data = sd;
		this.name = name;		
	}
	public void run(){
		// without adding delay 10 ms here, data.value was random.
		// we saw "A updated shared value 2" all the time.
		// we need to add synchronization to make sure value is
		// predictable. therefore we need to make sure no dead lock
		// situation
		//try {
		//	Thread.sleep(10);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
		
		// note that below caused deadlock
		//	thread B got name OK and want to print data
		// but thread A not rlease data yet. B is waiting for data
		// B is not release name yet.
		// thread A got data OK  and want to print name but
		// no release data yet. A is waiting for name, deadlock
		
		// solution is to just move 
		//synchronized(data){
		//	data.value = 2;
		//	System.out.println("B updated shared value "+data.value);
		//}
		// outside of synchronized(name){}
		// note we don't need to do the same for Thread A run().
		synchronized(name){
			name.name = 6;
			System.out.println("B updated shared name "+name.name);			
			synchronized(data){
				data.value = 2;
				System.out.println("B updated shared value "+data.value);
			}
		}
		
	}
}

public class prevent_deadlock {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// create sharedData
		sharedData da = new sharedData();
		sharedName na = new sharedName();
		
		// create threads
		
		Thread  ta = new Thread(new thread_A(da, na));
		Thread  tb = new Thread(new thread_B(da, na));
		ta.start();
		tb.start();		
	}

}
