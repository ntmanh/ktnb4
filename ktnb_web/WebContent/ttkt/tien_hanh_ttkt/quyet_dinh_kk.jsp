<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="kiem_ke.do?method=save&type=qdkk" method="POST">
	<html:hidden property="idQdKk" />
	<table align="center" style="width: 100%">
		<tr>
			<td width="19%" align="right">N&#417;i ra quy&#7871;t &#273;&#7883;nh <font color=red>*</font></td>
			<td width="1%"></td>
			<td width="30%" align="left"><html:text styleClass="text" property="noiRaQd"></html:text></td>
			<td width="19%" align="right">Ng&#224;y ra quy&#7871;t &#273;&#7883;nh <font color=red>*</font></td>
			<td width="1%"></td>
			<td width="30%" align="left"><html:text styleClass="text" property="ngayRaQd" onkeypress="return formatDate(event, this);" onblur="isDate(this);"></html:text></td>
		</tr>
		<tr>
			<td width="19%" align="right">Th&#7901;i gian ki&#7875;m k&#234; <font color=red>*</font></td>
			<td width="1%"></td>
			<td width="30%" align="left"><html:text styleClass="text" property="thoiGianKk" onblur="isTime(this)" onkeypress="return formatTime(event, this)"></html:text></td>
			<td width="19%" align="right"></td>
			<td width="1%"></td>
			<td width="30%" align="left"></td>
		</tr>
		<tr>
			<td align="right">T&#224;i s&#7843;n &#273;&#432;&#7907;c ki&#7875;m k&#234; <font color=red>*</font></td>
			<td></td>
			<td colspan="4" align="left"><html:textarea property="taiSanCanKiemKe" styleClass="textareaTitle" onkeypress="imposeMaxLength(this);" /></td>
		</tr>
		<tr>
			<td align="right">C&#417; quan, &#273;&#417;n v&#7883;, c&#225; nh&#226;n &#273;ang qu&#7843;n l&#253; b&#7843;o qu&#7843;n <font color=red>*</font></td>
			<td></td>
			<td colspan="4" align="left"><html:textarea property="donViDangBaoQuan" styleClass="textareaTitle" onkeypress="imposeMaxLength(this);" /></td>
		</tr>
		<tr>
			<td align="right">&#272;&#7883;a &#273;i&#7875;m c&#243; t&#224;i s&#7843;n &#273;&#432;&#7907;c ki&#7875;m k&#234; <font color=red>*</font></td>
			<td></td>
			<td colspan="4" align="left"><html:textarea property="diaDiemCoTsKk" styleClass="textareaTitle" onkeypress="imposeMaxLength(this);" /></td>
		</tr>
		<tr>
			<td align="right">&#272;&#417;n v&#7883; c&#225; nh&#226;n &#273;&#432;&#7907;c giao ki&#7875;m k&#234; <font color=red>*</font></td>
			<td></td>
			<td colspan="4" align="left"><html:textarea property="donViCaNhanDuocKk" onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle" /></td>
		</tr>
		<tr>
			<td align="right">&#272;&#417;n v&#7883; c&#225; nh&#226;n &#273;&#432;&#7907;c giao, b&#7843;o qu&#7843;n t&#224;i s&#7843;n ki&#7875;m k&#234; <font color=red>*</font></td>
			<td></td>
			<td colspan="4" align="left"><html:textarea property="donViCaNhanBaoQuan" onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle" /></td>
		</tr>
		<tr>
			<td align="right">Th&#7911; tr&#432;&#7903;ng &#273;&#417;n v&#7883; c&#243; t&#224;i s&#7843;n &#273;&#432;&#7907;c ki&#7875;m k&#234;</td>
			<td></td>
			<td colspan="4" align="left"><html:textarea property="thuTruongDonViCoTSKK" onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle" /></td>
		</tr>
		<tr>
			<td align="right">C&#417; quan t&#7893; ch&#7913;c c&#225; nh&#226;n c&#243; li&#234;n quan</td>
			<td></td>
			<td colspan="4" align="left"><html:textarea property="donViCoLienQuan" onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle" /></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td align="right"><INPUT type="button" class="button1" onclick="inQdkk()" value="In quy&#x1EBF;t &#x111;&#x1ECB;nh"></td>
		</tr>
	</table>
</html:form>
<script language="javascript">
	
	function inQdkk(){
		if(!validateQuyetdinh())
		return false;
		//document.forms[0].action = 'kiem_ke.do?method=in&type=qdkk';
		//document.forms[0].submit();
		//document.forms[0].action = 'kiem_ke.do';
		var printfForm = findForm('/' + contextRoot + '/kiem_ke.do?method=save&type=qdkk'); 	   
		printfForm.action = 'kiem_ke.do?method=in&type=qdkk&idCuocTtkt='+document.getElementsByName('idCuocTtkt')[0].value;
		printfForm.submit();                                  
		printfForm.action = '/' + contextRoot + '/kiem_ke.do?method=save&type=qdkk';
	}
	
</script>
