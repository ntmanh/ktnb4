package cmc.com.ktnb.web.dung_chung;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;

import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.pl.hb.entity.KtnbTlieuKemTheo;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.catalog.CatalogService;

public class DungChungService {
	
	protected BaseHibernateDAO dao= new BaseHibernateDAO();
	
	private Connection conn=null;
	
	/**
	 * Ham khoi tao mac dinh
	 * */
	public DungChungService()
	{
		super();
	}

	
	/**
	 * Get version don kntc
	 * */
	public String getVersionDonKntc(ApplicationContext appContext, String maHoSo) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcHoSoHdr.class);
		sc.addSearchItem("maHs", maHoSo);
		KntcHoSoHdr hdr = (KntcHoSoHdr) services.retriveObject(appContext, sc);
		if("4".equals(hdr.getDonVer())) return "4";
		else return "3";
	}
}
