<%@page pageEncoding="UTF-8" %>
<%@ include file="/top_bar.jsp"%>
<!-- <h3 class="Header">Hủy Thanh Tra Kiểm Tra</h3> -->
<h3 class="Header">Hủy Kiểm Tra</h3>
<html:form action="huy_ttkt.do">
	<html:hidden property="idCuocTtKt" />
	<html:hidden property="id" />
	<html:hidden property="idNguoiDnHuy" />
	<fieldset><legend> Thông Tin Hủy</legend>
	<TABLE width="100%" align="center">
		<TBODY>
			<tr>
				<td width="19%" align="right">Số quyết định</td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text property="soQd" styleClass="text"></html:text></td>
				<td width="19%" align="right">Nơi ra quyết định</td>
				<td width="1%"></td>
				<td width="30%"><html:text property="noiRaQd" styleClass="text"></html:text></td>
			</tr>
			<tr>
				<td width="19%" align="right">Ngày ra quyết định</td>
				<td width="1%"></td>
				<td width="30%"><html:text property="ngayRaQd" styleClass="text" onblur="isDate(this)" onkeypress="return formatDate(event, this)"></html:text></td>
				<td width="19%" align="right">Ngày hiệu lực <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%"><html:text property="ngayHieuLuc" styleClass="text" onblur="isDate(this)" onkeypress="return formatDate(event, this)"></html:text></td>
			</tr>
			<tr>
				<td align="right" width="19%">Văn bản quy định chức năng nhiệm vụ<font color=red>*</font></td>
				<td style="width: 1%; min-width: 5px"></td>
				<td colspan="4"><html:select property="vbQd" style="width: 100%">
					<html:option value=""></html:option>
					<html:options collection="dmtly" property="value" labelProperty="label" />
				</html:select></td>
			</tr>
			<tr>
				<td width="19%" align="right">Người đề nghị hủy</td>
				<td width="1%"></td>
				<td width="30%"><html:text property="tenNguyenDnHuy" styleClass="text">
				</html:text></td>
				<td width="19%" align="right">Chức vụ</td>
				<td width="1%"></td>
				<td width="30%"><html:text property="chucVuNguoiDnHuy" styleClass="text"></html:text></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td width="19%" align="right"></td>
				<td width="1%"></td>
				<td width="30%"><INPUT type="button" class="button1" value="In dự thảo quyết định" onclick="inDuThaoQdHuy()"></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
</html:form>
<script language="javascript">
function xuLySauSaveThanhCong(){	
	if(!isEmpty(document.getElementsByName('soQd')[0].value))
		window.opener.location = 'ttkt_index.do';
	window.close();
}
function selfClose(){
		window.close();
		
	}
</script>
<div style="text-align: center;"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></div>
<%@ include file="/bottom.jsp"%>
<script language="javascript">
	
	
	function inDuThaoQdHuy(){
		if(!validateForm())
			return;
		document.forms[0].action = 'huy_ttkt.do?method=in';
		document.forms[0].submit();
	}
	function validateForm(){
		if(!isEmpty(document.getElementsByName('soQd')[0].value)){
			if(!isRequired(document.getElementsByName('ngayRaQd')[0], 'Bạn cần nhập ngày ra quyết định cùng với số quyết định!'))
				return false;
			if(!isRequired(document.getElementsByName('noiRaQd')[0], 'Bạn cần nhập nơi ra quyết định cùng với số quyết định!'))
				return false;
		}		
		if(!isRequired(document.getElementsByName('ngayHieuLuc')[0]))
			return false;				
		if(!isRequired(document.getElementsByName('vbQd')[0]))
			return false;	
		
		if(!compareDate(document.getElementsByName('ngayRaQd')[0], document.getElementsByName('ngayHieuLuc')[0], 'Ngày hiệu lực phải bằng hoặc sau ngày ra quyết định!')){
			document.getElementsByName('ngayHieuLuc')[0].focus();
			return false;
		}		
		if(!isEmpty(document.getElementsByName('soQd')[0].value)){
			if(!window.confirm('Bạn có chắc chắn hủy cuộc Kiểm tra!'))
				return false;
		}			
		return true;
	}
</script>
