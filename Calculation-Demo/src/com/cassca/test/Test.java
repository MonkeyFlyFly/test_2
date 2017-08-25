package com.cassca.test;

import java.math.BigDecimal;

public class Test {
	public static void main(String[] args) {
		String s="";
		for (int i = 0; i < 65535/6; i++) {
			s+=String.valueOf(i);
		}
//		System.out.println(s);
		BigDecimal d1 =new BigDecimal(1);
		BigDecimal d2 =new BigDecimal(2);
//		System.out.println(d2.compareTo(d1));
		System.out.println("1233\"333\"33");
	}
}
