package jprj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Start {
	public static void main(String args[]) {
		System.out.println("hello world.");
		
		
	}
	
	//todo////
	//interface
	//extend
	//implements
	//thread
	//synchronized
	//abstract
	//serializable -> SerializableTest
	
	//final
	//static -> instance化せずにりようできる
	
	//collection
	//マルチスレッドに対応したコレクション
	//public static List synchronizedList(List list)
	//public static Map synchronizedMap(Map m)
	//public static Set synchronizedSet(Set s)
	public void colTest() {
		List list = Collections.synchronizedList(new ArrayList<>());
	    list.add("Windows");
	    list.add("Linux");
	    list.add("OS X");
	    System.out.println(list);
	}
	//ArrayList
    //ArrayListは、内部的には配列を利用したリスト構造です。
	//標準的な配列と異なる点は、サイズを後からでも変更できる点です。
	//その性質上、インデックス値による値の読み書きは高速ですが、要素の挿入／削除は、配列サイズが大きくなるほど、
	//また、操作位置が先頭に近くなるほど遅くなります。
	//LinkedList
	//LinkedListは、要素同士を前後双方向のリンクで参照するリンクリストを表します。
	//その性質上、要素の挿入／削除はリンクの付け替えで済むため、ArrayListに較べても高速です。
	//反面、インデックス値によるランダムなアクセスは苦手であるという性質を持ちます（＊）。
	//このような理由から、挿入／削除操作が多い状況ではLinkedListを、それ以外の場合はArrayListを使う、という使い分けになるでしょう。
	//HashMap
	//マップは、リストやセット、キューと異なり、キーと値の組み合わせで要素を管理します。
	//HashMapは、マップの実装クラスの中でも最も基本的なクラスです。キーは重複できず、また順番を持ちません。
	//TreeMap
	//TreeMapもまた、HashMap同様、要素をキーと値の組み合わせで管理するデータ構造ですが、キーの持ち方が異なります。
	//HashMapではキーの順番を保証しないのに対して、TreeMapではキーを自動的にソートし、順序を保証します。
	//HashSet
	//HashSetは、要素の重複を許可しない集合構造を表します。また、順番も持ちません。
	//数学での集合にもよく似た構造と考えて良いでしょう。
	//ArrayDeque
	//ArrayDequeは両端キューとも呼ばれ、先頭末尾の双方から要素を出し入れできるキューの実装です。
	//ArrayDequeを利用することで、キュー（FIFO：First In First Out）やスタック（LIFO：Last In First Out）
	//といったデータ構造を表現できます。
	
	//stream
	//バッファリング処理とは、書き込み時であればデータを一旦メモリー（バッファ）に蓄積し、
	//いっぱいになったところでファイルに出力することを言います。
	//読み込み時であればバッファにまとめてデータを読み込み、いっぱいになったところでデータを処理します。
	//いずれの場合もデータをまとめて処理できるので、読み書きを効率化できます。
	public void streamTest() {
	    try (BufferedReader reader = new BufferedReader(
	        new InputStreamReader(
	          new FileInputStream("/data/sample.txt"), "UTF-8"));
	       BufferedWriter writer = new BufferedWriter(
	        new OutputStreamWriter(
	          new FileOutputStream("/data/sample2.txt"), "UTF-8"))) {
	      String line;
	      while ((line = reader.readLine()) != null) {
	        writer.write(line);
	        writer.newLine();
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	
	////design pattern
	//dao
	//view helper
	//strategy:algorythm
	//factory:instance create
	//singleton
	//facade
	//templateMethod:abstract
	
	//thread pool
	//スレッドプールとは、スレッドをあらかじめいくつか用意しておき、再利用するしくみです。
	//スレッドプールを利用することで、必要になる都度、スレッドを生成する必要がなくなりますので、パフォーマンスの改善が期待できます。
	//スレッドプールを利用するには、Executorsクラス（java.util.concurrentパッケージ）を利用します。
	//Executorsクラスには、スレッドプールを生成するための以下のようなメソッドが用意されています。
	private static class MyThread implements Runnable {
	    @Override
	    public void run() {
	      System.out.println(new Date());
	    }
	  }
	 
		//main method
	  public void exec() {
	    ExecutorService service = Executors.newFixedThreadPool(3);
	    service.execute(new MyThread());
	    service.execute(new MyThread());
	    service.shutdown();
	  }
	  //java.util.concurrent.atomicパッケージでは、値の代入／取得といった処理を
	  //ハードウェアレベルでアトミックに実行する手段を提供します。
	  //・AtomicBoolean
	  //・AtomicInteger
	  //・AtomicIntegerArray
	  //・AtomicLong
	  //・AtomicLongArray
	  //これらのクラスを利用することで、synchronized修飾子、ReentrantLockクラスのようにロックを取得することなく、
	  //処理を同期させることが可能になります。
	  
	  //正規表現
	  public void patternMatch() {
		    String msg = "お問い合わせは、 sample@examples.com 、" + 
		      "または、examples@mcn.ne.jpまで";
		    Pattern p = Pattern.compile(
		      "[w.-]+@([w-]+.)+[w-]+", Pattern.CASE_INSENSITIVE);
		    Matcher m = p.matcher(msg);
		    while (m.find()) {
		      System.out.println("マッチング位置：" + m.start());
		      System.out.println("マッチング終了位置：" + m.end());
		      System.out.println("マッチング文字列：" + m.group());
		      System.out.println("------------------------------");
		    }
		  }
}


