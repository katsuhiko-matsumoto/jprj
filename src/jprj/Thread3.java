package jprj;

public class Thread3 extends Thread{
	
	public static void main(String args[]) {
		
		Thread3 t3 = new Thread3();
		t3.start();
		//thread 終了を待つ join(本流と、スレッドが交流する＝join)
		try {
			t3.join();
		}catch(InterruptedException e) {}
		System.out.println("Thread stopped");
	}
	
	public void run() {
		System.out.println("start");
		for(int i = 0; i< 10000; i++) {
			//nothing todo
		}
		System.out.println("Thread in roop is end");
	}
}
