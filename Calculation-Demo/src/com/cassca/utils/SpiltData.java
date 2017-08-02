package com.cassca.utils;
import java.util.List;
import java.util.ArrayList;

public class SpiltData {
	public static List<String> SpiltDatas(String datas){
		String[] datas_arr = datas.split("\n+");
		List<String> lst=new ArrayList();
		for (String data : datas_arr) {
			lst.add(data.trim());
		}
		return lst;
	}

}
