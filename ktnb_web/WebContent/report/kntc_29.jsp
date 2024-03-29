<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp" %>
<%@ page import="cmc.com.ktnb.util.KtnbUtil" %> 
<h3 class="Header">Báo cáo tổng hợp đơn Khiếu nại hệ thống KTNB</h3>
<html:form action="/kntc_rp.do?method=bcKn" >
<html:hidden property="arrCqt"/>
<html:hidden property="loaiBc" value="bcKn"/>
<fieldset>
	<legend>Chọn các tiêu chí để lập báo cáo</legend>
	<table width="100%">
		<tr>
		<td width="55%">
			<fieldset><legend>Thông tin chung</legend>
			<table width="100%">
				<tr>
					<td>Loại báo cáo</td>
					<td colspan="5">
						<html:select property="tenBc" styleId="loai" style="width: 100%;font-size: 12px;">
							<html:options collection="dmbc" property="value" labelProperty="label" />
						</html:select>
					</td>
				</tr>
				<tr>
					<td>Từ tháng<font color="red">*</font></td>
					<td colspan="2"><html:text property="tuThang" style="width: 100%;font-size: 12px;" alt="mm/yyyy" onkeypress="return formatDateMonth(event, this)" onblur="isMonth(this)"/>
					</td>
					<td>Đến tháng<font color="red">*</font></td>
					<td colspan="2"><html:text property="denThang" style="width: 100%;font-size: 12px;" alt="mm/yyyy" onkeypress="return formatDateMonth(event, this)" onblur="isMonth(this)"/></td>
				</tr>
				<!-- <tr>
					<td width="20%">Năm<font color="red">*</font></td>
					<td width="15%"><html:text property="nam" maxlength="4" style="width: 65px;font-size: 12px;" onkeypress="return formatInt(event)" onblur="isNumberInt(this);"/></td>
					<td width="15%"><font style="vertical-align: middle;">Loại kỳ</font></td>
					<td width="15%">
						<html:select property="tuNgay" styleId="loai" style="width: 65px;font-size: 12px;">
							<html:option value="THANG">Tháng</html:option>
							<html:option value="QUY">Quý</html:option>
							<html:option value="NAM">Năm</html:option>
						</html:select>
					</td>
					<td width="15%">Chi tiết kỳ</td>
					<td width="20%"><html:text property="kyBc" maxlength="2" style="width: 75px;font-size: 12px;"  onkeypress="return formatInt(event)" onblur="isNumberInt(this);"/></td>
				</tr>
				 -->
				<tr>
					<td>Nơi lập báo cáo</td>
					<td colspan="5"><html:text property="diaDiem" style="width: 100%;font-size: 12px;"/></td>
				</tr>
				<tr>
					<td>Ngày lập</td>
					<td colspan="2"><html:text property="ngayLap" maxlength="10" style="width: 100%;font-size: 12px;" onkeypress="return formatDate(event, this)" onblur="isDate(this);"/></td>
					<td>Người lập</td>
					<td colspan="2"><html:text property="nguoiLap" style="width: 100%;font-size: 12px;"/></td>
				</tr>	
				<tr>
					<% if(KtnbUtil.isTongCuc(ac)) { %>
						<td>Định dạng</td>
						<td colspan="2">
						<html:select property="dinhDang" style="width:100%;font-size: 12px;" >
							<html:option value="A4">A4</html:option>
												
						</html:select> 	
						</td>
						<td>Kết quả</td>
						<td colspan="2">
						<html:select property="ketQua" style="width:100%;font-size: 12px;" >
							<html:option value="0">Tổng hợp</html:option>
							<html:option value="1">Chi tiết</html:option>						
						</html:select> 	
						</td>
					<% } else{ %>
						<td>Định dạng</td>
						<td colspan="5">
						<html:select property="dinhDang" style="width:100%;font-size: 12px;" >
							<html:option value="A4">A4</html:option>
												
						</html:select> 	
						</td>
					<% }  %>
				</tr>								
			</table>
			</fieldset>
		</td>
		<td width="45%">	
		<% if(KtnbUtil.isTongCuc(ac)) { %>
			<table width="100%" border="0">
			   <tr>
					<td width="30%" align="right">Chọn cơ quan Thuế</td>
					<td width="70%">
						<html:select property="capCqt" styleId="loai" style="width: 100%" onchange="search();">
							<html:options collection="dmCqt" property="value" labelProperty="label" />
						</html:select>
					</td>
				</tr>
			</table>	
			<%}%>	
			<fieldset><legend>Danh sách CQT</legend>	
			<% if(KtnbUtil.isTongCuc(ac)) { %>		
				<div style="width:auto;height:120px;display:block;overflow:auto;border:1px solid #f1f1f1;padding:1px">
			<%} else %>
				<div style="width:auto;height:145px;display:block;overflow:auto;border:1px solid #f1f1f1;padding:1px">	
			<!--CO QUAN THUE--> 
				<%@ include file="../include/cqt1.jsp" %> 
			</div>				
			</fieldset>
		</td>		
		</tr> 
		</table>
		<table width="100%">
			<tr align="center">
		    	<td align="right" width="50%">
		      		<input type="button"  class="button" value='Kết xuất' name="B2" onclick="ketXuat();">
		    	</td>
		    	<td align="left" width="50%">
		      		<input type="button"  class="button" value='Đóng' name="B2" onclick="goHomeReport();">
		    	</td>
		  	</tr>
		</table>	 
</fieldset>	
</html:form>
<script type="text/javascript" charset="utf-8"> 
function ketXuat(){	
	/*if(document.forms[0].tuNgay.value=='THANG' || document.forms[0].tuNgay.value=='QUY')
		if(!isRequired(document.forms[0].kyBc,'Chưa có thông tin thời điểm báo cáo!'))
			return false;*/
	<% if(KtnbUtil.isTongCuc(ac)) { %>	
		if(document.forms[0].ctrlCqtBox.checked==true && document.forms[0].capCqt.value == '00000'){
				document.forms[0].arrCqt.value="all";
		}
		else{
				document.forms[0].arrCqt.value=getCheckReport(document.forms[0].selectCqt);
		}
	<%}else{%>
		document.forms[0].arrCqt.value=getCheckReport(document.forms[0].selectCqt);
	<%}%>
	if(document.forms[0].tuThang.value.length < 1){
		alert('Phải nhập thông tin tháng cần xem báo cáo!!!');
		document.forms[0].tuThang.focus();
		return null;
	}
	if(document.forms[0].denThang.value.length < 1){
		document.forms[0].denThang.value = document.forms[0].tuThang.value;
	}	
	document.forms[0].action="kntc_rp.do?method=export";
	document.forms[0].submit();
}
function search(){	
	document.forms[0].action="kntc_rp.do?method=search";
	document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>
