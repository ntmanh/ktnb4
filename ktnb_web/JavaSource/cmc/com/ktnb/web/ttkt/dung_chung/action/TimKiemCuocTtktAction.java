/*
 * Created on Nov 1, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.dung_chung.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhDuyetKeHoach;
import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DetailInformation;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.HtmlTable;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.QueryDetails;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.dung_chung.form.TimKiemCuocTtktForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

/**
 * @author ntdung1 +ntthu
 */
public class TimKiemCuocTtktAction extends BaseDispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception, Exception {
		TimKiemCuocTtktForm tkForm = (TimKiemCuocTtktForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		tkForm.setMaCqtTienHanh(appContext.getMaCqt());
		String strMethod = request.getParameter("method");
		if ("save".equals(strMethod)) {
			if ("pcTruongDoan".equals(tkForm.getNghiepVu())) {
				DetailInformation[] dsCuocTtkt = tkForm.getDsCuocTtkt();
				try {
					TtktService.saveDsPhanCongTd(dsCuocTtkt, request, appContext);
					request.setAttribute("statte", "success");
				} catch (Exception e) {
					request.setAttribute("statte", "fail");
				}
			}
		} else {
			String nghiepVu = request.getParameter("act");
			if (!Formater.isNull(nghiepVu))
				tkForm.setNghiepVu(nghiepVu);
		}
		this.find(appContext, tkForm, request, tkForm.getNghiepVu(), reponse);
		if ("cbTienHanh".equals(tkForm.getNghiepVu())) {
			request.setAttribute("title", "T\u00ECm ki\u1EBFm - Chu\u1EA9n b\u1ECB ti\u1EBFn h\u00E0nh");
		} else if ("pcTruongDoan".equals(tkForm.getNghiepVu())) {
			request.setAttribute("title", "T\u00ECm ki\u1EBFm - Ch\u1EC9 \u0111\u1ECBnh tr\u01B0\u1EDFng \u0111o\u00E0n");
			return mapping.findForward("chi_dinh_truong_doan");
		} else if ("congBo".equals(tkForm.getNghiepVu()))
			request.setAttribute("title", "T\u00ECm ki\u1EBFm - C\u00F4ng b\u00F3 quy\u1EBFt \u0111\u1ECBnh");
		else if ("tienhanh".equals(tkForm.getNghiepVu()))
			request.setAttribute("title", "T\u00ECm ki\u1EBFm - Ti\u1EBFn h\u00E0nh");
		else if ("ketthuc".equals(tkForm.getNghiepVu()))
			request.setAttribute("title", "T\u00ECm ki\u1EBFm - K\u1EBFt th\u00FAc");
		else if ("timKiem".equals(tkForm.getNghiepVu())) {
			request.setAttribute("title", "TT\u00ECm ki\u1EBFm");
			// Combo trang thai cuoc Ttkt
			Collection listTrangThai = new ArrayList();
			listTrangThai.add(Constants.TT_TTKT_CREATE);
			listTrangThai.add(Constants.TT_TTKT_CDTD); 
			listTrangThai.add(Constants.TT_TTKT_CBTH);
			listTrangThai.add(Constants.TT_TTKT_HUY);
			listTrangThai.add(Constants.TT_TTKT_TH);
			listTrangThai.add(Constants.TT_TTKT_KT);
			// tkForm.setNamTienHanh(Formater.date2str(new
			// Date()).substring(6));
			// tkForm.setTenCqtTienHanh(appContext.getTenCqt());
			request.setAttribute("dsTrangThaiTtkt", listTrangThai);
		}

		// search(appContext, tkForm, request, tkForm.getNghiepVu(), reponse);
		return mapping.findForward("view");
	}

