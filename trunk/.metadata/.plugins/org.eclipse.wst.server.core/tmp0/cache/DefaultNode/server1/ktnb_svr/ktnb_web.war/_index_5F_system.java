package org.apache.jsp;

import cmc.com.ktnb.util.KtnbUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _index_5F_system extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _index_5F_system( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/index_system.jsp";

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
                                                  response.setContentType("text/html; charset=UTF-8");
                                                  pageContext = _jspxFactory.getPageContext(this, request, response,
                                                  			"", true, 8192, true);

                                                  application = pageContext.getServletContext();
                                                  config = pageContext.getServletConfig();
                                                  session = pageContext.getSession();
                                                  out = pageContext.getOut();

                                                  /* Service Method Phase */

                                                  // HTML // begin [file="/index_system.jsp";from=(0,0);to=(1,0)]
                                                    out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"> \r\n");

                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(1,59);to=(2,0)]
                                                    out.write("\r\n");

                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(2,57);to=(3,0)]
                                                    out.write("\r\n");

                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(3,57);to=(4,0)]
                                                    out.write("\r\n");

                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(4,47);to=(5,0)]
                                                    out.write(" \r\n");

                                                  // end
                                                  // ##DEBUG## ##SCRIPTLET## "/index_system.jsp" 6,2-"/index_system.jsp" 11,0  LineMapIndex:1
                                                    
                                                    	request.setCharacterEncoding("UTF-8");
                                                    	response.setContentType("text/html;charset=UTF-8");
                                                    	cmc.com.ktnb.util.ApplicationContext ac = (cmc.com.ktnb.util.ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
                                                    	if (ac == null) {
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(10,2);to=(11,0)]
                                                    out.write("\r\n");

                                                  // end
                                                  // ##DEBUG## "/index_system.jsp" 12,0-"/index_system.jsp" 12,31  LineMapIndex:7
                                                    if (true) {
                                                      out.clear();
                                                      String _jspx_qfStr = "";
                                                      pageContext.forward("login.do" +  _jspx_qfStr);
                                                      return;
                                                    }
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(11,31);to=(12,0)]
                                                    out.write("\r\n");

                                                  // end
                                                  // ##DEBUG## ##SCRIPTLET## "/index_system.jsp" 13,2-"/index_system.jsp" 13,3  LineMapIndex:8
                                                    }
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(12,5);to=(15,0)]
                                                    out.write("\r\n<html>\r\n<head>\r\n");

                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(15,86);to=(20,49)]
                                                    out.write("\r\n<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\" />\r\n<META HTTP-EQUIV=\"Cache-Control\" CONTENT=\"no-cache, no-store, must-revalidate\">\r\n<META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\r\n<META HTTP-EQUIV=\"Expires\" CONTENT=\"0\">\r\n<link rel=\"shortcut icon\" type=\"image/ico\" href=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 21,49-"/index_system.jsp" 21,90  LineMapIndex:9
                                                    _jspx_th_html_rewrite_0.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_0.setParent(null);
                                                    _jspx_th_html_rewrite_0.setPage("/image/favicon.ico");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_0);
                                                      int _jspx_eval_html_rewrite_0 = _jspx_th_html_rewrite_0.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 21,49-"/index_system.jsp" 21,90  LineMapIndex:10
                                                      if (_jspx_th_html_rewrite_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(20,90);to=(22,28)]
                                                    out.write("\" />\r\n<title>HỆ THỐNG KIỂM TRA NỘI BỘ</title>\r\n<link type=\"text/css\" href=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 23,28-"/index_system.jsp" 23,71  LineMapIndex:11
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_1 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_1.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_1.setParent(null);
                                                    _jspx_th_html_rewrite_1.setPage("/stylesheet/ktnb.css");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_1);
                                                      int _jspx_eval_html_rewrite_1 = _jspx_th_html_rewrite_1.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 23,28-"/index_system.jsp" 23,71  LineMapIndex:12
                                                      if (_jspx_th_html_rewrite_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(22,71);to=(23,28)]
                                                    out.write("\" rel=\"stylesheet\">\r\n<link type=\"text/css\" href=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 24,28-"/index_system.jsp" 24,81  LineMapIndex:13
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_2 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_2.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_2.setParent(null);
                                                    _jspx_th_html_rewrite_2.setPage("/stylesheet/base/jquery-ui.css");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_2);
                                                      int _jspx_eval_html_rewrite_2 = _jspx_th_html_rewrite_2.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 24,28-"/index_system.jsp" 24,81  LineMapIndex:14
                                                      if (_jspx_th_html_rewrite_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(23,81);to=(24,34)]
                                                    out.write("\" rel=\"stylesheet\">\r\n<!--  <link type=\"text/css\" href=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 25,34-"/index_system.jsp" 25,94  LineMapIndex:15
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_3 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_3.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_3.setParent(null);
                                                    _jspx_th_html_rewrite_3.setPage("/stylesheet/base/jquery.treeTable.css");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_3);
                                                      int _jspx_eval_html_rewrite_3 = _jspx_th_html_rewrite_3.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 25,34-"/index_system.jsp" 25,94  LineMapIndex:16
                                                      if (_jspx_th_html_rewrite_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(24,94);to=(25,28)]
                                                    out.write("\" rel=\"stylesheet\">\t-->\r\n<link type=\"text/css\" href=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 26,28-"/index_system.jsp" 26,79  LineMapIndex:17
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_4 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_4.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_4.setParent(null);
                                                    _jspx_th_html_rewrite_4.setPage("/stylesheet/verticaltabs.css");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_4);
                                                      int _jspx_eval_html_rewrite_4 = _jspx_th_html_rewrite_4.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 26,28-"/index_system.jsp" 26,79  LineMapIndex:18
                                                      if (_jspx_th_html_rewrite_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(25,79);to=(28,36)]
                                                    out.write("\" rel=\"stylesheet\">\r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"include/js/themes/default/easyui.css\">\r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"include/js/themes/icon.css\">\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 29,36-"/index_system.jsp" 29,90  LineMapIndex:19
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_5 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_5.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_5.setParent(null);
                                                    _jspx_th_html_rewrite_5.setPage("/include/js/jquery-1.4.2.min.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_5);
                                                      int _jspx_eval_html_rewrite_5 = _jspx_th_html_rewrite_5.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 29,36-"/index_system.jsp" 29,90  LineMapIndex:20
                                                      if (_jspx_th_html_rewrite_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(28,90);to=(29,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 30,36-"/index_system.jsp" 30,91  LineMapIndex:21
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_6 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_6.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_6.setParent(null);
                                                    _jspx_th_html_rewrite_6.setPage("/include/js/jquery.easyui.min.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_6);
                                                      int _jspx_eval_html_rewrite_6 = _jspx_th_html_rewrite_6.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 30,36-"/index_system.jsp" 30,91  LineMapIndex:22
                                                      if (_jspx_th_html_rewrite_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(29,91);to=(30,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 31,36-"/index_system.jsp" 31,100  LineMapIndex:23
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_7 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_7.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_7.setParent(null);
                                                    _jspx_th_html_rewrite_7.setPage("/include/js/jquery-ui-1.8.2.custom.min.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_7);
                                                      int _jspx_eval_html_rewrite_7 = _jspx_th_html_rewrite_7.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 31,36-"/index_system.jsp" 31,100  LineMapIndex:24
                                                      if (_jspx_th_html_rewrite_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(30,100);to=(31,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 32,36-"/index_system.jsp" 32,95  LineMapIndex:25
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_8 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_8.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_8.setParent(null);
                                                    _jspx_th_html_rewrite_8.setPage("/include/js/jquery.dataTables.min.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_8);
                                                      int _jspx_eval_html_rewrite_8 = _jspx_th_html_rewrite_8.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 32,36-"/index_system.jsp" 32,95  LineMapIndex:26
                                                      if (_jspx_th_html_rewrite_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(31,95);to=(32,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 33,36-"/index_system.jsp" 33,95  LineMapIndex:27
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_9 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_9.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_9.setParent(null);
                                                    _jspx_th_html_rewrite_9.setPage("/include/js/jquery.jeditable.mini.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_9);
                                                      int _jspx_eval_html_rewrite_9 = _jspx_th_html_rewrite_9.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 33,36-"/index_system.jsp" 33,95  LineMapIndex:28
                                                      if (_jspx_th_html_rewrite_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(32,95);to=(33,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 34,36-"/index_system.jsp" 34,101  LineMapIndex:29
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_10 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_10.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_10.setParent(null);
                                                    _jspx_th_html_rewrite_10.setPage("/include/js/jquery.ui.datepicker-vi.min.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_10);
                                                      int _jspx_eval_html_rewrite_10 = _jspx_th_html_rewrite_10.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 34,36-"/index_system.jsp" 34,101  LineMapIndex:30
                                                      if (_jspx_th_html_rewrite_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(33,101);to=(34,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 35,36-"/index_system.jsp" 35,89  LineMapIndex:31
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_11 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_11.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_11.setParent(null);
                                                    _jspx_th_html_rewrite_11.setPage("/include/js/jquery.jixedbar.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_11);
                                                      int _jspx_eval_html_rewrite_11 = _jspx_th_html_rewrite_11.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 35,36-"/index_system.jsp" 35,89  LineMapIndex:32
                                                      if (_jspx_th_html_rewrite_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(34,89);to=(35,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 36,36-"/index_system.jsp" 36,88  LineMapIndex:33
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_12 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_12.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_12.setParent(null);
                                                    _jspx_th_html_rewrite_12.setPage("/include/js/jquery.hotkeys.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_12);
                                                      int _jspx_eval_html_rewrite_12 = _jspx_th_html_rewrite_12.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 36,36-"/index_system.jsp" 36,88  LineMapIndex:34
                                                      if (_jspx_th_html_rewrite_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(35,88);to=(36,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 37,36-"/index_system.jsp" 37,90  LineMapIndex:35
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_13 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_13.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_13.setParent(null);
                                                    _jspx_th_html_rewrite_13.setPage("/include/js/jquery.treeTable.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_13);
                                                      int _jspx_eval_html_rewrite_13 = _jspx_th_html_rewrite_13.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 37,36-"/index_system.jsp" 37,90  LineMapIndex:36
                                                      if (_jspx_th_html_rewrite_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(36,90);to=(37,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 38,36-"/index_system.jsp" 38,78  LineMapIndex:37
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_14 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_14.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_14.setParent(null);
                                                    _jspx_th_html_rewrite_14.setPage("/include/js/ktnb.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_14);
                                                      int _jspx_eval_html_rewrite_14 = _jspx_th_html_rewrite_14.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 38,36-"/index_system.jsp" 38,78  LineMapIndex:38
                                                      if (_jspx_th_html_rewrite_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(37,78);to=(38,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 39,36-"/index_system.jsp" 39,88  LineMapIndex:39
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_15 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_15.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_15.setParent(null);
                                                    _jspx_th_html_rewrite_15.setPage("/include/js/datatable.util.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_15);
                                                      int _jspx_eval_html_rewrite_15 = _jspx_th_html_rewrite_15.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 39,36-"/index_system.jsp" 39,88  LineMapIndex:40
                                                      if (_jspx_th_html_rewrite_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(38,88);to=(39,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 40,36-"/index_system.jsp" 40,85  LineMapIndex:41
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_16 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_16.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_16.setParent(null);
                                                    _jspx_th_html_rewrite_16.setPage("/include/js/date.format.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_16);
                                                      int _jspx_eval_html_rewrite_16 = _jspx_th_html_rewrite_16.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 40,36-"/index_system.jsp" 40,85  LineMapIndex:42
                                                      if (_jspx_th_html_rewrite_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(39,85);to=(40,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 41,36-"/index_system.jsp" 41,86  LineMapIndex:43
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_17 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_17.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_17.setParent(null);
                                                    _jspx_th_html_rewrite_17.setPage("/include/js/verticaltabs.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_17);
                                                      int _jspx_eval_html_rewrite_17 = _jspx_th_html_rewrite_17.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 41,36-"/index_system.jsp" 41,86  LineMapIndex:44
                                                      if (_jspx_th_html_rewrite_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(40,86);to=(41,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 42,36-"/index_system.jsp" 42,91  LineMapIndex:45
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_18 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_18.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_18.setParent(null);
                                                    _jspx_th_html_rewrite_18.setPage("/include/js/verticaltabs.pack.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_18);
                                                      int _jspx_eval_html_rewrite_18 = _jspx_th_html_rewrite_18.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 42,36-"/index_system.jsp" 42,91  LineMapIndex:46
                                                      if (_jspx_th_html_rewrite_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(41,91);to=(58,36)]
                                                    out.write("\"></script>\r\n<link rel='stylesheet' type='text/css' href='extjs/resources/css/ext-all.css' />\r\n<link rel='stylesheet' type='text/css' href='extjs/xtheme-gray-extend.css' />\r\n<link rel='stylesheet' type='text/css' href='extjs/examples/ux/css/RowEditor.css' />\r\n<link rel='stylesheet' type='text/css' href='extjs/examples/ux/css/Spinner.css' />\r\n<link rel='stylesheet' type='text/css' href='extjs/examples/ux/statusbar/css/statusbar.css' />\r\n<link rel='stylesheet' type='text/css' href='extjs/superboxselect.css' />\r\n<script type='text/javascript' src='extjs/adapter/ext/ext-base-debug.js'></script>\r\n<script type='text/javascript' src='extjs/ext-all-debug.js'></script>\r\n<script type='text/javascript' src='extjs/examples/ux/SearchField.js'></script>\r\n<script type='text/javascript' src='extjs/examples/ux/RowEditor.js'></script>\r\n<script type='text/javascript' src='extjs/examples/ux/CheckColumn.js'></script>\r\n<script type='text/javascript' src='extjs/examples/ux/Spinner.js'></script>\r\n<script type='text/javascript' src='extjs/examples/ux/SpinnerField.js'></script>\r\n<script type='text/javascript' src='extjs/examples/ux/statusbar/StatusBar.js'></script>\r\n<script type='text/javascript' src='extjs/SuperBoxSelect.js'></script>\r\n<script type='text/javascript' src='extjs/ext-ktnb.js'></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 59,36-"/index_system.jsp" 59,92  LineMapIndex:47
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_19 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_19.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_19.setParent(null);
                                                    _jspx_th_html_rewrite_19.setPage("/include/js/jquery.pngFix.pack.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_19);
                                                      int _jspx_eval_html_rewrite_19 = _jspx_th_html_rewrite_19.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 59,36-"/index_system.jsp" 59,92  LineMapIndex:48
                                                      if (_jspx_th_html_rewrite_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(58,92);to=(59,36)]
                                                    out.write("\"></script>\r\n<script type=\"text/javascript\" src=\"");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/index_system.jsp" 60,36-"/index_system.jsp" 60,84  LineMapIndex:49
                                                    /* ------  html:rewrite ------ */
                                                    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_20 = new org.apache.struts.taglib.html.RewriteTag();
                                                    _jspx_th_html_rewrite_20.setPageContext(pageContext);
                                                    _jspx_th_html_rewrite_20.setParent(null);
                                                    _jspx_th_html_rewrite_20.setPage("/include/js/pluginpage.js");
                                                    _jspxTagObjects.push(_jspx_th_html_rewrite_20);
                                                      int _jspx_eval_html_rewrite_20 = _jspx_th_html_rewrite_20.doStartTag();
                                                    // end
                                                    // ##DEBUG## "/index_system.jsp" 60,36-"/index_system.jsp" 60,84  LineMapIndex:50
                                                      if (_jspx_th_html_rewrite_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(59,84);to=(61,10)]
                                                    out.write("\"></script>\r\n<script>\r\n\t\tvar cuc=");

                                                  // end
                                                  // ##DEBUG## "/index_system.jsp" 62,13-"/index_system.jsp" 62,24  LineMapIndex:51
                                                    out.print(ac.getCuc());
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(61,26);to=(62,14)]
                                                    out.write(";\r\n\t\tvar tenNsd=\"");

                                                  // end
                                                  // ##DEBUG## "/index_system.jsp" 63,17-"/index_system.jsp" 63,31  LineMapIndex:52
                                                    out.print(ac.getTenNsd());
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(62,33);to=(63,16)]
                                                    out.write("\";\r\n\t\tvar tenPhong=\"");

                                                  // end
                                                  // ##DEBUG## "/index_system.jsp" 64,19-"/index_system.jsp" 64,35  LineMapIndex:53
                                                    out.print(ac.getTenPhong());
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(63,37);to=(64,14)]
                                                    out.write("\";\r\n\t\tvar tenCqt=\"");

                                                  // end
                                                  // ##DEBUG## "/index_system.jsp" 65,17-"/index_system.jsp" 65,31  LineMapIndex:54
                                                    out.print(ac.getTenCqt());
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(64,33);to=(65,14)]
                                                    out.write("\";\r\n\t\tvar tenCuc=\"");

                                                  // end
                                                  // ##DEBUG## "/index_system.jsp" 66,17-"/index_system.jsp" 66,31  LineMapIndex:55
                                                    out.print(ac.getTenCuc());
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(65,33);to=(66,15)]
                                                    out.write("\";\r\n\t\tvar maPhong=\"");

                                                  // end
                                                  // ##DEBUG## "/index_system.jsp" 67,18-"/index_system.jsp" 67,33  LineMapIndex:56
                                                    out.print(ac.getMaPhong());
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(66,35);to=(67,13)]
                                                    out.write("\";\r\n\t\tvar maCqt=\"");

                                                  // end
                                                  // ##DEBUG## "/index_system.jsp" 68,16-"/index_system.jsp" 68,29  LineMapIndex:57
                                                    out.print(ac.getMaCqt());
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(67,31);to=(68,13)]
                                                    out.write("\";\r\n\t\tvar maCuc=\"");

                                                  // end
                                                  // ##DEBUG## "/index_system.jsp" 69,16-"/index_system.jsp" 69,29  LineMapIndex:58
                                                    out.print(ac.getMaCuc());
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(68,31);to=(92,37)]
                                                    out.write("\";\r\n\t</script>\r\n</head>\r\n<body style=\"text-align: center;\">\r\n<div id=\"container\"><script>\r\n$(function() \r\n{\r\n  //$(\"#ktnb-bar\").jixedbar();\r\n  //$(\"#text_display\").html(day+\",\"+date_transaction);\r\n  $('#container').pngFix( );\r\n});\r\n</script>\r\n<div id=\"topbar\">     \r\n<div class=\"item\"><a href=\"index.do\" onclick=\"window.location='index.do';\"><img src=\"image/home.png\" alt=\"\" />Trang chủ</a></div>\r\n<div class=\"item\"><a href=\"ftp://ftp.tct.vn/Public/VPTCT/KTNB/Tailieudaotao.rar\"><img src=\"image/information.png\" alt=\"\" />Trợ giúp</a></div>\r\n<div class=\"item\"><a href=\"index_kntc.do\"><img src=\"image/blogs.png\" alt=\"\" />Khiếu nại tố cáo</a></div>\r\n<div class=\"item\"><a href=\"ttkt_index.do\"><img src=\"image/feed.png\" alt=\"\" />Kiểm tra nội bộ</a></div>\r\n<div class=\"item\"><a href=\"index_report.do\"><img src=\"image/report2.png\" alt=\"\" />Báo cáo</a></div>\r\n<div class=\"item\"><a href=\"index_ttcp.do\"><img src=\"image/report2.png\" alt=\"\" />Báo cáo TTCP</a></div>\r\n<div class=\"item\"><a href=\"index_system.do\"><img src=\"image/system.png\" alt=\"\" />Hệ thống</a></div>\r\n<div class=\"item\"><a href=\"pass.do\"><img src=\"image/password.png\" alt=\"\" />Đổi MK</a></div>\r\n<div class=\"item\"><a href=\"thoat.do\" onclick=\"window.location='thoat.do';\"><img src=\"image/exit.png\" alt=\"\" />Thoát</a></div>\r\n</div>\r\n<div id=\"logo\">\r\n<div id=\"loginStatus\"><b>CÁN BỘ:</b> ");

                                                  // end
                                                  // ##DEBUG## "/index_system.jsp" 93,40-"/index_system.jsp" 93,56  LineMapIndex:59
                                                    out.print(ac.getTenCanbo());
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(92,58);to=(92,82)]
                                                    out.write(" - <b>NƠI CÔNG TÁC:</b> ");

                                                  // end
                                                  // ##DEBUG## "/index_system.jsp" 93,85-"/index_system.jsp" 93,101  LineMapIndex:60
                                                    out.print(ac.getTenPhong());
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(92,103);to=(92,106)]
                                                    out.write(" - ");

                                                  // end
                                                  // ##DEBUG## "/index_system.jsp" 93,109-"/index_system.jsp" 93,123  LineMapIndex:61
                                                    out.print(ac.getTenCqt());
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(92,125);to=(95,0)]
                                                    out.write("</div>\r\n</div>\r\n<div id=\"content\">\r\n");

                                                  // end
                                                  // ##DEBUG## ##SCRIPTLET## "/index_system.jsp" 96,2-"/index_system.jsp" 96,32  LineMapIndex:62
                                                     if(KtnbUtil.isTongCuc(ac)) { 
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(95,34);to=(115,0)]
                                                    out.write("\r\n<table align=\"center\" width=\"100%\" cellpadding=\"10\"> \r\n\t<tr>\r\n\t\t<td valign=\"top\" align=\"left\" width=\"50%\" style=\"padding-left: 75px;\">\r\n\t\t<UL class=\"liMenu\">\r\n\t\t\t<li><a href=\"danh_muc_chung.do\"><font color=\"FF3600\" size=\"2\"><span>&raquo;</span></font> Danh mục chung</a></li>\r\n\t\t\t<li><a href=\"danh_muc_can_bo.do\"><font color=\"FF3600\" size=\"2\"><span>&raquo;</span></font> Danh mục cán bộ</a></li>\r\n\t\t\t<li><a href=\"danh_muc_phong_ban.do\"><font color=\"FF3600\" size=\"2\"><span>&raquo;</span></font> Danh mục phòng ban</a></li>\t\t\r\n\t\t\t<li><a href=\"danh_muc_thoi_han.do\"><font color=\"FF3600\" size=\"2\"><span>&raquo;</span></font> Danh mục thời hạn</a></li>\r\n\t\t</UL>\r\n\t\t</td>\r\n\t\t<td valign=\"top\" align=\"left\" width=\"50%\" style=\"padding-left: 75px;\">\r\n\t\t<ul class=\"liMenu\">\r\n\t\t\t<li><a href=\"danh_muc_cqt.do\"><font color=\"FF3600\" size=\"2\"><span>&raquo;</span></font> Danh mục cơ quan thuế</a></li>\r\n\t\t\t<li><a href=\"danh_muc_ngay_nghi.do\"><font color=\"FF3600\" size=\"2\"><span>&raquo;</span></font> Danh mục ngày nghỉ </a></li>\r\n\t\t\t<li><a href=\"dong_bo_so_lieu.do\"><font color=\"FF3600\" size=\"2\"><span>&raquo;</span></font> Đồng bộ số liệu</a></li>\r\n\t\t</ul>\r\n\t\t</td>\r\n\t</tr>\r\n</table>\r\n");

                                                  // end
                                                  // ##DEBUG## ##SCRIPTLET## "/index_system.jsp" 116,2-"/index_system.jsp" 116,4  LineMapIndex:63
                                                     }
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(115,6);to=(116,0)]
                                                    out.write("\r\n");

                                                  // end
                                                  // ##DEBUG## ##SCRIPTLET## "/index_system.jsp" 117,2-"/index_system.jsp" 117,33  LineMapIndex:64
                                                     if(!KtnbUtil.isTongCuc(ac)) { 
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(116,35);to=(135,0)]
                                                    out.write("\r\n<table align=\"center\" width=\"100%\" cellpadding=\"10\">\r\n\t<tr>\r\n\t\t<td valign=\"top\" align=\"left\" width=\"50%\" style=\"padding-left: 75px;\">\r\n\t\t<UL class=\"liMenu\">\t\t\t\r\n\t\t\t<li><a href=\"danh_muc_can_bo.do\"><font color=\"FF3600\" size=\"2\"><span>&raquo;</span></font> Danh mục cán bộ</a></li>\r\n\t\t\t<!-- <li><a href=\"danh_muc_chung.do\"><font color=\"FF3600\" size=\"2\"><span>&raquo;</span></font> Danh mục chung</a></li>\r\n\t\t\t<li><a href=\"danh_muc_thoi_han.do\"><font color=\"FF3600\" size=\"2\"><span>&raquo;</span></font> Danh mục thời hạn</a></li> -->\r\n\t\t</UL>\r\n\t\t</td>\r\n\t\t<td valign=\"top\" align=\"left\" width=\"50%\" style=\"padding-left: 75px;\">\r\n\t\t<ul class=\"liMenu\">\r\n\t\t\t<li><a href=\"danh_muc_phong_ban.do\"><font color=\"FF3600\" size=\"2\"><span>&raquo;</span></font> Danh mục phòng ban</a></li>\t\r\n\t\t\t<!-- <li><a href=\"danh_muc_cqt.do\"><font color=\"FF3600\" size=\"2\"><span>&raquo;</span></font> Danh mục cơ quan thuế</a></li>\r\n\t\t\t<li><a href=\"danh_muc_ngay_nghi.do\"><font color=\"FF3600\" size=\"2\"><span>&raquo;</span></font> Danh mục ngày nghỉ </a></li> -->\t\r\n\t\t</ul>\r\n\t\t</td>\r\n\t</tr>\r\n</table>\r\n");

                                                  // end
                                                  // ##DEBUG## ##SCRIPTLET## "/index_system.jsp" 136,2-"/index_system.jsp" 136,4  LineMapIndex:65
                                                     }
                                                  // end
                                                  // HTML // begin [file="/index_system.jsp";from=(135,6);to=(136,1)]
                                                    out.write("\r\n ");

                                                  // end
                                                  // HTML // begin [file="/bottom.jsp";from=(0,31);to=(22,4)]
                                                    out.write("\r\n<script language=\"Javascript\">\r\n$(function() \r\n{\r\n  $(document).bind('keydown','esc',function(evt){onButton('exit');return false;});\r\n  $(document).bind('keydown','home',function(evt){window.location='index.do';return false;});\r\n  if($('#exit').length>0)\r\n  {\r\n   $('#exit').button({icons:{primary:'ui-icon-close'}}).click(function(){onButton('exit');return false;});\r\n  }\r\n  if($('#search').length>0)\r\n  {\r\n    $('#search').button({icons:{primary:'ui-icon-search'}}).click(function(){onButton('search');return false;});\r\n    $(document).bind('keydown','Shift+s',function(evt){onButton('search');return false;});\r\n  }\r\n  if($('table.data_table').length>0)\r\n  {\r\n    $('table.data_table tbody tr').each(function(index) {$(this).addClass(arrClassName[index%3]);});\r\n    $(\"table.data_table tbody\").delegate(\"tr\", \"hover\", function(){$(this).toggleClass(\"highlight\");});\r\n  }\r\n  if($('#msgdiv').length>0)\r\n  {\r\n    ");

                                                  // end
                                                  // ##DEBUG## ##TAGLIB## "/bottom.jsp" 23,4-"/bottom.jsp" 23,30  LineMapIndex:66
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
                                                        // ##DEBUG## "/bottom.jsp" 25,4-"/bottom.jsp" 25,20  LineMapIndex:67
                                                        } while (_jspx_th_logic_present_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                      }
                                                      if (_jspx_th_logic_present_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                                                  // end
                                                  // HTML // begin [file="/bottom.jsp";from=(24,20);to=(32,92)]
                                                    out.write("\r\n  } \r\n});\r\n</script>\r\n</div>\r\n<div id=\"bottom\">\r\n<table width=\"100%\" border=\"0\" bordercolor=\"#AEC1F1\">\r\n\t<tr>\r\n\t\t<td align=\"center\" width=\"20%\" style=\"color: blue; font-size: 8pt\">KTNB Phiên bản <strong>");

                                                  // end
                                                  // ##DEBUG## "/bottom.jsp" 33,95-"/bottom.jsp" 33,113  LineMapIndex:68
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
                                              "/index_system.jsp", 
                                              "/bottom.jsp", 
                                              },
                                              {
                                              "0", 
                                              "66", 
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
                                              "1", 
                                              "1", 
                                              "1", 
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
                                              "21", 
                                              "21", 
                                              "23", 
                                              "23", 
                                              "24", 
                                              "24", 
                                              "25", 
                                              "25", 
                                              "26", 
                                              "26", 
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
                                              "42", 
                                              "42", 
                                              "59", 
                                              "59", 
                                              "60", 
                                              "60", 
                                              "62", 
                                              "63", 
                                              "64", 
                                              "65", 
                                              "66", 
                                              "67", 
                                              "68", 
                                              "69", 
                                              "93", 
                                              "93", 
                                              "93", 
                                              "96", 
                                              "116", 
                                              "117", 
                                              "136", 
                                              "23", 
                                              "25", 
                                              "33", 
                                              },
                                              };
                                            }
