<%@page pageEncoding="UTF-8" %>
<%@ include file="/top_bar.jsp"%>
<head>
	<style type="text/css">
	#ThongKeCanBo{
		padding:20px auto 10px 60px;
		margin: auto;
		width: 100%;
	}
	.content1{
		background-color:#FCFCFC;
	}
	.content2{
		background-color:#EAEAEA;
	}
	.style2{
		margin-left: 10px;
	}
	</style>
</head>
<logic:present name="success">
	<script type="text/javascript">
		alert("Lưu thành công");
	</script>
</logic:present>
<html:form action="thong_ke_can_bo.do" style="width: 100%">
<html:hidden property="ma"/>
<html:hidden property="ma_cqt"/>
<html:hidden property="ten_cqt"/>
<div id ="ThongKeCanBo">
	<div class="content1 content2"><b>Thống kê cán bộ</b></div>
	<div class="content1">
		<label class="label1">Số cán bộ đại học</label>
		<div class="style2">
		<html:text property="trinh_do_dh" onkeypress="return formatNumber(event, this)"></html:text>
		</div>
		<div class="note"></div>
		<label class="label1">Số cán bộ cao đẳng tại chức</label>
		<div class="style2">
		<html:text property="trinh_do_cdtc" onkeypress="return formatNumber(event, this)"></html:text>
		</div>
	</div>
	<div class="content1">
		<label class= label1>Số cán bộ chuyên trách</label>
		<div class="style2">
		<html:text property="chuyen_trach" onkeypress="return formatNumber(event, this)"></html:text>
		</div>
		<div class="note"></div>
		<label class="label1">Số cán bộ kiêm nhiệm</label>
		<div class="style2">
		<html:text property="kiem_nhiem" onkeypress="return formatNumber(event, this)"></html:text>
		</div>
	</div>
	<logic:present name="isCuc">
		<div class="content1">
			<label class= label1>Số CCT</label>
			<div class="style2">
			<html:text property="so_cct" onkeypress="return formatNumber(event, this)"></html:text>
			</div>
			<div class="note"></div>
			<label class="label1">Số đội KTNB</label>
			<div class="style2">
			<html:text property="so_doi_ktnb" onkeypress="return formatNumber(event, this)"></html:text>
			</div>
		</div>
	</logic:present>
	<div class="content1">
	<table width="100%">
		<tbody>
			<tr>
			<td><input type="button" onclick="save();" value=" Lưu " style="float: right;"></td>
			<td><input type="button" onclick="parent.location='ttkt_index.do'" value="Đóng " style="float: left;"></td>
			</tr>
		</tbody>
	</table>
	</div>
	</div>
</html:form>
<%@ include file="/bottom.jsp"%>
<script language="javascript">
function save(){
var check = false;
$.each($('.style2 input:not([type="button"])'),function(key,value){
	if(value.value.length>5){
		$(value).effect("highlight");
		check=true;
	}
});
if(check==true){
 alert("Số lượng phải nhỏ hơn 100000");
 return;
}
document.forms[0].action="thong_ke_can_bo.do?method=save";
document.forms[0].submit();
}
</script>
