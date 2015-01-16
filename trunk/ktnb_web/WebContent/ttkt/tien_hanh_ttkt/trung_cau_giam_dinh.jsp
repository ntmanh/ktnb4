<%@page pageEncoding="UTF-8" %>
<%@ include file="/top_bar.jsp"%>
<script>
	function selfClose(){
		window.close();
	}
	function xuLySauSaveThanhCong(){
	if(window.opener.location.href.indexOf('danh_sach_tim_kiem.do') > 0){
		window.opener.location.reload();	
	}else{
		window.close();
	}
}
	
</script>
<h3 class="Header">Trưng cầu giám định</h3>
<html:form action="trung_cau_giam_dinh.do">
	<html:hidden property="id" />
	<html:hidden property="idCuocTtKt" />
	<html:hidden property="idCqtGd" />
	<html:hidden property="idCqtTc" />
	<fieldset>
	<TABLE width="100%" align="center">
		<TBODY>
			<tr>
				<td align="right" style="width: 19%">Số quyết định <font
					color=red>*</font></td>
				<td style="width: 1%"></td>
				<td align="left" style="width: 30%"><html:text
					styleClass="text" property="soQd"></html:text></td>
				<td align="right" style="width: 19%"> <font
					color=red></font></td>
				<td style="width: 1%"></td>
				<td align="left" style="width: 30%"></td>
			</tr>
			<tr>
				<td align="right" style="width: 19%">Nơi lập <font
					color=red>*</font></td>
				<td style="width: 1%"></td>
				<td align="left" style="width: 30%"><html:text
					styleClass="text" property="noiLap"></html:text></td>
				<td align="right" style="width: 19%">Ngày lập <font
					color=red>*</font></td>
				<td style="width: 1%"></td>
				<td align="left" style="width: 30%"><html:text
					styleClass="text" property="ngayLap" onblur="if(!isDate(this)) return;validateDateRequired(this);" 
					onkeypress="return formatDate(event, this)"></html:text></td>
			</tr>
			<tr>
				<td align="right" style="width: 19%">Cơ quan giám
				định</td>
				<td style="width: 1%"></td>
				<td align="left" style="width: 30%"><html:text
					styleClass="text" property="tenCqtGd"></html:text></td>
				<td align="right" style="width: 19%">Cơ quan thuế
				trưng cầu giám định</td>
				<td style="width: 1%"></td>
				<td align="left" style="width: 30%"><html:text
					styleClass="text" property="tenCqtTc"></html:text></td>
			</tr>
			<tr>
				<td align="right">Nội dung giám định <font
					color=red>*</font></td>
				<td></td>
				<td colspan="4" align="left"><html:textarea
					styleClass="textareaContent" onkeypress="imposeMaxLength(this);"
					property="noiDung" style="width: 100%;height: 70px" /></td>
			</tr>
			<tr>
				<td align="right">Đề nghị cung cấp
				kết quả trước ngày <font color=red>*</font></td>
				<td></td>
				<td align="left"><html:text styleClass="text"
					property="ngayCcKq" onblur="isDate(this)"
					onkeypress="return formatDate(event, this)"></html:text></td>
				<td></td>
				<td colspan="2" align="right"><INPUT type="button" class="button1"
					value="In biên bản" onclick="inBienBan()"></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
</html:form>
<fieldset style="margin: 0"><%@ include
	file="/ttkt/dung_chung/action_bar.jsp"%></fieldset>
<%@ include file="/bottom.jsp"%>
<script language="javascript">
	function validateForm(){
		if(!isRequired(document.getElementsByName('noiLap')[0]))
		return false;
		if(!isRequired(document.getElementsByName('ngayLap')[0]))
		return false;
		if(!isRequired(document.getElementsByName('noiDung')[0]))
		return false;
		if(!isRequired(document.getElementsByName('ngayCcKq')[0]))
		return false;
		if(!compareDate(document.getElementsByName('ngayLap')[0],document.getElementsByName('ngayCcKq')[0], 'Ngày đề nghị cung cấp kết quả => Ngày lập'))
		return false;
		
		return true;
	}
	function inBienBan()
	{
	if(!validateForm()) return false;
	document.forms[0].action = 'trung_cau_giam_dinh.do?method=in'
	document.forms[0].submit();
	document.forms[0].action = 'trung_cau_giam_dinh.do';
	}
	
	function selfClose(){
		window.close();
	}
	function validateDateRequired(dateElement){
		var ngayRaQuyetDnh = '<%=request.getAttribute("ngayRaQuyetDnh")%>';
		if(ngayRaQuyetDnh!=null&&ngayRaQuyetDnh!=""){
			if(dateElement.value!=""){
				if(d2n(ngayRaQuyetDnh)>=d2n(dateElement.value)){
					alert("Ngày lập  phải sau ngày ra quyết định ("+NgayRaQuyetDnh+")!");
					$(dateElement).focus().select();			
				}
			}
		}
	}
	//window.onbeforeunload = function(){
	//	$('[name="ngayLap"]')[0].value="";
	//}
</script>
<%
if (request.getAttribute("save") != null) {
%>
<script language="javascript">
		alert('Lưu thành công!');
	    window.location =  'danh_sach_tim_kiem.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value +'&type=tcGiamDinh';
	</script>
<%
}
%>
