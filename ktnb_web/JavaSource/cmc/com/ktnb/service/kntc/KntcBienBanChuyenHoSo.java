package cmc.com.ktnb.service.kntc;

import java.util.ArrayList;

import cmc.com.ktnb.pl.hb.entity.KntcBienBan;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.pl.hb.entity.KntcDmRls;
import cmc.com.ktnb.pl.hb.entity.KtnbPaHsRls;

/**
 * @Author Ntthu-CMCSOFT
 * @since 03/2011
 * @version 1.0
 * Chuyển hồ sơ sang các cơ quan liên quan
 */

public class KntcBienBanChuyenHoSo implements java.io.Serializable {
	private KntcBienBan bienBan;
	private ArrayList listDm = new ArrayList(); // Cac noi dung (dm) can chuyen
	private ArrayList listCb = new ArrayList(); // Cac can bo lien quan
	private ArrayList listPa = new ArrayList(); // Cac parties lien quan
	public void addCb(KntcCanBoRls aCb){
		listCb.add(aCb);
	}
	/**
	 * 
	 */
	public ArrayList getListCb() {
		return listCb;
	}
	public void addPa(KtnbPaHsRls aPa){
		listPa.add(aPa);
	}
	
	public void addDm(KntcDmRls aDm){
		listDm.add(aDm);
	}
	/**
	 * 
	 */
	public ArrayList getListDm() {
		return listDm;
	}

	/**
	 * @param list
	 */
	public void setListCb(ArrayList list) {
		listCb = list;
	}

	/**
	 * @param list
	 */
	public void setListDm(ArrayList list) {
		listDm = list;
	}

	/**
	 * 
	 */
	public ArrayList getListPa() {
		return listPa;
	}

	/**
	 * @param list
	 */
	public void setListPa(ArrayList list) {
		listPa = list;
	}

	/**
	 * 
	 */
	public KntcBienBan getBienBan() {
		return bienBan;
	}

	/**
	 * @param ban
	 */
	public void setBienBan(KntcBienBan ban) {
		bienBan = ban;
	}

}