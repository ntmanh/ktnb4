package cmc.com.ktnb.tccp;
import cmc.com.ktnb.pl.hb.entity.Ttcp2c;
import cmc.com.ktnb.pl.hb.entity.TtcpBaoCaoId;
import cmc.com.ktnb.service.TtcpService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Báo cáo form
 * @author Ntthu
 * Created on 16/04/2011
 */
public class Bc2cForm extends BaseActionForm {	
	private String maCqt;
	private Integer nam;
	private Integer thang;
	//So lieu lay tu bao cao
	//So lieu +-
	private Long TONG_SO_DON_KN;//new Long($F{DON_NHAN_TRONG_KY}.longValue()+$F{DON_TON_KY_TRUOC}.longValue())
	private Long SO_DON_THUOC_THAM_QUYEN;//new Long($F{DGQ_SVV_RUT_DON}.longValue()+$F{GQ_LAN1}.longValue()+$F{GQ_LAN2_CONG_NHAN}.longValue()+$F{GQ_LAN2_HUY}.longValue())
	private Long SO_VU_VIEC_THUOC_THAM_QUYEN;//new Long($F{DGQ_SVV_RUT_DON}.longValue()+$F{GQ_LAN1}.longValue()+$F{GQ_LAN2_CONG_NHAN}.longValue()+$F{GQ_LAN2_HUY}.longValue())
	private Long SO_VU_VIEC_GQ_QUA_QDHC;//new Long($F{GQ_LAN1}.longValue()+$F{GQ_LAN2_CONG_NHAN}.longValue()+$F{GQ_LAN2_HUY}.longValue())
	//So lieu goc
	private Long DON_NHAN_TRONG_KY;
	private Long DON_TON_KY_TRUOC;
	private Long SO_VU_VIEC;
	private Long DGQ_SVV_RUT_DON;
	private Long KQ_DUNG;
	private Long KQ_SAI;
	private Long KQ_DUNG_SAI;
	private Long GQ_LAN1;
	private Long GQ_LAN2_CONG_NHAN;
	private Long GQ_LAN2_HUY;
	private Long GQ_THU_HOI_CHO_NN;
	private Long GQ_TRA_LAI_CD;
	private Long GQ_SO_NGUOI_DUOC_TRA_QUYEN_LOI;
	private Long GQ_XL_HC_NGUOI;
	private Long CHAP_HANH_DUNG_HAN;
	private Long CHAP_HANH_QUA_HAN;
	private Long TH_SQD_PHAI_THUC_HIEN_TRONG_KY;
	private Long TH_SQD_DA_THUC_HIEN;
	//So lieu can nhap	
	private Long soNguoiDaBiXly;
	private Long chuyenDtSoVu;
	private Long chuyenDtSoNguoi;
	private Long chuyenDtKqSoVu;
	private Long chuyenDtKqSoNguoi;
	private Long thuHoiPhaiThu;
	private Long thuHoiDaThu;
	private Long traLaiPhaiTra;
	private Long traLaiDaTra;
	
	private String ngayCuoiThang;
	
	public void fromEntity(Ttcp2c entity, ApplicationContext c) throws Exception {
		this.maCqt = entity.getId().getMaCqt();
		this.nam = entity.getId().getNam();
		this.thang = entity.getId().getThang();
		//So lieu lay tu bao cao
		this.getSoLieuTuBaoCao(thang.toString()+"/"+nam.toString(),maCqt);
		//So lieu nhap
		this.soNguoiDaBiXly = entity.getSoNguoiDaBiXly();
		this.chuyenDtSoVu = entity.getChuyenDtSoVu();
		this.chuyenDtSoNguoi = entity.getChuyenDtSoNguoi();
		this.chuyenDtKqSoVu = entity.getChuyenDtKqSoVu();
		this.chuyenDtKqSoNguoi = entity.getChuyenDtKqSoNguoi();
		this.thuHoiPhaiThu = entity.getThuHoiPhaiThu();
		this.thuHoiDaThu = entity.getThuHoiDaThu();
		this.traLaiPhaiTra = entity.getTraLaiPhaiTra();
		this.traLaiDaTra = entity.getTraLaiDaTra();
		this.ngayCuoiThang = Formater.date2strDateTimeForNV(entity.getNgayCuoiThang());
	}
	public Ttcp2c toEntity() throws Exception{
		Ttcp2c entity = new Ttcp2c();
		TtcpBaoCaoId id = new TtcpBaoCaoId();
		id.setMaCqt(this.maCqt);
		id.setNam(this.nam);
		id.setThang(this.thang);
		entity.setId(id);
		entity.setSoNguoiDaBiXly(this.soNguoiDaBiXly);
		entity.setChuyenDtSoVu(this.chuyenDtSoVu);
		entity.setChuyenDtSoNguoi(this.chuyenDtSoNguoi);
		entity.setChuyenDtKqSoVu(this.chuyenDtKqSoVu);
		entity.setChuyenDtKqSoNguoi(this.chuyenDtKqSoNguoi);
		entity.setThuHoiPhaiThu(this.thuHoiPhaiThu);
		entity.setThuHoiDaThu(this.thuHoiDaThu);
		entity.setTraLaiPhaiTra(this.traLaiPhaiTra);
		entity.setTraLaiDaTra(this.traLaiDaTra);
		entity.setNgayCuoiThang(Formater.str2dateForNV(this.getNgayCuoiThang()));
		
		return entity;
	}
	
