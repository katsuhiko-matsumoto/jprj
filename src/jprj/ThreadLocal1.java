package jprj;

public class ThreadLocal1 {
	static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	public static void test() {
		Integer num = (Integer)threadLocal.get();
		if(num == null) {
			num = new Integer(0);
		}
		num = new Integer(num.intValue()+1);
		System.out.println(Thread.currentThread().getName()+" : "+num.intValue());
		
		threadLocal.set(num);
	}
	public static void main(String args[]) {
		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		t1.start();
		t2.start();
	}
}

class MyThread extends Thread{
	MyThread(String name){
		super(name);
	}
	
	public void run() {
		for(;;) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
			ThreadLocal1.test();
		}
	}
}
