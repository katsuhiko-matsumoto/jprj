package jprj;

public class Thread5 extends Thread {
	public static Object obj;
	boolean isInterrupt = false;
	public static void main(String args[]) {
		obj = new Object();
		Thread5 t5 = new Thread5();
		t5.start();
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			
		}
		t5.interrupt();//wait中に割り込み
		
	}
	
	//interruptメソッドのおーばライド
	public void interrupt() {
		//フラグ処理追加してみる
		isInterrupt = true;
		super.interrupt();
	}
	
	public void run() {
		//for(;;) {
			try {
				synchronized(obj) {
					obj.wait();
				}
			}catch(InterruptedException e) {
				System.out.println("Interrupted!");
				System.out.println("isInterrupt:"+isInterrupt);
			}
		//}
	}
}
