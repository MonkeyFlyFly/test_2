package com.cassca.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cassca.ret.ReturnConstant;
import com.cassca.utils.ReturnOutPut;

public class Generatei18n {
	private Generatei18n(){};
	
	
	public static String generatei18n(String returnType,List fields, List values){
		//com.cacss.itas.ret.returnOTI.S4F4=Tax payable
		String eq="=";
		List<String> list=new ArrayList<String>(10);
		StringBuilder temp_data= new StringBuilder();
		for (int i = 0; i < fields.size(); i++) {
			temp_data.delete(0, temp_data.length());
			temp_data.append(ReturnConstant.PREFIX).append(File.separator).append(returnType).append(fields.get(i)).append(values.get(i));
			list.add(temp_data.toString());
		}
		
		ReturnOutPut.outPutReturn(list, ReturnConstant.I18ENGNNAME);
		return "";
	}
	
	
	
}
