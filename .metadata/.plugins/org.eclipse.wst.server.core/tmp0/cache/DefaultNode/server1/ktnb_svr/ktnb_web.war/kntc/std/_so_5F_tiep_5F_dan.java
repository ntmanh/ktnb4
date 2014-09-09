package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _so_5F_tiep_5F_dan extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _so_5F_tiep_5F_dan( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/kntc/std/so_tiep_dan.jsp";

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
      /* ------  html:text ------ */
      org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = new org.apache.struts.taglib.html.TextTag();

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

                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(0,31);to=(1,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(1,59);to=(2,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(2,57);to=(3,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(3,57);to=(8,18)]
                                                                                              out.write("\r\n<fieldset style=\"font-size: 8pt;\"><legend>Hồ sơ</legend>\r\n<TABLE width=\"100%\">\r\n\t<tr>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">Mã số hồ sơ</td>\r\n\t\t<td width=\"35%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 9,18-"/kntc/std/so_tiep_dan.jsp" 9,84  LineMapIndex:1
                                                                                              _jspx_th_html_text_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_0.setParent(null);
                                                                                              _jspx_th_html_text_0.setProperty("maHoSo");
                                                                                              _jspx_th_html_text_0.setStyle("width:100%");
                                                                                              _jspx_th_html_text_0.setReadonly(true);
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_0);
                                                                                              int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 9,18-"/kntc/std/so_tiep_dan.jsp" 9,84  LineMapIndex:2
                                                                                              if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(8,84);to=(10,18)]
                                                                                              out.write("</td>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">Lượt tiếp</td>\r\n\t\t<td width=\"35%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 11,18-"/kntc/std/so_tiep_dan.jsp" 11,168  LineMapIndex:3
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_1 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_1.setParent(null);
                                                                                              _jspx_th_html_text_1.setProperty("luotTiep");
                                                                                              _jspx_th_html_text_1.setStyle("width:100%");
                                                                                              _jspx_th_html_text_1.setOnkeypress("return nokeypress(event);");
                                                                                              _jspx_th_html_text_1.setOnchange("checkLuotTiep(this)");
                                                                                              _jspx_th_html_text_1.setOnblur("isNumber(this,'i')");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_1);
                                                                                              int _jspx_eval_html_text_1 = _jspx_th_html_text_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 11,18-"/kntc/std/so_tiep_dan.jsp" 11,168  LineMapIndex:4
                                                                                              if (_jspx_th_html_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(10,168);to=(17,17)]
                                                                                              out.write("</td>\r\n\t</tr>\r\n</TABLE>\r\n</fieldset>\r\n<fieldset><legend>Hình thức tiếp dân</legend>\r\n<TABLE width=\"100%\">\r\n\t<td width=\"15%\" style=\"text-align: right;\">&nbsp;</td>\r\n\t<td width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 18,17-"/kntc/std/so_tiep_dan.jsp" 18,61  LineMapIndex:5
                                                                                              /* ------  html:radio ------ */
                                                                                              org.apache.struts.taglib.html.RadioTag _jspx_th_html_radio_0 = new org.apache.struts.taglib.html.RadioTag();
                                                                                              _jspx_th_html_radio_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_radio_0.setParent(null);
                                                                                              _jspx_th_html_radio_0.setProperty("hinhThuc");
                                                                                              _jspx_th_html_radio_0.setValue("1");
                                                                                              _jspxTagObjects.push(_jspx_th_html_radio_0);
                                                                                              int _jspx_eval_html_radio_0 = _jspx_th_html_radio_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 18,17-"/kntc/std/so_tiep_dan.jsp" 18,61  LineMapIndex:6
                                                                                              if (_jspx_th_html_radio_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(17,61);to=(18,17)]
                                                                                              out.write("Tiếp thường xuyên &nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n\t<td width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 19,17-"/kntc/std/so_tiep_dan.jsp" 19,61  LineMapIndex:7
                                                                                              /* ------  html:radio ------ */
                                                                                              org.apache.struts.taglib.html.RadioTag _jspx_th_html_radio_1 = new org.apache.struts.taglib.html.RadioTag();
                                                                                              _jspx_th_html_radio_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_radio_1.setParent(null);
                                                                                              _jspx_th_html_radio_1.setProperty("hinhThuc");
                                                                                              _jspx_th_html_radio_1.setValue("2");
                                                                                              _jspxTagObjects.push(_jspx_th_html_radio_1);
                                                                                              int _jspx_eval_html_radio_1 = _jspx_th_html_radio_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 19,17-"/kntc/std/so_tiep_dan.jsp" 19,61  LineMapIndex:8
                                                                                              if (_jspx_th_html_radio_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(18,61);to=(26,18)]
                                                                                              out.write("Tiếp định kỳ và đột xuất của lãnh đạo</td>\r\n\t<td width=\"25%\"></td>\r\n</TABLE>\r\n</fieldset>\r\n<fieldset><legend>Xử lý sơ bộ khi công dân đến trụ sở cơ quan</legend>\r\n<table width=\"100%\">\r\n\t<tr>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">&nbsp;</td>\r\n\t\t<td width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 27,18-"/kntc/std/so_tiep_dan.jsp" 27,60  LineMapIndex:9
                                                                                              /* ------  html:radio ------ */
                                                                                              org.apache.struts.taglib.html.RadioTag _jspx_th_html_radio_2 = new org.apache.struts.taglib.html.RadioTag();
                                                                                              _jspx_th_html_radio_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_radio_2.setParent(null);
                                                                                              _jspx_th_html_radio_2.setProperty("gayRoi");
                                                                                              _jspx_th_html_radio_2.setValue("0");
                                                                                              _jspxTagObjects.push(_jspx_th_html_radio_2);
                                                                                              int _jspx_eval_html_radio_2 = _jspx_th_html_radio_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 27,18-"/kntc/std/so_tiep_dan.jsp" 27,60  LineMapIndex:10
                                                                                              if (_jspx_th_html_radio_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(26,60);to=(27,18)]
                                                                                              out.write("Không gây rối</td>\r\n\t\t<td width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 28,18-"/kntc/std/so_tiep_dan.jsp" 28,60  LineMapIndex:11
                                                                                              /* ------  html:radio ------ */
                                                                                              org.apache.struts.taglib.html.RadioTag _jspx_th_html_radio_3 = new org.apache.struts.taglib.html.RadioTag();
                                                                                              _jspx_th_html_radio_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_radio_3.setParent(null);
                                                                                              _jspx_th_html_radio_3.setProperty("gayRoi");
                                                                                              _jspx_th_html_radio_3.setValue("1");
                                                                                              _jspxTagObjects.push(_jspx_th_html_radio_3);
                                                                                              int _jspx_eval_html_radio_3 = _jspx_th_html_radio_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 28,18-"/kntc/std/so_tiep_dan.jsp" 28,60  LineMapIndex:12
                                                                                              if (_jspx_th_html_radio_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(27,60);to=(32,18)]
                                                                                              out.write("Có gây rối</td>\r\n\t\t<td width=\"25%\"></td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">&nbsp;</td>\r\n\t\t<td width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 33,18-"/kntc/std/so_tiep_dan.jsp" 33,100  LineMapIndex:13
                                                                                              /* ------  html:radio ------ */
                                                                                              org.apache.struts.taglib.html.RadioTag _jspx_th_html_radio_4 = new org.apache.struts.taglib.html.RadioTag();
                                                                                              _jspx_th_html_radio_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_radio_4.setParent(null);
                                                                                              _jspx_th_html_radio_4.setProperty("doanKNTC");
                                                                                              _jspx_th_html_radio_4.setValue("1");
                                                                                              _jspx_th_html_radio_4.setOnclick("changeDoanKntc(this.value);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_radio_4);
                                                                                              int _jspx_eval_html_radio_4 = _jspx_th_html_radio_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 33,18-"/kntc/std/so_tiep_dan.jsp" 33,100  LineMapIndex:14
                                                                                              if (_jspx_th_html_radio_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(32,100);to=(33,18)]
                                                                                              out.write("Một người</td>\r\n\t\t<td width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 34,18-"/kntc/std/so_tiep_dan.jsp" 34,100  LineMapIndex:15
                                                                                              /* ------  html:radio ------ */
                                                                                              org.apache.struts.taglib.html.RadioTag _jspx_th_html_radio_5 = new org.apache.struts.taglib.html.RadioTag();
                                                                                              _jspx_th_html_radio_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_radio_5.setParent(null);
                                                                                              _jspx_th_html_radio_5.setProperty("doanKNTC");
                                                                                              _jspx_th_html_radio_5.setValue("2");
                                                                                              _jspx_th_html_radio_5.setOnclick("changeDoanKntc(this.value);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_radio_5);
                                                                                              int _jspx_eval_html_radio_5 = _jspx_th_html_radio_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 34,18-"/kntc/std/so_tiep_dan.jsp" 34,100  LineMapIndex:16
                                                                                              if (_jspx_th_html_radio_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(33,100);to=(34,18)]
                                                                                              out.write("Đông người có cử đại diện</td>\r\n\t\t<td width=\"25%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 35,18-"/kntc/std/so_tiep_dan.jsp" 35,100  LineMapIndex:17
                                                                                              /* ------  html:radio ------ */
                                                                                              org.apache.struts.taglib.html.RadioTag _jspx_th_html_radio_6 = new org.apache.struts.taglib.html.RadioTag();
                                                                                              _jspx_th_html_radio_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_radio_6.setParent(null);
                                                                                              _jspx_th_html_radio_6.setProperty("doanKNTC");
                                                                                              _jspx_th_html_radio_6.setValue("3");
                                                                                              _jspx_th_html_radio_6.setOnclick("changeDoanKntc(this.value);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_radio_6);
                                                                                              int _jspx_eval_html_radio_6 = _jspx_th_html_radio_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 35,18-"/kntc/std/so_tiep_dan.jsp" 35,100  LineMapIndex:18
                                                                                              if (_jspx_th_html_radio_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(34,100);to=(41,18)]
                                                                                              out.write("Đông người không cử đại diện <font color=\"red\">(Xử lý từng người giống trường hợp một người)</font></td>\r\n\t</tr>\r\n</table>\r\n<DIV id=\"idDivSl\" style=\"display: none\">\r\n<table width=\"100%\">\r\n\t<tr>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">Số lượng người</td>\r\n\t\t<td width=\"35%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 42,18-"/kntc/std/so_tiep_dan.jsp" 42,72  LineMapIndex:19
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_2.setParent(null);
                                                                                              _jspx_th_html_text_2.setProperty("doanKNTCSoLuong");
                                                                                              _jspx_th_html_text_2.setMaxlength("5");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_2);
                                                                                              int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 42,18-"/kntc/std/so_tiep_dan.jsp" 42,72  LineMapIndex:20
                                                                                              if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(41,72);to=(52,18)]
                                                                                              out.write("</td>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\"></td>\r\n\t\t<td width=\"35%\"></td>\r\n\t</tr>\r\n</table>\r\n</DIV>\r\n</fieldset>\r\n<fieldset><legend>Trường hợp đến KNTC</legend>\r\n<table width=\"100%\">\r\n\t<tr>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">Trường hợp</td>\r\n\t\t<td width=\"35%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 53,18-"/kntc/std/so_tiep_dan.jsp" 53,113  LineMapIndex:21
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_0 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_0.setParent(null);
                                                                                              _jspx_th_html_select_0.setProperty("loaiKNTC");
                                                                                              _jspx_th_html_select_0.setStyle("width:100%");
                                                                                              _jspx_th_html_select_0.setStyleId("loaiKNTC");
                                                                                              _jspx_th_html_select_0.setOnchange("changeKNTC()");
                                                                                              _jspxTagObjects.push(_jspx_th_html_select_0);
                                                                                              int _jspx_eval_html_select_0 = _jspx_th_html_select_0.doStartTag();
                                                                                              if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_select_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_select_0.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(52,113);to=(53,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 54,3-"/kntc/std/so_tiep_dan.jsp" 54,26  LineMapIndex:22
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_0 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_0.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_option_0.setValue("1");
                                                                                              _jspxTagObjects.push(_jspx_th_html_option_0);
                                                                                              int _jspx_eval_html_option_0 = _jspx_th_html_option_0.doStartTag();
                                                                                              if (_jspx_eval_html_option_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_option_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_option_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_option_0.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(53,26);to=(53,35)]
                                                                                              out.write("Khiếu nại");

                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 54,35-"/kntc/std/so_tiep_dan.jsp" 54,49  LineMapIndex:23
                                                                                              } while (_jspx_th_html_option_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_option_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_option_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(53,49);to=(54,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 55,3-"/kntc/std/so_tiep_dan.jsp" 55,26  LineMapIndex:24
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_1 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_1.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_option_1.setValue("2");
                                                                                              _jspxTagObjects.push(_jspx_th_html_option_1);
                                                                                              int _jspx_eval_html_option_1 = _jspx_th_html_option_1.doStartTag();
                                                                                              if (_jspx_eval_html_option_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_option_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_option_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_option_1.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(54,26);to=(54,32)]
                                                                                              out.write("Tố cáo");

                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 55,32-"/kntc/std/so_tiep_dan.jsp" 55,46  LineMapIndex:25
                                                                                              } while (_jspx_th_html_option_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_option_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_option_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(54,46);to=(55,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 56,3-"/kntc/std/so_tiep_dan.jsp" 56,26  LineMapIndex:26
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_2 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_2.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_option_2.setValue("4");
                                                                                              _jspxTagObjects.push(_jspx_th_html_option_2);
                                                                                              int _jspx_eval_html_option_2 = _jspx_th_html_option_2.doStartTag();
                                                                                              if (_jspx_eval_html_option_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_option_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_option_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_option_2.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(55,26);to=(55,47)]
                                                                                              out.write("Hỏi chế độ chính sách");

                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 56,47-"/kntc/std/so_tiep_dan.jsp" 56,61  LineMapIndex:27
                                                                                              } while (_jspx_th_html_option_2.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_option_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_option_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(55,61);to=(56,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 57,3-"/kntc/std/so_tiep_dan.jsp" 57,26  LineMapIndex:28
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_3 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_3.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_option_3.setValue("3");
                                                                                              _jspxTagObjects.push(_jspx_th_html_option_3);
                                                                                              int _jspx_eval_html_option_3 = _jspx_th_html_option_3.doStartTag();
                                                                                              if (_jspx_eval_html_option_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_option_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_option_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_option_3.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(56,26);to=(56,41)]
                                                                                              out.write("Trường hợp khác");

                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 57,41-"/kntc/std/so_tiep_dan.jsp" 57,55  LineMapIndex:29
                                                                                              } while (_jspx_th_html_option_3.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_option_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_option_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(56,55);to=(57,2)]
                                                                                              out.write("\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 58,2-"/kntc/std/so_tiep_dan.jsp" 58,16  LineMapIndex:30
                                                                                              } while (_jspx_th_html_select_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_select_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(57,16);to=(64,21)]
                                                                                              out.write("</td>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\"></td>\r\n\t\t<td width=\"35%\"></td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td></td>\r\n\t\t<td>\r\n\t\t<div id=\"idKNType\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 65,21-"/kntc/std/so_tiep_dan.jsp" 65,106  LineMapIndex:31
                                                                                              /* ------  html:checkbox ------ */
                                                                                              org.apache.struts.taglib.html.CheckboxTag _jspx_th_html_checkbox_0 = new org.apache.struts.taglib.html.CheckboxTag();
                                                                                              _jspx_th_html_checkbox_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_checkbox_0.setParent(null);
                                                                                              _jspx_th_html_checkbox_0.setProperty("isKNTCTrucTiep");
                                                                                              _jspx_th_html_checkbox_0.setValue("1");
                                                                                              _jspx_th_html_checkbox_0.setOnclick("changeKNTCTrucTiep();");
                                                                                              _jspxTagObjects.push(_jspx_th_html_checkbox_0);
                                                                                              int _jspx_eval_html_checkbox_0 = _jspx_th_html_checkbox_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 65,21-"/kntc/std/so_tiep_dan.jsp" 65,106  LineMapIndex:32
                                                                                              if (_jspx_th_html_checkbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(64,106);to=(72,22)]
                                                                                              out.write(" Không phải Khiếu nại trực tiếp</div>\r\n\t\t</td>\r\n\t\t<td style=\"text-align: right;\"></td>\r\n\t\t<td></td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td></td>\r\n\t\t<td>\r\n\t\t<div id=\"idUyQuyen\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 73,22-"/kntc/std/so_tiep_dan.jsp" 73,119  LineMapIndex:33
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_1 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_1.setParent(null);
                                                                                              _jspx_th_html_select_1.setProperty("uyQuyen");
                                                                                              _jspx_th_html_select_1.setStyle("width:100%");
                                                                                              _jspx_th_html_select_1.setStyleId("uyQuyen");
                                                                                              _jspx_th_html_select_1.setOnchange("changeUyQuyen();");
                                                                                              _jspxTagObjects.push(_jspx_th_html_select_1);
                                                                                              int _jspx_eval_html_select_1 = _jspx_th_html_select_1.doStartTag();
                                                                                              if (_jspx_eval_html_select_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_select_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_select_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_select_1.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(72,119);to=(73,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 74,3-"/kntc/std/so_tiep_dan.jsp" 74,26  LineMapIndex:34
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_4 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_4.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_4.setValue("1");
                                                                                              _jspxTagObjects.push(_jspx_th_html_option_4);
                                                                                              int _jspx_eval_html_option_4 = _jspx_th_html_option_4.doStartTag();
                                                                                              if (_jspx_eval_html_option_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_option_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_option_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_option_4.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(73,26);to=(73,51)]
                                                                                              out.write("Được ủy quyền của cá nhân");

                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 74,51-"/kntc/std/so_tiep_dan.jsp" 74,65  LineMapIndex:35
                                                                                              } while (_jspx_th_html_option_4.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_option_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_option_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(73,65);to=(74,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 75,3-"/kntc/std/so_tiep_dan.jsp" 75,26  LineMapIndex:36
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_5 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_5.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_5.setValue("2");
                                                                                              _jspxTagObjects.push(_jspx_th_html_option_5);
                                                                                              int _jspx_eval_html_option_5 = _jspx_th_html_option_5.doStartTag();
                                                                                              if (_jspx_eval_html_option_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_option_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_option_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_option_5.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(74,26);to=(74,55)]
                                                                                              out.write("Đại diện cho cơ quan, tổ chức");

                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 75,55-"/kntc/std/so_tiep_dan.jsp" 75,69  LineMapIndex:37
                                                                                              } while (_jspx_th_html_option_5.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_option_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_option_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(74,69);to=(75,2)]
                                                                                              out.write("\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 76,2-"/kntc/std/so_tiep_dan.jsp" 76,16  LineMapIndex:38
                                                                                              } while (_jspx_th_html_select_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_select_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_select_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(75,16);to=(86,18)]
                                                                                              out.write("</div>\r\n\t\t</td>\r\n\t\t<td></td>\r\n\t\t<td></td>\r\n\t</tr>\r\n</table>\r\n</fieldset>\r\n<fieldset><legend>Thông tin công dân</legend>\r\n<table width=\"100%\">\r\n\t<tr>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">Ngày tiếp <font color=\"red\">*</font></td>\r\n\t\t<td width=\"35%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 87,18-"/kntc/std/so_tiep_dan.jsp" 87,151  LineMapIndex:39
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_3 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_3.setParent(null);
                                                                                              _jspx_th_html_text_3.setProperty("ngayTiep");
                                                                                              _jspx_th_html_text_3.setMaxlength("10");
                                                                                              _jspx_th_html_text_3.setStyle("width: 40%");
                                                                                              _jspx_th_html_text_3.setOnkeypress("return formatDate(event, this)");
                                                                                              _jspx_th_html_text_3.setOnblur("isDate(this)");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_3);
                                                                                              int _jspx_eval_html_text_3 = _jspx_th_html_text_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 87,18-"/kntc/std/so_tiep_dan.jsp" 87,151  LineMapIndex:40
                                                                                              if (_jspx_th_html_text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(86,151);to=(88,18)]
                                                                                              out.write(" <A href=\"#\" onclick=\"openDsHoSo();\"><font color=\"red\"> Kiểm tra hồ sơ liên quan </font></A></td>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">Địa chỉ <font color=\"red\">*</font></td>\r\n\t\t<td width=\"35%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 89,18-"/kntc/std/so_tiep_dan.jsp" 89,100  LineMapIndex:41
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_4 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_4.setParent(null);
                                                                                              _jspx_th_html_text_4.setProperty("congdanDiaChi");
                                                                                              _jspx_th_html_text_4.setStyle("width: 100%");
                                                                                              _jspx_th_html_text_4.setStyleId("congdanDiaChi");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_4);
                                                                                              int _jspx_eval_html_text_4 = _jspx_th_html_text_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 89,18-"/kntc/std/so_tiep_dan.jsp" 89,100  LineMapIndex:42
                                                                                              if (_jspx_th_html_text_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(88,100);to=(92,6)]
                                                                                              out.write("</td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td style=\"text-align: right;\">Họ tên <font color=\"red\">*</font></td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 93,6-"/kntc/std/so_tiep_dan.jsp" 93,81  LineMapIndex:43
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_5 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_5.setParent(null);
                                                                                              _jspx_th_html_text_5.setProperty("congdanTen");
                                                                                              _jspx_th_html_text_5.setStyle("width: 100%");
                                                                                              _jspx_th_html_text_5.setStyleId("condanTen");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_5);
                                                                                              int _jspx_eval_html_text_5 = _jspx_th_html_text_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 93,6-"/kntc/std/so_tiep_dan.jsp" 93,81  LineMapIndex:44
                                                                                              if (_jspx_th_html_text_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(92,81);to=(94,6)]
                                                                                              out.write("</td>\r\n\t\t<td style=\"text-align: right;\">Điện thoại</td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 95,6-"/kntc/std/so_tiep_dan.jsp" 95,81  LineMapIndex:45
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_6 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_6.setParent(null);
                                                                                              _jspx_th_html_text_6.setProperty("congdanDienThoai");
                                                                                              _jspx_th_html_text_6.setStyle("width: 100%");
                                                                                              _jspx_th_html_text_6.setMaxlength("20");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_6);
                                                                                              int _jspx_eval_html_text_6 = _jspx_th_html_text_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 95,6-"/kntc/std/so_tiep_dan.jsp" 95,81  LineMapIndex:46
                                                                                              if (_jspx_th_html_text_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(94,81);to=(98,6)]
                                                                                              out.write("</td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td style=\"text-align: right;\">Chức vụ</td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 99,6-"/kntc/std/so_tiep_dan.jsp" 99,64  LineMapIndex:47
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_7 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_7.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_7.setParent(null);
                                                                                              _jspx_th_html_text_7.setProperty("congdanChucVu");
                                                                                              _jspx_th_html_text_7.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_7);
                                                                                              int _jspx_eval_html_text_7 = _jspx_th_html_text_7.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 99,6-"/kntc/std/so_tiep_dan.jsp" 99,64  LineMapIndex:48
                                                                                              if (_jspx_th_html_text_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(98,64);to=(100,6)]
                                                                                              out.write("</td>\r\n\t\t<td style=\"text-align: right;\">CMT/Hộ chiếu</td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 101,6-"/kntc/std/so_tiep_dan.jsp" 101,61  LineMapIndex:49
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_8 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_8.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_8.setParent(null);
                                                                                              _jspx_th_html_text_8.setProperty("congdanCMT");
                                                                                              _jspx_th_html_text_8.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_8);
                                                                                              int _jspx_eval_html_text_8 = _jspx_th_html_text_8.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 101,6-"/kntc/std/so_tiep_dan.jsp" 101,61  LineMapIndex:50
                                                                                              if (_jspx_th_html_text_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(100,61);to=(104,6)]
                                                                                              out.write("</td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td style=\"text-align: right;\">Nơi công tác</td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 105,6-"/kntc/std/so_tiep_dan.jsp" 105,68  LineMapIndex:51
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_9 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_9.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_9.setParent(null);
                                                                                              _jspx_th_html_text_9.setProperty("congdanNoiCongTac");
                                                                                              _jspx_th_html_text_9.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_9);
                                                                                              int _jspx_eval_html_text_9 = _jspx_th_html_text_9.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 105,6-"/kntc/std/so_tiep_dan.jsp" 105,68  LineMapIndex:52
                                                                                              if (_jspx_th_html_text_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(104,68);to=(106,6)]
                                                                                              out.write("</td>\r\n\t\t<td style=\"text-align: right;\">Ngày cấp CMND/Hộ chiếu</td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 107,6-"/kntc/std/so_tiep_dan.jsp" 107,149  LineMapIndex:53
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_10 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_10.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_10.setParent(null);
                                                                                              _jspx_th_html_text_10.setProperty("congdanCMTNgayCap");
                                                                                              _jspx_th_html_text_10.setMaxlength("10");
                                                                                              _jspx_th_html_text_10.setStyle("width: 100%");
                                                                                              _jspx_th_html_text_10.setOnkeypress("return formatDate(event, this)");
                                                                                              _jspx_th_html_text_10.setOnblur("isDate(this)");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_10);
                                                                                              int _jspx_eval_html_text_10 = _jspx_th_html_text_10.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 107,6-"/kntc/std/so_tiep_dan.jsp" 107,149  LineMapIndex:54
                                                                                              if (_jspx_th_html_text_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(106,149);to=(110,6)]
                                                                                              out.write("</td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td style=\"text-align: right;\">Mã số thuế</td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 111,6-"/kntc/std/so_tiep_dan.jsp" 111,61  LineMapIndex:55
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_11 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_11.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_11.setParent(null);
                                                                                              _jspx_th_html_text_11.setProperty("congdanMST");
                                                                                              _jspx_th_html_text_11.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_11);
                                                                                              int _jspx_eval_html_text_11 = _jspx_th_html_text_11.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 111,6-"/kntc/std/so_tiep_dan.jsp" 111,61  LineMapIndex:56
                                                                                              if (_jspx_th_html_text_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(110,61);to=(112,6)]
                                                                                              out.write("</td>\r\n\t\t<td style=\"text-align: right;\">Nơi cấp CMND/Hộ chiếu</td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 113,6-"/kntc/std/so_tiep_dan.jsp" 113,67  LineMapIndex:57
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_12 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_12.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_12.setParent(null);
                                                                                              _jspx_th_html_text_12.setProperty("congdanCMTNoiCap");
                                                                                              _jspx_th_html_text_12.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_12);
                                                                                              int _jspx_eval_html_text_12 = _jspx_th_html_text_12.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 113,6-"/kntc/std/so_tiep_dan.jsp" 113,67  LineMapIndex:58
                                                                                              if (_jspx_th_html_text_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(112,67);to=(116,6)]
                                                                                              out.write("</td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td style=\"text-align: right;\">Có luật sư đi cùng</td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 117,6-"/kntc/std/so_tiep_dan.jsp" 117,79  LineMapIndex:59
                                                                                              /* ------  html:checkbox ------ */
                                                                                              org.apache.struts.taglib.html.CheckboxTag _jspx_th_html_checkbox_1 = new org.apache.struts.taglib.html.CheckboxTag();
                                                                                              _jspx_th_html_checkbox_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_checkbox_1.setParent(null);
                                                                                              _jspx_th_html_checkbox_1.setProperty("coLuatSu");
                                                                                              _jspx_th_html_checkbox_1.setValue("1");
                                                                                              _jspx_th_html_checkbox_1.setOnclick("changeLuatSu();");
                                                                                              _jspxTagObjects.push(_jspx_th_html_checkbox_1);
                                                                                              int _jspx_eval_html_checkbox_1 = _jspx_th_html_checkbox_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 117,6-"/kntc/std/so_tiep_dan.jsp" 117,79  LineMapIndex:60
                                                                                              if (_jspx_th_html_checkbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(116,79);to=(127,18)]
                                                                                              out.write("</td>\r\n\t\t<td style=\"text-align: right;\"></td>\r\n\t\t<td></td>\r\n\t</tr>\r\n</table>\r\n</fieldset>\r\n<DIV id=\"idDivLS\" style=\"display: none\">\r\n<fieldset><legend>Thông tin luật sư (tư vấn)</legend>\r\n<table width=\"100%\">\r\n\t<tr>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">Họ tên <font color=\"red\">*</font></td>\r\n\t\t<td width=\"35%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 128,18-"/kntc/std/so_tiep_dan.jsp" 128,53  LineMapIndex:61
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_0.setParent(null);
                                                                                              _jspx_th_html_hidden_0.setProperty("luatsuMa");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_0);
                                                                                              int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 128,18-"/kntc/std/so_tiep_dan.jsp" 128,53  LineMapIndex:62
                                                                                              if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(127,53);to=(127,54)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 128,54-"/kntc/std/so_tiep_dan.jsp" 128,108  LineMapIndex:63
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_13 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_13.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_13.setParent(null);
                                                                                              _jspx_th_html_text_13.setProperty("luatsuTen");
                                                                                              _jspx_th_html_text_13.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_13);
                                                                                              int _jspx_eval_html_text_13 = _jspx_th_html_text_13.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 128,54-"/kntc/std/so_tiep_dan.jsp" 128,108  LineMapIndex:64
                                                                                              if (_jspx_th_html_text_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(127,108);to=(129,18)]
                                                                                              out.write("</td>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">Địa chỉ</td>\r\n\t\t<td width=\"35%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 130,18-"/kntc/std/so_tiep_dan.jsp" 130,75  LineMapIndex:65
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_14 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_14.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_14.setParent(null);
                                                                                              _jspx_th_html_text_14.setProperty("luatsuDiaChi");
                                                                                              _jspx_th_html_text_14.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_14);
                                                                                              int _jspx_eval_html_text_14 = _jspx_th_html_text_14.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 130,18-"/kntc/std/so_tiep_dan.jsp" 130,75  LineMapIndex:66
                                                                                              if (_jspx_th_html_text_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(129,75);to=(133,6)]
                                                                                              out.write("</td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td style=\"text-align: right;\">Nơi công tác</td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 134,6-"/kntc/std/so_tiep_dan.jsp" 134,67  LineMapIndex:67
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_15 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_15.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_15.setParent(null);
                                                                                              _jspx_th_html_text_15.setProperty("luatsuNoiCongTac");
                                                                                              _jspx_th_html_text_15.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_15);
                                                                                              int _jspx_eval_html_text_15 = _jspx_th_html_text_15.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 134,6-"/kntc/std/so_tiep_dan.jsp" 134,67  LineMapIndex:68
                                                                                              if (_jspx_th_html_text_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(133,67);to=(135,6)]
                                                                                              out.write("</td>\r\n\t\t<td style=\"text-align: right;\">Điện thoại</td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 136,6-"/kntc/std/so_tiep_dan.jsp" 136,66  LineMapIndex:69
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_16 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_16.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_16.setParent(null);
                                                                                              _jspx_th_html_text_16.setProperty("luatsuDienThoai");
                                                                                              _jspx_th_html_text_16.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_16);
                                                                                              int _jspx_eval_html_text_16 = _jspx_th_html_text_16.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 136,6-"/kntc/std/so_tiep_dan.jsp" 136,66  LineMapIndex:70
                                                                                              if (_jspx_th_html_text_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(135,66);to=(139,6)]
                                                                                              out.write("</td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td style=\"text-align: right;\">CMT/Hộ chiếu <font color=\"red\">*</font></td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 140,6-"/kntc/std/so_tiep_dan.jsp" 140,60  LineMapIndex:71
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_17 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_17.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_17.setParent(null);
                                                                                              _jspx_th_html_text_17.setProperty("luatsuCMT");
                                                                                              _jspx_th_html_text_17.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_17);
                                                                                              int _jspx_eval_html_text_17 = _jspx_th_html_text_17.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 140,6-"/kntc/std/so_tiep_dan.jsp" 140,60  LineMapIndex:72
                                                                                              if (_jspx_th_html_text_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(139,60);to=(141,6)]
                                                                                              out.write("</td>\r\n\t\t<td style=\"text-align: right;\">Số thẻ</td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 142,6-"/kntc/std/so_tiep_dan.jsp" 142,62  LineMapIndex:73
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_18 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_18.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_18.setParent(null);
                                                                                              _jspx_th_html_text_18.setProperty("luatsuSoThe");
                                                                                              _jspx_th_html_text_18.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_18);
                                                                                              int _jspx_eval_html_text_18 = _jspx_th_html_text_18.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 142,6-"/kntc/std/so_tiep_dan.jsp" 142,62  LineMapIndex:74
                                                                                              if (_jspx_th_html_text_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(141,62);to=(148,18)]
                                                                                              out.write("</td>\r\n\t</tr>\r\n</table>\r\n<fieldset><legend>Thông tin giấy yêu cầu</legend>\r\n<table width=\"100%\">\r\n\t<tr>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">Số giấy yêu cầu</td>\r\n\t\t<td width=\"35%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 149,18-"/kntc/std/so_tiep_dan.jsp" 149,73  LineMapIndex:75
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_19 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_19.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_19.setParent(null);
                                                                                              _jspx_th_html_text_19.setProperty("luatsuHDMa");
                                                                                              _jspx_th_html_text_19.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_19);
                                                                                              int _jspx_eval_html_text_19 = _jspx_th_html_text_19.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 149,18-"/kntc/std/so_tiep_dan.jsp" 149,73  LineMapIndex:76
                                                                                              if (_jspx_th_html_text_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(148,73);to=(150,18)]
                                                                                              out.write("</td>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">Nội dung yêu cầu</td>\r\n\t\t<td width=\"35%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 151,18-"/kntc/std/so_tiep_dan.jsp" 151,130  LineMapIndex:77
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_0 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_0.setParent(null);
                                                                                              _jspx_th_html_textarea_0.setProperty("luatsuHDNoiDung");
                                                                                              _jspx_th_html_textarea_0.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_0.setStyle("width: 100%;height:40px");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_0);
                                                                                              int _jspx_eval_html_textarea_0 = _jspx_th_html_textarea_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 151,18-"/kntc/std/so_tiep_dan.jsp" 151,130  LineMapIndex:78
                                                                                              if (_jspx_th_html_textarea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(150,130);to=(160,18)]
                                                                                              out.write("</td>\r\n\t</tr>\r\n</table>\r\n</fieldset>\r\n</fieldset>\r\n</DIV>\r\n<fieldset><legend>Thông tin cán bộ tiếp dân</legend>\r\n<table width=\"100%\">\r\n\t<tr>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">Nơi tiếp dân</td>\r\n\t\t<td width=\"35%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 161,18-"/kntc/std/so_tiep_dan.jsp" 161,89  LineMapIndex:79
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_20 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_20.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_20.setParent(null);
                                                                                              _jspx_th_html_text_20.setProperty("noiTiepDan");
                                                                                              _jspx_th_html_text_20.setStyle("width: 100%");
                                                                                              _jspx_th_html_text_20.setReadonly(true);
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_20);
                                                                                              int _jspx_eval_html_text_20 = _jspx_th_html_text_20.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 161,18-"/kntc/std/so_tiep_dan.jsp" 161,89  LineMapIndex:80
                                                                                              if (_jspx_th_html_text_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(160,89);to=(162,18)]
                                                                                              out.write("</td>\r\n\t\t<td width=\"15%\" style=\"text-align: right;\">Chức vụ</td>\r\n\t\t<td width=\"35%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 163,18-"/kntc/std/so_tiep_dan.jsp" 163,90  LineMapIndex:81
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_21 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_21.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_21.setParent(null);
                                                                                              _jspx_th_html_text_21.setProperty("canBoChucVu");
                                                                                              _jspx_th_html_text_21.setStyle("width: 100%");
                                                                                              _jspx_th_html_text_21.setReadonly(true);
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_21);
                                                                                              int _jspx_eval_html_text_21 = _jspx_th_html_text_21.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 163,18-"/kntc/std/so_tiep_dan.jsp" 163,90  LineMapIndex:82
                                                                                              if (_jspx_th_html_text_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(162,90);to=(166,6)]
                                                                                              out.write("</td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td style=\"text-align: right;\">Họ tên</td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 167,6-"/kntc/std/so_tiep_dan.jsp" 167,40  LineMapIndex:83
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_1 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_1.setParent(null);
                                                                                              _jspx_th_html_hidden_1.setProperty("canBoMa");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_1);
                                                                                              int _jspx_eval_html_hidden_1 = _jspx_th_html_hidden_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 167,6-"/kntc/std/so_tiep_dan.jsp" 167,40  LineMapIndex:84
                                                                                              if (_jspx_th_html_hidden_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(166,40);to=(166,41)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 167,41-"/kntc/std/so_tiep_dan.jsp" 167,109  LineMapIndex:85
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_22 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_22.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_22.setParent(null);
                                                                                              _jspx_th_html_text_22.setProperty("canBoTen");
                                                                                              _jspx_th_html_text_22.setReadonly(true);
                                                                                              _jspx_th_html_text_22.setStyle("width:100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_22);
                                                                                              int _jspx_eval_html_text_22 = _jspx_th_html_text_22.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 167,41-"/kntc/std/so_tiep_dan.jsp" 167,109  LineMapIndex:86
                                                                                              if (_jspx_th_html_text_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(166,109);to=(168,6)]
                                                                                              out.write("</td>\r\n\t\t<td style=\"text-align: right;\">Bộ phận công tác</td>\r\n\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/kntc/std/so_tiep_dan.jsp" 169,6-"/kntc/std/so_tiep_dan.jsp" 169,82  LineMapIndex:87
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_23 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_23.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_23.setParent(null);
                                                                                              _jspx_th_html_text_23.setProperty("canBoNoiCongTac");
                                                                                              _jspx_th_html_text_23.setReadonly(true);
                                                                                              _jspx_th_html_text_23.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_23);
                                                                                              int _jspx_eval_html_text_23 = _jspx_th_html_text_23.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/kntc/std/so_tiep_dan.jsp" 169,6-"/kntc/std/so_tiep_dan.jsp" 169,82  LineMapIndex:88
                                                                                              if (_jspx_th_html_text_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/kntc/std/so_tiep_dan.jsp";from=(168,82);to=(172,0)]
                                                                                              out.write("</td>\r\n\t</tr>\r\n</table>\r\n</fieldset>\r\n");

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
                                                                                          "/kntc/std/so_tiep_dan.jsp", 
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
                                                                                          "9", 
                                                                                          "9", 
                                                                                          "11", 
                                                                                          "11", 
                                                                                          "18", 
                                                                                          "18", 
                                                                                          "19", 
                                                                                          "19", 
                                                                                          "27", 
                                                                                          "27", 
                                                                                          "28", 
                                                                                          "28", 
                                                                                          "33", 
                                                                                          "33", 
                                                                                          "34", 
                                                                                          "34", 
                                                                                          "35", 
                                                                                          "35", 
                                                                                          "42", 
                                                                                          "42", 
                                                                                          "53", 
                                                                                          "54", 
                                                                                          "54", 
                                                                                          "55", 
                                                                                          "55", 
                                                                                          "56", 
                                                                                          "56", 
                                                                                          "57", 
                                                                                          "57", 
                                                                                          "58", 
                                                                                          "65", 
                                                                                          "65", 
                                                                                          "73", 
                                                                                          "74", 
                                                                                          "74", 
                                                                                          "75", 
                                                                                          "75", 
                                                                                          "76", 
                                                                                          "87", 
                                                                                          "87", 
                                                                                          "89", 
                                                                                          "89", 
                                                                                          "93", 
                                                                                          "93", 
                                                                                          "95", 
                                                                                          "95", 
                                                                                          "99", 
                                                                                          "99", 
                                                                                          "101", 
                                                                                          "101", 
                                                                                          "105", 
                                                                                          "105", 
                                                                                          "107", 
                                                                                          "107", 
                                                                                          "111", 
                                                                                          "111", 
                                                                                          "113", 
                                                                                          "113", 
                                                                                          "117", 
                                                                                          "117", 
                                                                                          "128", 
                                                                                          "128", 
                                                                                          "128", 
                                                                                          "128", 
                                                                                          "130", 
                                                                                          "130", 
                                                                                          "134", 
                                                                                          "134", 
                                                                                          "136", 
                                                                                          "136", 
                                                                                          "140", 
                                                                                          "140", 
                                                                                          "142", 
                                                                                          "142", 
                                                                                          "149", 
                                                                                          "149", 
                                                                                          "151", 
                                                                                          "151", 
                                                                                          "161", 
                                                                                          "161", 
                                                                                          "163", 
                                                                                          "163", 
                                                                                          "167", 
                                                                                          "167", 
                                                                                          "167", 
                                                                                          "167", 
                                                                                          "169", 
                                                                                          "169", 
                                                                                          },
                                                                                          };
                                                                                        }
