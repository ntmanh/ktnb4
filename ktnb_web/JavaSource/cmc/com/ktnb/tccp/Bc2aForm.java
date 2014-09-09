package cmc.com.ktnb.tccp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.KntcXmKeHoach;
import cmc.com.ktnb.pl.hb.entity.Ttcp2a;
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
public class Bc2aForm extends BaseActionForm {	
	private String maCqt;
	private Integer nam;
	private Integer thang;
	//So lieu lay tu bao cao
	private Long ttxLuot;
	private Long ttxNguoi;	
	private Long ttxDnnSoDoan;
	private Long ttxDnnNguoi;
	private Long tdxLuot;
	private Long tdxNguoi;
	private Long tdxDnnSoDoan;
	private Long tdxDnnNguoi;
	//So lieu can nhap
	private Long ttxVuViecCu;
	private Long ttxVuViecMoi;
	private Long ttxDdnVuViecCu;
	private Long ttxDdnVuViecMoi;
	private Long tdxVuViecCu;
	private Long tdxVuViecMoi;
	private Long tdxDdnVuViecCu;
	private Long tdxDdnVuViecMoi;
	private Long ndKnChinhSach;
	private Long ndKnNhaTaiSan;
	private Long ndKnCheDo;
	private Long ndTcHanhChinh;
	private Long ndTcThamNhung;
	private Long ndKhac;
	private Long kqChuaGiaiQuyet;
	private Long kqDaGiaiQuyetChuaCoQD;
	private Long kqDaGiaiQuyetDaCoQD;
	private Long kqDaGiaiQuyetDaCoBanAn;
	private String ngayCuoiThang;
	public Bc2aForm() {
		// TODO Auto-generated constructor stub
	}
	public void fromEntity(Ttcp2a entity, ApplicationContext c) throws Exception {
		this.maCqt = entity.getId().getMaCqt();
		this.nam = entity.getId().getNam();
		this.thang = entity.getId().getThang();
		//So lieu lay tu bao cao
		this.getSoLieuTuBaoCao(thang.toString()+"/"+nam.toString(),maCqt);
		//So lieu nhap
		this.ttxVuViecCu = entity.getTtxVuViecCu();
		this.ttxVuViecMoi = entity.getTtxVuViecMoi();
		this.ttxDdnVuViecCu = entity.getTtxDdnVuViecCu();
		this.ttxDdnVuViecMoi = entity.getTtxDdnVuViecMoi();
		this.tdxVuViecCu = entity.getTdxVuViecCu();
		this.tdxVuViecMoi = entity.getTdxVuViecMoi();
		this.tdxDdnVuViecCu = entity.getTdxDdnVuViecCu();
		this.tdxDdnVuViecMoi = entity.getTdxDdnVuViecMoi();
		this.ndKnChinhSach = entity.getNdKnChinhSach();
		this.ndKnNhaTaiSan = entity.getNdKnNhaTaiSan();
		this.ndKnCheDo = entity.getNdKnCheDo();
		this.ndTcHanhChinh = entity.getNdTcHanhChinh();
		this.ndTcThamNhung = entity.getNdTcThamNhung();
		this.ndKhac = entity.getNdKhac();
		this.kqChuaGiaiQuyet = entity.getKqChuaGiaiQuyet();
		this.kqDaGiaiQuyetChuaCoQD = entity.getKqDaGiaiQuyetChuaCoQD();
		this.kqDaGiaiQuyetDaCoQD = entity.getKqDaGiaiQuyetDaCoQD();
		this.kqDaGiaiQuyetDaCoBanAn= entity.getKqDaGiaiQuyetDaCoBanAn();
		this.ngayCuoiThang = Formater.date2strDateTimeForNV(entity.getNgayCuoiThang());
	}
	public Ttcp2a toEntity() throws Exception{
		Ttcp2a entity = new Ttcp2a();
		TtcpBaoCaoId id = new TtcpBaoCaoId();
		id.setMaCqt(this.maCqt);
		id.setNam(this.nam);
		id.setThang(this.thang);
		entity.setId(id);
		entity.setTtxVuViecCu(this.ttxVuViecCu);
		entity.setTtxVuViecMoi(this.ttxVuViecMoi);
		entity.setTtxDdnVuViecCu(this.ttxDdnVuViecCu);
		entity.setTtxDdnVuViecMoi(this.ttxDdnVuViecMoi);
		entity.setTdxVuViecCu(this.tdxVuViecCu);
		entity.setTdxVuViecMoi(this.tdxVuViecMoi);
		entity.setTdxDdnVuViecCu(this.tdxDdnVuViecCu);
		entity.setTdxDdnVuViecMoi(this.tdxDdnVuViecMoi);
		entity.setNdKnChinhSach(this.ndKnChinhSach);
		entity.setNdKnNhaTaiSan(this.ndKnNhaTaiSan);
		entity.setNdKnCheDo(this.ndKnCheDo);
		entity.setNdTcHanhChinh(this.ndTcHanhChinh);
		entity.setNdTcThamNhung(this.ndTcThamNhung);
		entity.setNdKhac(this.ndKhac);
		entity.setKqChuaGiaiQuyet(this.kqChuaGiaiQuyet);
		entity.setKqDaGiaiQuyetChuaCoQD(this.kqDaGiaiQuyetChuaCoQD);
		entity.setKqDaGiaiQuyetDaCoQD(this.kqDaGiaiQuyetDaCoQD);
		entity.setKqDaGiaiQuyetDaCoBanAn(this.kqDaGiaiQuyetDaCoBanAn);
		entity.setNgayCuoiThang(Formater.str2dateForNV(this.getNgayCuoiThang()));
		return entity;
	}
	
