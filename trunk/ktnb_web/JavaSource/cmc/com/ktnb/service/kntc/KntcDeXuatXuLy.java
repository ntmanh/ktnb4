package cmc.com.ktnb.service.kntc;

import java.util.ArrayList;

import cmc.com.ktnb.pl.hb.entity.KntcDeXuatXly;
import cmc.com.ktnb.pl.hb.entity.KntcDmRls;

/**
 * @author Ntthu - cmcsoft
 * @since 06/12/2010 Thông tin đầy đủ của Đề xuất xử lý
 */
public class KntcDeXuatXuLy {
	private ArrayList dmRls;

	private KntcDeXuatXly dx;

	public KntcDeXuatXuLy(KntcDeXuatXly _dx) {
		this.dx = _dx;
	}

	public void addNoiDung(KntcDmRls tl) {
		dmRls.add(tl);
	}

	/**
	 * @return
	 */
	public KntcDeXuatXly getDx() {
		return dx;
	}

	/**
	 * @param xly
	 */
	public void setDx(KntcDeXuatXly xly) {
		dx = xly;
	}

	/**
	 * @return
	 */
	public ArrayList getDmRls() {
		return dmRls;
	}

	/**
	 * @param list
	 */
	public void setDmRls(ArrayList list) {
		dmRls = list;
	}

}
