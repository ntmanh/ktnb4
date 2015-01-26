<%@ include file="/top_bar.jsp"%> 
<%@ page pageEncoding="UTF-8"%>
<%@ page import="cmc.com.ktnb.util.KtnbUtil" %> 
<h3 class="Header">Tra cứu hồ sơ</h3>
<fieldset><html:form action="/kntc_tim_kiem.do?method=show">
	<html:hidden property="arrCqt" />
	<html:hidden styleId="data" property="data" />
	<legend class="legend">Thông tin tìm kiếm</legend>
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<td width="60%">
			<table width="100%">
				<tr>
					<td style="text-align: right;" width="20%">Mã hồ sơ</td>
					<td width="20%" colspan="3"><html:text styleId="ma" property="maHoSo" style="width: 100%" onkeypress="searchKeyPress(event);" onchange="changeIDisplayStart();" /></td>
				</tr>
				<tr>
					<td style="text-align: right;" width="20%">Cán bộ xử lý</td>
					<td width="20%" colspan="3"><html:text styleId="canBoXL" property="canBoXL" style="width: 100%" onkeypress="searchKeyPress(event);" onchange="changeIDisplayStart();" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">Tiếp dân từ ngày</td>
					<td><input type="text" id="tdTuNgay" name="tdTuNgay" style="width: 100%" onblur="isDate(this);validDateRange()" onchange="changeIDisplayStart();" maxlength="10" onkeypress="return formatDate(event, this)"></td>
					<td style="text-align: right;">Đến ngày</td>
					<td><input type="text" id="tdDenNgay" name="tdDenNgay" style="width: 100%" onblur="isDate(this);validDateRange()" onchange="changeIDisplayStart();" maxlength="10" onkeypress="return formatDate(event, this)"></td>
				</tr>
				<tr>
					<td style="text-align: right;">Người nộp đơn</td>
					<td><html:text styleId="nguoiNopDon" property="nguoiNopDon" style="width: 100%" onkeypress="searchKeyPress(event);" onchange="changeIDisplayStart();" /></td>
					<td style="text-align: right;">Người ủy quyền</td>
					<td><html:text styleId="nguoiUyQuyen" property="nguoiUyQuyen" style="width: 100%" onkeypress="searchKeyPress(event);" onchange="changeIDisplayStart();" /></td>
				</tr>
				<tr>
				<td style="text-align: right;">Hình thức</td>
					<td><html:select property="doanKNTC" style="width:100%" styleId="doanKNTC" onchange="changeIDisplayStart();">
			<html:option value="">--- Chọn hình thức ---</html:option>
			<html:option value="1">Một người</html:option>
			<html:option value="2">Nhiều người có cử đại diện</html:option>
			<html:option value="3">Nhiều người không cử đại diện</html:option>
		</html:select></td>
				</tr>
				<tr>
					<td style="text-align: right;">Loại hồ sơ</td>
					<td><html:select property="loaiHoSo" styleId="loai" style="width: 100%" onchange="changeLoaiHs(this.value)">
						<html:options collection="dmkntc" property="value" labelProperty="label" />
					</html:select></td>
					<td style="text-align: right;" width="20%">Trạng thái</td>
					<td width="30%"><html:select property="trangThai" styleId="tt" style="width: 100%" onchange="changeIDisplayStart();changeTrangThai();">
						<html:options collection="dmtt" property="value" labelProperty="label" />
					</html:select></td>
				</tr>
				<tr>
					<td style="text-align: right;">Nộp đơn từ ngày</td>
					<td><input type="text" id="sDate" name="sDate" style="width: 100%" onblur="isDate(this);validDateRange()" onchange="changeIDisplayStart();" maxlength="10" onkeypress="return formatDate(event, this)"></td>
					<td style="text-align: right;">Đến ngày</td>
					<td><input type="text" id="fDate" name="fDate" style="width: 100%" onblur="isDate(this);validDateRange()" onchange="changeIDisplayStart();" maxlength="10" onkeypress="return formatDate(event, this)"></td>
				</tr>
				<tr>
					<td style="text-align: right;">CV đến từ ngày</td>
					<td><input type="text" id="cvsDate" name="cvsDate" style="width: 100%" onblur="isDate(this);validDateRange()" onchange="changeIDisplayStart();" maxlength="10" onkeypress="return formatDate(event, this)"></td>
					<td style="text-align: right;">Đến ngày</td>
					<td><input type="text" id="cvfDate" name="cvfDate" style="width: 100%" onblur="isDate(this);validDateRange()" onchange="changeIDisplayStart();" maxlength="10" onkeypress="return formatDate(event, this)"></td>
				</tr>
				<tr>
					<td style="text-align: right;">Đơn trùng</td>
					<td><html:checkbox styleId="trungDon" property="trungDon"/></td>
					<td style="text-align: right;">Đơn lưu</td>
					<td><html:checkbox styleId="luuDon" property="luuDon"/></td>
				</tr>												
			</table>
			</td>
			<!-- Tìm theo cơ quan thuế -->
			<td width="40%">
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
				<input type="button" value="Hiện tìm kiếm nâng cao" id="btnShowAdvanceSeach" onclick="show_advance_search();"/>
				<input type="button" value="Ẩn tìm kiếm nâng cao" id="btnHideAdvanceSeach" onclick="hide_advance_search();" style="display: none;"/>
			</td>  
		</tr>		
	</table>
	<div id="advance-search" style="display: none">
		<fieldset><legend>Tìm kiếm nâng cao</legend>
		<table width="100%">
				<tr>
					<td width="15%" align="right">Chọn thẩm quyền</td>
					<td width="35%"><html:select property="thamQuyen" style="width:100%;" styleId="thamQuyen" onchange="changeThamQuyen(this.value);">
						<html:option value="0">Chọn thẩm quyền</html:option>
						<html:optionsCollection property="thamQuyenList" label="label" value="value" />
					</html:select></td>
					<td width="15%" style="text-align: right;">Loại kết thúc</td>
					<td width="35%">
						<html:select property="loaiKetThuc" styleId="loaiKetThuc" style="width:100%;" onchange="filter();">
							<html:option value="-1">Chọn loại kết thúc</html:option>
							<html:option value="0">Kết thúc thường</html:option>
							<html:option value="1">Kết thúc gộp đơn</html:option>
							<html:option value="2">Kết thúc rút đơn</html:option>
							<html:option value="3">Kết thúc trả đơn	</html:option>
							<html:option value="4">Kết thúc chuyển đơn</html:option>
							<html:option value="5">Kết thúc tách đơn</html:option>
							<html:option value="6">Kết thúc lưu đơn</html:option>
							<html:option value="7">Kết thúc xóa đơn</html:option>
						</html:select>
					</td>
				</tr>
				<tr>
					<td align="right">Trường hợp cụ thể</td>
					<td ><html:select property="thuLy" styleId="thuLy" style="width:100%;" onchange="filter();">
						<html:option value="0">Chọn trường hợp cụ thể</html:option>
						<html:optionsCollection property="thuLyList" label="label" value="value"/>
					</html:select></td>
					<td style="text-align: right;">Loại quan hệ</td>
					<td >
						<html:select property="loaiQuanHe" styleId="loaiQuanHe" style="width:100%;" onchange="filter();">
							<html:option value="-1">Chọn loại quan hệ</html:option>
							<html:option value="0">Liên kết cha con</html:option>
							<html:option value="1">Liên kết gộp</html:option>
							<html:option value="2">Liên kết chuyển</html:option>
						</html:select>
					</td>
				</tr>
				<tr>
					<td style="text-align: right;">Từ khóa</td>
					<td><html:text styleId="textSearch" property="textSearch" style="width: 100%" onkeypress="searchKeyPress(event);" onchange="changeIDisplayStart();" /></td>
					<td></td>
					<td></td>
				</tr>
		</table>
		</fieldset>
	</div>
	</fieldset>
