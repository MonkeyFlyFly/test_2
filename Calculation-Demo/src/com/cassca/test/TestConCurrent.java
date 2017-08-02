package com.cassca.test;

import com.cassca.thread.ThreadA;

public class TestConCurrent {
	
	
	public static void main(String[] args) {
		ThreadA t= new ThreadA("z", "v");
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		t2.start();
	}
	
	
	
}
