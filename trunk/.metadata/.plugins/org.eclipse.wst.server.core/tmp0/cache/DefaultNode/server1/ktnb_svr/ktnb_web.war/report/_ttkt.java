package org.apache.jsp;

import cmc.com.ktnb.util.KtnbUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _ttkt extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _ttkt( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/report/ttkt.jsp";

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

                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(0,31);to=(1,0)]
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(1,34);to=(2,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(2,47);to=(4,0)]
                                                                                              out.write(" \r\n<h3 class=\"Header\">Báo cáo Thanh tra Kiểm tra hệ thống KTNB</h3>\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 5,0-"/report/ttkt.jsp" 5,47  LineMapIndex:59
                                                                                              /* ------  html:form ------ */
                                                                                              org.apache.struts.taglib.html.FormTag _jspx_th_html_form_0 = new org.apache.struts.taglib.html.FormTag();
                                                                                              _jspx_th_html_form_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_form_0.setParent(null);
                                                                                              _jspx_th_html_form_0.setAction("/kntc_rp.do?method=bcTtKt");
                                                                                              _jspxTagObjects.push(_jspx_th_html_form_0);
                                                                                              int _jspx_eval_html_form_0 = _jspx_th_html_form_0.doStartTag();
                                                                                              if (_jspx_eval_html_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(4,47);to=(5,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 6,0-"/report/ttkt.jsp" 6,32  LineMapIndex:60
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_hidden_0.setProperty("arrCqt");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_0);
                                                                                              int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 6,0-"/report/ttkt.jsp" 6,32  LineMapIndex:61
                                                                                              if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(5,32);to=(6,0)]
                                                                                              out.write("\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 7,0-"/report/ttkt.jsp" 7,47  LineMapIndex:62
                                                                                              /* ------  html:hidden ------ */
                                                                                              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_1 = new org.apache.struts.taglib.html.HiddenTag();
                                                                                              _jspx_th_html_hidden_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_hidden_1.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_hidden_1.setProperty("loaiBc");
                                                                                              _jspx_th_html_hidden_1.setValue("bcTtKt");
                                                                                              _jspxTagObjects.push(_jspx_th_html_hidden_1);
                                                                                              int _jspx_eval_html_hidden_1 = _jspx_th_html_hidden_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 7,0-"/report/ttkt.jsp" 7,47  LineMapIndex:63
                                                                                              if (_jspx_th_html_hidden_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(6,47);to=(17,6)]
                                                                                              out.write("\r\n<fieldset>\r\n\t<legend>Chọn các tiêu chí để lập báo cáo</legend>\r\n\t<table width=\"100%\">\r\n\t\t<tr>\r\n\t\t<td width=\"55%\">\r\n\t\t\t<fieldset><legend>Thông tin chung</legend>\r\n\t\t\t<table width=\"100%\">\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td>Loại báo cáo</td>\r\n\t\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 18,6-"/report/ttkt.jsp" 18,71  LineMapIndex:64
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_0 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_select_0.setProperty("tenBc");
                                                                                              _jspx_th_html_select_0.setStyleId("loai");
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(17,71);to=(18,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 19,7-"/report/ttkt.jsp" 19,80  LineMapIndex:65
                                                                                              /* ------  html:options ------ */
                                                                                              org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_0 = new org.apache.struts.taglib.html.OptionsTag();
                                                                                              _jspx_th_html_options_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_options_0.setParent(_jspx_th_html_select_0);
                                                                                              _jspx_th_html_options_0.setCollection("dmbc");
                                                                                              _jspx_th_html_options_0.setProperty("value");
                                                                                              _jspx_th_html_options_0.setLabelProperty("label");
                                                                                              _jspxTagObjects.push(_jspx_th_html_options_0);
                                                                                              int _jspx_eval_html_options_0 = _jspx_th_html_options_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 19,7-"/report/ttkt.jsp" 19,80  LineMapIndex:66
                                                                                              if (_jspx_th_html_options_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(18,80);to=(19,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 20,6-"/report/ttkt.jsp" 20,20  LineMapIndex:67
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(19,20);to=(24,21)]
                                                                                              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td>Từ tháng<font color=\"red\">*</font></td>\r\n\t\t\t\t\t<td colspan=\"2\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 25,21-"/report/ttkt.jsp" 25,175  LineMapIndex:68
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_0.setProperty("tuThang");
                                                                                              _jspx_th_html_text_0.setStyle("width: 100%;font-size: 12px;");
                                                                                              _jspx_th_html_text_0.setAlt("mm/yyyy");
                                                                                              _jspx_th_html_text_0.setOnkeypress("return formatDateMonth(event, this)");
                                                                                              _jspx_th_html_text_0.setOnblur("isMonth(this)");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_0);
                                                                                              int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 25,21-"/report/ttkt.jsp" 25,175  LineMapIndex:69
                                                                                              if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(24,175);to=(27,21)]
                                                                                              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>Đến tháng<font color=\"red\">*</font></td>\r\n\t\t\t\t\t<td colspan=\"2\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 28,21-"/report/ttkt.jsp" 28,176  LineMapIndex:70
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_1 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_1.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_1.setProperty("denThang");
                                                                                              _jspx_th_html_text_1.setStyle("width: 100%;font-size: 12px;");
                                                                                              _jspx_th_html_text_1.setAlt("mm/yyyy");
                                                                                              _jspx_th_html_text_1.setOnkeypress("return formatDateMonth(event, this)");
                                                                                              _jspx_th_html_text_1.setOnblur("isMonth(this)");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_1);
                                                                                              int _jspx_eval_html_text_1 = _jspx_th_html_text_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 28,21-"/report/ttkt.jsp" 28,176  LineMapIndex:71
                                                                                              if (_jspx_th_html_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(27,176);to=(31,21)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<!-- <tr>\r\n\t\t\t\t\t<td width=\"20%\">Năm<font color=\"red\">*</font></td>\r\n\t\t\t\t\t<td width=\"15%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 32,21-"/report/ttkt.jsp" 32,164  LineMapIndex:72
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_2.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_2.setProperty("nam");
                                                                                              _jspx_th_html_text_2.setMaxlength("4");
                                                                                              _jspx_th_html_text_2.setStyle("width: 65px;font-size: 12px;");
                                                                                              _jspx_th_html_text_2.setOnkeypress("return formatInt(event)");
                                                                                              _jspx_th_html_text_2.setOnblur("isNumberInt(this);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_2);
                                                                                              int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 32,21-"/report/ttkt.jsp" 32,164  LineMapIndex:73
                                                                                              if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(31,164);to=(34,6)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t<td width=\"15%\"><font style=\"vertical-align: middle;\">Loại kỳ</font></td>\r\n\t\t\t\t\t<td width=\"15%\">\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 35,6-"/report/ttkt.jsp" 35,89  LineMapIndex:74
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_1 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_1.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_select_1.setProperty("tuNgay");
                                                                                              _jspx_th_html_select_1.setStyleId("loai");
                                                                                              _jspx_th_html_select_1.setStyle("width: 65px;font-size: 12px;");
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(34,89);to=(35,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 36,7-"/report/ttkt.jsp" 36,34  LineMapIndex:75
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_0 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_0.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_0.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_0.setValue("THANG");
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(35,34);to=(35,39)]
                                                                                              out.write("Tháng");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 36,39-"/report/ttkt.jsp" 36,53  LineMapIndex:76
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(35,53);to=(36,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 37,7-"/report/ttkt.jsp" 37,32  LineMapIndex:77
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_1 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_1.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_1.setValue("QUY");
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(36,32);to=(36,35)]
                                                                                              out.write("Quý");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 37,35-"/report/ttkt.jsp" 37,49  LineMapIndex:78
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(36,49);to=(37,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 38,7-"/report/ttkt.jsp" 38,32  LineMapIndex:79
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_2 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_2.setParent(_jspx_th_html_select_1);
                                                                                              _jspx_th_html_option_2.setValue("NAM");
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(37,32);to=(37,35)]
                                                                                              out.write("Năm");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 38,35-"/report/ttkt.jsp" 38,49  LineMapIndex:80
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(37,49);to=(38,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 39,6-"/report/ttkt.jsp" 39,20  LineMapIndex:81
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(38,20);to=(41,21)]
                                                                                              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td width=\"15%\">Chi tiết kỳ</td>\r\n\t\t\t\t\t<td width=\"20%\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 42,21-"/report/ttkt.jsp" 42,166  LineMapIndex:82
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_3 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_3.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_3.setProperty("kyBc");
                                                                                              _jspx_th_html_text_3.setMaxlength("2");
                                                                                              _jspx_th_html_text_3.setStyle("width: 75px;font-size: 12px;");
                                                                                              _jspx_th_html_text_3.setOnkeypress("return formatInt(event)");
                                                                                              _jspx_th_html_text_3.setOnblur("isNumberInt(this);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_3);
                                                                                              int _jspx_eval_html_text_3 = _jspx_th_html_text_3.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 42,21-"/report/ttkt.jsp" 42,166  LineMapIndex:83
                                                                                              if (_jspx_th_html_text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(41,166);to=(46,21)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t -->\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td>Nơi lập báo cáo</td>\r\n\t\t\t\t\t<td colspan=\"5\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 47,21-"/report/ttkt.jsp" 47,72  LineMapIndex:84
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_4 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_4.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_4.setProperty("diaDiem");
                                                                                              _jspx_th_html_text_4.setStyle("width: 100%");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_4);
                                                                                              int _jspx_eval_html_text_4 = _jspx_th_html_text_4.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 47,21-"/report/ttkt.jsp" 47,72  LineMapIndex:85
                                                                                              if (_jspx_th_html_text_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(46,72);to=(50,21)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td>Ngày lập</td>\r\n\t\t\t\t\t<td colspan=\"2\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 51,21-"/report/ttkt.jsp" 51,171  LineMapIndex:86
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_5 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_5.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_5.setProperty("ngayLap");
                                                                                              _jspx_th_html_text_5.setMaxlength("10");
                                                                                              _jspx_th_html_text_5.setStyle("width: 100%;font-size: 12px;");
                                                                                              _jspx_th_html_text_5.setOnkeypress("return formatDate(event, this)");
                                                                                              _jspx_th_html_text_5.setOnblur("isDate(this);");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_5);
                                                                                              int _jspx_eval_html_text_5 = _jspx_th_html_text_5.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 51,21-"/report/ttkt.jsp" 51,171  LineMapIndex:87
                                                                                              if (_jspx_th_html_text_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(50,171);to=(52,21)]
                                                                                              out.write("</td>\r\n\t\t\t\t\t<td>Người lập</td>\r\n\t\t\t\t\t<td colspan=\"2\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 53,21-"/report/ttkt.jsp" 53,90  LineMapIndex:88
                                                                                              /* ------  html:text ------ */
                                                                                              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_6 = new org.apache.struts.taglib.html.TextTag();
                                                                                              _jspx_th_html_text_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_text_6.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_text_6.setProperty("nguoiLap");
                                                                                              _jspx_th_html_text_6.setStyle("width: 100%;font-size: 12px;");
                                                                                              _jspxTagObjects.push(_jspx_th_html_text_6);
                                                                                              int _jspx_eval_html_text_6 = _jspx_th_html_text_6.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 53,21-"/report/ttkt.jsp" 53,90  LineMapIndex:89
                                                                                              if (_jspx_th_html_text_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(52,90);to=(55,5)]
                                                                                              out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/report/ttkt.jsp" 56,7-"/report/ttkt.jsp" 56,37  LineMapIndex:90
                                                                                               if(KtnbUtil.isTongCuc(ac)) { 
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(55,39);to=(58,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t<td>Định dạng</td>\r\n\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 59,6-"/report/ttkt.jsp" 59,76  LineMapIndex:91
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_2 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_2.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_2.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_select_2.setProperty("dinhDang");
                                                                                              _jspx_th_html_select_2.setStyle("width:100%;font-size: 12px;");
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(58,76);to=(59,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 60,7-"/report/ttkt.jsp" 60,31  LineMapIndex:92
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_3 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_3.setParent(_jspx_th_html_select_2);
                                                                                              _jspx_th_html_option_3.setValue("A4");
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(59,31);to=(59,33)]
                                                                                              out.write("A4");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 60,33-"/report/ttkt.jsp" 60,47  LineMapIndex:93
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(59,47);to=(61,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 62,6-"/report/ttkt.jsp" 62,20  LineMapIndex:94
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(61,20);to=(65,6)]
                                                                                              out.write(" \t\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>Kết quả</td>\r\n\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 66,6-"/report/ttkt.jsp" 66,74  LineMapIndex:95
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_3 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_3.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_3.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_select_3.setProperty("ketQua");
                                                                                              _jspx_th_html_select_3.setStyle("width:100%;font-size: 12px;");
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(65,74);to=(66,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 67,7-"/report/ttkt.jsp" 67,30  LineMapIndex:96
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_4 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_4.setParent(_jspx_th_html_select_3);
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(66,30);to=(66,38)]
                                                                                              out.write("Tổng hợp");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 67,38-"/report/ttkt.jsp" 67,52  LineMapIndex:97
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(66,52);to=(67,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 68,7-"/report/ttkt.jsp" 68,30  LineMapIndex:98
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_5 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_5.setParent(_jspx_th_html_select_3);
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(67,30);to=(67,38)]
                                                                                              out.write("Chi tiết");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 68,38-"/report/ttkt.jsp" 68,52  LineMapIndex:99
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(67,52);to=(68,6)]
                                                                                              out.write("\t\t\t\t\t\t\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 69,6-"/report/ttkt.jsp" 69,20  LineMapIndex:100
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(68,20);to=(70,5)]
                                                                                              out.write(" \t\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/report/ttkt.jsp" 71,7-"/report/ttkt.jsp" 71,16  LineMapIndex:101
                                                                                               } else{ 
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(70,18);to=(73,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t<td>Định dạng</td>\r\n\t\t\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 74,6-"/report/ttkt.jsp" 74,76  LineMapIndex:102
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_4 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_4.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_4.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_select_4.setProperty("dinhDang");
                                                                                              _jspx_th_html_select_4.setStyle("width:100%;font-size: 12px;");
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(73,76);to=(74,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 75,7-"/report/ttkt.jsp" 75,31  LineMapIndex:103
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_6 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_6.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_6.setParent(_jspx_th_html_select_4);
                                                                                              _jspx_th_html_option_6.setValue("A4");
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(74,31);to=(74,33)]
                                                                                              out.write("A4");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 75,33-"/report/ttkt.jsp" 75,47  LineMapIndex:104
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(74,47);to=(75,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 76,7-"/report/ttkt.jsp" 76,31  LineMapIndex:105
                                                                                              /* ------  html:option ------ */
                                                                                              org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_7 = new org.apache.struts.taglib.html.OptionTag();
                                                                                              _jspx_th_html_option_7.setPageContext(pageContext);
                                                                                              _jspx_th_html_option_7.setParent(_jspx_th_html_select_4);
                                                                                              _jspx_th_html_option_7.setValue("A3");
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(75,31);to=(75,33)]
                                                                                              out.write("A3");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 76,33-"/report/ttkt.jsp" 76,47  LineMapIndex:106
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(75,47);to=(76,6)]
                                                                                              out.write("\t\t\t\t\t\t\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 77,6-"/report/ttkt.jsp" 77,20  LineMapIndex:107
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(76,20);to=(78,5)]
                                                                                              out.write(" \t\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/report/ttkt.jsp" 79,7-"/report/ttkt.jsp" 79,11  LineMapIndex:108
                                                                                               }  
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(78,13);to=(84,3)]
                                                                                              out.write("\r\n\t\t\t\t</tr>\t\t\t\t\t\t\t\t\r\n\t\t\t</table>\r\n\t\t\t</fieldset>\r\n\t\t</td>\r\n\t\t<td width=\"45%\">\t\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/report/ttkt.jsp" 85,5-"/report/ttkt.jsp" 85,35  LineMapIndex:109
                                                                                               if(KtnbUtil.isTongCuc(ac)) { 
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(84,37);to=(89,6)]
                                                                                              out.write("\r\n\t\t\t<table width=\"100%\" border=\"0\">\r\n\t\t\t   <tr>\r\n\t\t\t\t\t<td width=\"30%\" align=\"right\">Chọn cơ quan Thuế</td>\r\n\t\t\t\t\t<td width=\"70%\">\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 90,6-"/report/ttkt.jsp" 90,93  LineMapIndex:110
                                                                                              /* ------  html:select ------ */
                                                                                              org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_5 = new org.apache.struts.taglib.html.SelectTag();
                                                                                              _jspx_th_html_select_5.setPageContext(pageContext);
                                                                                              _jspx_th_html_select_5.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_html_select_5.setProperty("capCqt");
                                                                                              _jspx_th_html_select_5.setStyleId("loai");
                                                                                              _jspx_th_html_select_5.setStyle("width: 100%");
                                                                                              _jspx_th_html_select_5.setOnchange("search();");
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(89,93);to=(90,7)]
                                                                                              out.write("\r\n\t\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/ttkt.jsp" 91,7-"/report/ttkt.jsp" 91,81  LineMapIndex:111
                                                                                              /* ------  html:options ------ */
                                                                                              org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_1 = new org.apache.struts.taglib.html.OptionsTag();
                                                                                              _jspx_th_html_options_1.setPageContext(pageContext);
                                                                                              _jspx_th_html_options_1.setParent(_jspx_th_html_select_5);
                                                                                              _jspx_th_html_options_1.setCollection("dmCqt");
                                                                                              _jspx_th_html_options_1.setProperty("value");
                                                                                              _jspx_th_html_options_1.setLabelProperty("label");
                                                                                              _jspxTagObjects.push(_jspx_th_html_options_1);
                                                                                              int _jspx_eval_html_options_1 = _jspx_th_html_options_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 91,7-"/report/ttkt.jsp" 91,81  LineMapIndex:112
                                                                                              if (_jspx_th_html_options_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(90,81);to=(91,6)]
                                                                                              out.write("\r\n\t\t\t\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 92,6-"/report/ttkt.jsp" 92,20  LineMapIndex:113
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
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(91,20);to=(95,3)]
                                                                                              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t</table>\t\t\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/report/ttkt.jsp" 96,5-"/report/ttkt.jsp" 96,6  LineMapIndex:114
                                                                                              }
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(95,8);to=(97,3)]
                                                                                              out.write("\t\r\n\t\t\t<fieldset><legend>Danh sách CQT</legend>\t\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/report/ttkt.jsp" 98,5-"/report/ttkt.jsp" 98,35  LineMapIndex:115
                                                                                               if(KtnbUtil.isTongCuc(ac)) { 
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(97,37);to=(99,3)]
                                                                                              out.write("\t\t\r\n\t\t\t\t<div style=\"width:auto;height:120px;display:block;overflow:auto;border:1px solid #f1f1f1;padding:1px\">\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/report/ttkt.jsp" 100,5-"/report/ttkt.jsp" 100,12  LineMapIndex:116
                                                                                              } else 
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(99,14);to=(102,4)]
                                                                                              out.write("\r\n\t\t\t\t<div style=\"width:auto;height:145px;display:block;overflow:auto;border:1px solid #f1f1f1;padding:1px\">\t\r\n\t\t\t<!--CO QUAN THUE--> \r\n\t\t\t\t");

                                                                                              // end
                                                                                              // HTML // begin [file="/report/../include/cqt1.jsp";from=(0,31);to=(8,1)]
                                                                                              out.write("\r\n<TABLE style=\"width:305px;border:1px solid #f1f1f1;padding:1px\" >\r\n\t<tr class=\"TdHeaderList\" align=\"center\">\r\n\t\t<td width=\"20%\"><input id=\"ctrlCqtBox\" name=\"selectAll\" type=\"CHECKBOX\" onclick=\"check(cqtCB,ctrlCqtBox);\"/></td>\r\n\t\t<td width=\"80%\">Tên CQT</td>\r\n\t</tr>\r\n</table>\r\n<table style=\"width:305px;height:110px;display:block;overflow:auto;border:1px solid #f1f1f1;padding:1px\">\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/../include/cqt1.jsp" 9,1-"/report/../include/cqt1.jsp" 9,28  LineMapIndex:117
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_0 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_0.setParent(_jspx_th_html_form_0);
                                                                                              _jspx_th_logic_present_0.setName("cqts");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_0);
                                                                                              int _jspx_eval_logic_present_0 = _jspx_th_logic_present_0.doStartTag();
                                                                                              if (_jspx_eval_logic_present_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/report/../include/cqt1.jsp";from=(8,28);to=(9,3)]
                                                                                              out.write("\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/../include/cqt1.jsp" 10,3-"/report/../include/cqt1.jsp" 10,55  LineMapIndex:118
                                                                                              /* ------  logic:iterate ------ */
                                                                                              org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_0 = new org.apache.struts.taglib.logic.IterateTag();
                                                                                              _jspx_th_logic_iterate_0.setPageContext(pageContext);
                                                                                              _jspx_th_logic_iterate_0.setParent(_jspx_th_logic_present_0);
                                                                                              _jspx_th_logic_iterate_0.setName("cqts");
                                                                                              _jspx_th_logic_iterate_0.setId("cqt");
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
                                                                                              java.lang.Object cqt = null;
                                                                                              cqt = (java.lang.Object) pageContext.findAttribute("cqt");
                                                                                              java.lang.Integer index = null;
                                                                                              index = (java.lang.Integer) pageContext.findAttribute("index");
                                                                                              // end
                                                                                              // HTML // begin [file="/report/../include/cqt1.jsp";from=(9,55);to=(10,32)]
                                                                                              out.write("\r\n\t\t\t<tr align=\"center\" class=\"row");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/../include/cqt1.jsp" 11,35-"/report/../include/cqt1.jsp" 11,60  LineMapIndex:119
                                                                                              out.print((index.intValue() % 2)+1 );
                                                                                              // end
                                                                                              // HTML // begin [file="/report/../include/cqt1.jsp";from=(10,62);to=(11,108)]
                                                                                              out.write("\">\r\n\t\t\t\t<td width=\"20%\"><input id=\"cqtCB\" name=\"selectCqt\" type=\"CHECKBOX\" onclick=\"checkUncheck(this);\" value=\"");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/../include/cqt1.jsp" 12,108-"/report/../include/cqt1.jsp" 12,147  LineMapIndex:120
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_0.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_0.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_0.setName("cqt");
                                                                                              _jspx_th_bean_write_0.setProperty("ma");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_0);
                                                                                              int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/report/../include/cqt1.jsp" 12,108-"/report/../include/cqt1.jsp" 12,147  LineMapIndex:121
                                                                                              if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/../include/cqt1.jsp";from=(11,147);to=(12,33)]
                                                                                              out.write("\"  /></td>\r\n\t\t\t\t<td width=\"80%\" align=\"left\">");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/report/../include/cqt1.jsp" 13,33-"/report/../include/cqt1.jsp" 13,73  LineMapIndex:122
                                                                                              /* ------  bean:write ------ */
                                                                                              org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_1 = new org.apache.struts.taglib.bean.WriteTag();
                                                                                              _jspx_th_bean_write_1.setPageContext(pageContext);
                                                                                              _jspx_th_bean_write_1.setParent(_jspx_th_logic_iterate_0);
                                                                                              _jspx_th_bean_write_1.setName("cqt");
                                                                                              _jspx_th_bean_write_1.setProperty("ten");
                                                                                              _jspxTagObjects.push(_jspx_th_bean_write_1);
                                                                                              int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
                                                                                              // end
                                                                                              // ##DEBUG## "/report/../include/cqt1.jsp" 13,33-"/report/../include/cqt1.jsp" 13,73  LineMapIndex:123
                                                                                              if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/../include/cqt1.jsp";from=(12,73);to=(14,3)]
                                                                                              out.write("</td>\t\t\t\t\t\r\n\t\t\t</tr>\r\n\t\t\t");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/../include/cqt1.jsp" 15,3-"/report/../include/cqt1.jsp" 15,19  LineMapIndex:124
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
                                                                                              // HTML // begin [file="/report/../include/cqt1.jsp";from=(14,19);to=(15,4)]
                                                                                              out.write("\r\n\t   ");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/../include/cqt1.jsp" 16,4-"/report/../include/cqt1.jsp" 16,20  LineMapIndex:125
                                                                                              } while (_jspx_th_logic_present_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/../include/cqt1.jsp";from=(15,20);to=(23,9)]
                                                                                              out.write("\t\r\n</table>\r\n<script type=\"text/javascript\" charset=\"utf-8\">  \r\nfunction checkUncheck(control){\r\n\tif(!control.checked){\r\n\t\tdocument.getElementById(\"ctrlCqtBox\").checked = false;\r\n\t}\r\n}\r\n</script>");

                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(102,45);to=(119,0)]
                                                                                              out.write(" \r\n\t\t\t</div>\t\t\t\t\r\n\t\t\t</fieldset>\r\n\t\t</td>\t\t\r\n\t\t</tr> \r\n\t\t</table>\r\n\t\t<table width=\"100%\">\r\n\t\t\t<tr align=\"center\">\r\n\t\t    \t<td align=\"right\" width=\"50%\">\r\n\t\t      \t\t<input type=\"button\"  class=\"button\" value='Kết xuất' name=\"B2\" onclick=\"ketXuat();\">\r\n\t\t    \t</td>\r\n\t\t    \t<td align=\"left\" width=\"50%\">\r\n\t\t      \t\t<input type=\"button\"  class=\"button\" value='Đóng' name=\"B2\" onclick=\"goHomeReport();\">\r\n\t\t    \t</td>\r\n\t\t  \t</tr>\r\n\t\t</table>\t \r\n</fieldset>\t\r\n");

                                                                                              // end
                                                                                              // ##DEBUG## "/report/ttkt.jsp" 120,0-"/report/ttkt.jsp" 120,12  LineMapIndex:126
                                                                                              } while (_jspx_th_html_form_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_html_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(119,12);to=(125,1)]
                                                                                              out.write("\r\n<script type=\"text/javascript\" charset=\"utf-8\"> \r\nfunction ketXuat(){\t\r\n\t//if(document.forms[0].tuNgay.value=='THANG' || document.forms[0].tuNgay.value=='QUY')\r\n\t//\tif(!isRequired(document.forms[0].kyBc,'Chưa có thông tin thời điểm báo cáo!'))\r\n\t//\t\treturn false;\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/report/ttkt.jsp" 126,3-"/report/ttkt.jsp" 126,33  LineMapIndex:127
                                                                                               if(KtnbUtil.isTongCuc(ac)) { 
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(125,35);to=(132,1)]
                                                                                              out.write("\t\r\n\t\tif(document.forms[0].ctrlCqtBox.checked==true && document.forms[0].capCqt.value == '00000'){\r\n\t\t\t\tdocument.forms[0].arrCqt.value=\"all\";\r\n\t\t}\r\n\t\telse{\r\n\t\t\t\tdocument.forms[0].arrCqt.value=getCheckReport(document.forms[0].selectCqt);\r\n\t\t}\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/report/ttkt.jsp" 133,3-"/report/ttkt.jsp" 133,9  LineMapIndex:128
                                                                                              }else{
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(132,11);to=(134,1)]
                                                                                              out.write("\r\n\t\tdocument.forms[0].arrCqt.value=getCheckReport(document.forms[0].selectCqt);\r\n\t");

                                                                                              // end
                                                                                              // ##DEBUG## ##SCRIPTLET## "/report/ttkt.jsp" 135,3-"/report/ttkt.jsp" 135,4  LineMapIndex:129
                                                                                              }
                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(134,6);to=(152,0)]
                                                                                              out.write("\r\n\t//document.forms[0].arrCqt.value=getCheckReport(document.forms[0].selectCqt);\r\n\tif(document.forms[0].tuThang.value.length < 1){\r\n\t\talert('Phải nhập thông tin tháng cần xem báo cáo!!!');\r\n\t\tdocument.forms[0].tuThang.focus();\r\n\t\treturn null;\r\n\t}\r\n\tif(document.forms[0].denThang.value.length < 1){\r\n\t\tdocument.forms[0].denThang.value = document.forms[0].tuThang.value;\r\n\t}\r\n\tdocument.forms[0].action=\"kntc_rp.do?method=export\";\r\n\tdocument.forms[0].submit();\r\n}\r\nfunction search(){\t\r\n\tdocument.forms[0].action=\"kntc_rp.do?method=search\";\r\n\tdocument.forms[0].submit();\r\n}\r\n</script>\r\n");

                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(0,31);to=(22,4)]
                                                                                              out.write("\r\n<script language=\"Javascript\">\r\n$(function() \r\n{\r\n  $(document).bind('keydown','esc',function(evt){onButton('exit');return false;});\r\n  $(document).bind('keydown','home',function(evt){window.location='index.do';return false;});\r\n  if($('#exit').length>0)\r\n  {\r\n   $('#exit').button({icons:{primary:'ui-icon-close'}}).click(function(){onButton('exit');return false;});\r\n  }\r\n  if($('#search').length>0)\r\n  {\r\n    $('#search').button({icons:{primary:'ui-icon-search'}}).click(function(){onButton('search');return false;});\r\n    $(document).bind('keydown','Shift+s',function(evt){onButton('search');return false;});\r\n  }\r\n  if($('table.data_table').length>0)\r\n  {\r\n    $('table.data_table tbody tr').each(function(index) {$(this).addClass(arrClassName[index%3]);});\r\n    $(\"table.data_table tbody\").delegate(\"tr\", \"hover\", function(){$(this).toggleClass(\"highlight\");});\r\n  }\r\n  if($('#msgdiv').length>0)\r\n  {\r\n    ");

                                                                                              // end
                                                                                              // ##DEBUG## ##TAGLIB## "/bottom.jsp" 23,4-"/bottom.jsp" 23,30  LineMapIndex:130
                                                                                              /* ------  logic:present ------ */
                                                                                              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_1 = new org.apache.struts.taglib.logic.PresentTag();
                                                                                              _jspx_th_logic_present_1.setPageContext(pageContext);
                                                                                              _jspx_th_logic_present_1.setParent(null);
                                                                                              _jspx_th_logic_present_1.setName("msg");
                                                                                              _jspxTagObjects.push(_jspx_th_logic_present_1);
                                                                                              int _jspx_eval_logic_present_1 = _jspx_th_logic_present_1.doStartTag();
                                                                                              if (_jspx_eval_logic_present_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                                                              do {
                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(22,30);to=(24,4)]
                                                                                              out.write("\r\n     $('#msgdiv').effect('pulsate',{times:3});\r\n    ");

                                                                                              // end
                                                                                              // ##DEBUG## "/bottom.jsp" 25,4-"/bottom.jsp" 25,20  LineMapIndex:131
                                                                                              } while (_jspx_th_logic_present_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                                                              }
                                                                                              if (_jspx_th_logic_present_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                              return;
                                                                                              ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(24,20);to=(32,92)]
                                                                                              out.write("\r\n  } \r\n});\r\n</script>\r\n</div>\r\n<div id=\"bottom\">\r\n<table width=\"100%\" border=\"0\" bordercolor=\"#AEC1F1\">\r\n\t<tr>\r\n\t\t<td align=\"center\" width=\"20%\" style=\"color: blue; font-size: 8pt\">KTNB Phiên bản <strong>");

                                                                                              // end
                                                                                              // ##DEBUG## "/bottom.jsp" 33,95-"/bottom.jsp" 33,113  LineMapIndex:132
                                                                                              out.print(ac.getVersionApp());
                                                                                              // end
                                                                                              // HTML // begin [file="/bottom.jsp";from=(32,115);to=(60,9)]
                                                                                              out.write("</strong> <br>\r\n\t\t<script language=JavaScript>\r\n                                                dayname = new Array(\"Chủ nhật\", \"Thứ Hai\", \"Thứ Ba\", \"Thứ Tư\", \"Thứ Năm\", \"Thứ Sáu\", \"Thứ Bẩy\");\r\n                                                monthname = new Array(\"01\", \"02\", \"03\", \"04\", \"05\", \"06\", \"07\", \"08\", \"09\", \"10\", \"11\", \"12\");\r\n                                                now = new Date();\r\n                                                daynum = now.getDay();\r\n                                                day = dayname[daynum];\r\n                                                date = now.getDate();\r\n                                                monthnum = now.getMonth();\r\n                                                month = monthname[monthnum];\r\n                                                document.write(\"\"+day+\", Ngày \"+date+\"/\"+month+\"/\"+now.getYear()+\"\");\r\n          </script></td>\r\n\t\t<td align=\"center\" width=\"70%\"><font style=\"color: blue; font-size: 8pt\"> <b>TỔNG CỤC THUẾ</b> <BR>\r\n\t\t<strong>Địa chỉ:</strong> Số 123 Lò Đúc, Hà Nội &nbsp; &nbsp;<strong>Điện thoại:</strong> (04) 9.724204 - 9.724209 <strong>Fax:</strong> (04) 9.712286 <br>\r\n\t\t<strong>Website:</strong> <a href=\"http://www.gdt.gov.vn\" target=\"_blank\">http://www.gdt.gov.vn</a> </font></td>\r\n\t</tr>\r\n</table>\r\n</div>\r\n</body>\r\n</html>\r\n<script language=\"Javascript\">\r\n// style js ui\r\n//$(function(){\r\n//\t$.each($('[type=\"button\"]'),function(index,value){\r\n//\t\t$(value).button();\r\n//\t\t$(value).css(\"font-size\",\"11\");\r\n//\t})\r\n//})\r\n</script>");

                                                                                              // end
                                                                                              // HTML // begin [file="/report/ttkt.jsp";from=(152,32);to=(155,0)]
                                                                                              out.write("\r\n\r\n\r\n");

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
                                                                                              "/report/ttkt.jsp", 
                                                                                              "/top_bar.jsp", 
                                                                                              "/report/../include/cqt1.jsp", 
                                                                                              "/bottom.jsp", 
                                                                                              },
                                                                                              {
                                                                                              "0", 
                                                                                              "1", 
                                                                                              "117", 
                                                                                              "130", 
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
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "2", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "0", 
                                                                                              "3", 
                                                                                              "3", 
                                                                                              "3", 
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
                                                                                              "5", 
                                                                                              "6", 
                                                                                              "6", 
                                                                                              "7", 
                                                                                              "7", 
                                                                                              "18", 
                                                                                              "19", 
                                                                                              "19", 
                                                                                              "20", 
                                                                                              "25", 
                                                                                              "25", 
                                                                                              "28", 
                                                                                              "28", 
                                                                                              "32", 
                                                                                              "32", 
                                                                                              "35", 
                                                                                              "36", 
                                                                                              "36", 
                                                                                              "37", 
                                                                                              "37", 
                                                                                              "38", 
                                                                                              "38", 
                                                                                              "39", 
                                                                                              "42", 
                                                                                              "42", 
                                                                                              "47", 
                                                                                              "47", 
                                                                                              "51", 
                                                                                              "51", 
                                                                                              "53", 
                                                                                              "53", 
                                                                                              "56", 
                                                                                              "59", 
                                                                                              "60", 
                                                                                              "60", 
                                                                                              "62", 
                                                                                              "66", 
                                                                                              "67", 
                                                                                              "67", 
                                                                                              "68", 
                                                                                              "68", 
                                                                                              "69", 
                                                                                              "71", 
                                                                                              "74", 
                                                                                              "75", 
                                                                                              "75", 
                                                                                              "76", 
                                                                                              "76", 
                                                                                              "77", 
                                                                                              "79", 
                                                                                              "85", 
                                                                                              "90", 
                                                                                              "91", 
                                                                                              "91", 
                                                                                              "92", 
                                                                                              "96", 
                                                                                              "98", 
                                                                                              "100", 
                                                                                              "9", 
                                                                                              "10", 
                                                                                              "11", 
                                                                                              "12", 
                                                                                              "12", 
                                                                                              "13", 
                                                                                              "13", 
                                                                                              "15", 
                                                                                              "16", 
                                                                                              "120", 
                                                                                              "126", 
                                                                                              "133", 
                                                                                              "135", 
                                                                                              "23", 
                                                                                              "25", 
                                                                                              "33", 
                                                                                              },
                                                                                              };
                                                                                              }
