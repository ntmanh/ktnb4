<%@ include file="/top.jsp"%>
<fieldset style="width: 495; text-align: center;">
<table id="tblLichTrinhDuKien" style="width: 495;" align="left">
	<tr class="TdHeaderList">
		<td>C&#xF4;ng vi&#x1EC7;c</td>
		<td>Th&#x1EDD;i gian th&#x1EF1;c hi&#x1EC7;n</td>
		<td>Ng&#xE0;y th&#x1EF1;c hi&#x1EC7;n</td>
	</tr>
	<tr>
		<td>Ra quy&#x1EBF;t &#x111;&#x1ECB;nh</td>
		<td><%=(String) request.getAttribute("th_quyet_dinh") + " Ng\u00E0y"%></td>
		<td><%=(String) request.getAttribute("quyet_dinh")%></td>
	</tr>
	<tr>
		<td>L&#x1EAD;p k&#x1EBF; ho&#x1EA1;ch</td>
		<td><%=(String) request.getAttribute("th_lap_ke_hoach") + " Ng\u00E0y"%></td>
		<td><%=(String) request.getAttribute("lap_ke_hoach")%></td>
	</tr>
	<tr>
		<td>Duy&#x1EC7;t k&#x1EBF; ho&#x1EA1;ch</td>
		<td><%=(String) request.getAttribute("th_duyet_ke_hoach") + " Ng\u00E0y"%></td>
		<td><%=(String) request.getAttribute("duyet_ke_hoach")%></td>
	</tr>
	<tr>
		<td>L&#x1EAD;p &#x111;&#x1EC1; c&#x1B0;&#x1A1;ng</td>
		<td><%=(String) request.getAttribute("th_de_cuong") + " Ng\u00E0y"%></td>
		<td><%=(String) request.getAttribute("de_cuong")%></td>
	</tr>
	<tr>
		<td>C&#xF4;ng b&#x1ED1; quy&#x1EBF;t &#x111;&#x1ECB;nh</td>
		<td><%=(String) request.getAttribute("th_cong_bo") + " Ng\u00E0y"%></td>
		<td><%=(String) request.getAttribute("cong_bo")%></td>
	</tr>
	<tr>
		<td>K&#x1EBF;t th&#xFA;c l&#xE0;m vi&#x1EC7;c t&#x1EA1;i &#x111;&#x1A1;n v&#x1ECB;</td>
		<td><%=(String) request.getAttribute("th_ket_thuc_ttkt") + " Ng\u00E0y"%></td>
		<td><%=(String) request.getAttribute("ket_thuc_ttkt")%></td>
	</tr>
	<tr>
		<td>G&#x1EED;i b&#xE1;o c&#xE1;o k&#x1EBF;t qu&#x1EA3;, d&#x1EF1; th&#x1EA3;o k&#x1EBF;t lu&#x1EAD;n</td>
		<td><%=(String) request.getAttribute("th_bao_cao_kq") + " Ng\u00E0y"%></td>
		<td><%=(String) request.getAttribute("bao_cao_kq")%></td>
	</tr>
	<tr>
		<td>Ra K&#x1EBF;t lu&#x1EAD;n</td>
		<td><%=(String) request.getAttribute("th_ket_luan") + " Ng\u00E0y"%></td>
		<td><%=(String) request.getAttribute("ket_luan")%></td>
	</tr>
	<tr>
		<td>B&#xE0;n giao h&#x1ED3; s&#x1A1; l&#x1B0;u tr&#x1EEF;</td>
		<td><%=(String) request.getAttribute("th_ban_giao_hslt") + " Ng\u00E0y"%></td>
		<td><%=(String) request.getAttribute("ban_giao_hslt")%></td>
	</tr>
</table>
</fieldset>
<fieldset style="width: 495; text-align: center; height: 60"><BR>
<INPUT type="button" onclick="window.close()" value="&#x110;&#xF3;ng"></fieldset>
<script language="javascript">
tblLtdk = document.getElementById('tblLichTrinhDuKien');
for(i = 1; i< tblLtdk.rows.length; i++){
	if(i%2==0)
		tblLtdk.rows[i].className  = 'row1';
	else
		tblLtdk.rows[i].className  = 'row2';
}
</script>
