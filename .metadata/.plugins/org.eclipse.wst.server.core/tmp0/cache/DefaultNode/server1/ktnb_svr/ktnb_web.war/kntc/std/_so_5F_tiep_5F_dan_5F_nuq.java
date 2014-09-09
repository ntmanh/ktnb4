package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _so_5F_tiep_5F_dan_5F_nuq extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _so_5F_tiep_5F_dan_5F_nuq( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/kntc/std/so_tiep_dan_nuq.jsp";

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
      /* ------  logic:present ------ */
      org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_0 = new org.apache.struts.taglib.logic.PresentTag();

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

                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(0,31);to=(1,0)]
                                                                out.write("\r\n");

                                                              // end
                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(1,59);to=(2,0)]
                                                                out.write("\r\n");

                                                              // end
                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(2,57);to=(3,0)]
                                                                out.write("\r\n");

                                                              // end
                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(3,57);to=(4,0)]
                                                                out.write("\r\n");

                                                              // end
                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 5,0-"/kntc/std/so_tiep_dan_nuq.jsp" 5,53  LineMapIndex:1
                                                                _jspx_th_logic_present_0.setPageContext(pageContext);
                                                                _jspx_th_logic_present_0.setParent(null);
                                                                _jspx_th_logic_present_0.setName("tiepDanForm");
                                                                _jspx_th_logic_present_0.setProperty("uyQuyen");
                                                                _jspxTagObjects.push(_jspx_th_logic_present_0);
                                                                  int _jspx_eval_logic_present_0 = _jspx_th_logic_present_0.doStartTag();
                                                                  if (_jspx_eval_logic_present_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                    do {
                                                                    // end
                                                                    // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(4,53);to=(5,1)]
                                                                      out.write("\r\n\t");

                                                                    // end
                                                                    // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 6,1-"/kntc/std/so_tiep_dan_nuq.jsp" 6,62  LineMapIndex:2
                                                                      /* ------  logic:equal ------ */
                                                                      org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_0 = new org.apache.struts.taglib.logic.EqualTag();
                                                                      _jspx_th_logic_equal_0.setPageContext(pageContext);
                                                                      _jspx_th_logic_equal_0.setParent(_jspx_th_logic_present_0);
                                                                      _jspx_th_logic_equal_0.setName("tiepDanForm");
                                                                      _jspx_th_logic_equal_0.setProperty("uyQuyen");
                                                                      _jspx_th_logic_equal_0.setValue("1");
                                                                      _jspxTagObjects.push(_jspx_th_logic_equal_0);
                                                                        int _jspx_eval_logic_equal_0 = _jspx_th_logic_equal_0.doStartTag();
                                                                        if (_jspx_eval_logic_equal_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                          do {
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(5,62);to=(10,20)]
                                                                            out.write("\r\n\t\t<fieldset><legend>Thông tin Người ủy quyền</legend>\r\n\t\t<table width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Họ tên <font color=\"red\">*</font></td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 11,20-"/kntc/std/so_tiep_dan_nuq.jsp" 11,52  LineMapIndex:3
                                                                            /* ------  html:hidden ------ */
                                                                            org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = new org.apache.struts.taglib.html.HiddenTag();
                                                                            _jspx_th_html_hidden_0.setPageContext(pageContext);
                                                                            _jspx_th_html_hidden_0.setParent(_jspx_th_logic_equal_0);
                                                                            _jspx_th_html_hidden_0.setProperty("nuqMa");
                                                                            _jspxTagObjects.push(_jspx_th_html_hidden_0);
                                                                              int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 11,20-"/kntc/std/so_tiep_dan_nuq.jsp" 11,52  LineMapIndex:4
                                                                              if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(10,52);to=(10,53)]
                                                                            out.write(" ");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 11,53-"/kntc/std/so_tiep_dan_nuq.jsp" 11,102  LineMapIndex:5
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_0.setPageContext(pageContext);
                                                                            _jspx_th_html_text_0.setParent(_jspx_th_logic_equal_0);
                                                                            _jspx_th_html_text_0.setProperty("nuqTen");
                                                                            _jspx_th_html_text_0.setStyle("width: 100%");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_0);
                                                                              int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 11,53-"/kntc/std/so_tiep_dan_nuq.jsp" 11,114  LineMapIndex:6
                                                                              if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(10,114);to=(12,20)]
                                                                            out.write("</td>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Địa chỉ</td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 13,20-"/kntc/std/so_tiep_dan_nuq.jsp" 13,74  LineMapIndex:7
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_1 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_1.setPageContext(pageContext);
                                                                            _jspx_th_html_text_1.setParent(_jspx_th_logic_equal_0);
                                                                            _jspx_th_html_text_1.setProperty("nuqDiaChi");
                                                                            _jspx_th_html_text_1.setStyle("width: 100%");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_1);
                                                                              int _jspx_eval_html_text_1 = _jspx_th_html_text_1.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 13,20-"/kntc/std/so_tiep_dan_nuq.jsp" 13,74  LineMapIndex:8
                                                                              if (_jspx_th_html_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(12,74);to=(16,8)]
                                                                            out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">Nơi công tác</td>\r\n\t\t\t\t<td>");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 17,8-"/kntc/std/so_tiep_dan_nuq.jsp" 17,66  LineMapIndex:9
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_2.setPageContext(pageContext);
                                                                            _jspx_th_html_text_2.setParent(_jspx_th_logic_equal_0);
                                                                            _jspx_th_html_text_2.setProperty("nuqNoiCongTac");
                                                                            _jspx_th_html_text_2.setStyle("width: 100%");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_2);
                                                                              int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 17,8-"/kntc/std/so_tiep_dan_nuq.jsp" 17,66  LineMapIndex:10
                                                                              if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(16,66);to=(18,8)]
                                                                            out.write("</td>\r\n\t\t\t\t<td style=\"text-align: right;\">Chức vụ</td>\r\n\t\t\t\t<td>");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 19,8-"/kntc/std/so_tiep_dan_nuq.jsp" 19,62  LineMapIndex:11
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_3 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_3.setPageContext(pageContext);
                                                                            _jspx_th_html_text_3.setParent(_jspx_th_logic_equal_0);
                                                                            _jspx_th_html_text_3.setProperty("nuqChucVu");
                                                                            _jspx_th_html_text_3.setStyle("width: 100%");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_3);
                                                                              int _jspx_eval_html_text_3 = _jspx_th_html_text_3.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 19,8-"/kntc/std/so_tiep_dan_nuq.jsp" 19,62  LineMapIndex:12
                                                                              if (_jspx_th_html_text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(18,62);to=(22,8)]
                                                                            out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">CMT/Hộ chiếu <font color=\"red\">*</font></td>\r\n\t\t\t\t<td>");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 23,8-"/kntc/std/so_tiep_dan_nuq.jsp" 23,59  LineMapIndex:13
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_4 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_4.setPageContext(pageContext);
                                                                            _jspx_th_html_text_4.setParent(_jspx_th_logic_equal_0);
                                                                            _jspx_th_html_text_4.setProperty("nuqCMT");
                                                                            _jspx_th_html_text_4.setStyle("width: 100%");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_4);
                                                                              int _jspx_eval_html_text_4 = _jspx_th_html_text_4.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 23,8-"/kntc/std/so_tiep_dan_nuq.jsp" 23,59  LineMapIndex:14
                                                                              if (_jspx_th_html_text_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(22,59);to=(24,8)]
                                                                            out.write("</td>\r\n\t\t\t\t<td style=\"text-align: right;\">Điện thoại</td>\r\n\t\t\t\t<td>");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 25,8-"/kntc/std/so_tiep_dan_nuq.jsp" 25,65  LineMapIndex:15
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_5 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_5.setPageContext(pageContext);
                                                                            _jspx_th_html_text_5.setParent(_jspx_th_logic_equal_0);
                                                                            _jspx_th_html_text_5.setProperty("nuqDienThoai");
                                                                            _jspx_th_html_text_5.setStyle("width: 100%");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_5);
                                                                              int _jspx_eval_html_text_5 = _jspx_th_html_text_5.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 25,8-"/kntc/std/so_tiep_dan_nuq.jsp" 25,65  LineMapIndex:16
                                                                              if (_jspx_th_html_text_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(24,65);to=(28,8)]
                                                                            out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">Nơi cấp</td>\r\n\t\t\t\t<td>");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 29,8-"/kntc/std/so_tiep_dan_nuq.jsp" 29,65  LineMapIndex:17
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_6 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_6.setPageContext(pageContext);
                                                                            _jspx_th_html_text_6.setParent(_jspx_th_logic_equal_0);
                                                                            _jspx_th_html_text_6.setProperty("nuqCMTNoiCap");
                                                                            _jspx_th_html_text_6.setStyle("width: 100%");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_6);
                                                                              int _jspx_eval_html_text_6 = _jspx_th_html_text_6.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 29,8-"/kntc/std/so_tiep_dan_nuq.jsp" 29,65  LineMapIndex:18
                                                                              if (_jspx_th_html_text_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(28,65);to=(30,8)]
                                                                            out.write("</td>\r\n\t\t\t\t<td style=\"text-align: right;\">Ngày cấp</td>\r\n\t\t\t\t<td>");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 31,8-"/kntc/std/so_tiep_dan_nuq.jsp" 31,166  LineMapIndex:19
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_7 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_7.setPageContext(pageContext);
                                                                            _jspx_th_html_text_7.setParent(_jspx_th_logic_equal_0);
                                                                            _jspx_th_html_text_7.setProperty("nuqCMTNgayCap");
                                                                            _jspx_th_html_text_7.setStyle("width: 100%");
                                                                            _jspx_th_html_text_7.setMaxlength("10");
                                                                            _jspx_th_html_text_7.setStyle("width:100%");
                                                                            _jspx_th_html_text_7.setOnkeypress("return formatDate(event, this)");
                                                                            _jspx_th_html_text_7.setOnblur("isDate(this)");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_7);
                                                                              int _jspx_eval_html_text_7 = _jspx_th_html_text_7.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 31,8-"/kntc/std/so_tiep_dan_nuq.jsp" 31,166  LineMapIndex:20
                                                                              if (_jspx_th_html_text_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(30,166);to=(38,20)]
                                                                            out.write("</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t</fieldset>\r\n\t\t<fieldset><legend>Nội dung giấy ủy quyền</legend>\r\n\t\t<table width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Thời gian ủy quyền từ ngày</td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 39,20-"/kntc/std/so_tiep_dan_nuq.jsp" 39,155  LineMapIndex:21
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_8 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_8.setPageContext(pageContext);
                                                                            _jspx_th_html_text_8.setParent(_jspx_th_logic_equal_0);
                                                                            _jspx_th_html_text_8.setProperty("guqTuNgay");
                                                                            _jspx_th_html_text_8.setMaxlength("10");
                                                                            _jspx_th_html_text_8.setStyle("width: 100%");
                                                                            _jspx_th_html_text_8.setOnkeypress("return formatDate(event, this)");
                                                                            _jspx_th_html_text_8.setOnblur("isDate(this)");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_8);
                                                                              int _jspx_eval_html_text_8 = _jspx_th_html_text_8.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 39,20-"/kntc/std/so_tiep_dan_nuq.jsp" 39,155  LineMapIndex:22
                                                                              if (_jspx_th_html_text_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(38,155);to=(40,20)]
                                                                            out.write("</td>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Đến ngày</td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 41,20-"/kntc/std/so_tiep_dan_nuq.jsp" 41,156  LineMapIndex:23
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_9 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_9.setPageContext(pageContext);
                                                                            _jspx_th_html_text_9.setParent(_jspx_th_logic_equal_0);
                                                                            _jspx_th_html_text_9.setProperty("guqDenNgay");
                                                                            _jspx_th_html_text_9.setMaxlength("10");
                                                                            _jspx_th_html_text_9.setStyle("width: 100%");
                                                                            _jspx_th_html_text_9.setOnkeypress("return formatDate(event, this)");
                                                                            _jspx_th_html_text_9.setOnblur("isDate(this)");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_9);
                                                                              int _jspx_eval_html_text_9 = _jspx_th_html_text_9.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 41,20-"/kntc/std/so_tiep_dan_nuq.jsp" 41,156  LineMapIndex:24
                                                                              if (_jspx_th_html_text_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(40,156);to=(44,20)]
                                                                            out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">Nội dung</td>\r\n\t\t\t\t<td colspan=\"3\">");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 45,20-"/kntc/std/so_tiep_dan_nuq.jsp" 45,126  LineMapIndex:25
                                                                            /* ------  html:textarea ------ */
                                                                            org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_0 = new org.apache.struts.taglib.html.TextareaTag();
                                                                            _jspx_th_html_textarea_0.setPageContext(pageContext);
                                                                            _jspx_th_html_textarea_0.setParent(_jspx_th_logic_equal_0);
                                                                            _jspx_th_html_textarea_0.setProperty("guqNoiDung");
                                                                            _jspx_th_html_textarea_0.setStyle("width: 100%;height:80px");
                                                                            _jspx_th_html_textarea_0.setOnkeypress("imposeMaxLength(this);");
                                                                            _jspxTagObjects.push(_jspx_th_html_textarea_0);
                                                                              int _jspx_eval_html_textarea_0 = _jspx_th_html_textarea_0.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 45,20-"/kntc/std/so_tiep_dan_nuq.jsp" 45,126  LineMapIndex:26
                                                                              if (_jspx_th_html_textarea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(44,126);to=(48,8)]
                                                                            out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">Ngày xác nhận của chính quyền địa phương</td>\r\n\t\t\t\t<td>");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 49,8-"/kntc/std/so_tiep_dan_nuq.jsp" 49,147  LineMapIndex:27
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_10 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_10.setPageContext(pageContext);
                                                                            _jspx_th_html_text_10.setParent(_jspx_th_logic_equal_0);
                                                                            _jspx_th_html_text_10.setProperty("guqNgayXacNhan");
                                                                            _jspx_th_html_text_10.setMaxlength("10");
                                                                            _jspx_th_html_text_10.setStyle("width:100%");
                                                                            _jspx_th_html_text_10.setOnkeypress("return formatDate(event, this)");
                                                                            _jspx_th_html_text_10.setOnblur("isDate(this)");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_10);
                                                                              int _jspx_eval_html_text_10 = _jspx_th_html_text_10.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 49,8-"/kntc/std/so_tiep_dan_nuq.jsp" 49,147  LineMapIndex:28
                                                                              if (_jspx_th_html_text_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(48,147);to=(54,1)]
                                                                            out.write("</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t</fieldset>\r\n\t");

                                                                          // end
                                                                          // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 55,1-"/kntc/std/so_tiep_dan_nuq.jsp" 55,15  LineMapIndex:29
                                                                          } while (_jspx_th_logic_equal_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                        }
                                                                        if (_jspx_th_logic_equal_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                          return;
                                                                      ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                    // end
                                                                    // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(54,15);to=(55,1)]
                                                                      out.write("\r\n\t");

                                                                    // end
                                                                    // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 56,1-"/kntc/std/so_tiep_dan_nuq.jsp" 56,62  LineMapIndex:30
                                                                      /* ------  logic:equal ------ */
                                                                      org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_1 = new org.apache.struts.taglib.logic.EqualTag();
                                                                      _jspx_th_logic_equal_1.setPageContext(pageContext);
                                                                      _jspx_th_logic_equal_1.setParent(_jspx_th_logic_present_0);
                                                                      _jspx_th_logic_equal_1.setName("tiepDanForm");
                                                                      _jspx_th_logic_equal_1.setProperty("uyQuyen");
                                                                      _jspx_th_logic_equal_1.setValue("2");
                                                                      _jspxTagObjects.push(_jspx_th_logic_equal_1);
                                                                        int _jspx_eval_logic_equal_1 = _jspx_th_logic_equal_1.doStartTag();
                                                                        if (_jspx_eval_logic_equal_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                          do {
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(55,62);to=(60,20)]
                                                                            out.write("\r\n\t\t<fieldset><legend>Thông tin cơ quan, tổ chức ủy quyền</legend>\r\n\t\t<table width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Tên <font color=\"red\">*</font></td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 61,20-"/kntc/std/so_tiep_dan_nuq.jsp" 61,52  LineMapIndex:31
                                                                            /* ------  html:hidden ------ */
                                                                            org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_1 = new org.apache.struts.taglib.html.HiddenTag();
                                                                            _jspx_th_html_hidden_1.setPageContext(pageContext);
                                                                            _jspx_th_html_hidden_1.setParent(_jspx_th_logic_equal_1);
                                                                            _jspx_th_html_hidden_1.setProperty("nuqMa");
                                                                            _jspxTagObjects.push(_jspx_th_html_hidden_1);
                                                                              int _jspx_eval_html_hidden_1 = _jspx_th_html_hidden_1.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 61,20-"/kntc/std/so_tiep_dan_nuq.jsp" 61,52  LineMapIndex:32
                                                                              if (_jspx_th_html_hidden_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(60,52);to=(60,53)]
                                                                            out.write(" ");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 61,53-"/kntc/std/so_tiep_dan_nuq.jsp" 61,101  LineMapIndex:33
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_11 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_11.setPageContext(pageContext);
                                                                            _jspx_th_html_text_11.setParent(_jspx_th_logic_equal_1);
                                                                            _jspx_th_html_text_11.setProperty("nuqTen");
                                                                            _jspx_th_html_text_11.setStyle("width:100%");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_11);
                                                                              int _jspx_eval_html_text_11 = _jspx_th_html_text_11.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 61,53-"/kntc/std/so_tiep_dan_nuq.jsp" 61,113  LineMapIndex:34
                                                                              if (_jspx_th_html_text_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(60,113);to=(62,20)]
                                                                            out.write("</td>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Điện thoại</td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 63,20-"/kntc/std/so_tiep_dan_nuq.jsp" 63,76  LineMapIndex:35
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_12 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_12.setPageContext(pageContext);
                                                                            _jspx_th_html_text_12.setParent(_jspx_th_logic_equal_1);
                                                                            _jspx_th_html_text_12.setProperty("nuqDienThoai");
                                                                            _jspx_th_html_text_12.setStyle("width:100%");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_12);
                                                                              int _jspx_eval_html_text_12 = _jspx_th_html_text_12.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 63,20-"/kntc/std/so_tiep_dan_nuq.jsp" 63,76  LineMapIndex:36
                                                                              if (_jspx_th_html_text_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(62,76);to=(66,20)]
                                                                            out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Địa chỉ</td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 67,20-"/kntc/std/so_tiep_dan_nuq.jsp" 67,73  LineMapIndex:37
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_13 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_13.setPageContext(pageContext);
                                                                            _jspx_th_html_text_13.setParent(_jspx_th_logic_equal_1);
                                                                            _jspx_th_html_text_13.setProperty("nuqDiaChi");
                                                                            _jspx_th_html_text_13.setStyle("width:100%");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_13);
                                                                              int _jspx_eval_html_text_13 = _jspx_th_html_text_13.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 67,20-"/kntc/std/so_tiep_dan_nuq.jsp" 67,73  LineMapIndex:38
                                                                              if (_jspx_th_html_text_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(66,73);to=(68,20)]
                                                                            out.write("</td>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">FAX</td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 69,20-"/kntc/std/so_tiep_dan_nuq.jsp" 69,51  LineMapIndex:39
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_14 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_14.setPageContext(pageContext);
                                                                            _jspx_th_html_text_14.setParent(_jspx_th_logic_equal_1);
                                                                            _jspx_th_html_text_14.setProperty("nuqFAX");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_14);
                                                                              int _jspx_eval_html_text_14 = _jspx_th_html_text_14.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 69,20-"/kntc/std/so_tiep_dan_nuq.jsp" 69,51  LineMapIndex:40
                                                                              if (_jspx_th_html_text_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(68,51);to=(72,20)]
                                                                            out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Mã số thuế <font color=\"red\">*</font></td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 73,20-"/kntc/std/so_tiep_dan_nuq.jsp" 73,70  LineMapIndex:41
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_15 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_15.setPageContext(pageContext);
                                                                            _jspx_th_html_text_15.setParent(_jspx_th_logic_equal_1);
                                                                            _jspx_th_html_text_15.setProperty("nuqCMT");
                                                                            _jspx_th_html_text_15.setStyle("width:100%");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_15);
                                                                              int _jspx_eval_html_text_15 = _jspx_th_html_text_15.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 73,20-"/kntc/std/so_tiep_dan_nuq.jsp" 73,70  LineMapIndex:42
                                                                              if (_jspx_th_html_text_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(72,70);to=(80,20)]
                                                                            out.write("</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t</fieldset>\r\n\t\t<fieldset><legend>Nội dung giấy ủy quyền</legend>\r\n\t\t<table width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Thời gian ủy quyền từ ngày <font color=\"red\">*</font></td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 81,20-"/kntc/std/so_tiep_dan_nuq.jsp" 81,174  LineMapIndex:43
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_16 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_16.setPageContext(pageContext);
                                                                            _jspx_th_html_text_16.setParent(_jspx_th_logic_equal_1);
                                                                            _jspx_th_html_text_16.setProperty("guqTuNgay");
                                                                            _jspx_th_html_text_16.setReadonly(false);
                                                                            _jspx_th_html_text_16.setStyle("width:100%");
                                                                            _jspx_th_html_text_16.setMaxlength("10");
                                                                            _jspx_th_html_text_16.setOnkeypress("return formatDate(event, this)");
                                                                            _jspx_th_html_text_16.setOnblur("isDate(this)");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_16);
                                                                              int _jspx_eval_html_text_16 = _jspx_th_html_text_16.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 81,20-"/kntc/std/so_tiep_dan_nuq.jsp" 81,174  LineMapIndex:44
                                                                              if (_jspx_th_html_text_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(80,174);to=(82,20)]
                                                                            out.write("</td>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Đến ngày <font color=\"red\">*</font></td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 83,20-"/kntc/std/so_tiep_dan_nuq.jsp" 83,155  LineMapIndex:45
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_17 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_17.setPageContext(pageContext);
                                                                            _jspx_th_html_text_17.setParent(_jspx_th_logic_equal_1);
                                                                            _jspx_th_html_text_17.setProperty("guqDenNgay");
                                                                            _jspx_th_html_text_17.setMaxlength("10");
                                                                            _jspx_th_html_text_17.setStyle("width:100%");
                                                                            _jspx_th_html_text_17.setOnkeypress("return formatDate(event, this)");
                                                                            _jspx_th_html_text_17.setOnblur("isDate(this)");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_17);
                                                                              int _jspx_eval_html_text_17 = _jspx_th_html_text_17.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 83,20-"/kntc/std/so_tiep_dan_nuq.jsp" 83,155  LineMapIndex:46
                                                                              if (_jspx_th_html_text_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(82,155);to=(86,8)]
                                                                            out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Người ủy quyền <font color=\"red\">*</font></td>\r\n\t\t\t\t<td>");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 87,8-"/kntc/std/so_tiep_dan_nuq.jsp" 87,61  LineMapIndex:47
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_18 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_18.setPageContext(pageContext);
                                                                            _jspx_th_html_text_18.setParent(_jspx_th_logic_equal_1);
                                                                            _jspx_th_html_text_18.setProperty("guqNuqTen");
                                                                            _jspx_th_html_text_18.setStyle("width:100%");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_18);
                                                                              int _jspx_eval_html_text_18 = _jspx_th_html_text_18.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 87,8-"/kntc/std/so_tiep_dan_nuq.jsp" 87,61  LineMapIndex:48
                                                                              if (_jspx_th_html_text_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(86,61);to=(88,8)]
                                                                            out.write("</td>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Chức danh</td>\r\n\t\t\t\t<td>");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 89,8-"/kntc/std/so_tiep_dan_nuq.jsp" 89,64  LineMapIndex:49
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_19 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_19.setPageContext(pageContext);
                                                                            _jspx_th_html_text_19.setParent(_jspx_th_logic_equal_1);
                                                                            _jspx_th_html_text_19.setProperty("guqNuqChucVu");
                                                                            _jspx_th_html_text_19.setStyle("width:100%");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_19);
                                                                              int _jspx_eval_html_text_19 = _jspx_th_html_text_19.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 89,8-"/kntc/std/so_tiep_dan_nuq.jsp" 89,64  LineMapIndex:50
                                                                              if (_jspx_th_html_text_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(88,64);to=(92,8)]
                                                                            out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Nội dung</td>\r\n\t\t\t\t<td>");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 93,8-"/kntc/std/so_tiep_dan_nuq.jsp" 93,114  LineMapIndex:51
                                                                            /* ------  html:textarea ------ */
                                                                            org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_1 = new org.apache.struts.taglib.html.TextareaTag();
                                                                            _jspx_th_html_textarea_1.setPageContext(pageContext);
                                                                            _jspx_th_html_textarea_1.setParent(_jspx_th_logic_equal_1);
                                                                            _jspx_th_html_textarea_1.setProperty("guqNoiDung");
                                                                            _jspx_th_html_textarea_1.setStyle("width:100%;height:80px;");
                                                                            _jspx_th_html_textarea_1.setOnkeypress("imposeMaxLength(this);");
                                                                            _jspxTagObjects.push(_jspx_th_html_textarea_1);
                                                                              int _jspx_eval_html_textarea_1 = _jspx_th_html_textarea_1.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 93,8-"/kntc/std/so_tiep_dan_nuq.jsp" 93,114  LineMapIndex:52
                                                                              if (_jspx_th_html_textarea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(92,114);to=(94,8)]
                                                                            out.write("</td>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Ngày xác nhận của cơ quan, tổ chức</td>\r\n\t\t\t\t<td>");

                                                                          // end
                                                                          // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_nuq.jsp" 95,8-"/kntc/std/so_tiep_dan_nuq.jsp" 95,132  LineMapIndex:53
                                                                            /* ------  html:text ------ */
                                                                            org.apache.struts.taglib.html.TextTag _jspx_th_html_text_20 = new org.apache.struts.taglib.html.TextTag();
                                                                            _jspx_th_html_text_20.setPageContext(pageContext);
                                                                            _jspx_th_html_text_20.setParent(_jspx_th_logic_equal_1);
                                                                            _jspx_th_html_text_20.setProperty("guqNgayXacNhan");
                                                                            _jspx_th_html_text_20.setStyle("width:100%");
                                                                            _jspx_th_html_text_20.setOnkeypress("return formatDate(event, this)");
                                                                            _jspx_th_html_text_20.setOnblur("isDate(this)");
                                                                            _jspxTagObjects.push(_jspx_th_html_text_20);
                                                                              int _jspx_eval_html_text_20 = _jspx_th_html_text_20.doStartTag();
                                                                            // end
                                                                            // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 95,8-"/kntc/std/so_tiep_dan_nuq.jsp" 95,132  LineMapIndex:54
                                                                              if (_jspx_th_html_text_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                return;
                                                                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                          // end
                                                                          // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(94,132);to=(98,1)]
                                                                            out.write("</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t</fieldset>\r\n\t");

                                                                          // end
                                                                          // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 99,1-"/kntc/std/so_tiep_dan_nuq.jsp" 99,15  LineMapIndex:55
                                                                          } while (_jspx_th_logic_equal_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                        }
                                                                        if (_jspx_th_logic_equal_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                          return;
                                                                      ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                    // end
                                                                    // HTML // begin [file="/kntc/std/so_tiep_dan_nuq.jsp";from=(98,15);to=(99,0)]
                                                                      out.write("\r\n");

                                                                    // end
                                                                    // ##DEBUG## "/kntc/std/so_tiep_dan_nuq.jsp" 100,0-"/kntc/std/so_tiep_dan_nuq.jsp" 100,16  LineMapIndex:56
                                                                    } while (_jspx_th_logic_present_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                  }
                                                                  if (_jspx_th_logic_present_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                    return;
                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
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
                                                          "/kntc/std/so_tiep_dan_nuq.jsp", 
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
                                                          "6", 
                                                          "11", 
                                                          "11", 
                                                          "11", 
                                                          "11", 
                                                          "13", 
                                                          "13", 
                                                          "17", 
                                                          "17", 
                                                          "19", 
                                                          "19", 
                                                          "23", 
                                                          "23", 
                                                          "25", 
                                                          "25", 
                                                          "29", 
                                                          "29", 
                                                          "31", 
                                                          "31", 
                                                          "39", 
                                                          "39", 
                                                          "41", 
                                                          "41", 
                                                          "45", 
                                                          "45", 
                                                          "49", 
                                                          "49", 
                                                          "55", 
                                                          "56", 
                                                          "61", 
                                                          "61", 
                                                          "61", 
                                                          "61", 
                                                          "63", 
                                                          "63", 
                                                          "67", 
                                                          "67", 
                                                          "69", 
                                                          "69", 
                                                          "73", 
                                                          "73", 
                                                          "81", 
                                                          "81", 
                                                          "83", 
                                                          "83", 
                                                          "87", 
                                                          "87", 
                                                          "89", 
                                                          "89", 
                                                          "93", 
                                                          "93", 
                                                          "95", 
                                                          "95", 
                                                          "99", 
                                                          "100", 
                                                          },
                                                          };
                                                        }
