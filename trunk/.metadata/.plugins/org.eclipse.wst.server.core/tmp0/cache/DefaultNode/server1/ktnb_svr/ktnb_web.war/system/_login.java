package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _login extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _login( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/system/login.jsp";

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

      // HTML // begin [file="/system/login.jsp";from=(0,0);to=(3,0)]
        out.write("<html>\r\n<head>\r\n<link rel='stylesheet' type='text/css' href='extjs/xtheme-gray-extend.css' />\r\n");

      // end
      // HTML // begin [file="/system/login.jsp";from=(3,31);to=(96,0)]
        out.write("\r\n<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\" />\r\n<link type=\"text/css\" href=\"stylesheet/ktnb.css\" rel=\"stylesheet\">\r\n<link rel=\"stylesheet\" type=\"text/css\" href='extjs/resources/css/ext-all.css'>\r\n<script type=\"text/javascript\" src='extjs/adapter/ext/ext-base.js'></script>\r\n<script type=\"text/javascript\" src='extjs/ext-all.js'></script>\r\n<script type=\"text/javascript\" src='extjs/ext-ktnb.js'></script>\r\n<script>\t\r\nExt.onReady(function(){\r\nvar browserName=navigator.appName; \r\n\r\nif (browserName!=\"Microsoft Internet Explorer\")\r\n{\r\n  alert(\"Chương trình hoạt động tốt nhất trên Trình duyệt IE (Internet Explorer) Version 7,8,9.\\nDùng trình duyệt khác có thể gây lỗi không mong muốn.\");  \r\n  //window.open('close.html','_parent','');\r\n  //window.close();\r\n}\r\nExt.QuickTips.init();\r\nlogin=function(){\r\n  form.getForm().submit({\r\n\t   \turl:'loginAction.do',\r\n\t   \twaitTitle:'\\u0110\\u0103ng nh\\u1EADp h\\u1EC7 th\\u1ED1ng', \r\n        waitMsg:'\\u0110ang k\\u1EBFt n\\u1ED1i....',\r\n\t   \tsuccess: function(f,action){\r\n\t   \t\twindow.location='index.do';\r\n\t   \t\t/*\r\n\t   \t\twindow.open(\"index.do\",\"\",\"menubar=no,toolbar=yes,scrollbars=yes,status=yes,height=800,width=600\");\r\n\t   \t\twindow.opener = \"me\";\r\n\t\t\twindow.close();\r\n\t\t\t*/\r\n\t   \t},\r\n\t   \tfailure: function(f,action){showFailure(action);}\t  \r\n\t});\r\n};\r\n\r\nform=new Ext.FormPanel({\r\n    title:'\\u0110\\u0103ng nh\\u1EADp'\r\n    ,frame: false\r\n    ,border:false\r\n    ,bodyStyle:'padding:15px;background:transparent'\r\n    //,bodyStyle:'padding:5px auto 0 auto;background:transparent',\r\n    //,buttonAlign:'center'\r\n    ,items:[\r\n     {xtype:'textfield', id:'user',fieldLabel:'T\\u00EAn \\u0111\\u0103ng nh\\u1EADp',allowBlank: false,minLength:4,maxLength:25,msgTarget:'side',validationEvent:false}\r\n    ,{xtype:'textfield', id:'pass',fieldLabel:'M\\u1EADt kh\\u1EA9u',inputType:'password',allowBlank:false,minLength:4,maxLength:25,msgTarget:'side',minLengthText:'M\\u1EADt kh\\u1EA9u ph\\u1EA3i d\\u00E0i h\\u01A1n 4',validationEvent:false}\r\n    ]\r\n\t,buttons:[{text:'\\u0110\\u0103ng nh\\u1EADp',icon:'image/password.png',handler:login}]\r\n\t,keys:[{key:[Ext.EventObject.ENTER],handler:login}]\r\n});\r\nwin=new Ext.Window({\r\n      layout:'form'\r\n      ,width:300\r\n      ,draggable: false\r\n      ,autoHeight:true\r\n      ,style: \"margin: 0px auto 0px auto;\"\r\n      ,closable:false\r\n      ,resizable:false\r\n      ,header:false\r\n      ,items: [form]\r\n      ,defaultButton:'user'\r\n      ,renderTo: Ext.get('divLogin')\r\n   });\r\nwin.show();\r\nwin.focus();\r\n});\t\r\nvar addEvent = function(elem, type, eventHandle) {\r\n    if (elem == null || elem == undefined) return;\r\n    if ( elem.addEventListener ) {\r\n        elem.addEventListener( type, eventHandle, false );\r\n    } else if ( elem.attachEvent ) {\r\n        elem.attachEvent( \"on\" + type, eventHandle );\r\n    }\r\n};\r\n\r\naddEvent(window, \"resize\", function() { \r\n\tlocation.reload(true);\r\n});\r\n\r\n</script>\r\n<META HTTP-EQUIV=\"Cache-Control\" CONTENT=\"no-cache, no-store, must-revalidate\">\r\n<META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\r\n<META HTTP-EQUIV=\"Expires\" CONTENT=\"0\">\r\n</head>\r\n<body>\r\n<div style=\"text-align: center\">\r\n<div id=\"divLogin\"\r\n\tstyle=\"width: 780px; height: 650px; background-image: url('images/loginBg2.jpg' ); background-repeat: no-repeat; background-position: center;\"></div>\r\n</div>\r\n<div style=\"text-align: center; margin-top: -100px;\"><font style=\"color: blue; font-size: 9pt\"> <b>T&#7892;NG C&#7908;C THU&#7870;</b> <BR>\r\n<strong>&#272;&#7883;a ch&#7881;:</strong> S&#7889; 123 L&#242; &#272;&#250;c, H&#224; N&#7897;i &nbsp; &nbsp;<strong>&#272;i&#7879;n tho&#7841;i:</strong> (04) 9.724204 - 9.724209 <strong>Fax:</strong> (04) 9.712286 <br>\r\n<strong>Website:</strong> <a href=\"http://www.gdt.gov.vn\" target=\"_blank\">http://www.gdt.gov.vn</a> </font></div>\r\n</body>\r\n</html>\r\n");

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
  "/system/login.jsp", 
  },
  {
  "0", 
  },
  };
  public static String[][] _jspx_debug_LineMapping = {
  {
  "0", 
  },
  {
  "1", 
  },
  };
}