	public void getSoLieuTuBaoCao(String thoiGian, String maCqt){
		TtcpService service = new TtcpService();	
		service.getSoLieuTuBaoCao2A(this, thoiGian, maCqt);		
	}
	
	public Long getKqChuaGiaiQuyet() {
		return kqChuaGiaiQuyet;
	}
	public void setKqChuaGiaiQuyet(Long kqChuaGiaiQuyet) {
		this.kqChuaGiaiQuyet = kqChuaGiaiQuyet;
	}
	public Long getKqDaGiaiQuyetChuaCoQD() {
		return kqDaGiaiQuyetChuaCoQD;
	}
	public void setKqDaGiaiQuyetChuaCoQD(Long kqDaGiaiQuyetChuaCoQD) {
		this.kqDaGiaiQuyetChuaCoQD = kqDaGiaiQuyetChuaCoQD;
	}
	public Long getKqDaGiaiQuyetDaCoBanAn() {
		return kqDaGiaiQuyetDaCoBanAn;
	}
	public void setKqDaGiaiQuyetDaCoBanAn(Long kqDaGiaiQuyetDaCoBanAn) {
		this.kqDaGiaiQuyetDaCoBanAn = kqDaGiaiQuyetDaCoBanAn;
	}
	public Long getKqDaGiaiQuyetDaCoQD() {
		return kqDaGiaiQuyetDaCoQD;
	}
	public void setKqDaGiaiQuyetDaCoQD(Long kqDaGiaiQuyetDaCoQD) {
		this.kqDaGiaiQuyetDaCoQD = kqDaGiaiQuyetDaCoQD;
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
	public Long getNdKhac() {
		return ndKhac;
	}
	public void setNdKhac(Long ndKhac) {
		this.ndKhac = ndKhac;
	}
	public Long getNdKnCheDo() {
		return ndKnCheDo;
	}
	public void setNdKnCheDo(Long ndKnCheDo) {
		this.ndKnCheDo = ndKnCheDo;
	}
	public Long getNdKnChinhSach() {
		return ndKnChinhSach;
	}
	public void setNdKnChinhSach(Long ndKnChinhSach) {
		this.ndKnChinhSach = ndKnChinhSach;
	}
	public Long getNdKnNhaTaiSan() {
		return ndKnNhaTaiSan;
	}
	public void setNdKnNhaTaiSan(Long ndKnNhaTaiSan) {
		this.ndKnNhaTaiSan = ndKnNhaTaiSan;
	}
	public Long getNdTcHanhChinh() {
		return ndTcHanhChinh;
	}
	public void setNdTcHanhChinh(Long ndTcHanhChinh) {
		this.ndTcHanhChinh = ndTcHanhChinh;
	}
	public Long getNdTcThamNhung() {
		return ndTcThamNhung;
	}
	public void setNdTcThamNhung(Long ndTcThamNhung) {
		this.ndTcThamNhung = ndTcThamNhung;
	}
	public Long getTdxDdnVuViecCu() {
		return tdxDdnVuViecCu;
	}
	public void setTdxDdnVuViecCu(Long tdxDdnVuViecCu) {
		this.tdxDdnVuViecCu = tdxDdnVuViecCu;
	}
	public Long getTdxDdnVuViecMoi() {
		return tdxDdnVuViecMoi;
	}
	public void setTdxDdnVuViecMoi(Long tdxDdnVuViecMoi) {
		this.tdxDdnVuViecMoi = tdxDdnVuViecMoi;
	}
	public Long getTdxVuViecCu() {
		return tdxVuViecCu;
	}
	public void setTdxVuViecCu(Long tdxVuViecCu) {
		this.tdxVuViecCu = tdxVuViecCu;
	}
	public Long getTdxVuViecMoi() {
		return tdxVuViecMoi;
	}
	public void setTdxVuViecMoi(Long tdxVuViecMoi) {
		this.tdxVuViecMoi = tdxVuViecMoi;
	}
	public Integer getThang() {
		return thang;
	}
	public void setThang(Integer thang) {
		this.thang = thang;
	}
	public Long getTtxDdnVuViecCu() {
		return ttxDdnVuViecCu;
	}
	public void setTtxDdnVuViecCu(Long ttxDdnVuViecCu) {
		this.ttxDdnVuViecCu = ttxDdnVuViecCu;
	}
	public Long getTtxDdnVuViecMoi() {
		return ttxDdnVuViecMoi;
	}
	public void setTtxDdnVuViecMoi(Long ttxDdnVuViecMoi) {
		this.ttxDdnVuViecMoi = ttxDdnVuViecMoi;
	}
	public Long getTtxVuViecCu() {
		return ttxVuViecCu;
	}
	public void setTtxVuViecCu(Long ttxVuViecCu) {
		this.ttxVuViecCu = ttxVuViecCu;
	}
	public Long getTtxVuViecMoi() {
		return ttxVuViecMoi;
	}
	public void setTtxVuViecMoi(Long ttxVuViecMoi) {
		this.ttxVuViecMoi = ttxVuViecMoi;
	}
	public Long getTtxLuot() {
		return ttxLuot;
	}
	public void setTtxLuot(Long ttxLuot) {
		this.ttxLuot = ttxLuot;
	}
	public Long getTdxDnnNguoi() {
		return tdxDnnNguoi;
	}
	public void setTdxDnnNguoi(Long tdxDnnNguoi) {
		this.tdxDnnNguoi = tdxDnnNguoi;
	}
	public Long getTdxDnnSoDoan() {
		return tdxDnnSoDoan;
	}
	public void setTdxDnnSoDoan(Long tdxDnnSoDoan) {
		this.tdxDnnSoDoan = tdxDnnSoDoan;
	}
	public Long getTdxLuot() {
		return tdxLuot;
	}
	public void setTdxLuot(Long tdxLuot) {
		this.tdxLuot = tdxLuot;
	}
	public Long getTdxNguoi() {
		return tdxNguoi;
	}
	public void setTdxNguoi(Long tdxNguoi) {
		this.tdxNguoi = tdxNguoi;
	}
	public Long getTtxDnnNguoi() {
		return ttxDnnNguoi;
	}
	public void setTtxDnnNguoi(Long ttxDnnNguoi) {
		this.ttxDnnNguoi = ttxDnnNguoi;
	}
	public Long getTtxDnnSoDoan() {
		return ttxDnnSoDoan;
	}
	public void setTtxDnnSoDoan(Long ttxDnnSoDoan) {
		this.ttxDnnSoDoan = ttxDnnSoDoan;
	}
	public Long getTtxNguoi() {
		return ttxNguoi;
	}
	public void setTtxNguoi(Long ttxNguoi) {
		this.ttxNguoi = ttxNguoi;
	}
	public String getNgayCuoiThang() {
		return ngayCuoiThang;
	}
	public void setNgayCuoiThang(String ngayCuoiThang) {
		this.ngayCuoiThang = ngayCuoiThang;
	}	
	
}
