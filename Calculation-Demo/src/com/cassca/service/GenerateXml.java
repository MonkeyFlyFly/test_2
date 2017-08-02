package com.cassca.service;


public class GenerateXml {
	private GenerateXml(){};
	public static String generateXml(String prefix,String returnShortName,String returnName,String[] fields,String[] desc) {
		String head_ele="<?xml version=\"1.0\"?>\n"+
						"<Fields>\n";
		String last_ele="</Fields>";
		
		
		StringBuilder body_ele=new StringBuilder();
		String ele_type="DOUBLE";
		String isTable="false";
		String isRequired="false";
		for (int i = 0; i < fields.length; i++) {
			body_ele.append("<RetFormRule>\n"
			+"<code>"+prefix+fields[i]+"</code>\n"
			+"<parentCode/>\n"
			+"<fieldType>"+ele_type+"</fieldType>\n"
			+"<isTable>"+isTable+"</isTable>\n"
			+"<isRequired>"+isRequired+"</isRequired>\n"
			+"<tag>"+prefix+fields[i]+"</tag>\n"
			+"<desc>"+desc[i]+"</desc>\n"
			+"<section>com.cacss.itas.ret.return"+returnShortName+"."+returnName+"</section>\n"
			+"<i18ncode>com.cacss.itas.ret."+returnShortName+"."+fields[i]+"</i18ncode>\n"
			+"</RetFormRule>\n");
		}
		
		return head_ele+body_ele+last_ele;
	}
	public static void main(String[] args) {
		String[] arr1={"S1F1","S1F2"};
		String[] arr2={"Document Type","Quantity"};
		System.out.println(generateXml("Cret00SDR", "SDR", "StampDuty",arr1,arr2));
	}

}