<table width="100%">
	<tr>
		<td align="center" width="10%"><input id="btnSearch" type="button" class="button" value='Tìm kiếm' name="B2" onclick="filter();"></td>
	</tr>
</table>
<fieldset><legend>
<div id="divTotal"></div>
</legend>
<div style="margin: 1px; border: solid 1px #CCC;">
<table cellpadding="0" cellspacing="0" class="display" id="hs_table" width="100%">
	<thead>
		<tr class="TdHeaderList" align="center">
			<th class="hideextra-x">
			<div style="width: 130px;">Mã HS</div>
			</th>
			<th></th>
			<th class="hideextra-x">
			<div>Người nộp đơn</div>
			</th>
			<th class="hideextra-x">
			<div>Người bị kntc</div>
			</th>
			<th class="hideextra-x">
			<div id="txtNgayTiep">Ngày tiếp</div>
			</th>
			<th class="hideextra-x">
			<div>Người xử lý</div>
			</th>
			<th class="hideextra-x" width="300px">
			<div>Đơn vị nhận đơn</div>
			</th>
			<th class="hideextra-x">
			<div>Đơn vị chuyển đơn</div>
			</th>
			<th class="hideextra-x">
			<div>Trạng thái</div>
			</th>
			<th class="hideextra-x">
			<div>Số lượng người</div>
			</th>
			<th class="hideextra-x">
			<div>Loại</div>
			</th>
		</tr>
	</thead>
	<tbody style="font-size: 10px;">
		<tr>
			<td colspan="10" class="dataTables_empty">Loading data from server...</td>
		</tr>
	</tbody>
