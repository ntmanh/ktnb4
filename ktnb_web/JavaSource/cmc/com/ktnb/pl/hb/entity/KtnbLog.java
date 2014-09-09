package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

import org.hibernate.id.GUIDGenerator;

import cmc.com.ktnb.util.KeyManagement;


/**
 * KntcPhieuHen entity. @author MyEclipse Persistence Tools
 */

public class KtnbLog extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	private String id;
	private Date time;
	private String nsd;
	private String maCanBo;
	private String action;
	private String info;
	private String cqt;
	public KtnbLog() throws Exception {
		
	}	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getCqt() {
		return cqt;
	}
	public void setCqt(String cqt) {
		this.cqt = cqt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getMaCanBo() {
		return maCanBo;
	}
	public void setMaCanBo(String maCanBo) {
		this.maCanBo = maCanBo;
	}
	public String getNsd() {
		return nsd;
	}
	public void setNsd(String nsd) {
		this.nsd = nsd;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}