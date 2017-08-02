package com.cassca.test;

public class Test {
	public static void main(String[] args) {
		String s="";
		for (int i = 0; i < 65535/6; i++) {
			s+=String.valueOf(i);
		}
		System.out.println(s);
	}
}
