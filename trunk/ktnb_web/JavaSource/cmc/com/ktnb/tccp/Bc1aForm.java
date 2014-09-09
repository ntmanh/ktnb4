package cmc.com.ktnb.tccp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.KntcXmKeHoach;
import cmc.com.ktnb.pl.hb.entity.Ttcp1a;
import cmc.com.ktnb.pl.hb.entity.Ttcp2a;
import cmc.com.ktnb.pl.hb.entity.Ttcp2b;
import cmc.com.ktnb.pl.hb.entity.TtcpBaoCaoId;
import cmc.com.ktnb.service.TtcpService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Báo cáo form
 * @author Ntthu
 * Created on 16/04/2011
 */
public class Bc1aForm extends BaseActionForm {	
	private String maCqt;
	private Integer nam;
	private Integer thang;
	//So lieu lay tu bao cao
	//	So lieu +-
	private Long TONG_SO;
	//	So lieu goc
	private Long KHN;
	private Long KHN_TH_KY_TRUOC;
	private Long KHN_TH_TRONG_KY;
	private Long KHN_TH_THEO_KH;
	private Long KHN_TH_DX;
	private Long KHN_TD_KT_TRUC_TIEP;
	private Long KHN_TD_KT_KET_LUAN;
	private Long SO_DV_DUOC_KT;
	private Long SO_DV_SAI_PHAM;
	private Long TSP_TIEN;
	private Long TSP_KHAC;
	private Long KNTH_TIEN;
	private Long KNTH_KHAC;
	private Long KNKHAC_TIEN;
	private Long KNKHAC_KHAC;
	private Long KNXL_HANH_CHINH;
	private Long KNXL_HINH_SU_VU;
	private Long KNXL_HINH_SU_NGUOI;
	private Long KQ_SO_NGUOI;
	private Long KQ_HC_RUT_KN;
	private Long KQ_HC_KHIEN_TRACH;
	private Long KQ_HC_CANH_CAO;
	private Long KQ_HC_HA_LUONG;
	private Long KQ_HC_GIANG_CHUC;
	private Long KQ_HC_CACH_CHUC;
	private Long KQ_HC_THOI_VIEC;
	private Long KQ_HS;
	//So lieu can nhap	
	private Long daThuTien;
	private Long daThuKhac;
	private Long kiemTraTongSo;
	private Long kiemTraTienPhaiThu;
	private Long kiemTraTienDaThu;
	private Long kiemTraKhacPhaiThu;
	private Long kiemTraKhacDaThu;
	private Long kiemTraDaXlyHC;
	private Long kiemTraKhoiToVu;
	private Long kiemTraKhoiToNguoi;
	private String ngayCuoiThang;
	
