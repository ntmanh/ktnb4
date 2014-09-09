<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@	page pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	cmc.com.ktnb.util.ApplicationContext ac = (cmc.com.ktnb.util.ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<link rel="shortcut icon" type="image/ico" href="<html:rewrite page='/image/favicon.ico'/>" />
<title>HỆ THỐNG KIỂM TRA NỘI BỘ</title>
<link type="text/css" href="<html:rewrite page='/stylesheet/ktnb.css'/>" rel="stylesheet">
<script type="text/javascript" src="<html:rewrite page='/include/js/ktnb.js'/>"></script>
</head>
<body>
<h3 class="Header">Danh sách hồ sơ</h3>
<html:form action="/kntc_tim_kiem.do?method=lov">
	<table width="100%">
		<tr>
			<td style="width:15%;text-align: right">Mã hồ sơ</td>
			<td style="width:35%"><html:text styleId="ma" property="maHoSo" style="width: 100%" /></td>
			<td style="width:15%;text-align: right">Người nộp đơn</td>
			<td style="width:35%"><html:text property="nguoiNopDon" style="width: 100%" /></td>
		</tr>
		<tr>
			<td style="width:15%;text-align: right">Loại hồ sơ</td>
			<td style="width:35%">
				<html:select property="loaiHoSo" styleId="loai" style="width: 100%">					
					<html:option value="1">Khiếu nại</html:option>
					<html:option value="2">Tố cáo</html:option>
					<html:option value="4">Hỏi chế độ chính sách</html:option>
					<html:option value="3">Trường hợp khác</html:option>
				</html:select>
			</td>
			<td style="width:15%;text-align: right">Trạng thái</td>
			<td style="width:35%">
				<html:select property="trangThai" styleId="tt" style="width: 100%">
					<option value="0">Tất cả</option>
					<option value="1603">Bổ sung HSTL</option>
					<option value="1605">Chuyển HS sang BPHC</option>
					<option value="1607">Chờ văn thư xử lý</option>
					<option value="1609">Phân loại, đề xuất</option>
					<option value="1611">Xác minh</option>
					<option value="1613">Đang giải quyết</option>
					<option value="1615">QĐGQ KN / KLND TC</option>
					<option value="1617">Kết thúc</option>
				</html:select>
			</td>
		</tr>
	</table>
	<input type="button" class="button" value='Lọc' name="B2" onclick="filter();">
	<input type="button" class="button" value='<bean:message key="button.thoat"/>' name="B2" onclick="window.close();">
	<logic:present name="total">
		<logic:equal name="total" value="0">
			<table width="100%">
				<tr>
					<td align="center"><font color="red" style="font-size: larger; text-align: center;">Không có hồ sơ nào liên quan!</font></td>
				</tr>
			</table>
		</logic:equal>
	</logic:present>
	<logic:present name="dtnts">
		<fieldset>
		<table width="100%">
			<tr class="TdHeaderList" align="center">
				<td width="4%">STT</td>
				<td width="11%">Mã</td>
				<td width="30%">Tên người nộp đơn</td>
				<td width="15%">Ngày nhận đơn</td>
				<td width="30%">Tên CQT</td>
				<td width="10%"></td>
			</tr>
			<logic:iterate id="bc" name="dtnts" property="data" indexId="index">
				<tr class="row<%=index.intValue() % 2 + 1%>">
					<td align="center"><bean:write name="dtnts" property="ordinal" /></td>
					<td align="left" nowrap="nowrap"><A href="#" onclick="setData('<bean:write name="bc" property="ma"/>','<bean:write name="bc" property="trangThai"/>','<bean:write name="bc" property="loaiHoSo"/>');"> <bean:write name="bc" property="ma"/> </A></td>
					<td align="left"><bean:write name="bc" property="tenNnd" /></td>
					<td align="center"><bean:write name="bc" property="ngayNhan" /></td>
					<td align="center"><bean:write name="bc" property="tenCqt" /></td>
					<td align="center"><a href="#" onclick="window.open('kntc_tiep_dan_van_thu_xem.do?method=view&action=tkxuly&id=<bean:write name="bc" property="ma"/>');">Xem hồ sơ</a></td>
				</tr>
			</logic:iterate>
		</table>
		<table width="100%">
			<tr>
				<td align="center"><bean:write name="dtnts" property="navigationBar" filter="false" /></td>
			</tr>
		</table>
		</fieldset>
	</logic:present>
</html:form>
<script language="javascript">
function filter(){
	var right  = '<%=request.getAttribute("right")%>';
	var tt  = '<%=request.getParameter("tt")%>';
	if(right!=null && right!="null" && right!='') 
		document.forms[0].action = document.forms[0].action+"&right=y&tt="+tt;	
	else 
		document.forms[0].action = document.forms[0].action+"&tt="+tt;	
	document.forms[0].submit();
}
window.onload = function()
{
	var right  = '<%=request.getAttribute("right")%>';
	if(right!=null && right!="null" && right!='') 
		document.forms[0].action = document.forms[0].action+"&right=y";	
	else 
		document.forms[0].action = document.forms[0].action;	
	var data  = '<%=request.getAttribute("datas")%>';
	if(data!=null && data!="null" && data!='') setData(data);
}
function setData(ma,trangthai,loaihoso)
{
	opener.setData(ma,trangthai,loaihoso);
	window.close();
}
</script>
</body>
</html>
