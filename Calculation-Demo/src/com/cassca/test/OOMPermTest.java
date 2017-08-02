package com.cassca.test;

import java.util.ArrayList;
import java.util.List;

public class OOMPermTest {
	public static void main (String[] args){
		List<Integer> list = new ArrayList();
		int i=0;
		while(true){
		list.add(i++);
		}}
}