package jprj;

public class SynchTest {
	private int coin1;
	private int coin5;
	
	private Object lock1;//lock for coin1
	private Object lock5;//lock for coin5
	
	SynchTest(){
		coin1 = 0;
		coin5 = 0;
		lock1 = new Object();
		lock5 = new Object();
		
	}
	
	//追加、減算処理含めて、直列化されるので、
	//複数スレッドで同時処理が起きても不整合がなくなる。
	//複数ロックする場合は、デッドロックの危険があるため、シリアルを振って、決まった順番でロックをかける。
	
	//object lock version
	public void add1() {
		synchronized(lock1) {
			coin1++;
		}
	}
	
	public void del1() {
		synchronized(lock1){
			if(coin1 >=1) coin1--;
		}
	}
	
	public void add5() {
		synchronized(lock5) {
			coin5++;
		}
	}
	
	public void del5() {
		synchronized(lock1){
			if(coin5 >=1) coin5--;
		}
	}
	
	//method version
	public synchronized void test() {
		System.out.println("call test");
		//todo
	}
	//上記と同義
	public void test2() {
		synchronized (this) {
			//todo
		}
	}
		
}
