<%@page pageEncoding="UTF-8" %>
<%@ include file="/top.jsp"%>
<script language="javascript">	
	function selectCqt(ma, ten){	
		window.opener.getCqtFromLov(ma, ten);		
		window.close();		
	}	
	function selectCqt1(ma){	
		var data = $('.data');
		var name="";
		for(var i=0;i<data.length;i++){
			if($.trim($(data[i]).text().replace(" ",""))==ma){
			name=$(data[i+1]).text();
			break;
			}
		}
		window.opener.getCqtFromLov(ma, name);		
		window.close();		
	}	
</script>
<logic:present name="ma&&ten">	
	<script language="javascript">
		maten = '<%=(String)request.getAttribute("ma&&ten")%>'
		ma = maten.split('&&')[0];
		ten = maten.split('&&')[1];
		selectCqt(ma, ten);
		window.close();
	</script>
</logic:present>
<BODY>
<html:form action="tim_kiem_cqt.do">
	<fieldSet style="text-align: center; width: 595">
	<fieldSet><legend><bean:message key="label.thong_tin_tim_kiem" /></legend>
	<TABLE cellpadding="10" cellspacing="10" width="100%">
		<tr>
			<td width="24%" align="right">Mã cơ quan thuế</td>
			<td width="1%" style="min-width: 5"></td>
			<td width="25%" align="left">
				<html:text property="maCqt" styleClass="text"></html:text>
			</td>
			<td width="24%" align="right">Tên cơ quan thuế</td>
			<td width="1%" style="min-width: 5"></td>
			<td width="25%" align="left"><html:text property="tenCqt" styleClass="text">
			</html:text></td>
		</tr>
		<tr valign="middle">
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td width="25%" align="left">
				<%@ include file="/ttkt/dung_chung/tim_kiem.jsp"%>
			</td>
		</tr>
	</table>
	</fieldSet>
	<fieldset><legend> <bean:message key="label.ket_qua_tim_kiem" /></legend>
		<TABLE width="100%" >
					<tr class="TdHeaderList"> 
						<td align="center" width="20%"><bean:message key="label.ma_cqt" />
						</td>
						<td align="center" width="80%"><bean:message key="label.ten_cqt" />
						</td>
					</tr>
					<logic:iterate id="rls4" name="dspb" property="data" indexId="index">
						<%if (index.intValue() % 2 == 0) {%>
							<tr class="row1">
								<%} else {%>
							<tr class="row2">
								<%}%>
							<td align="center" width="20%" class="data"><a href="#"
								onclick="selectCqt1('<bean:write name='rls4' property='ma'/>')"><bean:write name="rls4" property="ma" /></a>
							</td>
							<td align="left" width="80%" class="data"><bean:write name="rls4"
								property="ten" /></td>
						</tr>
					</logic:iterate>
				</TABLE>
	
		<DIV style="width: 100%; text-align: center;">
			<logic:present name="dspb">
				<tr>
					<td colspan="4" align="center">
					<table width="100%">
						<tr>
							<td align="center"><bean:write name="dspb"
								property="navigationBar" filter="false" /></td>
						</tr>
					</table>
					</td>
				</tr>
			</logic:present>
		</DIV>
	
	
	</fieldset>
	</fieldSet>	
	<br>
	<fieldSet style="text-align: center; width: 595;">	
		<TABLE>
			<tr>
				<td height="50" valign="middle">
					<INPUT type="button" onclick="window.close()" value="Đóng">
				</td>
			</tr>
		</TABLE>		
	</fieldset>

	<html:hidden property="maCqtChon" />
	<html:hidden property="level" />
</html:form>
</BODY>
<script language="javascript">	
	function validateForm(){
		return true;
	}
	function changeCqt(parentId){
		document.forms[0].elements['maCqtChon'] = parentId;
		document.forms[0].action = 'tim_kiem_cqt.do?method=changeCqt';				
		document.forms[0].submit();
	}
	
</script>
