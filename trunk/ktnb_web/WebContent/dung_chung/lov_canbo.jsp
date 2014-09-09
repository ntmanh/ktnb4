<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<% 
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	cmc.com.ktnb.util.ApplicationContext ac=(cmc.com.ktnb.util.ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
  <link rel="shortcut icon" type="image/ico" href="<html:rewrite page='/image/favicon.ico'/>" />
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
  <link type="text/css"	href="<html:rewrite page='/stylesheet/ktnb.css'/>" rel="stylesheet">  
  <script type="text/javascript" src="<html:rewrite page='/include/js/ktnb.js'/>"></script>   
</head>
<body>
<h3 class="Header">Danh sách cán bộ</h3>
<fieldset>
<html:form action="/danhmuc_canbo.do?method=lov" >
<legend class="legend">Điều kiện tra cứu</legend>
<table width="100%">
	<tr>
	<td width="15%">Cơ quan Thuế</td>
	<td width="35%">
		<!--CO QUAN THUE-->
		<html:select property="arrCqt" styleClass="combobox" style="width:100%" onchange="changeCqt(this.value);">
				<html:options collection="cqts" property="value" labelProperty="label" />						
		</html:select> 
	</td>
	<td width="15%"></td>
	<td width="35%"></td>
	</tr>
	<tr>
	   <td>Mã</td>
	   <td><html:text style="width: 100%" property="id" /></td>	  
	 	<td>Tên</td>
	   <td><html:text style="width: 100%" property="name" /></td>	   
	 </tr>
</table> 
<input type="button"  class="button" value='Lọc' name="B2" onclick="filter();">
</fieldset>
<logic:present name="total">
<logic:equal name = "total" value="0">
	<table width="100%">
		<tr>
		<td align="center">
			<font color="red" style="font-size: larger; text-align: center;">Không có cán bộ nào!</font>
		</td>
		</tr>
	</table>
</logic:equal>
</logic:present>
<logic:present name="dtnts">
<fieldset><legend class="legend">Số lượng cán bộ đến&nbsp;<font color="red"> <bean:write name="total" /> </font></legend>
	<table width="100%">
		<tr class="TdHeaderList" align="center">
			<td width="5%">STT</td>
			<td width="15%">Mã</td>
			<td width="30%">Tên</td>
			<td width="30%">Nơi công tác</td>
			<td width="20%">Chức vụ</td>
		</tr>	
		<logic:iterate id="bc" name="dtnts" property="data" indexId="index"> 
		<tr class="row<%=index.intValue()%2 +1%>">
			  <td align="center"><bean:write name="dtnts" property="ordinal"/></td>			  			  			  
			  <td align="left" nowrap="nowrap">
				  <a class="link0" href="#" onclick="setData('<bean:write name="bc" property="data" />')">
				  <bean:write name="bc" property="ma" /></a>
			  </td>
			  <td align="left"><bean:write name="bc" property="ten" /></td>
			  <td align="left"><bean:write name="bc" property="tenPhong" /></td>
			  <td align="left"><bean:write name="bc" property="chucVu" /></td>	  
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

<table width="100%">
<tr>    
    <td align="center">
      <input type="button"  class="button" value='<bean:message key="button.thoat"/>' name="B2" onclick="window.close();">
    </td>
</tr>
</table>
</html:form>
<script language="javascript">
function filter(){
/*
	obj =document.forms[0].selectCqt;	
	var s="";
    if (isArray(obj))
    {
      for(i=0;i<obj.length;i++)
      {
        if (obj[i].checked)  s=s+','+obj[i].value;
      }
    }
    else
    {
      if (obj.checked)      s=s+','+obj.value;
    }   
 
	document.forms[0].arrCqt.value=s.substring(1);
	*/
	var right  = '<%=request.getAttribute("r") %>';
	if(right!=null && right!="null" && right!='')
		document.forms[0].action = document.forms[0].action+"&r=y&cqt="+document.forms[0].arrCqt.value;	
	else
		document.forms[0].action = document.forms[0].action+"&cqt="+document.forms[0].arrCqt.value;	
	document.forms[0].submit();
}
window.onload = function()
{
	var right  = '<%=request.getAttribute("r") %>';
	if(right!=null && right!="null" && right!='')
		document.forms[0].action = document.forms[0].action+"&r=y&cqt="+document.forms[0].arrCqt.value;	
	else
		document.forms[0].action = document.forms[0].action+"&cqt="+document.forms[0].arrCqt.value;	
	var data  = '<%=request.getAttribute("datas") %>';
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

