package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _so_5F_tiep_5F_dan_5F_don extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _so_5F_tiep_5F_dan_5F_don( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/kntc/std/so_tiep_dan_don.jsp";

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

                                                                  // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(0,31);to=(1,0)]
                                                                    out.write("\r\n");

                                                                  // end
                                                                  // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(1,59);to=(2,0)]
                                                                    out.write("\r\n");

                                                                  // end
                                                                  // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(2,57);to=(3,0)]
                                                                    out.write("\r\n");

                                                                  // end
                                                                  // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(3,57);to=(4,0)]
                                                                    out.write("\r\n");

                                                                  // end
                                                                  // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 5,0-"/kntc/std/so_tiep_dan_don.jsp" 5,54  LineMapIndex:1
                                                                    _jspx_th_logic_present_0.setPageContext(pageContext);
                                                                    _jspx_th_logic_present_0.setParent(null);
                                                                    _jspx_th_logic_present_0.setName("tiepDanForm");
                                                                    _jspx_th_logic_present_0.setProperty("loaiKNTC");
                                                                    _jspxTagObjects.push(_jspx_th_logic_present_0);
                                                                      int _jspx_eval_logic_present_0 = _jspx_th_logic_present_0.doStartTag();
                                                                      if (_jspx_eval_logic_present_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                        do {
                                                                        // end
                                                                        // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(4,54);to=(5,1)]
                                                                          out.write("\r\n\t");

                                                                        // end
                                                                        // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 6,1-"/kntc/std/so_tiep_dan_don.jsp" 6,63  LineMapIndex:2
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
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(5,63);to=(10,20)]
                                                                                out.write("\r\n\t\t<fieldset><legend>Nội dung đơn</legend>\r\n\t\t<table width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Số đơn</td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 11,20-"/kntc/std/so_tiep_dan_don.jsp" 11,70  LineMapIndex:3
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_0.setPageContext(pageContext);
                                                                                _jspx_th_html_text_0.setParent(_jspx_th_logic_equal_0);
                                                                                _jspx_th_html_text_0.setProperty("soDon");
                                                                                _jspx_th_html_text_0.setStyle("width: 100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_0);
                                                                                  int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 11,20-"/kntc/std/so_tiep_dan_don.jsp" 11,70  LineMapIndex:4
                                                                                  if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(10,70);to=(12,20)]
                                                                                out.write("</td>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Đơn đề ngày</td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 13,20-"/kntc/std/so_tiep_dan_don.jsp" 13,155  LineMapIndex:5
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_1 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_1.setPageContext(pageContext);
                                                                                _jspx_th_html_text_1.setParent(_jspx_th_logic_equal_0);
                                                                                _jspx_th_html_text_1.setProperty("donDeNgay");
                                                                                _jspx_th_html_text_1.setMaxlength("10");
                                                                                _jspx_th_html_text_1.setStyle("width: 100%");
                                                                                _jspx_th_html_text_1.setOnkeypress("return formatDate(event, this)");
                                                                                _jspx_th_html_text_1.setOnblur("isDate(this)");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_1);
                                                                                  int _jspx_eval_html_text_1 = _jspx_th_html_text_1.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 13,20-"/kntc/std/so_tiep_dan_don.jsp" 13,155  LineMapIndex:6
                                                                                  if (_jspx_th_html_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(12,155);to=(16,12)]
                                                                                out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">Họ tên người bị KN <font color=\"red\">*</font></td>\r\n\t\t\t\t<td><!--");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 17,12-"/kntc/std/so_tiep_dan_don.jsp" 17,52  LineMapIndex:7
                                                                                /* ------  html:hidden ------ */
                                                                                org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                _jspx_th_html_hidden_0.setPageContext(pageContext);
                                                                                _jspx_th_html_hidden_0.setParent(_jspx_th_logic_equal_0);
                                                                                _jspx_th_html_hidden_0.setProperty("canBoBiKNTCMa");
                                                                                _jspxTagObjects.push(_jspx_th_html_hidden_0);
                                                                                  int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 17,12-"/kntc/std/so_tiep_dan_don.jsp" 17,52  LineMapIndex:8
                                                                                  if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(16,52);to=(16,57)]
                                                                                out.write(" --> ");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 17,57-"/kntc/std/so_tiep_dan_don.jsp" 17,116  LineMapIndex:9
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_2.setPageContext(pageContext);
                                                                                _jspx_th_html_text_2.setParent(_jspx_th_logic_equal_0);
                                                                                _jspx_th_html_text_2.setProperty("canBoBiKNTCTen");
                                                                                _jspx_th_html_text_2.setStyle("width: 100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_2);
                                                                                  int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 17,57-"/kntc/std/so_tiep_dan_don.jsp" 17,116  LineMapIndex:10
                                                                                  if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(16,116);to=(18,8)]
                                                                                out.write("</td>\r\n\t\t\t\t<td style=\"text-align: right;\">Địa chỉ</td>\r\n\t\t\t\t<td>");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 19,8-"/kntc/std/so_tiep_dan_don.jsp" 19,70  LineMapIndex:11
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_3 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_3.setPageContext(pageContext);
                                                                                _jspx_th_html_text_3.setParent(_jspx_th_logic_equal_0);
                                                                                _jspx_th_html_text_3.setProperty("canBoBiKNTCDiaChi");
                                                                                _jspx_th_html_text_3.setStyle("width: 100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_3);
                                                                                  int _jspx_eval_html_text_3 = _jspx_th_html_text_3.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 19,8-"/kntc/std/so_tiep_dan_don.jsp" 19,70  LineMapIndex:12
                                                                                  if (_jspx_th_html_text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(18,70);to=(22,8)]
                                                                                out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">Chức vụ</td>\r\n\t\t\t\t<td>");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 23,8-"/kntc/std/so_tiep_dan_don.jsp" 23,70  LineMapIndex:13
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_4 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_4.setPageContext(pageContext);
                                                                                _jspx_th_html_text_4.setParent(_jspx_th_logic_equal_0);
                                                                                _jspx_th_html_text_4.setProperty("canBoBiKNTCChucVu");
                                                                                _jspx_th_html_text_4.setStyle("width: 100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_4);
                                                                                  int _jspx_eval_html_text_4 = _jspx_th_html_text_4.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 23,8-"/kntc/std/so_tiep_dan_don.jsp" 23,70  LineMapIndex:14
                                                                                  if (_jspx_th_html_text_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(22,70);to=(24,8)]
                                                                                out.write("</td>\r\n\t\t\t\t<td style=\"text-align: right;\">Nơi công tác</td>\r\n\t\t\t\t<td>");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 25,8-"/kntc/std/so_tiep_dan_don.jsp" 25,74  LineMapIndex:15
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_5 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_5.setPageContext(pageContext);
                                                                                _jspx_th_html_text_5.setParent(_jspx_th_logic_equal_0);
                                                                                _jspx_th_html_text_5.setProperty("canBoBiKNTCNoiCongTac");
                                                                                _jspx_th_html_text_5.setStyle("width: 100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_5);
                                                                                  int _jspx_eval_html_text_5 = _jspx_th_html_text_5.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 25,8-"/kntc/std/so_tiep_dan_don.jsp" 25,74  LineMapIndex:16
                                                                                  if (_jspx_th_html_text_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(24,74);to=(28,20)]
                                                                                out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">Nội dung tóm tắt đơn <font color=\"red\">*</font></td>\r\n\t\t\t\t<td colspan=\"3\">");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 29,20-"/kntc/std/so_tiep_dan_don.jsp" 29,126  LineMapIndex:17
                                                                                /* ------  html:textarea ------ */
                                                                                org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_0 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                _jspx_th_html_textarea_0.setPageContext(pageContext);
                                                                                _jspx_th_html_textarea_0.setParent(_jspx_th_logic_equal_0);
                                                                                _jspx_th_html_textarea_0.setProperty("noiDungDon");
                                                                                _jspx_th_html_textarea_0.setOnkeypress("imposeMaxLength(this);");
                                                                                _jspx_th_html_textarea_0.setStyle("width:100%;height:80px;");
                                                                                _jspxTagObjects.push(_jspx_th_html_textarea_0);
                                                                                  int _jspx_eval_html_textarea_0 = _jspx_th_html_textarea_0.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 29,20-"/kntc/std/so_tiep_dan_don.jsp" 29,126  LineMapIndex:18
                                                                                  if (_jspx_th_html_textarea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(28,126);to=(59,1)]
                                                                                out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">File đơn</td>\r\n\t\t\t\t<td colspan=\"3\"><A href=\"#\" onclick=\"openUploadFile();\">File \"đơn\" đính kèm</A></td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t</fieldset>\r\n\t\t<fieldset><!-- Tai lieu kem theo --> <legend>Tài liệu, chứng cứ kèm theo</legend>\r\n\t\t<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\" id=\"example\">\r\n\t\t\t<thead>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<th width=\"50%\">Tên tài liệu</th>\r\n\t\t\t\t\t<th width=\"20%\">Số trang</th>\r\n\t\t\t\t\t<th width=\"30%\">Tình trạng</th>\r\n\t\t\t\t</tr>\r\n\t\t\t</thead>\r\n\t\t\t<tbody>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td width=\"50%\"><input type=\"text\" name=\"tenTL\" id=\"tenTL0\" style=\"width: 100%\"></td>\r\n\t\t\t\t\t<td width=\"20%\"><input type=\"text\" name=\"soTrangTL\" id=\"soTrangTL0\" style=\"width: 100%\" maxlength=\"3\" onblur=\"isNumber(this,'i');\" /></td>\r\n\t\t\t\t\t<td width=\"30%\"><select id=\"tinhTrang0\">\r\n\t\t\t\t\t\t<option value=\"Bản chính\">Bản chính</option>\r\n\t\t\t\t\t\t<option value=\"Bản sao\">Bản sao</option>\r\n\t\t\t\t\t\t<option value=\"Bản sao có công chứng\">Bản sao có công chứng</option>\r\n\t\t\t\t\t</select></td>\r\n\t\t\t\t</tr>\r\n\t\t\t</tbody>\r\n\t\t</table>\r\n\t\t<div style=\"text-align: right; width: 100%; font-size: 8pt; font-weight: bold;\"><INPUT type=\"button\" class=\"button\" name=\"btnAdd\" onclick=\"fnClickAddRow();\" value=\"Thêm\"> <INPUT type=\"button\" class=\"button\" name=\"btnXoa\" id=\"deleteRow\" value=\"Xóa\"></div>\r\n\t\t</fieldset>\r\n\t");

                                                                              // end
                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 60,1-"/kntc/std/so_tiep_dan_don.jsp" 60,15  LineMapIndex:19
                                                                              } while (_jspx_th_logic_equal_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                            }
                                                                            if (_jspx_th_logic_equal_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                              return;
                                                                          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                        // end
                                                                        // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(59,15);to=(61,1)]
                                                                          out.write("\r\n\t<!--Don To Cao-->\r\n\t");

                                                                        // end
                                                                        // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 62,1-"/kntc/std/so_tiep_dan_don.jsp" 62,63  LineMapIndex:20
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
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(61,63);to=(66,20)]
                                                                                out.write("\r\n\t\t<fieldset><legend>Nội dung đơn</legend>\r\n\t\t<table width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Số đơn</td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 67,20-"/kntc/std/so_tiep_dan_don.jsp" 67,69  LineMapIndex:21
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_6 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_6.setPageContext(pageContext);
                                                                                _jspx_th_html_text_6.setParent(_jspx_th_logic_equal_1);
                                                                                _jspx_th_html_text_6.setProperty("soDon");
                                                                                _jspx_th_html_text_6.setStyle("width:100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_6);
                                                                                  int _jspx_eval_html_text_6 = _jspx_th_html_text_6.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 67,20-"/kntc/std/so_tiep_dan_don.jsp" 67,69  LineMapIndex:22
                                                                                  if (_jspx_th_html_text_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(66,69);to=(68,20)]
                                                                                out.write("</td>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Đơn đề ngày</td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 69,20-"/kntc/std/so_tiep_dan_don.jsp" 69,155  LineMapIndex:23
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_7 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_7.setPageContext(pageContext);
                                                                                _jspx_th_html_text_7.setParent(_jspx_th_logic_equal_1);
                                                                                _jspx_th_html_text_7.setProperty("donDeNgay");
                                                                                _jspx_th_html_text_7.setMaxlength("10");
                                                                                _jspx_th_html_text_7.setStyle("width: 100%");
                                                                                _jspx_th_html_text_7.setOnkeypress("return formatDate(event, this)");
                                                                                _jspx_th_html_text_7.setOnblur("isDate(this)");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_7);
                                                                                  int _jspx_eval_html_text_7 = _jspx_th_html_text_7.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 69,20-"/kntc/std/so_tiep_dan_don.jsp" 69,155  LineMapIndex:24
                                                                                  if (_jspx_th_html_text_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(68,155);to=(72,8)]
                                                                                out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">Họ tên người bị TC <font color=\"red\">*</font></td>\r\n\t\t\t\t<td>");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 73,8-"/kntc/std/so_tiep_dan_don.jsp" 73,66  LineMapIndex:25
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_8 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_8.setPageContext(pageContext);
                                                                                _jspx_th_html_text_8.setParent(_jspx_th_logic_equal_1);
                                                                                _jspx_th_html_text_8.setProperty("canBoBiKNTCTen");
                                                                                _jspx_th_html_text_8.setStyle("width:100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_8);
                                                                                  int _jspx_eval_html_text_8 = _jspx_th_html_text_8.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 73,8-"/kntc/std/so_tiep_dan_don.jsp" 73,66  LineMapIndex:26
                                                                                  if (_jspx_th_html_text_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(72,66);to=(72,71)]
                                                                                out.write(" <!--");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 73,71-"/kntc/std/so_tiep_dan_don.jsp" 73,130  LineMapIndex:27
                                                                                /* ------  html:hidden ------ */
                                                                                org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_1 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                _jspx_th_html_hidden_1.setPageContext(pageContext);
                                                                                _jspx_th_html_hidden_1.setParent(_jspx_th_logic_equal_1);
                                                                                _jspx_th_html_hidden_1.setProperty("canBoBiKNTCMa");
                                                                                _jspx_th_html_hidden_1.setStyle("width: 100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_hidden_1);
                                                                                  int _jspx_eval_html_hidden_1 = _jspx_th_html_hidden_1.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 73,71-"/kntc/std/so_tiep_dan_don.jsp" 73,130  LineMapIndex:28
                                                                                  if (_jspx_th_html_hidden_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(72,130);to=(75,8)]
                                                                                out.write(" \t\t\t\r\n\t\t\t<input type=\"button\" class=\"button\" name=\"btnCb\" style=\"width: 10%\" value=\"...\" onclick=\"showLovCanbo()\">--></td>\r\n\t\t\t\t<td style=\"text-align: right;\">Địa chỉ</td>\r\n\t\t\t\t<td>");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 76,8-"/kntc/std/so_tiep_dan_don.jsp" 76,69  LineMapIndex:29
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_9 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_9.setPageContext(pageContext);
                                                                                _jspx_th_html_text_9.setParent(_jspx_th_logic_equal_1);
                                                                                _jspx_th_html_text_9.setProperty("canBoBiKNTCDiaChi");
                                                                                _jspx_th_html_text_9.setStyle("width:100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_9);
                                                                                  int _jspx_eval_html_text_9 = _jspx_th_html_text_9.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 76,8-"/kntc/std/so_tiep_dan_don.jsp" 76,69  LineMapIndex:30
                                                                                  if (_jspx_th_html_text_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(75,69);to=(79,8)]
                                                                                out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">Chức vụ</td>\r\n\t\t\t\t<td>");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 80,8-"/kntc/std/so_tiep_dan_don.jsp" 80,69  LineMapIndex:31
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_10 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_10.setPageContext(pageContext);
                                                                                _jspx_th_html_text_10.setParent(_jspx_th_logic_equal_1);
                                                                                _jspx_th_html_text_10.setProperty("canBoBiKNTCChucVu");
                                                                                _jspx_th_html_text_10.setStyle("width:100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_10);
                                                                                  int _jspx_eval_html_text_10 = _jspx_th_html_text_10.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 80,8-"/kntc/std/so_tiep_dan_don.jsp" 80,69  LineMapIndex:32
                                                                                  if (_jspx_th_html_text_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(79,69);to=(81,8)]
                                                                                out.write("</td>\r\n\t\t\t\t<td style=\"text-align: right;\">Nơi công tác</td>\r\n\t\t\t\t<td>");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 82,8-"/kntc/std/so_tiep_dan_don.jsp" 82,73  LineMapIndex:33
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_11 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_11.setPageContext(pageContext);
                                                                                _jspx_th_html_text_11.setParent(_jspx_th_logic_equal_1);
                                                                                _jspx_th_html_text_11.setProperty("canBoBiKNTCNoiCongTac");
                                                                                _jspx_th_html_text_11.setStyle("width:100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_11);
                                                                                  int _jspx_eval_html_text_11 = _jspx_th_html_text_11.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 82,8-"/kntc/std/so_tiep_dan_don.jsp" 82,73  LineMapIndex:34
                                                                                  if (_jspx_th_html_text_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(81,73);to=(85,20)]
                                                                                out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">Nội dung tóm tắt đơn <font color=\"red\">*</font></td>\r\n\t\t\t\t<td colspan=\"3\">");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 86,20-"/kntc/std/so_tiep_dan_don.jsp" 86,127  LineMapIndex:35
                                                                                /* ------  html:textarea ------ */
                                                                                org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_1 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                _jspx_th_html_textarea_1.setPageContext(pageContext);
                                                                                _jspx_th_html_textarea_1.setParent(_jspx_th_logic_equal_1);
                                                                                _jspx_th_html_textarea_1.setProperty("noiDungDon");
                                                                                _jspx_th_html_textarea_1.setOnkeypress("imposeMaxLength(this);");
                                                                                _jspx_th_html_textarea_1.setStyle("width:100%;height:80px;");
                                                                                _jspxTagObjects.push(_jspx_th_html_textarea_1);
                                                                                  int _jspx_eval_html_textarea_1 = _jspx_th_html_textarea_1.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 86,20-"/kntc/std/so_tiep_dan_don.jsp" 86,127  LineMapIndex:36
                                                                                  if (_jspx_th_html_textarea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(85,127);to=(116,1)]
                                                                                out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">File đơn</td>\r\n\t\t\t\t<td colspan=\"3\"><A href=\"#\" onclick=\"openUploadFile();\">Chọn file </A></td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t</fieldset>\r\n\t\t<fieldset><!-- Tai lieu kem theo --> <legend>Tài liệu, chứng cứ kèm theo</legend>\r\n\t\t<table width=\"50%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\" id=\"example\">\r\n\t\t\t<thead>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<th>Tên tài liệu</th>\r\n\t\t\t\t\t<th>Số trang</th>\r\n\t\t\t\t\t<th>Tình trạng</th>\r\n\t\t\t\t</tr>\r\n\t\t\t</thead>\r\n\t\t\t<tbody>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td width=\"50%\"><input type=\"text\" name=\"tenTL\" id=\"tenTL0\" style=\"width: 100%\"></td>\r\n\t\t\t\t\t<td width=\"20%\"><input type=\"text\" name=\"soTrangTL\" id=\"soTrangTL0\" style=\"width: 100%\" maxlength=\"3\" onkeypress=\"return nokeypress(event);\" onblur=\"isNumber(this,'i');\" /></td>\r\n\t\t\t\t\t<td width=\"30%\"><!--<input type=\"text\" name=\"tinhTrang\" id=\"tinhTrang0\" style=\"width: 100%\"  />--> <select id=\"tinhTrang0\">\r\n\t\t\t\t\t\t<option value=\"Bản chính\">Bản chính</option>\r\n\t\t\t\t\t\t<option value=\"Bản sao\">Bản sao</option>\r\n\t\t\t\t\t\t<option value=\"Bản sao có công chứng\">Bản sao có công chứng</option>\r\n\t\t\t\t\t</select></td>\r\n\t\t\t\t</tr>\r\n\t\t\t</tbody>\r\n\t\t</table>\r\n\t\t<div style=\"text-align: right; width: 100%; font-size: 8pt; font-weight: bold;\"><INPUT type=\"button\" class=\"button\" name=\"btnAdd\" onclick=\"fnClickAddRow();\" value=\"Thêm\"> <INPUT type=\"button\" class=\"button\" name=\"btnXoa\" id=\"deleteRow\" value=\"Xóa\"></div>\r\n\t\t</fieldset>\r\n\t");

                                                                              // end
                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 117,1-"/kntc/std/so_tiep_dan_don.jsp" 117,15  LineMapIndex:37
                                                                              } while (_jspx_th_logic_equal_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                            }
                                                                            if (_jspx_th_logic_equal_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                              return;
                                                                          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                        // end
                                                                        // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(116,15);to=(118,1)]
                                                                          out.write("\r\n\t<!--Don Khac-->\r\n\t");

                                                                        // end
                                                                        // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 119,1-"/kntc/std/so_tiep_dan_don.jsp" 119,63  LineMapIndex:38
                                                                          /* ------  logic:equal ------ */
                                                                          org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_2 = new org.apache.struts.taglib.logic.EqualTag();
                                                                          _jspx_th_logic_equal_2.setPageContext(pageContext);
                                                                          _jspx_th_logic_equal_2.setParent(_jspx_th_logic_present_0);
                                                                          _jspx_th_logic_equal_2.setName("tiepDanForm");
                                                                          _jspx_th_logic_equal_2.setProperty("loaiKNTC");
                                                                          _jspx_th_logic_equal_2.setValue("3");
                                                                          _jspxTagObjects.push(_jspx_th_logic_equal_2);
                                                                            int _jspx_eval_logic_equal_2 = _jspx_th_logic_equal_2.doStartTag();
                                                                            if (_jspx_eval_logic_equal_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                              do {
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(118,63);to=(123,20)]
                                                                                out.write("\r\n\t\t<fieldset><legend>Nội dung đơn</legend>\r\n\t\t<table width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Số đơn</td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 124,20-"/kntc/std/so_tiep_dan_don.jsp" 124,69  LineMapIndex:39
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_12 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_12.setPageContext(pageContext);
                                                                                _jspx_th_html_text_12.setParent(_jspx_th_logic_equal_2);
                                                                                _jspx_th_html_text_12.setProperty("soDon");
                                                                                _jspx_th_html_text_12.setStyle("width:100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_12);
                                                                                  int _jspx_eval_html_text_12 = _jspx_th_html_text_12.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 124,20-"/kntc/std/so_tiep_dan_don.jsp" 124,69  LineMapIndex:40
                                                                                  if (_jspx_th_html_text_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(123,69);to=(125,20)]
                                                                                out.write("</td>\r\n\t\t\t\t<td width=\"15%\" style=\"text-align: right;\">Đơn đề ngày</td>\r\n\t\t\t\t<td width=\"35%\">");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 126,20-"/kntc/std/so_tiep_dan_don.jsp" 126,155  LineMapIndex:41
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_13 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_13.setPageContext(pageContext);
                                                                                _jspx_th_html_text_13.setParent(_jspx_th_logic_equal_2);
                                                                                _jspx_th_html_text_13.setProperty("donDeNgay");
                                                                                _jspx_th_html_text_13.setMaxlength("10");
                                                                                _jspx_th_html_text_13.setStyle("width: 100%");
                                                                                _jspx_th_html_text_13.setOnkeypress("return formatDate(event, this)");
                                                                                _jspx_th_html_text_13.setOnblur("isDate(this)");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_13);
                                                                                  int _jspx_eval_html_text_13 = _jspx_th_html_text_13.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 126,20-"/kntc/std/so_tiep_dan_don.jsp" 126,155  LineMapIndex:42
                                                                                  if (_jspx_th_html_text_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(125,155);to=(129,8)]
                                                                                out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">Họ tên người bị KNTC <font color=\"red\">*</font></td>\r\n\t\t\t\t<td>");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 130,8-"/kntc/std/so_tiep_dan_don.jsp" 130,66  LineMapIndex:43
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_14 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_14.setPageContext(pageContext);
                                                                                _jspx_th_html_text_14.setParent(_jspx_th_logic_equal_2);
                                                                                _jspx_th_html_text_14.setProperty("canBoBiKNTCTen");
                                                                                _jspx_th_html_text_14.setStyle("width:100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_14);
                                                                                  int _jspx_eval_html_text_14 = _jspx_th_html_text_14.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 130,8-"/kntc/std/so_tiep_dan_don.jsp" 130,66  LineMapIndex:44
                                                                                  if (_jspx_th_html_text_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(129,66);to=(134,8)]
                                                                                out.write(" <!-- html:hidden property=\"canBoBiKNTCMa\" />\r\n\t\t\t\t\r\n\t\t\t\t<input type=\"button\" class=\"button\" name=\"btnCb\" style=\"width: 10%\" value=\"...\" onclick=\"showLovCanbo()\">\r\n\t\t\t\t --></td>\r\n\t\t\t\t<td style=\"text-align: right;\">Địa chỉ</td>\r\n\t\t\t\t<td>");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 135,8-"/kntc/std/so_tiep_dan_don.jsp" 135,69  LineMapIndex:45
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_15 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_15.setPageContext(pageContext);
                                                                                _jspx_th_html_text_15.setParent(_jspx_th_logic_equal_2);
                                                                                _jspx_th_html_text_15.setProperty("canBoBiKNTCDiaChi");
                                                                                _jspx_th_html_text_15.setStyle("width:100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_15);
                                                                                  int _jspx_eval_html_text_15 = _jspx_th_html_text_15.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 135,8-"/kntc/std/so_tiep_dan_don.jsp" 135,69  LineMapIndex:46
                                                                                  if (_jspx_th_html_text_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(134,69);to=(138,8)]
                                                                                out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">Chức vụ</td>\r\n\t\t\t\t<td>");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 139,8-"/kntc/std/so_tiep_dan_don.jsp" 139,69  LineMapIndex:47
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_16 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_16.setPageContext(pageContext);
                                                                                _jspx_th_html_text_16.setParent(_jspx_th_logic_equal_2);
                                                                                _jspx_th_html_text_16.setProperty("canBoBiKNTCChucVu");
                                                                                _jspx_th_html_text_16.setStyle("width:100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_16);
                                                                                  int _jspx_eval_html_text_16 = _jspx_th_html_text_16.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 139,8-"/kntc/std/so_tiep_dan_don.jsp" 139,69  LineMapIndex:48
                                                                                  if (_jspx_th_html_text_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(138,69);to=(140,8)]
                                                                                out.write("</td>\r\n\t\t\t\t<td style=\"text-align: right;\">Nơi công tác</td>\r\n\t\t\t\t<td>");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 141,8-"/kntc/std/so_tiep_dan_don.jsp" 141,73  LineMapIndex:49
                                                                                /* ------  html:text ------ */
                                                                                org.apache.struts.taglib.html.TextTag _jspx_th_html_text_17 = new org.apache.struts.taglib.html.TextTag();
                                                                                _jspx_th_html_text_17.setPageContext(pageContext);
                                                                                _jspx_th_html_text_17.setParent(_jspx_th_logic_equal_2);
                                                                                _jspx_th_html_text_17.setProperty("canBoBiKNTCNoiCongTac");
                                                                                _jspx_th_html_text_17.setStyle("width:100%");
                                                                                _jspxTagObjects.push(_jspx_th_html_text_17);
                                                                                  int _jspx_eval_html_text_17 = _jspx_th_html_text_17.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 141,8-"/kntc/std/so_tiep_dan_don.jsp" 141,73  LineMapIndex:50
                                                                                  if (_jspx_th_html_text_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(140,73);to=(144,20)]
                                                                                out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">Nội dung tóm tắt đơn <font color=\"red\">*</font></td>\r\n\t\t\t\t<td colspan=\"3\">");

                                                                              // end
                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 145,20-"/kntc/std/so_tiep_dan_don.jsp" 145,127  LineMapIndex:51
                                                                                /* ------  html:textarea ------ */
                                                                                org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_2 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                _jspx_th_html_textarea_2.setPageContext(pageContext);
                                                                                _jspx_th_html_textarea_2.setParent(_jspx_th_logic_equal_2);
                                                                                _jspx_th_html_textarea_2.setProperty("noiDungDon");
                                                                                _jspx_th_html_textarea_2.setOnkeypress("imposeMaxLength(this);");
                                                                                _jspx_th_html_textarea_2.setStyle("width:100%;height:80px;");
                                                                                _jspxTagObjects.push(_jspx_th_html_textarea_2);
                                                                                  int _jspx_eval_html_textarea_2 = _jspx_th_html_textarea_2.doStartTag();
                                                                                // end
                                                                                // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 145,20-"/kntc/std/so_tiep_dan_don.jsp" 145,127  LineMapIndex:52
                                                                                  if (_jspx_th_html_textarea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                    return;
                                                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                              // end
                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(144,127);to=(175,1)]
                                                                                out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td style=\"text-align: right;\">File đơn</td>\r\n\t\t\t\t<td colspan=\"3\"><A href=\"#\" onclick=\"openUploadFile();\">Chọn file </A></td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t</fieldset>\r\n\t\t<fieldset><!-- Tai lieu kem theo --> <legend>Tài liệu, chứng cứ kèm theo</legend>\r\n\t\t<table width=\"50%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\" id=\"example\">\r\n\t\t\t<thead>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<th>Tên tài liệu</th>\r\n\t\t\t\t\t<th>Số trang</th>\r\n\t\t\t\t\t<th>Tình trạng</th>\r\n\t\t\t\t</tr>\r\n\t\t\t</thead>\r\n\t\t\t<tbody>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td width=\"60%\"><input type=\"text\" name=\"tenTL\" id=\"tenTL0\" style=\"width: 100%\"></td>\r\n\t\t\t\t\t<td width=\"20%\"><input type=\"text\" name=\"soTrangTL\" id=\"soTrangTL0\" onkeypress=\"return nokeypress(event);\" style=\"width: 100%\" maxlength=\"3\" onblur=\"isNumber(this,'i');\" /></td>\r\n\t\t\t\t\t<td width=\"30%\"><select id=\"tinhTrang0\">\r\n\t\t\t\t\t\t<option value=\"Bản chính\">Bản chính</option>\r\n\t\t\t\t\t\t<option value=\"Bản sao\">Bản sao</option>\r\n\t\t\t\t\t\t<option value=\"Bản sao có công chứng\">Bản sao có công chứng</option>\r\n\t\t\t\t\t</select></td>\r\n\t\t\t\t</tr>\r\n\t\t\t</tbody>\r\n\t\t</table>\r\n\t\t<div style=\"text-align: right; width: 100%; font-size: 8pt; font-weight: bold;\"><INPUT type=\"button\" class=\"button\" name=\"btnAdd\" onclick=\"fnClickAddRow();\" value=\"Thêm\"> <INPUT type=\"button\" class=\"button\" name=\"btnXoa\" id=\"deleteRow\" value=\"Xóa\"></div>\r\n\t\t</fieldset>\r\n\t");

                                                                              // end
                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 176,1-"/kntc/std/so_tiep_dan_don.jsp" 176,15  LineMapIndex:53
                                                                              } while (_jspx_th_logic_equal_2.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                            }
                                                                            if (_jspx_th_logic_equal_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                              return;
                                                                          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                        // end
                                                                        // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(175,15);to=(179,20)]
                                                                          out.write("\r\n\t<fieldset><!-- Ghi chu --> <legend>Ghi chú</legend>\r\n\t<table width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"100%\">");

                                                                        // end
                                                                        // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 180,20-"/kntc/std/so_tiep_dan_don.jsp" 180,122  LineMapIndex:54
                                                                          /* ------  html:textarea ------ */
                                                                          org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_3 = new org.apache.struts.taglib.html.TextareaTag();
                                                                          _jspx_th_html_textarea_3.setPageContext(pageContext);
                                                                          _jspx_th_html_textarea_3.setParent(_jspx_th_logic_present_0);
                                                                          _jspx_th_html_textarea_3.setProperty("ghiChu");
                                                                          _jspx_th_html_textarea_3.setOnkeypress("imposeMaxLength(this);");
                                                                          _jspx_th_html_textarea_3.setStyle("width:100%;height:80px");
                                                                          _jspxTagObjects.push(_jspx_th_html_textarea_3);
                                                                            int _jspx_eval_html_textarea_3 = _jspx_th_html_textarea_3.doStartTag();
                                                                          // end
                                                                          // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 180,20-"/kntc/std/so_tiep_dan_don.jsp" 180,122  LineMapIndex:55
                                                                            if (_jspx_th_html_textarea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                              return;
                                                                          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                        // end
                                                                        // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(179,122);to=(185,33)]
                                                                          out.write("</td>\r\n\t\t</tr>\r\n\t</Table>\r\n\t</fieldset>\r\n\t<table width=\"90%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"15%\">");

                                                                        // end
                                                                        // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 186,33-"/kntc/std/so_tiep_dan_don.jsp" 186,113  LineMapIndex:56
                                                                          /* ------  html:checkbox ------ */
                                                                          org.apache.struts.taglib.html.CheckboxTag _jspx_th_html_checkbox_0 = new org.apache.struts.taglib.html.CheckboxTag();
                                                                          _jspx_th_html_checkbox_0.setPageContext(pageContext);
                                                                          _jspx_th_html_checkbox_0.setParent(_jspx_th_logic_present_0);
                                                                          _jspx_th_html_checkbox_0.setProperty("boSungTaiLieu");
                                                                          _jspx_th_html_checkbox_0.setValue("1");
                                                                          _jspx_th_html_checkbox_0.setOnclick("changePhieuHen();");
                                                                          _jspxTagObjects.push(_jspx_th_html_checkbox_0);
                                                                            int _jspx_eval_html_checkbox_0 = _jspx_th_html_checkbox_0.doStartTag();
                                                                          // end
                                                                          // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 186,33-"/kntc/std/so_tiep_dan_don.jsp" 186,113  LineMapIndex:57
                                                                            if (_jspx_th_html_checkbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                              return;
                                                                          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                        // end
                                                                        // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(185,113);to=(193,7)]
                                                                          out.write("</td>\r\n\t\t\t<td width=\"40%\">Yêu cầu cung cấp bổ sung tài liệu (phiếu hẹn)</td>\r\n\t\t\t<td width=\"45%\">\r\n\t\t\t<div id=\"divLapPhieu\"><input type=\"button\" name=\"lapPhieu\" class=\"button\" value=\"Lập phiếu hẹn\" onclick=\"lapPhieuHen();\" /></div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Thời điểm lập giấy biên nhận</td>\r\n\t\t\t<td>");

                                                                        // end
                                                                        // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan_don.jsp" 194,7-"/kntc/std/so_tiep_dan_don.jsp" 194,130  LineMapIndex:58
                                                                          /* ------  html:text ------ */
                                                                          org.apache.struts.taglib.html.TextTag _jspx_th_html_text_18 = new org.apache.struts.taglib.html.TextTag();
                                                                          _jspx_th_html_text_18.setPageContext(pageContext);
                                                                          _jspx_th_html_text_18.setParent(_jspx_th_logic_present_0);
                                                                          _jspx_th_html_text_18.setProperty("thoiDiemInGbn");
                                                                          _jspx_th_html_text_18.setStyle("width:100%");
                                                                          _jspx_th_html_text_18.setOnblur("isTime(this)");
                                                                          _jspx_th_html_text_18.setOnkeypress("return formatTime(event, this)");
                                                                          _jspxTagObjects.push(_jspx_th_html_text_18);
                                                                            int _jspx_eval_html_text_18 = _jspx_th_html_text_18.doStartTag();
                                                                          // end
                                                                          // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 194,7-"/kntc/std/so_tiep_dan_don.jsp" 194,130  LineMapIndex:59
                                                                            if (_jspx_th_html_text_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                              return;
                                                                          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                        // end
                                                                        // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(193,130);to=(200,15)]
                                                                          out.write("</td>\r\n\t\t\t<td><input type=\"button\" class=\"button\" name=\"inGiayBienNhan\" value=\"In giấy biên nhận\" onclick=\"giayBienNhan();\" /></td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<script language=\"JavaScript\">\r\nfunction openUploadFile(){\r\n\tvar view='';\r\n\tvar method = '");

                                                                        // end
                                                                        // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 201,18-"/kntc/std/so_tiep_dan_don.jsp" 201,48  LineMapIndex:60
                                                                          out.print(request.getParameter("method"));
                                                                        // end
                                                                        // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(200,50);to=(202,10)]
                                                                          out.write("';\r\n\tif(method == 'view') view = 'view';\r\n\tvar r = '");

                                                                        // end
                                                                        // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 203,13-"/kntc/std/so_tiep_dan_don.jsp" 203,38  LineMapIndex:61
                                                                          out.print(request.getParameter("r"));
                                                                        // end
                                                                        // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(202,40);to=(256,0)]
                                                                          out.write("';\r\n\tif(r == 'rol') view = 'view';\r\n\t\r\n\tvar maHS = document.forms[0].maHoSo.value;\r\n    if(maHS!=null && maHS!='' && maHS!='null')\r\n\t\topenWindow(\"UploadAction.do?parentId=\"+maHS+\"&nv=KNTC/STD&view=\"+view);\r\n\telse\r\n\t\talert(\"Bạn phải lưu hồ sơ trước khi gửi file đính kèm!\");\t\t\r\n}\r\nfunction giayBienNhan(){\r\n\tif(validTTChungTab()){\r\n\t\tvar arTL='';\r\n\t\t\tfor(i=0;i<oTable.fnGetData().length+1;i++){\r\n\t\t\t\tif(isExist('tenTL'+i)){\r\n\t\t\t\t\tif(!isEmpty(document.getElementById('tenTL'+i).value)){\r\n\t\t\t\t\t\tarTL +=$('#tenTL'+i).val()+'###'+$('#soTrangTL'+i).val()+'###'+$('#tinhTrang'+i).val()+'@@';\t\t\t\t\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t}\t\r\n\t\tdocument.forms[0].arrTenTl.value=arTL;\r\n\t\tdocument.forms[0].loaiKNTC.disabled = false;\r\n\t\tdocument.forms[0].ngayTiep.disabled = false;\r\n\t\tdocument.forms[0].action=\"kntc_tiep_dan.do?method=inGbn\";\r\n\t\tdocument.forms[0].submit();\r\n\t\tdocument.forms[0].loaiKNTC.disabled = true;\r\n\t\tdocument.forms[0].ngayTiep.disabled = true;\r\n\t}        \r\n}\r\nfunction lapPhieuHen(){\r\n\tvar maHS = document.forms[0].maHoSo.value;\r\n  \t//alert(maHS);\r\n   \tvar nguoinhan = document.forms[0].condanTen.value;\r\n   \tvar cdDiaChi = document.forms[0].congdanDiaChi.value;\r\n  \tif(maHS!=null && maHS!='' && maHS!='null')\r\n\t\topenWindow(encodeURI(\"kntc_phieu_hen.do?method=show&id=\"+maHS+\"&nguoinhan=\"+nguoinhan+\"&diachi=\"+cdDiaChi),800,700,false);\r\n\telse\r\n\t\talert(\"Chưa có thông tin về hồ sơ!\");  \r\n}\r\nfunction showLovCanbo(index)\r\n{\r\n\ttenCB = document.forms[0].canBoBiKNTCTen.value;\r\n\tif(tenCB!=null && tenCB!='' && tenCB!='null')\r\n\t\topenWindow(\"danhmuc_canbo.do?method=lov&txtSearch=\"+normalizeString4SQL(tenCB));\r\n\telse\r\n\t\topenWindow(\"danhmuc_canbo.do?method=lov\");\r\n}\r\nfunction setData(values){\r\n\tvar str_val= values.split(\"@@\");  \t\r\n \tdocument.forms[0].canBoBiKNTCMa.value= str_val[0];\r\n \tdocument.forms[0].canBoBiKNTCTen.value= str_val[1];\t\r\n \tdocument.forms[0].canBoBiKNTCChucVu.value= str_val[2];\r\n \tdocument.forms[0].canBoBiKNTCNoiCongTac.value= str_val[4];\t\r\n}\r\n</script>\r\n");

                                                                        // end
                                                                        // ##DEBUG## "/kntc/std/so_tiep_dan_don.jsp" 257,0-"/kntc/std/so_tiep_dan_don.jsp" 257,16  LineMapIndex:62
                                                                        } while (_jspx_th_logic_present_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                      }
                                                                      if (_jspx_th_logic_present_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                        return;
                                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                  // end
                                                                  // HTML // begin [file="/kntc/std/so_tiep_dan_don.jsp";from=(256,16);to=(257,0)]
                                                                    out.write("\r\n");

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
                                                              "/kntc/std/so_tiep_dan_don.jsp", 
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
                                                              "13", 
                                                              "13", 
                                                              "17", 
                                                              "17", 
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
                                                              "60", 
                                                              "62", 
                                                              "67", 
                                                              "67", 
                                                              "69", 
                                                              "69", 
                                                              "73", 
                                                              "73", 
                                                              "73", 
                                                              "73", 
                                                              "76", 
                                                              "76", 
                                                              "80", 
                                                              "80", 
                                                              "82", 
                                                              "82", 
                                                              "86", 
                                                              "86", 
                                                              "117", 
                                                              "119", 
                                                              "124", 
                                                              "124", 
                                                              "126", 
                                                              "126", 
                                                              "130", 
                                                              "130", 
                                                              "135", 
                                                              "135", 
                                                              "139", 
                                                              "139", 
                                                              "141", 
                                                              "141", 
                                                              "145", 
                                                              "145", 
                                                              "176", 
                                                              "180", 
                                                              "180", 
                                                              "186", 
                                                              "186", 
                                                              "194", 
                                                              "194", 
                                                              "201", 
                                                              "203", 
                                                              "257", 
                                                              },
                                                              };
                                                            }
