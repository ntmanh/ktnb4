<%@ page pageEncoding="UTF-8"%>
<fieldset style=""><legend>Xử lý phụ</legend>
	<table width="100%">
		<tr>
			<td width="50%"><a href="kntc_tim_kiem.do?method=show&action=bosungHS">Bổ sung hồ sơ, tài liệu</a></td>
			<td><a href="kntc_tim_kiem.do?method=show&action=suaHSTD">Sửa sổ tiếp dân</a></td>
		</tr>
		<tr id="divTcTrucTiep" style="dispplay: none;">
			<td><A href="#" onclick="openUploadFile();">Biên bản nội dung tố cáo trực tiếp</A></td>
			<td></td>
		</tr>
	</table>
</fieldset>
<script language="javascript">
var maHS = document.forms[0].maHoSo.value;
$(document).ready(function(){
	if(maHS!=null && maHS!='' && maHS!='null' && maHS.split('/')[2]=='TC')
    	$("#divTcTrucTiep").css('display','inline');
    else 
		$("#divTcTrucTiep").css('display','none');	
});
function openBm2(link){
		link = link + '<%=request.getParameter("id")%>';
		var r = '<%=request.getParameter("r")%>';
		if(r=='rol') link = link +'&r=rol';
		openWindow(link,800,600,false);
	}

function openUploadFile(){
		var view='';
	    if(maHS!=null && maHS!='' && maHS!='null')
			openWindow("UploadAction.do?parentId="+maHS+"&nv=STD/TCTT&view="+view);
		else
			alert("Chưa có thông tin về hồ sơ!");	
	}
</script>