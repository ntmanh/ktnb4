package cmc.com.ktnb.tccp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.KntcXmKeHoach;
import cmc.com.ktnb.pl.hb.entity.Ttcp2a;
import cmc.com.ktnb.pl.hb.entity.Ttcp2c;
import cmc.com.ktnb.pl.hb.entity.Ttcp2d;
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
public class Bc2dForm extends BaseActionForm {	
	private String maCqt;
	private Integer nam;
	private Integer thang;
	//So lieu lay tu bao cao
	//	So lieu +-
	private Long TONG_SO_DON;
	private Long DA_GIAI_QUYET_SO_DON;
	private Long DA_GIAI_QUYET_SO_VU_VIEC;
	//	So lieu goc
	private Long DON_NHAN_TRONG_KY;
	private Long DON_TON_KY_TRUOC;
	private Long SO_VU_VIEC;
	private Long KQ_DUNG;
	private Long KQ_SAI;
	private Long KQ_DUNG_SAI;
	private Long GQ_LAN1;
	private Long GQ_THU_HOI_CHO_NN;
	private Long GQ_TRA_LAI_CD;
	private Long GQ_XL_HC_NGUOI_DA_XL;
	private Long GQ_DT_SO_VU;
	private Long GQ_DT_SO_DOI_TUONG;
	private Long CHAP_HANH_DUNG_HAN;
	private Long CHAP_HANH_QUA_HAN;
	private Long TH_SQD_PHAI_THUC_HIEN_TRONG_KY;//Tuong ung thTongSo;Lay tu cot 37, Bao cao 30 ra
	private Long TH_SQD_DA_THUC_HIEN;//Tuong ung thDaTh=> cot 38 bao cao 30
	//So lieu can nhap	
	private Long snDuocBv;
	private Long snBiXly;
	private Long chuyenDtSoVuDkt;
	private Long chuyenDtSoNgDkt;
	private Long thTongSo;//Khong dung => Lay tu cot 37, Bao cao 30 ra
	private Long thDaTh;//Khong dung => Lay tu cot 38, Bao cao 30 ra
	private Long thThuHoiPhaiThu;
	private Long thThuHoiDaThu;
	private Long thTraLaiPhaiTra;
	private Long thTraLaiDaTra;
	private String ngayCuoiThang;
	public void fromEntity(Ttcp2d entity, ApplicationContext c) throws Exception {
		this.maCqt = entity.getId().getMaCqt();
		this.nam = entity.getId().getNam();
		this.thang = entity.getId().getThang();
		//So lieu lay tu bao cao
		this.getSoLieuTuBaoCao(thang.toString()+"/"+nam.toString(),maCqt);
		//So lieu nhap
		this.snDuocBv = entity.getSnDuocBv();
		this.snBiXly = entity.getSnBiXly();
		this.chuyenDtSoVuDkt = entity.getChuyenDtSoVuDkt();
		this.chuyenDtSoNgDkt = entity.getChuyenDtSoNgDkt();
		//this.thTongSo = entity.getThTongSo();
		this.thDaTh = entity.getThDaTh();
		this.thThuHoiPhaiThu = entity.getThThuHoiPhaiThu();
		this.thThuHoiDaThu = entity.getThThuHoiDaThu();
		this.thTraLaiPhaiTra = entity.getThTraLaiPhaiTra();
		this.thTraLaiDaTra = entity.getThTraLaiDaTra();
		this.ngayCuoiThang = Formater.date2strDateTimeForNV(entity.getNgayCuoiThang());
	}
	public Ttcp2d toEntity() throws Exception{
		Ttcp2d entity = new Ttcp2d();
		TtcpBaoCaoId id = new TtcpBaoCaoId();
		id.setMaCqt(this.maCqt);
		id.setNam(this.nam);
		id.setThang(this.thang);
		entity.setId(id);
		entity.setSnDuocBv(this.snDuocBv);
		entity.setSnBiXly(this.snBiXly);
		entity.setChuyenDtSoVuDkt(this.chuyenDtSoVuDkt);
		entity.setChuyenDtSoNgDkt(this.chuyenDtSoNgDkt);
		//entity.setThTongSo(this.thTongSo);
		entity.setThDaTh(this.thDaTh);
		entity.setThThuHoiPhaiThu(this.thThuHoiPhaiThu);
		entity.setThThuHoiDaThu(this.thThuHoiDaThu);
		entity.setThTraLaiPhaiTra(this.thTraLaiPhaiTra);
		entity.setThTraLaiDaTra(this.thTraLaiDaTra);
		entity.setNgayCuoiThang(Formater.str2dateForNV(this.getNgayCuoiThang()));
		
		return entity;
	}
	
	public void getSoLieuTuBaoCao(String thoiGian, String maCqt){
		TtcpService service = new TtcpService();	
		service.getSoLieuTuBaoCao2D(this, thoiGian, maCqt);		
	}
	
