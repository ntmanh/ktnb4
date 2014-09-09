package cmc.com.ktnb.tccp;
import cmc.com.ktnb.pl.hb.entity.Ttcp2b;
import cmc.com.ktnb.pl.hb.entity.TtcpBaoCaoId;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Báo cáo form
 * @author Ntthu
 * Created on 16/04/2011
 */
public class Bc2bForm extends BaseActionForm {	
	private String maCqt;
	private Integer nam;
	private Integer thang;
	//So lieu lay tu bao cao
	//So lieu can nhap	
	private Long tnTongSo;
	private Long tnTkNhieuNguoi;
	private Long tnTrongKyMotNguoi;
	private Long tnKtNhieuNguoi;
	private Long tnKtMotNguoi;
	private Long tnDuDkXly;
	private Long ndKnHcTong;
	private Long ndKnHcTaiSan;
	private Long ndKnHcChinhSach;
	private Long ndKnKhac;
	private Long ndKnDang;
	private Long ndTcTong;
	private Long ndTcHc;
	private Long ndTcThamNhung;
	private Long ndTcDang;
	private Long ndTcKhac;
	private Long tqCqHanhChinh;
	private Long tqCqDang;
	private Long ttgqChuaGq;
	private Long ttgqDaGqLanDau;
	private Long ttgqDaGqNhieuLan;
	private Long donKhac;
	private Long kqSoVanBan;
	private Long kqSoChuyenCq;
	private Long kqSoCvDonDoc;
	private Long kqThuocTqKn;
	private Long kqThuocTqTc;
	
