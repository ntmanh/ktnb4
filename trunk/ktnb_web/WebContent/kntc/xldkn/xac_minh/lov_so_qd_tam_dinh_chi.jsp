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
<h3 class="Header">Danh sách Số quyết định tạm đình chỉ</h3>
<fieldset>
<html:form action="/kntc_qd_tam_dinh_chi_thi_hanh.do?method=lov" >
<legend class="legend">Tra cứu</legend>
<table width="100%">
	<tr>
		<td style="text-align: right; width: 47%">Số quyết định tạm đình chỉ  <input type="text" id="soQuyetDinh" name="soQuyetDinh" style="width: 50%"/></td>
		<td style="width: 4%"></td>	  
	  	<td>Mã phiếu  <input type="text" id="maPhieu" name="maPhieu" style="width: 50%"/></td>	   
	 </tr>
	 <tr>
	 	<td style="text-align: right;">Ngày quyết định tạm đình chỉ  <input type="text" id="ngayQuyetDinh" name="ngayQuyetDinh" style="width: 50%"/></td>	
	 	<td colspan="2"></td>
	 </tr>
</table> 
<input type="button"  class="button" value='Lọc' name="B2" onclick="filter();">
</fieldset>
<logic:present name="total">
<logic:equal name = "total" value="0">
	<table width="100%">
		<tr>
		<td align="center">
			<font color="red" style="font-size: larger; text-align: center;">Không có số quyết định nào!</font>
		</td>
		</tr>
	</table>
</logic:equal>
</logic:present>
<logic:present name="dtnts">
<fieldset><legend class="legend">Tổng số quyết định tạm đình chỉ&nbsp;<font color="red"> <bean:write name="total" /> </font></legend>
	<table width="100%">
		<tr class="TdHeaderList" align="center">
			<td width="5%">STT</td>
			<td width="30%">Mã phiếu</td>
			<td width="25%">Số quyết định</td>
			<td width="20%">Ngày ban hành</td>
			<td width="20%">File đính kèm</td>
		</tr>	
		<logic:iterate id="bc" name="dtnts" property="data" indexId="index"> 
		<tr class="row<%=index.intValue()%2 +1%>">
			  <td align="center"><bean:write name="dtnts" property="ordinal"/></td>			  			  			  
			  <td align="left" nowrap="nowrap">
				  <a class="link0" href="#" onclick="setData('<bean:write name="bc" property="data" />')">
				  <bean:write name="bc" property="id" /></a>
			  </td>
			  <td align="left"><bean:write name="bc" property="soQd" /></td>
			  <td align="left"><bean:write name="bc" property="ngayBanHanhstr" /></td>
			  <td><A href='#' onclick='openUploadFile();'>File đính kèm</A></td>
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
var id = '<%=request.getParameter("id")%>'; //id o day la ma ho so
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
<!--	var right  = '<%=request.getAttribute("r") %>';-->
<!--	if(right!=null && right!="null" && right!='')-->
<!--		document.forms[0].action = document.forms[0].action+"&r=y&cqt="+document.forms[0].arrCqt.value;	-->
<!--	else-->
	document.forms[0].action = document.forms[0].action+"&soQd="+$('#soQuyetDinh').val()+"&maPhieu="+$('#maPhieu')+"&ngayBanHanh="+$('#ngayQuyetDinh');	
	document.forms[0].submit();
}
window.onload = function()
{
<!--	var right  = '<%=request.getAttribute("r") %>';-->
<!--	if(right!=null && right!="null" && right!='')-->
<!--		document.forms[0].action = document.forms[0].action+"&r=y&cqt="+document.forms[0].arrCqt.value;	-->
<!--	else-->
	document.forms[0].action = document.forms[0].action;	
	var data  = '<%=request.getAttribute("datas") %>';
	if(data!=null && data!="null" && data!='')
		setData(data);
}
function setData(data_val)
{
	opener.setData(data_val);
	window.close();
}
function openUploadFile(){
		var view='';
		var method = '<%=request.getParameter("method")%>';
		if(method == 'view') view = 'view';
		var r = '<%=request.getParameter("r")%>';
		if(r == 'rol') view = 'view';
		
	    var maHS = id; 
	    if(maHS!=null && maHS!='' && maHS!='null')
			openWindow("UploadAction.do?parentId="+id+"&nv=KNTC/XM/QDTDC&view="+view);
		else
			alert("Chưa có thông tin về hồ sơ!");	
	}
</script>
</body>
</html>

