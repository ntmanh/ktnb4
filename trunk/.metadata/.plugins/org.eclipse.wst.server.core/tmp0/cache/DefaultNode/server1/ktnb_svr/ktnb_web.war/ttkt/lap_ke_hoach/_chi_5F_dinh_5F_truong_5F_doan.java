package org.apache.jsp;

import cmc.com.ktnb.web.ttkt.dung_chung.form.TimKiemCuocTtktForm;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _chi_5F_dinh_5F_truong_5F_doan extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _chi_5F_dinh_5F_truong_5F_doan( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";

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

                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(0,31);to=(1,0)]
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(1,33);to=(2,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(2,76);to=(3,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(3,46);to=(4,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(4,55);to=(6,15)]
                                                                                              out.write("\r\n<script language=\"javascript\">                  \r\n\tvar tenCqt = \"");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 7,18-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 7,109  LineMapIndex:59
                                                                                              out.print(((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getTenCqt());
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(6,111);to=(7,14)]
                                                                                              out.write("\";\r\n\tvar maCqt = \"");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 8,17-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 8,107  LineMapIndex:60
                                                                                              out.print(((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getMaCqt());
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(7,109);to=(9,0)]
                                                                                              out.write("\";                 \r\n</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 10,2-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 18,0  LineMapIndex:61
                                                                                              
                                                                                              	//String tiTle = "T&#236;m ki&#7871;m cu&#7897;c Thanh tra Ki&#7875;m Tra";
                                                                                              	String tiTle = "T&#236;m ki&#7871;m";
                                                                                              	if(request.getAttribute("title") == null || !"".equals(request.getAttribute("title")))
                                                                                              		tiTle = (String)request.getAttribute("title");
                                                                                              	String nghiepVu = ((TimKiemCuocTtktForm)request.getAttribute("TimKiemCuocTtktForm")).getNghiepVu();
                                                                                              	
                                                                                              	
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(17,2);to=(18,19)]
                                                                                              out.write("\r\n<h3 class=\"Header\">");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 19,22-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 19,27  LineMapIndex:70
                                                                                              out.print(tiTle);
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(18,29);to=(19,0)]
                                                                                              out.write("</h3>\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(19,69);to=(20,36)]
                                                                                              out.write("\r\n<script type=\"text/javascript\" src=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 21,36-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 21,87  LineMapIndex:71
                                                                                              /* ------  html:rewrite ------ */
                                                                                              org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_23 = new org.apache.struts.taglib.html.RewriteTag();
                                                                                              _jspx_th_html_rewrite_23.setPageContext(pageContext);
                                                                                              _jspx_th_html_rewrite_23.setParent(null);
                                                                                              _jspx_th_html_rewrite_23.setPage("/include/js/ttkt/tim_kiem.js");
                                                                                              _jspxTagObjects.push(_jspx_th_html_rewrite_23);
                                                                                              int _jspx_eval_html_rewrite_23 = _jspx_th_html_rewrite_23.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 21,36-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 21,87  LineMapIndex:72
                                                                                              if (_jspx_th_html_rewrite_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(20,87);to=(22,0)]
                                                                                              out.write("\">\r\n</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 23,0-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 23,34  LineMapIndex:73
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_0 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_0.setParent(null);
                                                                                              _jspx_th_logic_present_0.setName("save_status");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_0);
                                                                                              int _jspx_eval_logic_present_0 = _jspx_th_logic_present_0.doStartTag();
                                                                                              if (_jspx_eval_logic_present_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(22,34);to=(23,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 24,1-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 24,49  LineMapIndex:74
                                                                                              /* ------  logic:equal ------ */
                                                                                              org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_0 = new org.apache.struts.taglib.logic.EqualTag();
                                                                                              _jspx_th_logic_equal_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_equal_0.setParent(_jspx_th_logic_present_0);
                                                                                              _jspx_th_logic_equal_0.setName("save_status");
                                                                                              _jspx_th_logic_equal_0.setValue("success");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_equal_0);
                                                                                              int _jspx_eval_logic_equal_0 = _jspx_th_logic_equal_0.doStartTag();
                                                                                              if (_jspx_eval_logic_equal_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(23,49);to=(27,1)]
                                                                                              out.write("\r\n\t\t<script language=\"javascript\">\r\n\t\t\talert('Lưu thành công!');\r\n\t\t</script>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 28,1-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 28,15  LineMapIndex:75
                                                                                              } while (_jspx_th_logic_equal_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_equal_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(27,15);to=(28,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 29,0-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 29,16  LineMapIndex:76
                                                                                              } while (_jspx_th_logic_present_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(28,16);to=(29,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 30,0-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 30,42  LineMapIndex:77
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(29,42);to=(30,39)]
                                                                                              out.write("\r\n\t<fieldset style=\"margin: 5px\"><legend>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 31,39-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 31,86  LineMapIndex:78
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_0 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_0.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_0.setKey("label.thong_tin_tim_kiem");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_0);
                                                                                              int _jspx_eval_bean_message_0 = _jspx_th_bean_message_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 31,39-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 31,86  LineMapIndex:79
                                                                                              if (_jspx_th_bean_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(30,86);to=(33,33)]
                                                                                              out.write("</legend>\r\n\t<table width=\"100%\" align=\"center\" cellspacing=\"5\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 34,33-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 34,74  LineMapIndex:80
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_1 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_1.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_1.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_1.setKey("label.ma_cuoc_ttkt");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_1);
                                                                                              int _jspx_eval_bean_message_1 = _jspx_th_bean_message_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 34,33-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 34,74  LineMapIndex:81
                                                                                              if (_jspx_th_bean_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(33,74);to=(35,32)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\" width=\"1%\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 36,32-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 36,86  LineMapIndex:82
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_0.setStyleClass("text");
                                                                                              _jspx_th_html_text_0.setProperty("ma_cuoc_ttkt");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_0);
                                                                                              int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 36,32-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 36,86  LineMapIndex:83
                                                                                              if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(35,86);to=(36,33)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\" width=\"19%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 37,33-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 37,78  LineMapIndex:84
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_2 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_2.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_2.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_2.setKey("label.don_vi_duoc_ttkt");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_2);
                                                                                              int _jspx_eval_bean_message_2 = _jspx_th_bean_message_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 37,33-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 37,78  LineMapIndex:85
                                                                                              if (_jspx_th_bean_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(36,78);to=(38,32)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\" width=\"1%\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 39,32-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 39,90  LineMapIndex:86
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_1 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_1.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_1.setStyleClass("text");
                                                                                              _jspx_th_html_text_1.setProperty("don_vi_duoc_ttkt");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_1);
                                                                                              int _jspx_eval_html_text_1 = _jspx_th_html_text_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 39,32-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 39,90  LineMapIndex:87
                                                                                              if (_jspx_th_html_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(38,90);to=(43,20)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Th&#x1EDD;i k&#x1EF3;: T&#x1EEB; ng&#xE0;y</td>\r\n\t\t\t<td align=\"right\"></td>\r\n\t\t\t<td align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 44,20-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 44,209  LineMapIndex:88
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_2.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_2.setStyleClass("text");
                                                                                              _jspx_th_html_text_2.setProperty("tu_ngay");
                                                                                              _jspx_th_html_text_2.setOnblur("if(!isDate(this)) return; compareDate(this, document.getElementsByName('den_ngay')[0])");
                                                                                              _jspx_th_html_text_2.setOnkeypress("return formatDate(event,this);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_2);
                                                                                              int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 44,20-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 44,209  LineMapIndex:89
                                                                                              if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(43,209);to=(44,21)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 45,21-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 45,58  LineMapIndex:90
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_3 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_3.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_3.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_3.setKey("label.den_ngay");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_3);
                                                                                              int _jspx_eval_bean_message_3 = _jspx_th_bean_message_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 45,21-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 45,58  LineMapIndex:91
                                                                                              if (_jspx_th_bean_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(44,58);to=(46,20)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\"></td>\r\n\t\t\t<td align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 47,20-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 47,209  LineMapIndex:92
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_3 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_3.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_3.setStyleClass("text");
                                                                                              _jspx_th_html_text_3.setProperty("den_ngay");
                                                                                              _jspx_th_html_text_3.setOnblur("if(!isDate(this)) return; compareDate(document.getElementsByName('tu_ngay')[0], this)");
                                                                                              _jspx_th_html_text_3.setOnkeypress("return formatDate(event,this);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_3);
                                                                                              int _jspx_eval_html_text_3 = _jspx_th_html_text_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 47,20-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 47,209  LineMapIndex:93
                                                                                              if (_jspx_th_html_text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(46,209);to=(51,32)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"19%\" align=\"right\">Th&#x1EDD;i gian d&#x1EF1; ki&#x1EBF;n</td>\r\n\t\t\t<td width=\"1%\" align=\"right\"></td>\r\n\t\t\t<td width=\"30%\" align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 52,32-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 52,187  LineMapIndex:94
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_4 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_4.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_4.setStyleClass("text");
                                                                                              _jspx_th_html_text_4.setStyle("width: 40");
                                                                                              _jspx_th_html_text_4.setProperty("thoiGianDuKien");
                                                                                              _jspx_th_html_text_4.setOnkeypress("return formatInt(event);");
                                                                                              _jspx_th_html_text_4.setOnblur("if(!isNumber(this, 'i')) return;");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_4);
                                                                                              int _jspx_eval_html_text_4 = _jspx_th_html_text_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 52,32-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 52,187  LineMapIndex:95
                                                                                              if (_jspx_th_html_text_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(51,187);to=(57,52)]
                                                                                              out.write(" Ng&#xE0;y</td>\r\n\t\t\t<td width=\"19%\" align=\"right\">T&#x1EEB; ng&#xE0;y - &#x111;&#x1EBF;n ng&#xE0;y</td>\r\n\t\t\t<td width=\"1%\" align=\"right\"></td>\r\n\t\t\t<td width=\"30%\" align=\"center\">\r\n\t\t\t<table style=\"margin: 0\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td align=\"left\" width=\"45%\" style=\"margin: 0\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 58,52-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 58,289  LineMapIndex:96
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_5 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_5.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_5.setStyleClass("text");
                                                                                              _jspx_th_html_text_5.setStyle("width: 100%");
                                                                                              _jspx_th_html_text_5.setProperty("thoiGianDuKienTuNgay");
                                                                                              _jspx_th_html_text_5.setOnkeypress("return formatDate(event,this);");
                                                                                              _jspx_th_html_text_5.setOnblur("if(!isDate(this)) return; compareDate(this, document.getElementsByName('thoiGianDuKienDenNgay')[0]);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_5);
                                                                                              int _jspx_eval_html_text_5 = _jspx_th_html_text_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 58,52-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 58,289  LineMapIndex:97
                                                                                              if (_jspx_th_html_text_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(57,289);to=(59,53)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t<td width=\"10%\" align=\"center\" style=\"text-align: center; margin: 0\">-</td>\r\n\t\t\t\t\t<td align=\"right\" width=\"45%\" style=\"margin: 0\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 60,53-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 61,117  LineMapIndex:98
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_6 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_6.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_6.setStyleClass("text");
                                                                                              _jspx_th_html_text_6.setStyle("width: 100%");
                                                                                              _jspx_th_html_text_6.setStyleClass("text");
                                                                                              _jspx_th_html_text_6.setProperty("thoiGianDuKienDenNgay");
                                                                                              _jspx_th_html_text_6.setOnkeypress("return formatDate(event, this);");
                                                                                              _jspx_th_html_text_6.setOnblur("if(!isDate(this)) return; compareDate(document.getElementsByName('thoiGianDuKienTuNgay')[0], this);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_6);
                                                                                              int _jspx_eval_html_text_6 = _jspx_th_html_text_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 60,53-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 61,117  LineMapIndex:100
                                                                                              if (_jspx_th_html_text_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(60,117);to=(66,26)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<!-- <td align=\"right\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 67,26-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 67,64  LineMapIndex:102
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_4 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_4.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_4.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_4.setKey("label.hinh_thuc");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_4);
                                                                                              int _jspx_eval_bean_message_4 = _jspx_th_bean_message_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 67,26-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 67,64  LineMapIndex:103
                                                                                              if (_jspx_th_bean_message_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(66,64);to=(70,4)]
                                                                                              out.write("\t\t\t\t\r\n\t\t\t</td>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t<td align=\"left\">\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 71,4-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 72,26  LineMapIndex:104
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_0 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_select_0.setStyleClass("combobox");
                                                                                              _jspx_th_html_select_0.setProperty("hinh_thuc");
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(71,26);to=(72,5)]
                                                                                              out.write("\t\t\t\t\t\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 73,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 73,30  LineMapIndex:106
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_0 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_0.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_option_0.setValue("all");
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(72,30);to=(73,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 74,6-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 74,41  LineMapIndex:107
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_5 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_5.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_5.setParent(_jspx_th_html_option_0);
                                                                                              _jspx_th_bean_message_5.setKey("label.tat_ca");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_5);
                                                                                              int _jspx_eval_bean_message_5 = _jspx_th_bean_message_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 74,6-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 74,41  LineMapIndex:108
                                                                                              if (_jspx_th_bean_message_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(73,41);to=(74,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 75,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 75,19  LineMapIndex:109
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(74,19);to=(75,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 76,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 76,28  LineMapIndex:110
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_1 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_1.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_option_1.setValue("0");
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(75,28);to=(76,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 77,6-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 77,44  LineMapIndex:111
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_6 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_6.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_6.setParent(_jspx_th_html_option_1);
                                                                                              _jspx_th_bean_message_6.setKey("label.thanh_tra");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_6);
                                                                                              int _jspx_eval_bean_message_6 = _jspx_th_bean_message_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 77,6-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 77,44  LineMapIndex:112
                                                                                              if (_jspx_th_bean_message_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(76,44);to=(77,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 78,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 78,19  LineMapIndex:113
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(77,19);to=(78,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 79,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 79,28  LineMapIndex:114
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_2 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_2.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_option_2.setValue("1");
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(78,28);to=(79,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 80,6-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 80,43  LineMapIndex:115
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_7 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_7.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_7.setParent(_jspx_th_html_option_2);
                                                                                              _jspx_th_bean_message_7.setKey("label.kiem_tra");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_7);
                                                                                              int _jspx_eval_bean_message_7 = _jspx_th_bean_message_7.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 80,6-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 80,43  LineMapIndex:116
                                                                                              if (_jspx_th_bean_message_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(79,43);to=(80,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 81,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 81,19  LineMapIndex:117
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(80,19);to=(81,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 82,4-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 82,18  LineMapIndex:118
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(81,18);to=(83,21)]
                                                                                              out.write("\r\n\t\t\t</td> -->\r\n\t\t\t<td align=\"right\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 84,21-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 84,54  LineMapIndex:119
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_8 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_8.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_8.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_8.setKey("label.loai");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_8);
                                                                                              int _jspx_eval_bean_message_8 = _jspx_th_bean_message_8.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 84,21-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 84,54  LineMapIndex:120
                                                                                              if (_jspx_th_bean_message_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(83,54);to=(85,20)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\"></td>\r\n\t\t\t<td align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 86,20-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 86,71  LineMapIndex:121
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(85,71);to=(87,4)]
                                                                                              out.write("\r\n\t\t\t\t<!--Dot xuat, dinh ky-->\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 88,4-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 88,29  LineMapIndex:122
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_3 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_3.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_3.setValue("all");
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(87,29);to=(88,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 89,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 89,40  LineMapIndex:123
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_9 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_9.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_9.setParent(_jspx_th_html_option_3);
                                                                                              _jspx_th_bean_message_9.setKey("label.tat_ca");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_9);
                                                                                              int _jspx_eval_bean_message_9 = _jspx_th_bean_message_9.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 89,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 89,40  LineMapIndex:124
                                                                                              if (_jspx_th_bean_message_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(88,40);to=(89,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 90,4-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 90,18  LineMapIndex:125
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(89,18);to=(90,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 91,4-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 91,27  LineMapIndex:126
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_4 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_4.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_4.setValue("0");
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(90,27);to=(91,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 92,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 92,41  LineMapIndex:127
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_10 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_10.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_10.setParent(_jspx_th_html_option_4);
                                                                                              _jspx_th_bean_message_10.setKey("label.dinh_ky");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_10);
                                                                                              int _jspx_eval_bean_message_10 = _jspx_th_bean_message_10.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 92,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 92,41  LineMapIndex:128
                                                                                              if (_jspx_th_bean_message_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(91,41);to=(92,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 93,4-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 93,18  LineMapIndex:129
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(92,18);to=(93,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 94,4-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 94,27  LineMapIndex:130
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_5 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_5.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_5.setValue("1");
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(93,27);to=(94,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 95,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 95,42  LineMapIndex:131
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_11 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_11.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_11.setParent(_jspx_th_html_option_5);
                                                                                              _jspx_th_bean_message_11.setKey("label.dot_xuat");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_11);
                                                                                              int _jspx_eval_bean_message_11 = _jspx_th_bean_message_11.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 95,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 95,42  LineMapIndex:132
                                                                                              if (_jspx_th_bean_message_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(94,42);to=(95,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 96,4-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 96,18  LineMapIndex:133
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(95,18);to=(96,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 97,3-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 97,17  LineMapIndex:134
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(96,17);to=(99,20)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\">Tr&#7841;ng th&#225;i</td>\r\n\t\t\t<td align=\"right\"></td>\r\n\t\t\t<td align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 100,20-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 100,92  LineMapIndex:135
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_2 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_2.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_select_2.setProperty("trangThaiPhanCongTruongDoan");
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(99,92);to=(100,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 101,4-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 101,26  LineMapIndex:136
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_6 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_6.setParent(_jspx_th_html_select_2);
                                                                                              _jspx_th_html_option_6.setValue("");
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(100,26);to=(100,44)]
                                                                                              out.write("T&#7845;t c&#7843;");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 101,44-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 101,58  LineMapIndex:137
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(100,58);to=(101,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 102,4-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 102,27  LineMapIndex:138
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_7 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_7.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_7.setParent(_jspx_th_html_select_2);
                                                                                              _jspx_th_html_option_7.setValue("0");
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(101,27);to=(101,89)]
                                                                                              out.write("Ch&#432;a ph&#226;n c&#244;ng tr&#432;&#7903;ng &#273;o&#224;n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 102,89-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 102,103  LineMapIndex:139
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(101,103);to=(102,4)]
                                                                                              out.write("\r\n\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 103,4-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 103,27  LineMapIndex:140
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_8 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_8.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_8.setParent(_jspx_th_html_select_2);
                                                                                              _jspx_th_html_option_8.setValue("1");
                                                                                              _jspxTagObjects.push(_jspx_th_html_option_8);
                                                                                              int _jspx_eval_html_option_8 = _jspx_th_html_option_8.doStartTag();
                                                                                              if (_jspx_eval_html_option_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              try {
                                                                                              if (_jspx_eval_html_option_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                                                                                              out = pageContext.pushBody();
                                                                                              _jspx_th_html_option_8.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                                                                                              _jspx_th_html_option_8.doInitBody();
                                                                                              }
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(102,27);to=(102,92)]
                                                                                              out.write("&#272;&#227; ph&#226;n c&#244;ng tr&#432;&#7903;ng &#273;o&#224;n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 103,92-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 103,106  LineMapIndex:141
                                                                                              } while (_jspx_th_html_option_8.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              } finally {
                                                                                              if (_jspx_eval_html_option_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                                                                                              out = pageContext.popBody();
                                                                                              }
                                                                                              }
                                                                                              if (_jspx_th_html_option_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(102,106);to=(103,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 104,3-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 104,17  LineMapIndex:142
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(103,17);to=(108,32)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"19%\">Tên trưởng đoàn</td>\r\n\t\t\t<td align=\"right\" width=\"1%\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 109,32-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 109,68  LineMapIndex:143
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_7 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_7.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_7.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_7.setProperty("tenTruongDoan");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_7);
                                                                                              int _jspx_eval_html_text_7 = _jspx_th_html_text_7.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 109,32-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 109,80  LineMapIndex:144
                                                                                              if (_jspx_th_html_text_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(108,80);to=(119,20)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"right\" width=\"19%\"></td>\r\n\t\t\t<td align=\"right\" width=\"1%\"></td>\r\n\t\t\t<td align=\"left\" width=\"30%\"></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td align=\"right\"></td>\r\n\t\t\t<td align=\"left\"></td>\r\n\t\t\t<td align=\"left\">");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem.jsp";from=(0,0);to=(0,28)]
                                                                                              out.write("<input type=\"button\" value='");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/tim_kiem.jsp" 1,28-"/ttkt/dung_chung/tim_kiem.jsp" 1,59  LineMapIndex:145
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_12 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_12.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_12.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_12.setKey("tim_kiem");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_12);
                                                                                              int _jspx_eval_bean_message_12 = _jspx_th_bean_message_12.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/tim_kiem.jsp" 1,28-"/ttkt/dung_chung/tim_kiem.jsp" 1,59  LineMapIndex:146
                                                                                              if (_jspx_th_bean_message_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/tim_kiem.jsp";from=(0,59);to=(21,9)]
                                                                                              out.write("' style=\"width: 80; margin: 0\" class=\"button\" onclick=\"search();\" />\r\n<script language=\"javascript\">    \r\n\t$(function(){\r\n    $('input').keydown(function(e){\r\n        if (e.keyCode == 13) {\r\n            search();\r\n            return false;\r\n        }\r\n    });\r\n});\r\n \tfunction search(){\r\n \t\tif(!validateForm()) \r\n \t\t\treturn;\r\n \t\ttry{\r\n \t\t\tselfSearch();\r\n \t\t}catch(err){ \t\t\t\r\n\t \t\tdocument.forms[0].action = document.forms[0].action.split('?')[0];\r\n\t \t\tdocument.forms[0].submit();\t\t\r\n \t\t}\r\n \t\t\r\n \t}\r\n</script>");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(119,70);to=(123,39)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t</fieldset>\r\n\t<Fieldset style=\"margin: 5px\"><legend>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 124,39-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 124,84  LineMapIndex:147
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_13 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_13.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_13.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_13.setKey("label.ket_qua_tim_kiem");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_13);
                                                                                              int _jspx_eval_bean_message_13 = _jspx_th_bean_message_13.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 124,39-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 124,84  LineMapIndex:148
                                                                                              if (_jspx_th_bean_message_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(123,84);to=(126,7)]
                                                                                              out.write(" </legend>\r\n\t<table width=\"100%\" align=\"center\">\r\n\t\t<tr class=\"TdHeaderListOfSearch\">\r\n\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 127,7-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 127,48  LineMapIndex:149
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_14 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_14.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_14.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_14.setKey("label.ma_cuoc_ttkt");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_14);
                                                                                              int _jspx_eval_bean_message_14 = _jspx_th_bean_message_14.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 127,7-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 127,48  LineMapIndex:150
                                                                                              if (_jspx_th_bean_message_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(126,48);to=(127,19)]
                                                                                              out.write("</td>\r\n\t\t\t<td width=\"17%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 128,19-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 128,64  LineMapIndex:151
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_15 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_15.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_15.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_15.setKey("label.don_vi_duoc_ttkt");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_15);
                                                                                              int _jspx_eval_bean_message_15 = _jspx_th_bean_message_15.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 128,19-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 128,64  LineMapIndex:152
                                                                                              if (_jspx_th_bean_message_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(127,64);to=(128,7)]
                                                                                              out.write("</td>\r\n\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 129,7-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 129,43  LineMapIndex:153
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_16 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_16.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_16.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_16.setKey("label.thoi_ky");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_16);
                                                                                              int _jspx_eval_bean_message_16 = _jspx_th_bean_message_16.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 129,7-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 129,43  LineMapIndex:154
                                                                                              if (_jspx_th_bean_message_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(128,43);to=(131,7)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"center\">Th&#x1EDD;i gian d&#x1EF1; ki&#x1EBF;n</td>\r\n\t\t\t<td>T&#x1EEB; ng&#xE0;y - &#x111;&#x1EBF;n ng&#xE0;y</td>\r\n\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 132,7-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 132,40  LineMapIndex:155
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_17 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_17.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_17.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_message_17.setKey("label.loai");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_17);
                                                                                              int _jspx_eval_bean_message_17 = _jspx_th_bean_message_17.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 132,7-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 132,40  LineMapIndex:156
                                                                                              if (_jspx_th_bean_message_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(131,40);to=(134,2)]
                                                                                              out.write("</td>\r\n\t\t\t<td align=\"center\" width=\"17%\">Tr&#432;&#7903;ng &#273;o&#224;n</td>\r\n\t\t</tr>\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 135,2-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 135,66  LineMapIndex:157
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_1 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_1.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_1.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_logic_present_1.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_logic_present_1.setProperty("dsCuocTtkt");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_1);
                                                                                              int _jspx_eval_logic_present_1 = _jspx_th_logic_present_1.doStartTag();
                                                                                              if (_jspx_eval_logic_present_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(134,66);to=(135,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 136,3-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 136,99  LineMapIndex:158
                                                                                              /* ------  logic:iterate ------ */
                                                                                              org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_0 = new org.apache.struts.taglib.logic.IterateTag();
                                                                                              _jspx_th_logic_iterate_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_iterate_0.setParent(_jspx_th_logic_present_1);
                                                                                              _jspx_th_logic_iterate_0.setId("dsCuocTtkt");
                                                                                              _jspx_th_logic_iterate_0.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_logic_iterate_0.setProperty("dsCuocTtkt");
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
                                                                                              java.lang.Object dsCuocTtkt = null;
                                                                                              dsCuocTtkt = (java.lang.Object) pageContext.findAttribute("dsCuocTtkt");
                                                                                              java.lang.Integer index = null;
                                                                                              index = (java.lang.Integer) pageContext.findAttribute("index");
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(135,99);to=(136,18)]
                                                                                              out.write("\r\n\t\t\t\t<tr class='row");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 137,21-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 137,46  LineMapIndex:159
                                                                                              out.print((index.intValue() % 2)+1 );
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(136,48);to=(137,29)]
                                                                                              out.write("'>\r\n\t\t\t\t\t<td><!--Id cuoc ttkt--> ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 138,29-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 138,120  LineMapIndex:160
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_0.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_hidden_0.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_html_hidden_0.setProperty("dsCuocTtkt[" + index + "].col0");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_0);
                                                                                              int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 138,29-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 138,120  LineMapIndex:161
                                                                                              if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(137,120);to=(137,190)]
                                                                                              out.write(" <A href=\"#\" onclick=\"openWindow('cuoc_ttkt.do?method=view&cuocTtktId=");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 138,193-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 138,253  LineMapIndex:162
                                                                                              out.print(((cmc.com.ktnb.util.DetailInformation) dsCuocTtkt).getCol0());
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(137,255);to=(137,260)]
                                                                                              out.write("')\"> ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 138,260-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 139,84  LineMapIndex:163
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_0.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_0.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_0.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_bean_write_0.setProperty("dsCuocTtkt[" + index + "].col1");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_0);
                                                                                              int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 138,260-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 139,84  LineMapIndex:165
                                                                                              if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(138,84);to=(138,85)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 139,85-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 139,176  LineMapIndex:167
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_1 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_1.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_hidden_1.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_html_hidden_1.setProperty("dsCuocTtkt[" + index + "].col0");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_1);
                                                                                              int _jspx_eval_html_hidden_1 = _jspx_th_html_hidden_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 139,85-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 139,176  LineMapIndex:168
                                                                                              if (_jspx_th_html_hidden_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(138,176);to=(139,30)]
                                                                                              out.write(" </A></td>\r\n\t\t\t\t\t<td><!--Ten don vi bi--> ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 140,30-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 140,120  LineMapIndex:169
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_1 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_1.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_1.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_1.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_bean_write_1.setProperty("dsCuocTtkt[" + index + "].col5");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_1);
                                                                                              int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 140,30-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 140,120  LineMapIndex:170
                                                                                              if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(139,120);to=(141,23)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t<td><!--Nien do--> <script language=\"javascript\">\r\n\t\t\t\t\t\t\tdocument.write('");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 142,23-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 142,112  LineMapIndex:171
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_2 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_2.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_2.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_2.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_bean_write_2.setProperty("dsCuocTtkt[" + index + "].col6");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_2);
                                                                                              int _jspx_eval_bean_write_2 = _jspx_th_bean_write_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 142,23-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 142,112  LineMapIndex:172
                                                                                              if (_jspx_th_bean_write_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(141,112);to=(141,139)]
                                                                                              out.write("'.substring(0,10) + '-' + '");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 142,139-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 142,228  LineMapIndex:173
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_3 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_3.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_3.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_3.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_bean_write_3.setProperty("dsCuocTtkt[" + index + "].col7");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_3);
                                                                                              int _jspx_eval_bean_write_3 = _jspx_th_bean_write_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 142,139-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 142,228  LineMapIndex:174
                                                                                              if (_jspx_th_bean_write_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(141,228);to=(143,49)]
                                                                                              out.write("'.substring(0,10));\r\n\t\t\t\t\t\t</script></td>\r\n\t\t\t\t\t<td align=\"center\"><!--Thoi gian du kien--> ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 144,49-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 144,140  LineMapIndex:175
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_4 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_4.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_4.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_4.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_bean_write_4.setProperty("dsCuocTtkt[" + index + "].col16");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_4);
                                                                                              int _jspx_eval_bean_write_4 = _jspx_th_bean_write_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 144,49-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 144,140  LineMapIndex:176
                                                                                              if (_jspx_th_bean_write_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(143,140);to=(144,34)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t<td><!--Thoi gian du kien--> ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 145,34-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 145,124  LineMapIndex:177
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_5 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_5.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_5.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_5.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_bean_write_5.setProperty("dsCuocTtkt[" + index + "].col8");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_5);
                                                                                              int _jspx_eval_bean_write_5 = _jspx_th_bean_write_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 145,34-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 145,124  LineMapIndex:178
                                                                                              if (_jspx_th_bean_write_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(144,124);to=(145,9)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t<td>");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 146,9-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 146,109  LineMapIndex:179
                                                                                              /* ------  logic:equal ------ */
                                                                                              org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_1 = new org.apache.struts.taglib.logic.EqualTag();
                                                                                              _jspx_th_logic_equal_1.setPageContext(pageContext);
                                                                                              _jspx_th_logic_equal_1.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_logic_equal_1.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_logic_equal_1.setProperty("dsCuocTtkt[" + index + "].col10");
                                                                                              _jspx_th_logic_equal_1.setValue("0");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_equal_1);
                                                                                              int _jspx_eval_logic_equal_1 = _jspx_th_logic_equal_1.doStartTag();
                                                                                              if (_jspx_eval_logic_equal_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(145,109);to=(146,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 147,6-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 147,42  LineMapIndex:180
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_18 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_18.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_18.setParent(_jspx_th_logic_equal_1);
                                                                                              _jspx_th_bean_message_18.setKey("label.dinh_ky");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_18);
                                                                                              int _jspx_eval_bean_message_18 = _jspx_th_bean_message_18.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 147,6-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 147,42  LineMapIndex:181
                                                                                              if (_jspx_th_bean_message_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(146,42);to=(147,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 148,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 148,19  LineMapIndex:182
                                                                                              } while (_jspx_th_logic_equal_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_equal_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(147,19);to=(147,20)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 148,20-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 148,120  LineMapIndex:183
                                                                                              /* ------  logic:equal ------ */
                                                                                              org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_2 = new org.apache.struts.taglib.logic.EqualTag();
                                                                                              _jspx_th_logic_equal_2.setPageContext(pageContext);
                                                                                              _jspx_th_logic_equal_2.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_logic_equal_2.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_logic_equal_2.setProperty("dsCuocTtkt[" + index + "].col10");
                                                                                              _jspx_th_logic_equal_2.setValue("1");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_equal_2);
                                                                                              int _jspx_eval_logic_equal_2 = _jspx_th_logic_equal_2.doStartTag();
                                                                                              if (_jspx_eval_logic_equal_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(147,120);to=(148,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 149,6-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 149,43  LineMapIndex:184
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_19 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_19.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_19.setParent(_jspx_th_logic_equal_2);
                                                                                              _jspx_th_bean_message_19.setKey("label.dot_xuat");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_19);
                                                                                              int _jspx_eval_bean_message_19 = _jspx_th_bean_message_19.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 149,6-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 149,43  LineMapIndex:185
                                                                                              if (_jspx_th_bean_message_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(148,43);to=(149,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 150,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 150,19  LineMapIndex:186
                                                                                              } while (_jspx_th_logic_equal_2.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_equal_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(149,19);to=(150,44)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t<td align=\"left\"><!--Id truong doan--> ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 151,44-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 151,136  LineMapIndex:187
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_2 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_2.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_hidden_2.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_html_hidden_2.setProperty("dsCuocTtkt[" + index + "].col11");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_2);
                                                                                              int _jspx_eval_html_hidden_2 = _jspx_th_html_hidden_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 151,44-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 151,136  LineMapIndex:188
                                                                                              if (_jspx_th_html_hidden_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(150,136);to=(150,160)]
                                                                                              out.write(" <!--Ten truong doan--> ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 151,160-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 152,83  LineMapIndex:189
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_8 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_8.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_8.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_text_8.setStyle("width: 75%");
                                                                                              _jspx_th_html_text_8.setOnchange("chonTruongDoan(" + index + ", 'dsCuocTtkt')");
                                                                                              _jspx_th_html_text_8.setStyleClass("text");
                                                                                              _jspx_th_html_text_8.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_html_text_8.setProperty("dsCuocTtkt[" + index + "].col12");
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(151,83);to=(152,5)]
                                                                                              out.write("\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 153,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 153,17  LineMapIndex:191
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(152,17);to=(152,88)]
                                                                                              out.write(" <INPUT type=\"button\" value=\"...\" onclick=\"document.getElementsByName('");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 153,91-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 153,124  LineMapIndex:192
                                                                                              out.print("dsCuocTtkt[" + index + "].col11");
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(152,126);to=(152,172)]
                                                                                              out.write("')[0].value = ''; document.getElementsByName('");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 153,175-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 153,208  LineMapIndex:193
                                                                                              out.print("dsCuocTtkt[" + index + "].col12");
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(152,210);to=(152,244)]
                                                                                              out.write("')[0].value = ''; chonTruongDoan('");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 153,247-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 153,252  LineMapIndex:194
                                                                                              out.print(index);
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(152,254);to=(153,5)]
                                                                                              out.write("', 'dsCuocTtkt')\"> <!--Id danh sach thanh vien doan-->\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 154,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 154,97  LineMapIndex:195
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_3 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_3.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_hidden_3.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_html_hidden_3.setProperty("dsCuocTtkt[" + index + "].col13");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_3);
                                                                                              int _jspx_eval_html_hidden_3 = _jspx_th_html_hidden_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 154,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 154,97  LineMapIndex:196
                                                                                              if (_jspx_th_html_hidden_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(153,97);to=(153,98)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 154,98-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 154,190  LineMapIndex:197
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_4 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_4.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_html_hidden_4.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_html_hidden_4.setProperty("dsCuocTtkt[" + index + "].col15");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_4);
                                                                                              int _jspx_eval_html_hidden_4 = _jspx_th_html_hidden_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 154,98-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 154,190  LineMapIndex:198
                                                                                              if (_jspx_th_html_hidden_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(153,190);to=(155,3)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 156,3-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 156,19  LineMapIndex:199
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
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(155,19);to=(156,2)]
                                                                                              out.write("\r\n\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 157,2-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 157,18  LineMapIndex:200
                                                                                              } while (_jspx_th_logic_present_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(156,18);to=(158,34)]
                                                                                              out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"7\" align=\"center\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 159,34-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 159,114  LineMapIndex:201
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_6 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_6.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_6.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_bean_write_6.setName("tableKetQuaTimKiem");
                                                                                              _jspx_th_bean_write_6.setProperty("navigationBar");
                                                                                              _jspx_th_bean_write_6.setFilter(false);
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_6);
                                                                                              int _jspx_eval_bean_write_6 = _jspx_th_bean_write_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 159,34-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 159,114  LineMapIndex:202
                                                                                              if (_jspx_th_bean_write_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(158,114);to=(165,3)]
                                                                                              out.write("</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t</fieldset>\r\n\t<BR>\r\n\t<TABLE width=\"30%\" align=\"center\">\r\n\t\t<tr align=\"center\">\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 166,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 166,46  LineMapIndex:203
                                                                                              if ("ke_hoach_nam.do".equals(nghiepVu)) {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(165,48);to=(172,3)]
                                                                                              out.write("\r\n\t\t\t<td width=\"20%\" align=\"center\"><INPUT type=\"button\" class=\"button\" value=\"Th&#xEA;m m&#x1EDB;i\" onclick=\"addNew()\" /></td>\r\n\t\t\t<td width=\"20%\" align=\"center\"><INPUT type=\"button\" class=\"button\" value=\"Copy\" onclick=\"copy()\"></td>\r\n\t\t\t<td width=\"20%\" align=\"center\"><INPUT type=\"button\" class=\"button\" value=\"S&#x1EED;a\" onclick=\"sua()\"></td>\r\n\t\t\t<td width=\"20%\" align=\"center\"><INPUT type=\"button\" class=\"button\" value=\"X&#xF3;a\" onclick=\"xoa()\"></td>\r\n\t\t\t<td width=\"20%\" align=\"center\"><INPUT type=\"button\" class=\"button1\" value=\"In\" onclick=\"inKeHoachNam()\"></td>\r\n\t\t\t<td width=\"20%\" align=\"center\"><INPUT type=\"button\" class=\"button\" value=\"&#x110;&#xF3;ng\" onclick=\"close123();\"></td>\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 173,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 173,50  LineMapIndex:204
                                                                                              } else if ("pcTruongDoan".equals(nghiepVu)) {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(172,52);to=(173,22)]
                                                                                              out.write("\r\n\t\t\t<td align=\"center\">");

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
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 6,1-"/ttkt/dung_chung/action_bar.jsp" 6,35  LineMapIndex:205
                                                                                              /* ------  logic:notPresent ------ */
                                                                                              org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_0 = new org.apache.struts.taglib.logic.NotPresentTag();
                                                                                              _jspx_th_logic_notPresent_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_notPresent_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_logic_notPresent_0.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_notPresent_0);
                                                                                              int _jspx_eval_logic_notPresent_0 = _jspx_th_logic_notPresent_0.doStartTag();
                                                                                              if (_jspx_eval_logic_notPresent_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(5,35);to=(7,109)]
                                                                                              out.write("\r\n\t\t<tr>\r\n\t\t\t<td width=\"50%\" align=\"right\"><input type=\"button\" style=\"width: 60\" class=\"button\" name=\"btnSave\" value='");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 8,109-"/ttkt/dung_chung/action_bar.jsp" 8,135  LineMapIndex:206
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_20 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_20.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_20.setParent(_jspx_th_logic_notPresent_0);
                                                                                              _jspx_th_bean_message_20.setKey("luu");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_20);
                                                                                              int _jspx_eval_bean_message_20 = _jspx_th_bean_message_20.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 8,109-"/ttkt/dung_chung/action_bar.jsp" 8,135  LineMapIndex:207
                                                                                              if (_jspx_th_bean_message_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(7,135);to=(8,113)]
                                                                                              out.write("' onclick=\"save();\"></td>\r\n\t\t\t<td width=\"50%\" align=\"left\"><input type=\"button\" name=\"closetheForm\" style=\"width: 60\" class=\"button\" value='");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 9,113-"/ttkt/dung_chung/action_bar.jsp" 9,139  LineMapIndex:208
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_21 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_21.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_21.setParent(_jspx_th_logic_notPresent_0);
                                                                                              _jspx_th_bean_message_21.setKey("dong");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_21);
                                                                                              int _jspx_eval_bean_message_21 = _jspx_th_bean_message_21.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 9,113-"/ttkt/dung_chung/action_bar.jsp" 9,139  LineMapIndex:209
                                                                                              if (_jspx_th_bean_message_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(8,139);to=(10,1)]
                                                                                              out.write("' onclick=\"closeContainWindow();\"></td>\r\n\t\t</tr>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 11,1-"/ttkt/dung_chung/action_bar.jsp" 11,20  LineMapIndex:210
                                                                                              } while (_jspx_th_logic_notPresent_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_notPresent_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(10,20);to=(11,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 12,1-"/ttkt/dung_chung/action_bar.jsp" 12,32  LineMapIndex:211
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_2 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_2.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_2.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_logic_present_2.setName("readOnly");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_2);
                                                                                              int _jspx_eval_logic_present_2 = _jspx_th_logic_present_2.doStartTag();
                                                                                              if (_jspx_eval_logic_present_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(11,32);to=(12,110)]
                                                                                              out.write("\r\n\t\t<td width=\"100%\" align=\"center\"><input type=\"button\" style=\"width: 60\" class=\"button\" name=\"btnSave\" value='");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 13,110-"/ttkt/dung_chung/action_bar.jsp" 13,136  LineMapIndex:212
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_22 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_22.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_22.setParent(_jspx_th_logic_present_2);
                                                                                              _jspx_th_bean_message_22.setKey("luu");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_22);
                                                                                              int _jspx_eval_bean_message_22 = _jspx_th_bean_message_22.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 13,110-"/ttkt/dung_chung/action_bar.jsp" 13,136  LineMapIndex:213
                                                                                              if (_jspx_th_bean_message_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(12,136);to=(12,258)]
                                                                                              out.write("' onclick=\"save();\" disabled=\"disabled\"> <input type=\"button\" name=\"closetheForm\" style=\"width: 60\" class=\"button\" value='");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 13,258-"/ttkt/dung_chung/action_bar.jsp" 13,284  LineMapIndex:214
                                                                                              /* ------  bean:message ------ */
                                                                                              org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_23 = new org.apache.struts.taglib.bean.MessageTag();
                                                                                              _jspx_th_bean_message_23.setPageContext(pageContext);
                                                                                              _jspx_th_bean_message_23.setParent(_jspx_th_logic_present_2);
                                                                                              _jspx_th_bean_message_23.setKey("dong");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_message_23);
                                                                                              int _jspx_eval_bean_message_23 = _jspx_th_bean_message_23.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 13,258-"/ttkt/dung_chung/action_bar.jsp" 13,284  LineMapIndex:215
                                                                                              if (_jspx_th_bean_message_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(12,284);to=(14,1)]
                                                                                              out.write("'\r\n\t\t\tonclick=\"closeContainWindow();\"></td>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 15,1-"/ttkt/dung_chung/action_bar.jsp" 15,17  LineMapIndex:216
                                                                                              } while (_jspx_th_logic_present_2.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(14,17);to=(45,0)]
                                                                                              out.write("\r\n</TABLE>\r\n<script language=\"javascript\">\t\t\r\n\tvar activeTab = null;\r\n \tfunction save(){\r\n \t\ttry{\r\n \t\t\tsaveActiveTab(); \r\n \t\t}catch(err){\r\n \t\t\t//Code kieu gi da Error con Submit ha NTDUNG???\r\n \t\t\tif(!validateForm())\r\n\t \t\t\treturn false;\r\n\t \t\taction = document.forms[0].action;\r\n\t \t\taction = action.split('?')[0];  \t\t\r\n\t \t\tdocument.forms[0].action += \"?method=save\";\r\n\t \t\tdocument.forms[0].submit();\r\n\t \t\t/*dhphuc sua lai => alert loi de biet, khong submit*/\t \t\t\r\n\t        //var text = \"Error description: \" + err.message + \"\\n\\n\";        \r\n\t        //alert(text);\r\n \t\t}\r\n \t} \t\r\n \tfunction closeContainWindow(){ \r\n \t\ttry{\r\n \t\t\t// Cac form tu cai dat phuong thuc dong\r\n \t\t\tselfClose();\r\n \t\t}catch(err){  \t\t\t\r\n \t\t\t// Neu khong tu dong se chuyen ve trang chu\r\n \t\t\twindow.location = 'ttkt_index.do';\r\n \t\t} \t\t\r\n \t}\r\n</script>\r\n</BODY>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/action_bar.jsp" 46,2-"/ttkt/dung_chung/action_bar.jsp" 46,49  LineMapIndex:217
                                                                                              if (request.getAttribute("readOnly") != null) {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(45,51);to=(70,0)]
                                                                                              out.write("\r\n<script language=\"javascript\"> \r\n// Input fields\r\nvar allInputFields = document.getElementsByTagName('input') \r\n\tfor(i = 0; i< allInputFields.length; i++){\t\t \r\n\t\tif(allInputFields[i].type.toLowerCase()=='button'&&allInputFields[i].className.toLowerCase()!=\"button1\"){ // Button\r\n\t\t\tif(allInputFields[i].name != 'closetheForm')\r\n\t\t\t\tallInputFields[i].disabled = true; \r\n\t\t\t\t\r\n\t\t}else if(allInputFields[i].type.toLowerCase()=='text'){ // Text\r\n\t\t\tallInputFields[i].readOnly = true;\r\n\t\t}else if(allInputFields[i].type.toLowerCase()=='radio'){ // Radio\r\n\t\t\tallInputFields[i].disabled = true;\r\n\t\t}else if(allInputFields[i].type.toLowerCase()=='checkbox'){ // Checkbox\r\n\t\t\tallInputFields[i].disabled = true;\r\n\t\t}\r\n\t}\r\nallSelect = document.getElementsByTagName('select'); // Select\r\nfor(i = 0; i< allSelect.length; i++)\r\n\tallSelect[i].disabled = true;\r\n\t\r\nallTextArea = document.getElementsByTagName('TEXTAREA')// Text area\r\nfor(i = 0; i< allTextArea.length; i++)\r\n\tallTextArea[i].readOnly = true;\r\n</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/dung_chung/action_bar.jsp" 71,2-"/ttkt/dung_chung/action_bar.jsp" 71,3  LineMapIndex:218
                                                                                              }
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(70,5);to=(71,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 72,0-"/ttkt/dung_chung/action_bar.jsp" 72,37  LineMapIndex:219
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_3 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_3.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_3.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_logic_present_3.setName("strDateHoliday");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_3);
                                                                                              int _jspx_eval_logic_present_3 = _jspx_th_logic_present_3.doStartTag();
                                                                                              if (_jspx_eval_logic_present_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(71,37);to=(73,19)]
                                                                                              out.write("\r\n\t<script language=\"javascript\">\r\n\t\tstrHolidayDay = '");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 74,22-"/ttkt/dung_chung/action_bar.jsp" 74,60  LineMapIndex:220
                                                                                              out.print(request.getAttribute("strDateHoliday"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(73,62);to=(75,0)]
                                                                                              out.write("';\t\r\n\t</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 76,0-"/ttkt/dung_chung/action_bar.jsp" 76,16  LineMapIndex:221
                                                                                              } while (_jspx_th_logic_present_3.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(75,16);to=(76,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/action_bar.jsp" 77,0-"/ttkt/dung_chung/action_bar.jsp" 77,33  LineMapIndex:222
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_4 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_4.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_4.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_logic_present_4.setName("saveStatus");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_4);
                                                                                              int _jspx_eval_logic_present_4 = _jspx_th_logic_present_4.doStartTag();
                                                                                              if (_jspx_eval_logic_present_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(76,33);to=(88,0)]
                                                                                              out.write("\r\n\t<script language=\"javascript\">\r\n\t\talert('L\\u01B0u th\\u00E0nh c\\u00F4ng!');\r\n\t\ttry{\r\n\t\t\txuLySauSaveThanhCong(); \r\n\t\t}catch(err){\r\n\t\t\t\r\n\t\t}\r\n\t\t// Sau khi save thanh cong chac chan se dong form.\r\n\t\tselfClose();\r\n\t\t\r\n\t</script>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/dung_chung/action_bar.jsp" 89,0-"/ttkt/dung_chung/action_bar.jsp" 89,16  LineMapIndex:223
                                                                                              } while (_jspx_th_logic_present_4.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/dung_chung/action_bar.jsp";from=(88,16);to=(89,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(173,74);to=(173,75)]
                                                                                              out.write(" ");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 174,77-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 174,83  LineMapIndex:224
                                                                                              }else{
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(173,85);to=(176,3)]
                                                                                              out.write("\r\n\t\t\t\r\n\t\t\t<td width=\"20%\" align=\"center\"><INPUT type=\"button\" class=\"button\" value=\"&#x110;&#xF3;ng\" onclick=\"close123();\">\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 177,5-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 177,6  LineMapIndex:225
                                                                                              }
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(176,8);to=(180,1)]
                                                                                              out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</TABLE>\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 181,1-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 181,63  LineMapIndex:226
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_5 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_5.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_hidden_5.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_html_hidden_5.setProperty("nghiepVu");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_5);
                                                                                              int _jspx_eval_html_hidden_5 = _jspx_th_html_hidden_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 181,1-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 181,63  LineMapIndex:227
                                                                                              if (_jspx_th_html_hidden_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(180,63);to=(181,1)]
                                                                                              out.write("\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 182,1-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 182,68  LineMapIndex:228
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_6 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_6.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_hidden_6.setName("TimKiemCuocTtktForm");
                                                                                              _jspx_th_html_hidden_6.setProperty("maCqtTienHanh");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_6);
                                                                                              int _jspx_eval_html_hidden_6 = _jspx_th_html_hidden_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 182,1-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 182,68  LineMapIndex:229
                                                                                              if (_jspx_th_html_hidden_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(181,68);to=(182,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 183,0-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 183,12  LineMapIndex:230
                                                                                              } while (_jspx_th_html_form_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_html_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(182,12);to=(183,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(0,31);to=(22,4)]
                                                                                              out.write("\r\n<script language=\"Javascript\">\r\n$(function() \r\n{\r\n  $(document).bind('keydown','esc',function(evt){onButton('exit');return false;});\r\n  $(document).bind('keydown','home',function(evt){window.location='index.do';return false;});\r\n  if($('#exit').length>0)\r\n  {\r\n   $('#exit').button({icons:{primary:'ui-icon-close'}}).click(function(){onButton('exit');return false;});\r\n  }\r\n  if($('#search').length>0)\r\n  {\r\n    $('#search').button({icons:{primary:'ui-icon-search'}}).click(function(){onButton('search');return false;});\r\n    $(document).bind('keydown','Shift+s',function(evt){onButton('search');return false;});\r\n  }\r\n  if($('table.data_table').length>0)\r\n  {\r\n    $('table.data_table tbody tr').each(function(index) {$(this).addClass(arrClassName[index%3]);});\r\n    $(\"table.data_table tbody\").delegate(\"tr\", \"hover\", function(){$(this).toggleClass(\"highlight\");});\r\n  }\r\n  if($('#msgdiv').length>0)\r\n  {\r\n    ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/bottom.jsp" 23,4-"/bottom.jsp" 23,30  LineMapIndex:231
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_5 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_5.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_5.setParent(null);
                                                                                              _jspx_th_logic_present_5.setName("msg");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_5);
                                                                                              int _jspx_eval_logic_present_5 = _jspx_th_logic_present_5.doStartTag();
                                                                                              if (_jspx_eval_logic_present_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(22,30);to=(24,4)]
                                                                                              out.write("\r\n     $('#msgdiv').effect('pulsate',{times:3});\r\n    ");

                                                                                              // end
                                                                                              // ##DEBUG## "/bottom.jsp" 25,4-"/bottom.jsp" 25,20  LineMapIndex:232
                                                                                              } while (_jspx_th_logic_present_5.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(24,20);to=(32,92)]
                                                                                              out.write("\r\n  } \r\n});\r\n</script>\r\n</div>\r\n<div id=\"bottom\">\r\n<table width=\"100%\" border=\"0\" bordercolor=\"#AEC1F1\">\r\n\t<tr>\r\n\t\t<td align=\"center\" width=\"20%\" style=\"color: blue; font-size: 8pt\">KTNB Phiên bản <strong>");

                                                                                              // end
                                                                                              // ##DEBUG## "/bottom.jsp" 33,95-"/bottom.jsp" 33,113  LineMapIndex:233
                                                                                              out.print(ac.getVersionApp());
                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(32,115);to=(60,9)]
                                                                                              out.write("</strong> <br>\r\n\t\t<script language=JavaScript>\r\n                                                dayname = new Array(\"Chủ nhật\", \"Thứ Hai\", \"Thứ Ba\", \"Thứ Tư\", \"Thứ Năm\", \"Thứ Sáu\", \"Thứ Bẩy\");\r\n                                                monthname = new Array(\"01\", \"02\", \"03\", \"04\", \"05\", \"06\", \"07\", \"08\", \"09\", \"10\", \"11\", \"12\");\r\n                                                now = new Date();\r\n                                                daynum = now.getDay();\r\n                                                day = dayname[daynum];\r\n                                                date = now.getDate();\r\n                                                monthnum = now.getMonth();\r\n                                                month = monthname[monthnum];\r\n                                                document.write(\"\"+day+\", Ngày \"+date+\"/\"+month+\"/\"+now.getYear()+\"\");\r\n          </script></td>\r\n\t\t<td align=\"center\" width=\"70%\"><font style=\"color: blue; font-size: 8pt\"> <b>TỔNG CỤC THUẾ</b> <BR>\r\n\t\t<strong>Địa chỉ:</strong> Số 123 Lò Đúc, Hà Nội &nbsp; &nbsp;<strong>Điện thoại:</strong> (04) 9.724204 - 9.724209 <strong>Fax:</strong> (04) 9.712286 <br>\r\n\t\t<strong>Website:</strong> <a href=\"http://www.gdt.gov.vn\" target=\"_blank\">http://www.gdt.gov.vn</a> </font></td>\r\n\t</tr>\r\n</table>\r\n</div>\r\n</body>\r\n</html>\r\n<script language=\"Javascript\">\r\n// style js ui\r\n//$(function(){\r\n//\t$.each($('[type=\"button\"]'),function(index,value){\r\n//\t\t$(value).button();\r\n//\t\t$(value).css(\"font-size\",\"11\");\r\n//\t})\r\n//})\r\n</script>");

                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(183,32);to=(186,14)]
                                                                                              out.write("\r\n<script language=\"javascript\">           \r\n$(function(){\r\n\tvar state = '");

                                                                                              // end
                                                                                              // ##DEBUG## "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 187,17-"/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp" 187,48  LineMapIndex:234
                                                                                              out.print( request.getAttribute("statte"));
                                                                                              // end
                                                                                              // HTML // begin [file="/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp";from=(186,50);to=(281,9)]
                                                                                              out.write("';\r\n\tif(state==\"success\"){\r\n\t\talert(\"Lưu thành công\");\r\n\t}\r\n\tif(state==\"fail\"){\r\n\t\talert(\"Lỗi khi lưu!\");\r\n\t}\r\n})\r\nfunction close123(){\r\n \t\ttry{\r\n \t\t\tselfClose();\r\n \t\t}catch(err){  \t\t\t\r\n \t\t\twindow.location = 'ttkt_index.do';\r\n \t\t} \t\t\r\n \t}\r\n\r\nvar returnId;\r\nvar returnName;\r\nvar returnChucVuCongTac;\r\nfunction chonTruongDoan(index, gridName){\t\r\n\treturnId = document.getElementsByName(gridName + '[' + index + '].col11')[0];\r\n\treturnName = document.getElementsByName(gridName + '[' + index + '].col12')[0];\r\n\treturnChucVuCongTac = document.getElementsByName(gridName + '[' + index + '].col15')[0];\t\r\n\tshowLovNhanVien(maCqt, returnName, \"true\" );//Show cac can bo la NSD\t\r\n}\r\nfunction setThongTinNhanVienFromLov(ma, ten, chucVu, tenPhong, tenCqt){\r\n\t\r\n\treturnId.value = ma;\r\n\treturnName.value = ten;\r\n\treturnChucVuCongTac.value = chucVu;\r\n}\r\n\r\n\r\nfunction getTruongDoan(ma, ten){\r\n\treturnId.value = ma;\r\n\treturnName.value = ten;\r\n}\r\nfunction getThongTinTruongDoan(id, name){\r\n\tdocument.getElementsByName(returnId)[0].value = id;\r\n\tdocument.getElementsByName(returnName)[0].value = name;\r\n}\r\nfunction inKeHoachNam(){\r\n}\r\nfunction getSelectedCuocTtktId(){\r\n\tallRadio = document.getElementsByName('cuocTtktFocus');\r\n\tfor(var i = 0; i< allRadio.length; i++){\r\n\t\tif(allRadio[i].checked)\r\n\t\t\treturn allRadio[i].value;\r\n\t}\r\n\treturn '';\r\n}\r\nvar cuocTtktId;\r\nfunction validateForm(){\r\n\tif(!compareDate(document.getElementsByName('tu_ngay')[0], document.getElementsByName('den_ngay')[0]))\r\n\t\treturn false;\r\n\tif(!compareDate(document.getElementsByName('thoiGianDuKienTuNgay')[0], document.getElementsByName('thoiGianDuKienDenNgay')[0]))\r\n\t\treturn false;\r\n\treturn true;\r\n}\r\nfunction addNew(){\r\n\twindow.location = 'cuoc_ttkt.do?method=add'; \r\n}\r\nfunction copy(){\r\n\tcuocTtktId = getSelectedCuocTtktId();\r\n\tif(cuocTtktId == null || cuocTtktId == '' ){\r\n\t\talert('Ch\\u01B0a ch\\u1ECDn b\\u1EA3n ghi n\\u00E0o!');\r\n\t\treturn;\r\n\t}\r\n\twindow.location = 'cuoc_ttkt.do?method=copy&cuocTtktId='+ cuocTtktId;    \r\n}\t \r\n\r\nfunction sua(){ \r\n\tcuocTtktId = getSelectedCuocTtktId();\r\n\tif(cuocTtktId == null || cuocTtktId == '' ){\r\n\t\talert('Ch\\u01B0a ch\\u1ECDn b\\u1EA3n ghi n\\u00E0o!');\r\n\t\treturn;\r\n\t}\r\n\twindow.location = 'cuoc_ttkt.do?method=edit&cuocTtktId='+ cuocTtktId;\r\n}\r\nfunction viewThisItem(control){\r\n\t\r\n\tcuocTtktId = control.value;\r\n\tdocument.forms[0].elements['cuocTtktFocus'].value = cuocTtktId;\r\n}\r\nfunction xoa(){\r\n\tcuocTtktId = getSelectedCuocTtktId();\r\n\tif(cuocTtktId == null || cuocTtktId == '' ){\r\n\t\talert('Ch\\u01B0a ch\\u1ECDn b\\u1EA3n ghi n\\u00E0o!');\r\n\t\treturn;\r\n\t}\r\n\tdocument.forms[0].action = 'ke_hoach_nam.do?method=delete&cuocTtktId = '+ cuocTtktId;\r\n\tdocument.forms[0].submit();\r\n\t\t\t\r\n}\r\n\t\r\n</script>");

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
                                                                                              "/ttkt/lap_ke_hoach/chi_dinh_truong_doan.jsp", 
                                                                                              "/top_bar.jsp", 
                                                                                              "/ttkt/dung_chung/tim_kiem.jsp", 
                                                                                              "/ttkt/dung_chung/action_bar.jsp", 
                                                                                              "/bottom.jsp", 
                                                                                              },
                                                                                              {
                                                                                              "0", 
                                                                                              "1", 
                                                                                              "145", 
                                                                                              "205", 
                                                                                              "231", 
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
                                                                                              "0", 
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
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
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
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "4", 
                                                                                              "4", 
                                                                                              "4", 
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
                                                                                              "7", 
                                                                                              "8", 
                                                                                              "10", 
                                                                                              "11", 
                                                                                              "12", 
                                                                                              "13", 
                                                                                              "14", 
                                                                                              "15", 
                                                                                              "16", 
                                                                                              "17", 
                                                                                              "18", 
                                                                                              "19", 
                                                                                              "21", 
                                                                                              "21", 
                                                                                              "23", 
                                                                                              "24", 
                                                                                              "28", 
                                                                                              "29", 
                                                                                              "30", 
                                                                                              "31", 
                                                                                              "31", 
                                                                                              "34", 
                                                                                              "34", 
                                                                                              "36", 
                                                                                              "36", 
                                                                                              "37", 
                                                                                              "37", 
                                                                                              "39", 
                                                                                              "39", 
                                                                                              "44", 
                                                                                              "44", 
                                                                                              "45", 
                                                                                              "45", 
                                                                                              "47", 
                                                                                              "47", 
                                                                                              "52", 
                                                                                              "52", 
                                                                                              "58", 
                                                                                              "58", 
                                                                                              "60", 
                                                                                              "61", 
                                                                                              "60", 
                                                                                              "61", 
                                                                                              "67", 
                                                                                              "67", 
                                                                                              "71", 
                                                                                              "72", 
                                                                                              "73", 
                                                                                              "74", 
                                                                                              "74", 
                                                                                              "75", 
                                                                                              "76", 
                                                                                              "77", 
                                                                                              "77", 
                                                                                              "78", 
                                                                                              "79", 
                                                                                              "80", 
                                                                                              "80", 
                                                                                              "81", 
                                                                                              "82", 
                                                                                              "84", 
                                                                                              "84", 
                                                                                              "86", 
                                                                                              "88", 
                                                                                              "89", 
                                                                                              "89", 
                                                                                              "90", 
                                                                                              "91", 
                                                                                              "92", 
                                                                                              "92", 
                                                                                              "93", 
                                                                                              "94", 
                                                                                              "95", 
                                                                                              "95", 
                                                                                              "96", 
                                                                                              "97", 
                                                                                              "100", 
                                                                                              "101", 
                                                                                              "101", 
                                                                                              "102", 
                                                                                              "102", 
                                                                                              "103", 
                                                                                              "103", 
                                                                                              "104", 
                                                                                              "109", 
                                                                                              "109", 
                                                                                              "1", 
                                                                                              "1", 
                                                                                              "124", 
                                                                                              "124", 
                                                                                              "127", 
                                                                                              "127", 
                                                                                              "128", 
                                                                                              "128", 
                                                                                              "129", 
                                                                                              "129", 
                                                                                              "132", 
                                                                                              "132", 
                                                                                              "135", 
                                                                                              "136", 
                                                                                              "137", 
                                                                                              "138", 
                                                                                              "138", 
                                                                                              "138", 
                                                                                              "138", 
                                                                                              "139", 
                                                                                              "138", 
                                                                                              "139", 
                                                                                              "139", 
                                                                                              "139", 
                                                                                              "140", 
                                                                                              "140", 
                                                                                              "142", 
                                                                                              "142", 
                                                                                              "142", 
                                                                                              "142", 
                                                                                              "144", 
                                                                                              "144", 
                                                                                              "145", 
                                                                                              "145", 
                                                                                              "146", 
                                                                                              "147", 
                                                                                              "147", 
                                                                                              "148", 
                                                                                              "148", 
                                                                                              "149", 
                                                                                              "149", 
                                                                                              "150", 
                                                                                              "151", 
                                                                                              "151", 
                                                                                              "151", 
                                                                                              "152", 
                                                                                              "153", 
                                                                                              "153", 
                                                                                              "153", 
                                                                                              "153", 
                                                                                              "154", 
                                                                                              "154", 
                                                                                              "154", 
                                                                                              "154", 
                                                                                              "156", 
                                                                                              "157", 
                                                                                              "159", 
                                                                                              "159", 
                                                                                              "166", 
                                                                                              "173", 
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
                                                                                              "174", 
                                                                                              "177", 
                                                                                              "181", 
                                                                                              "181", 
                                                                                              "182", 
                                                                                              "182", 
                                                                                              "183", 
                                                                                              "23", 
                                                                                              "25", 
                                                                                              "33", 
                                                                                              "187", 
                                                                                              },
                                                                                              };
                                                                                              }
