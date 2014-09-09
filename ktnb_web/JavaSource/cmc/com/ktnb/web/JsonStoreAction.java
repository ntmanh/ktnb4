package cmc.com.ktnb.web;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbCache;
import cmc.com.ktnb.util.KtnbDAO;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.vo.SearchStoreVO;

public class JsonStoreAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject json = null;
		KtnbDAO ktnbDAO = KtnbUtil.getKtnbDAO();
		try {
			ApplicationContext ac = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
			String method = (String) request.getParameter("method");
			String start = (String) request.getParameter("start");
			String limit = (String) request.getParameter("limit");
			String xaction = (String) request.getParameter("xaction");
			String query = (String) request.getParameter("query");
			//String ten = null;
			JSONObject jSONObject = null;
			JSONArray jSONArray = null;
			// CategoryVO categoryVO;
			Collection c;
			if (("update".equals(xaction)) || ("create".equals(xaction))) {
				JSONParser jSONParser = new JSONParser();
				String data = (String) request.getParameter("data");
				if (!data.startsWith("["))
					data = "[" + data + "]";
				Object obj = jSONParser.parse(data);
				jSONArray = (JSONArray) obj;
			}
			SearchStoreVO searchStoreVO = new SearchStoreVO();
			if (!Formater.isNull(start))
				searchStoreVO.start = Integer.parseInt(start);
			if (!Formater.isNull(limit))
				searchStoreVO.limit = Integer.parseInt(limit);
			searchStoreVO.sort = (String) request.getParameter("sort");
			searchStoreVO.dir = (String) request.getParameter("dir");
			searchStoreVO.query = query;
			response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Cache-Control", "no-store");
			PrintWriter out = response.getWriter();
			if ("dstinh".equals(method))
				json = ktnbDAO.getDsTinh(searchStoreVO);
			else if ("dsndttkt".equals(method)) {
				jSONArray = (JSONArray) KtnbCache.getInstance().get("JARR_DSNDTTKT");
				json = new JSONObject();
				json.put("data", jSONArray);
			} else if ("treeComboStore".equals(method)) {
				jSONArray = (JSONArray) KtnbCache.getInstance().get("JARR_DSDM");
				json = new JSONObject();
				json.put("data", jSONArray);
			} else if ("cucComboStoreAll".equals(method)) {
				if (Formater.isNull(query)) {
					jSONArray = new JSONArray();
					jSONArray.add(new CategoryVO("*", Constants.TATCA));
					jSONArray.addAll((JSONArray) KtnbCache.getInstance().get("JARR_DSTINH"));
					json = new JSONObject();
					json.put("data", jSONArray);
				} else
					json = ktnbDAO.getDsCucThue(searchStoreVO);
			} else if ("chucvuComboStore".equals(method)) {
				jSONArray = (JSONArray) KtnbCache.getInstance().get("JARR_DSCHUCVU");
				json = new JSONObject();
				json.put("data", jSONArray);
			} else if ("cucComboStore".equals(method)) {
				if (Formater.isNull(query)) {
					jSONArray = (JSONArray) KtnbCache.getInstance().get("JARR_DSTINH");
					json = new JSONObject();
					json.put("data", jSONArray);
				} else
					json = ktnbDAO.getDsCucThue(searchStoreVO);
			} else if ("cqtComboStore".equals(method)) {
				String macuc = (String) request.getParameter("macuc");
				jSONArray = new JSONArray();
				if (!"000".equals(macuc)) {
					jSONArray.add(new CategoryVO("*", Constants.TATCA));
					c = KtnbUtil.getCqtByMaTinh(macuc);
					for (Iterator iter = c.iterator(); iter.hasNext();)
						jSONArray.add((CategoryVO) iter.next());
				} else {
					jSONArray.add(new CategoryVO(Constants.TCT_CODE, Constants.TATCA));
				}
				json = new JSONObject();
				json.put("data", jSONArray);
			} else if ("namComboStore".equals(method)) {
				jSONArray = new JSONArray();
				for (int i = 2010; i < 2099; i++)
					jSONArray.add(new CategoryVO(Integer.toString(i), Integer.toString(i)));
				json = new JSONObject();
				json.put("data", jSONArray);
			} else if ("phongComboStore".equals(method)) {
				String macqt = (String) request.getParameter("macqt");
				jSONArray = new JSONArray();
				jSONArray.add(new CategoryVO("*", Constants.TATCA));
				if (!"*".equals(macqt)) {
					c = KtnbUtil.getDeptByMaCqt(macqt);
					for (Iterator iter = c.iterator(); iter.hasNext();)
						jSONArray.add((CategoryVO) iter.next());
				}
				json = new JSONObject();
				json.put("data", jSONArray);
			} else if ("phongEditComboStore".equals(method)) {
				String macqt = (String) request.getParameter("macqt");
				jSONArray = new JSONArray();
				if (!"*".equals(macqt)) {
					c = KtnbUtil.getDeptByMaCqt(macqt);
					for (Iterator iter = c.iterator(); iter.hasNext();)
						jSONArray.add((CategoryVO) iter.next());
				}
				json = new JSONObject();
				json.put("data", jSONArray);
			} else if ("tree".equals(method)) {
				jSONArray = new JSONArray();
//				jSONArray.add(ktnbDAO.getTree(request.getParameter("node"), request.getParameter("id"), request.getParameter("rls")));
				String parentId = request.getParameter("node");
				jSONArray.add(ktnbDAO.getTree(parentId, false));
				out.println(jSONArray.toString());
				out.flush();
				out.close();
				return null;
			}else if ("treecqt".equals(method)) {
				jSONArray = new JSONArray();
				jSONArray.add(ktnbDAO.getTreeCqt(request.getParameter("id")));
				out.println(jSONArray.toString());
				out.flush();
				out.close();
				return null;
			} 
			else if ("treeDm".equals(method)) {
				jSONArray = new JSONArray();
				jSONArray.add(ktnbDAO.getTree(request.getParameter("node"), request.getParameter("id"), request.getParameter("rls")));
				out.println(jSONArray.toString());
				out.flush();
				out.close();
				return null;
			}
			else if ("dsdb".equals(method))
				json = ktnbDAO.getDsDB();
			else if ("dscqt".equals(method)) {
				searchStoreVO.parentId = (String) request.getParameter("parentId");
				json = ktnbDAO.getDsCqt(searchStoreVO);
			}
			else if ("dsrole".equals(method)) {
				String parentId = (String) request.getParameter("parentId");
				
				json = ktnbDAO.getRoleByUser(parentId);
				
			} else if ("dsdata".equals(method)) {
				String parentId = (String) request.getParameter("parentId");
				json = ktnbDAO.getAllUser(parentId);
			} else if ("dscanbo".equals(method)) {
				if ("create".equals(xaction)) {
					for (int i = 0; i < jSONArray.size(); i++) {
						jSONObject = (JSONObject) jSONArray.get(i);
						ktnbDAO.insCanBo(jSONObject);
					}
				} else if ("update".equals(xaction)) {
					for (int i = 0; i < jSONArray.size(); i++) {
						jSONObject = (JSONObject) jSONArray.get(i);
						ktnbDAO.updCanBo(jSONObject);
					}
				} else {
					searchStoreVO.macuc = (String) request.getParameter("macuc");
					searchStoreVO.macqt = (String) request.getParameter("macqt");
					searchStoreVO.maphong = (String) request.getParameter("maphong");
					searchStoreVO.status = (String) request.getParameter("status");
					json = ktnbDAO.getDsCanBo(searchStoreVO);
				}
			} else if ("dsttkt".equals(method)) {
				searchStoreVO.macqt = ac.getMaCqt();
				searchStoreVO.tu_ngay = (String) request.getParameter("tu_ngay");
				searchStoreVO.den_ngay = (String) request.getParameter("den_ngay");
				searchStoreVO.loai_ttkt = (String) request.getParameter("loai_ttkt");
				searchStoreVO.hinhthuc_ttkt = (String) request.getParameter("hinhthuc_ttkt");
				searchStoreVO.status = (String) request.getParameter("status_ttkt");
				searchStoreVO.ma_dv_ttkt = (String) request.getParameter("ma_dv_ttkt");
				searchStoreVO.ma_ttkt = (String) request.getParameter("ma_ttkt");
				searchStoreVO.noidung_ttkt = (String) request.getParameter("noidung_ttkt");
				json = ktnbDAO.getDsCuocTTKT(searchStoreVO);
			} else if ("dstime".equals(method)) {
				if ("read".equals(xaction)) {
					searchStoreVO.parentId = (String) request.getParameter("parentId");
					json = ktnbDAO.getDsTime(searchStoreVO);
				} else if ("update".equals(xaction)) {
					for (int i = 0; i < jSONArray.size(); i++) {
						jSONObject = (JSONObject) jSONArray.get(i);
						ktnbDAO.updateDMTime(jSONObject);
					}
				}
			} else if ("dsphong".equals(method)) {
				String macqt = (String) request.getParameter("macqt");
				if ("create".equals(xaction)) {
					for (int i = 0; i < jSONArray.size(); i++) {
						jSONObject = (JSONObject) jSONArray.get(i);
						if (jSONObject != null)
							ktnbDAO.insDMPhong(macqt, jSONObject);
					}
				} else if ("update".equals(xaction)) {
					for (int i = 0; i < jSONArray.size(); i++) {
						jSONObject = (JSONObject) jSONArray.get(i);
						ktnbDAO.updDMPhong(jSONObject);
					}
				} else {
					searchStoreVO.macuc = (String) request.getParameter("macuc");
					searchStoreVO.macqt = macqt;
					json = ktnbDAO.getDsPhong(searchStoreVO);

				}
			} else if ("dsngaynghi".equals(method)) {
				String nam = (String) request.getParameter("nam");
				searchStoreVO.nam = nam;
				if ("create".equals(xaction)) {
					for (int i = 0; i < jSONArray.size(); i++) {
						jSONObject = (JSONObject) jSONArray.get(i);
						if (jSONObject != null)
							ktnbDAO.insDMNgayNghi(nam, jSONObject);
					}
				} else if ("update".equals(xaction)) {
					for (int i = 0; i < jSONArray.size(); i++) {
						jSONObject = (JSONObject) jSONArray.get(i);
						ktnbDAO.updDMNgayNghi(nam,jSONObject);
					}
				} else {
					// searchStoreVO.macuc = (String) request.getParameter("macuc");
					json = ktnbDAO.getDsNgayNghi(searchStoreVO);
				}
			}
			// System.out.println(json);
			out.println(json);
			out.flush();
			out.close();
		} catch (Exception e) {
			throw e;
		} finally {
			KtnbUtil.releaseKtnbDAO(ktnbDAO);
		}
		return null;
	}
}
