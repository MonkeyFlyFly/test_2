package com.cassca.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.cassca.constants.Calculation;
import com.cassca.utils.ParseExcel;

public class GenerateHtml {
	private GenerateHtml(){};
	public static String generateHtml(String returnShortName,String returnFullName,Map map) {
		String head_ele="<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>\n"
						+"<%@ include file=\"/WEB-INF/jsp/apex/inc/taglib.jsp\"%>\n"
						+"<script src=\"${appRoot}/static/ret/js/retCommon.js\" type=\"text/javascript\"></script>\n"
						+"<link href=\"${appRoot}/static/ret/css/returnfirst_en_us.css\" type=\"text/css\" rel=\"stylesheet\" />\n";
		String fist_ele="<div style=\"text-align: center;\">\n"
						+"<img src=\"${appRoot}/static/ret/images/image.gif\" />\n"
						+"<p style=\"font-size: 20px;\">\n"
						+"<spring:message code=\"com.cacss.itas.ret.return"+returnShortName+"."+returnShortName+"\" text=\""+returnFullName+"\" />\n"
						+"</p>\n"
						+"</div>\n";
		String second_ele=
				"<div class='accordion' id='accordion2'>\n"+
						"	<div class='accordion-group'>\n"+
						"		<div class='accordion-heading'>\n"+
						"			<a class='accordion-toggle' data-toggle='collapse'\n"+
						"				data-parent='#accordion2' href='#collapseTwo'> <strong><spring:message\n"+
						"						code=\"com.cacss.itas.ret.return"+returnShortName+"."+returnShortName+"\"\n"+
						"						text=\""+returnFullName+"\" /> </strong>\n"+
						"			</a>\n"+
						"		</div>\n"+
						"		<div id='collapseTwo' class='accordion-body collapse in'>\n"+
						"			<div class='accordion-inner' align='center' style='width: 100%'>\n"+
						"				<table id='mytable' border='1' cellpadding='0' cellspacing='0'\n"+
						"					bordercolor='#CCCCCC' class='mytable1 returntable'>\n"+
						"					<tr>\n"+
						"						<!-- ¶¨Î»ÐÐ -->\n"+
						"						<td class='tdvat1'></td>\n"+
						"						<td class='tdvat2'></td>\n"+
						"					</tr>\n";

		StringBuilder sb=new StringBuilder();
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry entry=(Entry)it.next();
			sb.append(
					"<tr class=\"paye4\">\n"+
							"	<td>\n"+
							"	<apex:label cls='labelcls' >\n"+
							"	<spring:message code=\"com.cacss.itas.ret.return"+returnShortName+"."+entry.getKey()+"\" text=\""+entry.getValue()+"\" />\n"+
							"	</apex:label>\n"+
							"	</td>\n"+
							"	<td>\n"+
							"	<apex:money maxlength=\"14\" id=\""+Calculation.PREFIX+returnShortName+entry.getKey()+"\" name=\""+Calculation.PREFIX+returnShortName+entry.getKey()+"\" value=\"${"+Calculation.PREFIX+returnShortName+entry.getKey()+" }\"/>\n"+
							"	</td>\n"+
							"</tr>\n"
					);
		}
		String end_ele ="</div>\n</div>\n</div>\n</div>\n";
		String script_ele=
		"<script type='text/javascript'>\n"+
		"$('#mytable div').addClass('controls2');\n"+
		"$('#gridview div').attr('class', 'controlsgridview');\n"+
		"$('#mytable label').attr('class', 'control-label2');\n"+
		"$('#gridview label').attr('class', 'control-labeleft');\n"+
		"var return_layout_panel_width = 0;\n"+
		"$(function() {\n"+
		"	initRequired();\n"+
		"	return_layout_panel_width = $('html').width() - 30;\n"+
		"	$('#mytable').each(function() {\n"+
		"		return_layout_panel_width = $('html').width() - 30;\n"+
		"		autoLayoutS1($(this), 1);\n"+
		"	});\n"+
		"});\n"+
		"$(window).resize(function() {\n"+
		"	autoLayout();\n"+
		"});\n"+
		"function autoLayoutS1(tab, col) {\n"+
		"	var tdw = 200;\n"+
		"	var ctw = tdw - 8;\n"+
		"	var tbw = ctw - 8;\n"+
		"	var mnw = tbw - 30;\n"+
		"	$(tab).find(':text').width(tbw);\n"+
		"	$(tab).find(':text[ismoney]').width(mnw);\n"+
		"	$(tab).find('.add-on').parent().find(':text').width(mnw + 2);\n"+
		"	$(tab).find('.controls2').attr('style', '').width(ctw);\n"+
		"	$(tab).find('tr:eq(0)').find('td:eq(0)').width(\n"+
		"			return_layout_panel_width - tdw * col);\n"+
		"	$(tab).find('tr:eq(0)').find('td:gt(0)').width(tdw);\n"+
		"}\n"+
		"function autoLayout() {\n"+
		"	return_layout_panel_width = $('html').width() - 50;\n"+
		"	$('.mytable2').each(function() {\n"+
		"		autoLayoutS1($(this), 2);\n"+
		"	});\n"+
		"	$('.mytable1').each(function() {\n"+
		"		autoLayoutS1($(this), 1);\n"+
		"	});\n"+
		"	$('.mytable3').each(function() {\n"+
		"		autoLayoutS1($(this), 3);\n"+
		"	});\n"+
		"	$('.mytable9').each(function() {\n"+
		"		autoLayoutS8($(this));\n"+
		"	});\n"+
		"}\n"+
		"</script>\n";
		
		String wholeEle=head_ele+fist_ele+second_ele+sb.toString()+end_ele+script_ele;
		return wholeEle;
	}
	public static void main(String[] args) {
		Map map = ParseExcel.parseExcel_1();
		System.out.println(generateHtml("SDR","Stamp Duty(2)",map));
	}
}
