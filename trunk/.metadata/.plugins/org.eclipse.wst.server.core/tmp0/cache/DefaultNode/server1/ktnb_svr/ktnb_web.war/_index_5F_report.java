package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _index_5F_report extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _index_5F_report( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/index_report.jsp";

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

                                                      // HTML // begin [file="/index_report.jsp";from=(0,31);to=(1,0)]
                                                        out.write(" \r\n");

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
                                                      // HTML // begin [file="/index_report.jsp";from=(1,33);to=(35,0)]
                                                        out.write("\r\n<div id=\"tab_kntc\" style=\"background-color: transparent\">\r\n<ul>\r\n\t<li><a href=\"#tab_bc_kntc\"><b>Báo cáo KNTC</b></a></li>\r\n\t<li><a href=\"#tab_bc_ttkt\"><b>Báo cáo TTKT</b></a></li>\r\n</ul>\r\n<div id=\"tab_bc_kntc\">\r\n<ul class=\"liMenu\">\r\n\t<li><img src=\"images/icons/report1.png\" /><a href=\"kntc_rp.do?method=bc28\">Báo cáo tổng hợp kết quả công tác tiếp dân và quản lý nhà nước về KNTC - Mẫu số 28/BC/KNTC</a></li>\r\n\t<li><img src=\"images/icons/report1.png\" /><a href=\"kntc_rp.do?method=bcKn\">Báo cáo tổng hợp kết quả giải quyết đơn KN - Mẫu số 29/BC/KNTC</a></li>\r\n\t<li><img src=\"images/icons/report1.png\" /><a href=\"kntc_rp.do?method=bcKnNd\">Báo cáo tổng hợp đơn KN theo nội dung - Mẫu số 29C/BC/KNTC</a></li>\r\n\t<li><img src=\"images/icons/report1.png\" /><a href=\"kntc_rp.do?method=bcTc\">Báo cáo tổng hợp kết quả giải quyết đơn TC - Mẫu số 30/BC/KNTC</a></li>\r\n\t<li><img src=\"images/icons/report1.png\" /><a href=\"kntc_rp.do?method=bcTcNd\">Báo cáo tổng hợp đơn Tố cáo theo nội dung - Mẫu số 30C/BC/KNTC</a></li>\r\n</ul>\r\n</div>\r\n<div id=\"tab_bc_ttkt\">\r\n<ul class=\"liMenu\">\r\n\t<li><img src=\"images/icons/report3.png\" /><a href=\"kntc_rp.do?method=bcTtKt&tenBc=bctt02\">Báo cáo kế hoạch Thanh tra, Kiểm tra nội bộ ngành - Mẫu số 02/TTNB</a></li>\r\n\t<li><img src=\"images/icons/report3.png\" /><a href=\"kntc_rp.do?method=bcTtKt\">Báo cáo công tác Thanh tra, Kiểm tra nội bộ ngành - Mẫu số 43/TTNB</a></li>\r\n\t<li><img src=\"images/icons/report3.png\" /><a href=\"kntc_rp.do?method=bcTtKt43E\">Báo cáo thực hiện kế hoạch Thanh tra, Kiểm tra nội bộ theo nội dung – Mẫu 43E</a></li>\r\n\t<li><img src=\"images/icons/report3.png\" /><a href=\"kntc_rp.do?method=bcTtKt&tenBc=bctt43f\">Báo cáo thống kê cán bộ – Mẫu 43F</a></li>\t\r\n</ul>\r\n</div>\r\n</div>\r\n<script>\r\n$(function()\r\n{\r\n  var tab_select=jQuery.fn.readCookie(\"TABI\");\r\n  var tabOpts={selected:tab_select,select:function(event,tab){jQuery.fn.createCookie(\"TABI\",tab.index);}}; \r\n  $(\"#tab_kntc\").tabs(tabOpts);\r\n  $(\"#tab_kntc\").removeClass(\"ui-corner-all\");\r\n  $(\"#tab_kntc\").children().removeClass(\"ui-corner-all\");\r\n});\r\n</script>\r\n");

                                                      // end
                                                      // HTML // begin [file="/bottom.jsp";from=(0,31);to=(22,4)]
                                                        out.write("\r\n<script language=\"Javascript\">\r\n$(function() \r\n{\r\n  $(document).bind('keydown','esc',function(evt){onButton('exit');return false;});\r\n  $(document).bind('keydown','home',function(evt){window.location='index.do';return false;});\r\n  if($('#exit').length>0)\r\n  {\r\n   $('#exit').button({icons:{primary:'ui-icon-close'}}).click(function(){onButton('exit');return false;});\r\n  }\r\n  if($('#search').length>0)\r\n  {\r\n    $('#search').button({icons:{primary:'ui-icon-search'}}).click(function(){onButton('search');return false;});\r\n    $(document).bind('keydown','Shift+s',function(evt){onButton('search');return false;});\r\n  }\r\n  if($('table.data_table').length>0)\r\n  {\r\n    $('table.data_table tbody tr').each(function(index) {$(this).addClass(arrClassName[index%3]);});\r\n    $(\"table.data_table tbody\").delegate(\"tr\", \"hover\", function(){$(this).toggleClass(\"highlight\");});\r\n  }\r\n  if($('#msgdiv').length>0)\r\n  {\r\n    ");

                                                      // end
                                                      // ##DEBUG## ##TAGLIB## "/bottom.jsp" 23,4-"/bottom.jsp" 23,30  LineMapIndex:59
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
                                                            // ##DEBUG## "/bottom.jsp" 25,4-"/bottom.jsp" 25,20  LineMapIndex:60
                                                            } while (_jspx_th_logic_present_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                          }
                                                          if (_jspx_th_logic_present_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                            return;
                                                        ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                      // end
                                                      // HTML // begin [file="/bottom.jsp";from=(24,20);to=(32,92)]
                                                        out.write("\r\n  } \r\n});\r\n</script>\r\n</div>\r\n<div id=\"bottom\">\r\n<table width=\"100%\" border=\"0\" bordercolor=\"#AEC1F1\">\r\n\t<tr>\r\n\t\t<td align=\"center\" width=\"20%\" style=\"color: blue; font-size: 8pt\">KTNB Phiên bản <strong>");

                                                      // end
                                                      // ##DEBUG## "/bottom.jsp" 33,95-"/bottom.jsp" 33,113  LineMapIndex:61
                                                        out.print(ac.getVersionApp());
                                                      // end
                                                      // HTML // begin [file="/bottom.jsp";from=(32,115);to=(60,9)]
                                                        out.write("</strong> <br>\r\n\t\t<script language=JavaScript>\r\n                                                dayname = new Array(\"Chủ nhật\", \"Thứ Hai\", \"Thứ Ba\", \"Thứ Tư\", \"Thứ Năm\", \"Thứ Sáu\", \"Thứ Bẩy\");\r\n                                                monthname = new Array(\"01\", \"02\", \"03\", \"04\", \"05\", \"06\", \"07\", \"08\", \"09\", \"10\", \"11\", \"12\");\r\n                                                now = new Date();\r\n                                                daynum = now.getDay();\r\n                                                day = dayname[daynum];\r\n                                                date = now.getDate();\r\n                                                monthnum = now.getMonth();\r\n                                                month = monthname[monthnum];\r\n                                                document.write(\"\"+day+\", Ngày \"+date+\"/\"+month+\"/\"+now.getYear()+\"\");\r\n          </script></td>\r\n\t\t<td align=\"center\" width=\"70%\"><font style=\"color: blue; font-size: 8pt\"> <b>TỔNG CỤC THUẾ</b> <BR>\r\n\t\t<strong>Địa chỉ:</strong> Số 123 Lò Đúc, Hà Nội &nbsp; &nbsp;<strong>Điện thoại:</strong> (04) 9.724204 - 9.724209 <strong>Fax:</strong> (04) 9.712286 <br>\r\n\t\t<strong>Website:</strong> <a href=\"http://www.gdt.gov.vn\" target=\"_blank\">http://www.gdt.gov.vn</a> </font></td>\r\n\t</tr>\r\n</table>\r\n</div>\r\n</body>\r\n</html>\r\n<script language=\"Javascript\">\r\n// style js ui\r\n//$(function(){\r\n//\t$.each($('[type=\"button\"]'),function(index,value){\r\n//\t\t$(value).button();\r\n//\t\t$(value).css(\"font-size\",\"11\");\r\n//\t})\r\n//})\r\n</script>");

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
                                                  "/index_report.jsp", 
                                                  "/top_bar.jsp", 
                                                  "/bottom.jsp", 
                                                  },
                                                  {
                                                  "0", 
                                                  "1", 
                                                  "59", 
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
                                                  "2", 
                                                  "2", 
                                                  "2", 
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
                                                  "23", 
                                                  "25", 
                                                  "33", 
                                                  },
                                                  };
                                                }
