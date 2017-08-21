package com.cassca.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.cassca.constants.Calculation;
import com.cassca.utils.ParseExcel;


public class GenerateXml {
	private GenerateXml(){};
	public static String generateXml(String returnShortName,String returnName,Map map) {
		String head_ele="<?xml version=\"1.0\"?>\n"+
						"<Fields>\n";
		String last_ele="</Fields>";
		String ele_type="DOUBLE";
		String isTable="false";
		String isRequired="false";
		StringBuilder body_ele=new StringBuilder();
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry entry=(Entry)it.next();
			body_ele.append("<RetFormRule>\n"
					+"<code>"+Calculation.PREFIX+returnShortName+entry.getKey()+"</code>\n"
					+"<parentCode/>\n"
					+"<fieldType>"+ele_type+"</fieldType>\n"
					+"<isTable>"+isTable+"</isTable>\n"
					+"<isRequired>"+isRequired+"</isRequired>\n"
					+"<tag>"+Calculation.PREFIX+returnShortName+entry.getKey()+"</tag>\n"
					+"<desc>"+entry.getValue()+"</desc>\n"
					+"<section>com.cacss.itas.ret.return"+returnShortName+"."+returnName+"</section>\n"
					+"<i18ncode>com.cacss.itas.ret."+returnShortName+"."+entry.getKey()+"</i18ncode>\n"
					+"</RetFormRule>\n");
		}
		return head_ele+body_ele+last_ele;
	}
	public static void main(String[] args) {
		Map map = ParseExcel.parseExcel_1();
		System.out.println(generateXml( "SDR", "StampDuty",map));
	}

}
