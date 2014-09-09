<%@page pageEncoding="UTF-8" %>
<%@ include file="/top.jsp"%>
<fieldset style="width: 595; text-align: center; height: 150; overflow: scroll">
<TABLE width="595">
	<tr class="TdHeaderList">
		<td align="center">STT</td>
		<td>Tên thành viên <font color="red">*</font></td>
		<td>Đơn vị công tác <font color="red">*</font></td>
		<td>Chức vụ công tác</td>
		<td>Chức vụ trong đoàn</td>
	</tr>
	<logic:present name="lisDsTvd">
		<logic:iterate name="lisDsTvd" id="thanhVienDoan" indexId="index">
			<tr class='row<%=(index.intValue() % 2)+1 %>'>
				<!--So thu tu-->
				<td align="center"><%=index.intValue() + 1%></td>
				<!--Ten thanh vien-->
				<td><bean:write property="tenCanBo" name="thanhVienDoan" /></td>
				<!--Don vi cong tac-->
				<td><bean:write property="tenPhong" name="thanhVienDoan" /></td>
				<!--Chuc vu cong tac-->
				<td><bean:write property="chucVu" name="thanhVienDoan" /></td>
				<!--Chuc vu trong doan-->
				<td><logic:equal property="chucVuTrongDoan" name="thanhVienDoan" value="Truong doan">
								Trưởng đoàn								
							</logic:equal> <logic:equal property="chucVuTrongDoan" name="thanhVienDoan" value="Pho doan">
								Phó đoàn								
							</logic:equal> <logic:equal property="chucVuTrongDoan" name="thanhVienDoan" value="Thanh vien doan">
								Thành viên đoàn								
							</logic:equal></td>
			</tr>
		</logic:iterate>
	</logic:present>
</TABLE>
</fieldset>
<fieldset style="width: 595; text-align: center; height: 50; vertical-align: bottom;"><BR>
<INPUT type="button" onclick="window.close()" value='<bean:message key="dong"/>'></fieldset>
