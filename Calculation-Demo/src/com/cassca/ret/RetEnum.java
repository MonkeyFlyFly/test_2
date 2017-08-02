package com.cassca.ret;



public enum RetEnum {
	PREFIX("com.cacss.itas.ret.return"),
	FILENAME("RET"),
	I18ENGNNAME("ret_en_US.properties"),
	I18ARNAME("ret_ar_SA.properties");
	private String context;
	
	private RetEnum(String context){
		this.context=context;
	}
	
	public String getValue(){
		return this.context;
	}
	

}
