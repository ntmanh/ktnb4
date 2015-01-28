<%@page pageEncoding="UTF-8" %> 
<%@ include file="/top_bar.jsp"%>
<!-- <h3 class="Header">Gia hạn Thanh tra Kiểm tra</h3> -->
<h3 class="Header">Gia hạn Kiểm tra</h3>
<script language="javascript">
	function selfClose(){
		window.close();
	}
	function xuLySauSaveThanhCong(){
		if(window.opener.location.href.indexOf('danh_sach_tim_kiem.do') >= 0){// Neu mo tu form tim kiem
			window.opener.location.reload();
		}
	}
</script>
<html:form action="gia_han.do">
	<html:hidden property="id" />
	<html:hidden property="idCuocTtKt" />
	<fieldset style="padding: 15px"><legend>Trưởng bộ phận Thanh tra Kiểm tra</legend>
	<TABLE width="100%" align="center" style="margin-top: 10px">
		<TBODY>
			<tr>
				<td align="right" style="width: 19%">Nơi ký trình</td>
				<td style="width: 1%"></td>
				<td align="left" style="width: 30%"><html:text property="noiTrinh" styleClass="text">
				</html:text></td>
				<td align="right" style="width: 19%">Ngày ký trình</td>
				<td style="width: 1%"></td>
				<td align="left" style="width: 30%"><html:text property="ngayTrinh" onkeypress="return formatDate(event, this)" onblur="if(!isDate(this)) return;validateDateRequired(this);"  styleClass="text">
				</html:text></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<fieldset style="padding: 15px"><legend>Thủ trưởng cơ quan thuế</legend>
	<TABLE width="100%" align="center" style="margin-top: 10px">
		<TBODY>
			<tr>
				<td align="right" style="width: 19%">Nơi phê duyệt</td>
				<td style="width: 1%"></td>
				<td align="left" style="width: 30%"><html:text property="noiPheDuyet" styleClass="text"></html:text></td>
				<td align="right" style="width: 19%">Ngày phê duyệt</td>
				<td style="width: 1%"></td>
				<td align="left" style="width: 30%"><html:text styleClass="text" property="ngayPheDuyet" onkeypress="return formatDate(event, this)" onblur="if(!isDate(this)) return;validateDateRequired(this);"></html:text></td>
			</tr>
			<tr>
				<td align="right" style="width: 19%">Nội dung phê duyệt</td>
				<td style="width: 1%"></td>
				<td colspan="4" align="left"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  property="kienPheDuyet"></html:textarea></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<fieldset style="padding: 15px"><legend>Thông tin quyết định</legend>
	<TABLE width="100%" align="center" style="margin-top: 10px">
		<TBODY>
			<tr>
				<td align="right" style="width: 19%">Số quyết định</td>
				<td style="width: 1%"></td>
				<td colspan="4" align="left"><html:text property="soQd" styleClass="text"></html:text></td>
			</tr>
			<tr>
				<td align="right" style="width: 19%">Nơi ra quyết định</td>
				<td style="width: 1%"></td>
				<td align="left" style="width: 30%"><html:text property="noiRaQd" styleClass="text">
				</html:text></td>
				<td align="right" style="width: 19%">Ngày ra quyết định</td>
				<td style="width: 1%"></td>
				<td align="left" style="width: 30%"><html:text property="ngayRaQd" onkeypress="return formatDate(event, this)" onblur="if(!isDate(this)) return;validateDateRequired(this);"  styleClass="text">
				</html:text></td>
			</tr>
			<tr>
				<td width="19%" align="right">Căn cứ quyết định</td>
				<td style="width: 1%" ></td>
				<td colspan="4"><html:textarea property="canCuQd" styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"/></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<fieldset style="padding: 15px"><legend>Thời gian gia hạn</legend>
	<TABLE width="100%" align="center" style="margin-top: 10px">
		<TBODY>
			<tr>
				<td style="width: 19%" align="right">Văn bản quy định chức năng nhiệm vụ</td>
				<td></td>
				<td colspan="7" align="left"><html:select property="vbQdCnNv" style="width: 100%">
					<html:option value=""></html:option>
					<html:options collection="dmtly" property="value" labelProperty="label" />
				</html:select></td>
			</tr>
			<tr>
				<td style="width: 19%" align="right">Thời gian gia hạn <font color=red>*</font></td>
				<td style="width: 1%"></td>
				<td style="width: 14%" align="left"><html:text property="soNgayRaHan" style="width: 50%" onblur="if(!isNumber(this, 'i')) return; caculateDenNgay();" styleClass="text">
				</html:text> Ngày</td>
				<td style="width: 12%" align="right">Từ ngày <font color=red>*</font></td>
				<td style="width: 1%"></td>
				<td style="width: 20%" align="left"><html:text property="raHanTuNgay" onkeypress="return formatDate(event, this)" onblur="if(!isDate(this)) return; caculateDenNgay();validateDateRequired(this); " styleClass="text">
				</html:text></td>
				<td style="width: 12%" align="right">Đến ngày</td>
				<td style="width: 1%"></td>
				<td style="width: 20%" align="left"><html:text property="raHanDenNgay" readonly="true" styleClass="text">
				</html:text></td>
			</tr>
			<tr>
				<td align="right">Lý do gia hạn <font color=red>*</font></td>
				<td></td>
				<td colspan="7" align="left"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  property="lyDoRaHan">
				</html:textarea></td>
			</tr>
			<tr>
				<td align="right">Đơn vị, cá nhân có liên quan</td>
				<td></td>
				<td colspan="7" align="left"><html:textarea property="dvCaNhanLq" onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle">
				</html:textarea></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<div style="text-align: right; width: 100%"><INPUT type="button" class="button1" value="In tờ trình" onclick="inToTrinh()" class="button1"> <INPUT type="button" class="button1" value="In quyết định" onclick="inQuyetDinh()"></div>