	private String ngayCuoiThang;
	public Bc2bForm() {
		// TODO Auto-generated constructor stub
	}
	public void fromEntity(Ttcp2b entity, ApplicationContext c) throws Exception {
		this.maCqt = entity.getId().getMaCqt();
		this.nam = entity.getId().getNam();
		this.thang = entity.getId().getThang();
		//So lieu lay tu bao cao
		//So lieu nhap
		this.tnTongSo = entity.getTnTongSo();
		this.tnTkNhieuNguoi = entity.getTnTkNhieuNguoi();
		this.tnTrongKyMotNguoi = entity.getTnTrongKyMotNguoi();
		this.tnKtNhieuNguoi = entity.getTnKtNhieuNguoi();
		this.tnKtMotNguoi = entity.getTnKtMotNguoi();
		this.tnDuDkXly = entity.getTnDuDkXly();
		this.ndKnHcTong = entity.getNdKnHcTong();
		this.ndKnHcTaiSan = entity.getNdKnHcTaiSan();
		this.ndKnHcChinhSach = entity.getNdKnHcChinhSach();
		this.ndKnKhac = entity.getNdKnKhac();
		this.ndKnDang = entity.getNdKnDang();
		this.ndTcTong = entity.getNdTcTong();
		this.ndTcHc = entity.getNdTcHc();
		this.ndTcThamNhung = entity.getNdTcThamNhung();
		this.ndTcDang = entity.getNdTcDang();
		this.ndTcKhac = entity.getNdTcKhac();
		this.tqCqHanhChinh = entity.getTqCqHanhChinh();
		this.tqCqDang = entity.getTqCqDang();
		this.ttgqChuaGq = entity.getTtgqChuaGq();
		this.ttgqDaGqLanDau = entity.getTtgqDaGqLanDau();
		this.ttgqDaGqNhieuLan = entity.getTtgqDaGqNhieuLan();
		this.donKhac = entity.getDonKhac();
		this.kqSoVanBan = entity.getKqSoVanBan();
		this.kqSoChuyenCq = entity.getKqSoChuyenCq();
		this.kqSoCvDonDoc = entity.getKqSoCvDonDoc();
		this.kqThuocTqKn = entity.getKqThuocTqKn();
		this.kqThuocTqTc = entity.getKqThuocTqTc();
		this.ngayCuoiThang = Formater.date2strDateTimeForNV(entity.getNgayCuoiThang());
	}
	public Ttcp2b toEntity() throws Exception{
		Ttcp2b entity = new Ttcp2b();
		TtcpBaoCaoId id = new TtcpBaoCaoId();
		id.setMaCqt(this.maCqt);
		id.setNam(this.nam);
		id.setThang(this.thang);
		entity.setId(id);
		entity.setTnTongSo(this.tnTongSo);
		entity.setTnTkNhieuNguoi(this.tnTkNhieuNguoi);
		entity.setTnTrongKyMotNguoi(this.tnTrongKyMotNguoi);
		entity.setTnKtNhieuNguoi(this.tnKtNhieuNguoi);
		entity.setTnKtMotNguoi(this.tnKtMotNguoi);
		entity.setTnDuDkXly(this.tnDuDkXly);
		entity.setNdKnHcTong(this.ndKnHcTong);
		entity.setNdKnHcTaiSan(this.ndKnHcTaiSan);
		entity.setNdKnHcChinhSach(this.ndKnHcChinhSach);
		entity.setNdKnKhac(this.ndKnKhac);
		entity.setNdKnDang(this.ndKnDang);
		entity.setNdTcTong(this.ndTcTong);
		entity.setNdTcHc(this.ndTcHc);
		entity.setNdTcThamNhung(this.ndTcThamNhung);
		entity.setNdTcDang(this.ndTcDang);
		entity.setNdTcKhac(this.ndTcKhac);
		entity.setTqCqHanhChinh(this.tqCqHanhChinh);
		entity.setTqCqDang(this.tqCqDang);
		entity.setTtgqChuaGq(this.ttgqChuaGq);
		entity.setTtgqDaGqLanDau(this.ttgqDaGqLanDau);
		entity.setTtgqDaGqNhieuLan(this.ttgqDaGqNhieuLan);
		entity.setDonKhac(this.donKhac);
		entity.setKqSoVanBan(this.kqSoVanBan);
		entity.setKqSoChuyenCq(this.kqSoChuyenCq);
		entity.setKqSoCvDonDoc(this.kqSoCvDonDoc);
		entity.setKqThuocTqKn(this.kqThuocTqKn);
		entity.setKqThuocTqTc(this.kqThuocTqTc);
		entity.setNgayCuoiThang(Formater.str2dateForNV(this.getNgayCuoiThang()));
		
		return entity;
	}
	public Long getDonKhac() {
		return donKhac;
	}
	public void setDonKhac(Long donKhac) {
		this.donKhac = donKhac;
	}
	public Long getKqSoChuyenCq() {
		return kqSoChuyenCq;
	}
	public void setKqSoChuyenCq(Long kqSoChuyenCq) {
		this.kqSoChuyenCq = kqSoChuyenCq;
	}
	public Long getKqSoCvDonDoc() {
		return kqSoCvDonDoc;
	}
	public void setKqSoCvDonDoc(Long kqSoCvDonDoc) {
		this.kqSoCvDonDoc = kqSoCvDonDoc;
	}
	public Long getKqSoVanBan() {
		return kqSoVanBan;
	}
	public void setKqSoVanBan(Long kqSoVanBan) {
		this.kqSoVanBan = kqSoVanBan;
	}
	public Long getKqThuocTqKn() {
		return kqThuocTqKn;
	}
	public void setKqThuocTqKn(Long kqThuocTqKn) {
		this.kqThuocTqKn = kqThuocTqKn;
	}
	public Long getKqThuocTqTc() {
		return kqThuocTqTc;
	}
	public void setKqThuocTqTc(Long kqThuocTqTc) {
		this.kqThuocTqTc = kqThuocTqTc;
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
	public Long getNdKnDang() {
		return ndKnDang;
	}
	public void setNdKnDang(Long ndKnDang) {
		this.ndKnDang = ndKnDang;
	}
	public Long getNdKnHcChinhSach() {
		return ndKnHcChinhSach;
	}
	public void setNdKnHcChinhSach(Long ndKnHcChinhSach) {
		this.ndKnHcChinhSach = ndKnHcChinhSach;
	}
	public Long getNdKnHcTaiSan() {
		return ndKnHcTaiSan;
	}
	public void setNdKnHcTaiSan(Long ndKnHcTaiSan) {
		this.ndKnHcTaiSan = ndKnHcTaiSan;
	}
	public Long getNdKnHcTong() {
		return ndKnHcTong;
	}
	public void setNdKnHcTong(Long ndKnHcTong) {
		this.ndKnHcTong = ndKnHcTong;
	}
	public Long getNdKnKhac() {
		return ndKnKhac;
	}
	public void setNdKnKhac(Long ndKnKhac) {
		this.ndKnKhac = ndKnKhac;
	}
	public Long getNdTcDang() {
		return ndTcDang;
	}
	public void setNdTcDang(Long ndTcDang) {
		this.ndTcDang = ndTcDang;
	}
	public Long getNdTcHc() {
		return ndTcHc;
	}
	public void setNdTcHc(Long ndTcHc) {
		this.ndTcHc = ndTcHc;
	}
	public Long getNdTcKhac() {
		return ndTcKhac;
	}
	public void setNdTcKhac(Long ndTcKhac) {
		this.ndTcKhac = ndTcKhac;
	}
	public Long getNdTcThamNhung() {
		return ndTcThamNhung;
	}
	public void setNdTcThamNhung(Long ndTcThamNhung) {
		this.ndTcThamNhung = ndTcThamNhung;
	}
	public Long getNdTcTong() {
		return ndTcTong;
	}
	public void setNdTcTong(Long ndTcTong) {
		this.ndTcTong = ndTcTong;
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
	public Long getTnDuDkXly() {
		return tnDuDkXly;
	}
	public void setTnDuDkXly(Long tnDuDkXly) {
		this.tnDuDkXly = tnDuDkXly;
	}
	public Long getTnKtMotNguoi() {
		return tnKtMotNguoi;
	}
	public void setTnKtMotNguoi(Long tnKtMotNguoi) {
		this.tnKtMotNguoi = tnKtMotNguoi;
	}
	public Long getTnKtNhieuNguoi() {
		return tnKtNhieuNguoi;
	}
	public void setTnKtNhieuNguoi(Long tnKtNhieuNguoi) {
		this.tnKtNhieuNguoi = tnKtNhieuNguoi;
	}
	public Long getTnTkNhieuNguoi() {
		return tnTkNhieuNguoi;
	}
	public void setTnTkNhieuNguoi(Long tnTkNhieuNguoi) {
		this.tnTkNhieuNguoi = tnTkNhieuNguoi;
	}
	public Long getTnTongSo() {
		return tnTongSo;
	}
	public void setTnTongSo(Long tnTongSo) {
		this.tnTongSo = tnTongSo;
	}
	public Long getTnTrongKyMotNguoi() {
		return tnTrongKyMotNguoi;
	}
	public void setTnTrongKyMotNguoi(Long tnTrongKyMotNguoi) {
		this.tnTrongKyMotNguoi = tnTrongKyMotNguoi;
	}
	public Long getTqCqDang() {
		return tqCqDang;
	}
	public void setTqCqDang(Long tqCqDang) {
		this.tqCqDang = tqCqDang;
	}
	public Long getTqCqHanhChinh() {
		return tqCqHanhChinh;
	}
	public void setTqCqHanhChinh(Long tqCqHanhChinh) {
		this.tqCqHanhChinh = tqCqHanhChinh;
	}
	public Long getTtgqChuaGq() {
		return ttgqChuaGq;
	}
	public void setTtgqChuaGq(Long ttgqChuaGq) {
		this.ttgqChuaGq = ttgqChuaGq;
	}
	public Long getTtgqDaGqLanDau() {
		return ttgqDaGqLanDau;
	}
	public void setTtgqDaGqLanDau(Long ttgqDaGqLanDau) {
		this.ttgqDaGqLanDau = ttgqDaGqLanDau;
	}
	public Long getTtgqDaGqNhieuLan() {
		return ttgqDaGqNhieuLan;
	}
	public void setTtgqDaGqNhieuLan(Long ttgqDaGqNhieuLan) {
		this.ttgqDaGqNhieuLan = ttgqDaGqNhieuLan;
	}	
	
}
