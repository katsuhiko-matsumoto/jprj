package jprj;

public class Thread1 {
	public static void main(String args[]) {
		StringBuffer shareString = new StringBuffer();
		ShareSub s1 = new ShareSub(shareString);
		s1.start();
		for(int i = 0; i<=20; i++) {
			System.out.println("shareString = "+shareString);
		}
	}
	
}

class ShareSub extends Thread{
	StringBuffer buf;
	public ShareSub(StringBuffer buf) {
		this.buf = buf;
	}
	
	public void run() {
		System.out.println("sub start");
		buf.append("sub end");
	}
}
