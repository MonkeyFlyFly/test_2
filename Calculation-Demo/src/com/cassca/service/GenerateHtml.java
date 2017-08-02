package com.cassca.service;

public class GenerateHtml {
	private GenerateHtml(){};
	public static String generateHtml() {

		
		String head_ele="<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>\n"
						+"<%@ include file=\"/WEB-INF/jsp/apex/inc/taglib.jsp\"%>\n"
						+"<script src=\"${appRoot}/static/ret/js/retCommon.js\" type=\"text/javascript\"></script>\n"
						+"<link href=\"${appRoot}/static/ret/css/returnfirst_en_us.css\" type=\"text/css\" rel=\"stylesheet\" />\n";

		
		String fist_ele="<div style=\"text-align: center;\">"
						+"<img src=\"${appRoot}/static/ret/images/image.gif\" />"
						+"<p style=\"font-size: 20px;\">"
						+"<spring:message code=\"com.cacss.itas.ret.returnSDR.StampDuty\" text=\"Stamp Duty (Agency)\" />"
						+"</p>"
						+"</div>";
						
		return head_ele;
	}
	public static void main(String[] args) {
		System.out.println(generateHtml());
	}
}
