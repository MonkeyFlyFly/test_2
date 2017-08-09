<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/apex/inc/taglib.jsp"%>
<script src="${appRoot}/static/ret/js/retCommon.js"
	type="text/javascript"></script>
<link href="${appRoot}/static/ret/css/returnfirst_en_us.css"
	type="text/css" rel="stylesheet" />


<div style="text-align: center;">
	<img src="${appRoot}/static/ret/images/image.gif" />
	<p style="font-size: 20px;">
		<spring:message code="com.cacss.itas.ret.returnSDR.StampDuty"
			text="Stamp Duty (Agency)" />
	</p>
</div>

<div class="accordion" id="accordion2">
	<div class="accordion-group">
		<div class="accordion-heading">
			<a class="accordion-toggle" data-toggle="collapse"
				data-parent="#accordion2" href="#collapseTwo"> <strong><spring:message
						code="com.cacss.itas.ret.returnSDR.StampDuty.Schedule1"
						text="Section 1 : Stamp Duty" /> </strong>
			</a>
		</div>
		<div id="collapseTwo" class="accordion-body collapse in">
			<div class="accordion-inner" align="center" style="width: 100%">
				<table id="mytable" border="1" cellpadding="0" cellspacing="0"
					bordercolor="#CCCCCC" class="mytable1 returntable">
					<tr>
						<!-- 定位行 -->
						<td class="tdvat1"></td>
						<td class="tdvat2"></td>
					</tr>
					
				<tr class="paye4">
					<td><apex:label cls='labelcls' ><small><i class="ax-notnull">*</i></small><spring:message code="com.cacss.itas.ret.returnSDR.S1F1" text="Document Type" /></apex:label></td>
					<td ><apex:money maxlength="14"  id="Cret00SDRS1F1"  name="Cret00SDRS1F1" value="${Cret00SDRS1F1 }"/></td>
				</tr>
				<tr class="paye4">
					<td><apex:label cls='labelcls' ><small><i class="ax-notnull">*</i></small><spring:message code="com.cacss.itas.ret.returnSDR.S1F2" text="Quantity" /></apex:label></td>
					<td><apex:money maxlength="14"   id="Cret00SDRS1F2"  name="Cret00SDRS1F2" value="${Cret00SDRS1F2 }"/></td>
				</tr>
				<tr class="paye4">
					<td><apex:label cls='labelcls' ><small><i class="ax-notnull">*</i></small><spring:message code="com.cacss.itas.ret.returnSDR.S1F3" text="Total Amount" /></apex:label></td>
					<td><apex:money maxlength="14"    id="Cret00SDRS1F3"  name="Cret00SDRS1F3" value="${Cret00SDRS1F3 }"/></td>
				</tr>
				<tr class="paye4">
					<td><apex:label cls='labelcls' ><small><i class="ax-notnull">*</i></small><spring:message code="com.cacss.itas.ret.returnSDR.S1F4" text="Tax Rate (Fixed Tax Amount)" /></apex:label></td>
					<td><apex:money maxlength="14"   id="Cret00SDRS1F4"  name="Cret00SDRS1F4" value="${Cret00SDRS1F4 }"/></td>
				</tr>
				<tr class="paye4">
					<td><apex:label cls='labelcls' ><small><i class="ax-notnull">*</i></small><spring:message code="com.cacss.itas.ret.returnSDR.S1F5" text="Tax Due" /></apex:label></td>
					<td><apex:money maxlength="14"   id="Cret00SDRS1F5"  name="Cret00SDRS1F5" value="${Cret00SDRS1F5 }"/></td>
				</tr>
				
				</table>
			</div>
		</div>
	</div>
</div>










<style>
.controls2 {
	
}

.ax-form label.error {
    z-index: 10;
}

</style>
<script type="text/javascript">
	$("#mytable div").addClass("controls2");
	$("#gridview div").attr("class", "controlsgridview");
	$("#mytable label").attr("class", "control-label2");
	$("#gridview label").attr("class", "control-labeleft");
	var return_layout_panel_width = 0;
	$(function() {
		initRequired();
		return_layout_panel_width = $("html").width() - 30;
		// 		$(":text[id^='Cret00']").first().parent().parent().parent().width(350);
		// 		$(":text[id^='Cret00']").each(function() {
		// 			$(this).width(350-45);
		// 		});

		$("#mytable").each(function() {
			return_layout_panel_width = $("html").width() - 30;
			autoLayoutS1($(this), 1);
		});
	});
	$(window).resize(function() {
		autoLayout();
	});
	function autoLayoutS1(tab, col) {
		var tdw = 200;
		var ctw = tdw - 8;
		var tbw = ctw - 8;
		var mnw = tbw - 30;
		$(tab).find(":text").width(tbw);
		$(tab).find(":text[ismoney]").width(mnw);
		$(tab).find(".add-on").parent().find(":text").width(mnw + 2);
		$(tab).find(".controls2").attr("style", "").width(ctw);
		$(tab).find("tr:eq(0)").find("td:eq(0)").width(
				return_layout_panel_width - tdw * col);
		$(tab).find("tr:eq(0)").find("td:gt(0)").width(tdw);
	}
	function autoLayout() {
		return_layout_panel_width = $("html").width() - 50;
		$(".mytable2").each(function() {
			autoLayoutS1($(this), 2);
		});
		$(".mytable1").each(function() {
			autoLayoutS1($(this), 1);
		});
		$(".mytable3").each(function() {
			autoLayoutS1($(this), 3);
		});
		$(".mytable9").each(function() {
			autoLayoutS8($(this));
		});
	}
	
	$("input[id^='Cret00SDRS1F' ]").blur(function(){
		var arr=new Array("Cret00SDRS1F1","Cret00SDRS1F2","Cret00SDRS1F3","Cret00SDRS1F4","Cret00SDRS1F5");
		if($.inArray(this.id, arr)!=-1){
			if(this.value == null || this.value == '' || this.value == 'undefined') {
				addSchedule1Cls(this.id);
			}else {
				removeSchedule1Cls(this.id, false);
			}
		}
	});
	
	
	function addSchedule1Cls(currId) {
		if(currId == null || currId == '') {
			return;
		}
		$(":input[id='"+currId+"'],:input[id='"+currId+"hidden']").addClass("required");
		$("label[id='"+currId+"hidden-error']").attr("style","display:block;").html("This field is required.");
	}
	
	
	function removeSchedule1Cls(currId, isClearData) {
		if(currId == null || currId == '') {
			return;
		}
		if($("#"+currId).val() != '') {
			$(":input[id='"+currId+"'],:input[id='"+currId+"hidden']").removeClass("required");
			$("label[id='"+currId+"hidden-error']").attr("style","display:none;");
			
		}
	}
	
	function initRequired(){
		var arr=new Array("Cret00SDRS1F1","Cret00SDRS1F2","Cret00SDRS1F3","Cret00SDRS1F4","Cret00SDRS1F5");
		for(var i= 0; i < 5 ;i++){
			$(":input[id='"+arr[i]+"'],:input[id='"+arr[i]+"hidden']").addClass("required");
		}
	}
</script>
