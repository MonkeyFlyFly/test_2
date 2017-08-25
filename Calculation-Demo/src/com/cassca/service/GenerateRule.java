package com.cassca.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.cassca.constants.Calculation;
import com.cassca.utils.ParseExcel;

public class GenerateRule {
	public static void generateRule(String returnName,String returnShortName){
		Map map = ParseExcel.parseExcel_1();
		String taxDue = "";
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			if(!it.hasNext()){
				taxDue= Calculation.PREFIX+returnShortName+entry.getKey();
			}
		}
		String rule=
				"package "+returnName.replaceAll(" ", "").toLowerCase()+"\n"+
				"dialect  \"mvel\"\n"+
				"import com.cacss.apex.web.util.rule.TaxField;\n"+
				"import com.cacss.itas.ret.rule.TaxMathUtils;\n"+
				"import com.cacss.itas.ret.rule.OperatorWrapper;\n"+
				"import com.cacss.itas.ret.rule.AssessmentResult;\n"+
				"global AssessmentResult assResult;\n"+
				"rule \"stampduty\"\n"+
				"when \n"+
				"			$"+taxDue+":TaxField(fieldName == \""+taxDue+"\");\n"+
				"then\n"+
				"			assResult.setPayableName($"+taxDue+".fieldName);\n"+
				"			assResult.setPayable($"+taxDue+".getNeedValue());\n"+
				"			assResult.setTaxDueName($"+taxDue+".fieldName);\n"+
				"			assResult.setTaxDue($"+taxDue+".getNeedValue());\n"+
				"end\n";
		System.out.println(rule);
	}
	public static void main(String[] args) {
		GenerateRule.generateRule("Stamp Duty","SDR");
	}
}
