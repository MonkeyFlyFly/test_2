package stampduty
dialect  "mvel"
import com.cacss.apex.web.util.rule.TaxField;
import com.cacss.itas.ret.rule.TaxMathUtils;
import com.cacss.itas.ret.rule.OperatorWrapper;
import com.cacss.itas.ret.rule.AssessmentResult;
//declare any global variables here
global AssessmentResult assResult;
rule "stampduty"
        when 
			//$Cret00RetVerUid:TaxField(fieldName == "Cret00BPTRetVerUid");
			$Cret00SDRS1F1:TaxField(fieldName == "Cret00SDRS1F1");
			$Cret00SDRS1F2:TaxField(fieldName == "Cret00SDRS1F2");
			//$Cret00SDRS1F3:TaxField(fieldName == "Cret00SDRS1F3",calValue==null);
			$Cret00SDRS1F3:TaxField(fieldName == "Cret00SDRS1F3");
			$Cret00SDRS1F4:TaxField(fieldName == "Cret00SDRS1F4");
			$Cret00SDRS1F5:TaxField(fieldName == "Cret00SDRS1F5");
		then
			String temp="";
		    //temp= TaxMathUtils.sumTaxOriginal($Cret00SDRS1F1,$Cret00SDRS1F2);
		    //assResult.compareAndSet($Cret00SDRS1F3,temp);
		    //assResult.compareAndSet($Cret00SDRS1F5,temp);
		    //S1F3=S1F1+S1F2
			//$Cret00SDRS1F3.setCalValue(TaxMathUtils.sumTaxOriginal($Cret00SDRS1F1,$Cret00SDRS1F2));
			//assResult.compareAndSet($Cret00SDRS1F3);
			//temp=TaxMathUtils.mulitplyTax($Cret00SDRS1F3,$Cret00SDRS1F4);
			//assResult.compareAndSet($Cret00SDRS1F5,temp);			
			assResult.setPayableName($Cret00SDRS1F5.fieldName);
			assResult.setPayable($Cret00SDRS1F5.getNeedValue());
			assResult.setTaxDueName($Cret00SDRS1F5.fieldName);
			assResult.setTaxDue($Cret00SDRS1F5.getNeedValue());
end