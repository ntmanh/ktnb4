<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
<%@ page pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<link rel="shortcut icon" type="image/ico"
	href="<html:rewrite page='/image/favicon.ico'/>" />
<title>HỆ THỐNG KIỂM TRA NỘI BỘ</title>
<script type="text/javascript" src="<html:rewrite page='/include/js/jquery-1.4.2.min.js'/>"></script>
  <script type="text/javascript" src="<html:rewrite page='/include/js/jquery.easyui.min.js'/>"></script>
  <script type="text/javascript" src="<html:rewrite page='/include/js/jquery-ui-1.8.2.custom.min.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.dataTables.min.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.jeditable.mini.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.ui.datepicker-vi.min.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.jixedbar.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.hotkeys.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.treeTable.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/ktnb.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/datatable.util.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/date.format.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/verticaltabs.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/verticaltabs.pack.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.pngFix.pack.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/pluginpage.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/nicEdit/nicEdit.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/FixedColumn.js'/>"></script>
<link type="text/css" href="<html:rewrite page='/stylesheet/ktnb.css'/>" rel="stylesheet">
<script type="text/javascript"
	src="<html:rewrite page='/include/js/ktnb.js'/>"></script>
</head>
<body>
<h3 class="Header">Danh sách cơ quan Thuế</h3>
<fieldset><html:form action="/danhmuc_canbo.do?method=lovCqt">
	<html:hidden property="arrCqt" />
	<legend class="legend">Điều kiện tra
	cứu</legend>
	<table width="100%">
		<tr>
			<td width="15%">Mã</td>
			<td width="30%"><html:text style="width:80%" property="id" /></td>
			<td width="15%">Tên</td>
			<td width="30%"><html:text style="width:80%" property="name" /></td>
			<td align="right" width="10%"><input type="button" style="width:60" class="button" value='Lọc' name="B2"
				onclick="filter();"></td>
		</tr>
	</table></fieldset>
<logic:present name="total">
	<logic:equal name="total" value="0">
		<table width="100%">
			<tr>
				<td align="center"><font color="red"
					style="font-size: larger; text-align: center;">Không
				có bản ghi nào thỏa mãn!</font></td>
			</tr>
		</table>
	</logic:equal>
</logic:present>
<logic:present name="dtnts">
	<fieldset><legend class="legend">Số
	lượng đến&nbsp;<font color="red"> <bean:write
		name="total" /> </font></legend>
	<table width="100%">
		<tr class="TdHeaderList" align="center">
			<td width="10%">STT</td>
			<td width="15%">Mã</td>
			<td width="75%">Tên</td>
		</tr>
		<logic:iterate id="bc" name="dtnts" property="data" indexId="index">
			<tr class="row<%=index.intValue() % 2 + 1%>">
				<td align="center"><bean:write name="dtnts" property="ordinal" /></td>
				<td align="left" nowrap="nowrap"><a class="link0" href="#"
					onclick="setData('<bean:write name="bc" property="dataCqt" />')">
				<bean:write name="bc" property="ma" /></a></td>
				<td align="left"><bean:write name="bc" property="ten" /></td>
			</tr>
		</logic:iterate>
	</table>
	<table width="100%">
		<tr>
			<td align="center"><bean:write name="dtnts"
				property="navigationBar" filter="false" /></td>
		</tr>
	</table>
	</fieldset>
</logic:present>

<table width="100%">
	<tr>
		<td align="right"><input type="button" class="button"
			value='<bean:message key="button.thoat"/>' name="B2"
			onclick="window.close();"></td>
	</tr>
</table>
</html:form>
<script language="javascript">
function filter(){
	var right  = '<%=request.getAttribute("right")%>';
	if(right!=null && right!="null" && right!='')
		document.forms[0].action = document.forms[0].action+"&right=y&cqt="+document.forms[0].arrCqt.value;	
	else
		document.forms[0].action = document.forms[0].action+"&cqt="+document.forms[0].arrCqt.value;	
	document.forms[0].submit();
}
window.onload = function()
{
	var right  = '<%=request.getAttribute("right")%>';
	if(right!=null && right!="null" && right!='')
		document.forms[0].action = document.forms[0].action+"&right=y&cqt="+document.forms[0].arrCqt.value;	
	else
		document.forms[0].action = document.forms[0].action+"&cqt="+document.forms[0].arrCqt.value;	
	var data  = '<%=request.getAttribute("datas")%>';
	if(data!=null && data!="null" && data!='')
		setData(data);
}
function setData(data_val)
{
	opener.setData(data_val);
	window.close();
}
</script>
</body>
</html>