</html:form>
<br />
<div style="margin: 0"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></div>
<%@ include file="/bottom.jsp"%>
<script language="javascript">
	window.onload=function(){
		var access = '<%=request.getAttribute("access")%>';
		if(access=='deny'){
			alert("Đã kết thúc không thể gia hạn!");
			window.close();
		}

	}
	function caculateDenNgay(){
		caculateDate('raHanTuNgay', 'raHanDenNgay', document.getElementsByName('soNgayRaHan')[0].value);
	}
	function inQuyetDinh(){
		if(!validateForm())
			return;
		document.forms[0].action = 'gia_han.do?method=in';
		document.forms[0].submit();		
		
	}
	function inToTrinh(){
		if(!validateForm())
			return;
		document.forms[0].action = 'gia_han.do?method=inTT';
		document.forms[0].submit();
		
	}
	function validateForm(){
		if(!isRequired(document.getElementsByName('soNgayRaHan')[0]))
			return false;
		if(!isRequired(document.getElementsByName('raHanTuNgay')[0]))
			return false;
		if(!isRequired(document.getElementsByName('lyDoRaHan')[0]))
			return false;		
		return true;
	}
	
	function validateDateRequired(dateElement){
		var ngayRaQuyetDnh = '<%=request.getAttribute("ngayRaQuyetDnh")%>';
		if(ngayRaQuyetDnh!=null&&ngayRaQuyetDnh!=""){
			if(dateElement.value!=""){
				if(d2n(ngayRaQuyetDnh)>=d2n(dateElement.value)){
					alert("Thời gian của trường này phải sau ngày ra quyết định("+ngayRaQuyetDnh+")!");
					$(dateElement).focus().select();			
				}
			}
		}
	}
	//window.onbeforeunload = function(){
	//if(state!=1)
	//	$('[name="ngayTrinh"]')[0].value="";
	//	$('[name="ngayPheDuyet"]')[0].value="";
	//	$('[name="ngayRaQd"]')[0].value="";
	//	$('[name="raHanTuNgay"]')[0].value="";
	//}

</script>
