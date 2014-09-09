<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<h5>Trạng thái hồ sơ : <bean:write name="SoTiepDanVanThuForm" property="trangThaiText" /></h5>
<h5>Hồ sơ chuyển : <a href="kntc_tiep_dan_van_thu.do?method=view&action=tkxuly&id=<bean:write name="SoTiepDanVanThuForm" property="maHoSoChuyen"/>"><bean:write name="SoTiepDanVanThuForm" property="maHoSoChuyen" /></a></h5>
<logic:present name="SoTiepDanVanThuForm" property="loaiKNTC">
	<!--loaiKNTC = 1 ( don khieu nai)-->
	<logic:equal name="SoTiepDanVanThuForm" property="loaiKNTC" value="1">
		<a href="lich_trinh_du_kien.do?method=show&action=lichTrinhDKKN&r=rol&id=<bean:write name="SoTiepDanVanThuForm" property="maHoSo"/>" style="font-size: 8pt; font-weight: bold; margin-top: 10px;" > Lịch trình dự kiến</a>
		<!--TiepDan-->
		<fieldset><legend>Tiếp dân</legend>
		<ol>
			<LI><a href="kntc_phieu_hen.do?method=show&r=rol&id=<bean:write name="SoTiepDanVanThuForm" property="maHoSo"/>"> Phiếu hẹn (Mẫu số 02/KNTC)</a></LI>
			<LI><a href="kntc_giay_bn.do?method=cghs&r=rol&id=<bean:write name="SoTiepDanVanThuForm" property="maHoSo"/>"> Phiếu giao nhận hồ sơ (Mẫu số 03/KNTC)</a></LI>
		</ol>
		</fieldset>		
		<fieldset>
		<legend>Thông tin xử lý</legend>
		<ol>
			<li>
				<a href="phieu_dxxl_kn.do?method=show&action=phanloaiHSKN&r=rol&id=<bean:write name="SoTiepDanVanThuForm" property="maHoSo"/>" > Thông tin xử lý</a>
			</li>
		</ol>
		</fieldset>	
	</logic:equal>
	<!--loaiKNTC = 2  ( don to cao)-->
	<logic:equal name="SoTiepDanVanThuForm" property="loaiKNTC" value="2">
		<a href="lich_trinh_du_kien.do?method=show&action=lichTrinhDKTC&r=rol&id=<bean:write name="SoTiepDanVanThuForm" property="maHoSo"/>" style="font-size: 8pt; font-weight: bold; margin-top: 10px;" > Lịch trình dự kiến</a>
		<!--TiepDan-->
		<fieldset><legend>Tiếp dân</legend>
		<ol>
			<LI><a href="kntc_phieu_hen.do?method=show&r=rol&id=<bean:write name="SoTiepDanVanThuForm" property="maHoSo"/>"> Phiếu hẹn (Mẫu số 02/KNTC)</a></LI>
			<LI><a href="kntc_giay_bn.do?method=cghs&r=rol&id=<bean:write name="SoTiepDanVanThuForm" property="maHoSo"/>"> Phiếu giao nhận hồ sơ (Mẫu số 03/KNTC)</a></LI>
		</ol>
		</fieldset>	
		<fieldset>
		<legend>Thông tin xử lý</legend>
		<ol>
			<li>
				<a href="phieu_dxxl_kn.do?method=show&action=phanloaiHSTC&r=rol&id=<bean:write name="SoTiepDanVanThuForm" property="maHoSo"/>"> Thông tin xử lý</a>
			</li>
		</ol>
		</fieldset>	
	</logic:equal>	
</logic:present>