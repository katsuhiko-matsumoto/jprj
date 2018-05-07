package jprj;

public class Thread2 implements Runnable{
	public static void main(String args[]) {
		Thread2 t2 = new Thread2();
		Thread t = new Thread(t2);
		t.start();
		
		//innner
		Thread tt = new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName()+" called from inner run method");
			}
		};
		tt.start();
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" called from run method");
	}
}
