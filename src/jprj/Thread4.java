package jprj;
import java.util.*;

public class Thread4 extends Thread {
	private Vector<String> buf;
	Thread4(){
		buf = new Vector<String>();
	}
	
	public static void main(String args[]) {
		Thread4 t= new Thread4();
		t.start();
		for(;;) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
			t.add("test");
		}
	}
	
	public synchronized void add(String str) {
		buf.add(str);
		notify(); //スレッド再開通知
	}
	
	public void run() {
		for(;;) {
			synchronized(this) {
				System.out.println("buf.size:"+buf.size());
				try {
					wait(); //スレッド停止
				}catch(InterruptedException e) {
					
				}
			}
		}
	}
}
