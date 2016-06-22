package com.multithreading;

class threadA implements Runnable {
	sharedData data;
	threadA(sharedData sd){
		data = sd;
	}
	public void run(){
		synchronized(data) {
			data.value = 1;
			System.out.println("A updated shared value "+data.value);			
		}
	}
}

class threadB implements Runnable {
	sharedData data;
	threadB(sharedData sd){
		data = sd;		
	}
	public void run(){	
		synchronized(data){
			data.value = 2;
			System.out.println("B updated shared value "+data.value);
		}
	}
}

public class synchronized_block {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// create sharedData
		sharedData da = new sharedData();
		
		// create threads
		
		Thread  ta = new Thread(new threadA(da));
		Thread  tb = new Thread(new threadB(da));
		ta.start();
		tb.start();		
	}

}
