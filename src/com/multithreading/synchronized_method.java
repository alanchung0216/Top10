package com.multithreading;

class shareData {
	int value;
	shareData(int i){
		value=i;
	}
}
class myThread extends Thread {
	private String name;
	private shareData sd;
	myThread(String name, shareData sd){
		this.name = name;
		this.sd = sd;
	}
	public void run() {
		int i=0;
		while (i < 10){

			increment();
			/* this delay will cause problem
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			int ret = getValue();
			System.out.println(" Thread "+Thread.currentThread().getName()
					+" "+name+" increment value "+ ret);
			i++;
		}
	}
	public synchronized int increment() {
		return sd.value++;
	}
	public synchronized int getValue() {
		return sd.value;
	}	
}
public class synchronized_method {

	public static void main(String[] args) {
		shareData sd = new shareData(0);
		Thread ta = new Thread(new myThread("A",sd));
		Thread tb = new Thread(new myThread("B",sd));
		ta.start();
		tb.start();

	}

}