	private void find(ApplicationContext appContext, TimKiemCuocTtktForm timKiemCuocTtktForm, HttpServletRequest request, String nghiepVu, HttpServletResponse reponse) throws Exception, Exception {
		StringBuffer sql = new StringBuffer("select * from Ttkt_Kh_Cuoc_Ttkt t where 1=1 ");

		sql.append(this.buildConditionFromForm(appContext, timKiemCuocTtktForm, request));
		sql.append(" AND Trang_Thai<> '" + Constants.TT_TTKT_HET_HL + "'");
		sql.append(" AND end_Date is null");
		if (nghiepVu != null) {
			if ("pcTruongDoan".equals(nghiepVu)) {
				// Chi tim kiem cuoc dot xuat hoac cuoc da duoc duyet ke hoach
				// nam
				sql.append(" and ((loai = 1) Or ((loai = 0) ");
				Collection dsDuyetKh = CuocTtktService.getDsDuyetKh(appContext);
				if (!Formater.isNull(dsDuyetKh)) {
					sql.append(" AND (");
					int i = 0;
					for (Iterator iter = dsDuyetKh.iterator(); iter.hasNext();) {
						sql.append(" MA like '%" + String.valueOf(((TtktKhDuyetKeHoach) iter.next()).getKeHoachNam() + "%'"));
						if (i < dsDuyetKh.size() - 1)
							sql.append(" OR ");
						i++;
					}
					sql.append(")");
				} else {
					sql.append("and (1=2)");
				}
				sql.append("))");

				// Don vi tien hanh
				sql.append(" AND Id_Don_Vi_Th ='" + appContext.getMaCqt() + "'");
				String trangThai = timKiemCuocTtktForm.getTrangThaiPhanCongTruongDoan();
				if ("0".equals(trangThai))
					sql.append(" AND Trang_Thai ='" + Constants.TT_TTKT_CREATE + "'");
				else if ("1".equals(trangThai))
					sql.append(" AND Trang_Thai ='" + Constants.TT_TTKT_CDTD + "'");
				else
					sql.append(" AND Trang_Thai in ('" + Constants.TT_TTKT_CREATE + "','" + Constants.TT_TTKT_CDTD+ "','" + Constants.TT_TTKT_BCKS+ "','" + Constants.TT_TTKT_CDTVD+ "','" + Constants.TT_TTKT_QD + "')");
				//TT_TTKT_BCKS, TT_TTKT_CDTVD, TT_TTKT_QD
			} else if ("timKiem".equals(nghiepVu)) { // Tim kiem de view
				if (!Formater.isNull(timKiemCuocTtktForm.getNamTienHanh())) {
					sql.append(" AND ma like '%" + timKiemCuocTtktForm.getNamTienHanh() + "%'");
				}
				if (!Formater.isNull(timKiemCuocTtktForm.getTenCqtTienHanh())) {
					sql.append(" AND upper(ten_don_vi_th) like '%" + timKiemCuocTtktForm.getTenCqtTienHanh().toUpperCase() + "%'");
				}
				if (KtnbUtil.haveRoleTt(appContext) || KtnbUtil.haveRoleTBP(appContext)) {
					if (KtnbUtil.isCuc(appContext)) {
						String[] roleData = appContext.getRoleData();
						if (roleData != null && roleData.length > 0) {
							String newArr = "";
							for (int i = 0; i < roleData.length; i++) {
								newArr += ",'" + roleData[i] + "'";
							}
							sql.append(" AND Id_Don_Vi_Th in ('" + appContext.getMaCqt() + "'," + newArr.substring(1) + ")");
						} else
							sql.append(" AND Id_Don_Vi_Th ='" + appContext.getMaCqt() + "'");
						sql.append(" AND Trang_Thai <>'" + Constants.TT_TTKT_HET_HL + "'");
					} else if (KtnbUtil.isChiCuc(appContext)) {
						sql.append(" AND Id_Don_Vi_Th ='" + appContext.getMaCqt() + "'");
					}

				} else {
					sql.append(" AND Id_Truong_Doan ='" + appContext.getMaCanbo() + "'");
				}
				Collection dsTrangThaiHopLe = new ArrayList();
				if (Constants.TT_TTKT_CREATE.equals(timKiemCuocTtktForm.getTrangThai()))
					dsTrangThaiHopLe.add(Constants.TT_TTKT_CREATE);
				else if (Constants.TT_TTKT_CDTD.equals(timKiemCuocTtktForm.getTrangThai())) {
					dsTrangThaiHopLe.add(Constants.TT_TTKT_CDTD);
				} else if (Constants.TT_TTKT_CBTH.equals(timKiemCuocTtktForm.getTrangThai())) {
					dsTrangThaiHopLe.add(Constants.TT_TTKT_BCKS);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_CDTVD);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_QD);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_KH);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_DC);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_HOP);
				} else if (Constants.TT_TTKT_HOAN.equals(timKiemCuocTtktForm.getTrangThai())) {
					sql.append(" AND Trang_Thai ='" + Constants.TT_TTKT_HOAN + "'");
				} else if (Constants.TT_TTKT_HUY.equals(timKiemCuocTtktForm.getTrangThai())) {
					sql.append(" AND Trang_Thai ='" + Constants.TT_TTKT_HUY + "'");
				} else if (Constants.TT_TTKT_TH.equals(timKiemCuocTtktForm.getTrangThai())) {
					dsTrangThaiHopLe.add(Constants.TT_TTKT_CBQD);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_NK);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_BBCT);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_BGHSLT);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_DTBBTH);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_BBTHGDVTTKT);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_BBTH);
				} else if (Constants.TT_TTKT_KT.equals(timKiemCuocTtktForm.getTrangThai())) {
					dsTrangThaiHopLe.add(Constants.TT_TTKT_TBKT);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_DTKQ);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_KQ);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_DTKL);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_KL);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_HOPRKN);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_CDLBC);
					dsTrangThaiHopLe.add(Constants.TTKT_BB_BGHSLT);
					dsTrangThaiHopLe.add(Constants.TT_TTKT_KT);
				}
				sql.append(" and Loai_Cuoc_Ttkt_KHN in('" + Constants.TTKT_LOAI_KHN_KH + "','" + Constants.TTKT_LOAI_KHN_ADD + "','" + Constants.TTKT_LOAI_KHN_ADD_BY_EDIT + "')");
				if (!Formater.isNull(dsTrangThaiHopLe)) {
					String tt = "";
					for (Iterator iter = dsTrangThaiHopLe.iterator(); iter.hasNext();) {
						String element = (String) iter.next();
						tt += ",'" + element + "'";
					}
					sql.append(" AND Trang_Thai in (" + tt.substring(1) + ")");
				}
			} else { // Tim kiem de tien hanh
				sql.append(" AND Id_Truong_Doan ='" + appContext.getMaCanbo() + "'");
				String firstStatus = "";
				if ("cbTienHanh".equals(nghiepVu)) {
					firstStatus = Constants.TT_TTKT_CDTD;
				} else if ("tienhanh".equals(nghiepVu)) {
					firstStatus = Constants.TT_TTKT_HOP;
				} else if ("ketthuc".equals(nghiepVu)) {
					firstStatus = Constants.TT_TTKT_BBTH;
				}
				Collection dsTrangThaiHopLe = new ArrayList();
				boolean found = false;
				for (int i = 0; i < Constants.ARR_TRANG_THAI_CUOC_TTKT.length - 1; i++) {
					if (!found) {
						if (Constants.ARR_TRANG_THAI_CUOC_TTKT[i].equals(firstStatus)) {
							found = true;
							dsTrangThaiHopLe.add(Constants.ARR_TRANG_THAI_CUOC_TTKT[i]);
						}
					} else
						dsTrangThaiHopLe.add(Constants.ARR_TRANG_THAI_CUOC_TTKT[i]);
				}
				if (!Formater.isNull(dsTrangThaiHopLe)) {
					String tt = "";
					for (Iterator iter = dsTrangThaiHopLe.iterator(); iter.hasNext();) {
						String element = (String) iter.next();
						tt += ",'" + element + "'";
					}
					sql.append(" AND Trang_Thai in (" + tt.substring(1) + ")");
				}
			}
		}
		//Bo sung lua chon sap xep
		String sapXep = timKiemCuocTtktForm.getSapXep();
		if (!Formater.isNull(sapXep)) {
			if("TangThoiGian".equals(sapXep)){
				sql.append(" ORDER BY thoi_gian_du_kien_tu_ngay ASC");
			}else if("TangThuTu".equals(sapXep)){
				sql.append(" ORDER BY ma ASC");
			} else if("GiamThoiGian".equals(sapXep)){
				sql.append(" ORDER BY thoi_gian_du_kien_tu_ngay DESC");
			}else if("GiamThuTu".equals(sapXep)){
				sql.append(" ORDER BY ma DESC");
			}
		} else {
			sql.append(" ORDER BY ma");
		}
		// Session session = HibernateSessionFactory.openNewSession();
		Session session = HibernateSessionFactory.currentSession();
		if (session != null) {
			QueryDetails queryDetails = new QueryDetails();
			try {
				session.beginTransaction();
				queryDetails.setPageSize(Constants.PAGE_SIZE_DEFAULT);
				String sPageNumber = request.getParameter("pageNumber");
				try {
					queryDetails.setPageNumber(new Integer(sPageNumber));
					request.setAttribute("pnumber", sPageNumber);
				} catch (Exception e) {
					queryDetails.setPageNumber(new Integer("1"));
					request.setAttribute("pnumber", new Integer("1"));
				}
				// request.setAttribute("sql", sql.toString());
				System.out.println("SQL Searching: " + sql.toString());
				Query q = session.createSQLQuery(sql.toString()).addEntity(TtktKhCuocTtkt.class);
				try {
					request.setAttribute("countResult", q.list().size() + "");
				} catch (Exception e) {
					// TODO: handle exception 
				}
				int beginIndx = queryDetails.getBeginIndex();
				int lastIndx = queryDetails.getLastIndex();
				q.setFirstResult(beginIndx);
				q.setMaxResults(lastIndx);
				Collection listCuocTtkt = q.list();
				if (listCuocTtkt.size() == 1) {
					TtktKhCuocTtkt cuocTtkt = ((TtktKhCuocTtkt) ((ArrayList) listCuocTtkt).get(0));
					String idCuocTtkt = cuocTtkt.getId();
					request.getSession().setAttribute("cuocTtkt", cuocTtkt);
					if ("cbTienHanh".equals(nghiepVu))
						reponse.sendRedirect("chuan_bi_tien_hanh.do?cuocTtktId=" + idCuocTtkt);
					else if ("tienhanh".equals(nghiepVu))
						reponse.sendRedirect("tien_hanh_ttkt.do?cuocTtktId=" + idCuocTtkt);
					else if ("ketthuc".equals(nghiepVu))
						reponse.sendRedirect("ket_thuc_ttkt.do?cuocTtktId=" + idCuocTtkt);
				}
				if (!Formater.isNull(listCuocTtkt)) {
					Iterator iter = listCuocTtkt.iterator();
					while (iter.hasNext()) {
						TtktKhCuocTtkt cuocTtkt = (TtktKhCuocTtkt) iter.next();
						cuocTtkt.setNienDoDenNgayStr(Formater.date2str(cuocTtkt.getNienDoDenNgay()));
						cuocTtkt.setNienDoTuNgayStr(Formater.date2str(cuocTtkt.getNienDoTuNgay()));
						cuocTtkt.setThoiGianDuKienDenNgayStr(Formater.date2str(cuocTtkt.getThoiGianDuKienDenNgay()));
						cuocTtkt.setThoiGianDuKienTuNgayStr(Formater.date2str(cuocTtkt.getThoiGianDuKienTuNgay()));
						if (KtnbUtil.isChiCuc(cuocTtkt.getIdDonViTh())) {
							String dvPhuthuoc = CuocTtktService.searchDvPhuthuoc(cuocTtkt.getId());
							if (dvPhuthuoc != null)
								cuocTtkt.setTenDonViBi(dvPhuthuoc);
						}
					}
				}
				// HtmlTable
				HtmlTable table = new HtmlTable();
				table.setPageNumber(sPageNumber);
				table.setPageSize(Constants.PAGE_SIZE_DEFAULT.longValue());
				table.setData(listCuocTtkt);
				table.setSearchForm("TimKiemCuocTtktForm");
				request.setAttribute("tableKetQuaTimKiem", table);
				timKiemCuocTtktForm.setDsCuocTtkt(convertToDetail(table.getData(), timKiemCuocTtktForm.getNghiepVu()));
			} catch (Exception e) {
				e.printStackTrace();
				HibernateSessionFactory.closeSessionQuiet();
				throw new KtnbException(e);
			} finally {
				HibernateSessionFactory.closeSessionQuiet();
			}
		}
	}

	/**
	 * @param listCuocTtkt
	 * @return
	 */
	private DetailInformation[] convertToDetail(Collection listCuocTtkt, String nghiepVu) {
		if (Formater.isNull(listCuocTtkt))
			return null;
		DetailInformation[] arrResult = new DetailInformation[listCuocTtkt.size()];
		Iterator iter = listCuocTtkt.iterator();
		int index = 0;
		while (iter.hasNext()) {
			TtktKhCuocTtkt cuocTtkt = (TtktKhCuocTtkt) iter.next();
			DetailInformation detailInformation = new DetailInformation();
			detailInformation.setCol0(cuocTtkt.getId());
			detailInformation.setCol1(cuocTtkt.getMa());
			detailInformation.setCol2(cuocTtkt.getIdDonViTh());
			detailInformation.setCol3(cuocTtkt.getTenDonViTh());
			detailInformation.setCol4(cuocTtkt.getIdDonViBi());
			detailInformation.setCol5(cuocTtkt.getTenDonViBi());
			detailInformation.setCol6(Formater.date2str(cuocTtkt.getNienDoTuNgay()));
			detailInformation.setCol7(Formater.date2str(cuocTtkt.getNienDoDenNgay()));
			detailInformation.setCol8(cuocTtkt.getThoiGianDuKienTuNgayStr().substring(0, 5) + "-" + cuocTtkt.getThoiGianDuKienDenNgayStr());
			detailInformation.setCol16(cuocTtkt.getThoiGianDuKien().toString() + " ng\u00E0y");
			if (cuocTtkt.getHinhThuc().booleanValue())
				detailInformation.setCol9("1");
			else
				detailInformation.setCol9("0");
			if (cuocTtkt.getLoai().booleanValue())
				detailInformation.setCol10("1");
			else
				detailInformation.setCol10("0");
			if (!"pcTruongDoan".equals(nghiepVu))
				detailInformation.setCol12(cuocTtkt.getTrangThai());
			arrResult[index] = detailInformation;
			index++;
			if (cuocTtkt.getTrangThai().equals(Constants.TT_TTKT_CDTD)) {
				TtktCbChiTietDsTvDoan chiTietDsTvd = CuocTtktService.getTruongDoan(cuocTtkt.getId());
				detailInformation.setCol11(chiTietDsTvd.getIdCanBo());
				detailInformation.setCol12(chiTietDsTvd.getTenCanBo());
				// Don vi cong tac
				detailInformation.setCol14(chiTietDsTvd.getTenCqt());
				detailInformation.setCol15(chiTietDsTvd.getChucVu());
				// Id danh sach thanh vien doan
				detailInformation.setCol13(chiTietDsTvd.getIdDsTvd());
			}
		}
		return arrResult;
	}

	private String buildConditionFromForm(ApplicationContext appContext, TimKiemCuocTtktForm sForm, HttpServletRequest request) throws Exception, Exception {
		StringBuffer sb = new StringBuffer();
		sb.append(" and id_Cuoc_Ttkt_Cha is null");
		// SearchCriteria criteria = new SearchCriteria(TtktKhCuocTtkt.class);

		// Cuoc ttkt chinh
		// criteria.addSearchItem(TtktKhCuocTtkt.IdCuocTtktCha, null,
		// SearchCriteria.LG_IS_NULL);
		if (!"timKiem".equals(sForm.getNghiepVu())) { // Nghiep vu
			// tim kiem trang thai xac dinh khac so voi cac nghiep vu khac
			if (!Formater.isNull(sForm.getTrangThai())) {
				sb.append(" and Trang_Thai ='" + sForm.getTrangThai() + "'");
				// criteria.addSearchItem(TtktKhCuocTtkt.TrangThai,
				// timKiemCuocTtktForm.getTrangThai());
			}
		}
		// Ma cuoc ttkt
		if (!Formater.isNull(sForm.getMa_cuoc_ttkt()))
			sb.append(" and upper(ma) like '%" + sForm.getMa_cuoc_ttkt().trim().toUpperCase() + "%'");
		if (!Formater.isNull(sForm.getTenTruongDoan())) {
			sb.append(" AND upper(ten_truong_doan) like '%" + sForm.getTenTruongDoan().trim().toUpperCase() + "%'");
		}
		// Ten don vi duoc ttkt
		if (!Formater.isNull(sForm.getDon_vi_duoc_ttkt()))
			sb.append(" and upper(Ten_Don_Vi_Bi) like upper('%" + sForm.getDon_vi_duoc_ttkt().trim() + "%')");
		// Nien do
		if (!Formater.isNull(sForm.getTu_ngay()))
			sb.append(" and Nien_Do_Tu_Ngay >= " + "to_date('" + sForm.getTu_ngay() + "','dd/mm/yyyy')");

		if (!Formater.isNull(sForm.getDen_ngay()))
			sb.append(" and Nien_Do_den_Ngay <= " + "to_date('" + sForm.getDen_ngay() + "','dd/mm/yyyy')");
		// Thoi gian du kien
		if (!Formater.isNull(sForm.getThoiGianDuKien()))
			sb.append(" and Thoi_Gian_Du_Kien =" + new Byte(sForm.getThoiGianDuKien()));

		// Thoi gian du kien
		if (!Formater.isNull(sForm.getThoiGianDuKienTuNgay()))
			sb.append(" and Thoi_Gian_Du_Kien_TU_Ngay >= " + "to_date('" + sForm.getThoiGianDuKienTuNgay() + "','dd/mm/yyyy')");

		if (!Formater.isNull(sForm.getThoiGianDuKienDenNgay()))
			sb.append(" and Thoi_Gian_Du_Kien_Den_Ngay <= " + "to_date('" + sForm.getThoiGianDuKienDenNgay() + "','dd/mm/yyyy')");
		// Loai: dot xuat, dinh ky
		if ("0".equals(sForm.getLoai()))
			sb.append(" and LOAI = 0");
		else if ("1".equals(sForm.getLoai()))
			sb.append(" and LOAI = 1");
		// Hinh thuc: Thanh tra, kiem tra
		if ("0".equals(sForm.getHinh_thuc()))
			sb.append(" and Hinh_Thuc = 0");
		else if ("1".equals(sForm.getHinh_thuc()))
			sb.append(" and Hinh_Thuc = 1");
		// edit
		return sb.toString();
	}

}