	public void getSoLieuTuBaoCao(String thoiGian, String maCqt){
		TtcpService service = new TtcpService();	
		service.getSoLieuTuBaoCao2C(this, thoiGian, maCqt);		
	}
	
	public Long getChuyenDtKqSoNguoi() {
		return chuyenDtKqSoNguoi;
	}
	public void setChuyenDtKqSoNguoi(Long chuyenDtKqSoNguoi) {
		this.chuyenDtKqSoNguoi = chuyenDtKqSoNguoi;
	}
	public Long getChuyenDtKqSoVu() {
		return chuyenDtKqSoVu;
	}
	public void setChuyenDtKqSoVu(Long chuyenDtKqSoVu) {
		this.chuyenDtKqSoVu = chuyenDtKqSoVu;
	}
	public Long getChuyenDtSoNguoi() {
		return chuyenDtSoNguoi;
	}
	public void setChuyenDtSoNguoi(Long chuyenDtSoNguoi) {
		this.chuyenDtSoNguoi = chuyenDtSoNguoi;
	}
	public Long getChuyenDtSoVu() {
		return chuyenDtSoVu;
	}
	public void setChuyenDtSoVu(Long chuyenDtSoVu) {
		this.chuyenDtSoVu = chuyenDtSoVu;
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
	public Long getSoNguoiDaBiXly() {
		return soNguoiDaBiXly;
	}
	public void setSoNguoiDaBiXly(Long soNguoiDaBiXly) {
		this.soNguoiDaBiXly = soNguoiDaBiXly;
	}
	public Integer getThang() {
		return thang;
	}
	public void setThang(Integer thang) {
		this.thang = thang;
	}
	public Long getThuHoiDaThu() {
		return thuHoiDaThu;
	}
	public void setThuHoiDaThu(Long thuHoiDaThu) {
		this.thuHoiDaThu = thuHoiDaThu;
	}
	public Long getThuHoiPhaiThu() {
		return thuHoiPhaiThu;
	}
	public void setThuHoiPhaiThu(Long thuHoiPhaiThu) {
		this.thuHoiPhaiThu = thuHoiPhaiThu;
	}
	public Long getTraLaiDaTra() {
		return traLaiDaTra;
	}
	public void setTraLaiDaTra(Long traLaiDaTra) {
		this.traLaiDaTra = traLaiDaTra;
	}
	public Long getTraLaiPhaiTra() {
		return traLaiPhaiTra;
	}
	public void setTraLaiPhaiTra(Long traLaiPhaiTra) {
		this.traLaiPhaiTra = traLaiPhaiTra;
	}
	public Bc2cForm() {
		// TODO Auto-generated constructor stub
	}
	public Long getCHAP_HANH_DUNG_HAN() {
		return CHAP_HANH_DUNG_HAN;
	}
	public void setCHAP_HANH_DUNG_HAN(Long chap_hanh_dung_han) {
		CHAP_HANH_DUNG_HAN = chap_hanh_dung_han;
	}
	public Long getCHAP_HANH_QUA_HAN() {
		return CHAP_HANH_QUA_HAN;
	}
	public void setCHAP_HANH_QUA_HAN(Long chap_hanh_qua_han) {
		CHAP_HANH_QUA_HAN = chap_hanh_qua_han;
	}
	public Long getDGQ_SVV_RUT_DON() {
		return DGQ_SVV_RUT_DON;
	}
	public void setDGQ_SVV_RUT_DON(Long dgq_svv_rut_don) {
		DGQ_SVV_RUT_DON = dgq_svv_rut_don;
	}
	public Long getDON_NHAN_TRONG_KY() {
		return DON_NHAN_TRONG_KY;
	}
	public void setDON_NHAN_TRONG_KY(Long don_nhan_trong_ky) {
		DON_NHAN_TRONG_KY = don_nhan_trong_ky;
	}
	public Long getDON_TON_KY_TRUOC() {
		return DON_TON_KY_TRUOC;
	}
	public void setDON_TON_KY_TRUOC(Long don_ton_ky_truoc) {
		DON_TON_KY_TRUOC = don_ton_ky_truoc;
	}
	public Long getGQ_LAN1() {
		return GQ_LAN1;
	}
	public void setGQ_LAN1(Long gq_lan1) {
		GQ_LAN1 = gq_lan1;
	}
	public Long getGQ_LAN2_CONG_NHAN() {
		return GQ_LAN2_CONG_NHAN;
	}
	public void setGQ_LAN2_CONG_NHAN(Long gq_lan2_cong_nhan) {
		GQ_LAN2_CONG_NHAN = gq_lan2_cong_nhan;
	}
	public Long getGQ_LAN2_HUY() {
		return GQ_LAN2_HUY;
	}
	public void setGQ_LAN2_HUY(Long gq_lan2_huy) {
		GQ_LAN2_HUY = gq_lan2_huy;
	}
	public Long getGQ_SO_NGUOI_DUOC_TRA_QUYEN_LOI() {
		return GQ_SO_NGUOI_DUOC_TRA_QUYEN_LOI;
	}
	public void setGQ_SO_NGUOI_DUOC_TRA_QUYEN_LOI(Long gq_so_nguoi_duoc_tra_quyen_loi) {
		GQ_SO_NGUOI_DUOC_TRA_QUYEN_LOI = gq_so_nguoi_duoc_tra_quyen_loi;
	}
	public Long getGQ_THU_HOI_CHO_NN() {
		return GQ_THU_HOI_CHO_NN;
	}
	public void setGQ_THU_HOI_CHO_NN(Long gq_thu_hoi_cho_nn) {
		GQ_THU_HOI_CHO_NN = gq_thu_hoi_cho_nn;
	}
	public Long getGQ_TRA_LAI_CD() {
		return GQ_TRA_LAI_CD;
	}
	public void setGQ_TRA_LAI_CD(Long gq_tra_lai_cd) {
		GQ_TRA_LAI_CD = gq_tra_lai_cd;
	}
	public Long getGQ_XL_HC_NGUOI() {
		return GQ_XL_HC_NGUOI;
	}
	public void setGQ_XL_HC_NGUOI(Long gq_xl_hc_nguoi) {
		GQ_XL_HC_NGUOI = gq_xl_hc_nguoi;
	}
	public Long getKQ_DUNG() {
		return KQ_DUNG;
	}
	public void setKQ_DUNG(Long kq_dung) {
		KQ_DUNG = kq_dung;
	}
	public Long getKQ_DUNG_SAI() {
		return KQ_DUNG_SAI;
	}
	public void setKQ_DUNG_SAI(Long kq_dung_sai) {
		KQ_DUNG_SAI = kq_dung_sai;
	}
	public Long getKQ_SAI() {
		return KQ_SAI;
	}
	public void setKQ_SAI(Long kq_sai) {
		KQ_SAI = kq_sai;
	}
	public Long getSO_VU_VIEC() {
		return SO_VU_VIEC;
	}
	public void setSO_VU_VIEC(Long so_vu_viec) {
		SO_VU_VIEC = so_vu_viec;
	}
	public Long getTH_SQD_DA_THUC_HIEN() {
		return TH_SQD_DA_THUC_HIEN;
	}
	public void setTH_SQD_DA_THUC_HIEN(Long th_sqd_da_thuc_hien) {
		TH_SQD_DA_THUC_HIEN = th_sqd_da_thuc_hien;
	}
	public Long getTH_SQD_PHAI_THUC_HIEN_TRONG_KY() {
		return TH_SQD_PHAI_THUC_HIEN_TRONG_KY;
	}
	public void setTH_SQD_PHAI_THUC_HIEN_TRONG_KY(Long th_sqd_phai_thuc_hien_trong_ky) {
		TH_SQD_PHAI_THUC_HIEN_TRONG_KY = th_sqd_phai_thuc_hien_trong_ky;
	}
	public Long getSO_DON_THUOC_THAM_QUYEN() {
		return SO_DON_THUOC_THAM_QUYEN;
	}
	public void setSO_DON_THUOC_THAM_QUYEN(Long so_don_thuoc_tham_quyen) {
		SO_DON_THUOC_THAM_QUYEN = so_don_thuoc_tham_quyen;
	}
	public Long getSO_VU_VIEC_GQ_QUA_QDHC() {
		return SO_VU_VIEC_GQ_QUA_QDHC;
	}
	public void setSO_VU_VIEC_GQ_QUA_QDHC(Long so_vu_viec_gq_qua_qdhc) {
		SO_VU_VIEC_GQ_QUA_QDHC = so_vu_viec_gq_qua_qdhc;
	}
	public Long getSO_VU_VIEC_THUOC_THAM_QUYEN() {
		return SO_VU_VIEC_THUOC_THAM_QUYEN;
	}
	public void setSO_VU_VIEC_THUOC_THAM_QUYEN(Long so_vu_viec_thuoc_tham_quyen) {
		SO_VU_VIEC_THUOC_THAM_QUYEN = so_vu_viec_thuoc_tham_quyen;
	}
	public Long getTONG_SO_DON_KN() {
		return TONG_SO_DON_KN;
	}
	public void setTONG_SO_DON_KN(Long tong_so_don_kn) {
		TONG_SO_DON_KN = tong_so_don_kn;
	}	
	
}
