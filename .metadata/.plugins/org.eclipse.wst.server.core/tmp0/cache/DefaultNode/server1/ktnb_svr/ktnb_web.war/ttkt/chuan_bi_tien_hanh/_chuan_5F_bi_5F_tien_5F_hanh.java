package org.apache.jsp;

import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form.ChuanBiTienHanhForm;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _chuan_5F_bi_5F_tien_5F_hanh extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _chuan_5F_bi_5F_tien_5F_hanh( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";

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
      /* ------  html:rewrite ------ */
      org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_0 = new org.apache.struts.taglib.html.RewriteTag();

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

                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(0,30);to=(1,0)]
                                                                                              out.write("     \r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(0,0);to=(1,0)]
                                                                                              out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(1,31);to=(2,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(2,59);to=(3,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(3,57);to=(4,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(4,57);to=(5,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/top_bar.jsp" 6,2-"/top_bar.jsp" 13,0  LineMapIndex:1
                                                                                               
                                                                                              	request.setCharacterEncoding("UTF-8");
                                                                                              	response.setContentType("text/html;charset=UTF-8");
                                                                                              	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                                                                                              	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                                                                                              	response.setDateHeader("Expires", 0); // Proxies.
                                                                                              	cmc.com.ktnb.util.ApplicationContext ac=(cmc.com.ktnb.util.ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(12,2);to=(21,50)]
                                                                                              out.write("\r\n<html>\t\r\n<head>\r\n<HTA:APPLICATION ID=\"Ulti\" APPLICATIONNAME=\"Ultimater\" BORDER=\"thick\" BORDERSTYLE=\"sunken\" INNERBORDER=\"yes\" CONTEXTMENU=\"yes\" CAPTION=\"yes\" MAXIMIZEBUTTON=\"yes\" MINIMIZEBUTTON=\"yes\" NAVIGABLE=\"no\" SCROLL=\"yes\" SCROLLFLAT=\"no\" SELECTION=\"yes\" SINGLEINSTANCE=\"no\" SHOWINTASKBAR=\"yes\"\r\n\tSINGLEINSTANCE=\"yes\" SYSMENU=\"yes\" WINDOWSTATE=\"normal\">\r\n\t<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\" />\r\n\t<META HTTP-EQUIV=\"Cache-Control\" CONTENT=\"no-cache, no-store, must-revalidate\">\r\n\t<META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\r\n\t<META HTTP-EQUIV=\"Expires\" CONTENT=\"0\">\r\n\t<link rel=\"shortcut icon\" type=\"image/ico\" href=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 22,50-"/top_bar.jsp" 22,91  LineMapIndex:9
                                                                                              _jspx_th_html_rewrite_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_0.setParent(null);
                                                                                              _jspx_th_html_rewrite_0.setPage("/image/favicon.ico");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_0);
                                                                                              int _jspx_eval_html_rewrite_0 = _jspx_th_html_rewrite_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 22,50-"/top_bar.jsp" 22,91  LineMapIndex:10
                                                                                              if (_jspx_th_html_rewrite_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(21,91);to=(23,29)]
                                                                                              out.write("\" />\r\n\t<title>HỆ THỐNG KIỂM TRA NỘI BỘ</title>\r\n\t<link type=\"text/css\" href=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 24,29-"/top_bar.jsp" 24,72  LineMapIndex:11
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_1 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_1.setParent(null);
                                                                                              _jspx_th_html_rewrite_1.setPage("/stylesheet/ktnb.css");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_1);
                                                                                              int _jspx_eval_html_rewrite_1 = _jspx_th_html_rewrite_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 24,29-"/top_bar.jsp" 24,72  LineMapIndex:12
                                                                                              if (_jspx_th_html_rewrite_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(23,72);to=(24,29)]
                                                                                              out.write("\" rel=\"stylesheet\">\r\n\t<link type=\"text/css\" href=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 25,29-"/top_bar.jsp" 25,82  LineMapIndex:13
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_2 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_2.setParent(null);
                                                                                              _jspx_th_html_rewrite_2.setPage("/stylesheet/base/jquery-ui.css");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_2);
                                                                                              int _jspx_eval_html_rewrite_2 = _jspx_th_html_rewrite_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 25,29-"/top_bar.jsp" 25,82  LineMapIndex:14
                                                                                              if (_jspx_th_html_rewrite_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(24,82);to=(25,35)]
                                                                                              out.write("\" rel=\"stylesheet\">\r\n\t<!--  <link type=\"text/css\" href=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 26,35-"/top_bar.jsp" 26,95  LineMapIndex:15
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_3 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_3.setParent(null);
                                                                                              _jspx_th_html_rewrite_3.setPage("/stylesheet/base/jquery.treeTable.css");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_3);
                                                                                              int _jspx_eval_html_rewrite_3 = _jspx_th_html_rewrite_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 26,35-"/top_bar.jsp" 26,95  LineMapIndex:16
                                                                                              if (_jspx_th_html_rewrite_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(25,95);to=(26,29)]
                                                                                              out.write("\" rel=\"stylesheet\">\t-->\r\n\t<link type=\"text/css\" href=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 27,29-"/top_bar.jsp" 27,80  LineMapIndex:17
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_4 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_4.setParent(null);
                                                                                              _jspx_th_html_rewrite_4.setPage("/stylesheet/verticaltabs.css");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_4);
                                                                                              int _jspx_eval_html_rewrite_4 = _jspx_th_html_rewrite_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 27,29-"/top_bar.jsp" 27,80  LineMapIndex:18
                                                                                              if (_jspx_th_html_rewrite_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(26,80);to=(29,37)]
                                                                                              out.write("\" rel=\"stylesheet\">\r\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"include/js/themes/default/easyui.css\">\r\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"include/js/themes/icon.css\">\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 30,37-"/top_bar.jsp" 30,91  LineMapIndex:19
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_5 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_5.setParent(null);
                                                                                              _jspx_th_html_rewrite_5.setPage("/include/js/jquery-1.4.2.min.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_5);
                                                                                              int _jspx_eval_html_rewrite_5 = _jspx_th_html_rewrite_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 30,37-"/top_bar.jsp" 30,91  LineMapIndex:20
                                                                                              if (_jspx_th_html_rewrite_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(29,91);to=(30,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 31,37-"/top_bar.jsp" 31,92  LineMapIndex:21
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_6 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_6.setParent(null);
                                                                                              _jspx_th_html_rewrite_6.setPage("/include/js/jquery.easyui.min.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_6);
                                                                                              int _jspx_eval_html_rewrite_6 = _jspx_th_html_rewrite_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 31,37-"/top_bar.jsp" 31,92  LineMapIndex:22
                                                                                              if (_jspx_th_html_rewrite_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(30,92);to=(31,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 32,37-"/top_bar.jsp" 32,101  LineMapIndex:23
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_7 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_7.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_7.setParent(null);
                                                                                              _jspx_th_html_rewrite_7.setPage("/include/js/jquery-ui-1.8.2.custom.min.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_7);
                                                                                              int _jspx_eval_html_rewrite_7 = _jspx_th_html_rewrite_7.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 32,37-"/top_bar.jsp" 32,101  LineMapIndex:24
                                                                                              if (_jspx_th_html_rewrite_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(31,101);to=(32,37)]
                                                                                              out.write("\"></script> \r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 33,37-"/top_bar.jsp" 33,96  LineMapIndex:25
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_8 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_8.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_8.setParent(null);
                                                                                              _jspx_th_html_rewrite_8.setPage("/include/js/jquery.dataTables.min.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_8);
                                                                                              int _jspx_eval_html_rewrite_8 = _jspx_th_html_rewrite_8.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 33,37-"/top_bar.jsp" 33,96  LineMapIndex:26
                                                                                              if (_jspx_th_html_rewrite_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(32,96);to=(33,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 34,37-"/top_bar.jsp" 34,96  LineMapIndex:27
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_9 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_9.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_9.setParent(null);
                                                                                              _jspx_th_html_rewrite_9.setPage("/include/js/jquery.jeditable.mini.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_9);
                                                                                              int _jspx_eval_html_rewrite_9 = _jspx_th_html_rewrite_9.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 34,37-"/top_bar.jsp" 34,96  LineMapIndex:28
                                                                                              if (_jspx_th_html_rewrite_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(33,96);to=(34,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 35,37-"/top_bar.jsp" 35,102  LineMapIndex:29
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_10 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_10.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_10.setParent(null);
                                                                                              _jspx_th_html_rewrite_10.setPage("/include/js/jquery.ui.datepicker-vi.min.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_10);
                                                                                              int _jspx_eval_html_rewrite_10 = _jspx_th_html_rewrite_10.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 35,37-"/top_bar.jsp" 35,102  LineMapIndex:30
                                                                                              if (_jspx_th_html_rewrite_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(34,102);to=(35,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 36,37-"/top_bar.jsp" 36,90  LineMapIndex:31
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_11 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_11.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_11.setParent(null);
                                                                                              _jspx_th_html_rewrite_11.setPage("/include/js/jquery.jixedbar.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_11);
                                                                                              int _jspx_eval_html_rewrite_11 = _jspx_th_html_rewrite_11.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 36,37-"/top_bar.jsp" 36,90  LineMapIndex:32
                                                                                              if (_jspx_th_html_rewrite_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(35,90);to=(36,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 37,37-"/top_bar.jsp" 37,89  LineMapIndex:33
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_12 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_12.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_12.setParent(null);
                                                                                              _jspx_th_html_rewrite_12.setPage("/include/js/jquery.hotkeys.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_12);
                                                                                              int _jspx_eval_html_rewrite_12 = _jspx_th_html_rewrite_12.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 37,37-"/top_bar.jsp" 37,89  LineMapIndex:34
                                                                                              if (_jspx_th_html_rewrite_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(36,89);to=(37,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 38,37-"/top_bar.jsp" 38,91  LineMapIndex:35
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_13 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_13.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_13.setParent(null);
                                                                                              _jspx_th_html_rewrite_13.setPage("/include/js/jquery.treeTable.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_13);
                                                                                              int _jspx_eval_html_rewrite_13 = _jspx_th_html_rewrite_13.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 38,37-"/top_bar.jsp" 38,91  LineMapIndex:36
                                                                                              if (_jspx_th_html_rewrite_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(37,91);to=(38,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 39,37-"/top_bar.jsp" 39,79  LineMapIndex:37
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_14 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_14.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_14.setParent(null);
                                                                                              _jspx_th_html_rewrite_14.setPage("/include/js/ktnb.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_14);
                                                                                              int _jspx_eval_html_rewrite_14 = _jspx_th_html_rewrite_14.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 39,37-"/top_bar.jsp" 39,79  LineMapIndex:38
                                                                                              if (_jspx_th_html_rewrite_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(38,79);to=(39,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 40,37-"/top_bar.jsp" 40,89  LineMapIndex:39
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_15 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_15.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_15.setParent(null);
                                                                                              _jspx_th_html_rewrite_15.setPage("/include/js/datatable.util.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_15);
                                                                                              int _jspx_eval_html_rewrite_15 = _jspx_th_html_rewrite_15.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 40,37-"/top_bar.jsp" 40,89  LineMapIndex:40
                                                                                              if (_jspx_th_html_rewrite_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(39,89);to=(40,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 41,37-"/top_bar.jsp" 41,86  LineMapIndex:41
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_16 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_16.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_16.setParent(null);
                                                                                              _jspx_th_html_rewrite_16.setPage("/include/js/date.format.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_16);
                                                                                              int _jspx_eval_html_rewrite_16 = _jspx_th_html_rewrite_16.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 41,37-"/top_bar.jsp" 41,86  LineMapIndex:42
                                                                                              if (_jspx_th_html_rewrite_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(40,86);to=(41,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 42,37-"/top_bar.jsp" 42,87  LineMapIndex:43
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_17 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_17.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_17.setParent(null);
                                                                                              _jspx_th_html_rewrite_17.setPage("/include/js/verticaltabs.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_17);
                                                                                              int _jspx_eval_html_rewrite_17 = _jspx_th_html_rewrite_17.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 42,37-"/top_bar.jsp" 42,87  LineMapIndex:44
                                                                                              if (_jspx_th_html_rewrite_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(41,87);to=(42,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 43,37-"/top_bar.jsp" 43,92  LineMapIndex:45
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_18 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_18.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_18.setParent(null);
                                                                                              _jspx_th_html_rewrite_18.setPage("/include/js/verticaltabs.pack.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_18);
                                                                                              int _jspx_eval_html_rewrite_18 = _jspx_th_html_rewrite_18.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 43,37-"/top_bar.jsp" 43,92  LineMapIndex:46
                                                                                              if (_jspx_th_html_rewrite_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(42,92);to=(43,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 44,37-"/top_bar.jsp" 44,93  LineMapIndex:47
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_19 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_19.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_19.setParent(null);
                                                                                              _jspx_th_html_rewrite_19.setPage("/include/js/jquery.pngFix.pack.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_19);
                                                                                              int _jspx_eval_html_rewrite_19 = _jspx_th_html_rewrite_19.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 44,37-"/top_bar.jsp" 44,93  LineMapIndex:48
                                                                                              if (_jspx_th_html_rewrite_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(43,93);to=(44,37)]
                                                                                              out.write("\"></script>\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 45,37-"/top_bar.jsp" 45,85  LineMapIndex:49
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_20 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_20.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_20.setParent(null);
                                                                                              _jspx_th_html_rewrite_20.setPage("/include/js/pluginpage.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_20);
                                                                                              int _jspx_eval_html_rewrite_20 = _jspx_th_html_rewrite_20.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 45,37-"/top_bar.jsp" 45,85  LineMapIndex:50
                                                                                              if (_jspx_th_html_rewrite_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(44,85);to=(45,42)]
                                                                                              out.write("\"></script>\r\n\t<!-- <script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 46,42-"/top_bar.jsp" 46,92  LineMapIndex:51
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_21 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_21.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_21.setParent(null);
                                                                                              _jspx_th_html_rewrite_21.setPage("/include/nicEdit/nicEdit.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_21);
                                                                                              int _jspx_eval_html_rewrite_21 = _jspx_th_html_rewrite_21.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 46,42-"/top_bar.jsp" 46,92  LineMapIndex:52
                                                                                              if (_jspx_th_html_rewrite_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(45,92);to=(46,37)]
                                                                                              out.write("\"></script> -->\r\n\t<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/top_bar.jsp" 47,37-"/top_bar.jsp" 47,86  LineMapIndex:53
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_22 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_22.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_22.setParent(null);
                                                                                              _jspx_th_html_rewrite_22.setPage("/include/js/FixedColumn.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_22);
                                                                                              int _jspx_eval_html_rewrite_22 = _jspx_th_html_rewrite_22.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 47,37-"/top_bar.jsp" 47,86  LineMapIndex:54
                                                                                              if (_jspx_th_html_rewrite_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(46,86);to=(50,18)]
                                                                                              out.write("\"></script>\r\n\t<script>\r\n\t$(function() \r\n\t{\t\t\r\n\t\tvar readonly = '");

                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 51,21-"/top_bar.jsp" 51,47  LineMapIndex:55
                                                                                              out.print(request.getParameter("r") );
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(50,49);to=(82,37)]
                                                                                              out.write("';\r\n\t\tif(readonly=='rol'){\r\n\t\t\tdisableAllField();\r\n\t\t\tif(isExist('btnKetXuat'))\r\n\t\t\tdocument.getElementById('btnKetXuat').disabled = false;\r\n\t\t\tif(isExist('btnXem'))\r\n\t\t\tdocument.getElementById('btnXem').disabled = false;\r\n\t\t\tif(isExist('btnClose'))\r\n\t\t\tdocument.getElementById('btnClose').disabled = false;\r\n\t\t\tif(isExist('btnClose2'))\r\n\t\t\tdocument.getElementById('btnClose2').disabled = false;\r\n\t\t\tif(isExist('btnClose3'))\r\n\t\t\tdocument.getElementById('btnClose3').disabled = false;\r\n\t\t}\t  \t\r\n\t\t$('#container').pngFix( );\r\n\t});\r\n  </script>\r\n</head>\r\n<body>\r\n<div id=\"container\">\r\n<div id=\"topbar\">\r\n<div class=\"item\"><a href=\"index.do\" onclick=\"window.location='index.do';\"><img src=\"image/home.png\" alt=\"\" />Trang chủ</a></div>\r\n<div class=\"item\"><a href=\"ftp://ftp.tct.vn/Public/VPTCT/KTNB/Tailieudaotao.rar\"><img src=\"image/information.png\" alt=\"\" />Trợ giúp</a></div>\r\n<div class=\"item\"><a href=\"index_kntc.do\"><img src=\"image/blogs.png\" alt=\"\" />Khiếu nại tố cáo</a></div>\r\n<div class=\"item\"><a href=\"ttkt_index.do\"><img src=\"image/feed.png\" alt=\"\" />Kiểm tra nội bộ</a></div>\r\n<div class=\"item\"><a href=\"index_report.do\"><img src=\"image/report2.png\" alt=\"\" />Báo cáo</a></div>\r\n<div class=\"item\"><a href=\"index_ttcp.do\"><img src=\"image/report2.png\" alt=\"\" />Báo cáo TTCP</a></div>\r\n<div class=\"item\"><a href=\"index_system.do\"><img src=\"image/system.png\" alt=\"\" />Hệ thống</a></div>\r\n<div class=\"item\"><a href=\"pass.do\"><img src=\"image/password.png\" alt=\"\" />Đổi MK</a></div>\r\n<div class=\"item\"><a href=\"thoat.do\" onclick=\"window.location='thoat.do';\"><img src=\"image/exit.png\" alt=\"\" />Thoát</a></div>\r\n</div>\r\n<div id=\"logo\">\r\n<div id=\"loginStatus\"><b>CÁN BỘ:</b> ");

                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 83,40-"/top_bar.jsp" 83,56  LineMapIndex:56
                                                                                              out.print(ac.getTenCanbo());
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(82,58);to=(82,82)]
                                                                                              out.write(" - <b>NƠI CÔNG TÁC:</b> ");

                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 83,85-"/top_bar.jsp" 83,101  LineMapIndex:57
                                                                                              out.print(ac.getTenPhong());
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(82,103);to=(82,106)]
                                                                                              out.write(" - ");

                                                                                              // end
                                                                                              // ##DEBUG## "/top_bar.jsp" 83,109-"/top_bar.jsp" 83,123  LineMapIndex:58
                                                                                              out.print(ac.getTenCqt());
                                                                                              // end
                                                                                              // HTML // begin [file="/top_bar.jsp";from=(82,125);to=(84,18)]
                                                                                              out.write("</div>\r\n</div>\r\n<div id=\"content\">");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(1,33);to=(2,36)]
                                                                                              out.write("      \r\n<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 3,36-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 3,83  LineMapIndex:59
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_23 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_23.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_23.setParent(null);
                                                                                              _jspx_th_html_rewrite_23.setPage("/include/js/ttkt/ttkt.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_23);
                                                                                              int _jspx_eval_html_rewrite_23 = _jspx_th_html_rewrite_23.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 3,36-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 3,83  LineMapIndex:60
                                                                                              if (_jspx_th_html_rewrite_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(2,83);to=(3,0)]
                                                                                              out.write("\"></script>\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(3,46);to=(4,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(4,55);to=(6,15)]
                                                                                              out.write("\r\n<script language=\"javascript\">                  \r\n\tvar tenCqt = \"");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 7,18-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 7,109  LineMapIndex:61
                                                                                              out.print(((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getTenCqt());
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(6,111);to=(7,14)]
                                                                                              out.write("\";\r\n\tvar maCqt = '");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 8,17-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 8,107  LineMapIndex:62
                                                                                              out.print(((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getMaCqt());
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(7,109);to=(9,48)]
                                                                                              out.write("';                 \r\n</script> \r\n<h3 class=\"Header\">Chuẩn bị tiến hành - Mã cuộc ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 10,48-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 10,110  LineMapIndex:63
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_0.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_0.setParent(null);
                                                                                              _jspx_th_bean_write_0.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_bean_write_0.setProperty("maCuocTtkt");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_0);
                                                                                              int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 10,48-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 10,110  LineMapIndex:64
                                                                                              if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(9,110);to=(10,0)]
                                                                                              out.write(" </h3>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 11,0-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 11,75  LineMapIndex:65
                                                                                              /* ------  html:form ------ */
                                                                                              org.apache.struts.taglib.html.FormTag _jspx_th_html_form_0 = new org.apache.struts.taglib.html.FormTag();
                                                                                              _jspx_th_html_form_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_form_0.setParent(null);
                                                                                              _jspx_th_html_form_0.setAction("chuan_bi_tien_hanh.do");
                                                                                              _jspx_th_html_form_0.setMethod("POST");
                                                                                              _jspx_th_html_form_0.setStyleId("cbthForm");
                                                                                              _jspxTagObjects.push(_jspx_th_html_form_0);
                                                                                              int _jspx_eval_html_form_0 = _jspx_th_html_form_0.doStartTag();
                                                                                              if (_jspx_eval_html_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(10,75);to=(11,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 12,1-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 12,38  LineMapIndex:66
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_hidden_0.setProperty("idCuocTtkt");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_0);
                                                                                              int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 12,1-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 12,38  LineMapIndex:67
                                                                                              if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(11,38);to=(12,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 13,1-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 13,35  LineMapIndex:68
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_1 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_1.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_hidden_1.setProperty("diaDiem");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_1);
                                                                                              int _jspx_eval_html_hidden_1 = _jspx_th_html_hidden_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 13,1-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 13,35  LineMapIndex:69
                                                                                              if (_jspx_th_html_hidden_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(12,35);to=(13,0)]
                                                                                              out.write("  \r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 14,0-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 14,12  LineMapIndex:70
                                                                                              } while (_jspx_th_html_form_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_html_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(13,12);to=(27,30)]
                                                                                              out.write("\r\n<DIV id=\"chua_co_lich_trinh_du_kien\"><B><a href=\"#\" onclick=\"xemThongTinChung();\">Thông tin chung</a></B></DIV>\r\n<DIV id=\"da_co_lich_trinh_du_kien\"><B><a href=\"#\" onclick=\"xemThongTinChung();\">Thông tin chung</a><label>&nbsp;|</label></B> <B><a href=\"#\" onclick=\"xemLichTrinhDuKien();\">Lịch trình dự kiến</a></B></DIV>\r\n</br>\r\n<div id=\"tab\" style=\"margin: 5px 5px 5px 5px\">\r\n<ul>\r\n\t<li><a href=\"#tabBCKS\"><b>Báo cáo khảo sát</b></a></li>\r\n\t<li><a href=\"#tabTVDoan\"><b>Thành viên đoàn</b></a></li>\r\n\t<li><a href=\"#tabQuyetDinh\"><b>Quyết định</b></a></li>\r\n\t<li><a href=\"#tabKH\"><b>Kế hoạch</b></a></li>\r\n\t<li><a href=\"#tabDeCuong\"><b>Đề cương</b></a></li>    \r\n\t<li><a href=\"#tabHopDoanTrienKhai\"><b>Họp đoàn triển khai</b></a></li>   \r\n</ul>\r\n<DIV id=\"tabBCKS\">    \r\n<fieldset style=\"width: 100%\">");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(0,56);to=(1,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(1,58);to=(2,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(2,56);to=(3,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(3,84);to=(4,36)]
                                                                                              out.write("\r\n<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 5,36-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 5,101  LineMapIndex:71
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_24 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_24.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_24.setParent(null);
                                                                                              _jspx_th_html_rewrite_24.setPage("/ttkt/chuan_bi_tien_hanh/webtoolkit.aim.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_24);
                                                                                              int _jspx_eval_html_rewrite_24 = _jspx_th_html_rewrite_24.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 5,36-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 5,101  LineMapIndex:72
                                                                                              if (_jspx_th_html_rewrite_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(4,101);to=(5,0)]
                                                                                              out.write("\"></script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 6,0-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 6,108  LineMapIndex:73
                                                                                              /* ------  html:form ------ */
                                                                                              org.apache.struts.taglib.html.FormTag _jspx_th_html_form_1 = new org.apache.struts.taglib.html.FormTag();
                                                                                              _jspx_th_html_form_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_form_1.setParent(null);
                                                                                              _jspx_th_html_form_1.setAction("chuan_bi_tien_hanh.do?method=save&type=bcks");
                                                                                              _jspx_th_html_form_1.setMethod("POST");
                                                                                              _jspx_th_html_form_1.setEnctype("multipart/form-data");
                                                                                              _jspxTagObjects.push(_jspx_th_html_form_1);
                                                                                              int _jspx_eval_html_form_1 = _jspx_th_html_form_1.doStartTag();
                                                                                              if (_jspx_eval_html_form_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(5,108);to=(7,1)]
                                                                                              out.write("\r\n\t<div id=\"getReturnBcks\" style=\"display: none;\"></div>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 8,1-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 8,38  LineMapIndex:74
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_2 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_2.setParent(_jspx_th_html_form_1);
                                                                                              _jspx_th_html_hidden_2.setProperty("maFileBCKS");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_2);
                                                                                              int _jspx_eval_html_hidden_2 = _jspx_th_html_hidden_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 8,1-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 8,38  LineMapIndex:75
                                                                                              if (_jspx_th_html_hidden_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(7,38);to=(8,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 9,1-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 9,40  LineMapIndex:76
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_3 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_3.setParent(_jspx_th_html_form_1);
                                                                                              _jspx_th_html_hidden_3.setProperty("isChangeBCKS");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_3);
                                                                                              int _jspx_eval_html_hidden_3 = _jspx_th_html_hidden_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 9,1-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 9,40  LineMapIndex:77
                                                                                              if (_jspx_th_html_hidden_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(8,40);to=(10,2)]
                                                                                              out.write("\r\n\t<TABLE width=\"100%\" align=\"center\">\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 11,2-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 11,36  LineMapIndex:78
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_0 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_0.setParent(_jspx_th_html_form_1);
                                                                                              _jspx_th_logic_notPresent_0.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_0);
                                                                                              int _jspx_eval_logic_notPresent_0 = _jspx_th_logic_notPresent_0.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(10,36);to=(24,33)]
                                                                                              out.write("\r\n\t\t\t<tr>\r\n\t\t\t\t<td align=\"right\" width=\"49%\">Download bi&#7875;u m&#7851;u</td>\r\n\t\t\t\t<td style=\"width: 2%; min-width: 5px;\"></td>\r\n\t\t\t\t<td align=\"left\" width=\"49%\"><A href=\"#\" onclick=\"downLoadBieuMau()\"> <font color=blue>M&#7851;u s&#7889; 03/TTNB</font> </A></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr id='fileBaoCaoKhaoSatCu'>\r\n\t\t\t\t<td align=\"right\" width=\"49%\">File &#x111;&#xED;nh k&#xE8;m</td>\r\n\t\t\t\t<td style=\"width: 2%; min-width: 5px;\"></td>\r\n\t\t\t\t<td align=\"left\" width=\"49%\"><A href=\"#\" onclick=\"downLoadBcks()\"><font color=blue>B&#225;o c&#225;o kh&#7843;o s&#225;t</font></A></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td align=\"right\" width=\"49%\" id=\"labelAttachmentFile\"></td>\r\n\t\t\t\t<td style=\"width: 2%; min-width: 5px;\"></td>\r\n\t\t\t\t<td align=\"left\" width=\"49%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 25,33-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 25,66  LineMapIndex:79
                                                                                              /* ------  html:file ------ */
                                                                                              org.apache.struts.taglib.html.FileTag _jspx_th_html_file_0 = new org.apache.struts.taglib.html.FileTag();
                                                                                              _jspx_th_html_file_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_file_0.setParent(_jspx_th_logic_notPresent_0);
                                                                                              _jspx_th_html_file_0.setProperty("fileBCKS");
                                                                                              _jspxTagObjects.push(_jspx_th_html_file_0);
                                                                                              int _jspx_eval_html_file_0 = _jspx_th_html_file_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 25,33-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 25,66  LineMapIndex:80
                                                                                              if (_jspx_th_html_file_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(24,66);to=(26,2)]
                                                                                              out.write("</td>\r\n\t\t\t</tr>\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 27,2-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 27,21  LineMapIndex:81
                                                                                              } while (_jspx_th_logic_notPresent_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(26,21);to=(27,2)]
                                                                                              out.write("\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 28,2-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 28,33  LineMapIndex:82
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_0 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_0.setParent(_jspx_th_html_form_1);
                                                                                              _jspx_th_logic_present_0.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_0);
                                                                                              int _jspx_eval_logic_present_0 = _jspx_th_logic_present_0.doStartTag();
                                                                                              if (_jspx_eval_logic_present_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(27,33);to=(28,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 29,3-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 29,75  LineMapIndex:83
                                                                                              /* ------  logic:equal ------ */
                                                                                              org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_0 = new org.apache.struts.taglib.logic.EqualTag();
                                                                                              _jspx_th_logic_equal_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_equal_0.setParent(_jspx_th_logic_present_0);
                                                                                              _jspx_th_logic_equal_0.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_equal_0.setProperty("maFileBCKS");
                                                                                              _jspx_th_logic_equal_0.setValue(" ");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_equal_0);
                                                                                              int _jspx_eval_logic_equal_0 = _jspx_th_logic_equal_0.doStartTag();
                                                                                              if (_jspx_eval_logic_equal_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(28,75);to=(32,3)]
                                                                                              out.write("\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"center\">Ch&#x1B0;a c&#xF3; b&#xE1;o c&#xE1;o kh&#x1EA3;o s&#xE1;t.</td>\r\n\t\t\t\t</tr>\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 33,3-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 33,17  LineMapIndex:84
                                                                                              } while (_jspx_th_logic_equal_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_equal_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(32,17);to=(33,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 34,3-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 34,78  LineMapIndex:85
                                                                                              /* ------  logic:notEqual ------ */
                                                                                              org.apache.struts.taglib.logic.NotEqualTag _jspx_th_logic_notEqual_0 = new org.apache.struts.taglib.logic.NotEqualTag();
                                                                                              _jspx_th_logic_notEqual_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notEqual_0.setParent(_jspx_th_logic_present_0);
                                                                                              _jspx_th_logic_notEqual_0.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_notEqual_0.setProperty("maFileBCKS");
                                                                                              _jspx_th_logic_notEqual_0.setValue(" ");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notEqual_0);
                                                                                              int _jspx_eval_logic_notEqual_0 = _jspx_th_logic_notEqual_0.doStartTag();
                                                                                              if (_jspx_eval_logic_notEqual_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(33,78);to=(39,3)]
                                                                                              out.write("\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"49%\">File &#x111;&#xED;nh k&#xE8;m</td>\r\n\t\t\t\t\t<td style=\"width: 2%; min-width: 5px;\"></td>\r\n\t\t\t\t\t<td align=\"left\" width=\"49%\"><A href=\"#\" onclick=\"downLoadBcks()\"><font color=blue>B&#225;o c&#225;o kh&#7843;o s&#225;t</font></A></td>\r\n\t\t\t\t</tr>\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 40,3-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 40,20  LineMapIndex:86
                                                                                              } while (_jspx_th_logic_notEqual_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notEqual_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(39,20);to=(40,2)]
                                                                                              out.write("\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 41,2-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 41,18  LineMapIndex:87
                                                                                              } while (_jspx_th_logic_present_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(40,18);to=(42,0)]
                                                                                              out.write("\r\n\t</TABLE>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 43,0-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 43,12  LineMapIndex:88
                                                                                              } while (_jspx_th_html_form_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_html_form_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(42,12);to=(43,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 44,0-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 44,34  LineMapIndex:89
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_1 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_1.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_1.setParent(null);
                                                                                              _jspx_th_logic_notPresent_1.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_1);
                                                                                              int _jspx_eval_logic_notPresent_1 = _jspx_th_logic_notPresent_1.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(43,34);to=(55,0)]
                                                                                              out.write("\r\n\t<script language=\"javascript\">\r\n\t\tmaFile = document.getElementsByName('maFileBCKS')[0].value;\r\n\t\tif(maFile == null || maFile == ' '){\r\n\t\t\tdocument.getElementById('fileBaoCaoKhaoSatCu').style.display = 'none';\r\n\t\t\tdocument.getElementById('labelAttachmentFile').innerHTML = 'File &#x111;&#xED;nh k&#xE8;m';\r\n\t\t}\t\r\n\t\telse{\r\n\t\t\tdocument.getElementById('fileBaoCaoKhaoSatCu').style.display = 'inline';\r\n\t\t\tdocument.getElementById('labelAttachmentFile').innerHTML = 'C&#x1EAD;p nh&#x1EAD;t file &#x111;&#xED;nh k&#xE8;m';\r\n\t\t}\r\n\t</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 56,0-"/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp" 56,19  LineMapIndex:90
                                                                                              } while (_jspx_th_logic_notPresent_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp";from=(55,19);to=(78,0)]
                                                                                              out.write("\r\n<script>\r\nfunction onLoadBaoCaoKs(){\r\n\r\n}\r\nfunction downLoadBcks(){ \r\n\tdownLoadWinDow = window.open('UploadAction.do?method=downLoadFileById&ma_file='+document.getElementsByName('maFileBCKS')[0].value);\r\n\tdownLoadWinDow.focus();\r\n}\r\nfunction downLoadBieuMau(){\r\n\t//downLoadWinDow = window.open('UploadAction.do?method=downLoadFileById&ma_file=ttnb03');\r\n\t//downLoadWinDow.focus();\r\n\tvar printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=bcks');\t\r\n\tprintfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=bcks&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;\r\n\tprintfForm.submit();\r\n\tprintfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=bcks';      \r\n}    \r\nfunction validateBaoCaoKhaoSat(){\r\n\tif(!isRequired(document.getElementsByName('fileBCKS')[0]))\r\n\t\treturn false;\r\n\treturn true;\r\n}\r\n</script>\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(27,90);to=(30,30)]
                                                                                              out.write("</fieldset>   \r\n</DIV>     \r\n<DIV id=\"tabTVDoan\">     \r\n<fieldset style=\"width: 100%\">");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(0,31);to=(1,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(1,56);to=(2,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(2,58);to=(3,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(3,56);to=(4,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 5,0-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 5,77  LineMapIndex:91
                                                                                              /* ------  html:form ------ */
                                                                                              org.apache.struts.taglib.html.FormTag _jspx_th_html_form_2 = new org.apache.struts.taglib.html.FormTag();
                                                                                              _jspx_th_html_form_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_form_2.setParent(null);
                                                                                              _jspx_th_html_form_2.setAction("chuan_bi_tien_hanh.do?method=save&type=tvd");
                                                                                              _jspx_th_html_form_2.setMethod("POST");
                                                                                              _jspxTagObjects.push(_jspx_th_html_form_2);
                                                                                              int _jspx_eval_html_form_2 = _jspx_th_html_form_2.doStartTag();
                                                                                              if (_jspx_eval_html_form_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(4,77);to=(9,19)]
                                                                                              out.write("\r\n\t<TABLE width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"19%\" align=\"right\">Nơi lập tờ trình <font color=\"red\">*</font></td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 10,19-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 10,98  LineMapIndex:92
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_0.setParent(_jspx_th_html_form_2);
                                                                                              _jspx_th_html_text_0.setStyleClass("text");
                                                                                              _jspx_th_html_text_0.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_0.setProperty("noiLapDsTvd");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_0);
                                                                                              int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
                                                                                              if (_jspx_eval_html_text_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_0.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(9,98);to=(10,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 11,3-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 11,15  LineMapIndex:93
                                                                                              } while (_jspx_th_html_text_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(10,15);to=(13,7)]
                                                                                              out.write("</td>\r\n\t\t\t<td width=\"19%\" align=\"right\">Ngày lập tờ trình <font color=\"red\">*</font></td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 14,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 14,153  LineMapIndex:94
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_1 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_1.setParent(_jspx_th_html_form_2);
                                                                                              _jspx_th_html_text_1.setOnkeypress("return formatDate(event, this)");
                                                                                              _jspx_th_html_text_1.setOnblur("isDate(this)");
                                                                                              _jspx_th_html_text_1.setStyleClass("text");
                                                                                              _jspx_th_html_text_1.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_1.setProperty("ngayLapDsTvd");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_1);
                                                                                              int _jspx_eval_html_text_1 = _jspx_th_html_text_1.doStartTag();
                                                                                              if (_jspx_eval_html_text_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_1.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(13,153);to=(14,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 15,3-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 15,15  LineMapIndex:95
                                                                                              } while (_jspx_th_html_text_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(14,15);to=(19,20)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Nơi phê duyệt</td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 20,20-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 20,104  LineMapIndex:96
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_2.setParent(_jspx_th_html_form_2);
                                                                                              _jspx_th_html_text_2.setStyleClass("text");
                                                                                              _jspx_th_html_text_2.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_2.setProperty("noiPheDuyetDsTvd");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_2);
                                                                                              int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 20,20-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 20,116  LineMapIndex:97
                                                                                              if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(19,116);to=(22,20)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\">Ngày phê duyệt</td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 23,20-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 23,171  LineMapIndex:98
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_3 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_3.setParent(_jspx_th_html_form_2);
                                                                                              _jspx_th_html_text_3.setOnkeypress("return formatDate(event, this)");
                                                                                              _jspx_th_html_text_3.setOnblur("isDate(this)");
                                                                                              _jspx_th_html_text_3.setStyleClass("text");
                                                                                              _jspx_th_html_text_3.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_3.setProperty("ngayPheDuyetDsTvd");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_3);
                                                                                              int _jspx_eval_html_text_3 = _jspx_th_html_text_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 23,20-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 23,183  LineMapIndex:99
                                                                                              if (_jspx_th_html_text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(22,183);to=(27,45)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Ý kiến phê duyệt</td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td colspan=\"4\" width=\"100%\" align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 28,45-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 28,153  LineMapIndex:100
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_0 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_0.setParent(_jspx_th_html_form_2);
                                                                                              _jspx_th_html_textarea_0.setProperty("ykienPheDuyetDsTvd");
                                                                                              _jspx_th_html_textarea_0.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_0.setStyleClass("textareaTitle");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_0);
                                                                                              int _jspx_eval_html_textarea_0 = _jspx_th_html_textarea_0.doStartTag();
                                                                                              if (_jspx_eval_html_textarea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_textarea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_textarea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_textarea_0.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(27,153);to=(28,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 29,3-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 29,19  LineMapIndex:101
                                                                                              } while (_jspx_th_html_textarea_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_textarea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_textarea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(28,19);to=(33,19)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Văn bản quy định chức năng nhiệm vụ<font color=red>*</font></td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 34,19-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 34,112  LineMapIndex:102
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_0 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_0.setParent(_jspx_th_html_form_2);
                                                                                              _jspx_th_html_select_0.setProperty("vanBanQuyDinhCnangNvuQdTvd");
                                                                                              _jspx_th_html_select_0.setStyle("width: 100%");
                                                                                              _jspx_th_html_select_0.setStyleClass("combobox");
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(33,112);to=(34,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 35,4-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 35,26  LineMapIndex:103
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_0 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_0.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_option_0.setValue("");
                                                                                              _jspxTagObjects.push(_jspx_th_html_option_0);
                                                                                              int _jspx_eval_html_option_0 = _jspx_th_html_option_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 35,4-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 35,40  LineMapIndex:104
                                                                                              if (_jspx_th_html_option_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(34,40);to=(35,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 36,4-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 36,78  LineMapIndex:105
                                                                                              /* ------  html:options ------ */
                                                                                              org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_0 = new org.apache.struts.taglib.html.OptionsTag();
                                                                                              _jspx_th_html_options_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_options_0.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_options_0.setCollection("dmtly");
                                                                                              _jspx_th_html_options_0.setProperty("value");
                                                                                              _jspx_th_html_options_0.setLabelProperty("label");
                                                                                              _jspxTagObjects.push(_jspx_th_html_options_0);
                                                                                              int _jspx_eval_html_options_0 = _jspx_th_html_options_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 36,4-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 36,78  LineMapIndex:106
                                                                                              if (_jspx_th_html_options_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(35,78);to=(36,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 37,3-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 37,17  LineMapIndex:107
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(36,17);to=(54,3)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t</TABLE>\r\n\t<br>\r\n\t<fieldset style=\"margin: 0\"><legend>Danh sách thành viên đoàn</legend>\r\n\t<DIV id=\"divDsTvd\">\r\n\t<TABLE id=\"tblDsTvd\" style=\"width: 100%\">\r\n\t\t<THEAD id=\"headerDsTvd\">\r\n\t\t\t<tr class=\"TdHeaderList\">\r\n\t\t\t\t<td align=\"center\">STT</td>\r\n\t\t\t\t<td>Tên thành viên <font color=\"red\">*</font></td>\r\n\t\t\t\t<td>Đơn vị công tác <font color=\"red\">*</font></td>\r\n\t\t\t\t<td>Chức vụ công tác</td>\r\n\t\t\t\t<td>Chức vụ trong đoàn</td>\r\n\t\t\t\t<td align=\"center\"><INPUT type=\"checkbox\" class=\"checkbox\" onclick=\"selectAllThanhVienDoan(this)\"></td>\r\n\t\t\t</tr>\r\n\t\t</THEAD>\r\n\t\t<TBODY id=\"bodyDsTvd\">\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 55,3-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 55,69  LineMapIndex:108
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_1 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_1.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_1.setParent(_jspx_th_html_form_2);
                                                                                              _jspx_th_logic_present_1.setProperty("chiTietDsTvd");
                                                                                              _jspx_th_logic_present_1.setName("ChuanBiTienHanhForm");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_1);
                                                                                              int _jspx_eval_logic_present_1 = _jspx_th_logic_present_1.doStartTag();
                                                                                              if (_jspx_eval_logic_present_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(54,69);to=(55,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 56,4-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 56,105  LineMapIndex:109
                                                                                              /* ------  logic:iterate ------ */
                                                                                              org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_0 = new org.apache.struts.taglib.logic.IterateTag();
                                                                                              _jspx_th_logic_iterate_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_iterate_0.setParent(_jspx_th_logic_present_1);
                                                                                              _jspx_th_logic_iterate_0.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_iterate_0.setProperty("chiTietDsTvd");
                                                                                              _jspx_th_logic_iterate_0.setId("thanhVienDoan");
                                                                                              _jspx_th_logic_iterate_0.setIndexId("index");
                                                                                              { // begin scope of tag variables
                                                                                              _jspxTagObjects.push(_jspx_th_logic_iterate_0);
                                                                                              int _jspx_eval_logic_iterate_0 = _jspx_th_logic_iterate_0.doStartTag();
                                                                                              if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_logic_iterate_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_logic_iterate_0.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              java.lang.Object thanhVienDoan = null;
                                                                                              thanhVienDoan = (java.lang.Object) pageContext.findAttribute("thanhVienDoan");
                                                                                              java.lang.Integer index = null;
                                                                                              index = (java.lang.Integer) pageContext.findAttribute("index");
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(55,105);to=(56,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 57,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 57,35  LineMapIndex:110
                                                                                              if (index.intValue() == 0) {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(56,37);to=(59,25)]
                                                                                              out.write("\r\n\t\t\t\t\t<tr class=\"row1\">\r\n\t\t\t\t\t\t<!--So thu tu-->\r\n\t\t\t\t\t\t<td align=\"center\">");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 60,28-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 60,48  LineMapIndex:111
                                                                                              out.print(index.intValue() + 1);
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(59,50);to=(61,10)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<!--Ten thanh vien-->\r\n\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 62,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 62,106  LineMapIndex:112
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_4 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_4.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_hidden_4.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_hidden_4.setProperty("chiTietDsTvd[" + index + "].idCanBo");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_4);
                                                                                              int _jspx_eval_html_hidden_4 = _jspx_th_html_hidden_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 62,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 62,106  LineMapIndex:113
                                                                                              if (_jspx_th_html_hidden_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(61,106);to=(61,107)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 62,107-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 62,252  LineMapIndex:114
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_4 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_4.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_text_4.setStyleClass("text");
                                                                                              _jspx_th_html_text_4.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_4.setStyle("width:77%");
                                                                                              _jspx_th_html_text_4.setProperty("chiTietDsTvd[" + index + "].tenCanBo");
                                                                                              _jspx_th_html_text_4.setReadonly(true);
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_4);
                                                                                              int _jspx_eval_html_text_4 = _jspx_th_html_text_4.doStartTag();
                                                                                              if (_jspx_eval_html_text_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_4.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(61,252);to=(62,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 63,6-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 63,18  LineMapIndex:115
                                                                                              } while (_jspx_th_html_text_4.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(62,18);to=(62,104)]
                                                                                              out.write(" <Input type=\"button\" value=\"...\" class=\"lovButton\" onclick=\"chonThanhVienDoanFromLov(");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 63,107-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 63,112  LineMapIndex:116
                                                                                              out.print(index);
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(62,114);to=(64,10)]
                                                                                              out.write(")\" disabled=\"disabled\"></td>\r\n\t\t\t\t\t\t<!--Don vi cong tac-->\r\n\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 65,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 65,106  LineMapIndex:117
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_5 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_5.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_hidden_5.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_hidden_5.setProperty("chiTietDsTvd[" + index + "].idPhong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_5);
                                                                                              int _jspx_eval_html_hidden_5 = _jspx_th_html_hidden_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 65,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 65,106  LineMapIndex:118
                                                                                              if (_jspx_th_html_hidden_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(64,106);to=(64,107)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 65,107-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 65,256  LineMapIndex:119
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_5 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_5.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_text_5.setStyle("border-bottom:none; width:100%");
                                                                                              _jspx_th_html_text_5.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_5.setProperty("chiTietDsTvd[" + index + "].tenPhong");
                                                                                              _jspx_th_html_text_5.setReadonly(true);
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_5);
                                                                                              int _jspx_eval_html_text_5 = _jspx_th_html_text_5.doStartTag();
                                                                                              if (_jspx_eval_html_text_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_5.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(64,256);to=(65,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 66,6-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 66,18  LineMapIndex:120
                                                                                              } while (_jspx_th_html_text_5.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(65,18);to=(67,10)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<!--Chuc vu cong tac-->\r\n\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 68,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 68,157  LineMapIndex:121
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_6 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_6.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_text_6.setStyle("border-bottom:none; width:100%");
                                                                                              _jspx_th_html_text_6.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_6.setProperty("chiTietDsTvd[" + index + "].chucVu");
                                                                                              _jspx_th_html_text_6.setReadonly(true);
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_6);
                                                                                              int _jspx_eval_html_text_6 = _jspx_th_html_text_6.doStartTag();
                                                                                              if (_jspx_eval_html_text_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_6.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(67,157);to=(68,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 69,6-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 69,18  LineMapIndex:122
                                                                                              } while (_jspx_th_html_text_6.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(68,18);to=(70,10)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<!--Chuc vu trong doan-->\r\n\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 71,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 71,128  LineMapIndex:123
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_1 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_1.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_select_1.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_select_1.setProperty("chiTietDsTvd[" + index + "].chucVuTrongDoan");
                                                                                              _jspx_th_html_select_1.setDisabled(true);
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(70,128);to=(71,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 72,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 72,40  LineMapIndex:124
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_1 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_1.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_1.setValue("Truong doan");
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(71,40);to=(71,51)]
                                                                                              out.write("Trưởng đoàn");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 72,51-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 72,65  LineMapIndex:125
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(71,65);to=(72,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 73,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 73,37  LineMapIndex:126
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_2 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_2.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_2.setValue("Pho doan");
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(72,37);to=(72,45)]
                                                                                              out.write("Phó đoàn");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 73,45-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 73,59  LineMapIndex:127
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(72,59);to=(73,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 74,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 74,44  LineMapIndex:128
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_3 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_3.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_3.setValue("Thanh vien doan");
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(73,44);to=(73,59)]
                                                                                              out.write("Thành viên đoàn");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 74,59-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 74,73  LineMapIndex:129
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(73,73);to=(74,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 75,6-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 75,20  LineMapIndex:130
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(74,20);to=(77,5)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<td align=\"center\"><INPUT type=\"checkbox\" value=\"selectThanhVienDoan(this)\" disabled=\"disabled\"></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 78,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 78,46  LineMapIndex:131
                                                                                              } else if (index.intValue() % 2 == 0) {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(77,48);to=(80,25)]
                                                                                              out.write("\r\n\t\t\t\t\t<tr class=\"row1\">\r\n\t\t\t\t\t\t<!--So thu tu-->\r\n\t\t\t\t\t\t<td align=\"center\">");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 81,28-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 81,48  LineMapIndex:132
                                                                                              out.print(index.intValue() + 1);
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(80,50);to=(82,10)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<!--Ten thanh vien-->\r\n\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 83,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 83,106  LineMapIndex:133
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_6 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_6.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_hidden_6.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_hidden_6.setProperty("chiTietDsTvd[" + index + "].idCanBo");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_6);
                                                                                              int _jspx_eval_html_hidden_6 = _jspx_th_html_hidden_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 83,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 83,106  LineMapIndex:134
                                                                                              if (_jspx_th_html_hidden_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(82,106);to=(82,107)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 83,107-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 83,236  LineMapIndex:135
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_7 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_7.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_7.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_text_7.setStyleClass("text");
                                                                                              _jspx_th_html_text_7.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_7.setStyle("width:77%");
                                                                                              _jspx_th_html_text_7.setProperty("chiTietDsTvd[" + index + "].tenCanBo");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_7);
                                                                                              int _jspx_eval_html_text_7 = _jspx_th_html_text_7.doStartTag();
                                                                                              if (_jspx_eval_html_text_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_7.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(82,236);to=(83,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 84,6-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 84,18  LineMapIndex:136
                                                                                              } while (_jspx_th_html_text_7.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(83,18);to=(84,7)]
                                                                                              out.write(" \r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 85,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 85,122  LineMapIndex:137
                                                                                              /* ------  logic:notEqual ------ */
                                                                                              org.apache.struts.taglib.logic.NotEqualTag _jspx_th_logic_notEqual_1 = new org.apache.struts.taglib.logic.NotEqualTag();
                                                                                              _jspx_th_logic_notEqual_1.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notEqual_1.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_logic_notEqual_1.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_notEqual_1.setValue("999999999");
                                                                                              _jspx_th_logic_notEqual_1.setProperty("chiTietDsTvd[" + index + "].idPhong");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notEqual_1);
                                                                                              int _jspx_eval_logic_notEqual_1 = _jspx_th_logic_notEqual_1.doStartTag();
                                                                                              if (_jspx_eval_logic_notEqual_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(84,122);to=(85,93)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t\t<Input type=\"button\" value=\"...\" class=\"lovButton\" onclick=\"chonThanhVienDoanFromLov(");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 86,96-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 86,101  LineMapIndex:138
                                                                                              out.print(index);
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(85,103);to=(86,7)]
                                                                                              out.write(")\">\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 87,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 87,24  LineMapIndex:139
                                                                                              } while (_jspx_th_logic_notEqual_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notEqual_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(86,24);to=(89,10)]
                                                                                              out.write("\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<!--Don vi cong tac-->\r\n\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 90,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 90,106  LineMapIndex:140
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_7 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_7.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_7.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_hidden_7.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_hidden_7.setProperty("chiTietDsTvd[" + index + "].idPhong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_7);
                                                                                              int _jspx_eval_html_hidden_7 = _jspx_th_html_hidden_7.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 90,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 90,106  LineMapIndex:141
                                                                                              if (_jspx_th_html_hidden_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(89,106);to=(89,107)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 90,107-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 90,240  LineMapIndex:142
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_8 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_8.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_8.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_text_8.setStyle("border-bottom:none; width:100%");
                                                                                              _jspx_th_html_text_8.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_8.setProperty("chiTietDsTvd[" + index + "].tenPhong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_8);
                                                                                              int _jspx_eval_html_text_8 = _jspx_th_html_text_8.doStartTag();
                                                                                              if (_jspx_eval_html_text_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_8.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_8.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(89,240);to=(90,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 91,6-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 91,18  LineMapIndex:143
                                                                                              } while (_jspx_th_html_text_8.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(90,18);to=(92,10)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<!--Chuc vu cong tac-->\r\n\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 93,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 93,141  LineMapIndex:144
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_9 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_9.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_9.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_text_9.setStyle("border-bottom:none; width:100%");
                                                                                              _jspx_th_html_text_9.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_9.setProperty("chiTietDsTvd[" + index + "].chucVu");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_9);
                                                                                              int _jspx_eval_html_text_9 = _jspx_th_html_text_9.doStartTag();
                                                                                              if (_jspx_eval_html_text_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_9.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_9.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(92,141);to=(93,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 94,6-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 94,18  LineMapIndex:145
                                                                                              } while (_jspx_th_html_text_9.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(93,18);to=(95,10)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<!--Chuc vu trong doan-->\r\n\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 96,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 96,134  LineMapIndex:146
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_2 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_2.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_select_2.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_select_2.setProperty("chiTietDsTvd[" + index + "].chucVuTrongDoan");
                                                                                              _jspx_th_html_select_2.setStyleClass("combobox");
                                                                                              _jspxTagObjects.push(_jspx_th_html_select_2);
                                                                                              int _jspx_eval_html_select_2 = _jspx_th_html_select_2.doStartTag();
                                                                                              if (_jspx_eval_html_select_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_select_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_select_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_select_2.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(95,134);to=(96,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 97,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 97,37  LineMapIndex:147
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_4 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_4.setParent(_jspx_th_html_select_2);
                                                                                              _jspx_th_html_option_4.setValue("Pho doan");
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(96,37);to=(96,45)]
                                                                                              out.write("Phó đoàn");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 97,45-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 97,59  LineMapIndex:148
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(96,59);to=(97,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 98,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 98,44  LineMapIndex:149
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_5 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_5.setParent(_jspx_th_html_select_2);
                                                                                              _jspx_th_html_option_5.setValue("Thanh vien doan");
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(97,44);to=(97,59)]
                                                                                              out.write("Thành viên đoàn");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 98,59-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 98,73  LineMapIndex:150
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
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(97,73);to=(98,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 99,6-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 99,20  LineMapIndex:151
                                                                                              } while (_jspx_th_html_select_2.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_select_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_select_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(98,20);to=(101,5)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<td align=\"center\"><INPUT type=\"checkbox\" class=\"checkbox\" value=\"selectThanhVienDoan(this)\"></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 102,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 102,13  LineMapIndex:152
                                                                                              }else{
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(101,15);to=(104,25)]
                                                                                              out.write("\r\n\t\t\t\t\t<tr class=\"row2\">\r\n\t\t\t\t\t\t<!--So thu tu-->\r\n\t\t\t\t\t\t<td align=\"center\">");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 105,28-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 105,48  LineMapIndex:153
                                                                                              out.print(index.intValue() + 1);
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(104,50);to=(106,10)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<!--Ten thanh vien-->\r\n\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 107,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 107,106  LineMapIndex:154
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_8 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_8.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_8.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_hidden_8.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_hidden_8.setProperty("chiTietDsTvd[" + index + "].idCanBo");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_8);
                                                                                              int _jspx_eval_html_hidden_8 = _jspx_th_html_hidden_8.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 107,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 107,106  LineMapIndex:155
                                                                                              if (_jspx_th_html_hidden_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(106,106);to=(106,107)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 107,107-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 107,236  LineMapIndex:156
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_10 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_10.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_10.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_text_10.setStyleClass("text");
                                                                                              _jspx_th_html_text_10.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_10.setStyle("width:77%");
                                                                                              _jspx_th_html_text_10.setProperty("chiTietDsTvd[" + index + "].tenCanBo");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_10);
                                                                                              int _jspx_eval_html_text_10 = _jspx_th_html_text_10.doStartTag();
                                                                                              if (_jspx_eval_html_text_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_10.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_10.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(106,236);to=(107,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 108,6-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 108,18  LineMapIndex:157
                                                                                              } while (_jspx_th_html_text_10.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(107,18);to=(108,7)]
                                                                                              out.write(" \r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 109,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 109,122  LineMapIndex:158
                                                                                              /* ------  logic:notEqual ------ */
                                                                                              org.apache.struts.taglib.logic.NotEqualTag _jspx_th_logic_notEqual_2 = new org.apache.struts.taglib.logic.NotEqualTag();
                                                                                              _jspx_th_logic_notEqual_2.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notEqual_2.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_logic_notEqual_2.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_notEqual_2.setValue("999999999");
                                                                                              _jspx_th_logic_notEqual_2.setProperty("chiTietDsTvd[" + index + "].idPhong");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notEqual_2);
                                                                                              int _jspx_eval_logic_notEqual_2 = _jspx_th_logic_notEqual_2.doStartTag();
                                                                                              if (_jspx_eval_logic_notEqual_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(108,122);to=(109,93)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t\t<Input type=\"button\" value=\"...\" class=\"lovButton\" onclick=\"chonThanhVienDoanFromLov(");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 110,96-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 110,101  LineMapIndex:159
                                                                                              out.print(index);
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(109,103);to=(110,7)]
                                                                                              out.write(")\">\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 111,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 111,24  LineMapIndex:160
                                                                                              } while (_jspx_th_logic_notEqual_2.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notEqual_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(110,24);to=(113,10)]
                                                                                              out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<!--Don vi cong tac-->\r\n\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 114,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 114,106  LineMapIndex:161
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_9 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_9.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_9.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_hidden_9.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_hidden_9.setProperty("chiTietDsTvd[" + index + "].idPhong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_9);
                                                                                              int _jspx_eval_html_hidden_9 = _jspx_th_html_hidden_9.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 114,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 114,106  LineMapIndex:162
                                                                                              if (_jspx_th_html_hidden_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(113,106);to=(113,107)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 114,107-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 114,240  LineMapIndex:163
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_11 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_11.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_11.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_text_11.setStyle("border-bottom:none; width:100%");
                                                                                              _jspx_th_html_text_11.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_11.setProperty("chiTietDsTvd[" + index + "].tenPhong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_11);
                                                                                              int _jspx_eval_html_text_11 = _jspx_th_html_text_11.doStartTag();
                                                                                              if (_jspx_eval_html_text_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_11.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_11.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(113,240);to=(114,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 115,6-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 115,18  LineMapIndex:164
                                                                                              } while (_jspx_th_html_text_11.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(114,18);to=(116,10)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<!--Chuc vu cong tac-->\r\n\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 117,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 117,140  LineMapIndex:165
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_12 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_12.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_12.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_text_12.setStyle("border-bottom:none;width:100%");
                                                                                              _jspx_th_html_text_12.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_12.setProperty("chiTietDsTvd[" + index + "].chucVu");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_12);
                                                                                              int _jspx_eval_html_text_12 = _jspx_th_html_text_12.doStartTag();
                                                                                              if (_jspx_eval_html_text_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_12 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_12.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_12.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(116,140);to=(117,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 118,6-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 118,18  LineMapIndex:166
                                                                                              } while (_jspx_th_html_text_12.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_12 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(117,18);to=(119,10)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<!--Chuc vu trong doan-->\r\n\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 120,10-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 120,134  LineMapIndex:167
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_3 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_3.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_select_3.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_select_3.setProperty("chiTietDsTvd[" + index + "].chucVuTrongDoan");
                                                                                              _jspx_th_html_select_3.setStyleClass("combobox");
                                                                                              _jspxTagObjects.push(_jspx_th_html_select_3);
                                                                                              int _jspx_eval_html_select_3 = _jspx_th_html_select_3.doStartTag();
                                                                                              if (_jspx_eval_html_select_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_select_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_select_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_select_3.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(119,134);to=(120,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 121,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 121,37  LineMapIndex:168
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_6 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_6.setParent(_jspx_th_html_select_3);
                                                                                              _jspx_th_html_option_6.setValue("Pho doan");
                                                                                              _jspxTagObjects.push(_jspx_th_html_option_6);
                                                                                              int _jspx_eval_html_option_6 = _jspx_th_html_option_6.doStartTag();
                                                                                              if (_jspx_eval_html_option_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_option_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_option_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_option_6.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(120,37);to=(120,45)]
                                                                                              out.write("Phó đoàn");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 121,45-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 121,59  LineMapIndex:169
                                                                                              } while (_jspx_th_html_option_6.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_option_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_option_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(120,59);to=(121,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 122,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 122,44  LineMapIndex:170
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_7 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_7.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_7.setParent(_jspx_th_html_select_3);
                                                                                              _jspx_th_html_option_7.setValue("Thanh vien doan");
                                                                                              _jspxTagObjects.push(_jspx_th_html_option_7);
                                                                                              int _jspx_eval_html_option_7 = _jspx_th_html_option_7.doStartTag();
                                                                                              if (_jspx_eval_html_option_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_option_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_option_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_option_7.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(121,44);to=(121,59)]
                                                                                              out.write("Thành viên đoàn");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 122,59-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 122,73  LineMapIndex:171
                                                                                              } while (_jspx_th_html_option_7.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_option_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_option_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(121,73);to=(122,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 123,6-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 123,20  LineMapIndex:172
                                                                                              } while (_jspx_th_html_select_3.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_select_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_select_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(122,20);to=(125,5)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<td align=\"center\"><INPUT type=\"checkbox\" class=\"checkbox\" value=\"selectThanhVienDoan(this)\"></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 126,7-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 126,8  LineMapIndex:173
                                                                                              }
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(125,10);to=(126,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 127,4-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 127,20  LineMapIndex:174
                                                                                              } while (_jspx_th_logic_iterate_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_logic_iterate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              } // end scope of tag variables
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(126,20);to=(127,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 128,3-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 128,19  LineMapIndex:175
                                                                                              } while (_jspx_th_logic_present_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(127,19);to=(146,1)]
                                                                                              out.write("\r\n\t\t</TBODY>\r\n\t</TABLE>\r\n\t</DIV>\r\n\t<TABLE width=\"100%\" align=\"right\">\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"6\" align=\"right\">\r\n\t\t\t<INPUT type=\"button\" class=\"button\" onclick=\"themThanhVienDoanNgoai()\" value=\"Thêm thành viên ngoài\">\r\n\t\t\t<INPUT type=\"button\" class=\"button\" onclick=\"themThanhVienDoan()\" value=\"Thêm\"> \r\n\t\t\t<INPUT type=\"button\" onclick=\"xoaThanhVienDoan()\" value=\"Xóa\" id=\"xoaTblThanhVienDoan\" class=\"button\">\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</TABLE>\r\n\t</fieldset>\r\n\t<TABLE align=\"right\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\"><INPUT type=\"button\" onclick=\"IntoTrinh()\" class=\"button1\" style=\"MARGIN: 0px;\" value=\"In tờ trình\"></td>\r\n\t\t</tr>\r\n\t</TABLE>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 147,1-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 147,39  LineMapIndex:176
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_10 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_10.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_10.setParent(_jspx_th_html_form_2);
                                                                                              _jspx_th_html_hidden_10.setProperty("isChangeTvd");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_10);
                                                                                              int _jspx_eval_html_hidden_10 = _jspx_th_html_hidden_10.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 147,1-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 147,39  LineMapIndex:177
                                                                                              if (_jspx_th_html_hidden_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(146,39);to=(147,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 148,1-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 148,35  LineMapIndex:178
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_11 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_11.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_11.setParent(_jspx_th_html_form_2);
                                                                                              _jspx_th_html_hidden_11.setProperty("idDsTvd");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_11);
                                                                                              int _jspx_eval_html_hidden_11 = _jspx_th_html_hidden_11.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 148,1-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 148,35  LineMapIndex:179
                                                                                              if (_jspx_th_html_hidden_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(147,35);to=(148,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 149,0-"/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp" 149,12  LineMapIndex:180
                                                                                              } while (_jspx_th_html_form_2.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_html_form_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp";from=(148,12);to=(357,9)]
                                                                                              out.write("\r\n<script language=\"javascript\">\r\nfunction IntoTrinh(){   \r\n\tif(!validateThanhVienDoan())     \r\n\t\t\treturn;\r\n\t//window.open('report.do?rp=ttnb04'); \r\n\tvar printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=tvd');\t\r\n\tprintfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=tvd&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;\r\n\tprintfForm.submit();\r\n\tprintfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=tvd'; \r\n}\r\nfunction onloadChiDinhThanhVienDoan(){\r\n\tif(document.getElementsByName('chiTietDsTvd[0].chucVu')[0].value == 'null')\r\n\t\tdocument.getElementsByName('chiTietDsTvd[0].chucVu')[0].value = ''; \r\n}\r\nvar idCanBoConTrol;\r\nvar\ttenCanBoConTrol;\r\nvar\tdonViCongTacControl;\r\nvar\tchucVuConTrol;\r\n\r\nfunction chonThanhVienDoanFromLov(index){\t\r\n\tlovType = 'tvd';\r\n\t// Id\r\n\tidCanBoConTrol = document.getElementsByName('chiTietDsTvd[' + index + '].idCanBo')[0];   \r\n\t// Ten\r\n\ttenCanBoConTrol = document.getElementsByName('chiTietDsTvd[' + index + '].tenCanBo')[0];\r\n\t// Don vi cong tac (Phong)\r\n\tdonViCongTacControl = document.getElementsByName('chiTietDsTvd[' + index + '].tenPhong')[0];\r\n\t// Chuc vu\r\n\tchucVuConTrol = document.getElementsByName('chiTietDsTvd[' + index + '].chucVu')[0]; \r\n\tshowLovNhanVienWithCQTrucThuoc(maCqt, tenCanBoConTrol); \r\n\t\r\n}\r\nfunction exist(maCanBo){\r\n\tvar allRowDsThanhVien = document.getElementById('bodyDsTvd').childNodes;\r\n\tfor(var i = 0; i< allRowDsThanhVien.length; i++){\r\n\t\tvar rowThanhVien = allRowDsThanhVien[i];\r\n\t\tvar colTenThanhVien = rowThanhVien.cells[1];\r\n\t\tif(maCanBo == colTenThanhVien.childNodes[0].value){\r\n\t\t\twindow.focus();  \r\n\t\t\talert('Cán bộ này đã tồn tại!');\r\n\t\t\treturn true;\r\n\t\t}\t \r\n\t}\r\n\treturn false; \r\n}\r\n\r\n\r\n\r\nfunction xoaThanhVienDoan(){\r\n\tbangDanhSachThanhVienDoan.deleteSelectedRow();\r\n\t\r\n}\r\nfunction selectAllThanhVienDoan(control){\r\n\ttableDsTvd = document.getElementById('tblDsTvd');\r\n\tallRows = tableDsTvd.rows;\r\n\tnumOfColumn = allRows[0].cells.length;\r\n\tfor(i = 2; i< allRows.length; i++)\r\n\t\tallRows[i].cells[numOfColumn - 1].childNodes[0].checked = control.checked;\r\n\tif(control.checked)\r\n\t\ttblDanhSachTVD.numOfCheckedRow = allRows.length - 2;\r\n\telse\r\n\t\ttblDanhSachTVD.numOfCheckedRow = 0;\r\n\t\r\n}\r\nvar thanhVienDoanIds = \"\";\r\nfunction selectThanhVienDoan(checkBox){\r\n\t\r\n}\r\nvar controlIdCanBo;\r\nvar controlTenCanBo; \r\nvar controlIdPhong;\r\nvar controlTenPhong;\r\nvar controlChucVu;\r\n\r\nfunction setThongTinTVD(idCanBo, tenCanBo, chucVu, idPhong, tenPhong){\r\n\tcontrolIdCanBo.value = idCanBo;\r\n\tcontrolTenCanBo.value = tenCanBo;\r\n\tcontrolChucVu.value = chucVu;\r\n\tcontrolIdPhong.value = idPhong;\r\n\tcontrolTenPhong.value = tenPhong;\r\n\t\r\n}\r\nfunction validateDate(){\r\n\treturn true;\r\n}\r\nfunction chonDonVi(control, index){\r\n\t\r\n}\r\n\r\nvar classStyleOfCurrentRow = \"row1\";\r\nvar numOfTvd = 1;\r\nvar bangDanhSachThanhVienDoan = new TableObject('tblDsTvd', true, 'xoaTblThanhVienDoan');\r\nfunction themThanhVienDoan(){\r\n\tbangDanhSachThanhVienDoan.addRow(createNewThanhVienDoanRow());\r\n}\r\nfunction createNewThanhVienDoanRow(){      \r\n\tarrDanhSachThanhVienDoan = new Array(); \r\n\tindex = bangDanhSachThanhVienDoan.numOfRow - 1;\r\n\tarrDanhSachThanhVienDoan[0] = '<input type=\"hidden\" name=\"chiTietDsTvd[' + index + '].idCanBo\">'\r\n\tarrDanhSachThanhVienDoan[0] += '<input type=\"text\" name=\"chiTietDsTvd[' + index + '].tenCanBo\" style=\"width:77%\" class=\"text\" onchange = \"chonThanhVienDoanFromLov(' + index + ')\">'\t\t\t\t\r\n\tarrDanhSachThanhVienDoan[0] += '<Input type=\"button\" value=\"...\" class=\"lovButton\" onclick=\"chonThanhVienDoanFromLov(' + index + ')\">'\r\n\t\r\n\tarrDanhSachThanhVienDoan[1] = '<input type=\"text\" name=\"chiTietDsTvd[' + index + '].tenPhong\" class=\"text1\" style=\"border-bottom:none; width:100%\">'\t\t\t\t\r\n\tarrDanhSachThanhVienDoan[1] += '<input type=\"hidden\" name=\"chiTietDsTvd[' + index + '].idPhong\" value=\"\">'\t\t\t\t\r\n\t\r\n\tarrDanhSachThanhVienDoan[2] = '<input type=\"text\" name=\"chiTietDsTvd[' + index + '].chucVu\" class=\"text1\" style=\"border-bottom:none; width:100%\">'\t\t\t\t\r\n\t\r\n\tarrDanhSachThanhVienDoan[3] = '<select name=\"chiTietDsTvd['+ index + '].chucVuTrongDoan\" styleClass=\"combobox\">'\r\n\tarrDanhSachThanhVienDoan[3] += '<option value=\"Pho doan\">Phó đoàn'\r\n\tarrDanhSachThanhVienDoan[3] += '</option>'\r\n\tarrDanhSachThanhVienDoan[3] += '<option value=\"Thanh vien doan\">Thành viên đoàn'\r\n\tarrDanhSachThanhVienDoan[3] += '</option>'\r\n\tarrDanhSachThanhVienDoan[3] += '</select>'   \r\n\tarrDanhSachThanhVienDoan[4] = '<INPUT type=\"checkbox\" class=\"checkbox\" name=\"selectThanhVienDoan\">' \r\n\treturn arrDanhSachThanhVienDoan;\r\n\t\r\n}\r\nfunction themThanhVienDoanNgoai(){\r\n\tbangDanhSachThanhVienDoan.addRow(createNewThanhVienDoanNgoaiRow());\r\n}\r\nfunction createNewThanhVienDoanNgoaiRow(){      \r\n\tarrDanhSachThanhVienDoan = new Array(); \r\n\tindex = bangDanhSachThanhVienDoan.numOfRow - 1;\r\n\tarrDanhSachThanhVienDoan[0] = '<input type=\"hidden\" name=\"chiTietDsTvd[' + index + '].idCanBo\" value=\"'+Math.uuid(10, 10)+'\">'\r\n\tarrDanhSachThanhVienDoan[0] += '<input type=\"text\" name=\"chiTietDsTvd[' + index + '].tenCanBo\" style=\"width:77%\" class=\"text\">'\t\t\t\t\r\n\t\t\r\n\tarrDanhSachThanhVienDoan[1] = '<input type=\"text\" name=\"chiTietDsTvd[' + index + '].tenPhong\" style=\"border-bottom:none; width:100%\">'\t\t\t\t\r\n\tarrDanhSachThanhVienDoan[1] += '<input type=\"hidden\" name=\"chiTietDsTvd[' + index + '].idPhong\" value=\"999999999\">'\t\t\t\t\r\n\t\r\n\tarrDanhSachThanhVienDoan[2] = '<input type=\"text\" name=\"chiTietDsTvd[' + index + '].chucVu\" style=\"border-bottom:none; width:100%\">'\t\t\t\t\r\n\t\r\n\tarrDanhSachThanhVienDoan[3] = '<select name=\"chiTietDsTvd['+ index + '].chucVuTrongDoan\" styleClass=\"combobox\">'\r\n\tarrDanhSachThanhVienDoan[3] += '<option value=\"Pho doan\">Phó đoàn'\r\n\tarrDanhSachThanhVienDoan[3] += '</option>'\r\n\tarrDanhSachThanhVienDoan[3] += '<option value=\"Thanh vien doan\">Thành viên đoàn'\r\n\tarrDanhSachThanhVienDoan[3] += '</option>'\r\n\tarrDanhSachThanhVienDoan[3] += '</select>'   \r\n\tarrDanhSachThanhVienDoan[4] = '<INPUT type=\"checkbox\" class=\"checkbox\" name=\"selectThanhVienDoan\">' \r\n\treturn arrDanhSachThanhVienDoan;\r\n\t\r\n}\r\nfunction validateThanhVienDoan(){\r\n\tif(!isRequired(document.getElementsByName('noiLapDsTvd')[0]))\r\n\t\treturn false;\r\n\tif(!isRequired(document.getElementsByName('ngayLapDsTvd')[0]))\r\n\t\treturn false; \r\n\tif(!isEmpty(document.getElementsByName('noiPheDuyetDsTvd')[0].value)){\r\n\t\tif(isEmpty(document.getElementsByName('ngayPheDuyetDsTvd')[0].value)){\r\n\t\t\talert('Bạn phải nhập nơi phê duyệt cùng với ngày phê duyệt!');\r\n\t\t\tdocument.getElementsByName('ngayPheDuyetDsTvd')[0].focus();\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\t\t\r\n\t}\r\n\tif(!isEmpty(document.getElementsByName('ngayPheDuyetDsTvd')[0].value)){\r\n\tif(isEmpty(document.getElementsByName('noiPheDuyetDsTvd')[0].value)){\r\n\t\talert('Bạn phải nhập nơi phê duyệt cùng với ngày phê duyệt!');\r\n\t\tdocument.getElementsByName('noiPheDuyetDsTvd')[0].focus();\r\n\t\treturn false;\r\n\t}\r\n\t\t\t\r\n\t}\r\n\t//if(!isRequired(document.getElementsByName('noiPheDuyetDsTvd')[0]))\r\n\t\t//return false;\r\n\t//if(!isRequired(document.getElementsByName('ngayPheDuyetDsTvd')[0]))\r\n\t\t//return false;\r\n\tif(!compareDate(document.getElementsByName('ngayLapDsTvd')[0], document.getElementsByName('ngayPheDuyetDsTvd')[0], 'Ngày phê duyệt phải bằng hoặc sau ngày lập!')){\r\n\t\tdocument.getElementsByName('ngayPheDuyetDsTvd')[0].focus();\r\n\t\treturn false;\r\n\t}\r\n\tif(!isRequired(document.getElementsByName('vanBanQuyDinhCnangNvuQdTvd')[0]))\r\n\t\treturn false;\r\n\tif(!validateDsThanhVien()) \r\n\t\treturn false; \r\n\treturn true;\r\n}\r\nfunction checkRequired(){\r\nif($('[name=\"noiPheDuyetDsTvd\"]')[0].value==\"\"){\r\n\talert(\"Phải nhập nơi phê duyệt \");\r\n\t$('[name=\"noiPheDuyetDsTvd\"]')[0].focus();\r\n\treturn true;\r\n}else\r\n\tif($('[name=\"ngayPheDuyetDsTvd\"]')[0].value==\"\")\r\n\t{\r\n\t\talert(\"Phải nhập ngày phê duyệt \");\r\n\t\t$('[name=\"ngayPheDuyetDsTvd\"]')[0].focus();\r\n\t\treturn true;\r\n\t}\r\n\telse return false;\r\n}\r\nfunction validateDsThanhVien(){\r\n\ttblDanhSachTVD = document.getElementById('tblDsTvd');\r\n\tfor(var i = 2; i < tblDanhSachTVD.rows.length; i++){\r\n\t\tif(!isRequired(document.getElementsByName('chiTietDsTvd[' + eval(i-1) + '].tenCanBo')[0]))\r\n\t\t\treturn false;\r\n\t\tif(!isRequired(document.getElementsByName('chiTietDsTvd[' + eval(i-1) + '].tenPhong')[0]))\r\n\t\t\treturn false;\r\n\t}\r\n\treturn true;\r\n}\r\nfunction saveThanhVienDoan(){\r\n\tfor(i = 0; i< document.forms.length; i++){\r\n\t\tif(document.forms[i].action == 'chuan_bi_tien_hanh.do?method=save&type=tvd')\r\n\t\t\tdocument.forms[i].submit();\r\n\t}\r\n}\r\n\t\r\n\t\r\n</script>");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(30,99);to=(33,30)]
                                                                                              out.write("</fieldset>    \r\n</DIV>\r\n<DIV id=\"tabQuyetDinh\">\r\n<fieldset style=\"width: 100%\">");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(0,33);to=(1,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(1,56);to=(2,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(2,58);to=(3,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(3,56);to=(4,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 5,0-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 5,100  LineMapIndex:181
                                                                                              /* ------  html:form ------ */
                                                                                              org.apache.struts.taglib.html.FormTag _jspx_th_html_form_3 = new org.apache.struts.taglib.html.FormTag();
                                                                                              _jspx_th_html_form_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_form_3.setParent(null);
                                                                                              _jspx_th_html_form_3.setAction("chuan_bi_tien_hanh.do?method=save&type=qd");
                                                                                              _jspx_th_html_form_3.setMethod("POST");
                                                                                              _jspx_th_html_form_3.setStyleId("quyetDinhForm");
                                                                                              _jspxTagObjects.push(_jspx_th_html_form_3);
                                                                                              int _jspx_eval_html_form_3 = _jspx_th_html_form_3.doStartTag();
                                                                                              if (_jspx_eval_html_form_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(4,100);to=(5,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 6,1-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 6,35  LineMapIndex:182
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_2 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_2.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_2.setParent(_jspx_th_html_form_3);
                                                                                              _jspx_th_logic_notPresent_2.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_2);
                                                                                              int _jspx_eval_logic_notPresent_2 = _jspx_th_logic_notPresent_2.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(5,35);to=(6,2)]
                                                                                              out.write("\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 7,2-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 7,52  LineMapIndex:183
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_3 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_3.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_3.setParent(_jspx_th_logic_notPresent_2);
                                                                                              _jspx_th_logic_notPresent_3.setName("da_co_lich_trinh_du_kien");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_3);
                                                                                              int _jspx_eval_logic_notPresent_3 = _jspx_th_logic_notPresent_3.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(6,52);to=(17,2)]
                                                                                              out.write("\r\n\t\t\t<fieldset style=\"margin: 0\"><legend> Nội dung kiểm tra </legend>\r\n\t\t\t<table>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Không thay đổi nội dung Kiểm tra</td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" width=\"80%\"><input type=\"checkbox\" id=\"chkBoxThayDoiNoiDungKt\" onclick=\"document.getElementById('lnkChinhSuaNoiDung').style.display=this.checked?'none':'inline'\">&nbsp; <A class=\"linkCnPhu\" href=\"#\" onclick=\"chinhSuaNoiDungTtkt()\" id=\"lnkChinhSuaNoiDung\"><font\r\n\t\t\t\t\t\tcolor=\"blue\">Thay đổi nội dung Kiểm tra</font></A></td>\r\n\t\t\t\t</tr>\r\n\t\t\t</table>\r\n\t\t\t</fieldset>\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 18,2-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 18,21  LineMapIndex:184
                                                                                              } while (_jspx_th_logic_notPresent_3.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(17,21);to=(18,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 19,1-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 19,20  LineMapIndex:185
                                                                                              } while (_jspx_th_logic_notPresent_2.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(18,20);to=(23,32)]
                                                                                              out.write("\r\n\t<table align=\"center\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Số quyết định</td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 24,32-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 24,84  LineMapIndex:186
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_13 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_13.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_13.setParent(_jspx_th_html_form_3);
                                                                                              _jspx_th_html_text_13.setStyleClass("text");
                                                                                              _jspx_th_html_text_13.setProperty("soQuyetDinh");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_13);
                                                                                              int _jspx_eval_html_text_13 = _jspx_th_html_text_13.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 24,32-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 24,96  LineMapIndex:187
                                                                                              if (_jspx_th_html_text_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(23,96);to=(26,32)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\" width=\"19%\">Địa điểm ra quyết định</td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 27,32-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 27,91  LineMapIndex:188
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_14 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_14.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_14.setParent(_jspx_th_html_form_3);
                                                                                              _jspx_th_html_text_14.setStyleClass("text");
                                                                                              _jspx_th_html_text_14.setProperty("diaDiemRaQuyetDinh");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_14);
                                                                                              int _jspx_eval_html_text_14 = _jspx_th_html_text_14.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 27,32-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 27,103  LineMapIndex:189
                                                                                              if (_jspx_th_html_text_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(26,103);to=(31,32)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Ngày ra quyết định</td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 32,32-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 32,194  LineMapIndex:190
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_15 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_15.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_15.setParent(_jspx_th_html_form_3);
                                                                                              _jspx_th_html_text_15.setOnkeypress("return formatDate(event, this)");
                                                                                              _jspx_th_html_text_15.setOnblur("if(!isDate(this)) return;validateDateRequired(this);");
                                                                                              _jspx_th_html_text_15.setStyleClass("text");
                                                                                              _jspx_th_html_text_15.setProperty("ngayRaQuyetDnh");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_15);
                                                                                              int _jspx_eval_html_text_15 = _jspx_th_html_text_15.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 32,32-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 32,206  LineMapIndex:191
                                                                                              if (_jspx_th_html_text_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(31,206);to=(39,19)]
                                                                                              out.write("</td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Văn bản quy định chức năng nhiệm vụ<font color=red>*</font></td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 40,19-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 40,109  LineMapIndex:192
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_4 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_4.setParent(_jspx_th_html_form_3);
                                                                                              _jspx_th_html_select_4.setProperty("vanBanQuyDinhCnangNvuQd");
                                                                                              _jspx_th_html_select_4.setStyle("width: 100%");
                                                                                              _jspx_th_html_select_4.setStyleClass("combobox");
                                                                                              _jspxTagObjects.push(_jspx_th_html_select_4);
                                                                                              int _jspx_eval_html_select_4 = _jspx_th_html_select_4.doStartTag();
                                                                                              if (_jspx_eval_html_select_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_select_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_select_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_select_4.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(39,109);to=(40,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 41,4-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 41,26  LineMapIndex:193
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_8 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_8.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_8.setParent(_jspx_th_html_select_4);
                                                                                              _jspx_th_html_option_8.setValue("");
                                                                                              _jspxTagObjects.push(_jspx_th_html_option_8);
                                                                                              int _jspx_eval_html_option_8 = _jspx_th_html_option_8.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 41,4-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 41,40  LineMapIndex:194
                                                                                              if (_jspx_th_html_option_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(40,40);to=(41,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 42,4-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 42,78  LineMapIndex:195
                                                                                              /* ------  html:options ------ */
                                                                                              org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_1 = new org.apache.struts.taglib.html.OptionsTag();
                                                                                              _jspx_th_html_options_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_options_1.setParent(_jspx_th_html_select_4);
                                                                                              _jspx_th_html_options_1.setCollection("dmtly");
                                                                                              _jspx_th_html_options_1.setProperty("value");
                                                                                              _jspx_th_html_options_1.setLabelProperty("label");
                                                                                              _jspxTagObjects.push(_jspx_th_html_options_1);
                                                                                              int _jspx_eval_html_options_1 = _jspx_th_html_options_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 42,4-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 42,78  LineMapIndex:196
                                                                                              if (_jspx_th_html_options_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(41,78);to=(42,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 43,3-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 43,17  LineMapIndex:197
                                                                                              } while (_jspx_th_html_select_4.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_select_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_select_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(42,17);to=(44,2)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 45,2-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 45,37  LineMapIndex:198
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_2 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_2.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_2.setParent(_jspx_th_html_form_3);
                                                                                              _jspx_th_logic_present_2.setName("showVbChiDao");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_2);
                                                                                              int _jspx_eval_logic_present_2 = _jspx_th_logic_present_2.doStartTag();
                                                                                              if (_jspx_eval_logic_present_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(44,37);to=(48,20)]
                                                                                              out.write("\r\n\t\t\t<tr>\r\n\t\t\t\t<td align=\"right\" width=\"19%\">Văn bản chỉ đạo/quyết định của người có thẩm quyền</td>\r\n\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t<td colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 49,20-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 49,124  LineMapIndex:199
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_1 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_1.setParent(_jspx_th_logic_present_2);
                                                                                              _jspx_th_html_textarea_1.setProperty("vanBanKeHoach");
                                                                                              _jspx_th_html_textarea_1.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_1.setStyleClass("textareaTitle");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_1);
                                                                                              int _jspx_eval_html_textarea_1 = _jspx_th_html_textarea_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 49,20-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 49,140  LineMapIndex:200
                                                                                              if (_jspx_th_html_textarea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(48,140);to=(50,2)]
                                                                                              out.write("</td>\r\n\t\t\t</tr>\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 51,2-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 51,18  LineMapIndex:201
                                                                                              } while (_jspx_th_logic_present_2.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(50,18);to=(57,52)]
                                                                                              out.write("\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Người chỉ đạo giám sát</td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">\r\n\t\t\t<table style=\"margin: 0\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"left\" width=\"90%\" style=\"margin: 0\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 58,52-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 58,99  LineMapIndex:202
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_12 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_12.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_12.setParent(_jspx_th_html_form_3);
                                                                                              _jspx_th_html_hidden_12.setProperty("idNguoiChiDaoGiamSat");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_12);
                                                                                              int _jspx_eval_html_hidden_12 = _jspx_th_html_hidden_12.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 58,52-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 58,99  LineMapIndex:203
                                                                                              if (_jspx_th_html_hidden_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 58,99-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 58,216  LineMapIndex:204
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_16 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_16.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_16.setParent(_jspx_th_html_form_3);
                                                                                              _jspx_th_html_text_16.setProperty("tenNguoiChiDaoGiamSat");
                                                                                              _jspx_th_html_text_16.setStyleClass("text");
                                                                                              _jspx_th_html_text_16.setOnchange("chonNguoiChiDaoGiamSat()");
                                                                                              _jspx_th_html_text_16.setStyle("width:100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_16);
                                                                                              int _jspx_eval_html_text_16 = _jspx_th_html_text_16.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 58,52-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 58,228  LineMapIndex:205
                                                                                              if (_jspx_th_html_text_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(57,228);to=(64,32)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t<td align=\"left\" width=\"10%\" style=\"margin: 0\"><INPUT type=\"button\" onclick=\"chonNguoiChiDaoGiamSat()\" value=\"...\" class=\"lovButton\"></td>\r\n\t\t\t\t</tr>\r\n\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t\t<td align=\"right\" width=\"19%\">Chức vụ</td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 65,32-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 65,97  LineMapIndex:206
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_17 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_17.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_17.setParent(_jspx_th_html_form_3);
                                                                                              _jspx_th_html_text_17.setProperty("chucVuNguoiChiDaoGiamSat");
                                                                                              _jspx_th_html_text_17.setStyleClass("text");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_17);
                                                                                              int _jspx_eval_html_text_17 = _jspx_th_html_text_17.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 65,32-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 65,109  LineMapIndex:207
                                                                                              if (_jspx_th_html_text_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(64,109);to=(69,19)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Thủ trưởng các đơn vị liên quan</td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 70,19-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 70,132  LineMapIndex:208
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_2 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_2.setParent(_jspx_th_html_form_3);
                                                                                              _jspx_th_html_textarea_2.setProperty("thuTruongCacDvLienQuan");
                                                                                              _jspx_th_html_textarea_2.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_2.setStyleClass("textareaTitle");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_2);
                                                                                              int _jspx_eval_html_textarea_2 = _jspx_th_html_textarea_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 70,19-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 70,148  LineMapIndex:209
                                                                                              if (_jspx_th_html_textarea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(69,148);to=(80,1)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td align=\"right\" width=\"25%\"><INPUT type=\"button\" class=\"button1\" onclick=\"inQuyetDinh()\" value=\"In quyết định\"></td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 81,1-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 81,39  LineMapIndex:210
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_13 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_13.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_13.setParent(_jspx_th_html_form_3);
                                                                                              _jspx_th_html_hidden_13.setProperty("idQuyetDinh");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_13);
                                                                                              int _jspx_eval_html_hidden_13 = _jspx_th_html_hidden_13.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 81,1-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 81,39  LineMapIndex:211
                                                                                              if (_jspx_th_html_hidden_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(80,39);to=(81,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 82,1-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 82,45  LineMapIndex:212
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_14 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_14.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_14.setParent(_jspx_th_html_form_3);
                                                                                              _jspx_th_html_hidden_14.setProperty("isChangeQuyetDinh");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_14);
                                                                                              int _jspx_eval_html_hidden_14 = _jspx_th_html_hidden_14.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 82,1-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 82,45  LineMapIndex:213
                                                                                              if (_jspx_th_html_hidden_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(81,45);to=(82,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 83,0-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 83,12  LineMapIndex:214
                                                                                              } while (_jspx_th_html_form_3.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_html_form_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(82,12);to=(115,3)]
                                                                                              out.write("\r\n<script language=\"javascript\">\r\n\tfunction chonNguoiChiDaoGiamSat(){\r\n\t\tlovType = 'chonNguoiChiDaoDamSat'\r\n\t\tidCanBoConTrol = document.getElementsByName('idNguoiChiDaoGiamSat')[0];\r\n\t\t// Ten \r\n\t\ttenCanBoConTrol = document.getElementsByName('tenNguoiChiDaoGiamSat')[0];\r\n\t\t\r\n\t\t// Chuc vu\r\n\t\tchucVuConTrol = document.getElementsByName('chucVuNguoiChiDaoGiamSat')[0];\r\n\t\tshowLovNhanVien(maCqt, tenCanBoConTrol);\t\r\n\t\t\r\n\t}     \r\n\tfunction inQuyetDinh(){\r\n\t\tif(!validateQuyetDinh())               \r\n\t\t\treturn;\t\r\n\t\t\t\r\n\t\tvar thongTinIn = \"\";\r\n\t\tvar qdForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd');\t \r\n\t\tfor(var i = 0; i< qdForm.elements.length; i++){\r\n\t\t\tif(qdForm.elements[i].name != null && qdForm.elements[i].name != '' && qdForm.elements[i].value != null && qdForm.elements[i].value != '')\r\n\t\t\tthongTinIn += \"&\" + qdForm.elements[i].name + \"=\" + encodeURIComponent(qdForm.elements[i].value);\r\n\t\t}\t\t\r\n\t\t//thongTinIn = thongTinIn.substring(0, thongTinIn.length - 1);  \r\n\t\t//window.open('chuan_bi_tien_hanh.do?method=in&type=qd&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value + '&' + thongTinIn);\r\n\t\tvar printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd'); \r\n\t\tprintfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=qd&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value + thongTinIn;\r\n\t\tprintfForm.submit();\r\n\t\tprintfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd'; \r\n\t}\r\n\tfunction ngayRaQuyetDnh(){\r\n\t} \r\n\tfunction validateQuyetDinh(){\t\t\r\n\t  ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 116,3-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 116,53  LineMapIndex:215
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_4 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_4.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_4.setParent(null);
                                                                                              _jspx_th_logic_notPresent_4.setName("da_co_lich_trinh_du_kien");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_4);
                                                                                              int _jspx_eval_logic_notPresent_4 = _jspx_th_logic_notPresent_4.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(115,53);to=(127,3)]
                                                                                              out.write("\t\t\r\n\t\tif(!isEmpty(document.getElementsByName('soQuyetDinh')[0].value)){\r\n\t\t\tif(!document.getElementById('chkBoxThayDoiNoiDungKt').checked){\r\n\t\t\t\talert('Bạn phải chắc chắn Không thay đổi nội dung Kiểm tra trước khi ra quyết định!');\r\n\t\t\t\tdocument.getElementById('chkBoxThayDoiNoiDungKt').focus();\r\n\t\t\t\treturn false;\r\n\t\t\t}\r\n\t\t\tif(!isRequired(document.getElementsByName('diaDiemRaQuyetDinh')[0], 'Phải nhập địa điểm ra quyết định cùng với số quyết định!'))\r\n\t\t\t\treturn false;  \r\n\t\t\tif(!isRequired(document.getElementsByName('ngayRaQuyetDnh')[0], 'Phải nhập ngày ra quyết định cùng với số quyết định!'))\r\n\t\t\t\treturn false; \r\n\t\t}\r\n\t  ");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 128,3-"/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp" 128,22  LineMapIndex:216
                                                                                              } while (_jspx_th_logic_notPresent_4.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp";from=(127,22);to=(145,0)]
                                                                                              out.write(" \t\t\r\n\t\t\r\n\t\tif(!isRequired(document.getElementsByName('vanBanQuyDinhCnangNvuQd')[0])) \r\n\t\t\treturn false;\r\n\t\t//if(!isRequired(document.getElementsByName('tenNguoiChiDaoGiamSat')[0]))\r\n\t\t\t//return false;\r\n\t\t//if(!isRequired(document.getElementsByName('chucVuNguoiChiDaoGiamSat')[0]))\r\n\t\t\t//return false;\r\n\t\t\r\n\t\t\r\n\t\t\t\r\n\t\treturn true;\r\n\t}\r\n\tfunction chinhSuaNoiDungTtkt(){\t\t\r\n\t\twindow.open('cuoc_ttkt.do?method=edit&cuocTtktId=' + document.getElementsByName('idCuocTtkt')[0].value + '&thoiDiem=raQuyetDinh').focus();\r\n\t}\r\n\t\r\n</script>\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(33,95);to=(36,30)]
                                                                                              out.write("</fieldset>\r\n</DIV>\r\n<DIV id=\"tabKH\">\r\n<fieldset style=\"width: 100%\">");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(0,31);to=(1,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(1,56);to=(2,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(2,58);to=(3,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(3,56);to=(4,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 5,0-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 5,106  LineMapIndex:217
                                                                                              /* ------  html:form ------ */
                                                                                              org.apache.struts.taglib.html.FormTag _jspx_th_html_form_4 = new org.apache.struts.taglib.html.FormTag();
                                                                                              _jspx_th_html_form_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_form_4.setParent(null);
                                                                                              _jspx_th_html_form_4.setAction("chuan_bi_tien_hanh.do?method=save&type=kh");
                                                                                              _jspx_th_html_form_4.setMethod("POST");
                                                                                              _jspx_th_html_form_4.setEnctype("multipart/form-data");
                                                                                              _jspxTagObjects.push(_jspx_th_html_form_4);
                                                                                              int _jspx_eval_html_form_4 = _jspx_th_html_form_4.doStartTag();
                                                                                              if (_jspx_eval_html_form_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(4,106);to=(14,34)]
                                                                                              out.write("\r\n\t<div id=\"getReturnKh\" style=\"display: none;\"></div>\r\n\t<table align=\"center\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t<fieldset><legend>Thông tin chung</legend>\r\n\t\t\t<table width=\"100%\">\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Địa điểm lập <font color=red>*</font></td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 15,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 15,92  LineMapIndex:218
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_18 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_18.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_18.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_text_18.setStyleClass("text");
                                                                                              _jspx_th_html_text_18.setProperty("diaDiemLapKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_18);
                                                                                              int _jspx_eval_html_text_18 = _jspx_th_html_text_18.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 15,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 15,104  LineMapIndex:219
                                                                                              if (_jspx_th_html_text_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(14,104);to=(17,34)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Ngày lập <font color=red>*</font></td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 18,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 18,194  LineMapIndex:220
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_19 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_19.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_19.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_text_19.setStyleClass("text");
                                                                                              _jspx_th_html_text_19.setOnkeypress("return formatDate(event, this)");
                                                                                              _jspx_th_html_text_19.setOnblur("if(!isDate(this)) return; validateNgayLapKeHoach();");
                                                                                              _jspx_th_html_text_19.setProperty("ngayLapKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_19);
                                                                                              int _jspx_eval_html_text_19 = _jspx_th_html_text_19.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 18,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 18,206  LineMapIndex:221
                                                                                              if (_jspx_th_html_text_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(17,206);to=(22,34)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Nơi phê duyệt</td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 23,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 23,93  LineMapIndex:222
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_20 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_20.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_20.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_text_20.setStyleClass("text");
                                                                                              _jspx_th_html_text_20.setProperty("noiPheDuyetKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_20);
                                                                                              int _jspx_eval_html_text_20 = _jspx_th_html_text_20.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 23,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 23,105  LineMapIndex:223
                                                                                              if (_jspx_th_html_text_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(22,105);to=(25,34)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Ngày phê duyệt</td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 26,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 26,202  LineMapIndex:224
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_21 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_21.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_21.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_text_21.setStyleClass("text");
                                                                                              _jspx_th_html_text_21.setOnkeypress("return formatDate(event, this)");
                                                                                              _jspx_th_html_text_21.setOnblur("if(!isDate(this)) return;  validateNgayDuyetKeHoach();");
                                                                                              _jspx_th_html_text_21.setProperty("ngayPheDuyetKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_21);
                                                                                              int _jspx_eval_html_text_21 = _jspx_th_html_text_21.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 26,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 26,214  LineMapIndex:225
                                                                                              if (_jspx_th_html_text_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(25,214);to=(31,34)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<!--Y kien phe duyet-->\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Ý kiến phê duyệt</td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 32,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 32,160  LineMapIndex:226
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_3 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_3.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_textarea_3.setStyleClass("textareaTitle");
                                                                                              _jspx_th_html_textarea_3.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_3.setStyle("width: 100%");
                                                                                              _jspx_th_html_textarea_3.setProperty("ykienPheDuyetKh");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_3);
                                                                                              int _jspx_eval_html_textarea_3 = _jspx_th_html_textarea_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 32,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 32,176  LineMapIndex:227
                                                                                              if (_jspx_th_html_textarea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(31,176);to=(37,34)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<!--Muc dich-->\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Mục đích</td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 38,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 38,152  LineMapIndex:228
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_4 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_4.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_textarea_4.setStyleClass("textareaTitle");
                                                                                              _jspx_th_html_textarea_4.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_4.setStyle("width: 100%");
                                                                                              _jspx_th_html_textarea_4.setProperty("mucDich");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_4);
                                                                                              int _jspx_eval_html_textarea_4 = _jspx_th_html_textarea_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 38,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 38,168  LineMapIndex:229
                                                                                              if (_jspx_th_html_textarea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(37,168);to=(43,34)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<!--Yeu cau-->\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Yêu cầu</td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 44,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 44,151  LineMapIndex:230
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_5 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_5.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_textarea_5.setStyleClass("textareaTitle");
                                                                                              _jspx_th_html_textarea_5.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_5.setStyle("width: 100%");
                                                                                              _jspx_th_html_textarea_5.setProperty("yeuCau");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_5);
                                                                                              int _jspx_eval_html_textarea_5 = _jspx_th_html_textarea_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 44,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 44,167  LineMapIndex:231
                                                                                              if (_jspx_th_html_textarea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(43,167);to=(49,34)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<!--Noi dung-->\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Nội dung</td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 50,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 50,152  LineMapIndex:232
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_6 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_6.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_textarea_6.setStyleClass("textareaTitle");
                                                                                              _jspx_th_html_textarea_6.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_6.setStyle("width: 100%");
                                                                                              _jspx_th_html_textarea_6.setProperty("noiDung");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_6);
                                                                                              int _jspx_eval_html_textarea_6 = _jspx_th_html_textarea_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 50,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 50,168  LineMapIndex:233
                                                                                              if (_jspx_th_html_textarea_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(49,168);to=(55,34)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<!--Phuong phap tien hanh-->\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Phương pháp tiến hành</td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 56,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 56,163  LineMapIndex:234
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_7 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_7.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_7.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_textarea_7.setStyleClass("textareaTitle");
                                                                                              _jspx_th_html_textarea_7.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_7.setStyle("width: 100%");
                                                                                              _jspx_th_html_textarea_7.setProperty("phuongPhapTienHanh");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_7);
                                                                                              int _jspx_eval_html_textarea_7 = _jspx_th_html_textarea_7.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 56,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 56,179  LineMapIndex:235
                                                                                              if (_jspx_th_html_textarea_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(55,179);to=(69,34)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t</table>\t\r\n\t\t\t</fieldset>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t<fieldset style=\"margin: 0\"><legend>Tổ chức thực hiện</legend>\r\n\t\t\t<table width=\"100%\">\r\n\t\t\t\t<!--To chuc thuc hien-->\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Tiến độ thực hiện</td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 70,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 70,159  LineMapIndex:236
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_8 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_8.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_8.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_textarea_8.setStyleClass("textareaTitle");
                                                                                              _jspx_th_html_textarea_8.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_8.setStyle("width: 100%");
                                                                                              _jspx_th_html_textarea_8.setProperty("toChucThucHien");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_8);
                                                                                              int _jspx_eval_html_textarea_8 = _jspx_th_html_textarea_8.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 70,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 70,175  LineMapIndex:237
                                                                                              if (_jspx_th_html_textarea_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(69,175);to=(75,34)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<!--Che do thong tin bao cao-->\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Chế độ thông tin báo cáo</td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 76,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 76,164  LineMapIndex:238
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_9 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_9.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_9.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_textarea_9.setStyleClass("textareaTitle");
                                                                                              _jspx_th_html_textarea_9.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_9.setStyle("width: 100%");
                                                                                              _jspx_th_html_textarea_9.setProperty("cheDoThongTinBaoCao");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_9);
                                                                                              int _jspx_eval_html_textarea_9 = _jspx_th_html_textarea_9.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 76,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 76,180  LineMapIndex:239
                                                                                              if (_jspx_th_html_textarea_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(75,180);to=(81,34)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<!--Dieu kien vat chat dam bao-->\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Điều kiện vật chất đảm bảo</td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 82,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 82,166  LineMapIndex:240
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_10 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_10.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_10.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_textarea_10.setStyleClass("textareaTitle");
                                                                                              _jspx_th_html_textarea_10.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_10.setStyle("width: 100%");
                                                                                              _jspx_th_html_textarea_10.setProperty("dieuKienVatChatDamBao");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_10);
                                                                                              int _jspx_eval_html_textarea_10 = _jspx_th_html_textarea_10.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 82,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 82,182  LineMapIndex:241
                                                                                              if (_jspx_th_html_textarea_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(81,182);to=(87,34)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<!--Nhung dieu kien khac-->\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"19%\">Những điều kiện khác</td>\r\n\t\t\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t\t\t<td align=\"left\" colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 88,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 88,162  LineMapIndex:242
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_11 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_11.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_11.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_textarea_11.setStyleClass("textareaTitle");
                                                                                              _jspx_th_html_textarea_11.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_11.setStyle("width: 100%");
                                                                                              _jspx_th_html_textarea_11.setProperty("nhungDieuKienKhac");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_11);
                                                                                              int _jspx_eval_html_textarea_11 = _jspx_th_html_textarea_11.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 88,34-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 88,178  LineMapIndex:243
                                                                                              if (_jspx_th_html_textarea_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(87,178);to=(101,45)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t</table>\r\n\t\t\t</fieldset>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\"><INPUT type=\"button\" class=\"button1\" value=\"In kế hoạch\" onclick=\"inKeHoach()\"></td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<table width=\"100%\">\r\n\t\t<!--<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Đính kèm file</td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" colspan=\"4\" width=\"100%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 102,45-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 102,112  LineMapIndex:244
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_3 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_3.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_3.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_logic_present_3.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_present_3.setProperty("maFileKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_3);
                                                                                              int _jspx_eval_logic_present_3 = _jspx_th_logic_present_3.doStartTag();
                                                                                              if (_jspx_eval_logic_present_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(101,112);to=(103,3)]
                                                                                              out.write("\r\n\t\t\t\t<input type=\"checkbox\" onclick=\"checkAttackKeHoach()\" checked id=\"checkAttackFile\" />\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 104,3-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 104,19  LineMapIndex:245
                                                                                              } while (_jspx_th_logic_present_3.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(103,19);to=(103,20)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 104,20-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 104,90  LineMapIndex:246
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_5 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_5.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_5.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_logic_notPresent_5.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_notPresent_5.setProperty("maFileKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_5);
                                                                                              int _jspx_eval_logic_notPresent_5 = _jspx_th_logic_notPresent_5.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(103,90);to=(105,3)]
                                                                                              out.write("\r\n\t\t\t\t<input type=\"checkbox\" onclick=\"checkAttackKeHoach()\" id=\"checkAttackFile\" />\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 106,3-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 106,22  LineMapIndex:247
                                                                                              } while (_jspx_th_logic_notPresent_5.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(105,22);to=(111,4)]
                                                                                              out.write("</td>\r\n\t\t</tr> -->\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"6\" width=\"100%\">\r\n\t\t\t<fieldset>\r\n\t\t\t<table width=\"100%\">\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 112,4-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 112,38  LineMapIndex:248
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_6 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_6.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_6.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_logic_notPresent_6.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_6);
                                                                                              int _jspx_eval_logic_notPresent_6 = _jspx_th_logic_notPresent_6.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(111,38);to=(117,4)]
                                                                                              out.write("\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=\"right\" width=\"49%\">Download biểu mẫu</td>\r\n\t\t\t\t\t\t<td style=\"width: 2%; min-width: 5px;\"></td>\r\n\t\t\t\t\t\t<td align=\"left\" width=\"49%\"><A href=\"filemau/TTNB12.doc\"> <font color=blue>Download File</font> </A></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 118,4-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 118,23  LineMapIndex:249
                                                                                              } while (_jspx_th_logic_notPresent_6.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(117,23);to=(118,8)]
                                                                                              out.write("\r\n\t\t\t\t<!--");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 119,8-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 119,75  LineMapIndex:250
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_4 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_4.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_4.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_logic_present_4.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_present_4.setProperty("maFileKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_4);
                                                                                              int _jspx_eval_logic_present_4 = _jspx_th_logic_present_4.doStartTag();
                                                                                              if (_jspx_eval_logic_present_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(118,75);to=(124,4)]
                                                                                              out.write("\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=\"right\" width=\"49%\">File đính kèm</td>\r\n\t\t\t\t\t\t<td style=\"width: 2%; min-width: 5px;\"></td>\r\n\t\t\t\t\t\t<td align=\"left\" width=\"49%\"><a href=\"#\" onclick=\"window.open('UploadAction.do?method=downLoadKeHoachTtkt&ma_file='+document.getElementsByName('maFileKeHoach')[0].value).focus()\"><font color=\"blue\">Kế hoạch Thanh tra Kiểm tra</font></a></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 125,4-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 125,20  LineMapIndex:251
                                                                                              } while (_jspx_th_logic_present_4.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(124,20);to=(125,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 126,4-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 126,38  LineMapIndex:252
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_7 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_7.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_7.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_logic_notPresent_7.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_7);
                                                                                              int _jspx_eval_logic_notPresent_7 = _jspx_th_logic_notPresent_7.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(125,38);to=(127,36)]
                                                                                              out.write("\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=\"right\" width=\"49%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 128,36-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 128,103  LineMapIndex:253
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_5 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_5.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_5.setParent(_jspx_th_logic_notPresent_7);
                                                                                              _jspx_th_logic_present_5.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_present_5.setProperty("maFileKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_5);
                                                                                              int _jspx_eval_logic_present_5 = _jspx_th_logic_present_5.doStartTag();
                                                                                              if (_jspx_eval_logic_present_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(127,103);to=(129,8)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t\t\tCập nhật file đính kèm\r\n\t\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 130,8-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 130,24  LineMapIndex:254
                                                                                              } while (_jspx_th_logic_present_5.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(129,24);to=(129,25)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 130,25-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 130,95  LineMapIndex:255
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_8 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_8.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_8.setParent(_jspx_th_logic_notPresent_7);
                                                                                              _jspx_th_logic_notPresent_8.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_notPresent_8.setProperty("maFileKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_8);
                                                                                              int _jspx_eval_logic_notPresent_8 = _jspx_th_logic_notPresent_8.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(129,95);to=(131,8)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t\t\tFile đính kèm\r\n\t\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 132,8-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 132,27  LineMapIndex:256
                                                                                              } while (_jspx_th_logic_notPresent_8.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(131,27);to=(133,35)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<td style=\"width: 2%; min-width: 5px;\"></td>\r\n\t\t\t\t\t\t<td align=\"left\" width=\"49%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 134,35-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 134,103  LineMapIndex:257
                                                                                              /* ------  html:file ------ */
                                                                                              org.apache.struts.taglib.html.FileTag _jspx_th_html_file_1 = new org.apache.struts.taglib.html.FileTag();
                                                                                              _jspx_th_html_file_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_file_1.setParent(_jspx_th_logic_notPresent_7);
                                                                                              _jspx_th_html_file_1.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_file_1.setProperty("fileDinhKemKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_html_file_1);
                                                                                              int _jspx_eval_html_file_1 = _jspx_th_html_file_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 134,35-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 134,115  LineMapIndex:258
                                                                                              if (_jspx_th_html_file_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(133,115);to=(135,4)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 136,4-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 136,23  LineMapIndex:259
                                                                                              } while (_jspx_th_logic_notPresent_7.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(135,23);to=(146,1)]
                                                                                              out.write("-->\r\n\t\t\t<tr>\r\n\t\t\t\t<td align=\"right\" width=\"49%\">File kế hoạch</td>\r\n\t\t\t\t<td style=\"width: 2%; min-width: 5px;\"></td>\r\n\t\t\t\t<td align=\"left\" width=\"49%\"><A href=\"#\" onclick=\"openUploadFile();\"><font color=blue>File \"kế hoạch\" đính kèm</font></A></td>\r\n\t\t\t</tr>\t\r\n\t\t\t</table>\r\n\t\t\t</fieldset>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 147,1-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 147,37  LineMapIndex:260
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_15 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_15.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_15.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_hidden_15.setProperty("idKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_15);
                                                                                              int _jspx_eval_html_hidden_15 = _jspx_th_html_hidden_15.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 147,1-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 147,37  LineMapIndex:261
                                                                                              if (_jspx_th_html_hidden_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(146,37);to=(146,38)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 147,38-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 147,80  LineMapIndex:262
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_16 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_16.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_16.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_hidden_16.setProperty("isChangeKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_16);
                                                                                              int _jspx_eval_html_hidden_16 = _jspx_th_html_hidden_16.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 147,38-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 147,80  LineMapIndex:263
                                                                                              if (_jspx_th_html_hidden_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(146,80);to=(147,1)]
                                                                                              out.write(" \r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 148,1-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 148,41  LineMapIndex:264
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_17 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_17.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_17.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_hidden_17.setProperty("maFileKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_17);
                                                                                              int _jspx_eval_html_hidden_17 = _jspx_th_html_hidden_17.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 148,1-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 148,41  LineMapIndex:265
                                                                                              if (_jspx_th_html_hidden_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(147,41);to=(148,1)]
                                                                                              out.write(" \r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 149,1-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 149,43  LineMapIndex:266
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_18 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_18.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_18.setParent(_jspx_th_html_form_4);
                                                                                              _jspx_th_html_hidden_18.setProperty("isAttackKeHoach");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_18);
                                                                                              int _jspx_eval_html_hidden_18 = _jspx_th_html_hidden_18.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 149,1-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 149,43  LineMapIndex:267
                                                                                              if (_jspx_th_html_hidden_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(148,43);to=(149,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 150,0-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 150,12  LineMapIndex:268
                                                                                              } while (_jspx_th_html_form_4.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_html_form_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(149,12);to=(153,16)]
                                                                                              out.write("\r\n<script language=\"javascript\">\t\r\n\tfunction openUploadFile(){\r\n\t\tvar view='';\r\n\t\tvar method = '");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 154,19-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 154,49  LineMapIndex:269
                                                                                              out.print(request.getParameter("method"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(153,51);to=(155,11)]
                                                                                              out.write("';\r\n\t\tif(method == 'view') view = 'view';\r\n\t\tvar r = '");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 156,14-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 156,39  LineMapIndex:270
                                                                                              out.print(request.getParameter("r"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(155,41);to=(305,0)]
                                                                                              out.write("';\r\n\t\tif(r == 'rol') view = 'view';\t\t\r\n\t\tvar maHS = document.getElementsByName('idCuocTtkt')[0].value;\r\n\t\topenWindow(\"UploadAction.do?parentId=\"+maHS+\"&nv=TTKT/CB/KH&view=\"+view);\t\t\r\n\t}\r\n\tfunction onLoadKeHoach(){\r\n\t\t//document.getElementById('trDinhKemFile').style.display = isEmpty(document.getElementsByName('maFileKeHoach')[0].value)? 'none': 'inline';\r\n\t}\r\n\tfunction downLoadBieuMauKeHoach(){\r\n\t\tvar thongTinQd = \"\";\r\n\t\tvar qdForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd');\t \r\n\t\tfor(var i = 0; i< qdForm.elements.length; i++){\r\n\t\t\tif(qdForm.elements[i].name != null && qdForm.elements[i].name != '' && qdForm.elements[i].value != null && qdForm.elements[i].value != '')\r\n\t\t\tthongTinQd += qdForm.elements[i].name + \"=\" + encodeURIComponent(qdForm.elements[i].value) + \"&\";\r\n\t\t}\t\t\r\n\t\tthongTinQd += 'idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;\r\n\t\t\r\n\t\tvar printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=kh');\t\r\n\t\tthongTinKh = \"\";\r\n\t\tfor(var i = 0; i< printfForm.elements.length; i++){\r\n\t\t\tif(printfForm.elements[i].name != null && printfForm.elements[i].name != '' && printfForm.elements[i].name != 'fileDinhKemKeHoach' && printfForm.elements[i].value != null && printfForm.elements[i].value != '')\r\n\t\t\t\tthongTinKh += printfForm.elements[i].name + \"=\" + encodeURIComponent(printfForm.elements[i].value) + \"&\";\r\n\t\t}\r\n\t\tprintfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=bmkh&' + thongTinKh + \"&\" + thongTinQd;\r\n\t\tprintfForm.submit();\r\n\t\tprintfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=kh'; \r\n\t}\r\n\tfunction checkAttackKeHoach(){\r\n\t\tif(document.getElementById('trDinhKemFile').style.display == 'inline')\r\n\t\t\tdocument.getElementById('trDinhKemFile').style.display = 'none';\r\n\t\telse\r\n\t\t\tdocument.getElementById('trDinhKemFile').style.display = 'inline';\r\n\t\t\t\r\n\t}\r\n\tfunction validateNgayDuyetKeHoach(){\r\n\t\tif(isEmpty(document.getElementsByName('ngayLapKeHoach')[0].value)){   \r\n\t\t\talert('Chưa nhập ngày lập kế hoạch!');\r\n\t\t\tdocument.getElementsByName('ngayPheDuyetKeHoach')[0].value = '';\r\n\t\t\tdocument.getElementsByName('ngayLapKeHoach')[0].focus();\r\n\t\t}\r\n\t\tif(d2n(document.getElementsByName('ngayLapKeHoach')[0].value) > d2n(document.getElementsByName('ngayPheDuyetKeHoach')[0].value)){\r\n\t\t\talert('Ngày phê duyệt kế hoạch không được nhỏ hơn ngày lập!');\r\n\t\t\tdocument.getElementsByName('ngayLapKeHoach')[0].focus();\r\n\t\t}\r\n\t\tcaculateDate('ngayLapKeHoach', 'truongGiuNgayTam', strNgayDuyetKeHoach);\r\n\t\tif(d2n(document.getElementsByName('ngayPheDuyetKeHoach')[0].value) > d2n(document.getElementsByName('truongGiuNgayTam')[0].value)){\r\n\t\t\talert('Thời hạn phê duyệt kế hoạch là ' + strNgayDuyetKeHoach + ' ngày!');\r\n\t\t}\r\n\t} \r\n\tfunction validateNgayLapKeHoach(){\r\n\t\tif(d2n(document.getElementsByName('ngayLapKeHoach')[0].value) < d2n(document.getElementsByName('ngayRaQuyetDnh')[0].value)){\r\n\t\t\talert('Ngày lập kế hoạch không được trước ngày ra quyết định!');\r\n\t\t\tdocument.getElementsByName('ngayLapKeHoach')[0].focus();\r\n\t\t}\r\n\t\tcaculateDate('ngayRaQuyetDnh', 'truongGiuNgayTam', strNgayLapKeHoach);\r\n\t\tif(d2n(document.getElementsByName('ngayLapKeHoach')[0].value) > d2n(document.getElementsByName('truongGiuNgayTam')[0].value)){\r\n\t\t\talert('Cảnh báo quá hạn: Kế hoạch lập sau quyết định quá '+ strNgayLapKeHoach + ' ngày!');\r\n\t\t\t//document.getElementsByName('ngayLapKeHoach')[0].focus();\r\n\t\t}\r\n\t}\r\n\tfunction inKeHoach(){ \r\n\t\tif(!validateKeHoach()) \r\n\t\t\treturn;   \r\n\t\tvar thongTinQd = \"\";\r\n\t\tvar qdForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd');\t \r\n\t\tfor(var i = 0; i< qdForm.elements.length; i++){\r\n\t\t\tif(qdForm.elements[i].name != null && qdForm.elements[i].name != '' && qdForm.elements[i].value != null && qdForm.elements[i].value != '')\r\n\t\t\tthongTinQd += qdForm.elements[i].name + \"=\" + encodeURIComponent(qdForm.elements[i].value) + \"&\";\r\n\t\t}\t\t\r\n\t\tthongTinQd += 'idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;  \r\n\t\t\r\n\t\tvar printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=kh');\t\r\n\t\tthongTinKh = \"\";\r\n\t\tfor(var i = 0; i< printfForm.elements.length; i++){\r\n\t\t\tif(printfForm.elements[i].name != null && printfForm.elements[i].name != '' && printfForm.elements[i].name != 'fileDinhKemKeHoach' && printfForm.elements[i].value != null && printfForm.elements[i].value != '')\r\n\t\t\t\tthongTinKh += printfForm.elements[i].name + \"=\" + encodeURIComponent(printfForm.elements[i].value) + \"&\";\r\n\t\t}\r\n\t\tprintfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=kh&' + thongTinQd;\r\n\t\tprintfForm.submit();\r\n\t\tprintfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=kh'; \r\n\t}\r\n\tfunction getThongTinKeHoach(){\r\n\t\tvar thongTinKh = '';\r\n\t\tvar khForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=kh');\t \r\n\t\tfor(var i = 0; i< khForm.elements.length; i++){\r\n\t\t\tif(khForm.elements[i].name != null && khForm.elements[i].name != '' && khForm.elements[i].value != null && khForm.elements[i].value != '')\r\n\t\t\tthongTinKh += khForm.elements[i].name + \"=\" + encodeURIComponent(khForm.elements[i].value) + \"&\";\r\n\t\t}\r\n\t\tthongTinKh = thongTinKh.substring(0, thongTinKh.length - 1); \r\n\t\treturn thongTinKh;\r\n\t}\r\n\tfunction validateInKeHoach(){\r\n\t\tif(!isRequired(document.getElementsByName('diaDiemLapKeHoach')[0]))\r\n\t\t\treturn false;\r\n\t\tif(!isRequired(document.getElementsByName('ngayLapKeHoach')[0]))\r\n\t\t\treturn false;\r\n\t\t\r\n\t\tif(!compareDate(document.getElementsByName('ngayRaQuyetDnh')[0], document.getElementsByName('ngayLapKeHoach')[0], 'Ngày lập kế hoạch phải lớn hơn hoặc bằng ngày ra quyết định!')){\r\n\t\t\tdocument.getElementsByName('ngayLapKeHoach')[0].focus();\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\t\r\n\t\tif(!compareDate(document.getElementsByName('ngayLapKeHoach')[0], document.getElementsByName('ngayPheDuyetKeHoach')[0], 'Ngày duyệt phải lớn hơn hoặc bằng ngày lập!')){\r\n\t\t\tdocument.getElementsByName('ngayPheDuyetKeHoach')[0].focus();\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\tif(!checkNvarchar2('ykienPheDuyetKh'))\r\n\t\t\treturn false;\t\r\n\t\tif(!checkNvarchar2('mucDich'))\r\n\t\t\treturn false;\t\r\n\t\tif(!checkNvarchar2('yeuCau'))\r\n\t\t\treturn false;\r\n\t\tif(!checkNvarchar2('noiDung'))\r\n\t\t\treturn false;\r\n\t\tif(!checkNvarchar2('phuongPhapTienHanh'))  \r\n\t\t\treturn false;\t\r\n\t\tif(!checkNvarchar2('toChucThucHien'))\r\n\t\t\treturn false;\t\r\n\t\tif(!checkNvarchar2('cheDoThongTinBaoCao'))    \r\n\t\t\treturn false;\t\r\n\t\tif(!checkNvarchar2('dieuKienVatChatDamBao'))\r\n\t\t\treturn false;\t\r\n\t\tif(!checkNvarchar2('nhungDieuKienKhac'))  \r\n\t\t\treturn false;\r\n\t\treturn true;  \r\n\t}\r\n\tfunction validateKeHoach(){  \r\n\t\t// Neu chon dinh kem file va chua co file ke hoach thi bat buoc nhap file dinh kem\r\n\t\t/*if(document.getElementById('checkAttackFile').checked){\r\n\t\t\tif(isEmpty(document.getElementsByName('maFileKeHoach')[0].value))  \r\n\t\t\t\tif(!isRequired(document.getElementsByName('fileDinhKemKeHoach')[0]))\r\n\t\t\t\t\treturn false;\r\n\t\t\tdocument.getElementsByName('isAttackKeHoach')[0].value = \"true\";\r\n\t\t}\t\t\t\r\n\t\telse{\r\n\t\t\tdocument.getElementsByName('isAttackKeHoach')[0].value = \"false\";\r\n\t\t\tif(!validateInKeHoach())\r\n\t\t\treturn false;\r\n\t\t\t//document.getElementsByName('fileDinhKemKeHoach')[0].value = \"\";\r\n\t\t\t//document.getElementsByName('maFileKeHoach')[0].value = \"\";\r\n\t\t}*/\r\n\t\treturn true;\r\n\t}\r\n\tfunction saveKeHoach(){\r\n\t\tfor(i = 0; i< document.forms.length; i++){\r\n\t\t\tif(document.forms[i].action == 'chuan_bi_tien_hanh.do?method=save&type=kh')\r\n\t\t\t\tdocument.forms[i].submit();\r\n\t\t}\r\n}\r\n</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 306,0-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 306,34  LineMapIndex:271
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_9 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_9.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_9.setParent(null);
                                                                                              _jspx_th_logic_notPresent_9.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_9);
                                                                                              int _jspx_eval_logic_notPresent_9 = _jspx_th_logic_notPresent_9.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(305,34);to=(307,26)]
                                                                                              out.write("\r\n\t<script language=\"javascript\">\r\n\t\tvar strNgayLapKeHoach = ");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 308,29-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 308,78  LineMapIndex:272
                                                                                              out.print((String)request.getAttribute("ngay_lap_ke_hoach"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(307,80);to=(308,28)]
                                                                                              out.write("\r\n\t\tvar strNgayDuyetKeHoach = ");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 309,31-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 309,79  LineMapIndex:273
                                                                                              out.print((String)request.getAttribute("ngay_duyet_hoach"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(308,81);to=(310,0)]
                                                                                              out.write("\r\n\t</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 311,0-"/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp" 311,19  LineMapIndex:274
                                                                                              } while (_jspx_th_logic_notPresent_9.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp";from=(310,19);to=(311,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(36,93);to=(39,30)]
                                                                                              out.write("</fieldset>\r\n</DIV>\r\n<DIV id=\"tabDeCuong\">\r\n<fieldset style=\"width: 100%\">");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(0,31);to=(1,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(1,56);to=(2,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(2,58);to=(3,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(3,56);to=(4,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 5,0-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 5,128  LineMapIndex:275
                                                                                              /* ------  html:form ------ */
                                                                                              org.apache.struts.taglib.html.FormTag _jspx_th_html_form_5 = new org.apache.struts.taglib.html.FormTag();
                                                                                              _jspx_th_html_form_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_form_5.setParent(null);
                                                                                              _jspx_th_html_form_5.setAction("chuan_bi_tien_hanh.do?method=save&type=dc");
                                                                                              _jspx_th_html_form_5.setMethod("POST");
                                                                                              _jspx_th_html_form_5.setEnctype("multipart/form-data");
                                                                                              _jspx_th_html_form_5.setStyleId("deCuongForm");
                                                                                              _jspxTagObjects.push(_jspx_th_html_form_5);
                                                                                              int _jspx_eval_html_form_5 = _jspx_th_html_form_5.doStartTag();
                                                                                              if (_jspx_eval_html_form_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(4,128);to=(10,32)]
                                                                                              out.write("\r\n\t<div id=\"getReturnDc\" style=\"display: none;\"></div>\r\n\t<table align=\"center\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Địa điểm lập <font color=red>*</font></td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 11,32-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 11,86  LineMapIndex:276
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_22 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_22.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_22.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_html_text_22.setStyleClass("text");
                                                                                              _jspx_th_html_text_22.setProperty("noiLapDeCuong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_22);
                                                                                              int _jspx_eval_html_text_22 = _jspx_th_html_text_22.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 11,32-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 11,98  LineMapIndex:277
                                                                                              if (_jspx_th_html_text_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(10,98);to=(13,32)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\" width=\"19%\">Ngày lập <font color=red>*</font></td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 14,32-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 14,191  LineMapIndex:278
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_23 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_23.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_23.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_html_text_23.setStyleClass("text");
                                                                                              _jspx_th_html_text_23.setProperty("ngayLapDeCuong");
                                                                                              _jspx_th_html_text_23.setOnblur("if(!isDate(this)) return; validateNgayLapDeCuong()");
                                                                                              _jspx_th_html_text_23.setOnkeypress("return formatDate(event, this)");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_23);
                                                                                              int _jspx_eval_html_text_23 = _jspx_th_html_text_23.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 14,32-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 14,203  LineMapIndex:279
                                                                                              if (_jspx_th_html_text_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(13,203);to=(30,4)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"center\" width=\"100%\" colspan=\"6\">\r\n\t\t\t<fieldset style=\"width: 100%; margin: 0\"><legend>Báo cáo phải chuẩn bị và cung cấp </legend>\r\n\t\t\t<DIV style=\"overflow: scroll; width: 740; height: 150\">\r\n\t\t\t<TABLE width=\"1000\" id=\"tblBaoCao\">\r\n\t\t\t\t<tr class=\"TdHeaderList\">\r\n\t\t\t\t\t<td>Tên <font color=red>*</font></td>\r\n\t\t\t\t\t<td>Nội dung</td>\r\n\t\t\t\t\t<td>Thời kỳ</td>\r\n\t\t\t\t\t<td>Hình thức</td>\r\n\t\t\t\t\t<td>Thời gian bàn giao <font color=red>*</font></td>\r\n\t\t\t\t\t<td>Địa điểm nhận <font color=red>*</font></td>\r\n\t\t\t\t\t<td>Người nhận <font color=red>*</font></td>\r\n\t\t\t\t\t<td align=\"center\"><INPUT type=\"checkbox\" onclick=\"selectAllBaoCao(this)\"></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 31,4-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 31,66  LineMapIndex:280
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_6 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_6.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_6.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_logic_present_6.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_present_6.setProperty("dsBaoCao");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_6);
                                                                                              int _jspx_eval_logic_present_6 = _jspx_th_logic_present_6.doStartTag();
                                                                                              if (_jspx_eval_logic_present_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(30,66);to=(31,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 32,5-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 32,95  LineMapIndex:281
                                                                                              /* ------  logic:iterate ------ */
                                                                                              org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_1 = new org.apache.struts.taglib.logic.IterateTag();
                                                                                              _jspx_th_logic_iterate_1.setPageContext(pageContext);
                                                                                              _jspx_th_logic_iterate_1.setParent(_jspx_th_logic_present_6);
                                                                                              _jspx_th_logic_iterate_1.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_iterate_1.setProperty("dsBaoCao");
                                                                                              _jspx_th_logic_iterate_1.setIndexId("index");
                                                                                              _jspx_th_logic_iterate_1.setId("baoCao");
                                                                                              { // begin scope of tag variables
                                                                                              _jspxTagObjects.push(_jspx_th_logic_iterate_1);
                                                                                              int _jspx_eval_logic_iterate_1 = _jspx_th_logic_iterate_1.doStartTag();
                                                                                              if (_jspx_eval_logic_iterate_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_logic_iterate_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_logic_iterate_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_logic_iterate_1.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              java.lang.Object baoCao = null;
                                                                                              baoCao = (java.lang.Object) pageContext.findAttribute("baoCao");
                                                                                              java.lang.Integer index = null;
                                                                                              index = (java.lang.Integer) pageContext.findAttribute("index");
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(31,95);to=(32,20)]
                                                                                              out.write("\r\n\t\t\t\t\t\t<tr class='row");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 33,23-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 33,48  LineMapIndex:282
                                                                                              out.print((index.intValue() % 2)+1 );
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(32,50);to=(33,11)]
                                                                                              out.write("'>\r\n\t\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 34,11-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 34,98  LineMapIndex:283
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_19 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_19.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_19.setParent(_jspx_th_logic_iterate_1);
                                                                                              _jspx_th_html_hidden_19.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_hidden_19.setProperty("dsBaoCao[" + index + "].id");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_19);
                                                                                              int _jspx_eval_html_hidden_19 = _jspx_th_html_hidden_19.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 34,11-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 34,98  LineMapIndex:284
                                                                                              if (_jspx_th_html_hidden_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(33,98);to=(33,99)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 34,99-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 34,260  LineMapIndex:285
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_24 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_24.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_24.setParent(_jspx_th_logic_iterate_1);
                                                                                              _jspx_th_html_text_24.setStyleClass("text1");
                                                                                              _jspx_th_html_text_24.setStyleId("ten"+index);
                                                                                              _jspx_th_html_text_24.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_24.setProperty("dsBaoCao[" + index + "].ten");
                                                                                              _jspx_th_html_text_24.setOnclick("showContents(event);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_24);
                                                                                              int _jspx_eval_html_text_24 = _jspx_th_html_text_24.doStartTag();
                                                                                              if (_jspx_eval_html_text_24 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_24 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_24.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_24.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(33,260);to=(34,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 35,7-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 35,19  LineMapIndex:286
                                                                                              } while (_jspx_th_html_text_24.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_24 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(34,19);to=(35,11)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 36,11-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 36,245  LineMapIndex:287
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_25 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_25.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_25.setParent(_jspx_th_logic_iterate_1);
                                                                                              _jspx_th_html_text_25.setStyleClass("text1");
                                                                                              _jspx_th_html_text_25.setStyleId("noiDung"+index);
                                                                                              _jspx_th_html_text_25.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_25.setProperty("dsBaoCao[" + index + "].noiDung");
                                                                                              _jspx_th_html_text_25.setOnkeydown("showContents(event);");
                                                                                              _jspx_th_html_text_25.setOnchange("showContents(event);");
                                                                                              _jspx_th_html_text_25.setOnclick("showContents(event);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_25);
                                                                                              int _jspx_eval_html_text_25 = _jspx_th_html_text_25.doStartTag();
                                                                                              if (_jspx_eval_html_text_25 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_25 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_25.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_25.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(35,245);to=(36,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 37,7-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 37,19  LineMapIndex:288
                                                                                              } while (_jspx_th_html_text_25.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_25 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(36,19);to=(37,11)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 38,11-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 38,206  LineMapIndex:289
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_26 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_26.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_26.setParent(_jspx_th_logic_iterate_1);
                                                                                              _jspx_th_html_text_26.setStyleClass("text1");
                                                                                              _jspx_th_html_text_26.setStyle("width: 65");
                                                                                              _jspx_th_html_text_26.setOnkeypress("return formatDate(event, this)");
                                                                                              _jspx_th_html_text_26.setOnblur("isDate(this)");
                                                                                              _jspx_th_html_text_26.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_26.setProperty("dsBaoCao[" + index + "].strThoiKyTu");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_26);
                                                                                              int _jspx_eval_html_text_26 = _jspx_th_html_text_26.doStartTag();
                                                                                              if (_jspx_eval_html_text_26 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_26 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_26.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_26.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(37,206);to=(38,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 39,7-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 39,19  LineMapIndex:290
                                                                                              } while (_jspx_th_html_text_26.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_26 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(38,19);to=(38,22)]
                                                                                              out.write(" - ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 39,22-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 39,218  LineMapIndex:291
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_27 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_27.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_27.setParent(_jspx_th_logic_iterate_1);
                                                                                              _jspx_th_html_text_27.setStyle("width: 65");
                                                                                              _jspx_th_html_text_27.setStyleClass("text1");
                                                                                              _jspx_th_html_text_27.setOnkeypress("return formatDate(event, this)");
                                                                                              _jspx_th_html_text_27.setOnblur("isDate(this)");
                                                                                              _jspx_th_html_text_27.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_27.setProperty("dsBaoCao[" + index + "].strThoiKyDen");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_27);
                                                                                              int _jspx_eval_html_text_27 = _jspx_th_html_text_27.doStartTag();
                                                                                              if (_jspx_eval_html_text_27 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_27 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_27.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_27.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(38,218);to=(39,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 40,7-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 40,19  LineMapIndex:292
                                                                                              } while (_jspx_th_html_text_27.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_27 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(39,19);to=(40,11)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 41,11-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 41,119  LineMapIndex:293
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_28 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_28.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_28.setParent(_jspx_th_logic_iterate_1);
                                                                                              _jspx_th_html_text_28.setStyleClass("text1");
                                                                                              _jspx_th_html_text_28.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_28.setProperty("dsBaoCao[" + index + "].hinhThuc");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_28);
                                                                                              int _jspx_eval_html_text_28 = _jspx_th_html_text_28.doStartTag();
                                                                                              if (_jspx_eval_html_text_28 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_28 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_28.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_28.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(40,119);to=(41,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 42,7-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 42,19  LineMapIndex:294
                                                                                              } while (_jspx_th_html_text_28.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_28 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(41,19);to=(42,11)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 43,11-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 43,195  LineMapIndex:295
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_29 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_29.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_29.setParent(_jspx_th_logic_iterate_1);
                                                                                              _jspx_th_html_text_29.setStyleClass("text1");
                                                                                              _jspx_th_html_text_29.setOnkeypress("return formatDate(event, this)");
                                                                                              _jspx_th_html_text_29.setOnblur("isDate(this)");
                                                                                              _jspx_th_html_text_29.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_29.setProperty("dsBaoCao[" + index + "].strThoiGianBanGiao");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_29);
                                                                                              int _jspx_eval_html_text_29 = _jspx_th_html_text_29.doStartTag();
                                                                                              if (_jspx_eval_html_text_29 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_29 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_29.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_29.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(42,195);to=(43,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 44,7-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 44,19  LineMapIndex:296
                                                                                              } while (_jspx_th_html_text_29.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_29 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(43,19);to=(44,11)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 45,11-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 45,109  LineMapIndex:297
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_20 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_20.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_20.setParent(_jspx_th_logic_iterate_1);
                                                                                              _jspx_th_html_hidden_20.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_hidden_20.setProperty("dsBaoCao[" + index + "].diaDiemNhanId");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_20);
                                                                                              int _jspx_eval_html_hidden_20 = _jspx_th_html_hidden_20.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 45,11-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 45,109  LineMapIndex:298
                                                                                              if (_jspx_th_html_hidden_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(44,109);to=(44,110)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 45,110-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 45,225  LineMapIndex:299
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_30 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_30.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_30.setParent(_jspx_th_logic_iterate_1);
                                                                                              _jspx_th_html_text_30.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_30.setStyleClass("text1");
                                                                                              _jspx_th_html_text_30.setProperty("dsBaoCao[" + index + "].diaDiemNhanName");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_30);
                                                                                              int _jspx_eval_html_text_30 = _jspx_th_html_text_30.doStartTag();
                                                                                              if (_jspx_eval_html_text_30 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_30 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_30.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_30.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(44,225);to=(45,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 46,7-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 46,19  LineMapIndex:300
                                                                                              } while (_jspx_th_html_text_30.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_30 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(45,19);to=(47,8)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 48,8-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 48,148  LineMapIndex:301
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_5 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_5.setParent(_jspx_th_logic_iterate_1);
                                                                                              _jspx_th_html_select_5.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_select_5.setProperty("dsBaoCao[" + index + "].nguoiNhanId");
                                                                                              _jspx_th_html_select_5.setOnchange("getTen(this)");
                                                                                              _jspx_th_html_select_5.setStyleClass("decuong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_select_5);
                                                                                              int _jspx_eval_html_select_5 = _jspx_th_html_select_5.doStartTag();
                                                                                              if (_jspx_eval_html_select_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_select_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_select_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_select_5.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(47,148);to=(48,9)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 49,9-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 49,98  LineMapIndex:302
                                                                                              /* ------  html:options ------ */
                                                                                              org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_2 = new org.apache.struts.taglib.html.OptionsTag();
                                                                                              _jspx_th_html_options_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_options_2.setParent(_jspx_th_html_select_5);
                                                                                              _jspx_th_html_options_2.setCollection("dsTvdLapDeCuong");
                                                                                              _jspx_th_html_options_2.setProperty("idCanBo");
                                                                                              _jspx_th_html_options_2.setLabelProperty("tenCanBo");
                                                                                              _jspxTagObjects.push(_jspx_th_html_options_2);
                                                                                              int _jspx_eval_html_options_2 = _jspx_th_html_options_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 49,9-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 49,98  LineMapIndex:303
                                                                                              if (_jspx_th_html_options_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(48,98);to=(49,8)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 50,8-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 50,22  LineMapIndex:304
                                                                                              } while (_jspx_th_html_select_5.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_select_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_select_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(49,22);to=(50,8)]
                                                                                              out.write(" \r\n\t\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 51,8-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 51,106  LineMapIndex:305
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_21 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_21.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_21.setParent(_jspx_th_logic_iterate_1);
                                                                                              _jspx_th_html_hidden_21.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_hidden_21.setProperty("dsBaoCao[" + index + "].nguoiNhanName");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_21);
                                                                                              int _jspx_eval_html_hidden_21 = _jspx_th_html_hidden_21.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 51,8-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 51,106  LineMapIndex:306
                                                                                              if (_jspx_th_html_hidden_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(50,106);to=(54,5)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td align=\"center\"><INPUT type=\"checkbox\" onclick=\"selectBaoCao(this)\"></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 55,5-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 55,21  LineMapIndex:307
                                                                                              } while (_jspx_th_logic_iterate_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_logic_iterate_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_logic_iterate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              } // end scope of tag variables
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(54,21);to=(55,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 56,4-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 56,20  LineMapIndex:308
                                                                                              } while (_jspx_th_logic_present_6.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(55,20);to=(73,4)]
                                                                                              out.write("\r\n\t\t\t</TABLE>\r\n\t\t\t</DIV>\r\n\t\t\t<DIV style=\"width: 100%; text-align: right;\" align=\"right\"><INPUT type=\"button\" onclick=\"themBaoCao()\" value=\"Thêm\"> <INPUT type=\"button\" onclick=\"xoaBaoCao()\" value=\"Xóa\" id=\"xoaTblBaoCao\"></DIV>\r\n\t\t\t</fieldset>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"center\" width=\"100%\" colspan=\"6\">\r\n\t\t\t<fieldset style=\"width: 100%; margin: 0\"><legend>Hồ sơ tài liệu phải chuẩn bị và cung cấp </legend>\r\n\t\t\t<TABLE width=\"100%\" id=\"tblHsTl\">\r\n\t\t\t\t<tr class=\"TdHeaderList\">\r\n\t\t\t\t\t<th>Tên <font color=red>*</font></th>\r\n\t\t\t\t\t<th>Thời gian bàn giao <font color=red>*</font></th>\r\n\t\t\t\t\t<th>Địa điểm nhận <font color=red>*</font></th>\r\n\t\t\t\t\t<th>Người nhận <font color=red>*</font></th>\r\n\t\t\t\t\t<TH align=\"center\"><INPUT type=\"checkbox\" onclick=\"selectAllHsTl(this)\"></TH>\r\n\t\t\t\t</tr>\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 74,4-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 74,66  LineMapIndex:309
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_7 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_7.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_7.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_logic_present_7.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_present_7.setProperty("dsHoSoTl");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_7);
                                                                                              int _jspx_eval_logic_present_7 = _jspx_th_logic_present_7.doStartTag();
                                                                                              if (_jspx_eval_logic_present_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(73,66);to=(74,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 75,4-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 75,94  LineMapIndex:310
                                                                                              /* ------  logic:iterate ------ */
                                                                                              org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_2 = new org.apache.struts.taglib.logic.IterateTag();
                                                                                              _jspx_th_logic_iterate_2.setPageContext(pageContext);
                                                                                              _jspx_th_logic_iterate_2.setParent(_jspx_th_logic_present_7);
                                                                                              _jspx_th_logic_iterate_2.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_iterate_2.setProperty("dsHoSoTl");
                                                                                              _jspx_th_logic_iterate_2.setIndexId("index");
                                                                                              _jspx_th_logic_iterate_2.setId("hoSoTl");
                                                                                              { // begin scope of tag variables
                                                                                              _jspxTagObjects.push(_jspx_th_logic_iterate_2);
                                                                                              int _jspx_eval_logic_iterate_2 = _jspx_th_logic_iterate_2.doStartTag();
                                                                                              if (_jspx_eval_logic_iterate_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_logic_iterate_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_logic_iterate_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_logic_iterate_2.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              java.lang.Object hoSoTl = null;
                                                                                              hoSoTl = (java.lang.Object) pageContext.findAttribute("hoSoTl");
                                                                                              java.lang.Integer index = null;
                                                                                              index = (java.lang.Integer) pageContext.findAttribute("index");
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(74,94);to=(75,19)]
                                                                                              out.write("\r\n\t\t\t\t\t<tr class='row");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 76,22-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 76,47  LineMapIndex:311
                                                                                              out.print((index.intValue() % 2)+1 );
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(75,49);to=(78,7)]
                                                                                              out.write("'>\r\n\t\t\t\t\t\t<td width=\"100px;\">\r\n\t\t\t\t\t\t<div style=\"width: 100px;overflow:hidden;\">\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 79,7-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 79,94  LineMapIndex:312
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_22 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_22.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_22.setParent(_jspx_th_logic_iterate_2);
                                                                                              _jspx_th_html_hidden_22.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_hidden_22.setProperty("dsHoSoTl[" + index + "].id");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_22);
                                                                                              int _jspx_eval_html_hidden_22 = _jspx_th_html_hidden_22.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 79,7-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 79,94  LineMapIndex:313
                                                                                              if (_jspx_th_html_hidden_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(78,94);to=(79,7)]
                                                                                              out.write(" \r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 80,7-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 80,178  LineMapIndex:314
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_31 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_31.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_31.setParent(_jspx_th_logic_iterate_2);
                                                                                              _jspx_th_html_text_31.setStyleClass("text1");
                                                                                              _jspx_th_html_text_31.setStyleId("dsHoSoTl_ten_"+index);
                                                                                              _jspx_th_html_text_31.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_31.setProperty("dsHoSoTl[" + index + "].ten");
                                                                                              _jspx_th_html_text_31.setOnclick("showContents(event);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_31);
                                                                                              int _jspx_eval_html_text_31 = _jspx_th_html_text_31.doStartTag();
                                                                                              if (_jspx_eval_html_text_31 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_31 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_31.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_31.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(79,178);to=(80,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 81,7-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 81,19  LineMapIndex:315
                                                                                              } while (_jspx_th_html_text_31.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_31 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(80,19);to=(84,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 85,6-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 85,190  LineMapIndex:316
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_32 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_32.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_32.setParent(_jspx_th_logic_iterate_2);
                                                                                              _jspx_th_html_text_32.setStyleClass("text1");
                                                                                              _jspx_th_html_text_32.setOnkeypress("return formatDate(event, this)");
                                                                                              _jspx_th_html_text_32.setOnblur("isDate(this)");
                                                                                              _jspx_th_html_text_32.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_32.setProperty("dsHoSoTl[" + index + "].strThoiGianBanGiao");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_32);
                                                                                              int _jspx_eval_html_text_32 = _jspx_th_html_text_32.doStartTag();
                                                                                              if (_jspx_eval_html_text_32 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_32 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_32.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_32.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(84,190);to=(85,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 86,6-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 86,18  LineMapIndex:317
                                                                                              } while (_jspx_th_html_text_32.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_32 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(85,18);to=(88,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 89,6-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 89,104  LineMapIndex:318
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_23 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_23.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_23.setParent(_jspx_th_logic_iterate_2);
                                                                                              _jspx_th_html_hidden_23.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_hidden_23.setProperty("dsHoSoTl[" + index + "].diaDiemNhanId");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_23);
                                                                                              int _jspx_eval_html_hidden_23 = _jspx_th_html_hidden_23.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 89,6-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 89,104  LineMapIndex:319
                                                                                              if (_jspx_th_html_hidden_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(88,104);to=(89,6)]
                                                                                              out.write(" \r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 90,6-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 90,121  LineMapIndex:320
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_33 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_33.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_33.setParent(_jspx_th_logic_iterate_2);
                                                                                              _jspx_th_html_text_33.setStyleClass("text1");
                                                                                              _jspx_th_html_text_33.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_33.setProperty("dsHoSoTl[" + index + "].diaDiemNhanName");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_33);
                                                                                              int _jspx_eval_html_text_33 = _jspx_th_html_text_33.doStartTag();
                                                                                              if (_jspx_eval_html_text_33 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_33 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_33.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_33.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(89,121);to=(90,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 91,6-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 91,18  LineMapIndex:321
                                                                                              } while (_jspx_th_html_text_33.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_33 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(90,18);to=(93,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 94,7-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 94,146  LineMapIndex:322
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_6 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_6.setParent(_jspx_th_logic_iterate_2);
                                                                                              _jspx_th_html_select_6.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_select_6.setProperty("dsHoSoTl[" + index + "].nguoiNhanId");
                                                                                              _jspx_th_html_select_6.setOnchange("getTen(this)");
                                                                                              _jspx_th_html_select_6.setStyleClass("decuong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_select_6);
                                                                                              int _jspx_eval_html_select_6 = _jspx_th_html_select_6.doStartTag();
                                                                                              if (_jspx_eval_html_select_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_select_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_select_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_select_6.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(93,146);to=(94,8)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 95,8-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 95,97  LineMapIndex:323
                                                                                              /* ------  html:options ------ */
                                                                                              org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_3 = new org.apache.struts.taglib.html.OptionsTag();
                                                                                              _jspx_th_html_options_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_options_3.setParent(_jspx_th_html_select_6);
                                                                                              _jspx_th_html_options_3.setCollection("dsTvdLapDeCuong");
                                                                                              _jspx_th_html_options_3.setProperty("idCanBo");
                                                                                              _jspx_th_html_options_3.setLabelProperty("tenCanBo");
                                                                                              _jspxTagObjects.push(_jspx_th_html_options_3);
                                                                                              int _jspx_eval_html_options_3 = _jspx_th_html_options_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 95,8-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 95,97  LineMapIndex:324
                                                                                              if (_jspx_th_html_options_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(94,97);to=(95,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 96,7-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 96,21  LineMapIndex:325
                                                                                              } while (_jspx_th_html_select_6.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_select_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_select_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(95,21);to=(96,8)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 97,8-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 97,106  LineMapIndex:326
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_24 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_24.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_24.setParent(_jspx_th_logic_iterate_2);
                                                                                              _jspx_th_html_hidden_24.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_hidden_24.setProperty("dsHoSoTl[" + index + "].nguoiNhanName");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_24);
                                                                                              int _jspx_eval_html_hidden_24 = _jspx_th_html_hidden_24.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 97,8-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 97,106  LineMapIndex:327
                                                                                              if (_jspx_th_html_hidden_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(96,106);to=(100,4)]
                                                                                              out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td align=\"center\"><INPUT type=\"checkbox\" onclick=\"selectHsTl(this)\"></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 101,4-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 101,20  LineMapIndex:328
                                                                                              } while (_jspx_th_logic_iterate_2.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_logic_iterate_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_logic_iterate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              } // end scope of tag variables
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(100,20);to=(101,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 102,4-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 102,20  LineMapIndex:329
                                                                                              } while (_jspx_th_logic_present_7.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(101,20);to=(111,5)]
                                                                                              out.write("\r\n\t\t\t</TABLE>\r\n\t\t\t<DIV style=\"width: 100%; text-align: right;\" align=\"right\"><INPUT type=\"button\" onclick=\"themHoSoTl()\" value=\"Thêm\"> <INPUT type=\"button\" onclick=\"xoaHoSoTl()\" value=\"Xóa\" id=\"xoaTblHsTl\"></DIV>\r\n\t\t\t</fieldset>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<!--Nhung van de khac-->\r\n\t\t<tr>\t\t\t\r\n\t\t\t<td align=\"left\" colspan=\"6\">\r\n\t\t\t\t<fieldset> <legend>Những vấn đề khác</legend>\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 112,5-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 112,132  LineMapIndex:330
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_12 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_12.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_12.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_html_textarea_12.setStyleClass("textareaContent");
                                                                                              _jspx_th_html_textarea_12.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_12.setStyle("width: 100%");
                                                                                              _jspx_th_html_textarea_12.setProperty("nhungVanDeKhac");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_12);
                                                                                              int _jspx_eval_html_textarea_12 = _jspx_th_html_textarea_12.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 112,5-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 112,148  LineMapIndex:331
                                                                                              if (_jspx_th_html_textarea_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(111,148);to=(124,32)]
                                                                                              out.write("\r\n\t\t\t\t</fieldset>\r\n\t\t\t</td>\t\t\t\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"5\"></td>\r\n\t\t\t<td align=\"right\"><INPUT type=\"button\" class=\"button1\" value=\"In đề cương\" onclick=\"inDeCuong()\"></td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<table width=\"100%\">\r\n\t\t<!-- <tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Đính kèm file</td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 125,32-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 125,99  LineMapIndex:332
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_8 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_8.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_8.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_logic_present_8.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_present_8.setProperty("maFileDeCuong");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_8);
                                                                                              int _jspx_eval_logic_present_8 = _jspx_th_logic_present_8.doStartTag();
                                                                                              if (_jspx_eval_logic_present_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(124,99);to=(126,3)]
                                                                                              out.write("\r\n\t\t\t\t<input type=\"checkbox\" style=\"margin: 0\" onclick=\"checkAttackDeCuong()\" checked id=\"checkAttackFileDC\" />\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 127,3-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 127,19  LineMapIndex:333
                                                                                              } while (_jspx_th_logic_present_8.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(126,19);to=(126,20)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 127,20-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 127,90  LineMapIndex:334
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_10 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_10.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_10.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_logic_notPresent_10.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_notPresent_10.setProperty("maFileDeCuong");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_10);
                                                                                              int _jspx_eval_logic_notPresent_10 = _jspx_th_logic_notPresent_10.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(126,90);to=(128,3)]
                                                                                              out.write("\r\n\t\t\t\t<input type=\"checkbox\" style=\"margin: 0\" onclick=\"checkAttackDeCuong()\" id=\"checkAttackFileDC\" />\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 129,3-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 129,22  LineMapIndex:335
                                                                                              } while (_jspx_th_logic_notPresent_10.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(128,22);to=(134,8)]
                                                                                              out.write("</td>\r\n\t\t</tr> --> \r\n\t\t<tr>\r\n\t\t\t<td colspan=\"6\" width=\"100%\">\r\n\t\t\t<fieldset>\r\n\t\t\t<table width=\"100%\">\r\n\t\t\t\t<!--");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 135,8-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 135,42  LineMapIndex:336
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_11 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_11.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_11.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_logic_notPresent_11.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_11);
                                                                                              int _jspx_eval_logic_notPresent_11 = _jspx_th_logic_notPresent_11.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(134,42);to=(140,8)]
                                                                                              out.write("-->\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"49%\">Download biểu mẫu</td>\r\n\t\t\t\t\t<td style=\"width: 2%; min-width: 5px;\"></td>\r\n\t\t\t\t\t<td align=\"left\" width=\"49%\"><A href=\"filemau/TTNB13.doc\"> <font color=blue>Download File</font> </A></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<!--");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 141,8-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 141,27  LineMapIndex:337
                                                                                              } while (_jspx_th_logic_notPresent_11.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(140,27);to=(141,8)]
                                                                                              out.write("-->\r\n\t\t\t\t<!--");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 142,8-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 142,75  LineMapIndex:338
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_9 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_9.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_9.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_logic_present_9.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_present_9.setProperty("maFileDeCuong");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_9);
                                                                                              int _jspx_eval_logic_present_9 = _jspx_th_logic_present_9.doStartTag();
                                                                                              if (_jspx_eval_logic_present_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(141,75);to=(147,4)]
                                                                                              out.write("\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=\"right\" width=\"49%\">File đính kèm</td>\r\n\t\t\t\t\t\t<td style=\"width: 2%; min-width: 5px;\"></td>\r\n\t\t\t\t\t\t<td align=\"left\" width=\"49%\"><a href=\"#\" onclick=\"window.open('UploadAction.do?method=downLoadDeCuongTtkt&ma_file='+document.getElementsByName('maFileDeCuong')[0].value).focus()\"><font color=\"blue\">Đề cương Thanh tra Kiểm tra</font></a></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 148,4-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 148,20  LineMapIndex:339
                                                                                              } while (_jspx_th_logic_present_9.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(147,20);to=(148,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 149,4-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 149,38  LineMapIndex:340
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_12 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_12.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_12.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_logic_notPresent_12.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_12);
                                                                                              int _jspx_eval_logic_notPresent_12 = _jspx_th_logic_notPresent_12.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(148,38);to=(151,6)]
                                                                                              out.write("\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=\"right\" width=\"49%\">\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 152,6-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 152,73  LineMapIndex:341
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_10 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_10.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_10.setParent(_jspx_th_logic_notPresent_12);
                                                                                              _jspx_th_logic_present_10.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_present_10.setProperty("maFileDeCuong");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_10);
                                                                                              int _jspx_eval_logic_present_10 = _jspx_th_logic_present_10.doStartTag();
                                                                                              if (_jspx_eval_logic_present_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(151,73);to=(153,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t\t\tCập nhật file đính kèm\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 154,6-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 154,22  LineMapIndex:342
                                                                                              } while (_jspx_th_logic_present_10.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(153,22);to=(154,6)]
                                                                                              out.write(" \r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 155,6-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 155,76  LineMapIndex:343
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_13 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_13.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_13.setParent(_jspx_th_logic_notPresent_12);
                                                                                              _jspx_th_logic_notPresent_13.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_notPresent_13.setProperty("maFileDeCuong");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_13);
                                                                                              int _jspx_eval_logic_notPresent_13 = _jspx_th_logic_notPresent_13.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(154,76);to=(156,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t\t\tFile đính kèm\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 157,6-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 157,25  LineMapIndex:344
                                                                                              } while (_jspx_th_logic_notPresent_13.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(156,25);to=(159,6)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t<td style=\"width: 2%; min-width: 5px;\"></td>\r\n\t\t\t\t\t\t<td align=\"left\" width=\"49%\">\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 160,6-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 160,74  LineMapIndex:345
                                                                                              /* ------  html:file ------ */
                                                                                              org.apache.struts.taglib.html.FileTag _jspx_th_html_file_2 = new org.apache.struts.taglib.html.FileTag();
                                                                                              _jspx_th_html_file_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_file_2.setParent(_jspx_th_logic_notPresent_12);
                                                                                              _jspx_th_html_file_2.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_file_2.setProperty("fileDinhKemDeCuong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_file_2);
                                                                                              int _jspx_eval_html_file_2 = _jspx_th_html_file_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 160,6-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 160,86  LineMapIndex:346
                                                                                              if (_jspx_th_html_file_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(159,86);to=(162,4)]
                                                                                              out.write("\t\t\t\t\t\t\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 163,4-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 163,23  LineMapIndex:347
                                                                                              } while (_jspx_th_logic_notPresent_12.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(162,23);to=(175,1)]
                                                                                              out.write("-->\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"49%\">File đề cương</td>\r\n\t\t\t\t\t<td style=\"width: 2%; min-width: 5px;\"></td>\r\n\t\t\t\t\t<td align=\"left\" width=\"49%\"><A href=\"#\" onclick=\"openUploadFile();\"><font color=blue>File \"đề cương\" đính kèm</font></A></td>\r\n\t\t\t\t</tr>\r\n\t\t\t</table>\r\n\t\t\t</fieldset>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t<div id=\"Contents\" style=\"display: none; width: 200px; height: 100px; position: absolute;\">\r\n\t<textarea id=\"Area\" rows=\"3\" cols=\"50\" onkeypress=\"imposeMaxLength(this);\"  onblur=\"changeContents(this);\"></textarea></div>\r\n\t</table>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 176,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 176,37  LineMapIndex:348
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_25 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_25.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_25.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_html_hidden_25.setProperty("idDecuong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_25);
                                                                                              int _jspx_eval_html_hidden_25 = _jspx_th_html_hidden_25.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 176,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 176,37  LineMapIndex:349
                                                                                              if (_jspx_th_html_hidden_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(175,37);to=(176,1)]
                                                                                              out.write(" \r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 177,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 177,43  LineMapIndex:350
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_26 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_26.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_26.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_html_hidden_26.setProperty("isChangeDeCuong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_26);
                                                                                              int _jspx_eval_html_hidden_26 = _jspx_th_html_hidden_26.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 177,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 177,43  LineMapIndex:351
                                                                                              if (_jspx_th_html_hidden_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(176,43);to=(177,1)]
                                                                                              out.write(" \r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 178,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 178,53  LineMapIndex:352
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_27 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_27.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_27.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_html_hidden_27.setProperty("idBaoCaoPhaiCbiCungCap_DC");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_27);
                                                                                              int _jspx_eval_html_hidden_27 = _jspx_th_html_hidden_27.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 178,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 178,53  LineMapIndex:353
                                                                                              if (_jspx_th_html_hidden_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(177,53);to=(178,1)]
                                                                                              out.write(" \r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 179,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 179,51  LineMapIndex:354
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_28 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_28.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_28.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_html_hidden_28.setProperty("idHstlPhaiCbiCungCap_DC");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_28);
                                                                                              int _jspx_eval_html_hidden_28 = _jspx_th_html_hidden_28.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 179,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 179,51  LineMapIndex:355
                                                                                              if (_jspx_th_html_hidden_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(178,51);to=(179,1)]
                                                                                              out.write(" \r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 180,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 180,45  LineMapIndex:356
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_29 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_29.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_29.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_html_hidden_29.setProperty("idDsTvdLapDeCuong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_29);
                                                                                              int _jspx_eval_html_hidden_29 = _jspx_th_html_hidden_29.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 180,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 180,45  LineMapIndex:357
                                                                                              if (_jspx_th_html_hidden_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(179,45);to=(180,1)]
                                                                                              out.write(" \r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 181,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 181,41  LineMapIndex:358
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_30 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_30.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_30.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_html_hidden_30.setProperty("maFileDeCuong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_30);
                                                                                              int _jspx_eval_html_hidden_30 = _jspx_th_html_hidden_30.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 181,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 181,41  LineMapIndex:359
                                                                                              if (_jspx_th_html_hidden_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(180,41);to=(181,1)]
                                                                                              out.write(" \r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 182,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 182,43  LineMapIndex:360
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_31 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_31.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_31.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_html_hidden_31.setProperty("isAttackDeCuong");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_31);
                                                                                              int _jspx_eval_html_hidden_31 = _jspx_th_html_hidden_31.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 182,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 182,43  LineMapIndex:361
                                                                                              if (_jspx_th_html_hidden_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(181,43);to=(182,2)]
                                                                                              out.write(" \r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 183,2-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 183,65  LineMapIndex:362
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_7 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_7.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_7.setParent(_jspx_th_html_form_5);
                                                                                              _jspx_th_html_select_7.setProperty("dsTvdLapDeCuong");
                                                                                              _jspx_th_html_select_7.setStyle("display: none;");
                                                                                              _jspxTagObjects.push(_jspx_th_html_select_7);
                                                                                              int _jspx_eval_html_select_7 = _jspx_th_html_select_7.doStartTag();
                                                                                              if (_jspx_eval_html_select_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_select_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_select_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_select_7.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(182,65);to=(183,2)]
                                                                                              out.write("\r\n\t\t");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(183,46);to=(184,2)]
                                                                                              out.write("\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 185,2-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 185,91  LineMapIndex:363
                                                                                              /* ------  html:options ------ */
                                                                                              org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_4 = new org.apache.struts.taglib.html.OptionsTag();
                                                                                              _jspx_th_html_options_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_options_4.setParent(_jspx_th_html_select_7);
                                                                                              _jspx_th_html_options_4.setCollection("dsTvdLapDeCuong");
                                                                                              _jspx_th_html_options_4.setProperty("idCanBo");
                                                                                              _jspx_th_html_options_4.setLabelProperty("tenCanBo");
                                                                                              _jspxTagObjects.push(_jspx_th_html_options_4);
                                                                                              int _jspx_eval_html_options_4 = _jspx_th_html_options_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 185,2-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 185,91  LineMapIndex:364
                                                                                              if (_jspx_th_html_options_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(184,91);to=(185,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 186,1-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 186,15  LineMapIndex:365
                                                                                              } while (_jspx_th_html_select_7.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_select_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_select_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(185,15);to=(186,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 187,0-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 187,12  LineMapIndex:366
                                                                                              } while (_jspx_th_html_form_5.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_html_form_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(186,12);to=(191,16)]
                                                                                              out.write("\r\n<script>\r\n\tvar contextRoot = document.forms[0].action.split('/')[1];\r\n\tfunction openUploadFile(){\r\n\t\tvar view='';\r\n\t\tvar method = '");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 192,19-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 192,49  LineMapIndex:367
                                                                                              out.print(request.getParameter("method"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(191,51);to=(193,11)]
                                                                                              out.write("';\r\n\t\tif(method == 'view') view = 'view';\r\n\t\tvar r = '");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 194,14-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 194,39  LineMapIndex:368
                                                                                              out.print(request.getParameter("r"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(193,41);to=(243,27)]
                                                                                              out.write("';\r\n\t\tif(r == 'rol') view = 'view';\t\t\r\n\t\tvar maHS = document.getElementsByName('idCuocTtkt')[0].value;\r\n\t\topenWindow(\"UploadAction.do?parentId=\"+maHS+\"&nv=TTKT/DC&view=\"+view);\t\t\r\n\t}\r\n\tfunction getTen(controlId){ \r\n\t\tdocument.getElementsByName(controlId.name.replace('nguoiNhanId', 'nguoiNhanName'))[0].value = controlId[controlId.selectedIndex].text;\r\n\t}\r\n\t$(document).ready(function(){\r\n \t\tvar arr = $(\".decuong\");\r\n \t\tfor ( var i = 0; i < arr.length; i = i + 1 ) {\r\n    \t\tgetTen(arr[i]);\r\n\t\t};\r\n\t});\r\n\tfunction downLoadBieuMauDeCuong(){\r\n\t\t//var fullPath = window.location.protocol + \"//\" + window.location.host + \"\" + window.location.pathname+\"\"+window.location.search;\t\t\r\n\t\tvar thongTinQd = \"\";\r\n\t\t//var qdForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd');\t \r\n\t\tvar qdForm = document.getElementById('quyetDinhForm');\r\n\t\tfor(var i = 0; i< qdForm.elements.length; i++){\r\n\t\t\tif(qdForm.elements[i].name != null && qdForm.elements[i].name != '' && qdForm.elements[i].value != null && qdForm.elements[i].value != '')\r\n\t\t\tthongTinQd += qdForm.elements[i].name + \"=\" + encodeURIComponent(qdForm.elements[i].value) + \"&\";\r\n\t\t}\t\t\r\n\t\tthongTinQd += 'idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;\r\n\t\t//var printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=dc');\t\r\n\t\tvar printfForm =document.getElementById('deCuongForm');\r\n\t\tthongTinDc = \"\";\r\n\t\tfor(var i = 0; i< printfForm.elements.length; i++){\r\n\t\t\tif(printfForm.elements[i].name != null \r\n\t\t\t&& printfForm.elements[i].name != '' \r\n\t\t\t&& printfForm.elements[i].name != 'fileDinhKemDeCuong' \r\n\t\t\t&& printfForm.elements[i].value != null \r\n\t\t\t&& printfForm.elements[i].value != '')\r\n\t\t\t\tthongTinDc += printfForm.elements[i].name + \"=\" + encodeURIComponent(printfForm.elements[i].value) + \"&\";\t\t\t\t\r\n\t\t}\r\n\t\tconsole.log(printfForm);\r\n\t\tprintfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=bmdc&' + thongTinQd ;//+ '&' + thongTinDc;\r\n\t\t//alert(thongTinDc);\r\n\t\tprintfForm.submit();\r\n\t\tprintfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=dc';\r\n\t\t//window.location = fullPath;\r\n\t\t//location.reload();\r\n\t}\r\n\tfunction checkAttackDeCuong(){\r\n\t\tif(document.getElementById('trDinhKemFileDC').style.display == 'inline')\r\n\t\t\tdocument.getElementById('trDinhKemFileDC').style.display = 'none';\r\n\t\telse\r\n\t\t\tdocument.getElementById('trDinhKemFileDC').style.display = 'inline';\r\n\t}\r\n\tfunction validateNgayLapDeCuong(){\r\n\t\tvar thoi_gian_gia_han = '");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 244,30-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 244,71  LineMapIndex:369
                                                                                              out.print(request.getAttribute("thoi_gian_gia_han"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(243,73);to=(460,0)]
                                                                                              out.write("';\r\n\t\tif(thoi_gian_gia_han!=null&&thoi_gian_gia_han!='null'&&thoi_gian_gia_han!=''&thoi_gian_gia_han!=' '){\r\n\t\tif(d2n(document.getElementsByName('ngayLapDeCuong')[0].value) < d2n(thoi_gian_gia_han)){\r\n\t\t\talert('Cảnh báo: Ngày lập đề cương không được trước ngày ra hạn ('+thoi_gian_gia_han+')!');\r\n\t\t\t//document.getElementsByName('ngayLapDeCuong')[0].focus();\r\n\t\t}\r\n\t\tcaculateDate('ngayRaQuyetDnh', 'truongGiuNgayTam', strNgayLapDeCuong);\r\n\t\tif(d2n(document.getElementsByName('ngayLapDeCuong')[0].value) > d2n(document.getElementsByName('truongGiuNgayTam')[0].value)){\t\t\t\r\n\t\t\talert('Cảnh báo quá hạn: Đề cương lập sau quyết định quá '+ strNgayLapKeHoach + ' ngày!');\r\n\t\t}\r\n\t\t}\r\n\t}\r\n\tfunction inDeCuong(){ \r\n\t\tif(!validateInDeCuong())        \r\n\t\t\treturn;\r\n\t\tvar thongTinQd = \"\";\r\n\t\tvar qdForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd');\t \r\n\t\tfor(var i = 0; i< qdForm.elements.length; i++){\r\n\t\t\tif(qdForm.elements[i].name != null && qdForm.elements[i].name != '' && qdForm.elements[i].value != null && qdForm.elements[i].value != '')\r\n\t\t\tthongTinQd += qdForm.elements[i].name + \"=\" + encodeURIComponent(qdForm.elements[i].value) + \"&\";\r\n\t\t}\t\t\r\n\t\tthongTinQd += 'idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;\r\n\t\tvar printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=dc');\t\r\n\t\tthongTinDc = \"\";\r\n\t\tfor(var i = 0; i< printfForm.elements.length; i++){\r\n\t\t\tif(printfForm.elements[i].name != null && printfForm.elements[i].name != '' && printfForm.elements[i].name != 'fileDinhKemDeCuong' && printfForm.elements[i].value != null && printfForm.elements[i].value != '')\r\n\t\t\t\tthongTinDc += printfForm.elements[i].name + \"=\" + encodeURIComponent(printfForm.elements[i].value) + \"&\";\r\n\t\t}\r\n\t\tprintfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=dc&' + thongTinQd;// + '&' + thongTinDc;\r\n\t\tprintfForm.submit();\r\n\t\tprintfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=dc'; \r\n\t}\r\n\tfunction selectAllBaoCao(chkBxSelectAll){\r\n\t\tbangBaoCao.selectAllRow();\r\n\t}\r\n\tfunction selectBaoCao(chckBox){\r\n\t}\t\r\n\tfunction selectHsTl(chckBox){ \r\n\t}\t\r\n\tvar bangBaoCao = new TableObject('tblBaoCao', false, 'xoaTblBaoCao');\r\n\tvar index = 0;\t\r\n\tfunction themBaoCao(){\r\n\t\tbangBaoCao.addRow(createNewBaoCaoRow());\r\n\t\ttry{\r\n\t\t\tvar strThoiGianBanGiao = document.getElementsByName(\"dsBaoCao[\" + eval(index-1) + \"].strThoiGianBanGiao\")[0].value;\r\n\t\t\tdocument.getElementsByName(\"dsBaoCao[\" + eval(index) + \"].strThoiGianBanGiao\")[0].value = strThoiGianBanGiao;\r\n\t\t\t\r\n\t\t\tvar oldObj =  document.getElementsByName(\"dsBaoCao[\" + eval(index-1) + \"].nguoiNhanId\")[0];\r\n\t\t\tvar curObj =  document.getElementsByName(\"dsBaoCao[\" + eval(index) + \"].nguoiNhanId\")[0];\r\n\t\t\tcurObj[oldObj.selectedIndex].selected = \"selected\";\r\n\t\t}catch(Exception){}\r\n\t}\r\n\t\r\n\tfunction xoaBaoCao(){\r\n\t\tbangBaoCao.deleteSelectedRow();\r\n\t}\t\r\n\tfunction createNewBaoCaoRow(){\t\t\r\n\t\tarrNewBaoCaoRow = new Array();\r\n\t\tindex = bangBaoCao.numOfRow - 1;\r\n\t\tarrNewBaoCaoRow[0] = '<input type=\"text\" id=\"ten' + index +'\" name=\"dsBaoCao[' + index + '].ten\" class=\"text1\" onclick=\"showContents(event);\">'\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\tarrNewBaoCaoRow[1] = '<input type=\"text\" id=\"noiDung' + index +'\" name=\"dsBaoCao[' + index + '].noiDung\" class=\"text1\" onkeypress=\"showContents(event);\" onchange=\"showContents(event);\" onclick=\"showContents(event);\" >'\t\t\t\t\t\t\t\t\t\r\n\t\tarrNewBaoCaoRow[2] = '<input type=\"text\" style = \"width:65\" onkeypress=\"return formatDate(event, this)\" onblur=\"isDate(this)\" name=\"dsBaoCao[' + index + '].strThoiKyTu\" class=\"text1\" > - '\t\t\t\t\t\t\r\n\t\tarrNewBaoCaoRow[2] += '<input type=\"text\" style = \"width:65\" onkeypress=\"return formatDate(event, this)\" onblur=\"isDate(this)\" name=\"dsBaoCao[' + index + '].strThoiKyDen\" class=\"text1\" >'\t\t\t\t\t\t\r\n\t\tarrNewBaoCaoRow[3] = '<input type=\"text\" name=\"dsBaoCao[' + index + '].hinhThuc\" class=\"text1\" >'\t\t\t\t\t\t\r\n\t\tarrNewBaoCaoRow[4] = '<input type=\"text\" onkeypress=\"return formatDate(event, this)\" onblur=\"isDate(this)\" name=\"dsBaoCao[' + index + '].strThoiGianBanGiao\" class=\"text1\" >'\t\t\t\t\t\t\r\n\t\tarrNewBaoCaoRow[5] = '<input type=\"text\" name=\"dsBaoCao[' + index + '].diaDiemNhanName\" class=\"text1\" value = \"' + document.getElementsByName('diaDiem')[0].value + '\">'\t\t\t\t\t\t\r\n\t\tarrNewBaoCaoRow[6] = '<select name = \"dsBaoCao[' + index + '].nguoiNhanId\" onchange=\"getTen(this)\">'\r\n\t\tarrNewBaoCaoRow[6] += document.getElementsByName('dsTvdLapDeCuong')[0].innerHTML;\r\n\t\tarrNewBaoCaoRow[6] += '</select>'\t\t\r\n\t\tarrNewBaoCaoRow[6] += '<INPUT type=\"hidden\" name=\"dsBaoCao[' + index + '].nguoiNhanName\">'\r\n\t\tarrNewBaoCaoRow[7] = '<INPUT type=\"checkbox\" onclick=\"selectBaoCao(this)\">'\t\r\n\t\treturn arrNewBaoCaoRow;\r\n\t}\r\n\tvar bangHsTl = new TableObject('tblHsTl', false, 'xoaTblHsTl');\r\n\tfunction themHoSoTl(){\r\n\t\tbangHsTl.addRow(createNewHsTlRow());\r\n\t\ttry{\r\n\t\t\tvar strThoiGianBanGiao = document.getElementsByName(\"dsHoSoTl[\" + eval(index-1) + \"].strThoiGianBanGiao\")[0].value;\r\n\t\t\tdocument.getElementsByName(\"dsHoSoTl[\" + eval(index) + \"].strThoiGianBanGiao\")[0].value = strThoiGianBanGiao;\r\n\t\t\t\r\n\t\t\tvar oldObj =  document.getElementsByName(\"dsHoSoTl[\" + eval(index-1) + \"].nguoiNhanId\")[0];\r\n\t\t\tvar curObj =  document.getElementsByName(\"dsHoSoTl[\" + eval(index) + \"].nguoiNhanId\")[0];\r\n\t\t\tcurObj[oldObj.selectedIndex].selected = \"selected\";\r\n\t\t\tgetTen(document.getElementsByName(\"dsHoSoTl[\" + eval(index) + \"].nguoiNhanId\")[0]);\r\n\t\t\t//alert(document.getElementsByName(\"dsHoSoTl[\" + eval(index) + \"].nguoiNhanName\")[0].value);\r\n\t\t}catch(Exception){}\r\n\t}  \r\n\t\r\n\tfunction createNewHsTlRow(){\r\n\t\tarrNewHsTlRow = new Array();\r\n\t\tindex = bangHsTl.numOfRow - 1;\r\n\t\tarrNewHsTlRow[0] = '<input type=\"text\" id=\"dsHoSoTl_ten_' + index +'\"  name=\"dsHoSoTl[' + index + '].ten\" class=\"text1\" onclick=\"showContents(event);\">'\t\t\t\t\t\t\r\n\t\tarrNewHsTlRow[1] = '<input type=\"text\" onkeypress=\"return formatDate(event, this)\" onblur=\"isDate(this)\" name=\"dsHoSoTl[' + index + '].strThoiGianBanGiao\" class=\"text1\" >'\r\n\t\tarrNewHsTlRow[2] = '<input type=\"text\" name=\"dsHoSoTl[' + index + '].diaDiemNhanName\" class=\"text1\" value = \"' + document.getElementsByName('diaDiem')[0].value + '\">'\t\t\t\t\t\t\r\n\t\tarrNewHsTlRow[3] = '<select name = \"dsHoSoTl[' + index + '].nguoiNhanId\" onchange=\"getTen(this)\" onload=\"getTen(this)\">'\r\n\t\tarrNewHsTlRow[3] += document.getElementsByName('dsTvdLapDeCuong')[0].innerHTML;\t\r\n\t\tarrNewHsTlRow[3] += '</select>'\t\r\n\t\tarrNewHsTlRow[3] += '<INPUT type=\"hidden\" name=\"dsHoSoTl[' + index + '].nguoiNhanName\">'\t\t\r\n\t\tarrNewHsTlRow[4] = '<INPUT type=\"checkbox\" onclick=\"selectHsTl(this)\">'\t\t\r\n\t\treturn arrNewHsTlRow;\r\n\t}\r\n\t\r\n\tfunction selectAllHsTl(chkBxSelectAll){\r\n\t\tbangHsTl.selectAllRow();  \r\n\t}\r\n\t\r\n\t\r\n\t\r\n\tfunction onloadDeCuong(){ \r\n\t\t//document.getElementById('trDinhKemFileDC').style.display = isEmpty(document.getElementsByName('maFileDeCuong')[0].value)? 'none': 'inline';\t\t \r\n\t}\r\n\tfunction validateInDeCuong(){\r\n\t\tif(!isRequired(document.getElementsByName('noiLapDeCuong')[0]))\r\n\t\t\treturn false;\r\n\t\tif(!isRequired(document.getElementsByName('ngayLapDeCuong')[0]))\r\n\t\t\treturn false;\r\n\t\tif(!compareDate(document.getElementsByName('ngayRaQuyetDnh')[0], document.getElementsByName('ngayLapDeCuong')[0], 'Ngày đề cương phải lớn hơn hoặc bằng ngày ra quyết định!')){\r\n\t\t\tdocument.getElementsByName('ngayLapDeCuong')[0].focus();\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\tif(bangBaoCao.numOfRow <=1 && bangHsTl.numOfRow <=1){\r\n\t\t\talert('Bạn phải nhập báo cáo hoặc hồ sơ tài liệu cần chuẩn bị và cung cấp!');\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\tif(!validateGridBaoCao())\r\n\t\t\treturn false;\r\n\t\tif(!validateGridHsTl()) \r\n\t\t\treturn false;\r\n\t\treturn true;\r\n\t}\r\n\tfunction validateDeCuong(){\r\n\t\tif(!validateInDeCuong()) \r\n\t\t\treturn false; \r\n\t\t// Neu chon dinh kem file va chua co file ke hoach thi bat buoc nhap file dinh kem\r\n\t\t/*if(document.getElementById('checkAttackFileDC').checked){\r\n\t\t\tif(isEmpty(document.getElementsByName('maFileDeCuong')[0].value))  \r\n\t\t\t\tif(!isRequired(document.getElementsByName('fileDinhKemDeCuong')[0]))\r\n\t\t\t\t\treturn false;\r\n\t\t\tdocument.getElementsByName('isAttackDeCuong')[0].value = \"true\";\r\n\t\t}\t\t\t\r\n\t\telse{\r\n\t\t\tdocument.getElementsByName('isAttackDeCuong')[0].value = \"false\";\r\n\t\t}*/\r\n\t\tif(!checkNvarchar2('nhungVanDeKhac', 'Chỉ được nhập tối đa 4000 ký tự!'))\r\n\t\treturn false;\r\n\t\treturn true;\r\n\t}\r\n\t\r\n\tfunction validateGridBaoCao(){\r\n\t\tif(bangBaoCao.numOfRow <= 1) \r\n\t\t\treturn true;\r\n\t\tfor(i = 1; i < bangBaoCao.numOfRow; i++){\r\n\t\t\tif(!isRequired(document.getElementsByName('dsBaoCao['+ eval(i - 1) +'].ten')[0]))\r\n\t\t\t\treturn false;\r\n\t\t\tif(!isRequired(document.getElementsByName('dsBaoCao['+ eval(i - 1) +'].strThoiGianBanGiao')[0]))\t\t\t\r\n\t\t\t\treturn false;\r\n\t\t\tif(!isRequired(document.getElementsByName('dsBaoCao['+ eval(i - 1) +'].diaDiemNhanName')[0]))\r\n\t\t\t\treturn false;\r\n\t\t\tif(!isRequired(document.getElementsByName('dsBaoCao['+ eval(i - 1) +'].nguoiNhanId')[0]))\r\n\t\t\t\treturn false;\r\n\t\t}\r\n\t\treturn true; \r\n\t}\r\n\tfunction validateGridHsTl(){\r\n\t\tif(bangHsTl.numOfRow <= 1)\r\n\t\t\treturn true;\r\n\t\tfor(i = 1; i < bangHsTl.numOfRow; i++){\r\n\t\t\tif(!isRequired(document.getElementsByName('dsHoSoTl['+ eval(i - 1)  +'].ten')[0]))\r\n\t\t\t\treturn false;\r\n\t\t\tif(!isRequired(document.getElementsByName('dsHoSoTl['+ eval(i - 1) +'].strThoiGianBanGiao')[0]))\r\n\t\t\t\treturn false;\r\n\t\t\tif(!isRequired(document.getElementsByName('dsHoSoTl['+ eval(i - 1) +'].diaDiemNhanName')[0]))\r\n\t\t\t\treturn false;\r\n\t\t\tif(!isRequired(document.getElementsByName('dsHoSoTl['+ eval(i - 1) +'].nguoiNhanId')[0]))\r\n\t\t\t\treturn false;\r\n\t\t}\r\n\t\treturn true;\r\n\t}\r\n\t\r\n\tvar idContents = \"\";\r\n\tfunction showContents(event){\r\n\t\tvar ecurObj;\r\n\t\tvar ev;\r\n\t\tif(!window.Event){\r\n\t    \tcurObj = event.srcElement;\r\n\t    \tev = event;\r\n\t    }\r\n\t    else{\r\n\t    \tcurObj = e.target;\r\n\t    \tev = e;\r\n\t   \t}\r\n\t   \t\r\n\t   \tidContents = curObj.id;\r\n\t\tdocument.getElementById(\"Contents\").style.top = ev.y;\r\n\t\tdocument.getElementById(\"Contents\").style.left = ev.x;\r\n\t\tdocument.getElementById(\"Contents\").style.display = \"block\";\r\n\t\tdocument.getElementById(\"Contents\").style.width = \"500px\";\r\n\t\tdocument.getElementById(\"Contents\").style.height = \"200px\";\r\n\t\tdocument.getElementById(\"Area\").value = curObj.value;\r\n\t\tdocument.getElementById(\"Area\").style.width = \"500px\";\r\n\t\tdocument.getElementById(\"Area\").style.height = \"200px\";\r\n\t\t\r\n\t\tdocument.getElementById(\"Area\").focus();\r\n\t}\r\n\t\r\n\tfunction hideContents(){\r\n\t\tdocument.getElementById(\"Contents\").style.display = \"none\";\r\n\t}\r\n\tfunction validateForm(){\r\n\t\treturn true;\r\n\t}\r\n\tfunction changeContents(obj){\r\n\t\tdocument.getElementById(idContents).value = obj.value;\r\n\t\tdocument.getElementById(idContents).focus();\r\n\t\thideContents();\r\n\t}\r\n</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 461,0-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 461,34  LineMapIndex:370
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_14 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_14.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_14.setParent(null);
                                                                                              _jspx_th_logic_notPresent_14.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_14);
                                                                                              int _jspx_eval_logic_notPresent_14 = _jspx_th_logic_notPresent_14.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(460,34);to=(462,26)]
                                                                                              out.write("\r\n\t<script language=\"javascript\">\r\n\t\tvar strNgayLapDeCuong = ");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 463,29-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 463,78  LineMapIndex:371
                                                                                              out.print((String)request.getAttribute("ngay_lap_de_cuong"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(462,80);to=(464,0)]
                                                                                              out.write("\r\n\t</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 465,0-"/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp" 465,19  LineMapIndex:372
                                                                                              } while (_jspx_th_logic_notPresent_14.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp";from=(464,19);to=(465,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(39,93);to=(42,30)]
                                                                                              out.write("</fieldset>\r\n</DIV>\r\n<DIV id=\"tabHopDoanTrienKhai\">\r\n<fieldset style=\"width: 100%\">");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(0,31);to=(1,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(1,56);to=(2,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(2,58);to=(3,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(3,56);to=(6,1)]
                                                                                              out.write("\r\n<SELECT id=\"cbDsTvdHopDoanTrienKhai\" style=\"display: none;\">\r\n\t<OPTION value=\"\"></OPTION>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 7,1-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 7,50  LineMapIndex:373
                                                                                              /* ------  logic:iterate ------ */
                                                                                              org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_3 = new org.apache.struts.taglib.logic.IterateTag();
                                                                                              _jspx_th_logic_iterate_3.setPageContext(pageContext);
                                                                                              _jspx_th_logic_iterate_3.setParent(null);
                                                                                              _jspx_th_logic_iterate_3.setName("dsTvdHopTrienKhai");
                                                                                              _jspx_th_logic_iterate_3.setId("tvd");
                                                                                              { // begin scope of tag variables
                                                                                              _jspxTagObjects.push(_jspx_th_logic_iterate_3);
                                                                                              int _jspx_eval_logic_iterate_3 = _jspx_th_logic_iterate_3.doStartTag();
                                                                                              if (_jspx_eval_logic_iterate_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_logic_iterate_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_logic_iterate_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_logic_iterate_3.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              java.lang.Object tvd = null;
                                                                                              tvd = (java.lang.Object) pageContext.findAttribute("tvd");
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(6,50);to=(7,17)]
                                                                                              out.write("\r\n\t\t<OPTION value=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 8,17-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 8,60  LineMapIndex:374
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_1 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_1.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_1.setParent(_jspx_th_logic_iterate_3);
                                                                                              _jspx_th_bean_write_1.setName("tvd");
                                                                                              _jspx_th_bean_write_1.setProperty("idCanBo");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_1);
                                                                                              int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 8,17-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 8,60  LineMapIndex:375
                                                                                              if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(7,60);to=(7,69)]
                                                                                              out.write("\" title=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 8,69-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 8,120  LineMapIndex:376
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_2 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_2.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_2.setParent(_jspx_th_logic_iterate_3);
                                                                                              _jspx_th_bean_write_2.setName("tvd");
                                                                                              _jspx_th_bean_write_2.setProperty("chucVuTrongDoan");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_2);
                                                                                              int _jspx_eval_bean_write_2 = _jspx_th_bean_write_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 8,69-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 8,120  LineMapIndex:377
                                                                                              if (_jspx_th_bean_write_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(7,120);to=(7,122)]
                                                                                              out.write("\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 8,122-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 8,167  LineMapIndex:378
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_3 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_3.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_3.setParent(_jspx_th_logic_iterate_3);
                                                                                              _jspx_th_bean_write_3.setName("tvd");
                                                                                              _jspx_th_bean_write_3.setProperty("tenCanBo");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_3);
                                                                                              int _jspx_eval_bean_write_3 = _jspx_th_bean_write_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 8,122-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 8,167  LineMapIndex:379
                                                                                              if (_jspx_th_bean_write_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(7,167);to=(8,1)]
                                                                                              out.write("</OPTION>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 9,1-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 9,17  LineMapIndex:380
                                                                                              } while (_jspx_th_logic_iterate_3.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_logic_iterate_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_logic_iterate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              } // end scope of tag variables
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(8,17);to=(10,0)]
                                                                                              out.write("\r\n</SELECT>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 11,0-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 11,78  LineMapIndex:381
                                                                                              /* ------  html:form ------ */
                                                                                              org.apache.struts.taglib.html.FormTag _jspx_th_html_form_6 = new org.apache.struts.taglib.html.FormTag();
                                                                                              _jspx_th_html_form_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_form_6.setParent(null);
                                                                                              _jspx_th_html_form_6.setAction("chuan_bi_tien_hanh.do?method=save&type=hdtk");
                                                                                              _jspx_th_html_form_6.setMethod("POST");
                                                                                              _jspxTagObjects.push(_jspx_th_html_form_6);
                                                                                              int _jspx_eval_html_form_6 = _jspx_th_html_form_6.doStartTag();
                                                                                              if (_jspx_eval_html_form_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(10,78);to=(15,32)]
                                                                                              out.write("\r\n\t<table align=\"left\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Thời điểm bắt đầu <font color=red>*</font></td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 16,32-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 16,193  LineMapIndex:382
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_34 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_34.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_34.setParent(_jspx_th_html_form_6);
                                                                                              _jspx_th_html_text_34.setStyleClass("text");
                                                                                              _jspx_th_html_text_34.setOnkeypress("return formatTime(event, this)");
                                                                                              _jspx_th_html_text_34.setOnblur("if(!isTime(this)) return;validateDateRequired(this);");
                                                                                              _jspx_th_html_text_34.setProperty("thoiDiemBatDau");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_34);
                                                                                              int _jspx_eval_html_text_34 = _jspx_th_html_text_34.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 16,32-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 16,205  LineMapIndex:383
                                                                                              if (_jspx_th_html_text_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(15,205);to=(18,32)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\" width=\"19%\">Địa điểm họp <font color=red>*</font></td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 19,32-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 19,83  LineMapIndex:384
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_35 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_35.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_35.setParent(_jspx_th_html_form_6);
                                                                                              _jspx_th_html_text_35.setStyleClass("text");
                                                                                              _jspx_th_html_text_35.setProperty("diaDiemHop");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_35);
                                                                                              int _jspx_eval_html_text_35 = _jspx_th_html_text_35.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 19,32-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 19,95  LineMapIndex:385
                                                                                              if (_jspx_th_html_text_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(18,95);to=(23,45)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Về việc <font color=red>*</font></td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" width=\"100%\" colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 24,45-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 24,162  LineMapIndex:386
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_13 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_13.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_13.setParent(_jspx_th_html_form_6);
                                                                                              _jspx_th_html_textarea_13.setStyleClass("textareaTitle");
                                                                                              _jspx_th_html_textarea_13.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_13.setStyle("width: 100%");
                                                                                              _jspx_th_html_textarea_13.setProperty("veViec");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_13);
                                                                                              int _jspx_eval_html_textarea_13 = _jspx_th_html_textarea_13.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 24,45-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 24,178  LineMapIndex:387
                                                                                              if (_jspx_th_html_textarea_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(23,178);to=(37,4)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Thành phần tham dự <font color=red>*</font></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td align=\"left\" width=\"100%\" colspan=\"4\">\r\n\t\t\t<fieldset id=\"FIELDSET\" style=\"width: 100%; margin: 0\">\r\n\t\t\t<TABLE id=\"tb_DS_TPTD\" width=\"100%\">\r\n\t\t\t\t<tr class=\"TdHeaderList\">\r\n\t\t\t\t\t<TH width=\"10%\">STT</TH>\r\n\t\t\t\t\t<TH width=\"40%\">Ông (bà) <font color=red>*</font></TH>\r\n\t\t\t\t\t<TH width=\"40%\">Chức vụ <font color=red>*</font></TH>\r\n\t\t\t\t\t<TH width=\"10%\"><INPUT type=\"checkbox\" name=\"selectAll\" onclick=\"selectAll123xxxxxxxxxxxxx(this)\"></TH>\r\n\t\t\t\t</tr>\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 38,4-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 38,89  LineMapIndex:388
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_11 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_11.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_11.setParent(_jspx_th_html_form_6);
                                                                                              _jspx_th_logic_present_11.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_present_11.setProperty("thanhPhanThamDuHopDoanTrienKhai");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_11);
                                                                                              int _jspx_eval_logic_present_11 = _jspx_th_logic_present_11.doStartTag();
                                                                                              if (_jspx_eval_logic_present_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(37,89);to=(38,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 39,5-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 39,125  LineMapIndex:389
                                                                                              /* ------  logic:iterate ------ */
                                                                                              org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_4 = new org.apache.struts.taglib.logic.IterateTag();
                                                                                              _jspx_th_logic_iterate_4.setPageContext(pageContext);
                                                                                              _jspx_th_logic_iterate_4.setParent(_jspx_th_logic_present_11);
                                                                                              _jspx_th_logic_iterate_4.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_logic_iterate_4.setProperty("thanhPhanThamDuHopDoanTrienKhai");
                                                                                              _jspx_th_logic_iterate_4.setIndexId("index");
                                                                                              _jspx_th_logic_iterate_4.setId("thanhVienDoan");
                                                                                              { // begin scope of tag variables
                                                                                              _jspxTagObjects.push(_jspx_th_logic_iterate_4);
                                                                                              int _jspx_eval_logic_iterate_4 = _jspx_th_logic_iterate_4.doStartTag();
                                                                                              if (_jspx_eval_logic_iterate_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_logic_iterate_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_logic_iterate_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_logic_iterate_4.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              java.lang.Object thanhVienDoan = null;
                                                                                              thanhVienDoan = (java.lang.Object) pageContext.findAttribute("thanhVienDoan");
                                                                                              java.lang.Integer index = null;
                                                                                              index = (java.lang.Integer) pageContext.findAttribute("index");
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(38,125);to=(39,20)]
                                                                                              out.write("\r\n\t\t\t\t\t\t<tr class='row");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 40,23-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 40,48  LineMapIndex:390
                                                                                              out.print((index.intValue() % 2)+1 );
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(39,50);to=(40,26)]
                                                                                              out.write("'>\r\n\t\t\t\t\t\t\t<td align=\"center\">");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 41,29-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 41,49  LineMapIndex:391
                                                                                              out.print(index.intValue() + 1);
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(40,51);to=(41,11)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 42,11-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 42,207  LineMapIndex:392
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_8 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_8.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_8.setParent(_jspx_th_logic_iterate_4);
                                                                                              _jspx_th_html_select_8.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_select_8.setProperty("thanhPhanThamDuHopDoanTrienKhai[" + index + "].idCanBo");
                                                                                              _jspx_th_html_select_8.setOnclick("cacheOldValue(this)");
                                                                                              _jspx_th_html_select_8.setOnchange("chonThanhVienDoan(this)");
                                                                                              _jspx_th_html_select_8.setStyle("width:80%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_select_8);
                                                                                              int _jspx_eval_html_select_8 = _jspx_th_html_select_8.doStartTag();
                                                                                              if (_jspx_eval_html_select_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_select_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_select_8.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_select_8.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(41,207);to=(42,8)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 43,8-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 43,99  LineMapIndex:393
                                                                                              /* ------  html:options ------ */
                                                                                              org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_5 = new org.apache.struts.taglib.html.OptionsTag();
                                                                                              _jspx_th_html_options_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_options_5.setParent(_jspx_th_html_select_8);
                                                                                              _jspx_th_html_options_5.setCollection("dsTvdHopTrienKhai");
                                                                                              _jspx_th_html_options_5.setProperty("idCanBo");
                                                                                              _jspx_th_html_options_5.setLabelProperty("tenCanBo");
                                                                                              _jspxTagObjects.push(_jspx_th_html_options_5);
                                                                                              int _jspx_eval_html_options_5 = _jspx_th_html_options_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 43,8-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 43,99  LineMapIndex:394
                                                                                              if (_jspx_th_html_options_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(42,99);to=(43,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 44,7-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 44,21  LineMapIndex:395
                                                                                              } while (_jspx_th_html_select_8.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_select_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_select_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(43,21);to=(43,22)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 44,22-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 44,135  LineMapIndex:396
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_32 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_32.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_32.setParent(_jspx_th_logic_iterate_4);
                                                                                              _jspx_th_html_hidden_32.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_hidden_32.setProperty("thanhPhanThamDuHopDoanTrienKhai[" + index + "].hoTen");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_32);
                                                                                              int _jspx_eval_html_hidden_32 = _jspx_th_html_hidden_32.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 44,22-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 44,135  LineMapIndex:397
                                                                                              if (_jspx_th_html_hidden_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(43,135);to=(44,11)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 45,11-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 45,195  LineMapIndex:398
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_36 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_36.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_36.setParent(_jspx_th_logic_iterate_4);
                                                                                              _jspx_th_html_text_36.setName("ChuanBiTienHanhForm");
                                                                                              _jspx_th_html_text_36.setProperty("thanhPhanThamDuHopDoanTrienKhai[" + index + "].chucVu");
                                                                                              _jspx_th_html_text_36.setStyleClass("text1");
                                                                                              _jspx_th_html_text_36.setReadonly(true);
                                                                                              _jspx_th_html_text_36.setStyle("border-bottom:none; width:100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_36);
                                                                                              int _jspx_eval_html_text_36 = _jspx_th_html_text_36.doStartTag();
                                                                                              if (_jspx_eval_html_text_36 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_text_36 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_text_36.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_text_36.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(44,195);to=(45,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 46,7-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 46,19  LineMapIndex:399
                                                                                              } while (_jspx_th_html_text_36.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_text_36 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_text_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(45,19);to=(48,5)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t\t\t<td align=\"center\"><INPUT type=\"checkbox\" name=\"checkBoxTpTD\" onclick=\"chonThanhPhanThamDu(this)\"></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 49,5-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 49,21  LineMapIndex:400
                                                                                              } while (_jspx_th_logic_iterate_4.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_logic_iterate_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_logic_iterate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              } // end scope of tag variables
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(48,21);to=(49,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 50,4-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 50,20  LineMapIndex:401
                                                                                              } while (_jspx_th_logic_present_11.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(49,20);to=(58,45)]
                                                                                              out.write("\r\n\t\t\t</TABLE>\r\n\t\t\t<DIV align=\"right\" style=\"text-align: right;\"><INPUT type=\"button\" onclick=\"themThanhPhanThamDu()\" value=\"Thêm\" id=\"addRow\"> <INPUT type=\"button\" onclick=\"xoaThanhVienThamDuHopDoanTrienKhai()\" value=\"Xóa\" id=\"xoaTblTpTdHopDoanTrienKhai\"></DIV>\r\n\t\t\t</fieldset>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Nội dung <font color=red>*</font></td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" width=\"100%\" colspan=\"4\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 59,45-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 59,181  LineMapIndex:402
                                                                                              /* ------  html:textarea ------ */
                                                                                              org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_14 = new org.apache.struts.taglib.html.TextareaTag();
                                                                                              _jspx_th_html_textarea_14.setPageContext(pageContext);
                                                                                              _jspx_th_html_textarea_14.setParent(_jspx_th_html_form_6);
                                                                                              _jspx_th_html_textarea_14.setStyleClass("textareaContent");
                                                                                              _jspx_th_html_textarea_14.setOnkeypress("imposeMaxLength(this);");
                                                                                              _jspx_th_html_textarea_14.setProperty("noiDungHopDoanTrienKhai");
                                                                                              _jspx_th_html_textarea_14.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_textarea_14);
                                                                                              int _jspx_eval_html_textarea_14 = _jspx_th_html_textarea_14.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 59,45-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 59,197  LineMapIndex:403
                                                                                              if (_jspx_th_html_textarea_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(58,197);to=(63,32)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Thời điểm kết thúc <font color=red>*</font></td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 64,32-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 64,195  LineMapIndex:404
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_37 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_37.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_37.setParent(_jspx_th_html_form_6);
                                                                                              _jspx_th_html_text_37.setStyleClass("text");
                                                                                              _jspx_th_html_text_37.setOnkeypress("return formatTime(event, this)");
                                                                                              _jspx_th_html_text_37.setOnblur("if(!isTime(this)) return;validateDateRequired(this);");
                                                                                              _jspx_th_html_text_37.setProperty("thoiDiemKetThuc");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_37);
                                                                                              int _jspx_eval_html_text_37 = _jspx_th_html_text_37.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 64,32-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 64,207  LineMapIndex:405
                                                                                              if (_jspx_th_html_text_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(63,207);to=(69,1)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\" width=\"19%\"></td>\r\n\t\t\t<td style=\"width: 1%; min-width: 5px\"></td>\r\n\t\t\t<td align=\"right\" width=\"30%\"><INPUT type=\"button\" class=\"button1\" onclick=\"inBienBanHopDoanTrienKhai()\" value=\"In biên bản\"></td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 70,1-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 70,53  LineMapIndex:406
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_33 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_33.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_33.setParent(_jspx_th_html_form_6);
                                                                                              _jspx_th_html_hidden_33.setProperty("idBienBanHopTrienKhaiDoan");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_33);
                                                                                              int _jspx_eval_html_hidden_33 = _jspx_th_html_hidden_33.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 70,1-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 70,53  LineMapIndex:407
                                                                                              if (_jspx_th_html_hidden_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(69,53);to=(70,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 71,1-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 71,52  LineMapIndex:408
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_34 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_34.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_34.setParent(_jspx_th_html_form_6);
                                                                                              _jspx_th_html_hidden_34.setProperty("isChangeHopDoanTrienKhai");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_34);
                                                                                              int _jspx_eval_html_hidden_34 = _jspx_th_html_hidden_34.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 71,1-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 71,52  LineMapIndex:409
                                                                                              if (_jspx_th_html_hidden_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(70,52);to=(71,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 72,1-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 72,47  LineMapIndex:410
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_35 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_35.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_35.setParent(_jspx_th_html_form_6);
                                                                                              _jspx_th_html_hidden_35.setProperty("idDsTvdHopTrienKhai");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_35);
                                                                                              int _jspx_eval_html_hidden_35 = _jspx_th_html_hidden_35.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 72,1-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 72,47  LineMapIndex:411
                                                                                              if (_jspx_th_html_hidden_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(71,47);to=(72,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 73,1-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 73,66  LineMapIndex:412
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_9 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_9.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_9.setParent(_jspx_th_html_form_6);
                                                                                              _jspx_th_html_select_9.setProperty("dsTvdHopTrienKhai");
                                                                                              _jspx_th_html_select_9.setStyle("display: none;");
                                                                                              _jspxTagObjects.push(_jspx_th_html_select_9);
                                                                                              int _jspx_eval_html_select_9 = _jspx_th_html_select_9.doStartTag();
                                                                                              if (_jspx_eval_html_select_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_select_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_select_9.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_select_9.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(72,66);to=(73,2)]
                                                                                              out.write("\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 74,2-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 74,24  LineMapIndex:413
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_9 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_9.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_9.setParent(_jspx_th_html_select_9);
                                                                                              _jspx_th_html_option_9.setValue("");
                                                                                              _jspxTagObjects.push(_jspx_th_html_option_9);
                                                                                              int _jspx_eval_html_option_9 = _jspx_th_html_option_9.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 74,2-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 74,38  LineMapIndex:414
                                                                                              if (_jspx_th_html_option_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(73,38);to=(74,2)]
                                                                                              out.write("\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 75,2-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 75,93  LineMapIndex:415
                                                                                              /* ------  html:options ------ */
                                                                                              org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_6 = new org.apache.struts.taglib.html.OptionsTag();
                                                                                              _jspx_th_html_options_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_options_6.setParent(_jspx_th_html_select_9);
                                                                                              _jspx_th_html_options_6.setCollection("dsTvdHopTrienKhai");
                                                                                              _jspx_th_html_options_6.setProperty("idCanBo");
                                                                                              _jspx_th_html_options_6.setLabelProperty("tenCanBo");
                                                                                              _jspxTagObjects.push(_jspx_th_html_options_6);
                                                                                              int _jspx_eval_html_options_6 = _jspx_th_html_options_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 75,2-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 75,93  LineMapIndex:416
                                                                                              if (_jspx_th_html_options_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(74,93);to=(75,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 76,1-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 76,15  LineMapIndex:417
                                                                                              } while (_jspx_th_html_select_9.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_select_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_select_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(75,15);to=(76,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 77,0-"/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp" 77,12  LineMapIndex:418
                                                                                              } while (_jspx_th_html_form_6.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_html_form_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp";from=(76,12);to=(204,9)]
                                                                                              out.write("\r\n<script language=\"javascript\">\r\nfunction inBienBanHopDoanTrienKhai(){\r\n\tif(!validateHopDoanTrienKhai())    \r\n\t\t\treturn;\r\n\tvar thongTinQd = \"\";\r\n\tvar qdForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd');\t \r\n\tfor(var i = 0; i< qdForm.elements.length; i++){\r\n\t\tif(qdForm.elements[i].name != null && qdForm.elements[i].name != '' && qdForm.elements[i].value != null && qdForm.elements[i].value != '')\r\n\t\tthongTinQd += qdForm.elements[i].name + \"=\" + encodeURIComponent(qdForm.elements[i].value) + \"&\";\r\n\t}\t\t\r\n\tthongTinQd += 'idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;\r\n\t\r\n\tvar printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=hdtk');\t\r\n\tprintfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=hdtk&' + thongTinQd;\r\n\tprintfForm.submit();\r\n\tprintfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=hdtk'; \r\n}\r\nvar selectedThanhPhanThamDu = \"\";\r\nvar bangThanhPhanThamDu = new TableObject('tb_DS_TPTD', true, 'xoaTblTpTdHopDoanTrienKhai');\r\nfunction selectAll123xxxxxxxxxxxxx(chkBxSelectAll){\r\n\tbangThanhPhanThamDu.selectAllRow();\r\n}\r\nfunction getCaNhanId(checkBox){\r\n\treturn checkBox.parentNode.parentNode.childNodes[1].childNodes[0].value;\r\n}\r\n\r\nfunction xoaThanhVienThamDuHopDoanTrienKhai(){\r\n\tbangThanhPhanThamDu.deleteSelectedRow();\r\n}\r\n\r\nfunction themThanhPhanThamDu() {\t\r\n\tbangThanhPhanThamDu.addRow(createNewThanhPhanThamDuRow());\r\n}\r\nfunction changeThanhPhanThamDu(cbThanhPhanThamDu){\r\n\tdocument.getElementsByName(cbThanhPhanThamDu.name.replace('.idCanBo', '.chucVu'))[0].value = getChucVuTrongDoan(cbThanhPhanThamDu.value);\t\r\n}\r\nfunction getChucVuTrongDoan(idCanBo){\r\n\t/*var tableDsThanhVienDoan = document.getElementById('tblDsTvd');\r\n\tvar allRows = tableDsThanhVienDoan.rows;\r\n\tfor(int i = 1; i< allRows.length; i++){\r\n\t\tif(allRows[i].cells[1].childNodes[0].value == idCanBo)\r\n\t\t\treturn \r\n\t}*/\r\n\treturn \"\";\r\n}\r\n\r\nfunction createNewThanhPhanThamDuRow(){\r\n\tarrNewThanhPhanThamDu = new Array();\r\n\tindex = bangThanhPhanThamDu.numOfRow - 1;\r\n\tarrNewThanhPhanThamDu[0] = '<SELECT name=\"thanhPhanThamDuHopDoanTrienKhai[' + index + '].idCanBo\" onclick=\"cacheOldValue(this)\" onchange=\"chonThanhVienDoan(this)\" style=\"width:80%\">';\t\r\n\tarrNewThanhPhanThamDu[0] += document.getElementsByName('dsTvdHopTrienKhai')[0].innerHTML;\r\n\tarrNewThanhPhanThamDu[0] += '</SELECT>';\r\n\tarrNewThanhPhanThamDu[0] += '<INPUT type=\"hidden\" name=\"thanhPhanThamDuHopDoanTrienKhai[' + index + '].hoTen\">'\r\n\t\r\n\tarrNewThanhPhanThamDu[1] = '<INPUT type=\"text\" class=\"text1\" readonly=\"true\" style=\"border-bottom:none; width:100%\" name=\"thanhPhanThamDuHopDoanTrienKhai[' + index + '].chucVu\"> ';\r\n\tarrNewThanhPhanThamDu[2] = '<INPUT type=checkbox>';\r\n\treturn arrNewThanhPhanThamDu; \r\n}\r\nvar tmpIdCanBo;\r\nvar tmpTenCanBo;\r\nvar tmpChucVu;\r\nfunction cacheOldValue(controlIdTvd){\r\n\ttmpIdCanBo = controlIdTvd.value;\r\n\ttmpTenCanBo = document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value;\r\n\ttmpChucVu = document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value;\r\n}\r\nfunction existInSelected(controlIdTvd){\r\n\tfor(var i = 0; i< bangThanhPhanThamDu.numOfRow - 1; i++){\r\n\t\telement = document.getElementsByName('thanhPhanThamDuHopDoanTrienKhai[' + i + '].idCanBo')[0];\r\n\t\tif(element != null && element != controlIdTvd && element.value == controlIdTvd.value)\r\n\t\t\treturn true;\t\t\t\r\n\t}\r\n\treturn false;\r\n}\r\nfunction chonThanhVienDoan(controlIdTvd){\t\r\n\tif(existInSelected(controlIdTvd)){\r\n\t\talert('Thành viên này đã được chọn!');\r\n\t\tcontrolIdTvd.value = tmpIdCanBo;\r\n\t\tdocument.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = tmpTenCanBo;\r\n\t\tdocument.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = tmpChucVu;\r\n\t\tcontrolIdTvd.focus();\r\n\t\treturn;\r\n\t}\r\n\tdsCanBoHopDoanTk = document.getElementById('cbDsTvdHopDoanTrienKhai');\r\n\tfor(var i = 0; i< dsCanBoHopDoanTk.length; i++){\r\n\t\tif(dsCanBoHopDoanTk[i].value == controlIdTvd.value){\r\n\t\t\tchucVuEn = dsCanBoHopDoanTk[i].title;\r\n\t\t\tdocument.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = dsCanBoHopDoanTk[i].text;\r\n\t\t\tdocument.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = getChucVuCoDau(chucVuEn);\t\t\t\r\n\t\t\treturn;\r\n\t\t}\r\n\t}\t\r\n}\r\n\r\nfunction onloadHopDoanTrienKhai(){\r\n\r\n}\r\nfunction validateGridThanhPhanThamDuHopDoanTrienKhai(){\r\n\tif(document.getElementById('tb_DS_TPTD').rows.length <= 1){\r\n\t\talert('Không có thành phần tham dự họp đoàn triển khai!');\r\n\t\tdocument.getElementById('tb_DS_TPTD').focus();\r\n\t\treturn false;\r\n\t}\r\n\treturn true;\r\n\t\t\r\n\t\r\n}\r\nfunction validateHopDoanTrienKhai(){\r\n\tif(!isRequired(document.getElementsByName('thoiDiemBatDau')[0]))\r\n\t\treturn false;\r\n\tif(!isRequired(document.getElementsByName('diaDiemHop')[0]))\r\n\t\treturn false;\r\n\tif(!isRequired(document.getElementsByName('veViec')[0]))\r\n\t\treturn false;\r\n\tif(!validateGridThanhPhanThamDuHopDoanTrienKhai())\r\n\t\treturn false;\r\n\tif(!isRequired(document.getElementsByName('noiDungHopDoanTrienKhai')[0]))\r\n\t\treturn false;\r\n\tif(!checkNvarchar2('noiDungHopDoanTrienKhai', 'Chỉ được nhập tối đa 4000 ký tự!'))\r\n\t\treturn false;\t\t\r\n\tif(!isRequired(document.getElementsByName('thoiDiemKetThuc')[0]))\r\n\t\treturn false;\r\n\tif(!compareTime(document.getElementsByName('thoiDiemBatDau')[0], document.getElementsByName('thoiDiemKetThuc')[0], '<', 'Thời điểm kết thúc phải sau thời điểm bắt đầu!'))\r\n\t\treturn false;\r\n\treturn true;\r\n}\r\n\r\n</script>");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(42,99);to=(44,0)]
                                                                                              out.write("</fieldset>\r\n</DIV>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 45,0-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 45,31  LineMapIndex:419
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_12 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_12.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_12.setParent(null);
                                                                                              _jspx_th_logic_present_12.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_12);
                                                                                              int _jspx_eval_logic_present_12 = _jspx_th_logic_present_12.doStartTag();
                                                                                              if (_jspx_eval_logic_present_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(44,31);to=(48,6)]
                                                                                              out.write("    \r\n\t<script language=\"javascript\">     \r\n\t\tvar lastLabelId = '';       \r\n\t</script>\r\n\t<DIV>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 49,6-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 49,33  LineMapIndex:420
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_13 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_13.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_13.setParent(_jspx_th_logic_present_12);
                                                                                              _jspx_th_logic_present_13.setName("hoan");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_13);
                                                                                              int _jspx_eval_logic_present_13 = _jspx_th_logic_present_13.doStartTag();
                                                                                              if (_jspx_eval_logic_present_13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(48,33);to=(55,1)]
                                                                                              out.write("\r\n\t\t<!-- <a href=\"#\" onclick=\"hoan();\" class=\"linkCnPhu\"><font color=blue>Hoãn Thanh tra Kiểm tra</font></a><label id=\"hoan\">&nbsp;|</label> -->\r\n\t\t<a href=\"#\" onclick=\"hoan();\" class=\"linkCnPhu\"><font color=blue>Hoãn Kiểm tra</font></a>\r\n\t\t<label id=\"hoan\">&nbsp;|</label>\r\n\t\t<script language=\"javascript\">   \r\n\t\t\t\tlastLabelId = 'hoan';\r\n\t\t\t</script>    \r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 56,1-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 56,17  LineMapIndex:421
                                                                                              } while (_jspx_th_logic_present_13.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(55,17);to=(55,18)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 56,18-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 56,48  LineMapIndex:422
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_14 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_14.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_14.setParent(_jspx_th_logic_present_12);
                                                                                              _jspx_th_logic_present_14.setName("gia han");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_14);
                                                                                              int _jspx_eval_logic_present_14 = _jspx_th_logic_present_14.doStartTag();
                                                                                              if (_jspx_eval_logic_present_14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(55,48);to=(62,1)]
                                                                                              out.write("\r\n\t\t<!-- <a href=\"#\" onclick=\"giaHan();\" class=\"linkCnPhu\"><font color=blue>Gia hạn Thanh tra Kiểm tra</font></a><label id=\"gia_han\">&nbsp;|</label> -->\r\n\t\t<a href=\"#\" onclick=\"giaHan();\" class=\"linkCnPhu\"><font color=blue>Gia hạn Kiểm tra</font></a>\r\n\t\t<label id=\"gia_han\">&nbsp;|</label>\r\n\t\t<script language=\"javascript\">\r\n\t\t\t\tlastLabelId = 'gia_han';  \r\n\t\t\t</script> \r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 63,1-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 63,17  LineMapIndex:423
                                                                                              } while (_jspx_th_logic_present_14.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(62,17);to=(62,18)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 63,18-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 63,65  LineMapIndex:424
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_15 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_15.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_15.setParent(_jspx_th_logic_present_12);
                                                                                              _jspx_th_logic_present_15.setName("thay doi thanh vien doan");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_15);
                                                                                              int _jspx_eval_logic_present_15 = _jspx_th_logic_present_15.doStartTag();
                                                                                              if (_jspx_eval_logic_present_15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(62,65);to=(68,1)]
                                                                                              out.write("\r\n\t\t<a href=\"#\" onclick=\"thayDoiThanhVien();\" class=\"linkCnPhu\"><font color=blue>Thay đổi thành viên đoàn</font></a>\r\n\t\t<label id=\"thay_doi_thanh_vien_doan\">&nbsp;|</label>\r\n\t\t<script language=\"javascript\">\r\n\t\t\t\tlastLabelId = 'thay_doi_thanh_vien_doan';\r\n\t\t\t</script>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 69,1-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 69,17  LineMapIndex:425
                                                                                              } while (_jspx_th_logic_present_15.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(68,17);to=(73,0)]
                                                                                              out.write("</DIV>  \r\n\t<script language=\"javascript\">\r\n\t\tif(lastLabelId != '')\r\n\t\t\tdocument.getElementById(lastLabelId).innerHTML = '';\r\n\t</script>    \r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 74,0-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 74,16  LineMapIndex:426
                                                                                              } while (_jspx_th_logic_present_12.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(73,16);to=(73,17)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 74,17-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 74,51  LineMapIndex:427
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_15 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_15.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_15.setParent(null);
                                                                                              _jspx_th_logic_notPresent_15.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_15);
                                                                                              int _jspx_eval_logic_notPresent_15 = _jspx_th_logic_notPresent_15.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(73,51);to=(74,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 75,1-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 75,48  LineMapIndex:428
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_16 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_16.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_16.setParent(_jspx_th_logic_notPresent_15);
                                                                                              _jspx_th_logic_present_16.setName("da_co_lich_trinh_du_kien");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_16);
                                                                                              int _jspx_eval_logic_present_16 = _jspx_th_logic_present_16.doStartTag();
                                                                                              if (_jspx_eval_logic_present_16 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(74,48);to=(81,1)]
                                                                                              out.write("\r\n\t\t<DIV id=\"divThongTinPhu\" style=\"display: inline;\"><!-- <a href=\"#\" onclick=\"huy();\" class=\"linkCnPhu\"><font color=blue>Hủy Thanh tra Kiểm tra</font></a> |\r\n\t\t\t<a href=\"#\" onclick=\"hoan();\" class=\"linkCnPhu\"><font color=blue>Hoãn Thanh tra Kiểm tra</font></a> |\r\n\t\t\t<a href=\"#\" onclick=\"giaHan();\" class=\"linkCnPhu\"><font color=blue>Gia hạn Thanh tra Kiểm tra</font></a> |\r\n\t\t\t<a href=\"#\" onclick=\"thayDoiThanhVien();\" class=\"linkCnPhu\"><font color=blue>Thay đổi thành viên đoàn</font></a> --> <a href=\"#\" onclick=\"huy();\" class=\"linkCnPhu\"><font color=blue>Hủy Kiểm tra</font></a> | <a href=\"#\" onclick=\"hoan();\" class=\"linkCnPhu\"><font\r\n\t\t\tcolor=blue>Hoãn Kiểm tra</font></a> | <a href=\"#\" onclick=\"giaHan();\" class=\"linkCnPhu\"><font color=blue>Gia hạn Kiểm tra</font></a> | <a href=\"#\" onclick=\"thayDoiThanhVien();\" class=\"linkCnPhu\"><font color=blue>Thay đổi thành viên đoàn</font></a>\r\n\t\t</DIV>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 82,1-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 82,17  LineMapIndex:429
                                                                                              } while (_jspx_th_logic_present_16.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(81,17);to=(82,0)]
                                                                                              out.write("     \r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 83,0-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 83,19  LineMapIndex:430
                                                                                              } while (_jspx_th_logic_notPresent_15.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(82,19);to=(84,36)]
                                                                                              out.write("</div>\r\n<br/>\r\n<div style=\"width: 100%; margin: 0\">");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(0,59);to=(1,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(1,57);to=(2,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(2,57);to=(5,1)]
                                                                                              out.write("\r\n<BODY>\r\n<TABLE width=\"100%\" align=\"center\" cellpadding=\"5\">\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 6,1-"/ttkt/dung_chung/action_bar.jsp" 6,35  LineMapIndex:431
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_16 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_16.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_16.setParent(null);
                                                                                              _jspx_th_logic_notPresent_16.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_16);
                                                                                              int _jspx_eval_logic_notPresent_16 = _jspx_th_logic_notPresent_16.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_16 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(5,35);to=(7,109)]
                                                                                              out.write("\r\n\t\t<tr>\r\n\t\t\t<td width=\"50%\" align=\"right\"><input type=\"button\" style=\"width: 60\" class=\"button\" name=\"btnSave\" value='");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 8,109-"/ttkt/dung_chung/action_bar.jsp" 8,135  LineMapIndex:432
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_0 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_0.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_0.setParent(_jspx_th_logic_notPresent_16);
                                                                                              _jspx_th_bean_message_0.setKey("luu");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_0);
                                                                                              int _jspx_eval_bean_message_0 = _jspx_th_bean_message_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 8,109-"/ttkt/dung_chung/action_bar.jsp" 8,135  LineMapIndex:433
                                                                                              if (_jspx_th_bean_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(7,135);to=(8,113)]
                                                                                              out.write("' onclick=\"save();\"></td>\r\n\t\t\t<td width=\"50%\" align=\"left\"><input type=\"button\" name=\"closetheForm\" style=\"width: 60\" class=\"button\" value='");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 9,113-"/ttkt/dung_chung/action_bar.jsp" 9,139  LineMapIndex:434
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_1 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_1.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_1.setParent(_jspx_th_logic_notPresent_16);
                                                                                              _jspx_th_bean_message_1.setKey("dong");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_1);
                                                                                              int _jspx_eval_bean_message_1 = _jspx_th_bean_message_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 9,113-"/ttkt/dung_chung/action_bar.jsp" 9,139  LineMapIndex:435
                                                                                              if (_jspx_th_bean_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(8,139);to=(10,1)]
                                                                                              out.write("' onclick=\"closeContainWindow();\"></td>\r\n\t\t</tr>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 11,1-"/ttkt/dung_chung/action_bar.jsp" 11,20  LineMapIndex:436
                                                                                              } while (_jspx_th_logic_notPresent_16.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(10,20);to=(11,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 12,1-"/ttkt/dung_chung/action_bar.jsp" 12,32  LineMapIndex:437
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_17 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_17.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_17.setParent(null);
                                                                                              _jspx_th_logic_present_17.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_17);
                                                                                              int _jspx_eval_logic_present_17 = _jspx_th_logic_present_17.doStartTag();
                                                                                              if (_jspx_eval_logic_present_17 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(11,32);to=(12,110)]
                                                                                              out.write("\r\n\t\t<td width=\"100%\" align=\"center\"><input type=\"button\" style=\"width: 60\" class=\"button\" name=\"btnSave\" value='");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 13,110-"/ttkt/dung_chung/action_bar.jsp" 13,136  LineMapIndex:438
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_2 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_2.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_2.setParent(_jspx_th_logic_present_17);
                                                                                              _jspx_th_bean_message_2.setKey("luu");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_2);
                                                                                              int _jspx_eval_bean_message_2 = _jspx_th_bean_message_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 13,110-"/ttkt/dung_chung/action_bar.jsp" 13,136  LineMapIndex:439
                                                                                              if (_jspx_th_bean_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(12,136);to=(12,258)]
                                                                                              out.write("' onclick=\"save();\" disabled=\"disabled\"> <input type=\"button\" name=\"closetheForm\" style=\"width: 60\" class=\"button\" value='");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 13,258-"/ttkt/dung_chung/action_bar.jsp" 13,284  LineMapIndex:440
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_3 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_3.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_3.setParent(_jspx_th_logic_present_17);
                                                                                              _jspx_th_bean_message_3.setKey("dong");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_3);
                                                                                              int _jspx_eval_bean_message_3 = _jspx_th_bean_message_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 13,258-"/ttkt/dung_chung/action_bar.jsp" 13,284  LineMapIndex:441
                                                                                              if (_jspx_th_bean_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(12,284);to=(14,1)]
                                                                                              out.write("'\r\n\t\t\tonclick=\"closeContainWindow();\"></td>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 15,1-"/ttkt/dung_chung/action_bar.jsp" 15,17  LineMapIndex:442
                                                                                              } while (_jspx_th_logic_present_17.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(14,17);to=(45,0)]
                                                                                              out.write("\r\n</TABLE>\r\n<script language=\"javascript\">\t\t\r\n\tvar activeTab = null;\r\n \tfunction save(){\r\n \t\ttry{\r\n \t\t\tsaveActiveTab(); \r\n \t\t}catch(err){\r\n \t\t\t//Code kieu gi da Error con Submit ha NTDUNG???\r\n \t\t\tif(!validateForm())\r\n\t \t\t\treturn false;\r\n\t \t\taction = document.forms[0].action;\r\n\t \t\taction = action.split('?')[0];  \t\t\r\n\t \t\tdocument.forms[0].action += \"?method=save\";\r\n\t \t\tdocument.forms[0].submit();\r\n\t \t\t/*dhphuc sua lai => alert loi de biet, khong submit*/\t \t\t\r\n\t        //var text = \"Error description: \" + err.message + \"\\n\\n\";        \r\n\t        //alert(text);\r\n \t\t}\r\n \t} \t\r\n \tfunction closeContainWindow(){ \r\n \t\ttry{\r\n \t\t\t// Cac form tu cai dat phuong thuc dong\r\n \t\t\tselfClose();\r\n \t\t}catch(err){  \t\t\t\r\n \t\t\t// Neu khong tu dong se chuyen ve trang chu\r\n \t\t\twindow.location = 'ttkt_index.do';\r\n \t\t} \t\t\r\n \t}\r\n</script>\r\n</BODY>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/action_bar.jsp" 46,2-"/ttkt/dung_chung/action_bar.jsp" 46,49  LineMapIndex:443
                                                                                              if (request.getAttribute("readOnly") != null) {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(45,51);to=(70,0)]
                                                                                              out.write("\r\n<script language=\"javascript\"> \r\n// Input fields\r\nvar allInputFields = document.getElementsByTagName('input') \r\n\tfor(i = 0; i< allInputFields.length; i++){\t\t \r\n\t\tif(allInputFields[i].type.toLowerCase()=='button'&&allInputFields[i].className.toLowerCase()!=\"button1\"){ // Button\r\n\t\t\tif(allInputFields[i].name != 'closetheForm')\r\n\t\t\t\tallInputFields[i].disabled = true; \r\n\t\t\t\t\r\n\t\t}else if(allInputFields[i].type.toLowerCase()=='text'){ // Text\r\n\t\t\tallInputFields[i].readOnly = true;\r\n\t\t}else if(allInputFields[i].type.toLowerCase()=='radio'){ // Radio\r\n\t\t\tallInputFields[i].disabled = true;\r\n\t\t}else if(allInputFields[i].type.toLowerCase()=='checkbox'){ // Checkbox\r\n\t\t\tallInputFields[i].disabled = true;\r\n\t\t}\r\n\t}\r\nallSelect = document.getElementsByTagName('select'); // Select\r\nfor(i = 0; i< allSelect.length; i++)\r\n\tallSelect[i].disabled = true;\r\n\t\r\nallTextArea = document.getElementsByTagName('TEXTAREA')// Text area\r\nfor(i = 0; i< allTextArea.length; i++)\r\n\tallTextArea[i].readOnly = true;\r\n</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/action_bar.jsp" 71,2-"/ttkt/dung_chung/action_bar.jsp" 71,3  LineMapIndex:444
                                                                                              }
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(70,5);to=(71,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 72,0-"/ttkt/dung_chung/action_bar.jsp" 72,37  LineMapIndex:445
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_18 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_18.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_18.setParent(null);
                                                                                              _jspx_th_logic_present_18.setName("strDateHoliday");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_18);
                                                                                              int _jspx_eval_logic_present_18 = _jspx_th_logic_present_18.doStartTag();
                                                                                              if (_jspx_eval_logic_present_18 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(71,37);to=(73,19)]
                                                                                              out.write("\r\n\t<script language=\"javascript\">\r\n\t\tstrHolidayDay = '");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 74,22-"/ttkt/dung_chung/action_bar.jsp" 74,60  LineMapIndex:446
                                                                                              out.print(request.getAttribute("strDateHoliday"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(73,62);to=(75,0)]
                                                                                              out.write("';\t\r\n\t</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 76,0-"/ttkt/dung_chung/action_bar.jsp" 76,16  LineMapIndex:447
                                                                                              } while (_jspx_th_logic_present_18.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(75,16);to=(76,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 77,0-"/ttkt/dung_chung/action_bar.jsp" 77,33  LineMapIndex:448
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_19 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_19.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_19.setParent(null);
                                                                                              _jspx_th_logic_present_19.setName("saveStatus");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_19);
                                                                                              int _jspx_eval_logic_present_19 = _jspx_th_logic_present_19.doStartTag();
                                                                                              if (_jspx_eval_logic_present_19 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(76,33);to=(88,0)]
                                                                                              out.write("\r\n\t<script language=\"javascript\">\r\n\t\talert('L\\u01B0u th\\u00E0nh c\\u00F4ng!');\r\n\t\ttry{\r\n\t\t\txuLySauSaveThanhCong(); \r\n\t\t}catch(err){\r\n\t\t\t\r\n\t\t}\r\n\t\t// Sau khi save thanh cong chac chan se dong form.\r\n\t\tselfClose();\r\n\t\t\r\n\t</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 89,0-"/ttkt/dung_chung/action_bar.jsp" 89,16  LineMapIndex:449
                                                                                              } while (_jspx_th_logic_present_19.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(88,16);to=(89,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(84,88);to=(85,0)]
                                                                                              out.write("</div>\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(0,31);to=(22,4)]
                                                                                              out.write("\r\n<script language=\"Javascript\">\r\n$(function() \r\n{\r\n  $(document).bind('keydown','esc',function(evt){onButton('exit');return false;});\r\n  $(document).bind('keydown','home',function(evt){window.location='index.do';return false;});\r\n  if($('#exit').length>0)\r\n  {\r\n   $('#exit').button({icons:{primary:'ui-icon-close'}}).click(function(){onButton('exit');return false;});\r\n  }\r\n  if($('#search').length>0)\r\n  {\r\n    $('#search').button({icons:{primary:'ui-icon-search'}}).click(function(){onButton('search');return false;});\r\n    $(document).bind('keydown','Shift+s',function(evt){onButton('search');return false;});\r\n  }\r\n  if($('table.data_table').length>0)\r\n  {\r\n    $('table.data_table tbody tr').each(function(index) {$(this).addClass(arrClassName[index%3]);});\r\n    $(\"table.data_table tbody\").delegate(\"tr\", \"hover\", function(){$(this).toggleClass(\"highlight\");});\r\n  }\r\n  if($('#msgdiv').length>0)\r\n  {\r\n    ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/bottom.jsp" 23,4-"/bottom.jsp" 23,30  LineMapIndex:450
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_20 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_20.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_20.setParent(null);
                                                                                              _jspx_th_logic_present_20.setName("msg");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_20);
                                                                                              int _jspx_eval_logic_present_20 = _jspx_th_logic_present_20.doStartTag();
                                                                                              if (_jspx_eval_logic_present_20 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(22,30);to=(24,4)]
                                                                                              out.write("\r\n     $('#msgdiv').effect('pulsate',{times:3});\r\n    ");

                                                                                              // end
                                                                                              // ##DEBUG## "/bottom.jsp" 25,4-"/bottom.jsp" 25,20  LineMapIndex:451
                                                                                              } while (_jspx_th_logic_present_20.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(24,20);to=(32,92)]
                                                                                              out.write("\r\n  } \r\n});\r\n</script>\r\n</div>\r\n<div id=\"bottom\">\r\n<table width=\"100%\" border=\"0\" bordercolor=\"#AEC1F1\">\r\n\t<tr>\r\n\t\t<td align=\"center\" width=\"20%\" style=\"color: blue; font-size: 8pt\">KTNB Phiên bản <strong>");

                                                                                              // end
                                                                                              // ##DEBUG## "/bottom.jsp" 33,95-"/bottom.jsp" 33,113  LineMapIndex:452
                                                                                              out.print(ac.getVersionApp());
                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(32,115);to=(60,9)]
                                                                                              out.write("</strong> <br>\r\n\t\t<script language=JavaScript>\r\n                                                dayname = new Array(\"Chủ nhật\", \"Thứ Hai\", \"Thứ Ba\", \"Thứ Tư\", \"Thứ Năm\", \"Thứ Sáu\", \"Thứ Bẩy\");\r\n                                                monthname = new Array(\"01\", \"02\", \"03\", \"04\", \"05\", \"06\", \"07\", \"08\", \"09\", \"10\", \"11\", \"12\");\r\n                                                now = new Date();\r\n                                                daynum = now.getDay();\r\n                                                day = dayname[daynum];\r\n                                                date = now.getDate();\r\n                                                monthnum = now.getMonth();\r\n                                                month = monthname[monthnum];\r\n                                                document.write(\"\"+day+\", Ngày \"+date+\"/\"+month+\"/\"+now.getYear()+\"\");\r\n          </script></td>\r\n\t\t<td align=\"center\" width=\"70%\"><font style=\"color: blue; font-size: 8pt\"> <b>TỔNG CỤC THUẾ</b> <BR>\r\n\t\t<strong>Địa chỉ:</strong> Số 123 Lò Đúc, Hà Nội &nbsp; &nbsp;<strong>Điện thoại:</strong> (04) 9.724204 - 9.724209 <strong>Fax:</strong> (04) 9.712286 <br>\r\n\t\t<strong>Website:</strong> <a href=\"http://www.gdt.gov.vn\" target=\"_blank\">http://www.gdt.gov.vn</a> </font></td>\r\n\t</tr>\r\n</table>\r\n</div>\r\n</body>\r\n</html>\r\n<script language=\"Javascript\">\r\n// style js ui\r\n//$(function(){\r\n//\t$.each($('[type=\"button\"]'),function(index,value){\r\n//\t\t$(value).button();\r\n//\t\t$(value).css(\"font-size\",\"11\");\r\n//\t})\r\n//})\r\n</script>");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(85,32);to=(122,23)]
                                                                                              out.write("\r\n\r\n<INPUT type=\"hidden\" name=\"truongGiuNgayTam\">\r\n<script language=\"javascript\">     \r\nfunction selfClose(){\r\n\tif(window.opener != null)\r\n\t\twindow.close();\r\n\telse\r\n\t\tthrow err;\t\t\r\n}\r\nfunction huy(){ \r\nwindow.open('huy_ttkt.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);\r\n}     \r\nfunction hoan(){\r\nwindow.open('hoan_ttkt.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);\r\n}     \r\nfunction giaHan(){ \r\n\twindow.open('gia_han.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);\r\n} \r\nfunction thayDoiThanhVien(){\r\n\twindow.open('thay_doi_thanh_vien_doan.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);\r\n}  \r\n    \r\nvar cbDsThanhVienDoan; \r\n$(function()             \r\n{\r\n var  idQD = document.getElementsByName('maFileBCKS')[0].value;\r\n  //alert(idQD);\r\n  if(idQD== null || idQD ==''||idQD ==\" \"){\r\n  \tactiveTab =0;\r\n  }\t\r\n  else{\r\n\t  var tab_select = jQuery.fn.readCookie(getTabIndexInCookKie());      \r\n\t  setActiveTab(tab_select); \r\n  }  \r\n  var tabOpts={selected:activeTab ,select:function(event,tab){jQuery.fn.createCookie(getTabIndexInCookKie(), tab.index ); setActiveTab(tab.index)}};                \r\n  $(\"#tab\").tabs(tabOpts);   \r\n  dsIdThanhVienDoan = '");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 123,26-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 123,67  LineMapIndex:453
                                                                                              out.print(request.getAttribute("dsIdThanhVienDoan"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(122,69);to=(124,22)]
                                                                                              out.write("'\r\n\tdsIdThanhVienDoan = dsIdThanhVienDoan.split(',');\r\n\tdsChucVuTrongDoan = '");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 125,25-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 125,66  LineMapIndex:454
                                                                                              out.print(request.getAttribute("dsChucVuTrongDoan"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(124,68);to=(410,0)]
                                                                                              out.write("'   \r\n\tdsChucVuTrongDoan = dsChucVuTrongDoan.split(',');\r\n\tonloadChiDinhThanhVienDoan();\r\n\tonLoadKeHoach();\r\n\tonloadDeCuong(); \r\n\tonLoadBaoCaoKs();\r\n\tif(activeTab == null)\r\n\t\tactiveTab = 0; \r\n\tnumOfTab = document.getElementById('tab').childNodes[0].childNodes.length;\r\n\tcreateOptionsFromDsThanhVien();      \r\n\tmethod = getUrlParam('method')\r\n\tif('view' == method){\r\n\t\tsetVisibleButton();\r\n\t}      \r\n\thideContents();\r\n\t//để một dòng trống trước các danh sách\r\n\tif($('#tblDsTvd tbody tr').length==1){\r\n\t\tthemThanhVienDoan();\r\n\t} \r\n\tif($('#tblBaoCao tbody tr').length==1){\r\n\t\tthemBaoCao(); \r\n\t}\r\n\tif($('#tblHsTl tbody tr').length==1){\r\n\t\tthemHoSoTl();\r\n\t}\r\n\tif($('#tb_DS_TPTD tbody tr').length==1){\r\n\t\tthemThanhPhanThamDu();\r\n\t}\r\n});\r\nvar formObj = new DHTMLSuite.form({ formRef:'ChuanBiTienHanhForm',action:'chuan_bi_tien_hanh.do',responseEl:'getReturn'}); \r\nfunction getTabIndexInCookKie(){ \r\n\treturn \"chuanBiTienHanh\";  \r\n} \r\nfunction setActiveTab(tabIndex){  \r\n\t//alert(tabIndex); \r\n\tactiveTab = tabIndex;   \r\n}   \r\nfunction findForm(formAction){ \r\n\t//alert(\"tim form :\"+formAction);\r\n\tfor(i = 0; i< document.forms.length; i++){\r\n\t\t//alert(i+ \" :\"+ document.forms[i].action);\r\n\t\tif(document.forms[i].action == formAction || document.forms[i].action.indexOf(formAction) >=0)\r\n\t\t\treturn document.forms[i];\r\n\t}\r\n\treturn null;\r\n} \r\nvar url;   \r\nvar submitString = \"\";\r\nvar contextRoot = document.forms[0].action.split('/')[1];\r\nfunction saveActiveTab(){\r\n\tvar saveResultDivName;\r\n\tif(activeTab == 0){\r\n\t\tsaveResultDivName = \"getReturnBcks\";\r\n\t\tif(!validateBaoCaoKhaoSat())       \r\n\t\t\treturn; \r\n\t\turl = 'chuan_bi_tien_hanh.do?method=save&type=bcks';  \r\n\t}else if(activeTab == 1){ \r\n\t\tif(!validateThanhVienDoan())     \r\n\t\t\treturn; \r\n\t\turl = 'chuan_bi_tien_hanh.do?method=save&type=tvd';\r\n\t}else if(activeTab == 2){   \r\n\t\tif(!isEmpty(document.getElementsByName('soQuyetDinh')[0].value)){\r\n\t\t\tvar r=confirm(\"Sau khi lưu quyết định, các thông tin trước sẽ không được sửa!\")\r\n\t\t\tif (r==false)\r\n\t\t\t\treturn;\t\t      \r\n\t\t}\r\n\t\tif(!validateQuyetDinh())               \r\n\t\t\treturn;     \r\n\t\turl = 'chuan_bi_tien_hanh.do?method=save&type=qd';\t  \r\n\t}else if(activeTab == 3){ \r\n\t\tsaveResultDivName = \"getReturnKh\";\t\t\r\n\t\tif(!validateKeHoach())     \r\n\t\t\treturn;       \r\n\t\turl = 'chuan_bi_tien_hanh.do?method=save&type=kh';  \r\n\t}else if(activeTab == 4){  \r\n\t\tsaveResultDivName = \"getReturnDc\";\t\t\r\n\t\tif(!validateDeCuong())           \r\n\t\t\treturn;  \r\n\t\turl = 'chuan_bi_tien_hanh.do?method=save&type=dc';   \r\n\t}else if(activeTab == 5){         \r\n\t\tif(!validateHopDoanTrienKhai())                              \r\n\t\t\treturn;  \r\n\t\tif(checkRequired())\r\n\t\treturn;    \r\n\t\turl = 'chuan_bi_tien_hanh.do?method=save&type=hdtk';            \r\n\t}else throw \"Err1\";      \r\n\tif(contextRoot.length > 0){\r\n\t\turl = '/' + contextRoot + '/' + url; \r\n\t}\r\n\tif(url.indexOf('type=dc') >=0  || url.indexOf('type=bcks') >=0 || url.indexOf('type=kh') >=0){    \r\n\t\turlWithAllParam = url + '&' + getThongTinChung();\t\r\n\t\tsmbForm = findForm(url);    \r\n\t\tif(smbForm == null)        \r\n\t\t\tsmbForm = findForm(urlWithAllParam);\t\t\t\t\t\r\n\t\tif(url.indexOf('type=dc') >=0 || url.indexOf('type=kh') >=0){\r\n\t\t\txmlhttpPost(urlWithAllParam); \t\r\n\t\t}\r\n\t\telse{\r\n\t\t\tformObj = new DHTMLSuite.form({ formRef:smbForm,action:urlWithAllParam, responseEl:saveResultDivName});\t\t\r\n\t\t\tformObj.submit();\r\n\t\t}\r\n\t}else\r\n\txmlhttpPost(url);               \r\n}       \r\nfunction xuLySaveThanhCongCuaTungForm(){\t\r\n\tif(activeTab == 0 ||activeTab == 1 || activeTab == 2 || activeTab == 3 || activeTab == 4){     \r\n\t\twindow.location.reload();\r\n\t}else if(activeTab == 5){\r\n\t\tif(window.confirm('Bạn đã nhập xong dữ liệu cho bước Chuẩn bị tiến hành! Bạn có muốn nhập tiếp thông tin cho bước Tiến hành không?'))\r\n\t\t\twindow.location = 'tien_hanh_ttkt.do?cuocTtktId=' + document.getElementsByName('idCuocTtkt')[0].value;\r\n\t}\t   \r\n} \r\nfunction xuLySaveKhongThanhCongCuaTungForm(maLoi){\r\n\tswitch (maLoi){\r\n\t\tcase \"1\":\r\n\t\t\talert('Chưa nhập báo cáo khảo sát!');\r\n\t\t\tbreak;\r\n\t\tcase \"2\":\r\n\t\t\talert('Chưa chỉ định hoặc chưa nhập thông tin phê duyệt danh sách thành viên!');\r\n\t\t\tbreak;\r\n\t\tcase \"3\":\r\n\t\t\talert('Chưa có quyết định!');\r\n\t\t\tbreak; \r\n\t\tcase \"4\":\r\n\t\t\talert('Chưa lập kế hoạch hoặc chưa nhập thông tin phê duyệt kế hoạch!');\r\n\t\t\tbreak; \r\n\t\tcase \"5\":\r\n\t\t\talert('Chưa lập đề cương!');\r\n\t\t\tbreak; \r\n\t\tdefault:\r\n\t\t\tbreak;\r\n\t}\t\r\n}\r\nfunction readOnlyTabBCKS(){\r\n\ttry{\r\n\t\tdocument.getElementsByName('fileBCKS')[0].disabled = true;\r\n\t}catch(err){\r\n\t}\t\r\n}\r\nfunction readOnlyTabChiDinhThanhVienDoan(){\r\n\t$(\"div#tabTVDoan .text\").attr(\"readOnly\", true); \r\n\t$(\"div#tabTVDoan .textareaTitle\").attr(\"readOnly\", true); \r\n\t$(\"div#tabTVDoan .button\").attr(\"disabled\", true);   \r\n\t$(\"div#tabTVDoan .lovButton\").attr(\"disabled\", true);\r\n\t$(\"div#tabTVDoan .checkbox\").attr(\"disabled\", true); \r\n\t$(\"div#tabTVDoan .combobox\").attr(\"disabled\", true); \r\n\t//$(\"div#tabTVDoan .textarea\").attr(\"disabled\", true); \r\n\t//$(\"div#tabTVDoan .textarea\").attr(\"disabled\", true); \t\r\n}\r\nfunction readOnlyTabQuyetDinh(){ \r\n\t$(\"div#tabQuyetDinh .text\").attr(\"readOnly\", true); \r\n\t//$(\"div#tabQuyetDinh .button\").attr(\"disabled\", true); \r\n\t$(\"div#tabQuyetDinh .lovButton\").attr(\"disabled\", true);\r\n\t$(\"div#tabQuyetDinh .checkbox\").attr(\"disabled\", true); \r\n\t$(\"div#tabQuyetDinh .combobox\").attr(\"disabled\", true); \r\n\t$(\"div#tabQuyetDinh .textareaTitle\").attr(\"readOnly\", true); \r\n \t           \r\n}\r\nfunction readOnlyAllPreFieldOfQd(){                   \r\n\treadOnlyTabBCKS();\r\n\treadOnlyTabChiDinhThanhVienDoan();\r\n\treadOnlyTabQuyetDinh();\r\n}   \r\nvar formObj;\r\nfunction getThongTinChung(){ \r\n\tthongTinChung = \"\";  \r\n\t//thongTinChungForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do');  \r\n\t//thongTinChungForm = findForm('/ktnb/chuan_bi_tien_hanh.do');  \r\n\tthongTinChungForm = document.getElementById('cbthForm');\r\n\tfor(i = 0; i< thongTinChungForm.elements.length; i++)\r\n\t\tif(thongTinChungForm.elements[i].name != null && thongTinChungForm.elements[i].name != '' && thongTinChungForm.elements[i].value != null && thongTinChungForm.elements[i].value != '')\r\n\t\t\tthongTinChung += thongTinChungForm.elements[i].name + \"=\" + encodeURIComponent(thongTinChungForm.elements[i].value) + \"&\"; \r\n\tthongTinChung = thongTinChung.substring(0, thongTinChung.length - 1); \r\n\treturn thongTinChung; \r\n}     \r\nfunction createSubmitString(){      \r\n\treVal = \"\";      \r\n\tactiveForm = findForm(url);     \r\n\tif(url.indexOf('type=bcks') < 0){ \r\n\t\tif(url.indexOf('type=dc') >= 0){\r\n\t\t\t//var temptext = '';\r\n\t\t\tfor(i = 0; i< activeForm.elements.length; i++){\r\n\t\t\t\t//temptext+=activeForm.elements[i].name+':'+activeForm.elements[i].value+'\\n';\r\n\t\t\t\tif(activeForm.elements[i].name != null \r\n\t\t\t\t&& activeForm.elements[i].name != '' \r\n\t\t\t\t&& activeForm.elements[i].name != 'fileDinhKemDeCuong'\r\n\t\t\t\t//&& activeForm.elements[i].name.indexOf(\"dsHoSoTl\") <= -1 \t\t\t\t\r\n\t\t\t\t&& activeForm.elements[i].value != null \r\n\t\t\t\t&& activeForm.elements[i].value != '')\r\n\t\t\t\t\treVal += activeForm.elements[i].name + \"=\" + encodeURIComponent(activeForm.elements[i].value) + \"&\";\r\n\t\t\t}\r\n\t\t\t//alert(temptext);\r\n\t\t}else{\r\n\t\t\tfor(i = 0; i< activeForm.elements.length; i++){\r\n\t\t\t\tif(activeForm.elements[i].name != null \r\n\t\t\t\t&& activeForm.elements[i].name != '' \r\n\t\t\t\t&& activeForm.elements[i].value != null \r\n\t\t\t\t&& activeForm.elements[i].value != '')\r\n\t\t\t\t\treVal += activeForm.elements[i].name + \"=\" + encodeURIComponent(activeForm.elements[i].value) + \"&\";\r\n\t\t\t}\r\n\t\t}\r\n\t} \r\n\t// collect thong tin chung.\r\n\tif(getThongTinChung() != null && getThongTinChung() != '')\r\n\t\treVal = getThongTinChung()+'&'+reVal;\r\n\telse\r\n\t\treVal = reVal.substring(0, reVal.length - 1);   \r\n\treturn reVal;    \r\n}   \r\n\r\nfunction createOptionsFromDsThanhVien(){                \r\n\t\tcbDsThanhVienDoan = '<option value = \"\"></option>';           \r\n\t\tvar allRowDsThanhVien = document.getElementById('bodyDsTvd').rows;    \r\n\t\tfor(var i = 0; i< allRowDsThanhVien.length; i++){    \r\n\t\t\tvar rowThanhVien = allRowDsThanhVien[i];  \r\n\t\t\tvar colTenThanhVien = rowThanhVien.cells[1];      \r\n\t\t\tif(colTenThanhVien.childNodes[0].value != null && colTenThanhVien.childNodes[0].value != ''){ \r\n\t\t\t\tif(i==0) \r\n\t\t\t\t\tcbDsThanhVienDoan += '<option value=\"' + colTenThanhVien.childNodes[0].value + '\">' + colTenThanhVien.childNodes[2].value + '</option>';\r\n\t\t\t\telse\r\n\t\t\t\t\tcbDsThanhVienDoan += '<option value=\"' + colTenThanhVien.childNodes[0].value + '\">' + colTenThanhVien.childNodes[2].value + '</option>';\r\n\t\t\t}\t \r\n\t\t}  \r\n\t}           \r\n \r\n\r\nfunction xemLichTrinhDuKien(){\r\n\topenWindow('lich_trinh_du_kien_ttkt.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value, '500','250','menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no');\r\n}\r\nvar lovType;\r\nfunction setThongTinNhanVienFromLov(maCanBo, tenCanBo, chucVu, tenPhong, tenCqt){ \r\n\tif(lovType == 'tvd'){\r\n\t\tif(exist(maCanBo)){ \r\n\t\t\tidCanBoConTrol.value = \"\";\r\n\t\t\ttenCanBoConTrol.value = \"\"; \t\t\t    \r\n\t\t\tif(tenCanBoConTrol.name.indexOf('chiTietDsTvd') >=0)\r\n\t\t\t\treturn;\r\n\t\t} \r\n\t\tidCanBoConTrol.value = maCanBo;\r\n\t\ttenCanBoConTrol.value = tenCanBo; \r\n\t\tif(!isEmpty(tenPhong)){ \r\n\t\t\tdonViCongTacControl.value = tenPhong;\r\n\t\t\tif(!isEmpty(tenCqt)){  \r\n\t\t\t\tdonViCongTacControl.value += ', ' + tenCqt;\r\n\t\t\t}\r\n\t\t}else if(isEmpty(tenCqt)){\r\n\t\t\tdonViCongTacControl.value += tenCqt;   \r\n\t\t}\t\t\t\r\n\t\tif(chucVu != null && chucVu != '') \r\n\t\t\tchucVuConTrol.value = chucVu;\t\r\n\t}else if('chonNguoiChiDaoDamSat' == lovType){\r\n\t\tidCanBoConTrol.value = maCanBo;\r\n\t\t// Ten \r\n\t\ttenCanBoConTrol.value = tenCanBo;\t\t\r\n\t\t// Chuc vu\r\n\t\tchucVuConTrol.value = chucVu;\r\n\t}          \r\n}\t\r\n\r\nfunction validateDateRequired(dateElement){\r\n\tif(dateElement.value==\"\"||dateElement.value==null)\r\n\treturn;\r\n\tvar ngayLapDsTvd = $('[name=\"ngayLapDsTvd\"]')[0].value;\r\n\tswitch(dateElement.name){\r\n\t\tcase \"ngayRaQuyetDnh\":\r\n\t\t\tif(d2n(dateElement.value)<d2n(ngayLapDsTvd)){\r\n\t\t\t\talert(\"Ngày ra quyết định phải sau ngày lập tờ trình\");\r\n\t\t\t\t$(dateElement).focus().select();\r\n\t\t\t}\r\n\t\t\tbreak;\r\n\t\tcase \"thoiDiemBatDau\":\r\n\t\t\tif($('[name=\"ngayRaQuyetDnh\"]')[0].value!=\"\"&& d2n(dateElement.value.split(\" \")[1])<d2n($('[name=\"ngayRaQuyetDnh\"]')[0].value)){\r\n\t\t\t\talert(\"Ngày họp phải sau ngày ra quyết định\");\r\n\t\t\t\t$(dateElement).focus().select();\r\n\t\t\t}\r\n\t\t\tbreak;\r\n\t\tcase \"thoiDiemKetThuc\":\r\n\t\t\tif($('[name=\"ngayRaQuyetDnh\"]')[0].value!=\"\"&& d2n(dateElement.value.split(\" \")[1])<d2n($('[name=\"ngayRaQuyetDnh\"]')[0].value)){\r\n\t\t\t\talert(\"Ngày kết thúc họp đoàn phải sau ngày ra quyết định\");\r\n\t\t\t\t$(dateElement).focus().select();\r\n\t\t\t}\r\n\t\t\tbreak;\r\n\t\t\t\r\n\t}\r\n}  \r\n</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 411,0-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 411,47  LineMapIndex:455
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_21 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_21.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_21.setParent(null);
                                                                                              _jspx_th_logic_present_21.setName("da_co_lich_trinh_du_kien");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_21);
                                                                                              int _jspx_eval_logic_present_21 = _jspx_th_logic_present_21.doStartTag();
                                                                                              if (_jspx_eval_logic_present_21 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(410,47);to=(416,0)]
                                                                                              out.write("\r\n\t<script language=\"javascript\"> \t\t\r\n\t\t$(\"#da_co_lich_trinh_du_kien\").css(\"display\",\"inline\"); \r\n\t\t$(\"#chua_co_lich_trinh_du_kien\").css(\"display\",\"none\"); \r\n\t\treadOnlyAllPreFieldOfQd();\r\n\t</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 417,0-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 417,16  LineMapIndex:456
                                                                                              } while (_jspx_th_logic_present_21.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(416,16);to=(417,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 418,0-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 418,50  LineMapIndex:457
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_17 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_17.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_17.setParent(null);
                                                                                              _jspx_th_logic_notPresent_17.setName("da_co_lich_trinh_du_kien");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_17);
                                                                                              int _jspx_eval_logic_notPresent_17 = _jspx_th_logic_notPresent_17.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_17 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(417,50);to=(422,0)]
                                                                                              out.write("\r\n\t<script language=\"javascript\"> \r\n\t\t$(\"#da_co_lich_trinh_du_kien\").css(\"display\",\"none\"); \r\n\t\t$(\"#chua_co_lich_trinh_du_kien\").css(\"display\",\"inline\");\t\t\r\n\t</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 423,0-"/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp" 423,19  LineMapIndex:458
                                                                                              } while (_jspx_th_logic_notPresent_17.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp";from=(422,19);to=(424,0)]
                                                                                              out.write("\r\n\r\n");

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
                                                                                              "/ttkt/chuan_bi_tien_hanh/chuan_bi_tien_hanh.jsp", 
                                                                                              "/top_bar.jsp", 
                                                                                              "/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp", 
                                                                                              "/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp", 
                                                                                              "/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp", 
                                                                                              "/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp", 
                                                                                              "/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp", 
                                                                                              "/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp", 
                                                                                              "/ttkt/dung_chung/action_bar.jsp", 
                                                                                              "/bottom.jsp", 
                                                                                              },
                                                                                              {
                                                                                              "0", 
                                                                                              "1", 
                                                                                              "71", 
                                                                                              "91", 
                                                                                              "181", 
                                                                                              "217", 
                                                                                              "275", 
                                                                                              "373", 
                                                                                              "431", 
                                                                                              "450", 
                                                                                              },
                                                                                              };
                                                                                              public static String[][] _jspx_debug_LineMapping = {
                                                                                              {
                                                                                              "0", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "1", 
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
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "7", 
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
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "9", 
                                                                                              "9", 
                                                                                              "9", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              },
                                                                                              {
                                                                                              "1", 
                                                                                              "6", 
                                                                                              "7", 
                                                                                              "8", 
                                                                                              "9", 
                                                                                              "10", 
                                                                                              "11", 
                                                                                              "12", 
                                                                                              "13", 
                                                                                              "22", 
                                                                                              "22", 
                                                                                              "24", 
                                                                                              "24", 
                                                                                              "25", 
                                                                                              "25", 
                                                                                              "26", 
                                                                                              "26", 
                                                                                              "27", 
                                                                                              "27", 
                                                                                              "30", 
                                                                                              "30", 
                                                                                              "31", 
                                                                                              "31", 
                                                                                              "32", 
                                                                                              "32", 
                                                                                              "33", 
                                                                                              "33", 
                                                                                              "34", 
                                                                                              "34", 
                                                                                              "35", 
                                                                                              "35", 
                                                                                              "36", 
                                                                                              "36", 
                                                                                              "37", 
                                                                                              "37", 
                                                                                              "38", 
                                                                                              "38", 
                                                                                              "39", 
                                                                                              "39", 
                                                                                              "40", 
                                                                                              "40", 
                                                                                              "41", 
                                                                                              "41", 
                                                                                              "42", 
                                                                                              "42", 
                                                                                              "43", 
                                                                                              "43", 
                                                                                              "44", 
                                                                                              "44", 
                                                                                              "45", 
                                                                                              "45", 
                                                                                              "46", 
                                                                                              "46", 
                                                                                              "47", 
                                                                                              "47", 
                                                                                              "51", 
                                                                                              "83", 
                                                                                              "83", 
                                                                                              "83", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "7", 
                                                                                              "8", 
                                                                                              "10", 
                                                                                              "10", 
                                                                                              "11", 
                                                                                              "12", 
                                                                                              "12", 
                                                                                              "13", 
                                                                                              "13", 
                                                                                              "14", 
                                                                                              "5", 
                                                                                              "5", 
                                                                                              "6", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "9", 
                                                                                              "9", 
                                                                                              "11", 
                                                                                              "25", 
                                                                                              "25", 
                                                                                              "27", 
                                                                                              "28", 
                                                                                              "29", 
                                                                                              "33", 
                                                                                              "34", 
                                                                                              "40", 
                                                                                              "41", 
                                                                                              "43", 
                                                                                              "44", 
                                                                                              "56", 
                                                                                              "5", 
                                                                                              "10", 
                                                                                              "11", 
                                                                                              "14", 
                                                                                              "15", 
                                                                                              "20", 
                                                                                              "20", 
                                                                                              "23", 
                                                                                              "23", 
                                                                                              "28", 
                                                                                              "29", 
                                                                                              "34", 
                                                                                              "35", 
                                                                                              "35", 
                                                                                              "36", 
                                                                                              "36", 
                                                                                              "37", 
                                                                                              "55", 
                                                                                              "56", 
                                                                                              "57", 
                                                                                              "60", 
                                                                                              "62", 
                                                                                              "62", 
                                                                                              "62", 
                                                                                              "63", 
                                                                                              "63", 
                                                                                              "65", 
                                                                                              "65", 
                                                                                              "65", 
                                                                                              "66", 
                                                                                              "68", 
                                                                                              "69", 
                                                                                              "71", 
                                                                                              "72", 
                                                                                              "72", 
                                                                                              "73", 
                                                                                              "73", 
                                                                                              "74", 
                                                                                              "74", 
                                                                                              "75", 
                                                                                              "78", 
                                                                                              "81", 
                                                                                              "83", 
                                                                                              "83", 
                                                                                              "83", 
                                                                                              "84", 
                                                                                              "85", 
                                                                                              "86", 
                                                                                              "87", 
                                                                                              "90", 
                                                                                              "90", 
                                                                                              "90", 
                                                                                              "91", 
                                                                                              "93", 
                                                                                              "94", 
                                                                                              "96", 
                                                                                              "97", 
                                                                                              "97", 
                                                                                              "98", 
                                                                                              "98", 
                                                                                              "99", 
                                                                                              "102", 
                                                                                              "105", 
                                                                                              "107", 
                                                                                              "107", 
                                                                                              "107", 
                                                                                              "108", 
                                                                                              "109", 
                                                                                              "110", 
                                                                                              "111", 
                                                                                              "114", 
                                                                                              "114", 
                                                                                              "114", 
                                                                                              "115", 
                                                                                              "117", 
                                                                                              "118", 
                                                                                              "120", 
                                                                                              "121", 
                                                                                              "121", 
                                                                                              "122", 
                                                                                              "122", 
                                                                                              "123", 
                                                                                              "126", 
                                                                                              "127", 
                                                                                              "128", 
                                                                                              "147", 
                                                                                              "147", 
                                                                                              "148", 
                                                                                              "148", 
                                                                                              "149", 
                                                                                              "5", 
                                                                                              "6", 
                                                                                              "7", 
                                                                                              "18", 
                                                                                              "19", 
                                                                                              "24", 
                                                                                              "24", 
                                                                                              "27", 
                                                                                              "27", 
                                                                                              "32", 
                                                                                              "32", 
                                                                                              "40", 
                                                                                              "41", 
                                                                                              "41", 
                                                                                              "42", 
                                                                                              "42", 
                                                                                              "43", 
                                                                                              "45", 
                                                                                              "49", 
                                                                                              "49", 
                                                                                              "51", 
                                                                                              "58", 
                                                                                              "58", 
                                                                                              "58", 
                                                                                              "58", 
                                                                                              "65", 
                                                                                              "65", 
                                                                                              "70", 
                                                                                              "70", 
                                                                                              "81", 
                                                                                              "81", 
                                                                                              "82", 
                                                                                              "82", 
                                                                                              "83", 
                                                                                              "116", 
                                                                                              "128", 
                                                                                              "5", 
                                                                                              "15", 
                                                                                              "15", 
                                                                                              "18", 
                                                                                              "18", 
                                                                                              "23", 
                                                                                              "23", 
                                                                                              "26", 
                                                                                              "26", 
                                                                                              "32", 
                                                                                              "32", 
                                                                                              "38", 
                                                                                              "38", 
                                                                                              "44", 
                                                                                              "44", 
                                                                                              "50", 
                                                                                              "50", 
                                                                                              "56", 
                                                                                              "56", 
                                                                                              "70", 
                                                                                              "70", 
                                                                                              "76", 
                                                                                              "76", 
                                                                                              "82", 
                                                                                              "82", 
                                                                                              "88", 
                                                                                              "88", 
                                                                                              "102", 
                                                                                              "104", 
                                                                                              "104", 
                                                                                              "106", 
                                                                                              "112", 
                                                                                              "118", 
                                                                                              "119", 
                                                                                              "125", 
                                                                                              "126", 
                                                                                              "128", 
                                                                                              "130", 
                                                                                              "130", 
                                                                                              "132", 
                                                                                              "134", 
                                                                                              "134", 
                                                                                              "136", 
                                                                                              "147", 
                                                                                              "147", 
                                                                                              "147", 
                                                                                              "147", 
                                                                                              "148", 
                                                                                              "148", 
                                                                                              "149", 
                                                                                              "149", 
                                                                                              "150", 
                                                                                              "154", 
                                                                                              "156", 
                                                                                              "306", 
                                                                                              "308", 
                                                                                              "309", 
                                                                                              "311", 
                                                                                              "5", 
                                                                                              "11", 
                                                                                              "11", 
                                                                                              "14", 
                                                                                              "14", 
                                                                                              "31", 
                                                                                              "32", 
                                                                                              "33", 
                                                                                              "34", 
                                                                                              "34", 
                                                                                              "34", 
                                                                                              "35", 
                                                                                              "36", 
                                                                                              "37", 
                                                                                              "38", 
                                                                                              "39", 
                                                                                              "39", 
                                                                                              "40", 
                                                                                              "41", 
                                                                                              "42", 
                                                                                              "43", 
                                                                                              "44", 
                                                                                              "45", 
                                                                                              "45", 
                                                                                              "45", 
                                                                                              "46", 
                                                                                              "48", 
                                                                                              "49", 
                                                                                              "49", 
                                                                                              "50", 
                                                                                              "51", 
                                                                                              "51", 
                                                                                              "55", 
                                                                                              "56", 
                                                                                              "74", 
                                                                                              "75", 
                                                                                              "76", 
                                                                                              "79", 
                                                                                              "79", 
                                                                                              "80", 
                                                                                              "81", 
                                                                                              "85", 
                                                                                              "86", 
                                                                                              "89", 
                                                                                              "89", 
                                                                                              "90", 
                                                                                              "91", 
                                                                                              "94", 
                                                                                              "95", 
                                                                                              "95", 
                                                                                              "96", 
                                                                                              "97", 
                                                                                              "97", 
                                                                                              "101", 
                                                                                              "102", 
                                                                                              "112", 
                                                                                              "112", 
                                                                                              "125", 
                                                                                              "127", 
                                                                                              "127", 
                                                                                              "129", 
                                                                                              "135", 
                                                                                              "141", 
                                                                                              "142", 
                                                                                              "148", 
                                                                                              "149", 
                                                                                              "152", 
                                                                                              "154", 
                                                                                              "155", 
                                                                                              "157", 
                                                                                              "160", 
                                                                                              "160", 
                                                                                              "163", 
                                                                                              "176", 
                                                                                              "176", 
                                                                                              "177", 
                                                                                              "177", 
                                                                                              "178", 
                                                                                              "178", 
                                                                                              "179", 
                                                                                              "179", 
                                                                                              "180", 
                                                                                              "180", 
                                                                                              "181", 
                                                                                              "181", 
                                                                                              "182", 
                                                                                              "182", 
                                                                                              "183", 
                                                                                              "185", 
                                                                                              "185", 
                                                                                              "186", 
                                                                                              "187", 
                                                                                              "192", 
                                                                                              "194", 
                                                                                              "244", 
                                                                                              "461", 
                                                                                              "463", 
                                                                                              "465", 
                                                                                              "7", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "9", 
                                                                                              "11", 
                                                                                              "16", 
                                                                                              "16", 
                                                                                              "19", 
                                                                                              "19", 
                                                                                              "24", 
                                                                                              "24", 
                                                                                              "38", 
                                                                                              "39", 
                                                                                              "40", 
                                                                                              "41", 
                                                                                              "42", 
                                                                                              "43", 
                                                                                              "43", 
                                                                                              "44", 
                                                                                              "44", 
                                                                                              "44", 
                                                                                              "45", 
                                                                                              "46", 
                                                                                              "49", 
                                                                                              "50", 
                                                                                              "59", 
                                                                                              "59", 
                                                                                              "64", 
                                                                                              "64", 
                                                                                              "70", 
                                                                                              "70", 
                                                                                              "71", 
                                                                                              "71", 
                                                                                              "72", 
                                                                                              "72", 
                                                                                              "73", 
                                                                                              "74", 
                                                                                              "74", 
                                                                                              "75", 
                                                                                              "75", 
                                                                                              "76", 
                                                                                              "77", 
                                                                                              "45", 
                                                                                              "49", 
                                                                                              "56", 
                                                                                              "56", 
                                                                                              "63", 
                                                                                              "63", 
                                                                                              "69", 
                                                                                              "74", 
                                                                                              "74", 
                                                                                              "75", 
                                                                                              "82", 
                                                                                              "83", 
                                                                                              "6", 
                                                                                              "8", 
                                                                                              "8", 
                                                                                              "9", 
                                                                                              "9", 
                                                                                              "11", 
                                                                                              "12", 
                                                                                              "13", 
                                                                                              "13", 
                                                                                              "13", 
                                                                                              "13", 
                                                                                              "15", 
                                                                                              "46", 
                                                                                              "71", 
                                                                                              "72", 
                                                                                              "74", 
                                                                                              "76", 
                                                                                              "77", 
                                                                                              "89", 
                                                                                              "23", 
                                                                                              "25", 
                                                                                              "33", 
                                                                                              "123", 
                                                                                              "125", 
                                                                                              "411", 
                                                                                              "417", 
                                                                                              "418", 
                                                                                              "423", 
                                                                                              },
                                                                                              };
                                                                                              }
