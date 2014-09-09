package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;

import java.util.Date;

/**
 * TtktThNhanTraHstl entity. @author MyEclipse Persistence Tools
 */

public class TtktThNhanTraHstl implements java.io.Serializable {

	// Fields

	private String id;
	private TtktThYcBsHstl ttktThYcBsHstl;
	private Date thoiDiemNhanTra;
	private String baoCao;
	private String hoSo;
	private String idDaiDienBenGiao;
	private String idDaiDienBenNhan;
	private Boolean loai;

	// Constructors

	/** default constructor */
	public TtktThNhanTraHstl() {
	}

	/** minimal constructor */
	public TtktThNhanTraHstl(String id, TtktThYcBsHstl ttktThYcBsHstl,
			Date thoiDiemNhanTra, String idDaiDienBenGiao,
			String idDaiDienBenNhan, Boolean loai) {
		this.id = id;
		this.ttktThYcBsHstl = ttktThYcBsHstl;
		this.thoiDiemNhanTra = thoiDiemNhanTra;
		this.idDaiDienBenGiao = idDaiDienBenGiao;
		this.idDaiDienBenNhan = idDaiDienBenNhan;
		this.loai = loai;
	}

	/** full constructor */
	public TtktThNhanTraHstl(String id, TtktThYcBsHstl ttktThYcBsHstl,
			Date thoiDiemNhanTra, String baoCao, String hoSo,
			String idDaiDienBenGiao, String idDaiDienBenNhan, Boolean loai) {
		this.id = id;
		this.ttktThYcBsHstl = ttktThYcBsHstl;
		this.thoiDiemNhanTra = thoiDiemNhanTra;
		this.baoCao = baoCao;
		this.hoSo = hoSo;
		this.idDaiDienBenGiao = idDaiDienBenGiao;
		this.idDaiDienBenNhan = idDaiDienBenNhan;
		this.loai = loai;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TtktThYcBsHstl getTtktThYcBsHstl() {
		return this.ttktThYcBsHstl;
	}

	public void setTtktThYcBsHstl(TtktThYcBsHstl ttktThYcBsHstl) {
		this.ttktThYcBsHstl = ttktThYcBsHstl;
	}

	public Date getThoiDiemNhanTra() {
		return this.thoiDiemNhanTra;
	}

	public void setThoiDiemNhanTra(Date thoiDiemNhanTra) {
		this.thoiDiemNhanTra = thoiDiemNhanTra;
	}

	public String getBaoCao() {
		return this.baoCao;
	}

	public void setBaoCao(String baoCao) {
		this.baoCao = baoCao;
	}

	public String getHoSo() {
		return this.hoSo;
	}

	public void setHoSo(String hoSo) {
		this.hoSo = hoSo;
	}

	public String getIdDaiDienBenGiao() {
		return this.idDaiDienBenGiao;
	}

	public void setIdDaiDienBenGiao(String idDaiDienBenGiao) {
		this.idDaiDienBenGiao = idDaiDienBenGiao;
	}

	public String getIdDaiDienBenNhan() {
		return this.idDaiDienBenNhan;
	}

	public void setIdDaiDienBenNhan(String idDaiDienBenNhan) {
		this.idDaiDienBenNhan = idDaiDienBenNhan;
	}

	public Boolean getLoai() {
		return this.loai;
	}

	public void setLoai(Boolean loai) {
		this.loai = loai;
	}

}