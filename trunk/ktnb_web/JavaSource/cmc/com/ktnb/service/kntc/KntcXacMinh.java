package cmc.com.ktnb.service.kntc;
import java.io.Serializable;
import java.util.ArrayList;

import cmc.com.ktnb.pl.hb.entity.KntcKquaXmDtl;
import cmc.com.ktnb.pl.hb.entity.KntcKqxmKluatKnghi;
/**
 * @author cmcsoft
 * Dec 6, 2010
 * ktnb_web
 */
public class KntcXacMinh implements Serializable {
	private KntcKqxmKluatKnghi hdr;
	private ArrayList listDtl = new ArrayList();

	
	public void addKntcKquaXmDtl(KntcKquaXmDtl tl){
		listDtl.add(tl);
	}
	
	/**
	 * @return
	 */
	public ArrayList getListDtl() {
		return listDtl;
	}

	/**
	 * @param list
	 */
	public void setListDtl(ArrayList list) {
		listDtl = list;
	}

	/**
	 * @return
	 */
	public KntcKqxmKluatKnghi getHdr() {
		return hdr;
	}

	/**
	 * @param knghi
	 */
	public void setHdr(KntcKqxmKluatKnghi knghi) {
		hdr = knghi;
	}

}
