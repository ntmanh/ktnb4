package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _ho_5F_so_5F_xu_5F_ly_5F_td extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _ho_5F_so_5F_xu_5F_ly_5F_td( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/kntc/std/ho_so_xu_ly_td.jsp";

  public final void _jspx_init() throws org.apache.jasper.runtime.JspException {
    /* Init Method Phase */
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse  response)
      throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    String  _value = null;
    java.util.Stack _jspxTagObjects = new java.util.Stack();
    /* Service Declaration Phase */
      /* ------  bean:write ------ */
      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = new org.apache.struts.taglib.bean.WriteTag();

                                  try {

                                    if (_jspx_inited == false) {
                                      synchronized (this) {
                                        if (_jspx_inited == false) {
                                          _jspx_init();
                                          _jspx_inited = true;
                                        }
                                      }
                                    }

                                    _jspxFactory = JspFactory.getDefaultFactory();
                                    response.setContentType("text/html;charset=UTF-8");
                                    pageContext = _jspxFactory.getPageContext(this, request, response,
                                    			"", true, 8192, true);

                                    application = pageContext.getServletContext();
                                    config = pageContext.getServletConfig();
                                    session = pageContext.getSession();
                                    out = pageContext.getOut();

                                    /* Service Method Phase */

                                    // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(0,31);to=(1,0)]
                                      out.write("\r\n");

                                    // end
                                    // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(1,59);to=(2,0)]
                                      out.write("\r\n");

                                    // end
                                    // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(2,57);to=(3,0)]
                                      out.write("\r\n");

                                    // end
                                    // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(3,57);to=(4,23)]
                                      out.write("\r\n<h5>Trạng thái hồ sơ : ");

                                    // end
                                    // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 5,23-"/kntc/std/ho_so_xu_ly_td.jsp" 5,81  LineMapIndex:1
                                      _jspx_th_bean_write_0.setPageContext(pageContext);
                                      _jspx_th_bean_write_0.setParent(null);
                                      _jspx_th_bean_write_0.setName("tiepDanForm");
                                      _jspx_th_bean_write_0.setProperty("trangThaiText");
                                      _jspxTagObjects.push(_jspx_th_bean_write_0);
                                        int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
                                      // end
                                      // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 5,23-"/kntc/std/ho_so_xu_ly_td.jsp" 5,81  LineMapIndex:2
                                        if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                          return;
                                      ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                    // end
                                    // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(4,81);to=(5,73)]
                                      out.write("</h5>\r\n<h5>Hồ sơ chuyển: <a href=\"kntc_tiep_dan.do?method=view&action=tkxuly&id=");

                                    // end
                                    // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 6,73-"/kntc/std/ho_so_xu_ly_td.jsp" 6,129  LineMapIndex:3
                                      /* ------  bean:write ------ */
                                      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_1 = new org.apache.struts.taglib.bean.WriteTag();
                                      _jspx_th_bean_write_1.setPageContext(pageContext);
                                      _jspx_th_bean_write_1.setParent(null);
                                      _jspx_th_bean_write_1.setName("tiepDanForm");
                                      _jspx_th_bean_write_1.setProperty("maHoSoChuyen");
                                      _jspxTagObjects.push(_jspx_th_bean_write_1);
                                        int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
                                      // end
                                      // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 6,73-"/kntc/std/ho_so_xu_ly_td.jsp" 6,129  LineMapIndex:4
                                        if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                          return;
                                      ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                    // end
                                    // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(5,129);to=(5,132)]
                                      out.write("\" >");

                                    // end
                                    // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 6,132-"/kntc/std/ho_so_xu_ly_td.jsp" 6,189  LineMapIndex:5
                                      /* ------  bean:write ------ */
                                      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_2 = new org.apache.struts.taglib.bean.WriteTag();
                                      _jspx_th_bean_write_2.setPageContext(pageContext);
                                      _jspx_th_bean_write_2.setParent(null);
                                      _jspx_th_bean_write_2.setName("tiepDanForm");
                                      _jspx_th_bean_write_2.setProperty("maHoSoChuyen");
                                      _jspxTagObjects.push(_jspx_th_bean_write_2);
                                        int _jspx_eval_bean_write_2 = _jspx_th_bean_write_2.doStartTag();
                                      // end
                                      // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 6,132-"/kntc/std/ho_so_xu_ly_td.jsp" 6,189  LineMapIndex:6
                                        if (_jspx_th_bean_write_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                          return;
                                      ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                    // end
                                    // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(5,189);to=(6,0)]
                                      out.write("</a></h5>\r\n");

                                    // end
                                    // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 7,0-"/kntc/std/ho_so_xu_ly_td.jsp" 7,54  LineMapIndex:7
                                      /* ------  logic:present ------ */
                                      org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_0 = new org.apache.struts.taglib.logic.PresentTag();
                                      _jspx_th_logic_present_0.setPageContext(pageContext);
                                      _jspx_th_logic_present_0.setParent(null);
                                      _jspx_th_logic_present_0.setName("tiepDanForm");
                                      _jspx_th_logic_present_0.setProperty("loaiKNTC");
                                      _jspxTagObjects.push(_jspx_th_logic_present_0);
                                        int _jspx_eval_logic_present_0 = _jspx_th_logic_present_0.doStartTag();
                                        if (_jspx_eval_logic_present_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                          do {
                                          // end
                                          // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(6,54);to=(8,1)]
                                            out.write("\r\n\t<!--loaiKNTC = 1 ( don khieu nai)-->\r\n\t");

                                          // end
                                          // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 9,1-"/kntc/std/ho_so_xu_ly_td.jsp" 9,63  LineMapIndex:8
                                            /* ------  logic:equal ------ */
                                            org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_0 = new org.apache.struts.taglib.logic.EqualTag();
                                            _jspx_th_logic_equal_0.setPageContext(pageContext);
                                            _jspx_th_logic_equal_0.setParent(_jspx_th_logic_present_0);
                                            _jspx_th_logic_equal_0.setName("tiepDanForm");
                                            _jspx_th_logic_equal_0.setProperty("loaiKNTC");
                                            _jspx_th_logic_equal_0.setValue("1");
                                            _jspxTagObjects.push(_jspx_th_logic_equal_0);
                                              int _jspx_eval_logic_equal_0 = _jspx_th_logic_equal_0.doStartTag();
                                              if (_jspx_eval_logic_equal_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                do {
                                                // end
                                                // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(8,63);to=(9,75)]
                                                  out.write("\r\n\t\t<a href=\"lich_trinh_du_kien.do?method=show&action=lichTrinhDKKN&r=rol&id=");

                                                // end
                                                // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 10,75-"/kntc/std/ho_so_xu_ly_td.jsp" 10,125  LineMapIndex:9
                                                  /* ------  bean:write ------ */
                                                  org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_3 = new org.apache.struts.taglib.bean.WriteTag();
                                                  _jspx_th_bean_write_3.setPageContext(pageContext);
                                                  _jspx_th_bean_write_3.setParent(_jspx_th_logic_equal_0);
                                                  _jspx_th_bean_write_3.setName("tiepDanForm");
                                                  _jspx_th_bean_write_3.setProperty("maHoSo");
                                                  _jspxTagObjects.push(_jspx_th_bean_write_3);
                                                    int _jspx_eval_bean_write_3 = _jspx_th_bean_write_3.doStartTag();
                                                  // end
                                                  // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 10,75-"/kntc/std/ho_so_xu_ly_td.jsp" 10,125  LineMapIndex:10
                                                    if (_jspx_th_bean_write_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                      return;
                                                  ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                // end
                                                // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(9,125);to=(13,55)]
                                                  out.write("\" style=\"font-size: 8pt; font-weight: bold; margin-top: 10px;\" > Lịch trình dự kiến</a>\r\n\t\t<!--TiepDan-->\r\n\t\t<fieldset><legend>Tiếp dân</legend>\r\n\t\t<ol>\r\n\t\t\t<LI><a href=\"kntc_phieu_hen.do?method=show&r=rol&id=");

                                                // end
                                                // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 14,55-"/kntc/std/ho_so_xu_ly_td.jsp" 14,105  LineMapIndex:11
                                                  /* ------  bean:write ------ */
                                                  org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_4 = new org.apache.struts.taglib.bean.WriteTag();
                                                  _jspx_th_bean_write_4.setPageContext(pageContext);
                                                  _jspx_th_bean_write_4.setParent(_jspx_th_logic_equal_0);
                                                  _jspx_th_bean_write_4.setName("tiepDanForm");
                                                  _jspx_th_bean_write_4.setProperty("maHoSo");
                                                  _jspxTagObjects.push(_jspx_th_bean_write_4);
                                                    int _jspx_eval_bean_write_4 = _jspx_th_bean_write_4.doStartTag();
                                                  // end
                                                  // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 14,55-"/kntc/std/ho_so_xu_ly_td.jsp" 14,105  LineMapIndex:12
                                                    if (_jspx_th_bean_write_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                      return;
                                                  ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                // end
                                                // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(13,105);to=(14,53)]
                                                  out.write("\" > Phiếu hẹn (Mẫu số 02/KNTC)</a></LI>\r\n\t\t\t<LI><a href=\"kntc_giay_bn.do?method=cghs&r=rol&id=");

                                                // end
                                                // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 15,53-"/kntc/std/ho_so_xu_ly_td.jsp" 15,103  LineMapIndex:13
                                                  /* ------  bean:write ------ */
                                                  org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_5 = new org.apache.struts.taglib.bean.WriteTag();
                                                  _jspx_th_bean_write_5.setPageContext(pageContext);
                                                  _jspx_th_bean_write_5.setParent(_jspx_th_logic_equal_0);
                                                  _jspx_th_bean_write_5.setName("tiepDanForm");
                                                  _jspx_th_bean_write_5.setProperty("maHoSo");
                                                  _jspxTagObjects.push(_jspx_th_bean_write_5);
                                                    int _jspx_eval_bean_write_5 = _jspx_th_bean_write_5.doStartTag();
                                                  // end
                                                  // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 15,53-"/kntc/std/ho_so_xu_ly_td.jsp" 15,103  LineMapIndex:14
                                                    if (_jspx_th_bean_write_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                      return;
                                                  ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                // end
                                                // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(14,103);to=(21,71)]
                                                  out.write("\" > Phiếu giao nhận hồ sơ (Mẫu số 03/KNTC)</a></LI>\r\n\t\t</ol>\r\n\t\t</fieldset>\t\t\r\n\t\t<fieldset>\r\n\t\t<legend>Thông tin xử lý</legend>\r\n\t\t<ol>\r\n\t\t\t<li>\r\n\t\t\t\t<a href=\"phieu_dxxl_kn.do?method=show&action=phanloaiHSKN&r=rol&id=");

                                                // end
                                                // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 22,71-"/kntc/std/ho_so_xu_ly_td.jsp" 22,121  LineMapIndex:15
                                                  /* ------  bean:write ------ */
                                                  org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_6 = new org.apache.struts.taglib.bean.WriteTag();
                                                  _jspx_th_bean_write_6.setPageContext(pageContext);
                                                  _jspx_th_bean_write_6.setParent(_jspx_th_logic_equal_0);
                                                  _jspx_th_bean_write_6.setName("tiepDanForm");
                                                  _jspx_th_bean_write_6.setProperty("maHoSo");
                                                  _jspxTagObjects.push(_jspx_th_bean_write_6);
                                                    int _jspx_eval_bean_write_6 = _jspx_th_bean_write_6.doStartTag();
                                                  // end
                                                  // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 22,71-"/kntc/std/ho_so_xu_ly_td.jsp" 22,121  LineMapIndex:16
                                                    if (_jspx_th_bean_write_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                      return;
                                                  ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                // end
                                                // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(21,121);to=(25,1)]
                                                  out.write("\" > Thông tin xử lý</a>\r\n\t\t\t</li>\r\n\t\t</ol>\r\n\t\t</fieldset>\r\n\t");

                                                // end
                                                // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 26,1-"/kntc/std/ho_so_xu_ly_td.jsp" 26,15  LineMapIndex:17
                                                } while (_jspx_th_logic_equal_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                              }
                                              if (_jspx_th_logic_equal_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                return;
                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                          // end
                                          // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(25,15);to=(27,1)]
                                            out.write("\r\n\t<!--loaiKNTC = 2  ( don to cao)-->\r\n\t");

                                          // end
                                          // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 28,1-"/kntc/std/ho_so_xu_ly_td.jsp" 28,63  LineMapIndex:18
                                            /* ------  logic:equal ------ */
                                            org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_1 = new org.apache.struts.taglib.logic.EqualTag();
                                            _jspx_th_logic_equal_1.setPageContext(pageContext);
                                            _jspx_th_logic_equal_1.setParent(_jspx_th_logic_present_0);
                                            _jspx_th_logic_equal_1.setName("tiepDanForm");
                                            _jspx_th_logic_equal_1.setProperty("loaiKNTC");
                                            _jspx_th_logic_equal_1.setValue("2");
                                            _jspxTagObjects.push(_jspx_th_logic_equal_1);
                                              int _jspx_eval_logic_equal_1 = _jspx_th_logic_equal_1.doStartTag();
                                              if (_jspx_eval_logic_equal_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                do {
                                                // end
                                                // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(27,63);to=(28,75)]
                                                  out.write("\r\n\t\t<a href=\"lich_trinh_du_kien.do?method=show&action=lichTrinhDKTC&r=rol&id=");

                                                // end
                                                // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 29,75-"/kntc/std/ho_so_xu_ly_td.jsp" 29,125  LineMapIndex:19
                                                  /* ------  bean:write ------ */
                                                  org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_7 = new org.apache.struts.taglib.bean.WriteTag();
                                                  _jspx_th_bean_write_7.setPageContext(pageContext);
                                                  _jspx_th_bean_write_7.setParent(_jspx_th_logic_equal_1);
                                                  _jspx_th_bean_write_7.setName("tiepDanForm");
                                                  _jspx_th_bean_write_7.setProperty("maHoSo");
                                                  _jspxTagObjects.push(_jspx_th_bean_write_7);
                                                    int _jspx_eval_bean_write_7 = _jspx_th_bean_write_7.doStartTag();
                                                  // end
                                                  // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 29,75-"/kntc/std/ho_so_xu_ly_td.jsp" 29,125  LineMapIndex:20
                                                    if (_jspx_th_bean_write_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                      return;
                                                  ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                // end
                                                // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(28,125);to=(32,55)]
                                                  out.write("\" style=\"font-size: 8pt; font-weight: bold; margin-top: 10px;\" > Lịch trình dự kiến</a>\r\n\t\t<!--TiepDan-->\r\n\t\t<fieldset><legend>Tiếp dân</legend>\r\n\t\t<ol>\r\n\t\t\t<LI><a href=\"kntc_phieu_hen.do?method=show&r=rol&id=");

                                                // end
                                                // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 33,55-"/kntc/std/ho_so_xu_ly_td.jsp" 33,105  LineMapIndex:21
                                                  /* ------  bean:write ------ */
                                                  org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_8 = new org.apache.struts.taglib.bean.WriteTag();
                                                  _jspx_th_bean_write_8.setPageContext(pageContext);
                                                  _jspx_th_bean_write_8.setParent(_jspx_th_logic_equal_1);
                                                  _jspx_th_bean_write_8.setName("tiepDanForm");
                                                  _jspx_th_bean_write_8.setProperty("maHoSo");
                                                  _jspxTagObjects.push(_jspx_th_bean_write_8);
                                                    int _jspx_eval_bean_write_8 = _jspx_th_bean_write_8.doStartTag();
                                                  // end
                                                  // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 33,55-"/kntc/std/ho_so_xu_ly_td.jsp" 33,105  LineMapIndex:22
                                                    if (_jspx_th_bean_write_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                      return;
                                                  ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                // end
                                                // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(32,105);to=(33,53)]
                                                  out.write("\" > Phiếu hẹn (Mẫu số 02/KNTC)</a></LI>\r\n\t\t\t<LI><a href=\"kntc_giay_bn.do?method=cghs&r=rol&id=");

                                                // end
                                                // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 34,53-"/kntc/std/ho_so_xu_ly_td.jsp" 34,103  LineMapIndex:23
                                                  /* ------  bean:write ------ */
                                                  org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_9 = new org.apache.struts.taglib.bean.WriteTag();
                                                  _jspx_th_bean_write_9.setPageContext(pageContext);
                                                  _jspx_th_bean_write_9.setParent(_jspx_th_logic_equal_1);
                                                  _jspx_th_bean_write_9.setName("tiepDanForm");
                                                  _jspx_th_bean_write_9.setProperty("maHoSo");
                                                  _jspxTagObjects.push(_jspx_th_bean_write_9);
                                                    int _jspx_eval_bean_write_9 = _jspx_th_bean_write_9.doStartTag();
                                                  // end
                                                  // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 34,53-"/kntc/std/ho_so_xu_ly_td.jsp" 34,103  LineMapIndex:24
                                                    if (_jspx_th_bean_write_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                      return;
                                                  ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                // end
                                                // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(33,103);to=(40,71)]
                                                  out.write("\" > Phiếu giao nhận hồ sơ (Mẫu số 03/KNTC)</a></LI>\r\n\t\t</ol>\r\n\t\t</fieldset>\t\r\n\t\t<fieldset>\r\n\t\t<legend>Thông tin xử lý</legend>\r\n\t\t<ol>\r\n\t\t\t<li>\r\n\t\t\t\t<a href=\"phieu_dxxl_kn.do?method=show&action=phanloaiHSTC&r=rol&id=");

                                                // end
                                                // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 41,71-"/kntc/std/ho_so_xu_ly_td.jsp" 41,121  LineMapIndex:25
                                                  /* ------  bean:write ------ */
                                                  org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_10 = new org.apache.struts.taglib.bean.WriteTag();
                                                  _jspx_th_bean_write_10.setPageContext(pageContext);
                                                  _jspx_th_bean_write_10.setParent(_jspx_th_logic_equal_1);
                                                  _jspx_th_bean_write_10.setName("tiepDanForm");
                                                  _jspx_th_bean_write_10.setProperty("maHoSo");
                                                  _jspxTagObjects.push(_jspx_th_bean_write_10);
                                                    int _jspx_eval_bean_write_10 = _jspx_th_bean_write_10.doStartTag();
                                                  // end
                                                  // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 41,71-"/kntc/std/ho_so_xu_ly_td.jsp" 41,121  LineMapIndex:26
                                                    if (_jspx_th_bean_write_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                      return;
                                                  ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                // end
                                                // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(40,121);to=(44,1)]
                                                  out.write("\" > Thông tin xử lý</a>\r\n\t\t\t</li>\r\n\t\t</ol>\r\n\t\t</fieldset>\t\r\n\t");

                                                // end
                                                // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 45,1-"/kntc/std/ho_so_xu_ly_td.jsp" 45,15  LineMapIndex:27
                                                } while (_jspx_th_logic_equal_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                              }
                                              if (_jspx_th_logic_equal_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                return;
                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                          // end
                                          // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(44,15);to=(45,0)]
                                            out.write("\r\n");

                                          // end
                                          // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 46,0-"/kntc/std/ho_so_xu_ly_td.jsp" 46,16  LineMapIndex:28
                                          } while (_jspx_th_logic_present_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                        }
                                        if (_jspx_th_logic_present_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                          return;
                                      ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                    // end
                                    // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(45,16);to=(46,48)]
                                      out.write("\r\n<p><a href=\"kntc_qdgq.do?method=rutdon&r=rol&id=");

                                    // end
                                    // ##DEBUG## ##TAGLIB## "/kntc/std/ho_so_xu_ly_td.jsp" 47,48-"/kntc/std/ho_so_xu_ly_td.jsp" 47,98  LineMapIndex:29
                                      /* ------  bean:write ------ */
                                      org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_11 = new org.apache.struts.taglib.bean.WriteTag();
                                      _jspx_th_bean_write_11.setPageContext(pageContext);
                                      _jspx_th_bean_write_11.setParent(null);
                                      _jspx_th_bean_write_11.setName("tiepDanForm");
                                      _jspx_th_bean_write_11.setProperty("maHoSo");
                                      _jspxTagObjects.push(_jspx_th_bean_write_11);
                                        int _jspx_eval_bean_write_11 = _jspx_th_bean_write_11.doStartTag();
                                      // end
                                      // ##DEBUG## "/kntc/std/ho_so_xu_ly_td.jsp" 47,48-"/kntc/std/ho_so_xu_ly_td.jsp" 47,98  LineMapIndex:30
                                        if (_jspx_th_bean_write_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                          return;
                                      ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                    // end
                                    // HTML // begin [file="/kntc/std/ho_so_xu_ly_td.jsp";from=(46,98);to=(47,0)]
                                      out.write("\" style=\"font-size: 8pt; font-weight: bold; margin-top: 10px;\">Xem thông tin rút đơn/đóng đơn</a></p>\r\n");

                                    // end

                                  } catch (Throwable t) {
                                    if (out != null && out.getBufferSize() != 0)
                                      out.clearBuffer();
                                    if (pageContext != null) pageContext.handlePageException(t);
                                  } finally {
                                    while (_jspxTagObjects.empty() == false){
                                      ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                    }
                                    if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);

                                    /* Service Finally Phase */
                                  }
                                }
                                public static String[][] _jspx_debug_FileMapping = {
                                {
                                "/kntc/std/ho_so_xu_ly_td.jsp", 
                                },
                                {
                                "0", 
                                },
                                };
                                public static String[][] _jspx_debug_LineMapping = {
                                {
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                "0", 
                                },
                                {
                                "1", 
                                "5", 
                                "5", 
                                "6", 
                                "6", 
                                "6", 
                                "6", 
                                "7", 
                                "9", 
                                "10", 
                                "10", 
                                "14", 
                                "14", 
                                "15", 
                                "15", 
                                "22", 
                                "22", 
                                "26", 
                                "28", 
                                "29", 
                                "29", 
                                "33", 
                                "33", 
                                "34", 
                                "34", 
                                "41", 
                                "41", 
                                "45", 
                                "46", 
                                "47", 
                                "47", 
                                },
                                };
                              }
