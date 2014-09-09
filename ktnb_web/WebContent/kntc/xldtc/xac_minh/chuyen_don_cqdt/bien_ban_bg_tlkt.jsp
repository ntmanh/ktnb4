<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<fieldset><!-- Tai lieu kem theo --> <legend>T&#224;i li&#7879;u, ch&#7913;ng c&#7913; k&#232;m theo</legend>
<table width="100%" cellpadding="0" cellspacing="0" border="0" class="display" id="tlkt">
	<thead>
		<tr>
			<th width="50%">T&#234;n t&#224;i li&#7879;u</th>
			<th width="20%">S&#7889; trang</th>
			<th width="30%">T&#236;nh tr&#7841;ng</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td width="50%"><input type="text" name="tenTL" id="tenTL0" style="width: 100%"></td>
			<td width="20%"><input type="text" name="soTrangTL" id="soTrangTL0" style="width: 100%" maxlength="3" onblur="isNumber(this,'i');" /></td>
			<td width="30%"><input type="text" name="tinhTrang" id="tinhTrang0" style="width: 100%" /></td>
		</tr>
	</tbody>
</table>
<div style="text-align: right; width: 100%"><INPUT type="button" class="button" name="btnAdd" onclick="fnClickAddRowTlkt();" value="Th&#234;m"> <INPUT type="button" class="button" name="btnXoa" id="deleteRow3" value="X&#243;a"></div>
</fieldset>
