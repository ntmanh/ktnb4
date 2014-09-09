<%@ page pageEncoding="UTF-8"%>
<%@ page  contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<LINK rel="stylesheet" type="text/css" HREF="<html:rewrite page='/stylesheet/ktnb.css'/>">
</head>
<%
  String errCode=(String) request.getParameter("errCode"); 
  if(errCode==null ||(errCode!=null && errCode.equals("null")))
  {
  	errCode ="Có lỗi xảy ra trong quá trình thực hiện nghiệp vụ!";
  }
  String errCodeCause=(String) request.getParameter("errCodeCause"); 
  if(errCodeCause==null ||(errCodeCause!=null && errCodeCause.equals("null")))
  {
  	errCodeCause ="Kiểm tra dữ liệu đầu vào hoặc đường truyền dữ liệu.";
  }
  String errCodeAction=(String) request.getParameter("errCodeAction"); 
  if(errCodeAction==null ||(errCodeAction!=null && errCodeAction.equals("null")))
  {
  	errCodeAction ="Vui lòng thông báo cho quản trị hệ thống!";
  }
%>
<body bgcolor="#D4D0C8">
<center>
<h3>Thông báo!</h3>
<table align="center" border="0" cellpadding="3" cellspacing="3" width="100%">
  <tr>
    <td align="right" width="30%"><b>Vấn đề :</b></td>
    <td align="left"  width="70%"><%=errCode%> </td>
  </tr>  
   <tr>
    <td align="right" width="30%"><b>Giải pháp :</b></td>
    <td align="left"  width="70%"><%=errCodeAction%> </td>
  </tr> 
  <tr>
      <td colspan="2" align="center">
          <input type="button" value="Quay lại" onClick="javascript:window.close();" class="button">
      </td>
    </tr>
 </table>
</center>
</body>
</html>