</table>
</div>
</fieldset>
<table width="100%">
	<tr>
		<td align="center">
			<input type="button" class="button" value='Xem hồ sơ' id="btnView" onclick="view();">
			<logic:present name="action">	
			<logic:equal name="action" value="tktiepdan">
				<input type="button" class="button" value='Xóa' id="btnDelete" onclick="xoa();">
			</logic:equal>
			<logic:equal name="action" value="tkxuly">
				<input type="button" class="button" value='Xóa' id="btnDelete" onclick="xoa();">
			</logic:equal>
					
			<logic:equal name="action" value="suaHSTD">
				<input type="button" class="button" value='Sửa' id="btnEdit" onclick="edit();">
				<input type="button" class="button" value='Xóa' id="btnDelete" onclick="xoa();">
			</logic:equal>
			<logic:equal name="action" value="suaHSVT">
				<input type="button" class="button" value='Sửa' id="btnEditXly" onclick="edittkxl();">
				<input type="button" class="button" value='Xóa' id="btnDeleteVT" onclick="xoavt();">
			</logic:equal>
			<logic:equal name="action" value="bbDoiThoaiKN">
				<input type="button" class="button" value='Lập biên bản đối thoại' name="B2" onclick="executeAction('bbDoiThoaiKN')">
			</logic:equal>
			<logic:equal name="action" value="phancongHS">
				<input type="button" class="button" value='Thay cán bộ xử lý ' id="phancongHs" onclick="executeAction('pchs')">
			</logic:equal>
			<logic:equal name="action" value="chonXLHS1Lan">
				<input type="button" class="button" value='Chọn xử lý' id="phancongHs" onclick="executeAction('chonXLHS1Lan')">
			</logic:equal>
			<logic:equal name="action" value="bbThongBaoDuThaoTC">
				<input type="button" class="button" value='Lập biên bản làm việc' name="B2" onclick="executeAction('bbThongBaoDuThaoTC')">
			</logic:equal>
			<logic:equal name="action" value="bosungHS">
				<input type="button" class="button" value='Bổ sung hồ sơ' id="bosungHS" onclick="executeAction('bshs')">
			</logic:equal>
			<logic:equal name="action" value="bckqxmKN">
				<input type="button" class="button" value='Báo cáo kết quả giải quyết KN' id="bckqxmKN" onclick="executeAction('bckqxmKN')">
			</logic:equal>
			<logic:equal name="action" value="chuyenHS">
				<input type="button" class="button" value='Chuyển hồ sơ' id="chuyenHoSo" onclick="executeAction('chs')">
			</logic:equal>
			<logic:equal name="action" value="phanloaiHSKN">
				<input type="button" class="button" value='Phân loại, lập đề xuất xử lý' id="phanloaiHoSo" onclick="executeAction('phanloaiHSKN')">
			</logic:equal>
			<logic:equal name="action" value="phanloaiHSTC">
				<input type="button" class="button" value='Phân loại, lập đề xuất xử lý' id="phanloaiHoSo" onclick="executeAction('phanloaiHSTC')">
			</logic:equal>
			<logic:equal name="action" value="lichTrinhDKKN">
				<input type="button" class="button" value='Xem lịch trình' name="B2" onclick="executeAction('lichTrinhDKKN');">
			</logic:equal>
			<logic:equal name="action" value="lichTrinhDKTC">
				<input type="button" class="button" value='Xem lịch trình' name="B2" onclick="executeAction('lichTrinhDKTC');">
			</logic:equal>
			<logic:equal name="action" value="tachDon">
				<input type="button" class="button" value='Tách nội dung KNTC' name="B2" onclick="executeAction('tachDon');">
			</logic:equal>
			<logic:equal name="action" value="qdgq">
				<input type="button" class="button" value='Quyết định giải quyết' name="B2" onclick="executeAction('qdgq')">
			</logic:equal>
			<logic:equal name="action" value="rutdon">
				<input type="button" class="button" value='Rút đơn' name="B2" onclick="executeAction('rutdon')">
			</logic:equal>
			<logic:equal name="action" value="theodoiKN">
				<input type="button" class="button" value='Theo dõi thi hành' name="B2" onclick="executeAction('theodoiKN')">
			</logic:equal>
			<logic:equal name="action" value="theodoiTC">
				<input type="button" class="button" value='Theo dõi thi hành' name="B2" onclick="executeAction('theodoiTC')">
			</logic:equal>
			<logic:equal name="action" value="qdxmkn">
				<input type="button" class="button" value='Quyết định xác minh' name="B2" onclick="executeAction('qdxmkn')">
			</logic:equal>
			<logic:equal name="action" value="qdxmtc">
				<input type="button" class="button" value='Quyết định xác minh' name="B2" onclick="executeAction('qdxmtc')">
			</logic:equal>
			<logic:equal name="action" value="bbLamViecNguoiTC0">
				<input type="button" class="button" value='Lập biên bản làm việc' name="B2" onclick="executeAction('bbLamViecNguoiTC0')">
			</logic:equal>
			<logic:equal name="action" value="khxmkn">
				<input type="button" class="button" value='Kế hoạch xác minh' name="B2" onclick="executeAction('khxmkn')">
			</logic:equal>
			<logic:equal name="action" value="khxmtc">
				<input type="button" class="button" value='Kế hoạch xác minh' name="B2" onclick="executeAction('khxmtc')">
			</logic:equal>
			<logic:equal name="action" value="bbxmkn">
				<input type="button" class="button" value='Biên bản công bố QĐXM' name="B2" onclick="executeAction('bbxmkn')">
			</logic:equal>
			<logic:equal name="action" value="bbxmtc">
				<input type="button" class="button" value='Biên bản công bố QĐXM' name="B2" onclick="executeAction('bbxmtc')">
			</logic:equal>
			<logic:equal name="action" value="25A">
				<input type="button" class="button" value='Phiếu chuyển sang cơ quan điều tra' name="B2" onclick="executeAction('25A')">
			</logic:equal>
			<logic:equal name="action" value="25B">
				<input type="button" class="button" value='Biên bản bàn giao hồ sơ vụ việc' name="B2" onclick="executeAction('25B')">
			</logic:equal>
			<logic:equal name="action" value="tbkqgqtc">
				<input type="button" class="button" value='Thông báo KQGQ' name="B2" onclick="executeAction('tbkqgqtc')">
			</logic:equal>
			<logic:equal name="action" value="ketLuanTC">
				<input type="button" class="button" value='Kết luận nội dung TC' id="ketLuanTC" onclick="executeAction('ketLuanTC')">
			</logic:equal>
			<logic:equal name="action" value="phieuYcHsTlKN">
				<input type="button" class="button" value='Lập phiếu yêu cầu cung cấp HS,TL' id="phieuYcHsTlKN" onclick="executeAction('phieuYcHsTlKN')">
			</logic:equal>
			<logic:equal name="action" value="phieuYcHsTlTC">
				<input type="button" class="button" value='Lập phiếu yêu cầu cung cấp HS,TL' id="phieuYcHsTlTC" onclick="executeAction('phieuYcHsTlTC')">
			</logic:equal>
			<logic:equal name="action" value="bbYeuCauBoSungHSTLTC">
				<input type="button" class="button" value='Lập biên bản làm việc' name="B2" onclick="executeAction('bbYeuCauBoSungHSTLTC')">
			</logic:equal>
			<logic:equal name="action" value="bbLamViecNguoiBiTC">
				<input type="button" class="button" value='Lập biên bản làm việc' name="B2" onclick="executeAction('bbLamViecNguoiBiTC')">
			</logic:equal>
			<logic:equal name="action" value="bbLamViecNguoiTC">
				<input type="button" class="button" value='Lập biên bản làm việc' name="B2" onclick="executeAction('bbLamViecNguoiTC')">
			</logic:equal>
			<logic:equal name="action" value="phieuYcGtKN">
				<input type="button" class="button" value='Lập phiếu yêu cầu giải trình' id="phieuYcGtKN" onclick="executeAction('phieuYcGtKN')">
			</logic:equal>
			<logic:equal name="action" value="phieuYcGtTC">
				<input type="button" class="button" value='Lập phiếu yêu cầu giải trình' id="phieuYcGtTC" onclick="executeAction('phieuYcGtTC')">
			</logic:equal>
			<logic:equal name="action" value="bbLamViecNguoiKN0">
				<input type="button" class="button" value='Lập biên bản làm việc' name="B2" onclick="executeAction('bbLamViecNguoiKN0')">
			</logic:equal>
			<logic:equal name="action" value="bbLamViecNguoiKN">
				<input type="button" class="button" value='Lập biên bản làm việc' name="B2" onclick="executeAction('bbLamViecNguoiKN')">
			</logic:equal>
			<logic:equal name="action" value="bbLamViecNguoiBiKN">
				<input type="button" class="button" value='Lập biên bản làm việc' name="B2" onclick="executeAction('bbLamViecNguoiBiKN')">
			</logic:equal>
			<logic:equal name="action" value="baoCaoGtKN">
				<input type="button" class="button" value='Lập Báo cáo Giải trình' id="baoCaoGtKN" onclick="executeAction('baoCaoGtKN')">
			</logic:equal>
			<logic:equal name="action" value="baoCaoGtTC">
				<input type="button" class="button" value='Lập Báo cáo Giải trình' id="baoCaoGtTC" onclick="executeAction('baoCaoGtTC')">
			</logic:equal>
			<logic:equal name="action" value="yktvKN">
				<input type="button" class="button" value='Lập phiếu lấy ý kiến tư vấn' id="yktvKN" onclick="executeAction('yktvKN')">
			</logic:equal>
			<logic:equal name="action" value="yktvTC">
				<input type="button" class="button" value='Lập phiếu lấy ý kiến tư vấn' id="yktvTC" onclick="executeAction('yktvTC')">
			</logic:equal>
			<logic:equal name="action" value="ycgdKN">
				<input type="button" class="button" value='Lập phiếu giám định' id="ykgdKN" onclick="executeAction('ycgdKN')">
			</logic:equal>
			<logic:equal name="action" value="ycgdTC">
				<input type="button" class="button" value='Lập phiếu giám định' id="ykgdTC" onclick="executeAction('ycgdTC')">
			</logic:equal>
			<logic:equal name="action" value="giahanKN">
				<input type="button" class="button" value='Gia hạn thời gian xác minh' id="giahanKN" onclick="executeAction('giahanKN')">
			</logic:equal>
			<logic:equal name="action" value="giahanTC">
				<input type="button" class="button" value='Gia hạn thời gian xác minh' id="giahanTC" onclick="executeAction('giahanTC')">
			</logic:equal>
			<logic:equal name="action" value="kqxmKN">
				<input type="button" class="button" value='Báo cáo kết quả xác minh nội dung' id="kqxmKN" onclick="executeAction('kqxmKN')">
			</logic:equal>
			<logic:equal name="action" value="bckqxmTC">
				<input type="button" class="button" value='Báo cáo kết quả xác minh nội dung' id="bckqxmTC" onclick="executeAction('bckqxmTC')">
			</logic:equal>
			<logic:equal name="action" value="xacMinhKhieuNai">
				<input type="button" class="button" value='Xác minh khiếu nại' id="xacMinhKhieuNai" onclick="executeAction('xacMinhKhieuNai')">
			</logic:equal>
			<logic:equal name="action" value="ketThucKhieuNai">
				<input type="button" class="button" value='Kết thúc giải quyết khiếu nại' id="ketThucKhieuNai" onclick="executeAction('ketThucKhieuNai')">
			</logic:equal>
			<logic:equal name="action" value="ketThucToCao">
				<input type="button" class="button" value='Kết thúc giải quyết tố cáo' id="ketThucToCao" onclick="executeAction('ketThucToCao')">
			</logic:equal>
			<logic:equal name="action" value="xacMinhToCao">
				<input type="button" class="button" value='Xác minh tố cáo' id="xacMinhToCao" onclick="executeAction('xacMinhToCao')">
			</logic:equal>
			<logic:equal name="action" value="copyHs">
				<input type="button" class="button" value='Xử lý hồ sơ' id="copyHs" onclick="executeAction('copyHs')">
			</logic:equal>
			<logic:equal name="action" value="gopHs">
				<input type="button" class="button" value='Xử lý hồ sơ' id="gopHs" onclick="executeAction('gopHs')">
			</logic:equal>
			
			<logic:equal name="action" value="xuLyKhieuNai">
				<input type="button" class="button" value='Xử lý khiếu nại' id="xuLyKhieuNai" onclick="executeAction('xuLyKhieuNai')">
			</logic:equal>
			<logic:equal name="action" value="xuLyToCao">
				<input type="button" class="button" value='Xử lý tố cáo' id="xuLyToCao" onclick="executeAction('xuLyToCao')">
			</logic:equal>
		</logic:present> <input type="button" class="button" value='Đóng' name="B3" onclick="goHomeKntc();"></td>
	</tr>