	public void fromEntity(Ttcp1a entity, ApplicationContext c) throws Exception {
		this.maCqt = entity.getId().getMaCqt();
		this.nam = entity.getId().getNam();
		this.thang = entity.getId().getThang();
		//So lieu lay tu bao cao
		this.getSoLieuTuBaoCao(thang.toString()+"/"+nam.toString(),maCqt,nam.intValue(),nam.intValue()+1);
		//So lieu nhap
		this.daThuTien = entity.getDaThuTien();
		this.daThuKhac = entity.getDaThuKhac();
		this.kiemTraTongSo = entity.getKiemTraTongSo();
		this.kiemTraTienPhaiThu = entity.getKiemTraTienPhaiThu();
		this.kiemTraTienDaThu = entity.getKiemTraTienDaThu();
		this.kiemTraKhacPhaiThu = entity.getKiemTraKhacPhaiThu();
		this.kiemTraKhacDaThu = entity.getKiemTraKhacDaThu();
		this.kiemTraDaXlyHC = entity.getKiemTraDaXlyHC();
		this.kiemTraKhoiToVu = entity.getKiemTraKhoiToVu();
		this.kiemTraKhoiToNguoi = entity.getKiemTraKhoiToNguoi();
		this.ngayCuoiThang = Formater.date2strDateTimeForNV(entity.getNgayCuoiThang());
	}
	public Ttcp1a toEntity() throws Exception{
		Ttcp1a entity = new Ttcp1a();
		TtcpBaoCaoId id = new TtcpBaoCaoId();
		id.setMaCqt(this.maCqt);
		id.setNam(this.nam);
		id.setThang(this.thang);
		entity.setId(id);
		entity.setDaThuTien(this.daThuTien);
		entity.setDaThuKhac(this.daThuKhac);
		entity.setKiemTraTongSo(this.kiemTraTongSo);
		entity.setKiemTraTienPhaiThu(this.kiemTraTienPhaiThu);
		entity.setKiemTraTienDaThu(this.kiemTraTienDaThu);
		entity.setKiemTraKhacPhaiThu(this.kiemTraKhacPhaiThu);
		entity.setKiemTraKhacDaThu(this.kiemTraKhacDaThu);
		entity.setKiemTraDaXlyHC(this.kiemTraDaXlyHC);
		entity.setKiemTraKhoiToVu(this.kiemTraKhoiToVu);
		entity.setKiemTraKhoiToNguoi(this.kiemTraKhoiToNguoi);
		entity.setNgayCuoiThang(Formater.str2dateForNV(this.getNgayCuoiThang()));
		
		return entity;
	}
	public void getSoLieuTuBaoCao(String thoiGian, String maCqt, int nam, int namSau){
		TtcpService service = new TtcpService();	
		service.getSoLieuTuBaoCao1A(this, thoiGian, maCqt, nam, namSau);		
	}
	public Long getDaThuKhac() {
		return daThuKhac;
	}
	public void setDaThuKhac(Long daThuKhac) {
		this.daThuKhac = daThuKhac;
	}
	public Long getDaThuTien() {
		return daThuTien;
	}
	public void setDaThuTien(Long daThuTien) {
		this.daThuTien = daThuTien;
	}
	public Long getKiemTraDaXlyHC() {
		return kiemTraDaXlyHC;
	}
	public void setKiemTraDaXlyHC(Long kiemTraDaXlyHC) {
		this.kiemTraDaXlyHC = kiemTraDaXlyHC;
	}
	public Long getKiemTraKhacDaThu() {
		return kiemTraKhacDaThu;
	}
	public void setKiemTraKhacDaThu(Long kiemTraKhacDaThu) {
		this.kiemTraKhacDaThu = kiemTraKhacDaThu;
	}
	public Long getKiemTraKhacPhaiThu() {
		return kiemTraKhacPhaiThu;
	}
	public void setKiemTraKhacPhaiThu(Long kiemTraKhacPhaiThu) {
		this.kiemTraKhacPhaiThu = kiemTraKhacPhaiThu;
	}
	public Long getKiemTraKhoiToNguoi() {
		return kiemTraKhoiToNguoi;
	}
	public void setKiemTraKhoiToNguoi(Long kiemTraKhoiToNguoi) {
		this.kiemTraKhoiToNguoi = kiemTraKhoiToNguoi;
	}
	public Long getKiemTraKhoiToVu() {
		return kiemTraKhoiToVu;
	}
	public void setKiemTraKhoiToVu(Long kiemTraKhoiToVu) {
		this.kiemTraKhoiToVu = kiemTraKhoiToVu;
	}
	public Long getKiemTraTienDaThu() {
		return kiemTraTienDaThu;
	}
	public void setKiemTraTienDaThu(Long kiemTraTienDaThu) {
		this.kiemTraTienDaThu = kiemTraTienDaThu;
	}
	public Long getKiemTraTienPhaiThu() {
		return kiemTraTienPhaiThu;
	}
	public void setKiemTraTienPhaiThu(Long kiemTraTienPhaiThu) {
		this.kiemTraTienPhaiThu = kiemTraTienPhaiThu;
	}
	public Long getKiemTraTongSo() {
		return kiemTraTongSo;
	}
	public void setKiemTraTongSo(Long kiemTraTongSo) {
		this.kiemTraTongSo = kiemTraTongSo;
	}
	public String getMaCqt() {
		return maCqt;
	}
	public void setMaCqt(String maCqt) {
		this.maCqt = maCqt;
	}
	public Integer getNam() {
		return nam;
	}
	public void setNam(Integer nam) {
		this.nam = nam;
	}
	public String getNgayCuoiThang() {
		return ngayCuoiThang;
	}
	public void setNgayCuoiThang(String ngayCuoiThang) {
		this.ngayCuoiThang = ngayCuoiThang;
	}
	public Integer getThang() {
		return thang;
	}
	public void setThang(Integer thang) {
		this.thang = thang;
	}
	
