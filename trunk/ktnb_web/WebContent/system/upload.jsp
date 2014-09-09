<%@	page pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ include file="/top.jsp"%>
<link type="text/css" href="<html:rewrite page='/uploadify/uploadify.css'/>" rel="stylesheet">
<html:form action="/UploadAction" method="POST" enctype="multipart/form-data">
<html:hidden property="parentId" styleId="parentId"/>
<html:hidden property="id" styleId="id"/>
<html:hidden property="method" styleId="method"/>
<html:hidden property="nv" styleId="nv"/>
<div style="position:absolute;left:5%;width:70%;" >

<fieldset style="padding:5"><legend>Upload tài liệu</legend>
	<table width="100%"  cellpadding="2"  cellspacing="2" border="0">
	    <tr>
	        <td>File</td>
	        <td>
		        <div id="divUpload">
		          	<html:file property="formFile" styleId="multipleFiles">Chọn file</html:file>
				  	<button id='upload'>Gửi file</button>
					<button id='exit' onclick="window.close();">Đóng</button>
			  	<div>
	        </td>
	    </tr>
	</table>
</fieldset>

<logic:present name="table">
<fieldset style="padding:5"><legend>Danh sách tài liệu</legend>
  <table id='inbk' width="100%" cellpadding="2"  cellspacing="2" border="0">
  <thead>
    <tr>
      <td width="5%">Stt</td>
      <td>Tên File</td>
      <td width="15%">Ngày cập nhật</td>
      <td width="15%">Người cập nhật</td>
      <td width="5%">Xóa</td>
    </tr>
   </thead>
   <TBODY>
   <logic:iterate id="iter" name="table" property="data">
     <tr class="<bean:write name='table' property='rowStyle'/>">
	     <td class='ns' align="center"><bean:write name="table" property="ordinal"/></td>
	     <td class='ns'><a class="link0" href="#" onclick="onDownload('<bean:write name='iter' property='col1'/>');" /><bean:write name="iter"  property="col2" /></a></td>
	     <td class='ns'><bean:write name="iter" property="col3" /></td>
	     <td class='ns'><bean:write name="iter" property="col5" /></td>
	     <td class='rs' id="<bean:write name='iter' property='col1'/>"></td>
     </tr>
    </logic:iterate>
   </TBODY>  
  </table>
</fieldset>
</logic:present>
<div id="msgdiv"><html:messages id="msg" property="message" bundle="error"  message="true"><b><bean:write name="msg" /></b></html:messages></div>
</div>
</html:form>
<script type="text/javascript" src="<html:rewrite page='/uploadify/swfobject.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/uploadify/jquery.uploadify.v2.1.4.min.js'/>"></script>
<script type="text/javascript">
 $("#multipleFiles").uploadify({
      'uploader': '/ktnb/uploadify/uploadify.swf',
      'script': 'UploadAction.do',
      'scriptData'  : {'method':'upload','parentId':document.getElementById('parentId').value,'nv':document.getElementById('nv').value},
      'fileDataName': 'file',
      'buttonImg':'/ktnb/uploadify/attach.png',
      'hideButton':true,
      'buttonText': 'Chon file',
      'multi': true,
      'fileDesc':'Chọn file phù hợp',
      'fileExt' : '*.gif; *.jpg; *.png;*.docx;*.doc;*.xls;*.xlsx;*.pdf;*.jpeg;*.tif',
      'sizeLimit': 30485760,
      'simUploadLimit': 5,
      'cancelImg': '/ktnb/uploadify/cancel.png',
      'auto': false,
      'onError': function (a, b, c, d) {
          if (d.status == 404)
              alert("Could not find upload script. Use a path relative to: " + "<?= getcwd() ?>");
          else if (d.type === "HTTP")
              alert("error " + d.type + ": " + d.status);
          else if (d.type === "File Size")
              alert(c.name + " " + d.type + " Gi\u1EDBi h\u1EA1n: " + Math.round(d.info / (1024 * 1024)) + "MB");
          else
              alert("error " + d.type + ": " + d.text);
      },
      'onComplete' : function(){
        alert('G\u1EEDi file th\u00E0nh c\u00F4ng');
    	location.reload(true);
	  }
  });

$(function() 
{
  $('#upload').button({icons:{primary:'ui-icon-disk'}}).click(
  function(){
	  onButton('upload');	  
	  return false;
	  }
  );
  <logic:present name="table">
  if($('#inbk').length>0)  
  {
    $("#inbk td.rs").click(function() 
    {
      b=showConfirm(message_error_xac_nhan_xoa);
      if (b)
      {
      	document.forms[0].id.value=this.id;
      	document.forms[0].method.value='delete';
   	  	document.forms[0].submit();
   	  }
   	  return false;
    }); 
  }
  </logic:present>
  
  var view = '<%=request.getParameter("view")%>';
  if(view=='view'){
  	document.getElementById('divUpload').style.display = 'none';
  }
});

function onButton(method)
{
   if (method=='exit')  window.close();
   else if (method=='upload')
   {
    $('#multipleFiles').uploadifyUpload();
   }
   return true;
}
function onDownload(maFile)
{
   document.forms[0].id.value=maFile;
   document.forms[0].method.value='download';
   document.forms[0].submit();
   //var url="UploadAction.do?method=download&id="+maFile;
   //window.location=url;
}
</script>
<%@ include file="/bottom_lov.jsp"%>