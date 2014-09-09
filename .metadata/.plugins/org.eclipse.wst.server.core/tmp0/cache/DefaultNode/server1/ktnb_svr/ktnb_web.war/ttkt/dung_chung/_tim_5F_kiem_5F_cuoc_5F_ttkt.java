package org.apache.jsp;

import cmc.com.ktnb.web.ttkt.dung_chung.form.TimKiemCuocTtktForm;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _tim_5F_kiem_5F_cuoc_5F_ttkt extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _tim_5F_kiem_5F_cuoc_5F_ttkt( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";

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

                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(0,31);to=(1,0)]
                                                                                              out.write("\r\n");

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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(1,33);to=(2,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(2,76);to=(3,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 4,2-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 9,0  LineMapIndex:59
                                                                                              //String tiTle = "Tìm kiếm cuộc Thanh tra Kiểm Tra";
                                                                                              String tiTle = "Tìm kiếm";   
                                                                                              if (request.getAttribute("title") == null || !"".equals(request.getAttribute("title")))
                                                                                              	tiTle = (String) request.getAttribute("title");
                                                                                              String nghiepVu = ((TimKiemCuocTtktForm) request.getAttribute("TimKiemCuocTtktForm")).getNghiepVu();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(8,2);to=(10,0)]
                                                                                              out.write("\r\n<h3 class=\"Header\">Thông tin Thanh tra Kiểm tra</h3>\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(10,69);to=(11,36)]
                                                                                              out.write("\r\n<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 12,36-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 12,87  LineMapIndex:65
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_23 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_23.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_23.setParent(null);
                                                                                              _jspx_th_html_rewrite_23.setPage("/include/js/ttkt/tim_kiem.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_23);
                                                                                              int _jspx_eval_html_rewrite_23 = _jspx_th_html_rewrite_23.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 12,36-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 12,87  LineMapIndex:66
                                                                                              if (_jspx_th_html_rewrite_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(11,87);to=(13,0)]
                                                                                              out.write("\">\r\n</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 14,0-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 14,42  LineMapIndex:67
                                                                                              /* ------  html:form ------ */
                                                                                              org.apache.struts.taglib.html.FormTag _jspx_th_html_form_0 = new org.apache.struts.taglib.html.FormTag();
                                                                                              _jspx_th_html_form_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_form_0.setParent(null);
                                                                                              _jspx_th_html_form_0.setAction("tim_kiem_cuoc_ttkt.do");
                                                                                              _jspxTagObjects.push(_jspx_th_html_form_0);
                                                                                              int _jspx_eval_html_form_0 = _jspx_th_html_form_0.doStartTag();
                                                                                              if (_jspx_eval_html_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(13,42);to=(14,39)]
                                                                                              out.write("\r\n\t<fieldset style=\"margin: 5px\"><legend>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 15,39-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 15,86  LineMapIndex:68
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_0 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_0.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_0.setKey("label.thong_tin_tim_kiem");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_0);
                                                                                              int _jspx_eval_bean_message_0 = _jspx_th_bean_message_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 15,39-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 15,86  LineMapIndex:69
                                                                                              if (_jspx_th_bean_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(14,86);to=(16,2)]
                                                                                              out.write("</legend>\r\n\t<table width=\"100%\" align=\"center\" cellspacing=\"5\">\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 17,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 17,37  LineMapIndex:70
                                                                                              if ("timKiem".equals(nghiepVu)) {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(16,39);to=(20,32)]
                                                                                              out.write("\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Năm tiến hành</td>\r\n\t\t\t<td width=\"1%\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 21,32-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 21,122  LineMapIndex:71
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_0.setProperty("namTienHanh");
                                                                                              _jspx_th_html_text_0.setStyleClass("text");
                                                                                              _jspx_th_html_text_0.setOnkeypress("return formatInt(event);");
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(20,122);to=(21,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 22,3-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 22,15  LineMapIndex:72
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(21,15);to=(24,7)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\" width=\"19%\">Đơn vị tiến hành</td>\r\n\t\t\t<td width=\"1%\"></td>\r\n\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 25,7-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 25,63  LineMapIndex:73
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_1 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_1.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_1.setProperty("tenCqtTienHanh");
                                                                                              _jspx_th_html_text_1.setStyleClass("text");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_1);
                                                                                              int _jspx_eval_html_text_1 = _jspx_th_html_text_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 25,7-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 25,63  LineMapIndex:74
                                                                                              if (_jspx_th_html_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(24,63);to=(26,2)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 27,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 27,5  LineMapIndex:75
                                                                                              }
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(26,7);to=(28,33)]
                                                                                              out.write("\r\n\t\t<tr>\r\n\t\t\t<td width=\"19%\" align=\"right\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 29,33-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 29,74  LineMapIndex:76
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_1 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_1.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_1.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_1.setKey("label.ma_cuoc_ttkt");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_1);
                                                                                              int _jspx_eval_bean_message_1 = _jspx_th_bean_message_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 29,33-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 29,74  LineMapIndex:77
                                                                                              if (_jspx_th_bean_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(28,74);to=(30,32)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\" width=\"1%\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 31,32-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 31,86  LineMapIndex:78
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_2.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_2.setStyleClass("text");
                                                                                              _jspx_th_html_text_2.setProperty("ma_cuoc_ttkt");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_2);
                                                                                              int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 31,32-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 31,86  LineMapIndex:79
                                                                                              if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(30,86);to=(31,33)]
                                                                                              out.write("</td>\r\n\t\t\t<td width=\"19%\" align=\"right\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 32,33-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 32,78  LineMapIndex:80
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_2 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_2.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_2.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_2.setKey("label.don_vi_duoc_ttkt");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_2);
                                                                                              int _jspx_eval_bean_message_2 = _jspx_th_bean_message_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 32,33-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 32,78  LineMapIndex:81
                                                                                              if (_jspx_th_bean_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(31,78);to=(33,32)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\" width=\"1%\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 34,32-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 34,91  LineMapIndex:82
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_3 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_3.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_3.setStyleClass("text");
                                                                                              _jspx_th_html_text_3.setProperty("don_vi_duoc_ttkt");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_3);
                                                                                              int _jspx_eval_html_text_3 = _jspx_th_html_text_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 34,32-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 34,91  LineMapIndex:83
                                                                                              if (_jspx_th_html_text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(33,91);to=(38,20)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Thời kỳ: Từ ngày</td>\r\n\t\t\t<td align=\"right\"></td>\r\n\t\t\t<td align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 39,20-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 39,136  LineMapIndex:84
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_4 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_4.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_4.setStyleClass("text");
                                                                                              _jspx_th_html_text_4.setProperty("tu_ngay");
                                                                                              _jspx_th_html_text_4.setOnkeypress("return formatDate(event,this);");
                                                                                              _jspx_th_html_text_4.setOnblur("isDate(this)");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_4);
                                                                                              int _jspx_eval_html_text_4 = _jspx_th_html_text_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 39,20-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 39,136  LineMapIndex:85
                                                                                              if (_jspx_th_html_text_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(38,136);to=(39,21)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 40,21-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 40,58  LineMapIndex:86
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_3 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_3.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_3.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_3.setKey("label.den_ngay");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_3);
                                                                                              int _jspx_eval_bean_message_3 = _jspx_th_bean_message_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 40,21-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 40,58  LineMapIndex:87
                                                                                              if (_jspx_th_bean_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(39,58);to=(41,20)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\"></td>\r\n\t\t\t<td align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 42,20-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 42,137  LineMapIndex:88
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_5 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_5.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_5.setStyleClass("text");
                                                                                              _jspx_th_html_text_5.setProperty("den_ngay");
                                                                                              _jspx_th_html_text_5.setOnkeypress("return formatDate(event,this);");
                                                                                              _jspx_th_html_text_5.setOnblur("isDate(this)");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_5);
                                                                                              int _jspx_eval_html_text_5 = _jspx_th_html_text_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 42,20-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 42,137  LineMapIndex:89
                                                                                              if (_jspx_th_html_text_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(41,137);to=(46,32)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"19%\" align=\"right\">Thời gian dự kiến</td>\r\n\t\t\t<td width=\"1%\" align=\"right\"></td>\r\n\t\t\t<td width=\"30%\" align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 47,32-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 47,187  LineMapIndex:90
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_6 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_6.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_6.setStyleClass("text");
                                                                                              _jspx_th_html_text_6.setStyle("width: 40");
                                                                                              _jspx_th_html_text_6.setProperty("thoiGianDuKien");
                                                                                              _jspx_th_html_text_6.setOnkeypress("return formatInt(event);");
                                                                                              _jspx_th_html_text_6.setOnblur("if(!isNumber(this, 'i')) return;");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_6);
                                                                                              int _jspx_eval_html_text_6 = _jspx_th_html_text_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 47,32-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 47,187  LineMapIndex:91
                                                                                              if (_jspx_th_html_text_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(46,187);to=(52,52)]
                                                                                              out.write(" Ngày</td>\r\n\t\t\t<td width=\"19%\" align=\"right\">Từ ngày - đến ngày</td>\r\n\t\t\t<td width=\"1%\" align=\"right\"></td>\r\n\t\t\t<td width=\"30%\" align=\"left\">\r\n\t\t\t<table style=\"margin: 0\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"left\" width=\"45%\" style=\"margin: 0\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 53,52-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 53,269  LineMapIndex:92
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_7 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_7.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_7.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_7.setStyleClass("text");
                                                                                              _jspx_th_html_text_7.setProperty("thoiGianDuKienTuNgay");
                                                                                              _jspx_th_html_text_7.setOnkeypress("return formatDate(event,this);");
                                                                                              _jspx_th_html_text_7.setOnblur("if(!isDate(this)) return; compareDate(this, document.getElementsByName('thoiGianDuKienDenNgay')[0]);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_7);
                                                                                              int _jspx_eval_html_text_7 = _jspx_th_html_text_7.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 53,52-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 53,269  LineMapIndex:93
                                                                                              if (_jspx_th_html_text_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(52,269);to=(54,53)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t<td width=\"10%\" align=\"center\" style=\"text-align: center; margin: 0\">-</td>\r\n\t\t\t\t\t<td align=\"right\" width=\"45%\" style=\"margin: 0\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 55,53-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 55,289  LineMapIndex:94
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_8 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_8.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_8.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_8.setStyleClass("text");
                                                                                              _jspx_th_html_text_8.setStyleClass("text");
                                                                                              _jspx_th_html_text_8.setProperty("thoiGianDuKienDenNgay");
                                                                                              _jspx_th_html_text_8.setOnkeypress("return formatDate(event, this);");
                                                                                              _jspx_th_html_text_8.setOnblur("if(!isDate(this)) return; compareDate(document.getElementsByName('thoiGianDuKienTuNgay')[0], this);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_8);
                                                                                              int _jspx_eval_html_text_8 = _jspx_th_html_text_8.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 55,53-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 55,289  LineMapIndex:95
                                                                                              if (_jspx_th_html_text_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(54,289);to=(63,32)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t\r\n\t\t<tr>\r\n\t\t\t<td width=\"19%\" align=\"right\">Tên trưởng đoàn</td>\r\n\t\t\t<td align=\"right\" width=\"1%\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 64,32-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 64,87  LineMapIndex:96
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_9 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_9.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_9.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_9.setStyleClass("text");
                                                                                              _jspx_th_html_text_9.setProperty("tenTruongDoan");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_9);
                                                                                              int _jspx_eval_html_text_9 = _jspx_th_html_text_9.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 64,32-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 64,87  LineMapIndex:97
                                                                                              if (_jspx_th_html_text_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(63,87);to=(67,5)]
                                                                                              out.write("</td>\r\n\t\t\t<td width=\"19%\" align=\"right\">Sắp xếp</td>\r\n\t\t\t<td align=\"right\" width=\"1%\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 68,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 68,56  LineMapIndex:98
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_0 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_select_0.setProperty("sapXep");
                                                                                              _jspx_th_html_select_0.setStyle("width: 100%");
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(67,56);to=(68,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 69,6-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 69,40  LineMapIndex:99
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_0 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_0.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_option_0.setValue("TangThoiGian");
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(68,40);to=(68,69)]
                                                                                              out.write("Tăng theo thời gian thực hiện");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 69,69-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 69,83  LineMapIndex:100
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(68,83);to=(69,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 70,6-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 70,40  LineMapIndex:101
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_1 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_1.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_option_1.setValue("GiamThoiGian");
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(69,40);to=(69,69)]
                                                                                              out.write("Giảm theo thời gian thực hiện");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 70,69-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 70,83  LineMapIndex:102
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(69,83);to=(70,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 71,6-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 71,37  LineMapIndex:103
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_2 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_2.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_option_2.setValue("TangThuTu");
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(70,37);to=(70,63)]
                                                                                              out.write("Tăng theo thứ tự cuộc TTKT");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 71,63-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 71,77  LineMapIndex:104
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(70,77);to=(71,6)]
                                                                                              out.write("\t\t\t\t\t\t\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 72,6-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 72,37  LineMapIndex:105
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_3 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_3.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_option_3.setValue("GiamThuTu");
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(71,37);to=(71,63)]
                                                                                              out.write("Giảm theo thứ tự cuộc TTKT");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 72,63-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 72,77  LineMapIndex:106
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(71,77);to=(72,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 73,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 73,19  LineMapIndex:107
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(72,19);to=(76,21)]
                                                                                              out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 77,21-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 77,54  LineMapIndex:108
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_4 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_4.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_4.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_4.setKey("label.loai");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_4);
                                                                                              int _jspx_eval_bean_message_4 = _jspx_th_bean_message_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 77,21-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 77,54  LineMapIndex:109
                                                                                              if (_jspx_th_bean_message_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(76,54);to=(78,20)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\"></td>\r\n\t\t\t<td align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 79,20-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 79,71  LineMapIndex:110
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_1 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_1.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_select_1.setStyleClass("combobox");
                                                                                              _jspx_th_html_select_1.setProperty("loai");
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(78,71);to=(80,4)]
                                                                                              out.write("\r\n\t\t\t\t<!--Dot xuat, dinh ky-->\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 81,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 81,29  LineMapIndex:111
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_4 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_4.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_4.setValue("all");
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(80,29);to=(81,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 82,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 82,40  LineMapIndex:112
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_5 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_5.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_5.setParent(_jspx_th_html_option_4);
                                                                                              _jspx_th_bean_message_5.setKey("label.tat_ca");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_5);
                                                                                              int _jspx_eval_bean_message_5 = _jspx_th_bean_message_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 82,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 82,40  LineMapIndex:113
                                                                                              if (_jspx_th_bean_message_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(81,40);to=(82,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 83,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 83,18  LineMapIndex:114
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(82,18);to=(83,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 84,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 84,27  LineMapIndex:115
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_5 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_5.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_5.setValue("0");
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(83,27);to=(84,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 85,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 85,41  LineMapIndex:116
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_6 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_6.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_6.setParent(_jspx_th_html_option_5);
                                                                                              _jspx_th_bean_message_6.setKey("label.dinh_ky");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_6);
                                                                                              int _jspx_eval_bean_message_6 = _jspx_th_bean_message_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 85,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 85,41  LineMapIndex:117
                                                                                              if (_jspx_th_bean_message_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(84,41);to=(85,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 86,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 86,18  LineMapIndex:118
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(85,18);to=(86,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 87,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 87,27  LineMapIndex:119
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_6 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_6.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_6.setValue("1");
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(86,27);to=(87,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 88,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 88,42  LineMapIndex:120
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_7 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_7.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_7.setParent(_jspx_th_html_option_6);
                                                                                              _jspx_th_bean_message_7.setKey("label.dot_xuat");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_7);
                                                                                              int _jspx_eval_bean_message_7 = _jspx_th_bean_message_7.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 88,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 88,42  LineMapIndex:121
                                                                                              if (_jspx_th_bean_message_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(87,42);to=(88,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 89,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 89,18  LineMapIndex:122
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(88,18);to=(89,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 90,3-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 90,17  LineMapIndex:123
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(89,17);to=(90,3)]
                                                                                              out.write("</td>\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 91,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 91,38  LineMapIndex:124
                                                                                              if ("timKiem".equals(nghiepVu)) {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(90,40);to=(92,3)]
                                                                                              out.write("\r\n\t\t\t<td align=\"right\">\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 93,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 93,38  LineMapIndex:125
                                                                                              if ("timKiem".equals(nghiepVu)) {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(92,40);to=(92,52)]
                                                                                              out.write(" Trạng thái ");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 93,54-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 93,55  LineMapIndex:126
                                                                                              }
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(92,57);to=(96,3)]
                                                                                              out.write("\r\n\t\t\t</td>\r\n\t\t\t<td align=\"left\"></td>\r\n\t\t\t<td>\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 97,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 97,38  LineMapIndex:127
                                                                                              if ("timKiem".equals(nghiepVu)) {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(96,40);to=(96,41)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 97,41-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 97,95  LineMapIndex:128
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_2 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_2.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_select_2.setProperty("trangThai");
                                                                                              _jspx_th_html_select_2.setStyle("width: 100%");
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(96,95);to=(97,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 98,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 98,26  LineMapIndex:129
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_7 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_7.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_7.setParent(_jspx_th_html_select_2);
                                                                                              _jspx_th_html_option_7.setValue("");
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(97,26);to=(97,32)]
                                                                                              out.write("Tất cả");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 98,32-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 98,46  LineMapIndex:130
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(97,46);to=(98,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 99,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 99,43  LineMapIndex:131
                                                                                              /* ------  html:options ------ */
                                                                                              org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_0 = new org.apache.struts.taglib.html.OptionsTag();
                                                                                              _jspx_th_html_options_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_options_0.setParent(_jspx_th_html_select_2);
                                                                                              _jspx_th_html_options_0.setName("dsTrangThaiTtkt");
                                                                                              _jspxTagObjects.push(_jspx_th_html_options_0);
                                                                                              int _jspx_eval_html_options_0 = _jspx_th_html_options_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 99,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 99,43  LineMapIndex:132
                                                                                              if (_jspx_th_html_options_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(98,43);to=(99,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 100,3-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 100,17  LineMapIndex:133
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(99,17);to=(99,18)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 100,20-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 100,28  LineMapIndex:134
                                                                                              } else {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(99,30);to=(99,31)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem.jsp";from=(0,0);to=(0,28)]
                                                                                              out.write("<input type=\"button\" value='");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem.jsp" 1,28-"/ttkt/dung_chung/tim_kiem.jsp" 1,59  LineMapIndex:135
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_8 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_8.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_8.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_8.setKey("tim_kiem");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_8);
                                                                                              int _jspx_eval_bean_message_8 = _jspx_th_bean_message_8.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem.jsp" 1,28-"/ttkt/dung_chung/tim_kiem.jsp" 1,59  LineMapIndex:136
                                                                                              if (_jspx_th_bean_message_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem.jsp";from=(0,59);to=(21,9)]
                                                                                              out.write("' style=\"width: 80; margin: 0\" class=\"button\" onclick=\"search();\" />\r\n<script language=\"javascript\">    \r\n\t$(function(){\r\n    $('input').keydown(function(e){\r\n        if (e.keyCode == 13) {\r\n            search();\r\n            return false;\r\n        }\r\n    });\r\n});\r\n \tfunction search(){\r\n \t\tif(!validateForm()) \r\n \t\t\treturn;\r\n \t\ttry{\r\n \t\t\tselfSearch();\r\n \t\t}catch(err){ \t\t\t\r\n\t \t\tdocument.forms[0].action = document.forms[0].action.split('?')[0];\r\n\t \t\tdocument.forms[0].submit();\t\t\r\n \t\t}\r\n \t\t\r\n \t}\r\n</script>");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(99,81);to=(99,82)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 100,84-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 100,85  LineMapIndex:137
                                                                                              }
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(99,87);to=(101,3)]
                                                                                              out.write("\r\n\t\t\t</td>\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 102,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 102,11  LineMapIndex:138
                                                                                              }else{
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(101,13);to=(104,7)]
                                                                                              out.write("\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td>");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem.jsp";from=(0,0);to=(0,28)]
                                                                                              out.write("<input type=\"button\" value='");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem.jsp" 1,28-"/ttkt/dung_chung/tim_kiem.jsp" 1,59  LineMapIndex:139
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_9 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_9.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_9.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_9.setKey("tim_kiem");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_9);
                                                                                              int _jspx_eval_bean_message_9 = _jspx_th_bean_message_9.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem.jsp" 1,28-"/ttkt/dung_chung/tim_kiem.jsp" 1,59  LineMapIndex:140
                                                                                              if (_jspx_th_bean_message_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem.jsp";from=(0,59);to=(21,9)]
                                                                                              out.write("' style=\"width: 80; margin: 0\" class=\"button\" onclick=\"search();\" />\r\n<script language=\"javascript\">    \r\n\t$(function(){\r\n    $('input').keydown(function(e){\r\n        if (e.keyCode == 13) {\r\n            search();\r\n            return false;\r\n        }\r\n    });\r\n});\r\n \tfunction search(){\r\n \t\tif(!validateForm()) \r\n \t\t\treturn;\r\n \t\ttry{\r\n \t\t\tselfSearch();\r\n \t\t}catch(err){ \t\t\t\r\n\t \t\tdocument.forms[0].action = document.forms[0].action.split('?')[0];\r\n\t \t\tdocument.forms[0].submit();\t\t\r\n \t\t}\r\n \t\t\r\n \t}\r\n</script>");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(104,57);to=(105,3)]
                                                                                              out.write("</td>\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 106,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 106,6  LineMapIndex:141
                                                                                              }
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(105,8);to=(107,2)]
                                                                                              out.write("\r\n\t\t</tr>\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 108,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 108,37  LineMapIndex:142
                                                                                              if ("timKiem".equals(nghiepVu)) {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(107,39);to=(114,7)]
                                                                                              out.write("\r\n\t\t<tr>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td>");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem.jsp";from=(0,0);to=(0,28)]
                                                                                              out.write("<input type=\"button\" value='");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem.jsp" 1,28-"/ttkt/dung_chung/tim_kiem.jsp" 1,59  LineMapIndex:143
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_10 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_10.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_10.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_10.setKey("tim_kiem");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_10);
                                                                                              int _jspx_eval_bean_message_10 = _jspx_th_bean_message_10.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem.jsp" 1,28-"/ttkt/dung_chung/tim_kiem.jsp" 1,59  LineMapIndex:144
                                                                                              if (_jspx_th_bean_message_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem.jsp";from=(0,59);to=(21,9)]
                                                                                              out.write("' style=\"width: 80; margin: 0\" class=\"button\" onclick=\"search();\" />\r\n<script language=\"javascript\">    \r\n\t$(function(){\r\n    $('input').keydown(function(e){\r\n        if (e.keyCode == 13) {\r\n            search();\r\n            return false;\r\n        }\r\n    });\r\n});\r\n \tfunction search(){\r\n \t\tif(!validateForm()) \r\n \t\t\treturn;\r\n \t\ttry{\r\n \t\t\tselfSearch();\r\n \t\t}catch(err){ \t\t\t\r\n\t \t\tdocument.forms[0].action = document.forms[0].action.split('?')[0];\r\n\t \t\tdocument.forms[0].submit();\t\t\r\n \t\t}\r\n \t\t\r\n \t}\r\n</script>");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(114,57);to=(116,2)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 117,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 117,5  LineMapIndex:145
                                                                                              }
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(116,7);to=(119,48)]
                                                                                              out.write("\r\n\t</table>\r\n\t</fieldset>\r\n\t<Fieldset style=\"margin: 5px\"><legend>Tổng số: ");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 120,51-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 120,86  LineMapIndex:146
                                                                                              out.print(request.getAttribute("countResult"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(119,88);to=(131,2)]
                                                                                              out.write(" </legend>\r\n\t<table width=\"100%\" align=\"center\">\r\n\t\t<tr class=\"TdHeaderListOfSearch\">\r\n\t\t\t<td width=\"10%\">Mã</td>\r\n\t\t\t<td align=\"left\" width=\"15%\">Đơn vị tiến hành</td>\r\n\t\t\t<td align=\"left\" width=\"15%\">Đơn vị được kiểm tra</td>\r\n\t\t\t<td width=\"17%\">Thời kỳ</td>\r\n\t\t\t<td align=\"center\" width=\"8%\">Thời gian</td>\r\n\t\t\t<td width=\"13%\">Từ ngày - đến ngày</td>\r\n\t\t\t<td width=\"7%\">Loại</td>\r\n\t\t\t<td align=\"left\" width=\"15%\">Trạng thái</td>\r\n\t\t</tr>\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 132,2-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 132,89  LineMapIndex:147
                                                                                              /* ------  logic:iterate ------ */
                                                                                              org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_0 = new org.apache.struts.taglib.logic.IterateTag();
                                                                                              _jspx_th_logic_iterate_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_iterate_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_logic_iterate_0.setId("cuocTTKT");
                                                                                              _jspx_th_logic_iterate_0.setName("tableKetQuaTimKiem");
                                                                                              _jspx_th_logic_iterate_0.setProperty("data");
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
                                                                                              java.lang.Object cuocTTKT = null;
                                                                                              cuocTTKT = (java.lang.Object) pageContext.findAttribute("cuocTTKT");
                                                                                              java.lang.Integer index = null;
                                                                                              index = (java.lang.Integer) pageContext.findAttribute("index");
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(131,89);to=(132,17)]
                                                                                              out.write("\r\n\t\t\t<tr class='row");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 133,20-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 133,45  LineMapIndex:148
                                                                                              out.print((index.intValue() % 2)+1 );
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(132,47);to=(133,43)]
                                                                                              out.write("'>\r\n\t\t\t\t<td><A href=\"#\" onclick=\"openNghiepVu('");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 134,43-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 134,86  LineMapIndex:149
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_0.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_0.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_0.setName("cuocTTKT");
                                                                                              _jspx_th_bean_write_0.setProperty("id");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_0);
                                                                                              int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 134,43-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 134,86  LineMapIndex:150
                                                                                              if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(133,86);to=(133,91)]
                                                                                              out.write("')\"> ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 134,91-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 134,135  LineMapIndex:151
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_1 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_1.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_1.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_1.setName("cuocTTKT");
                                                                                              _jspx_th_bean_write_1.setProperty("ma");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_1);
                                                                                              int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 134,91-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 134,135  LineMapIndex:152
                                                                                              if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(133,135);to=(134,21)]
                                                                                              out.write(" </A></td>\r\n\t\t\t\t<td align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 135,21-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 135,73  LineMapIndex:153
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_2 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_2.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_2.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_2.setName("cuocTTKT");
                                                                                              _jspx_th_bean_write_2.setProperty("tenDonViTh");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_2);
                                                                                              int _jspx_eval_bean_write_2 = _jspx_th_bean_write_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 135,21-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 135,73  LineMapIndex:154
                                                                                              if (_jspx_th_bean_write_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(134,73);to=(135,21)]
                                                                                              out.write("</td>\r\n\t\t\t\t<td align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 136,21-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 136,73  LineMapIndex:155
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_3 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_3.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_3.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_3.setName("cuocTTKT");
                                                                                              _jspx_th_bean_write_3.setProperty("tenDonViBi");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_3);
                                                                                              int _jspx_eval_bean_write_3 = _jspx_th_bean_write_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 136,21-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 136,73  LineMapIndex:156
                                                                                              if (_jspx_th_bean_write_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(135,73);to=(137,22)]
                                                                                              out.write("</td>\r\n\t\t\t\t<td><script language=\"javascript\">\r\n\t\t\t\t\t\tdocument.write('");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 138,22-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 138,78  LineMapIndex:157
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_4 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_4.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_4.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_4.setName("cuocTTKT");
                                                                                              _jspx_th_bean_write_4.setProperty("nienDoTuNgayStr");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_4);
                                                                                              int _jspx_eval_bean_write_4 = _jspx_th_bean_write_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 138,22-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 138,78  LineMapIndex:158
                                                                                              if (_jspx_th_bean_write_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(137,78);to=(137,89)]
                                                                                              out.write("' + '-' + '");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 138,89-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 138,146  LineMapIndex:159
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_5 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_5.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_5.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_5.setName("cuocTTKT");
                                                                                              _jspx_th_bean_write_5.setProperty("nienDoDenNgayStr");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_5);
                                                                                              int _jspx_eval_bean_write_5 = _jspx_th_bean_write_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 138,89-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 138,146  LineMapIndex:160
                                                                                              if (_jspx_th_bean_write_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(137,146);to=(140,22)]
                                                                                              out.write("');\r\n\t\t\t\t\t</script></td>\r\n\t\t\t\t<td align=\"center\"><script language=\"javascript\">\r\n\t\t\t\t\t\tdocument.write('");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 141,22-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 141,77  LineMapIndex:161
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_6 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_6.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_6.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_6.setName("cuocTTKT");
                                                                                              _jspx_th_bean_write_6.setProperty("thoiGianDuKien");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_6);
                                                                                              int _jspx_eval_bean_write_6 = _jspx_th_bean_write_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 141,22-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 141,77  LineMapIndex:162
                                                                                              if (_jspx_th_bean_write_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(140,77);to=(144,22)]
                                                                                              out.write("');\r\n\t\t\t\t\t\tdocument.write(' ngày');\r\n\t\t\t\t\t</script></td>\r\n\t\t\t\t<td><script language=\"javascript\">\r\n\t\t\t\t\t\tdocument.write('");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 145,22-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 145,86  LineMapIndex:163
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_7 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_7.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_7.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_7.setName("cuocTTKT");
                                                                                              _jspx_th_bean_write_7.setProperty("thoiGianDuKienTuNgayStr");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_7);
                                                                                              int _jspx_eval_bean_write_7 = _jspx_th_bean_write_7.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 145,22-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 145,86  LineMapIndex:164
                                                                                              if (_jspx_th_bean_write_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(144,86);to=(144,112)]
                                                                                              out.write("'.substring(0,5) + '-' + '");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 145,112-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 145,177  LineMapIndex:165
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_8 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_8.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_8.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_8.setName("cuocTTKT");
                                                                                              _jspx_th_bean_write_8.setProperty("thoiGianDuKienDenNgayStr");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_8);
                                                                                              int _jspx_eval_bean_write_8 = _jspx_th_bean_write_8.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 145,112-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 145,177  LineMapIndex:166
                                                                                              if (_jspx_th_bean_write_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(144,177);to=(146,8)]
                                                                                              out.write("');\r\n\t\t\t\t\t</script></td>\r\n\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 147,8-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 147,66  LineMapIndex:167
                                                                                              /* ------  logic:equal ------ */
                                                                                              org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_0 = new org.apache.struts.taglib.logic.EqualTag();
                                                                                              _jspx_th_logic_equal_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_equal_0.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_logic_equal_0.setName("cuocTTKT");
                                                                                              _jspx_th_logic_equal_0.setProperty("loai");
                                                                                              _jspx_th_logic_equal_0.setValue("true");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_equal_0);
                                                                                              int _jspx_eval_logic_equal_0 = _jspx_th_logic_equal_0.doStartTag();
                                                                                              if (_jspx_eval_logic_equal_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(146,66);to=(147,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 148,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 148,42  LineMapIndex:168
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_11 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_11.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_11.setParent(_jspx_th_logic_equal_0);
                                                                                              _jspx_th_bean_message_11.setKey("label.dot_xuat");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_11);
                                                                                              int _jspx_eval_bean_message_11 = _jspx_th_bean_message_11.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 148,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 148,42  LineMapIndex:169
                                                                                              if (_jspx_th_bean_message_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(147,42);to=(148,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 149,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 149,18  LineMapIndex:170
                                                                                              } while (_jspx_th_logic_equal_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_equal_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(148,18);to=(148,19)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 149,19-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 149,78  LineMapIndex:171
                                                                                              /* ------  logic:equal ------ */
                                                                                              org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_1 = new org.apache.struts.taglib.logic.EqualTag();
                                                                                              _jspx_th_logic_equal_1.setPageContext(pageContext);
                                                                                              _jspx_th_logic_equal_1.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_logic_equal_1.setName("cuocTTKT");
                                                                                              _jspx_th_logic_equal_1.setProperty("loai");
                                                                                              _jspx_th_logic_equal_1.setValue("false");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_equal_1);
                                                                                              int _jspx_eval_logic_equal_1 = _jspx_th_logic_equal_1.doStartTag();
                                                                                              if (_jspx_eval_logic_equal_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(148,78);to=(149,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 150,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 150,41  LineMapIndex:172
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_12 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_12.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_12.setParent(_jspx_th_logic_equal_1);
                                                                                              _jspx_th_bean_message_12.setKey("label.dinh_ky");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_12);
                                                                                              int _jspx_eval_bean_message_12 = _jspx_th_bean_message_12.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 150,5-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 150,41  LineMapIndex:173
                                                                                              if (_jspx_th_bean_message_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(149,41);to=(150,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 151,4-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 151,18  LineMapIndex:174
                                                                                              } while (_jspx_th_logic_equal_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_equal_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(150,18);to=(151,21)]
                                                                                              out.write("</td>\r\n\t\t\t\t<td align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 152,21-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 152,72  LineMapIndex:175
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_9 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_9.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_9.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_9.setName("cuocTTKT");
                                                                                              _jspx_th_bean_write_9.setProperty("trangThai");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_9);
                                                                                              int _jspx_eval_bean_write_9 = _jspx_th_bean_write_9.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 152,21-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 152,72  LineMapIndex:176
                                                                                              if (_jspx_th_bean_write_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(151,72);to=(153,2)]
                                                                                              out.write("</td>\r\n\t\t\t</tr>\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 154,2-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 154,18  LineMapIndex:177
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
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(153,18);to=(155,34)]
                                                                                              out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"8\" align=\"center\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 156,34-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 156,114  LineMapIndex:178
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_10 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_10.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_10.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_write_10.setName("tableKetQuaTimKiem");
                                                                                              _jspx_th_bean_write_10.setProperty("navigationBar");
                                                                                              _jspx_th_bean_write_10.setFilter(false);
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_10);
                                                                                              int _jspx_eval_bean_write_10 = _jspx_th_bean_write_10.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 156,34-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 156,114  LineMapIndex:179
                                                                                              if (_jspx_th_bean_write_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(155,114);to=(165,1)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t</fieldset>\r\n\t<BR>\r\n\t<TABLE width=\"30%\" align=\"center\">\r\n\t\t<tr align=\"center\">\r\n\t\t\t<td width=\"20%\" align=\"center\"><INPUT type=\"button\" class=\"button\" value=\"Đóng\" onclick=\"window.location = 'ttkt_index.do';\"></td>\r\n\t\t</tr>\r\n\t</TABLE>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 166,1-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 166,63  LineMapIndex:180
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_hidden_0.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_html_hidden_0.setProperty("nghiepVu");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_0);
                                                                                              int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 166,1-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 166,63  LineMapIndex:181
                                                                                              if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(165,63);to=(166,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 167,0-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 167,12  LineMapIndex:182
                                                                                              } while (_jspx_th_html_form_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_html_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(166,12);to=(167,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(0,31);to=(22,4)]
                                                                                              out.write("\r\n<script language=\"Javascript\">\r\n$(function() \r\n{\r\n  $(document).bind('keydown','esc',function(evt){onButton('exit');return false;});\r\n  $(document).bind('keydown','home',function(evt){window.location='index.do';return false;});\r\n  if($('#exit').length>0)\r\n  {\r\n   $('#exit').button({icons:{primary:'ui-icon-close'}}).click(function(){onButton('exit');return false;});\r\n  }\r\n  if($('#search').length>0)\r\n  {\r\n    $('#search').button({icons:{primary:'ui-icon-search'}}).click(function(){onButton('search');return false;});\r\n    $(document).bind('keydown','Shift+s',function(evt){onButton('search');return false;});\r\n  }\r\n  if($('table.data_table').length>0)\r\n  {\r\n    $('table.data_table tbody tr').each(function(index) {$(this).addClass(arrClassName[index%3]);});\r\n    $(\"table.data_table tbody\").delegate(\"tr\", \"hover\", function(){$(this).toggleClass(\"highlight\");});\r\n  }\r\n  if($('#msgdiv').length>0)\r\n  {\r\n    ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/bottom.jsp" 23,4-"/bottom.jsp" 23,30  LineMapIndex:183
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_0 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_0.setParent(null);
                                                                                              _jspx_th_logic_present_0.setName("msg");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_0);
                                                                                              int _jspx_eval_logic_present_0 = _jspx_th_logic_present_0.doStartTag();
                                                                                              if (_jspx_eval_logic_present_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(22,30);to=(24,4)]
                                                                                              out.write("\r\n     $('#msgdiv').effect('pulsate',{times:3});\r\n    ");

                                                                                              // end
                                                                                              // ##DEBUG## "/bottom.jsp" 25,4-"/bottom.jsp" 25,20  LineMapIndex:184
                                                                                              } while (_jspx_th_logic_present_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(24,20);to=(32,92)]
                                                                                              out.write("\r\n  } \r\n});\r\n</script>\r\n</div>\r\n<div id=\"bottom\">\r\n<table width=\"100%\" border=\"0\" bordercolor=\"#AEC1F1\">\r\n\t<tr>\r\n\t\t<td align=\"center\" width=\"20%\" style=\"color: blue; font-size: 8pt\">KTNB Phiên bản <strong>");

                                                                                              // end
                                                                                              // ##DEBUG## "/bottom.jsp" 33,95-"/bottom.jsp" 33,113  LineMapIndex:185
                                                                                              out.print(ac.getVersionApp());
                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(32,115);to=(60,9)]
                                                                                              out.write("</strong> <br>\r\n\t\t<script language=JavaScript>\r\n                                                dayname = new Array(\"Chủ nhật\", \"Thứ Hai\", \"Thứ Ba\", \"Thứ Tư\", \"Thứ Năm\", \"Thứ Sáu\", \"Thứ Bẩy\");\r\n                                                monthname = new Array(\"01\", \"02\", \"03\", \"04\", \"05\", \"06\", \"07\", \"08\", \"09\", \"10\", \"11\", \"12\");\r\n                                                now = new Date();\r\n                                                daynum = now.getDay();\r\n                                                day = dayname[daynum];\r\n                                                date = now.getDate();\r\n                                                monthnum = now.getMonth();\r\n                                                month = monthname[monthnum];\r\n                                                document.write(\"\"+day+\", Ngày \"+date+\"/\"+month+\"/\"+now.getYear()+\"\");\r\n          </script></td>\r\n\t\t<td align=\"center\" width=\"70%\"><font style=\"color: blue; font-size: 8pt\"> <b>TỔNG CỤC THUẾ</b> <BR>\r\n\t\t<strong>Địa chỉ:</strong> Số 123 Lò Đúc, Hà Nội &nbsp; &nbsp;<strong>Điện thoại:</strong> (04) 9.724204 - 9.724209 <strong>Fax:</strong> (04) 9.712286 <br>\r\n\t\t<strong>Website:</strong> <a href=\"http://www.gdt.gov.vn\" target=\"_blank\">http://www.gdt.gov.vn</a> </font></td>\r\n\t</tr>\r\n</table>\r\n</div>\r\n</body>\r\n</html>\r\n<script language=\"Javascript\">\r\n// style js ui\r\n//$(function(){\r\n//\t$.each($('[type=\"button\"]'),function(index,value){\r\n//\t\t$(value).button();\r\n//\t\t$(value).css(\"font-size\",\"11\");\r\n//\t})\r\n//})\r\n</script>");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(167,32);to=(251,17)]
                                                                                              out.write("\r\n<script language=\"javascript\">\r\nfunction openNghiepVu(cuocTtktId){\t\r\n\tif('cbTienHanh' == document.forms[0].elements['nghiepVu'].value){\r\n\t\twindow.location = \"chuan_bi_tien_hanh.do?cuocTtktId=\" + cuocTtktId;\r\n\t}else if('tienhanh' == document.forms[0].elements['nghiepVu'].value){\r\n\t\twindow.location = \"tien_hanh_ttkt.do?cuocTtktId=\" + cuocTtktId;\t\r\n\t}else if('ketthuc' == document.forms[0].elements['nghiepVu'].value){\r\n\t\twindow.location = \"ket_thuc_ttkt.do?cuocTtktId=\" + cuocTtktId;\t\r\n\t}else if('timKiem' == document.forms[0].elements['nghiepVu'].value){\r\n\t\twindow.location = 'cuoc_ttkt.do?method=view&cuocTtktId=' + cuocTtktId;\r\n\t}\t\t\r\n}\r\n\r\n\r\nvar returnId;\r\nvar returnName;\r\nfunction chonTruongDoan(index, gridName){\t\r\n\treturnId = document.forms[0].elements[gridName + '[' + index + '].col11'];\r\n\treturnName = document.forms[0].elements[gridName + '[' + index + '].col12'];\r\n\twin = window.open(\"tim_kiem_canBo.do?method=execute&select=tvd&tenNhanVien=\" + returnName.value,\"\",\"menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no,height=360,width=600,top=0,left=0\");\r\n\twin.focus(); \r\n}\r\nfunction getTruongDoan(ma, ten){\r\n\treturnId.value = ma;\r\n\treturnName.value = ten;\r\n}\r\nfunction getThongTinTruongDoan(id, name){\r\n\tdocument.getElementsByName(returnId)[0].value = id;\r\n\tdocument.getElementsByName(returnName)[0].value = name;\r\n}\r\nfunction inKeHoachNam(){\r\n}\r\nfunction getSelectedCuocTtktId(){\r\n\tallRadio = document.getElementsByName('cuocTtktFocus');\r\n\tfor(var i = 0; i< allRadio.length; i++){\r\n\t\tif(allRadio[i].checked)\r\n\t\t\treturn allRadio[i].value;\r\n\t}\r\n\treturn '';\r\n}\r\nvar cuocTtktId;\r\nfunction validateForm(){\r\n\tif(!compareDate(document.getElementsByName('tu_ngay')[0], document.getElementsByName('den_ngay')[0]))\r\n\t\treturn false;\r\n\tif(!compareDate(document.getElementsByName('thoiGianDuKienTuNgay')[0], document.getElementsByName('thoiGianDuKienDenNgay')[0]))\r\n\t\treturn false;\r\n\t\t\r\n\treturn true;\r\n}\r\nfunction addNew(){\r\n\twindow.location = 'cuoc_ttkt.do?method=add'; \r\n}\r\nfunction copy(){\r\n\tcuocTtktId = getSelectedCuocTtktId();\r\n\tif(cuocTtktId == null || cuocTtktId == '' ){\r\n\t\talert('Chưa chọn bản ghi nào!');\r\n\t\treturn;\r\n\t}\r\n\twindow.location = 'cuoc_ttkt.do?method=copy&cuocTtktId='+ cuocTtktId;    \r\n}\t \r\n\r\nfunction sua(){ \r\n\tcuocTtktId = getSelectedCuocTtktId();\r\n\tif(cuocTtktId == null || cuocTtktId == '' ){\r\n\t\talert('Chưa chọn bản ghi nào!');\r\n\t\treturn;\r\n\t}\r\n\twindow.location = 'cuoc_ttkt.do?method=edit&cuocTtktId='+ cuocTtktId;\r\n}\r\nfunction viewThisItem(control){\r\n\t\r\n\tcuocTtktId = control.value;\r\n\tdocument.forms[0].elements['cuocTtktFocus'].value = cuocTtktId;\r\n}\r\nfunction xoa(){\r\n\tcuocTtktId = getSelectedCuocTtktId();\r\n\tif(cuocTtktId == null || cuocTtktId == '' ){\r\n\t\talert('Chưa chọn bản ghi nào!');\r\n\t\treturn;\r\n\t}\r\n\tdocument.forms[0].action = 'ke_hoach_nam.do?method=delete&cuocTtktId = '+ cuocTtktId;\r\n\tdocument.forms[0].submit();\t\t\t\r\n}\t\r\nvar countResult='");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 252,20-"/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp" 252,55  LineMapIndex:186
                                                                                              out.print(request.getAttribute("countResult"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp";from=(251,57);to=(252,9)]
                                                                                              out.write("';\r\n</script>");

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
                                                                                              "/ttkt/dung_chung/tim_kiem_cuoc_ttkt.jsp", 
                                                                                              "/top_bar.jsp", 
                                                                                              "/ttkt/dung_chung/tim_kiem.jsp", 
                                                                                              "/bottom.jsp", 
                                                                                              },
                                                                                              {
                                                                                              "0", 
                                                                                              "1", 
                                                                                              "135", 
                                                                                              "183", 
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
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "2", 
                                                                                              "2", 
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
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
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
                                                                                              "4", 
                                                                                              "5", 
                                                                                              "6", 
                                                                                              "7", 
                                                                                              "8", 
                                                                                              "9", 
                                                                                              "12", 
                                                                                              "12", 
                                                                                              "14", 
                                                                                              "15", 
                                                                                              "15", 
                                                                                              "17", 
                                                                                              "21", 
                                                                                              "22", 
                                                                                              "25", 
                                                                                              "25", 
                                                                                              "27", 
                                                                                              "29", 
                                                                                              "29", 
                                                                                              "31", 
                                                                                              "31", 
                                                                                              "32", 
                                                                                              "32", 
                                                                                              "34", 
                                                                                              "34", 
                                                                                              "39", 
                                                                                              "39", 
                                                                                              "40", 
                                                                                              "40", 
                                                                                              "42", 
                                                                                              "42", 
                                                                                              "47", 
                                                                                              "47", 
                                                                                              "53", 
                                                                                              "53", 
                                                                                              "55", 
                                                                                              "55", 
                                                                                              "64", 
                                                                                              "64", 
                                                                                              "68", 
                                                                                              "69", 
                                                                                              "69", 
                                                                                              "70", 
                                                                                              "70", 
                                                                                              "71", 
                                                                                              "71", 
                                                                                              "72", 
                                                                                              "72", 
                                                                                              "73", 
                                                                                              "77", 
                                                                                              "77", 
                                                                                              "79", 
                                                                                              "81", 
                                                                                              "82", 
                                                                                              "82", 
                                                                                              "83", 
                                                                                              "84", 
                                                                                              "85", 
                                                                                              "85", 
                                                                                              "86", 
                                                                                              "87", 
                                                                                              "88", 
                                                                                              "88", 
                                                                                              "89", 
                                                                                              "90", 
                                                                                              "91", 
                                                                                              "93", 
                                                                                              "93", 
                                                                                              "97", 
                                                                                              "97", 
                                                                                              "98", 
                                                                                              "98", 
                                                                                              "99", 
                                                                                              "99", 
                                                                                              "100", 
                                                                                              "100", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "100", 
                                                                                              "102", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "106", 
                                                                                              "108", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "117", 
                                                                                              "120", 
                                                                                              "132", 
                                                                                              "133", 
                                                                                              "134", 
                                                                                              "134", 
                                                                                              "134", 
                                                                                              "134", 
                                                                                              "135", 
                                                                                              "135", 
                                                                                              "136", 
                                                                                              "136", 
                                                                                              "138", 
                                                                                              "138", 
                                                                                              "138", 
                                                                                              "138", 
                                                                                              "141", 
                                                                                              "141", 
                                                                                              "145", 
                                                                                              "145", 
                                                                                              "145", 
                                                                                              "145", 
                                                                                              "147", 
                                                                                              "148", 
                                                                                              "148", 
                                                                                              "149", 
                                                                                              "149", 
                                                                                              "150", 
                                                                                              "150", 
                                                                                              "151", 
                                                                                              "152", 
                                                                                              "152", 
                                                                                              "154", 
                                                                                              "156", 
                                                                                              "156", 
                                                                                              "166", 
                                                                                              "166", 
                                                                                              "167", 
                                                                                              "23", 
                                                                                              "25", 
                                                                                              "33", 
                                                                                              "252", 
                                                                                              },
                                                                                              };
                                                                                              }
