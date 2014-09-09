package cmc.com.ktnb.pl.hb.entity;
import java.util.Date;

import cmc.com.ktnb.util.Formater;
/**
 * KntcDeXuatXly entity. @author MyEclipse Persistence Tools
 */
public class KntcDeXuatXly extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable
{
	private static final long serialVersionUID = 2024799294904937046L;
	// Fields    
	private String ma,diaDiem;
	private String maHs;
	private Long lanGui;
	private String noiDung;
	private String deXuat;
	private Date ngayTrinhKy,ngayCapNhat;
	private Date ngayKy;
	private String YKienTrinh;
	private Date ngayTrinhDuyet;
	private Date ngayDuyet;
	private String YKienDuyet;
	private Long isGquyetNgay,isQuaHan;
	private String thamQuyen;
	private String thuLy;
	private String arrTenTl;
	private String nguoiKNTC,nguoiCapNhat;
	private String chuDanhNguoiKNTC;
	private String dcNguoiKNTC;
	private String nguoiBiKNTC;
	private String chuDanhNguoiBiKNTC;
	private String dcNguoiBiKNTC;
	private String cqDaQG;
	private String ndDaQG;
	private String noiDungKNTC,canBoXly;
	
	public String getChuDanhNguoiBiKNTC() {
		return chuDanhNguoiBiKNTC;
	}
	public void setChuDanhNguoiBiKNTC(String chuDanhNguoiBiKNTC) {
		this.chuDanhNguoiBiKNTC = chuDanhNguoiBiKNTC;
	}
	public String getChuDanhNguoiKNTC() {
		return chuDanhNguoiKNTC;
	}
	public void setChuDanhNguoiKNTC(String chuDanhNguoiKNTC) {
		this.chuDanhNguoiKNTC = chuDanhNguoiKNTC;
	}
	public String getCqDaQG() {
		return cqDaQG;
	}
	public void setCqDaQG(String cqDaQG) {
		this.cqDaQG = cqDaQG;
	}
	public String getDcNguoiBiKNTC() {
		return dcNguoiBiKNTC;
	}
	public void setDcNguoiBiKNTC(String dcNguoiBiKNTC) {
		this.dcNguoiBiKNTC = dcNguoiBiKNTC;
	}
	public String getDcNguoiKNTC() {
		if(Formater.isNull(dcNguoiKNTC))
			return "";
		else
			return dcNguoiKNTC;
	}
	public void setDcNguoiKNTC(String dcNguoiKNTC) {
		this.dcNguoiKNTC = dcNguoiKNTC;
	}
	public String getNdDaQG() {
		return ndDaQG;
	}
	public void setNdDaQG(String ndDaQG) {
		this.ndDaQG = ndDaQG;
	}
	public String getNguoiBiKNTC() {
		return nguoiBiKNTC;
	}
	public void setNguoiBiKNTC(String nguoiBiKNTC) {
		this.nguoiBiKNTC = nguoiBiKNTC;
	}
	public String getNguoiKNTC() {
		return nguoiKNTC;
	}
	public void setNguoiKNTC(String nguoiKNTC) {
		this.nguoiKNTC = nguoiKNTC;
	}
	public String getArrTenTl() {
		return arrTenTl;
	}
	public void setArrTenTl(String arrTenTl) {
		this.arrTenTl = arrTenTl;
	}
	// Constructors
	/** default constructor */
	public KntcDeXuatXly()
	{
	}
	/** minimal constructor */
	public KntcDeXuatXly(String maHs)
	{
		this.maHs = maHs;
	}
	public String getThamQuyen()
	{
		return this.thamQuyen;
	}
	public void setThamQuyen(String thamQuyen)
	{
		this.thamQuyen = thamQuyen;
	}
	public String getThuLy()
	{
		return this.thuLy;
	}
	public void setThuLy(String thuLy)
	{
		this.thuLy = thuLy;
	}
	/** full constructor */
	public KntcDeXuatXly(String maHs, Long lanGui, String noiDung, String deXuat, Date ngayTrinhKy, Date ngayKy, String YKienTrinh, Date ngayTrinhDuyet, Date ngayDuyet, String YKienDuyet, Long isGquyetNgay)
	{
		this.maHs = maHs;
		this.lanGui = lanGui;
		this.noiDung = noiDung;
		this.deXuat = deXuat;
		this.ngayTrinhKy = ngayTrinhKy;
		this.ngayKy = ngayKy;
		this.YKienTrinh = YKienTrinh;
		this.ngayTrinhDuyet = ngayTrinhDuyet;
		this.ngayDuyet = ngayDuyet;
		this.YKienDuyet = YKienDuyet;
		this.isGquyetNgay = isGquyetNgay;
	}
	// Property accessors
	public String getMaHs()
	{
		return this.maHs;
	}
	public void setMaHs(String maHs)
	{
		this.maHs = maHs;
	}
	public Long getLanGui()
	{
		return this.lanGui;
	}
	public void setLanGui(Long lanGui)
	{
		this.lanGui = lanGui;
	}
	public String getNoiDung()
	{
		return this.noiDung;
	}
	public void setNoiDung(String noiDung)
	{
		this.noiDung = noiDung;
	}
	public String getDeXuat()
	{
		return this.deXuat;
	}
	public void setDeXuat(String deXuat)
	{
		this.deXuat = deXuat;
	}
	public Date getNgayTrinhKy()
	{
		return this.ngayTrinhKy;
	}
	public void setNgayTrinhKy(Date ngayTrinhKy)
	{
		this.ngayTrinhKy = ngayTrinhKy;
	}
	public Date getNgayKy()
	{
		return this.ngayKy;
	}
	public void setNgayKy(Date ngayKy)
	{
		this.ngayKy = ngayKy;
	}
	public String getYKienTrinh()
	{
		return this.YKienTrinh;
	}
	public void setYKienTrinh(String YKienTrinh)
	{
		this.YKienTrinh = YKienTrinh;
	}
	public Date getNgayTrinhDuyet()
	{
		return this.ngayTrinhDuyet;
	}
	public void setNgayTrinhDuyet(Date ngayTrinhDuyet)
	{
		this.ngayTrinhDuyet = ngayTrinhDuyet;
	}
	public Date getNgayDuyet()
	{
		return this.ngayDuyet;
	}
	public void setNgayDuyet(Date ngayDuyet)
	{
		this.ngayDuyet = ngayDuyet;
	}
	public String getYKienDuyet()
	{
		return this.YKienDuyet;
	}
	public void setYKienDuyet(String YKienDuyet)
	{
		this.YKienDuyet = YKienDuyet;
	}
	public Long getIsGquyetNgay()
	{
		return this.isGquyetNgay;
	}
	public void setIsGquyetNgay(Long isGquyetNgay)
	{
		this.isGquyetNgay = isGquyetNgay;
	}
	/**
	 * @return
	 */
	public String getMa()
	{
		return ma;
	}
	/**
	 * @param string
	 */
	public void setMa(String string)
	{
		ma = string;
	}
	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}
	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}
	public String getNguoiCapNhat() {
		return nguoiCapNhat;
	}
	public void setNguoiCapNhat(String nguoiCapNhat) {
		this.nguoiCapNhat = nguoiCapNhat;
	}
	public String getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
	public String getNoiDungKNTC() {
		return noiDungKNTC;
	}
	public void setNoiDungKNTC(String noiDungKNTC) {
		this.noiDungKNTC = noiDungKNTC;
	}
	public String getCanBoXly() {
		return canBoXly;
	}
	public void setCanBoXly(String canBoXly) {
		this.canBoXly = canBoXly;
	}
	public Long getIsQuaHan() {
		return isQuaHan;
	}
	public void setIsQuaHan(Long isQuaHan) {
		this.isQuaHan = isQuaHan;
	}
}