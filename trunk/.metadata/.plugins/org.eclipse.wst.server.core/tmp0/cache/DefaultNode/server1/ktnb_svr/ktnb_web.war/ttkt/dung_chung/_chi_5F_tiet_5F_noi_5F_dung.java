package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _chi_5F_tiet_5F_noi_5F_dung extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _chi_5F_tiet_5F_noi_5F_dung( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/ttkt/dung_chung/chi_tiet_noi_dung.jsp";

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

                                              // HTML // begin [file="/ttkt/dung_chung/chi_tiet_noi_dung.jsp";from=(0,31);to=(1,0)]
                                                out.write("\r\n");

                                              // end
                                              // HTML // begin [file="/top.jsp";from=(0,0);to=(1,0)]
                                                out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");

                                              // end
                                              // HTML // begin [file="/top.jsp";from=(1,31);to=(2,0)]
                                                out.write("\r\n");

                                              // end
                                              // HTML // begin [file="/top.jsp";from=(2,59);to=(3,0)]
                                                out.write("\r\n");

                                              // end
                                              // HTML // begin [file="/top.jsp";from=(3,57);to=(4,0)]
                                                out.write("\r\n");

                                              // end
                                              // HTML // begin [file="/top.jsp";from=(4,57);to=(5,0)]
                                                out.write("\r\n");

                                              // end
                                              // ##DEBUG## ##SCRIPTLET## "/top.jsp" 6,2-"/top.jsp" 13,0  LineMapIndex:1
                                                
                                                	request.setCharacterEncoding("UTF-8");
                                                	response.setContentType("text/html;charset=UTF-8");
                                                	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                                                	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                                                	response.setDateHeader("Expires", 0); // Proxies.
                                                	cmc.com.ktnb.util.ApplicationContext ac = (cmc.com.ktnb.util.ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(12,2);to=(19,49)]
                                                out.write("\r\n<html>\r\n<head>\r\n<META HTTP-EQUIV=\"Cache-Control\" CONTENT=\"no-cache, no-store, must-revalidate\">\r\n<META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\r\n<META HTTP-EQUIV=\"Expires\" CONTENT=\"0\">\r\n<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\" />\r\n<link rel=\"shortcut icon\" type=\"image/ico\" href=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 20,49-"/top.jsp" 20,90  LineMapIndex:9
                                                _jspx_th_html_rewrite_0.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_0.setParent(null);
                                                _jspx_th_html_rewrite_0.setPage("/image/favicon.ico");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_0);
                                                  int _jspx_eval_html_rewrite_0 = _jspx_th_html_rewrite_0.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 20,49-"/top.jsp" 20,90  LineMapIndex:10
                                                  if (_jspx_th_html_rewrite_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(19,90);to=(21,28)]
                                                out.write("\" />\r\n<title>HỆ THỐNG KIỂM TRA NỘI BỘ</title>\r\n<link type=\"text/css\" href=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 22,28-"/top.jsp" 22,71  LineMapIndex:11
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_1 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_1.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_1.setParent(null);
                                                _jspx_th_html_rewrite_1.setPage("/stylesheet/ktnb.css");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_1);
                                                  int _jspx_eval_html_rewrite_1 = _jspx_th_html_rewrite_1.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 22,28-"/top.jsp" 22,71  LineMapIndex:12
                                                  if (_jspx_th_html_rewrite_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(21,71);to=(22,28)]
                                                out.write("\" rel=\"stylesheet\">\r\n<link type=\"text/css\" href=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 23,28-"/top.jsp" 23,81  LineMapIndex:13
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_2 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_2.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_2.setParent(null);
                                                _jspx_th_html_rewrite_2.setPage("/stylesheet/base/jquery-ui.css");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_2);
                                                  int _jspx_eval_html_rewrite_2 = _jspx_th_html_rewrite_2.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 23,28-"/top.jsp" 23,81  LineMapIndex:14
                                                  if (_jspx_th_html_rewrite_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(22,81);to=(23,34)]
                                                out.write("\" rel=\"stylesheet\">\r\n<!--  <link type=\"text/css\" href=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 24,34-"/top.jsp" 24,94  LineMapIndex:15
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_3 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_3.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_3.setParent(null);
                                                _jspx_th_html_rewrite_3.setPage("/stylesheet/base/jquery.treeTable.css");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_3);
                                                  int _jspx_eval_html_rewrite_3 = _jspx_th_html_rewrite_3.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 24,34-"/top.jsp" 24,94  LineMapIndex:16
                                                  if (_jspx_th_html_rewrite_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(23,94);to=(24,28)]
                                                out.write("\" rel=\"stylesheet\">\t-->\r\n<link type=\"text/css\" href=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 25,28-"/top.jsp" 25,79  LineMapIndex:17
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_4 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_4.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_4.setParent(null);
                                                _jspx_th_html_rewrite_4.setPage("/stylesheet/verticaltabs.css");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_4);
                                                  int _jspx_eval_html_rewrite_4 = _jspx_th_html_rewrite_4.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 25,28-"/top.jsp" 25,79  LineMapIndex:18
                                                  if (_jspx_th_html_rewrite_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(24,79);to=(27,36)]
                                                out.write("\" rel=\"stylesheet\">\r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"include/js/themes/default/easyui.css\">\r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"include/js/themes/icon.css\">\r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 28,36-"/top.jsp" 28,90  LineMapIndex:19
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_5 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_5.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_5.setParent(null);
                                                _jspx_th_html_rewrite_5.setPage("/include/js/jquery-1.4.2.min.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_5);
                                                  int _jspx_eval_html_rewrite_5 = _jspx_th_html_rewrite_5.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 28,36-"/top.jsp" 28,90  LineMapIndex:20
                                                  if (_jspx_th_html_rewrite_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(27,90);to=(28,36)]
                                                out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 29,36-"/top.jsp" 29,91  LineMapIndex:21
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_6 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_6.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_6.setParent(null);
                                                _jspx_th_html_rewrite_6.setPage("/include/js/jquery.easyui.min.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_6);
                                                  int _jspx_eval_html_rewrite_6 = _jspx_th_html_rewrite_6.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 29,36-"/top.jsp" 29,91  LineMapIndex:22
                                                  if (_jspx_th_html_rewrite_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(28,91);to=(29,36)]
                                                out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 30,36-"/top.jsp" 30,100  LineMapIndex:23
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_7 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_7.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_7.setParent(null);
                                                _jspx_th_html_rewrite_7.setPage("/include/js/jquery-ui-1.8.2.custom.min.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_7);
                                                  int _jspx_eval_html_rewrite_7 = _jspx_th_html_rewrite_7.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 30,36-"/top.jsp" 30,100  LineMapIndex:24
                                                  if (_jspx_th_html_rewrite_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(29,100);to=(30,36)]
                                                out.write("\"></script> \r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 31,36-"/top.jsp" 31,95  LineMapIndex:25
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_8 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_8.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_8.setParent(null);
                                                _jspx_th_html_rewrite_8.setPage("/include/js/jquery.dataTables.min.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_8);
                                                  int _jspx_eval_html_rewrite_8 = _jspx_th_html_rewrite_8.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 31,36-"/top.jsp" 31,95  LineMapIndex:26
                                                  if (_jspx_th_html_rewrite_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(30,95);to=(31,36)]
                                                out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 32,36-"/top.jsp" 32,95  LineMapIndex:27
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_9 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_9.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_9.setParent(null);
                                                _jspx_th_html_rewrite_9.setPage("/include/js/jquery.jeditable.mini.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_9);
                                                  int _jspx_eval_html_rewrite_9 = _jspx_th_html_rewrite_9.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 32,36-"/top.jsp" 32,95  LineMapIndex:28
                                                  if (_jspx_th_html_rewrite_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(31,95);to=(32,36)]
                                                out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 33,36-"/top.jsp" 33,101  LineMapIndex:29
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_10 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_10.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_10.setParent(null);
                                                _jspx_th_html_rewrite_10.setPage("/include/js/jquery.ui.datepicker-vi.min.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_10);
                                                  int _jspx_eval_html_rewrite_10 = _jspx_th_html_rewrite_10.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 33,36-"/top.jsp" 33,101  LineMapIndex:30
                                                  if (_jspx_th_html_rewrite_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(32,101);to=(33,36)]
                                                out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 34,36-"/top.jsp" 34,89  LineMapIndex:31
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_11 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_11.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_11.setParent(null);
                                                _jspx_th_html_rewrite_11.setPage("/include/js/jquery.jixedbar.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_11);
                                                  int _jspx_eval_html_rewrite_11 = _jspx_th_html_rewrite_11.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 34,36-"/top.jsp" 34,89  LineMapIndex:32
                                                  if (_jspx_th_html_rewrite_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(33,89);to=(34,36)]
                                                out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 35,36-"/top.jsp" 35,88  LineMapIndex:33
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_12 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_12.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_12.setParent(null);
                                                _jspx_th_html_rewrite_12.setPage("/include/js/jquery.hotkeys.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_12);
                                                  int _jspx_eval_html_rewrite_12 = _jspx_th_html_rewrite_12.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 35,36-"/top.jsp" 35,88  LineMapIndex:34
                                                  if (_jspx_th_html_rewrite_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(34,88);to=(35,36)]
                                                out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 36,36-"/top.jsp" 36,90  LineMapIndex:35
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_13 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_13.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_13.setParent(null);
                                                _jspx_th_html_rewrite_13.setPage("/include/js/jquery.treeTable.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_13);
                                                  int _jspx_eval_html_rewrite_13 = _jspx_th_html_rewrite_13.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 36,36-"/top.jsp" 36,90  LineMapIndex:36
                                                  if (_jspx_th_html_rewrite_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(35,90);to=(36,36)]
                                                out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 37,36-"/top.jsp" 37,78  LineMapIndex:37
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_14 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_14.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_14.setParent(null);
                                                _jspx_th_html_rewrite_14.setPage("/include/js/ktnb.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_14);
                                                  int _jspx_eval_html_rewrite_14 = _jspx_th_html_rewrite_14.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 37,36-"/top.jsp" 37,78  LineMapIndex:38
                                                  if (_jspx_th_html_rewrite_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(36,78);to=(37,36)]
                                                out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 38,36-"/top.jsp" 38,88  LineMapIndex:39
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_15 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_15.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_15.setParent(null);
                                                _jspx_th_html_rewrite_15.setPage("/include/js/datatable.util.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_15);
                                                  int _jspx_eval_html_rewrite_15 = _jspx_th_html_rewrite_15.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 38,36-"/top.jsp" 38,88  LineMapIndex:40
                                                  if (_jspx_th_html_rewrite_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(37,88);to=(38,36)]
                                                out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 39,36-"/top.jsp" 39,85  LineMapIndex:41
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_16 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_16.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_16.setParent(null);
                                                _jspx_th_html_rewrite_16.setPage("/include/js/date.format.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_16);
                                                  int _jspx_eval_html_rewrite_16 = _jspx_th_html_rewrite_16.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 39,36-"/top.jsp" 39,85  LineMapIndex:42
                                                  if (_jspx_th_html_rewrite_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(38,85);to=(39,36)]
                                                out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 40,36-"/top.jsp" 40,86  LineMapIndex:43
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_17 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_17.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_17.setParent(null);
                                                _jspx_th_html_rewrite_17.setPage("/include/js/verticaltabs.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_17);
                                                  int _jspx_eval_html_rewrite_17 = _jspx_th_html_rewrite_17.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 40,36-"/top.jsp" 40,86  LineMapIndex:44
                                                  if (_jspx_th_html_rewrite_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(39,86);to=(40,36)]
                                                out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/top.jsp" 41,36-"/top.jsp" 41,91  LineMapIndex:45
                                                /* ------  html:rewrite ------ */
                                                org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_18 = new org.apache.struts.taglib.html.RewriteTag();
                                                _jspx_th_html_rewrite_18.setPageContext(pageContext);
                                                _jspx_th_html_rewrite_18.setParent(null);
                                                _jspx_th_html_rewrite_18.setPage("/include/js/verticaltabs.pack.js");
                                                _jspxTagObjects.push(_jspx_th_html_rewrite_18);
                                                  int _jspx_eval_html_rewrite_18 = _jspx_th_html_rewrite_18.doStartTag();
                                                // end
                                                // ##DEBUG## "/top.jsp" 41,36-"/top.jsp" 41,91  LineMapIndex:46
                                                  if (_jspx_th_html_rewrite_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(40,91);to=(58,10)]
                                                out.write("\"></script>\r\n<link rel='stylesheet' type='text/css' href='extjs/resources/css/ext-all.css' />\r\n<link rel='stylesheet' type='text/css' href='extjs/xtheme-gray-extend.css' />\r\n<link rel='stylesheet' type='text/css' href='extjs/examples/ux/css/RowEditor.css' />\r\n<link rel='stylesheet' type='text/css' href='extjs/examples/ux/css/Spinner.css' />\r\n<link rel='stylesheet' type='text/css' href='extjs/examples/ux/statusbar/css/statusbar.css' />\r\n<link rel='stylesheet' type='text/css' href='extjs/superboxselect.css' />\r\n<script type='text/javascript' src='extjs/adapter/ext/ext-base.js'></script>\r\n<script type='text/javascript' src='extjs/ext-all.js'></script>\r\n<script type='text/javascript' src='extjs/examples/ux/SearchField.js'></script>\r\n<script type='text/javascript' src='extjs/examples/ux/RowEditor.js'></script>\r\n<script type='text/javascript' src='extjs/examples/ux/CheckColumn.js'></script>\r\n<script type='text/javascript' src='extjs/examples/ux/Spinner.js'></script>\r\n<script type='text/javascript' src='extjs/examples/ux/SpinnerField.js'></script>\r\n<script type='text/javascript' src='extjs/examples/ux/statusbar/StatusBar.js'></script>\r\n<script type='text/javascript' src='extjs/SuperBoxSelect.js'></script>\r\n<script type='text/javascript' src='extjs/ext-ktnb.js'></script>\r\n<script>\r\n\t\tvar cuc=");

                                              // end
                                              // ##DEBUG## "/top.jsp" 59,13-"/top.jsp" 59,24  LineMapIndex:47
                                                out.print(ac.getCuc());
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(58,26);to=(59,14)]
                                                out.write(";\r\n\t\tvar tenNsd=\"");

                                              // end
                                              // ##DEBUG## "/top.jsp" 60,17-"/top.jsp" 60,31  LineMapIndex:48
                                                out.print(ac.getTenNsd());
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(59,33);to=(60,16)]
                                                out.write("\";\r\n\t\tvar tenPhong=\"");

                                              // end
                                              // ##DEBUG## "/top.jsp" 61,19-"/top.jsp" 61,35  LineMapIndex:49
                                                out.print(ac.getTenPhong());
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(60,37);to=(61,14)]
                                                out.write("\";\r\n\t\tvar tenCqt=\"");

                                              // end
                                              // ##DEBUG## "/top.jsp" 62,17-"/top.jsp" 62,31  LineMapIndex:50
                                                out.print(ac.getTenCqt());
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(61,33);to=(62,14)]
                                                out.write("\";\r\n\t\tvar tenCuc=\"");

                                              // end
                                              // ##DEBUG## "/top.jsp" 63,17-"/top.jsp" 63,31  LineMapIndex:51
                                                out.print(ac.getTenCuc());
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(62,33);to=(63,15)]
                                                out.write("\";\r\n\t\tvar maPhong=\"");

                                              // end
                                              // ##DEBUG## "/top.jsp" 64,18-"/top.jsp" 64,33  LineMapIndex:52
                                                out.print(ac.getMaPhong());
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(63,35);to=(64,13)]
                                                out.write("\";\r\n\t\tvar maCqt=\"");

                                              // end
                                              // ##DEBUG## "/top.jsp" 65,16-"/top.jsp" 65,29  LineMapIndex:53
                                                out.print(ac.getMaCqt());
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(64,31);to=(65,13)]
                                                out.write("\";\r\n\t\tvar maCuc=\"");

                                              // end
                                              // ##DEBUG## "/top.jsp" 66,16-"/top.jsp" 66,29  LineMapIndex:54
                                                out.print(ac.getMaCuc());
                                              // end
                                              // HTML // begin [file="/top.jsp";from=(65,31);to=(69,20)]
                                                out.write("\";\r\n\t</script>\r\n</head>\r\n<body>\r\n<div id=\"container\">");

                                              // end
                                              // HTML // begin [file="/ttkt/dung_chung/chi_tiet_noi_dung.jsp";from=(1,29);to=(10,0)]
                                                out.write("\r\n<style type=\"text/css\">\r\nspan.description {\r\n\tdisplay: inline-block;\r\n\toverflow: hidden;\r\n\twhite-space: nowrap;\r\n\twidth: 99%;\r\n}\r\n</style>\r\n");

                                              // end
                                              // ##DEBUG## ##TAGLIB## "/ttkt/dung_chung/chi_tiet_noi_dung.jsp" 11,0-"/ttkt/dung_chung/chi_tiet_noi_dung.jsp" 11,41  LineMapIndex:55
                                                /* ------  html:form ------ */
                                                org.apache.struts.taglib.html.FormTag _jspx_th_html_form_0 = new org.apache.struts.taglib.html.FormTag();
                                                _jspx_th_html_form_0.setPageContext(pageContext);
                                                _jspx_th_html_form_0.setParent(null);
                                                _jspx_th_html_form_0.setAction("chi_tiet_noi_dung.do");
                                                _jspxTagObjects.push(_jspx_th_html_form_0);
                                                  int _jspx_eval_html_form_0 = _jspx_th_html_form_0.doStartTag();
                                                  if (_jspx_eval_html_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                                                    do {
                                                    // end
                                                    // HTML // begin [file="/ttkt/dung_chung/chi_tiet_noi_dung.jsp";from=(10,41);to=(26,31)]
                                                      out.write("\r\n\t<fieldset style=\"margin: 0; width: 597; height: 530;\">\r\n\t<fieldset style=\"width: 100%; height: 10%; text-align: center;\"><legend> Thông tin tìm kiếm </legend>\r\n\t<table width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"9%\" align=\"right\">Mã</td>\r\n\t\t\t<td width=\"1%\"></td>\r\n\t\t\t<td width=\"20%\" align=\"left\"><input type=\"text\" id='ma' style=\"width: 100%\" onblur=\"search()\" onkeypress=\"if(!formatInt(event)) return false; return true\"></td>\r\n\t\t\t<td width=\"7%\" align=\"right\">Tên</td>\r\n\t\t\t<td width=\"1%\"></td>\r\n\t\t\t<td width=\"62%\" align=\"left\"><input type=\"text\" id='ten' onblur=\"search()\" width=\"100%\" style=\"width: 95%\"></td>\r\n\t\t</tr>\r\n\t</table>\r\n\t</fieldset>\r\n\t<fieldset style=\"width: 100%; height: 90%;\"><legend>Kết quả tìm kiếm</legend>\r\n\t<table width=\"576\" border=\"0\" height=\"30\" style=\"table-layout: fixed\">\r\n\t\t<tr class=\"TdHeaderList\" id=\"");

                                                    // end
                                                    // ##DEBUG## "/ttkt/dung_chung/chi_tiet_noi_dung.jsp" 27,34-"/ttkt/dung_chung/chi_tiet_noi_dung.jsp" 27,61  LineMapIndex:56
                                                      out.print(request.getAttribute("goc"));
                                                    // end
                                                    // HTML // begin [file="/ttkt/dung_chung/chi_tiet_noi_dung.jsp";from=(26,63);to=(32,68)]
                                                      out.write("\">\r\n\t\t\t<td width=\"11%\"><b>Mã</b></td>\r\n\t\t\t<td width=\"85%\"><b>Tên</b></td>\r\n\t\t\t<td width=\"4%\" align=\"center\"><INPUT type=\"checkbox\" onclick=\"selectAll(this.checked)\"></td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<div style=\"overflow: scroll; width: 100%; height: 435; margin: 0\">");

                                                    // end
                                                    // ##DEBUG## "/ttkt/dung_chung/chi_tiet_noi_dung.jsp" 33,71-"/ttkt/dung_chung/chi_tiet_noi_dung.jsp" 33,110  LineMapIndex:57
                                                      out.print(request.getAttribute("danhMucTtktTree"));
                                                    // end
                                                    // HTML // begin [file="/ttkt/dung_chung/chi_tiet_noi_dung.jsp";from=(32,112);to=(45,0)]
                                                      out.write("</div>\r\n\t</fieldset>\r\n\t</fieldset>\r\n\t<br>\r\n\t<fieldset style=\"margin: 0; width: 597\">\r\n\t<div align=\"center\" style=\"text-align: center; vertical-align: middle; height: 40\">\r\n\t<table align=\"center\" width=\"100%\" height=\"100%\">\r\n\t\t<tr valign=\"middle\">\r\n\t\t\t<td align=\"center\" valign=\"middle\"\"><INPUT type='button' class=\"button\" onclick='selectChiTietDanhMuc();' value='Chọn'> <INPUT type='button' class=\"button\" onclick='window.close();' value='Đóng'></td>\r\n\t\t</tr>\r\n\t</table>\r\n\t</div>\r\n\t</fieldset>\r\n");

                                                    // end
                                                    // ##DEBUG## "/ttkt/dung_chung/chi_tiet_noi_dung.jsp" 46,0-"/ttkt/dung_chung/chi_tiet_noi_dung.jsp" 46,12  LineMapIndex:58
                                                    } while (_jspx_th_html_form_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                  }
                                                  if (_jspx_th_html_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                              // end
                                              // HTML // begin [file="/ttkt/dung_chung/chi_tiet_noi_dung.jsp";from=(45,12);to=(515,9)]
                                                out.write("\r\n\r\n<!-- script cu -->\r\n<script language=\"javascript\">\r\n$(function(){\r\n    $('input').keydown(function(e){\r\n        if (e.keyCode == 13) {\r\n            search();\r\n            return false;\r\n        }\r\n    });\r\n});\r\nvar maDmGoc = getUrlParam('root');\r\nvar ma;\r\nvar ten;\r\nfunction search(){\r\n\tma = document.getElementById('ma').value;\r\n\tten = document.getElementById('ten').value;\t\r\n\t// Lay tat ca cac dong root\r\n\tvar allHiden = document.getElementsByName('parentId' + maDmGoc);\r\n\tfor(var i = 0; i < allHiden.length; i++){\r\n\t\tvar searchingNode = new treeNode(allHiden[i].parentNode.parentNode);\r\n\t\tsearchingNode.treeSearch();\r\n\t}\t\r\n\treFormatTable();\t\r\n}\r\nfunction checkTree(){\r\n\tvar treeLevel = 0;\r\n\twhile (document.getElementsByName(treeLevel) != null && document.getElementsByName(treeLevel).length > 0){\r\n\t\ttreeLevel++;\r\n\t}\t  \r\n\ttreeLevel--;\r\n\tvar parentList = '';\r\n\tfor(var lv = treeLevel; lv > 0; lv--){\r\n\t\tvar childList = document.getElementsByName(lv);\r\n\t\tfor(var i = 0; i< childList.length; i++){\r\n\t\t\tvar tn = new treeNode(childList[i].parentNode.parentNode);\r\n\t\t\tif(parentList.indexOf(tn.parentId + ',') < 0){\r\n\t\t\t\tvar parentNode = new treeNode(document.getElementById(tn.parentId));\r\n\t\t\t\tif(parentNode.isSelectAllChild())\r\n\t\t\t\t\tparentNode.setCheck(true);\r\n\t\t\t\tparentList += tn.parentId + ',';   \r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n}\r\n\t\r\nwindow.onload = function(){\r\n\treFormatTable();\r\n\tmethod = getUrlParam('method');\r\n\tif(method == 'chonChiTiet'){\r\n\t\tvar chiTietNoiDungDaChonId = window.opener.chiTietNoiDungDaChonId;\r\n\t\tfor(var i= 0; i< chiTietNoiDungDaChonId.length; i++){\t\t\t\r\n\t\t\tvar tn = new treeNode(document.getElementById(chiTietNoiDungDaChonId[i]));\r\n\t\t\ttn.setCheck(true);\r\n\t\t\tif(!tn.isRoot){\r\n\t\t\t\tvar parent = new treeNode(document.getElementById(tn.parentId));\r\n\t\t\t\tparent.setDisplay(false);\r\n\t\t\t\tparent.expand();\r\n\t\t\t}\r\n\t\t}\r\n\t\tcheckTree();\r\n\t\treturn;\r\n\t}\t\r\n\t// Mac dinh cac noi dung da chon\r\n\tchiTietNoiDungDaChonId = window.opener.chiTietNoiDungDaChonId;\r\n\tdsCacNoiDungDaChonId = window.opener.dsCacNoiDungDaChonId;\t\r\n\tvar root1;\r\n\tvar root2;\r\n\tfor(var i=0; i< dsCacNoiDungDaChonId.length; i++){\t\r\n\t\tif(dsCacNoiDungDaChonId[i].toString().substring(0,4)==\"1901\"){\t\t\t\r\n\t\t\troot1=true;\r\n\t\t}else if(dsCacNoiDungDaChonId[i].toString().substring(0,4)==\"1903\"){\t\t\t\r\n\t\t\troot2=true;\r\n\t\t}\r\n\t\tdocument.getElementById(dsCacNoiDungDaChonId[i]+'check').checked = true;\r\n\t\texpandThisNode(dsCacNoiDungDaChonId[i]);\r\n\t\tvar arrchiTietNoiDungDaChonId = chiTietNoiDungDaChonId[i].split(',');\r\n\t\tarrchiTietNoiDungDaChonId.unshift(dsCacNoiDungDaChonId[i]);\r\n\t\tfor(var j = 0; j< arrchiTietNoiDungDaChonId.length; j++){\t\t\r\n\t\t\tif(document.getElementById(arrchiTietNoiDungDaChonId[j])!=null){\r\n\t\t\tvar tn = new treeNode(document.getElementById(arrchiTietNoiDungDaChonId[j]));\r\n\t\t\ttn.setCheck(true);\r\n\t\t\tif(!tn.isRoot){\r\n\t\t\t\tvar parent = new treeNode(document.getElementById(tn.parentId));\r\n\t\t\t\tparent.setDisplay(false);\r\n\t\t\t\tparent.expand();\r\n\t\t\t}\t\t\t\r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n\tif(root1){\r\n\tvar parent = new treeNode(document.getElementById(1901));\r\n\t\t\t\tparent.setCheck(true);\r\n\t}\r\n\tif(root2){\r\n\tvar parent = new treeNode(document.getElementById(1903));\r\n\t\t\t\tparent.setCheck(true);\r\n\t}\r\n\tcheckTree();\r\n}\r\nfunction reFormatTable(){\r\n\tvar styleClass = 'row1';\r\n\tvar rows = document.getElementById(\"tblChiTietNoiDung\").rows;\r\n\tfor(var i = 0; i < rows.length; i++){\r\n\t\tif(rows[i].style.display == 'inline'){\r\n\t\t\trows[i].className  = styleClass;\r\n\t\t\tif(styleClass == 'row1')\r\n\t\t\t\tstyleClass = 'row2'\r\n\t\t\telse\r\n\t\t\t\tstyleClass = 'row1'\r\n\t\t}\t\t\r\n\t}\r\n\tvar numOfDisplay = 0;\r\n\tvar tblRows = document.getElementById('tblChiTietNoiDung').rows;\r\n\tfor(var i = 0; i< tblRows.length; i++){\r\n\t\tif(tblRows[i].style.display == 'inline')\r\n\t\t\tnumOfDisplay++;\r\n\t}\r\n\tdocument.getElementById('tblChiTietNoiDung').style.height = numOfDisplay*20;\r\n}\r\n \r\nfunction selectAll(isSelect){\t\r\n\tselectedIds = '';\t\r\n\tvar elements = document.getElementById('tblChiTietNoiDung').rows;\r\n\tfor(i = 0; i< elements.length; i++){\r\n\t\tif(elements[i].id != null && elements[i].id != ''){\r\n\t\t\ttn = new treeNode(elements[i]);\r\n\t\t\tif(tn.isEnable)\r\n\t\t\t\tdocument.getElementById(elements[i].id + 'check').checked = isSelect;\r\n\t\t\tif(isSelect){\t\t\t\t\r\n\t\t\t\tif(tn.isLeaf)\r\n\t\t\t\t\tselectedIds += tn.ma + ',';\r\n\t\t\t}\t\t\t\r\n\t\t}\t\t\t\r\n\t}\r\n\tif(isSelect)\r\n\t\tselectedIds = selectedIds.substring(0, selectedIds.length -1);\t\t\r\n}\r\nfunction selectItem(ma){\t\r\n\ttn = new treeNode(document.getElementById(ma));\r\n\tarrAffectedId = tn.click();\r\n\t// click node cha\r\n\tif(!tn.isRoot){\r\n\t\tvar parentNode = tn.getParent();\r\n\t\twhile(true){\r\n\t\t\tif(tn.checked){\r\n\t\t\t\tif(parentNode.isSelectAllChild()){\r\n\t\t\t\t\tparentNode.setCheck(true);\r\n\t\t\t\t}else{\r\n\t\t\t\t\tbreak;\r\n\t\t\t\t}\r\n\t\t\t}else{\r\n\t\t\t\tparentNode.setCheck(false);\r\n\t\t\t}\r\n\t\t\tif(parentNode.isRoot)\r\n\t\t\t\tbreak;\r\n\t\t\tparentNode = parentNode.getParent();\r\n\t\t}\r\n\t\t\r\n\t}\r\n\t\r\n\t// Lay danh sach cac phan tu duoc chon\r\n\tif(tn.checked){\r\n\t\tfor(var i =0; i< arrAffectedId.length; i++){\r\n\t\t\tif(selectedIds.indexOf(arrAffectedId[i]) < 0){\r\n\t\t\t\tif(selectedIds == '')\r\n\t\t\t\t\tselectedIds = arrAffectedId[i];\r\n\t\t\t\telse\r\n\t\t\t\t\tselectedIds += ',' + arrAffectedId[i];\r\n\t\t\t}\t\r\n\t\t}\r\n\t}else{\r\n\t\tfor(var i =0; i< arrAffectedId.length; i++){\r\n\t\t\tif(selectedIds.indexOf(arrAffectedId[i]) > 0)\r\n\t\t\t\tselectedIds = selectedIds.replace(',' + arrAffectedId[i], '');\r\n\t\t\telse if(selectedIds.indexOf(arrAffectedId[i]) == 0){\r\n\t\t\t\tif(selectedIds == arrAffectedId[i])\r\n\t\t\t\t\tselectedIds = '';\r\n\t\t\t\telse\r\n\t\t\t\t\tselectedIds = selectedIds.replace(arrAffectedId[i] + ',', '');\t\t\t\t\r\n\t\t\t}\r\n\t\t\t\t\r\n\t\t}\r\n\t}\r\n\treFormatTable();\r\n\t\r\n\t\r\n}\r\nfunction expandThisNode(ma){\r\n\tvar tn = new treeNode(document.getElementById(ma));\r\n\tif(tn.isLeaf)\r\n\t\treturn;\r\n\ttn.expand();\r\n}\r\nfunction treeNode(theRow){\t\r\n\t// Property\r\n\t// Read only\r\n\tthis.tr =theRow;\r\n\tthis.ma = theRow.id;\t\r\n\tthis.name = theRow.title;\r\n\tthis.parentId = theRow.cells[0].childNodes[0].name.substr(8);\t\r\n\tthis.isRoot = (this.parentId == maDmGoc);\r\n\tthis.isLeaf = document.getElementById(this.ma + '-') == null;\r\n\tthis.level = theRow.cells[0].childNodes[1].name;\t\r\n\t\r\n\t// Use\r\n\tthis.isExpand = !this.isLeaf && document.getElementById(this.ma + '-').style.display == 'inline';\r\n\tthis.checked = document.getElementById(this.ma + 'check').checked;\r\n\tthis.isEnable = theRow.cells[0].childNodes[0].id=='enable'? true: false;\r\n\t\r\n\t// Method\r\n\tthis.setDisplay = setDisplay;\r\n\tthis.setEnable = setEnable;\r\n\tthis.setCheck = setCheck;\r\n\tthis.getChilds = getChilds;\r\n\tthis.getSelectedChildIds = getSelectedChildIds;\r\n\tthis.expand = expand;\t\t\t\t\r\n\tthis.click = click;\r\n\tthis.setEnable = setEnable;\r\n\tthis.enableAndDisplayOnlyMe = enableAndDisplayOnlyMe;\r\n\tthis.enableOnlyMe = enableOnlyMe;\r\n\tthis.displayOnlyMe = displayOnlyMe;\r\n\tthis.treeSearch = treeSearch;\r\n\tthis.isSelectAllChild = isSelectAllChild;\r\n\tthis.unSelectAllChild = unSelectAllChild;\r\n\tthis.getParent = getParent;\r\n\t\r\n}\r\nfunction getParent(){\r\n\tif(this.isRoot)\r\n\t\treturn null;\r\n\treturn new treeNode(document.getElementById(this.parentId))\r\n}\r\nfunction isSelectAllChild(){\r\n\tvar allChilds = this.getChilds();\r\n\tfor(var i = 0; i< allChilds.length; i++){\r\n\t\tif(!allChilds[i].checked)\r\n\t\t\treturn false;\r\n\t}\r\n\treturn true;\r\n}\r\nfunction unSelectAllChild(){\r\n\tvar allChilds = this.getChilds();\r\n\tfor(var i = 0; i< allChilds.length; i++){\r\n\t\tif(allChilds[i].checked)\r\n\t\t\treturn false;\r\n\t}\r\n\treturn true;\r\n}\r\nfunction setDisplay(isDisplay){\r\n\tthis.isExpand = isDisplay;\r\n\tdocument.getElementById(this.ma + '-').style.display = isDisplay?'inline':'none';\r\n\tdocument.getElementById(this.ma + '+').style.display = isDisplay?'none':'inline';\r\n}\r\nfunction setCheck(isChecked){\r\n\tthis.checked = isChecked; \r\n\tdocument.getElementById(this.ma + 'check').checked = isChecked;\r\n}\r\nfunction setEnable(isEnable){\r\n\tthis.isEnable = isEnable;\r\n\tthis.tr.cells[0].childNodes[0].id==isEnable? 'enable': 'disable';\r\n}\r\n\r\nfunction getSelectedChildIds(){\t\r\n\tif(this.isLeaf)\r\n\t\treturn '';\r\n\tvar childList = this.getChilds();\r\n\tvar reval = '';\r\n\tfor(var i = 0; i< childList.length; i++){\r\n\t\tif(childList[i].isLeaf){\r\n\t\t\tif(childList[i].checked)\r\n\t\t\t\treval += childList[i].ma + ',';\t\t\t\t\r\n\t\t}else{\r\n\t\t\tvar temp = childList[i].getSelectedChildIds();\r\n\t\t\tif(!isEmpty(temp))\r\n\t\t\t\treval += temp + ',';\r\n\t\t}\r\n\t}\r\n\tif(reval != '')\r\n\t\treval = reval.substring(0, reval.length -1);\t\r\n\treturn reval;\t\r\n}\r\nfunction enableOnlyMe(isTrue){\r\n\tthis.tr.cells[0].childNodes[0].id = isTrue?\"enable\":\"disable\";\r\n\t//this.tr.style.display = isTrue?\"inline\":\"none\";\r\n}\r\nfunction displayOnlyMe(isTrue){\r\n\tthis.tr.style.display = isTrue?\"inline\":\"none\";\r\n\tif(!this.isLeaf){\r\n\t\tdocument.getElementById(this.ma + '-').style.display = isTrue?\"inline\":\"none\";\r\n\t\tdocument.getElementById(this.ma + '+').style.display = isTrue?\"none\":\"inline\";\r\n\t}\t\r\n}\r\nfunction enableAndDisplayOnlyMe(isTrue){\r\n\tthis.tr.cells[0].childNodes[0].id = isTrue?\"enable\":\"disable\";\r\n\tthis.tr.style.display = isTrue?\"inline\":\"none\";\r\n\tif(!this.isLeaf){\r\n\t\tdocument.getElementById(this.ma + '-').style.display = isTrue?\"inline\":\"none\";\r\n\t\tdocument.getElementById(this.ma + '+').style.display = isTrue?\"none\":\"inline\";\r\n\t}\r\n\t\r\n}\r\nfunction treeSearch(){\r\n\tif(((isEmpty(ma)) || (this.ma.indexOf(ma) >= 0))&&((isEmpty(ten))||(this.name.toLowerCase().indexOf(ten.toLowerCase()) >=0 ))){//Thoa man dieu kien tk\r\n\t\t//this.enableAndDisplayOnlyMe(true);\r\n\t\tthis.setEnable(true);\r\n\t\treturn true;\r\n\t}else{\r\n\t\tvar bReturn = false;\r\n\t\tif(!this.isLeaf){\r\n\t\t\tvar childList = this.getChilds();\t\t\t\t\t\t\t\r\n\t\t\tfor(var i = 0; i< childList.length; i++){\r\n\t\t\t\tif(childList[i].treeSearch()){\r\n\t\t\t\t\tif(!bReturn)\r\n\t\t\t\t\t\tbReturn = true;\r\n\t\t\t\t}\r\n\t\t\t\t\t\r\n\t\t\t}\r\n\t\t}\t\t\r\n\t\tthis.enableAndDisplayOnlyMe(bReturn);\r\n\t\treturn bReturn;\r\n\t}\r\n}\r\nfunction setEnable(enb){\t\r\n\tthis.tr.cells[0].childNodes[0].id = enb?\"enable\":\"disable\";\r\n\tthis.tr.style.display = enb?\"inline\":\"none\";\r\n\tif(!this.isLeaf){\r\n\t\tdocument.getElementById(this.ma + '-').style.display = enb?\"inline\":\"none\";\r\n\t\tdocument.getElementById(this.ma + '+').style.display = enb?\"none\":\"inline\";\r\n\t}\r\n\t\r\n\tif(this.isLeaf)\r\n\t\treturn;\r\n\tvar childList = this.getChilds()\r\n\tfor(var i = 0; i < childList.length; i++){\r\n\t\tchildList[i].setEnable(enb);\r\n\t}\r\n}\r\nvar selectedIds = '';\r\nfunction click(){\r\n\tif(this.isLeaf) \r\n\t\treturn new Array(this.ma);\r\n\tdocument.getElementById(this.ma + '-').style.display = 'inline';\r\n\tdocument.getElementById(this.ma + '+').style.display = 'none';\r\n\tvar reval = new Array();\r\n\tvar childList = this.getChilds();\r\n\tif(childList != null){\r\n\t\tfor(var i = 0; i< childList.length; i++){\r\n\t\t\tif(childList[i].isEnable){\r\n\t\t\t\tdocument.getElementById(childList[i].ma + 'check').checked = this.checked;\t\r\n\t\t\t\tchildList[i].tr.style.display = 'inline';\t\r\n\t\t\t\tchildList[i].checked = this.checked;\t\t\r\n\t\t\t\tif(childList[i].isLeaf)\r\n\t\t\t\t\treval.push(childList[i].ma);\r\n\t\t\t\telse\r\n\t\t\t\t\treval = reval.concat(childList[i].click());\r\n\t\t\t}\r\n\t\t\t\t\t\t\t\t\t\r\n\t\t}\r\n\t}\t\t\t\r\n\treturn reval;\t\r\n}\r\nfunction getChilds(){\r\n\tif(this.isLeaf)\r\n\t\treturn null;\r\n\tvar arrReturn = new Array();\r\n\tvar allHiddenField = document.getElementsByName('parentId' + this.ma);\t\t\r\n\tfor(var i = 0; i< allHiddenField.length; i++){\r\n\t\t//if(allHiddenField[i].nodeName != 'tr' && allHiddenField[i].nodeName != 'TR')\r\n\t\t\tarrReturn.push(new treeNode(allHiddenField[i].parentNode.parentNode))\t\r\n\t\t\t\r\n\t}\t\t\r\n\treturn arrReturn;\r\n}\r\nfunction expand(){\r\n\tif(this.isLeaf)\r\n\t\treturn;\r\n\tif(this.isExpand){// Dang mo\r\n\t\t// Doi dau - thanh dau +\r\n\t\tdocument.getElementById(this.ma + '+').style.display = 'inline';\r\n\t\tdocument.getElementById(this.ma + '-').style.display = 'none';\r\n\t\tvar allTr = document.getElementsByTagName('tr');\r\n\t\tfor(var i = 0; i< allTr.length; i++){\r\n\t\t\tif(allTr[i].id.indexOf(this.ma) == 0 && allTr[i].id != this.ma)\r\n\t\t\t\tallTr[i].style.display = 'none';\r\n\t\t\t\t\r\n\t\t}\r\n\t}else{// Dang dong\r\n\t\tdocument.getElementById(this.ma + '-').style.display = 'inline';\r\n\t\tdocument.getElementById(this.ma + '+').style.display = 'none';\r\n\t\t// Mo node con\r\n\t\tvar allChilds = this.getChilds();\r\n\t\tfor(var i = 0; i< allChilds.length; i++){\r\n\t\t\tif(allChilds[i].isEnable){\r\n\t\t\t\tallChilds[i].tr.style.display = 'inline';\r\n\t\t\t\tif(!allChilds[i].isLeaf && allChilds[i].isExpand){\r\n\t\t\t\t\tshowChilds(allChilds[i]);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n\treFormatTable();\r\n\t\r\n}\r\nfunction showChilds(element){\r\n\tvar allChilds = element.getChilds();\r\n\tfor(var i = 0; i< allChilds.length; i++){\r\n\t\tif(allChilds[i].isEnable){\r\n\t\t\tallChilds[i].tr.style.display = 'inline';\r\n\t\t\tif(!allChilds[i].isLeaf && allChilds[i].isExpand){\r\n\t\t\t\tshowChilds(allChilds[i]);\r\n\t\t\t}\r\n\t\t}\t\t\r\n\t}\r\n}\r\n\r\nfunction getAllRoot(){\r\n\tvar arrRoot = new Array();\r\n\tvar allHidden = document.getElementsByName('parentId' + 1901);\r\n\tfor(var i = 0; i< allHidden.length; i++){\r\n\t\tarrRoot.push(new treeNode(allHidden[i].parentNode.parentNode));\t\r\n\t}\r\n\tvar allHidden = document.getElementsByName('parentId' + 1903);\r\n\tfor(var i = 0; i< allHidden.length; i++){\r\n\t\tarrRoot.push(new treeNode(allHidden[i].parentNode.parentNode));\t\r\n\t}\r\n\treturn arrRoot;\r\n}\r\nfunction selectChiTietDanhMuc(){\r\n\tmethod = getUrlParam('method');\r\n\tif(method == 'chonChiTiet'){\r\n\t\tvar selectedIds = select123();\r\n\t\tif(!isEmpty(selectedIds))\r\n\t\t\twindow.opener.selectChiTietDanhMuc(selectedIds);\t\r\n\t\twindow.close();\r\n\t\treturn;\r\n\t}\t\r\n\tvar arrReturn = new Array();\r\n\tvar allRoot = getAllRoot();\r\n\tfor(var i = 0; i< allRoot.length; i++ ){\r\n\t\tvar selectedChildIds = allRoot[i].getSelectedChildIds();\r\n\t\tif(allRoot[i].checked || selectedChildIds != ''){\r\n\t\t\tarrReturn.push(new returnTree(allRoot[i], selectedChildIds));\r\n\t\t}\r\n\t}\r\n\tif(arrReturn.length ==0){\r\n\t\talert('Bạn chưa chọn bản ghi nào!');\r\n\t\treturn;\r\n\t}\t\r\n\twindow.opener.chonDanhMucGoc(arrReturn);\t\r\n\twindow.close();\r\n}\r\nfunction returnTree(tn, selectedChildChildIds){\r\n\tthis.ma = tn.ma;\r\n\tthis.name = tn.name;\r\n\tthis.selectedChildIds = selectedChildChildIds;\r\n}\r\nfunction select123(){\r\n\tvar reVal = '';\r\n\tvar allTblRows = document.getElementById('tblChiTietNoiDung').rows;\r\n\tfor(var i = 0; i< allTblRows.length; i++){\r\n\t\tvar tn = new treeNode(allTblRows[i]);\r\n\t\tif(tn.isLeaf && tn.checked)\r\n\t\t\treVal += allTblRows[i].id + ',';\t\t\t\r\n\t}\r\n\tif(reVal != '')\r\n\t\treVal = reVal.substring(0, reVal.length -1);\t\r\n\treturn reVal;\t\r\n}\r\n</script>");

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
                                          "/ttkt/dung_chung/chi_tiet_noi_dung.jsp", 
                                          "/top.jsp", 
                                          },
                                          {
                                          "0", 
                                          "1", 
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
                                          "20", 
                                          "20", 
                                          "22", 
                                          "22", 
                                          "23", 
                                          "23", 
                                          "24", 
                                          "24", 
                                          "25", 
                                          "25", 
                                          "28", 
                                          "28", 
                                          "29", 
                                          "29", 
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
                                          "59", 
                                          "60", 
                                          "61", 
                                          "62", 
                                          "63", 
                                          "64", 
                                          "65", 
                                          "66", 
                                          "11", 
                                          "27", 
                                          "33", 
                                          "46", 
                                          },
                                          };
                                        }