</table>
</html:form>
<script type="text/javascript" charset="utf-8"> 
var oTable;
var showAdvanceSearch = 'false';
$(function(){			
	var act = '<%=request.getParameter("action")%>';
 	if(act=='bosungHS' || act=='chuyenHS' || act=='tktiepdan' || act=='suaHSTD'){
 		document.getElementById("txtNgayTiep").innerHTML = 'Ngày tiếp';
 	}else if(act=='chonXLHS1Lan'){
 		document.getElementById("txtNgayTiep").innerHTML = 'Ngày tiếp';
 	}else {
 		document.getElementById("txtNgayTiep").innerHTML = 'Ngày CV đến';
 	}	
  	//Ẩn hiện search advance
  	showAdvanceSearch = '<%=request.getParameter("showAdvanceSeach")%>';
  	if('true' == showAdvanceSearch){
  		show_advance_search();
  	}  	
  	else{
  		hide_advance_search();
  	}
  	//var url=encodeURI('kntc_tim_kiem.do?method=search&maHs=%'+$('#data').val()+'%&nnd='+$('#nguoiNopDon').val()+'&cbxl='+$('#canBoXL').val()+'&nuq='+$('#nguoiUyQuyen').val()+'&tSearch='+$('#textSearch').val()+'&tt='+$('#tt').val()+'&loai='+$('#loai').val()+'&sDate='+$('#sDate').val()+'&fDate='+$('#fDate').val()+'&cvsDate='+$('#cvsDate').val()+'&cvfDate='+$('#cvfDate').val()+'&action='+act);
  	//var url=encodeURI('kntc_tim_kiem.do?method=search');
 	oTable=$("#hs_table").dataTable({ 
 		"sScrollY": "320px",
 		"sScrollX": "100%",
 		"sScrollXInner": "100%", 		
 		"bJQueryUI":true,"bLengthChange": false,
 		"bScrollCollapse": true,
 		"bProcessing": true,
 		"bServerSide": true,
 		"iDisplayLength": 10,"sDom":'<"H"fr>t<"F"p>', 
		"bSort": false,"bFilter": false,
		"sAjaxSource":'',
		"bAutoWidth" : false,
 	    "oLanguage":language,
 	    "sPaginationType": "full_numbers",
 	    //"aoColumns": [null, {"bVisible":false },null,null,null,null,null,null],   	    
 	    "aoColumns" : [   
       { sClass: "hideextra"},   
       { sClass: "hiddenall"},  
       { sClass: "hideextra" },
       { sClass: "hideextra" },
       { sClass: "hideextra" },
       { sClass: "hideextra" },
       { sClass: "hideextra" },
       { sClass: "hideextra" },
       { sClass: "hideextra" },
       { sClass: "hideextra" },
       { sClass: "hideextra" }]
  	});      
 	//$('#hs_table tr td:nth-child(1)').addClass('hideextra');	   	
 	new FixedColumns(oTable,{"iLeftColumns":1,"iLeftWidth":150});	
 	
 	$('#data').val('');	
	
	$("#hs_table tbody").click(function(event) {
		try{
			$(oTable.fnSettings().aoData).each(function (){
				$(this.nTr).removeClass('row_selected');
			});
			$(event.target.parentNode).addClass('row_selected');
		    var iPos=oTable.fnGetPosition(event.target.parentNode);
			var aData=oTable.fnGetData(iPos);			
		 	$('#data').val(aData[1]);
	 	}catch(e){
	 		
	 	}
	});	
  	
	var xoaTC = "";
	
	xoaTC = '<%=session.getAttribute("xoaThanhcong")%>';
	<%session.removeAttribute("xoaThanhcong");%>
	
	if(xoaTC=='1')
	  alert('Xóa dữ liệu thành công!'); 
	else  if(xoaTC=='0')
	  alert('Lỗi khi xóa dữ liệu!!!');
	window.setTimeout("filter()",500);  
	setInterval('getTotal()', 3000);
});
var noiDung='';
function getTotal(){
	document.all.divTotal.innerHTML = "Tìm được tổng số <font color='red'>"+oTable.fnSettings().fnRecordsTotal()+"</font> bản ghi";
}
function chuyenHS(){
	var ma=$('#data').val();
  	if (isEmpty(ma)){
  	  alert(chua_chon_ban_ghi);
      return false;
  	}
	window.location = "kntc_giay_bn.do?method=cghs&id="+ma;
		//oTable.fnDeleteRow( anSelected[0] );	
}
function phancongHS(){
	var ma=$('#data').val();
  	if (isEmpty(ma)){
  	  alert(chua_chon_ban_ghi);
      return false;
  	}
	openWindow("kntc_phan_cong_can_bo.do?method=show&id="+ma,1000,500,false);
}
function bosungHS(){
	
}
function xemLichTrinh(){
	var maHS  = getValRadio(document.forms[0].selectValue);
	window.location = "kntc_giay_bn.do?method=cghs&id="+maHS;	
}
function phancongCBXly(){
	var maHS  = getValRadio(document.forms[0].selectValue);
	window.location = "kntc_phan_cong.do?method=show&id="+maHS;	
}

