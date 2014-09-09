package cmc.com.ktnb.service.kntc;
import java.util.ArrayList;

import cmc.com.ktnb.pl.hb.entity.KntcGiayBienNhan;
import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuChuyenDon;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuGiaoHs;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuHdNkn;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuHen;
import cmc.com.ktnb.pl.hb.entity.KtnbTlieuKemTheo;
/**
 * @author thunt
 * Thông tin đầy đủ bộ hồ sơ tiếp dân hoặc nhận từ văn thư 
 * @since Dec 6, 2010
 */
public class KntcSoTiepDan  {
	private KntcHoSoHdr hdr;
	//private KntcNdungDon noiDungDon;
	private ArrayList listGiayBienNhan  = new ArrayList();
	private ArrayList listPhieuHen  = new ArrayList();
	private KntcPhieuGiaoHs phieuGiaoHs;
	private KntcPhieuChuyenDon phieuChuyenDon;
	private ArrayList listPhieuHdNkn  = new ArrayList();
	private ArrayList listTailieu = new ArrayList();
	/**
	 * 
	 */
	public KntcSoTiepDan(KntcHoSoHdr hdr1) {		
		this.hdr = hdr1;		
	}
	public KntcHoSoHdr getData()
	{
		return this.hdr;
	}
	public void addGiayBienNhan(KntcGiayBienNhan gbn) {
		listGiayBienNhan.add(gbn);
	}
	/**
	 * @return
	 */
	public ArrayList getListGiayBienNhan() {
		return listGiayBienNhan;
	}
	public void addPhieuHdNkn(KntcPhieuHdNkn phdNKN) {
		listPhieuHdNkn.add(phdNKN);
	}

	/**
	 * @return
	 */
	public ArrayList getListPhieuHdNkn() {
		return listPhieuHdNkn;
	}

	public void addPhieuHen(KntcPhieuHen phieuhen) {
			listPhieuHen.add(phieuhen);
		}
	/**
	 * @return
	 */
	public ArrayList getListPhieuHen() {
		return listPhieuHen;
	}

	public KntcPhieuChuyenDon getPhieuChuyenDon() {
		return phieuChuyenDon;
	}

	/**
	 
	 */
	public KntcPhieuGiaoHs getPhieuGiaoHs() {
		return phieuGiaoHs;
	}

	/**
	 * @param list
	 */
	public void setListGiayBienNhan(ArrayList list) {
		listGiayBienNhan = list;
	}

	/**
	 * @param list
	 */
	public void setListPhieuHdNkn(ArrayList list) {
		listPhieuHdNkn = list;
	}

	/**
	 * @param list
	 */
	public void setListPhieuHen(ArrayList list) {
		listPhieuHen = list;
	}

	/**
	 * @param don
	 
	public void setNoiDungDon(KntcNdungDon don) {
		noiDungDon = don;
	}*/

	/**
	 * @param don
	 */
	public void setPhieuChuyenDon(KntcPhieuChuyenDon don) {
		phieuChuyenDon = don;
	}

	/**
	 * @param hs
	 */
	public void setPhieuGiaoHs(KntcPhieuGiaoHs hs) {
		phieuGiaoHs = hs;
	}

	/**
	 
	 */
	public KntcHoSoHdr getHdr() {
		return hdr;
	}

	/**
	 * @param hdr
	 */
	public void setHdr(KntcHoSoHdr hdr) {
		this.hdr = hdr;
	}
	
	public void addTailieu(KtnbTlieuKemTheo tl){
		listTailieu.add(tl);
	}
	/**
	 
	 */
	public ArrayList getListTailieu() {
		return listTailieu;
	}

	/**
	 * @param list
	 */
	public void setListTailieu(ArrayList list) {
		listTailieu = list;
	}
}
