package com.cassca.calTest;

import java.math.BigDecimal;

public class CalTest {
	public static void main(String[] args) {
		spiltCal_sum();
//		System.out.println(new BigDecimal(3).compareTo(new BigDecimal(2)));
//		spiltCal_sub();
		
	}
	
	public static void spiltCal_sum(){
		String arr ="S10F31,S10F33,S10F35,S10F37,S10F39";
		String[] arr_=arr.split(",");
		String pre="getValue(\"";
		String suffix = "\")";
		String plus="+";
		for (String s : arr_) {
			System.out.print(pre+s+suffix+plus);
		}
		
	}
	public static void spiltCal_sub(){
		
		String arr ="S6F10,S6F11,S6F12,S6F13,S6F14";
		String[] arr_=arr.split(",");
		String pre="getValue(\"";
		String suffix = "\")";
		String plus="-";
		for (String s : arr_) {
			System.out.print(pre+s+suffix+plus);
		}
		
	}
	
	
}
