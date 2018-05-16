package jprj;

public class Logic {
	
	public static void main(String args[]) {
		int[] n = {9,4,5,8,2,3,1,7,6,0};
		int[] nn = {5,0,20,15,30,60,50};
		Logic l = new Logic();
		n = l.bubbleSort(n);
		int[] n2 = l.quickSort(nn,0,nn.length-1);
		for(int i = 0; i < n2.length; i++) {
			System.out.print(" "+n2[i]);
		}
		System.out.println("");
		System.out.println(l.matchArray(n, n2));
		System.out.println(l.search2buntansaku(n,5));
		System.out.println(l.search2buntansaku(n,11));
		System.out.println(l.recursive(6));
		System.out.println(l.isSosuu(31));
	}
	
	public boolean matchArray(int[] n, int[] m) {
		if(n == null || m == null) {
			return false;
		}
		if(n.length != m.length) {
			return false;
		}
		for(int i = 0; i < n.length; i++) {
			if(n[i] != m[i]) {
				return false;
			}
		}
		return true;
	}
	
	//sort : bubble sort, quick sort
	public int[] bubbleSort(int[] n) {
		for(int i = 0; i < n.length-1; i++) {
			for(int j = i+1; j < n.length; j++) {
				if(n[i] > n[j]) {
					int tmp = n[i];
					n[i] = n[j];
					n[j] = tmp;
				}
			}
		}
		for(int i = 0; i < n.length; i++) {
			System.out.print(" "+n[i]);
		}
		System.out.println("");
		return n;
	}
	
	public int[] quickSort(int[] n, int left, int right) {
		int i,j,s,tmp;
		//System.out.println(""+left+" "+right);
		if(left < right) {
			s = n[left];
			i = left;
			j = right;
			while(true) {
				System.out.println(""+i+" "+j);
				while(n[++i]<s);
				while(n[--j]>s);
				if(i >= j) break;
				tmp=n[i];
				n[i] = n[j];
				n[j] = tmp;
			}
			n[left]= n[j];
			n[j] =s;
			
			n = this.quickSort(n,left,j-1);
			//n = this.quickSort(n,j+1,right);
			
		}
		return n;
	}
	
	//search : 2bun tansaku
	public boolean search2buntansaku(int[] n, int search) {
		int low=0;
		int high = n.length-1;
		int mid;
		while(low <= high) {
			mid = (low+high)/2;
			if(n[mid] == search) {
				return true;
			}
			if(n[mid] < search) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return false;
	}
	
	public boolean searchBanpei(int[] n, int search) {
		for(int i = 0; i < n.length; i++) {
			if(n[i] == search) {
				return true;
			}
		}
		return false;
	}
	
	//recursive　階乗
	public int recursive(int n) {
		if (n <= 1) {
			return n;
		}
		return n*this.recursive(n-1);
	}
	
	//soinsuu bunkai
	public boolean isSosuu(int n) {
		int flg = 0;
		for(int i =2; i <= n; i++) {
			if (n % i == 0) {
				flg++;
			}
		}
		if(flg == 1) {
			return true;
		}else {
			return false;
		}
	}
}