//search button click
function filter(){
	var s="";
	//document.forms[0].arrCqt.value = getCheckedSave();
	s=getCheck(document.forms[0].selectCqt);	
	var trungDon = document.getElementById("trungDon").checked?1:0;
	var luuDon = document.getElementById("luuDon").checked?1:0;	
	var oSettings =oTable.fnSettings();
	var act = '<%=request.getParameter("action")%>';	
	
    var url=encodeURI('kntc_tim_kiem.do?method=search&maHs=%'+$('#ma').val()+'%&nnd='+$('#nguoiNopDon').val()
    +'&trungDon='+trungDon+'&doanKNTC='+$('#doanKNTC').val()+'&luuDon='+luuDon+'&cbxl='+$('#canBoXL').val()
    +'&nuq='+$('#nguoiUyQuyen').val()+'&tSearch='+$('#textSearch').val()
    +'&tdTuNgay='+$('#tdTuNgay').val()+'&tdDenNgay='+$('#tdDenNgay').val()
    +'&tt='+$('#tt').val()+'&loai='+$('#loai').val()+'&sDate='+$('#sDate').val()
    +'&fDate='+$('#fDate').val()+'&cvsDate='+$('#cvsDate').val()+'&cvfDate='+$('#cvfDate').val()
    +'&cqt='+s+'&action='+act+'&loaiQuanHe='+$('#loaiQuanHe').val()+'&loaiKetThuc='+$('#loaiKetThuc').val()
    +'&thamQuyen='+$('#thamQuyen').val()+'&thuLy='+$('#thuLy').val());
	oSettings.sAjaxSource=url;
	
	//alert(url);
	oTable.fnDraw();
	window.setTimeout("getTotal()",120);
}
function executeAction(action){	
	var ma=$('#data').val();
  	if (isEmpty(ma)){
  	  alert(chua_chon_ban_ghi);
      return false;
  	}
  	if('qdgq'==action) window.location = encodeURI("kntc_qdgq.do?method=qdgq&id="+ma);
	else if('rutdon'==action) window.location = encodeURI("kntc_qdgq.do?method=rutdon&id="+ma);
	else if('chonXLHS1Lan'==action) window.location = encodeURI("kntc_da_tiep_nhan.do?method=show&id="+ma);
	else if('theodoiKN'==action) window.location = encodeURI("kntc_qdgq.do?method=theodoi&id="+ma);
	else if('theodoiTC'==action) window.location = encodeURI("kntc_qdgq.do?method=theodoi&id="+ma);
	else if('phanloaiHSKN'==action) window.location = encodeURI("phieu_dxxl_kn.do?method=show&id="+ma+"&action=phanloaiHSKN");
	else if('phanloaiHSTC'==action) window.location = encodeURI("phieu_dxxl_kn.do?method=show&id="+ma+"&action=phanloaiHSTC");
	else if('pchs'==action) window.location =encodeURI("kntc_phan_cong_can_bo.do?method=show&id="+ma);
	else if('chs'==action) window.location = encodeURI("kntc_giay_bn.do?method=cghs&id="+ma);
	else if('qdxmtc'==action) window.location = encodeURI("kntc_xac_minh.do?method=show&id="+ma);
	else if('qdxmkn'==action) window.location = encodeURI("kntc_xac_minh.do?method=show&id="+ma);
	else if('khxmkn'==action) window.location = encodeURI("kntc_khxm.do?method=khxm&id="+ma);
	else if('bckqxmKN'==action) window.location = encodeURI("kntc_kq_xm.do?method=baocao&action=bckqxm&id="+ma);
	else if('khxmtc'==action) window.location = encodeURI("kntc_khxm.do?method=khxmtc&id="+ma);
	else if('bbxmkn'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbxmkn&id="+ma);
	else if('bbThongBaoDuThaoTC'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbThongBaoDuThaoTC&id="+ma);
	else if('bbxmtc'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbxmtc&id="+ma);
	else if('bshs'==action) window.location = encodeURI("kntc_bo_sung_hs.do?method=showTlkt&action=bshs&maHs="+ma);	
	else if('25A'==action) window.location = encodeURI("kntc_dxxl.do?method=chuyenDieuTra&action=25A&id="+ma);
	else if('25B'==action) window.location = encodeURI("kntc_bb.do?method=bb25B&action=25B&id="+ma);
	else if('tbkqgqtc'==action) window.location = encodeURI("tb_kqgq_tc.do?method=show&action=tbkqgqtc&id="+ma);
	else if('tachDon'==action) window.location = encodeURI("kntc_tach_don.do?method=tachDon&action=tachDon&id="+ma);
	else if('bbLamViecNguoiTC0'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbLamViecNguoiTC0&id="+ma);
	else if('lichTrinhDKKN'==action) window.location = encodeURI("lich_trinh_du_kien.do?method=show&action=lichTrinhDKKN&id="+ma);
	else if('ketLuanTC'==action) window.location = encodeURI("kntc_kq_xm_tc.do?method=ketLuanTc&action=ketLuanTc&id="+ma);
	else if('bbDoiThoaiKN'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbDoiThoai&id="+ma);
	else if('lichTrinhDKTC'==action) window.location = encodeURI("lich_trinh_du_kien.do?method=show&action=lichTrinhDKTC&id="+ma);	
	else if('phieuYcHsTlKN'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=show&action=phieuYcHsTlKN&id="+ma);
  	else if('phieuYcHsTlTC'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=show&action=phieuYcHsTlTC&id="+ma);
	else if('phieuYcGtKN'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=ycgt&action=phieuYcGtKN&id="+ma);
	else if('phieuYcGtTC'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=ycgt&action=phieuYcGtTC&id="+ma);
	else if('baoCaoGtKN'==action) window.location = encodeURI("kntc_xm_bao_cao.do?method=show&action=baoCaoGtKN&id="+ma);
	else if('baoCaoGtTC'==action) window.location = encodeURI("kntc_xm_bao_cao.do?method=show&action=baoCaoGtTC&id="+ma);
	else if('yktvKN'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=yktv&action=yktvKN&id="+ma);
	else if('yktvTC'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=yktv&action=yktvTC&id="+ma);
	else if('ycgdKN'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=tcgd&action=ycgdKN&id="+ma);
	else if('ycgdTC'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=tcgd&action=ycgdTC&id="+ma);
	else if('bbYeuCauBoSungHSTLTC'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbYeuCauBoSungHSTLTC&id="+ma);
	else if('giahanKN'==action) window.location = encodeURI("kntc_xm_gia_han.do?method=giahan&action=giahanKN&id="+ma);
	else if('giahanTC'==action) window.location = encodeURI("kntc_xm_gia_han.do?method=giahan&action=giahanTC&id="+ma);
	else if('kqxmKN'==action) window.location = encodeURI("kntc_xac_minh.do?method=bbKqXm&action=kqxmKN&id="+ma);
	else if('bbLamViecNguoiKN0'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbLamViecNguoiKN0&id="+ma);
	else if('bbLamViecNguoiKN'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbLamViecNguoiKN&id="+ma);
	else if('bbLamViecNguoiBiKN'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbLamViecNguoiBiKN&id="+ma);
	else if('bckqxmTC'==action) window.location = encodeURI("kntc_kq_xm_tc.do?method=bcKqXmTc&action=bckqxmTC&id="+ma);
	else if('bbLamViecNguoiTC'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbLamViecNguoiTC&id="+ma);
	else if('bbLamViecNguoiBiTC'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbLamViecNguoiBiTC&id="+ma);
	else if('xacMinhKhieuNai'==action) window.location = encodeURI("kntc_xac_minh.do?method=xacMinh&action=xacMinhKhieuNai&id="+ma);	
	else if('xacMinhToCao'==action) window.location = encodeURI("kntc_xac_minh.do?method=xacMinh&action=xacMinhToCao&id="+ma);
	else if('ketThucKhieuNai'==action) window.location = encodeURI("kntc_kq_xm.do?method=ketThuc&action=ketThucKhieuNai&id="+ma);
	else if('ketThucToCao'==action) window.location = encodeURI("kntc_kq_xm.do?method=ketThuc&action=ketThucToCao&id="+ma);
	else if('copyHs'==action) window.location = encodeURI("kntc_tiep_dan_van_thu.do?method=copy&id="+ma);
	else if('gopHs'==action) window.location = encodeURI("kntc_da_tiep_nhan.do?method=gopHs&id="+ma);	
	else if('xuLyKhieuNai'==action) window.location = encodeURI("phieu_dxxl_kn.do?method=show&action=phanloaiHSKN&id="+ma);
	else if('xuLyToCao'==action) window.location = encodeURI("phieu_dxxl_kn.do?method=show&action=phanloaiHSTC&id="+ma);
}
function validDateRange(){
	if(!compareDate(document.forms[0].sDate,document.forms[0].fDate))
	return false;
	if(!compareDate(document.forms[0].cvsDate,document.forms[0].cvfDate))
	return false;
	return true;
}
function del(){
	if (confirm("Bạn có chắc chắn muốn xóa?")){
		var ma=$('#data').val();
	  	if (isEmpty(ma)){
	  	  alert(chua_chon_ban_ghi);
	      return false;
	  	}
		window.location = "kntc_tim_kiem.do?method=del&id="+ma;
	}
}
function changeTrangThai(){
	var action = '<%=request.getParameter("action")%>';
	filter();
}
function view(){
	var ma=$('#data').val();
	if (isEmpty(ma)){
	  	  alert(chua_chon_ban_ghi);
	      return false;
	}
	var action = '<%=request.getParameter("action")%>';
	if('tktiepdan' == action){
 		window.location = "kntc_tiep_dan.do?method=view&id="+ma;
 	}else{
 		window.location = "kntc_tiep_dan_van_thu.do?method=view&id="+ma;
 	}
}
function edit(){
	var ma=$('#data').val();
	if (isEmpty(ma)){
	  	  alert(chua_chon_ban_ghi);
	      return false;
	}
	window.location = "kntc_tiep_dan.do?method=edit&id="+ma+"&action=suaHSTD";
}
function edittkxl(){
	var ma=$('#data').val();
	if (isEmpty(ma)){
	  	  alert(chua_chon_ban_ghi);
	      return false;
	}
	window.location = "kntc_tiep_dan_van_thu.do?method=edit&id="+ma+"&action=suaHSVT";
}
function xoa(){
	var ma=$('#data').val();
	if (isEmpty(ma)){
	  	  alert(chua_chon_ban_ghi);
	      return false;
	}else{
		if (confirm("Bạn có chắc chắn muốn xóa?")){
			window.location = "kntc_tim_kiem.do?method=del&id="+ma+"&action=xoaHSTD";
		}
	}
}
function xoavt(){
	var ma=$('#data').val();
	if (isEmpty(ma)){
	  	  alert(chua_chon_ban_ghi);
	      return false;
	}else{
		if (confirm("Bạn có chắc chắn muốn xóa?")){
		window.location = "kntc_tim_kiem.do?method=del&id="+ma+"&action=xoaHSVT";
		}
	}
}
function searchKeyPress(e){
      if (window.event) { e = window.event; }
      if (e.keyCode == 13){
         document.getElementById('btnSearch').click();
    }    
}
function changeIDisplayStart(){
	var oSettings = oTable.fnSettings();
	oSettings._iDisplayStart = 0;
}
function search(){	
	//alert('search');
	var act = '<%=request.getParameter("action")%>';
	document.forms[0].action='kntc_tim_kiem.do?method=show&action='+act;
	document.forms[0].submit();
}
//Thay đổi loại hồ sơ
function changeLoaiHs(loai){	
	var act = '<%=request.getParameter("action")%>';	
	document.forms[0].action='kntc_tim_kiem.do?method=show&loai=' + loai+'&showAdvanceSeach='+showAdvanceSearch+'&action='+act;
	document.forms[0].submit();	
}
//Thay đổi thẩm quyền
function changeThamQuyen(thamQuyen){	
	var act = '<%=request.getParameter("action")%>';
	document.forms[0].action='kntc_tim_kiem.do?method=show&loai=' + $('#loai').val()+'&thamQuyen=' + thamQuyen+'&showAdvanceSeach='+showAdvanceSearch+'&action='+act;
	document.forms[0].submit();
}
function show_advance_search(){
	show("advance-search");
	show("btnHideAdvanceSeach");
	hide("btnShowAdvanceSeach");
	showAdvanceSearch = 'true';
}
function hide_advance_search(){
	hide("advance-search");
	hide("btnHideAdvanceSeach");
	show("btnShowAdvanceSeach");
	showAdvanceSearch = 'false';
}
function setSelectData(data){
	alert(data);
}
</script>
<%@ include file="/bottom.jsp"%>