	public Long getChuyenDtSoNgDkt() {
		return chuyenDtSoNgDkt;
	}
	public void setChuyenDtSoNgDkt(Long chuyenDtSoNgDkt) {
		this.chuyenDtSoNgDkt = chuyenDtSoNgDkt;
	}
	public Long getChuyenDtSoVuDkt() {
		return chuyenDtSoVuDkt;
	}
	public void setChuyenDtSoVuDkt(Long chuyenDtSoVuDkt) {
		this.chuyenDtSoVuDkt = chuyenDtSoVuDkt;
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
	public Long getSnBiXly() {
		return snBiXly;
	}
	public void setSnBiXly(Long snBiXly) {
		this.snBiXly = snBiXly;
	}
	public Long getSnDuocBv() {
		return snDuocBv;
	}
	public void setSnDuocBv(Long snDuocBv) {
		this.snDuocBv = snDuocBv;
	}
	public Integer getThang() {
		return thang;
	}
	public void setThang(Integer thang) {
		this.thang = thang;
	}
	public Long getThDaTh() {
		return thDaTh;
	}
	public void setThDaTh(Long thDaTh) {
		this.thDaTh = thDaTh;
	}
	public Long getThThuHoiPhaiThu() {
		return thThuHoiPhaiThu;
	}
	public void setThThuHoiPhaiThu(Long thThuHoiPhaiThu) {
		this.thThuHoiPhaiThu = thThuHoiPhaiThu;
	}
	public Long getThTongSo() {
		return thTongSo;
	}
	public void setThTongSo(Long thTongSo) {
		this.thTongSo = thTongSo;
	}
	public Long getThTraLaiDaTra() {
		return thTraLaiDaTra;
	}
	public void setThTraLaiDaTra(Long thTraLaiDaTra) {
		this.thTraLaiDaTra = thTraLaiDaTra;
	}
	public Long getThTraLaiPhaiTra() {
		return thTraLaiPhaiTra;
	}
	public void setThTraLaiPhaiTra(Long thTraLaiPhaiTra) {
		this.thTraLaiPhaiTra = thTraLaiPhaiTra;
	}
	public Bc2dForm() {
		// TODO Auto-generated constructor stub
	}
	public Long getThThuHoiDaThu() {
		return thThuHoiDaThu;
	}
	public void setThThuHoiDaThu(Long thThuHoiDaThu) {
		this.thThuHoiDaThu = thThuHoiDaThu;
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
	public Long getDA_GIAI_QUYET_SO_DON() {
		return DA_GIAI_QUYET_SO_DON;
	}
	public void setDA_GIAI_QUYET_SO_DON(Long da_giai_quyet_so_don) {
		DA_GIAI_QUYET_SO_DON = da_giai_quyet_so_don;
	}
	public Long getDA_GIAI_QUYET_SO_VU_VIEC() {
		return DA_GIAI_QUYET_SO_VU_VIEC;
	}
	public void setDA_GIAI_QUYET_SO_VU_VIEC(Long da_giai_quyet_so_vu_viec) {
		DA_GIAI_QUYET_SO_VU_VIEC = da_giai_quyet_so_vu_viec;
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
	
	public Long getGQ_DT_SO_DOI_TUONG() {
		return GQ_DT_SO_DOI_TUONG;
	}
	public void setGQ_DT_SO_DOI_TUONG(Long gq_dt_so_doi_tuong) {
		GQ_DT_SO_DOI_TUONG = gq_dt_so_doi_tuong;
	}
	public Long getGQ_DT_SO_VU() {
		return GQ_DT_SO_VU;
	}
	public void setGQ_DT_SO_VU(Long gq_dt_so_vu) {
		GQ_DT_SO_VU = gq_dt_so_vu;
	}
	public Long getGQ_LAN1() {
		return GQ_LAN1;
	}
	public void setGQ_LAN1(Long gq_lan1) {
		GQ_LAN1 = gq_lan1;
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
	public Long getGQ_XL_HC_NGUOI_DA_XL() {
		return GQ_XL_HC_NGUOI_DA_XL;
	}
	public void setGQ_XL_HC_NGUOI_DA_XL(Long gq_xl_hc_nguoi_da_xl) {
		GQ_XL_HC_NGUOI_DA_XL = gq_xl_hc_nguoi_da_xl;
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
	public Long getTONG_SO_DON() {
		return TONG_SO_DON;
	}
	public void setTONG_SO_DON(Long tong_so_don) {
		TONG_SO_DON = tong_so_don;
	}
	public Long getTH_SQD_PHAI_THUC_HIEN_TRONG_KY() {
		return TH_SQD_PHAI_THUC_HIEN_TRONG_KY;
	}
	public void setTH_SQD_PHAI_THUC_HIEN_TRONG_KY(Long th_sqd_phai_thuc_hien_trong_ky) {
		TH_SQD_PHAI_THUC_HIEN_TRONG_KY = th_sqd_phai_thuc_hien_trong_ky;
	}
	public Long getTH_SQD_DA_THUC_HIEN() {
		return TH_SQD_DA_THUC_HIEN;
	}
	public void setTH_SQD_DA_THUC_HIEN(Long th_sqd_da_thuc_hien) {
		TH_SQD_DA_THUC_HIEN = th_sqd_da_thuc_hien;
	}	
	
}