	public Long getKHN() {
		return KHN;
	}
	public void setKHN(Long khn) {
		KHN = khn;
	}
	public Long getKHN_TD_KT_KET_LUAN() {
		return KHN_TD_KT_KET_LUAN;
	}
	public void setKHN_TD_KT_KET_LUAN(Long khn_td_kt_ket_luan) {
		KHN_TD_KT_KET_LUAN = khn_td_kt_ket_luan;
	}
	public Long getKHN_TD_KT_TRUC_TIEP() {
		return KHN_TD_KT_TRUC_TIEP;
	}
	public void setKHN_TD_KT_TRUC_TIEP(Long khn_td_kt_truc_tiep) {
		KHN_TD_KT_TRUC_TIEP = khn_td_kt_truc_tiep;
	}
	public Long getKHN_TH_DX() {
		return KHN_TH_DX;
	}
	public void setKHN_TH_DX(Long khn_th_dx) {
		KHN_TH_DX = khn_th_dx;
	}
	public Long getKHN_TH_KY_TRUOC() {
		return KHN_TH_KY_TRUOC;
	}
	public void setKHN_TH_KY_TRUOC(Long khn_th_ky_truoc) {
		KHN_TH_KY_TRUOC = khn_th_ky_truoc;
	}
	public Long getKHN_TH_THEO_KH() {
		return KHN_TH_THEO_KH;
	}
	public void setKHN_TH_THEO_KH(Long khn_th_theo_kh) {
		KHN_TH_THEO_KH = khn_th_theo_kh;
	}
	public Long getKHN_TH_TRONG_KY() {
		return KHN_TH_TRONG_KY;
	}
	public void setKHN_TH_TRONG_KY(Long khn_th_trong_ky) {
		KHN_TH_TRONG_KY = khn_th_trong_ky;
	}
	public Long getKNKHAC_KHAC() {
		return KNKHAC_KHAC;
	}
	public void setKNKHAC_KHAC(Long knkhac_khac) {
		KNKHAC_KHAC = knkhac_khac;
	}
	public Long getKNKHAC_TIEN() {
		return KNKHAC_TIEN;
	}
	public void setKNKHAC_TIEN(Long knkhac_tien) {
		KNKHAC_TIEN = knkhac_tien;
	}
	public Long getKNTH_KHAC() {
		return KNTH_KHAC;
	}
	public void setKNTH_KHAC(Long knth_khac) {
		KNTH_KHAC = knth_khac;
	}
	public Long getKNTH_TIEN() {
		return KNTH_TIEN;
	}
	public void setKNTH_TIEN(Long knth_tien) {
		KNTH_TIEN = knth_tien;
	}
	public Long getKNXL_HANH_CHINH() {
		return KNXL_HANH_CHINH;
	}
	public void setKNXL_HANH_CHINH(Long knxl_hanh_chinh) {
		KNXL_HANH_CHINH = knxl_hanh_chinh;
	}
	public Long getKNXL_HINH_SU_NGUOI() {
		return KNXL_HINH_SU_NGUOI;
	}
	public void setKNXL_HINH_SU_NGUOI(Long knxl_hinh_su_nguoi) {
		KNXL_HINH_SU_NGUOI = knxl_hinh_su_nguoi;
	}
	public Long getKNXL_HINH_SU_VU() {
		return KNXL_HINH_SU_VU;
	}
	public void setKNXL_HINH_SU_VU(Long knxl_hinh_su_vu) {
		KNXL_HINH_SU_VU = knxl_hinh_su_vu;
	}
	public Long getKQ_HC_CACH_CHUC() {
		return KQ_HC_CACH_CHUC;
	}
	public void setKQ_HC_CACH_CHUC(Long kq_hc_cach_chuc) {
		KQ_HC_CACH_CHUC = kq_hc_cach_chuc;
	}
	public Long getKQ_HC_CANH_CAO() {
		return KQ_HC_CANH_CAO;
	}
	public void setKQ_HC_CANH_CAO(Long kq_hc_canh_cao) {
		KQ_HC_CANH_CAO = kq_hc_canh_cao;
	}
	public Long getKQ_HC_GIANG_CHUC() {
		return KQ_HC_GIANG_CHUC;
	}
	public void setKQ_HC_GIANG_CHUC(Long kq_hc_giang_chuc) {
		KQ_HC_GIANG_CHUC = kq_hc_giang_chuc;
	}
	public Long getKQ_HC_HA_LUONG() {
		return KQ_HC_HA_LUONG;
	}
	public void setKQ_HC_HA_LUONG(Long kq_hc_ha_luong) {
		KQ_HC_HA_LUONG = kq_hc_ha_luong;
	}
	public Long getKQ_HC_KHIEN_TRACH() {
		return KQ_HC_KHIEN_TRACH;
	}
	public void setKQ_HC_KHIEN_TRACH(Long kq_hc_khien_trach) {
		KQ_HC_KHIEN_TRACH = kq_hc_khien_trach;
	}
	public Long getKQ_HC_RUT_KN() {
		return KQ_HC_RUT_KN;
	}
	public void setKQ_HC_RUT_KN(Long kq_hc_rut_kn) {
		KQ_HC_RUT_KN = kq_hc_rut_kn;
	}
	public Long getKQ_HC_THOI_VIEC() {
		return KQ_HC_THOI_VIEC;
	}
	public void setKQ_HC_THOI_VIEC(Long kq_hc_thoi_viec) {
		KQ_HC_THOI_VIEC = kq_hc_thoi_viec;
	}
	public Long getKQ_HS() {
		return KQ_HS;
	}
	public void setKQ_HS(Long kq_hs) {
		KQ_HS = kq_hs;
	}
	public Long getKQ_SO_NGUOI() {
		return KQ_SO_NGUOI;
	}
	public void setKQ_SO_NGUOI(Long kq_so_nguoi) {
		KQ_SO_NGUOI = kq_so_nguoi;
	}
	public Long getSO_DV_DUOC_KT() {
		return SO_DV_DUOC_KT;
	}
	public void setSO_DV_DUOC_KT(Long so_dv_duoc_kt) {
		SO_DV_DUOC_KT = so_dv_duoc_kt;
	}
	public Long getSO_DV_SAI_PHAM() {
		return SO_DV_SAI_PHAM;
	}
	public void setSO_DV_SAI_PHAM(Long so_dv_sai_pham) {
		SO_DV_SAI_PHAM = so_dv_sai_pham;
	}
	public Long getTONG_SO() {
		return TONG_SO;
	}
	public void setTONG_SO(Long tong_so) {
		TONG_SO = tong_so;
	}
	public Long getTSP_KHAC() {
		return TSP_KHAC;
	}
	public void setTSP_KHAC(Long tsp_khac) {
		TSP_KHAC = tsp_khac;
	}
	public Long getTSP_TIEN() {
		return TSP_TIEN;
	}
	public void setTSP_TIEN(Long tsp_tien) {
		TSP_TIEN = tsp_tien;
	}
	public Bc1aForm() {
		// TODO Auto-generated constructor stub
	}	
	
}
