<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">K&#7870; HO&#7840;CH X&#193;C MINH TC - M&#7850;U S&#7888; 11/KNTC</h3>
<html:form action="/kntc_khxm.do?method=khxm">
	<html:hidden property="arrDm" styleId="arrDm" />
	<html:hidden property="maQd" />
	<html:hidden property="maHidden" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> S&#7889; h&#7891; s&#417;</font> <html:text property="maHoSo" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Th&#244;ng tin k&#7871; ho&#7841;ch</legend>
	<table width="100%">
		<tr>
			<td width="15%" style="text-align: right;">&#272;&#7883;a &#273;i&#7875;m <font style="color: red">*</font></td>
			<td width="35%"><html:text property="diaDiem" style="width: 100%" /></td>
			<td width="15%" style="text-align: right;">Ng&#224;y l&#7853;p k&#7871; ho&#7841;ch</td>
			<td width="312"><html:text property="thoiDiem" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">C&#225;n b&#7897; l&#7853;p k&#7871; ho&#7841;ch</td>
			<td colspan="3"><html:select property="canBoTen" styleClass="combobox123" style="width:100%">
				<html:options collection="dmcb" property="value" labelProperty="label" />
			</html:select></td>
		</tr>
		<tr>
			<td style="text-align: right;">C&#259;n c&#7913; ph&#225;p l&#253; &#273;&#7875; ti&#7871;n h&#224;nh x&#225;c minh</td>
			<td colspan="3"><html:textarea property="canCuPhapLy" style="width: 100%;height:80px" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">M&#7909;c &#273;&#237;ch y&#234;u c&#7847;u x&#225;c minh</td>
			<td colspan="3"><html:textarea property="mucDich" style="width: 100%;height:80px" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">C&#225;c t&#224;i li&#7879;u b&#7857;ng ch&#7913;ng c&#7847;n thu th&#7853;p</td>
			<td colspan="3"><html:textarea property="bangChung" style="width: 100%;height:80px" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">C&#417; quan, &#273;&#417;n v&#7883;, c&#225; nh&#226;n c&#7847;n l&#224;m vi&#7879;c</td>
			<td colspan="3"><html:textarea property="benLienQuan" style="width: 100%;height:80px" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">&#272;i&#7873;u ki&#7879;n, ph&#432;&#417;ng ti&#7879;n l&#224;m vi&#7879;c</td>
			<td colspan="3"><html:textarea property="phuongTien" style="width: 100%;height:80px" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">File k&#7871; ho&#7841;ch x&#225;c minh</td>
			<td colspan="3"><A href="#" onclick="openUploadFile(maHoSo);">File "k&#7871; ho&#7841;ch x&#225;c minh" &#273;&#237;nh k&#232;m </A></td>
		</tr>
	</table>
	<fieldset><legend>N&#7897;i dung KNTC</legend>
	<div>
	<table cellpadding="0" cellspacing="0" width="750px" class="display" id="dm_table">
		<thead>
			<tr class="TdHeaderList" align="center">
				<th width="5%">STT</th>
				<th width="15%">M&#227;</th>
				<th width="75%">T&#234;n</th>
				<th width="5%">Ch&#7885;n</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="4" class="dataTables_empty">&#272;ang l&#7845;y d&#7919; li&#7879;u...</td>
			</tr>
		</tbody>
	</table>
	</div>
	</fieldset>
	</fieldset>
	<jsp:include page="../../thong_tin_ky_duyet.jsp" />
	<jsp:include page="../../../button_bar_kntc.jsp" />
</html:form>
<script type="text/javascript" charset="utf-8"> 
var oTable;
$(function(){	
	var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1')
	   alert('L\u01B0u th\u00E0nh c\u00F4ng!'); 
	 else  if(ghiTC=='0')
	   alert('L\u1ED7i khi ghi d\u1EEF li\u1EC7u!!!'); 
	var url='kntc_khxm.do?method=getListDmNd&maHs='+document.forms[0].maHoSo.value+'&l1=04/KNTC&l2=11/KNTC';
  	oTable=$("#dm_table").dataTable({
     	"bJQueryUI":true,
		"sDom":'<"H"fr>t<"F"p>',
		"bSort": false,
		"sScrollY": "200px",
		"sScrollX": "750px",
		"bScrollCollapse": true,
		"bPaginate": false,
		"bFilter": false,
		"bProcessing": true,
		"bServerSide": true,
		"sAjaxSource":url,
		"oLanguage":language
	}).fnSetFilteringDelay(200);
});

function ghi(){
	if(validRequired()) {
	try{
		obj =document.forms[0].dmNd;	
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
		document.forms[0].arrDm.value=s.substring(1);
		}catch(e){}
		document.forms[0].action="kntc_khxm.do?method=saveKhxmTc";
		document.forms[0].submit();	
	}
}
function print(){		
		try{
		obj =document.forms[0].dmNd;	
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
		document.forms[0].arrDm.value=s.substring(1);
		}catch(e){}
		document.forms[0].action="kntc_khxm.do?method=inKhXm";
		document.forms[0].submit();
	}
function validRequired() {
	if(!isRequired(document.forms[0].diaDiem,'Ch\u01B0a nh\u1EADp \u0111\u1ECBa \u0111i\u1EC3m')) return false;
	//if(!isRequired(document.forms[0].thoiDiem,'Ch\u01B0a nh\u1EADp ng\u00E0y ra quy\u1EBFt \u0111\u1ECBnh')) return false;
	return true;
}
function openUploadFile(){
	var view='';
	var method = '<%=request.getParameter("method")%>';
	if(method == 'view') view = 'view';
	var r = '<%=request.getParameter("r")%>';
	if(r == 'rol') view = 'view';
	
    var maHS = document.forms[0].maHoSo.value;
    if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/KHXM&view="+view);
	else
		alert("Ch\u01B0a c\u00F3 th\u00F4ng tin v\u1EC1 h\u1ED3 s\u01A1!");	
}
</script>
<%@ include file="/bottom.jsp"%>
