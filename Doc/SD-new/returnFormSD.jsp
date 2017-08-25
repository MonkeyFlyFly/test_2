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
						<td ></td>
						<td ></td>
						<td ></td>
						<td ></td>
						<td ></td>
						<td ></td>
					</tr>			
					<tr>
						<td colspan="5"><apex:label cls='labelcls'>
								<strong> <spring:message
										code="com.cacss.itas.ret.returnSDR.StampDuty"
										text="Stamp Duty (Agency)" /></strong>
							</apex:label></td>
						<td style="text-align:center">
                            <apex:button name="retTableTrAdd" iconCls="icon-add" cls="btcls">
                                <spring:message code="ax.form.add" text="Add"/>
                            </apex:button>
                        </td>
					</tr>										
				<tr>
					<td >
					<apex:label cls='labelcls' >
					<small><i class="ax-notnull">*</i></small>
					<strong>
					<spring:message code="com.cacss.itas.ret.returnSDR.S1F1" text="Document Type" />
					</strong>
					</apex:label>
					</td>					
					<td ><apex:label cls='labelcls' ><small><i class="ax-notnull">*</i></small><strong><spring:message code="com.cacss.itas.ret.returnSDR.S1F2" text="Quantity" /></strong></apex:label></td>
					<td ><apex:label cls='labelcls' ><small><i class="ax-notnull">*</i></small><strong><spring:message code="com.cacss.itas.ret.returnSDR.S1F3" text="Total Amount" /></strong></apex:label></td>
					<td ><apex:label cls='labelcls' ><small><i class="ax-notnull">*</i></small><strong><spring:message code="com.cacss.itas.ret.returnSDR.S1F4" text="Tax Rate" /></strong></apex:label></td>
					<td ><apex:label cls='labelcls' ><small><i class="ax-notnull">*</i></small><strong><spring:message code="com.cacss.itas.ret.returnSDR.S1F5" text="Tax Due" /></strong></apex:label></td>					
					<td ></td>
				</tr>				
					<c:if test="${tbl_03 != null && tbl_03.size() > 0}">
					<c:forEach begin="0" end="${tbl_03.size() - 1}" varStatus="status" items="${tbl_03}" var="entity">
					<c:set var="s1f1" value="Cret00SDRS1F1_${status.count}"/>
					<c:set var="s1f2" value="Cret00SDRS1F2_${status.count}"/>
					<c:set var="s1f3" value="Cret00SDRS1F3_${status.count}"/>
					<c:set var="s1f4" value="Cret00SDRS1F4_${status.count}"/>
					<c:set var="s1f5" value="Cret00SDRS1F5_${status.count}"/>					
				<tr>
					<td ><apex:text	id="Cret00SDRS1F1_${status.count}"  name="Cret00SDRS1F1_${status.count}" value="${entity.get(s1f1) }"/></td>
					<td ><apex:text  id="Cret00SDRS1F2_${status.count}"  name="Cret00SDRS1F2_${status.count}" value="${entity.get(s1f2) }"/></td>
					<td ><apex:money maxlength="14"    id="Cret00SDRS1F3_${status.count}"  name="Cret00SDRS1F3_${status.count}" value="${entity.get(s1f3)}"/></td>
					<td ><apex:text  id="Cret00SDRS1F4_${status.count}"  name="Cret00SDRS1F4_${status.count}" value="${entity.get(s1f4)}" symbolShow="right" symbol="%"/></td>
					<td ><apex:money maxlength="14"   id="Cret00SDRS1F5_${status.count}"  name="Cret00SDRS1F5_${status.count}" value="${entity.get(s1f5)}"/></td>
					<td style="text-align:center">
                            <apex:button name="retTableTrDel" iconCls="icon-remove" cls="btcls"><spring:message code="ax.form.del" text="Delete"/></apex:button>
                        </td>
				</tr>
					</c:forEach>
					</c:if>
					<c:if test="${tbl_03 == null || tbl_03.size() <= 0}">
					<c:forEach begin="0" end="0" varStatus="status">
					<tr>
					<td ><apex:text	id="Cret00SDRS1F1_${status.count}"  name="Cret00SDRS1F1_${status.count}" value=""/></td>
					<td ><apex:text  id="Cret00SDRS1F2_${status.count}"  name="Cret00SDRS1F2_${status.count}" value=""/></td>
					<td ><apex:money maxlength="14"    id="Cret00SDRS1F3_${status.count}"  name="Cret00SDRS1F3_${status.count}" value=""/></td>
					<td ><apex:text  id="Cret00SDRS1F4_${status.count}"  name="Cret00SDRS1F4_${status.count}" value="" symbolShow="right" symbol="%"/></td>
					<td ><apex:money maxlength="14"   id="Cret00SDRS1F5_${status.count}"  name="Cret00SDRS1F5_${status.count}" value=""/></td>
					<td style="text-align:center">
                            <apex:button name="retTableTrDel" iconCls="icon-remove" cls="btcls"><spring:message code="ax.form.del" text="Delete"/></apex:button>
                        </td>
					</tr>
					</c:forEach>
					</c:if>			
				<tr>
					<td colspan="4"><apex:label cls='labelcls' ><small><i class="ax-notnull">*</i></small><strong><spring:message code="com.cacss.itas.ret.returnSDR.S1F6" text="Totals" /></strong></apex:label></td>
					<td><apex:money maxlength="14"   id="Cret00SDRS1F6"  name="Cret00SDRS1F6" value="${Cret00SDRS1F6 }"/></td>
					<td></td>
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
		initButton();
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
	function assembleData(){
			var arr = new Array();
			var a = $("input[id^='Cret00SDRS1F']");
			var length = a.length;
			for(var i =0; i< length ; i++){
				if(a[i].getAttribute('id').indexOf('hidden') === -1){
					arr.push(a[i].getAttribute('id'));
				}
			}
				return arr;
	}
	
	$("input[id^='Cret00SDRS1F']").blur(function(){
		var arr=assembleData();
		if($.inArray(this.id, arr)!=-1){
			if(this.value == null || this.value == '' || this.value == 'undefined') {
				addSchedule1Cls(this.id);
			}else {
				removeSchedule1Cls(this.id, false);
			}
		}
		calculateTotals();
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
		var arr=assembleData();
		for(var i= 0; i < arr.length ;i++){
			$(":input[id='"+arr[i]+"'],:input[id='"+arr[i]+"hidden']").addClass("required");
		}
		
	}		
	//validation for number
	$("input[id^='Cret00SDRS1F4_'],input[id^='Cret00SDRS1F2_']").keyup(
			function() {
				//$(this).val($(this).val().replace(/\D|^0/g, ''));
				$(this).val(
						$(this).val().replace(/[^0-9.]/g, '').replace(
								/^\./g, "").replace(/\.{2,}/g, ".")
								.replace(".", "$#$").replace(/\./g, "")
								.replace("$#$", ".")
								.replace(/^(\-)*(\d+)\.(\d\d).*$/,
										'$1$2.$3'));

			});
	$("input[id^='Cret00SDRS1F4_'],input[id^='Cret00SDRS1F2_']").on('blur', function() {
		var $amountInput = $(this);
		$amountInput.val(($amountInput.val().replace(/\.$/g, "")));
	});
	function initButton(){
		//Dynamic table: Add \ Del \ disabled. 
		$("button[name='retTableTrAdd']").click(function () {
	       $(this).retTableTrAdd();
	       reloadText();
	       return false;
	   	});
	   	$("button[name='retTableTrDel']").click(function () {
	       $(this).retTableTrDel();
	       reloadText();
	       return false;
	   	});
		if (!showEmployeeBut) {
	        $(":button[name='retTableTrAdd'],:button[name='retTableTrDel']").attr("disabled","disabled");
	    }
	}
	function calculateTotals(){
		var totals='0';
		var total = $("input[id^='Cret00SDRS1F5_']");
		var length = total.length;
		for(var i =0; i< length ;i++){
			if(total[i].getAttribute('id').indexOf('hidden') != -1){
				var id= total[i].getAttribute('id');
				var val = $('#'+id).val()-'0';
				var temp =parseFloat(val).toFixed(2);
				totals= parseFloat(parseFloat(totals) + parseFloat(temp)).toFixed(2);
			}
		}
		$("#Cret00SDRS1F6").val(totals);
		$("#Cret00SDRS1F6hidden").val(totals);
	}
	function reloadText(){
		$("input[id^='Cret00SDRS1F']").blur(function(){
			var arr=assembleData();
			if($.inArray(this.id, arr)!=-1){
				if(this.value == null || this.value == '' || this.value == 'undefined') {
					addSchedule1Cls(this.id);
				}else {
					removeSchedule1Cls(this.id, false);
				}
			}
			calculateTotals();
		});
		
	}

</script>
