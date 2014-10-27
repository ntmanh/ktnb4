<html>
<head>

<%@ page pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<script language="JavaScript" src="include/js/jquery-1.4.2.min.js"></script>
<script language="JavaScript" src="include/js/jquery-ui-1.8.2.custom.min.js"></script>
<script language="JavaScript" src="../include/js/ktnb.js"></script>


<script>
	$( document ).ready(function() {
    	var browserName=navigator.appName; 
		if (browserName!="Microsoft Internet Explorer")
		{
		  alert("Chương trình hoạt động tốt nhất trên Trình duyệt IE (Internet Explorer) Version 7,8,9.\nDùng trình duyệt khác có thể gây lỗi không mong muốn.");  
		  //window.open('close.html','_parent','');
		  //window.close();
		}
	});
	function login()
	{
		document.forms[0].action='loginAction.do';
		document.forms[0].submit();
	}	
</script>
<style type="text/css">
	#divHienThi {
		background-color: #B6E6FF;
		width:24%;
		height: 20%;
		position: absolute;
		top: 37%;
		left: 38%;
	}
	.lb {float:left; width:100px;}
	.text {float: left; width:150px;}
	#box-login { float :left; margin-left: 3%;margin-bottom: 5px;}
	#tit-login { margin-bottom: 5px; background-color: red; font-weight: bold;}
</style>
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, no-store, must-revalidate">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
</head>
<body>
<html:form action="loginAction">
<div style="text-align: center">
	<div id="divLogin" style="width: 780px; height: 650px; background-image: url('images/loginBg2.jpg' ); background-repeat: no-repeat; background-position: center;">
	</div>
	<div id="divHienThi">
		<div id="tit-login">&#272;&#259;ng nh&#7853;p</div>
		<div id="box-login">
			<div class="lb">T&#234;n &#273;&#259;ng nh&#7853;p </div>
			<div><html:text property="userName" styleClass="text" styleId="name"></html:text></div>
			<div class="lb" >M&#7853;t kh&#7849;u </div>
			<div><html:password property="passWord" styleClass="text"></html:password></div>
		</div>
		<input type="button" value="&#272;&#259;ng nh&#7853;p" onclick="login();" />
	</div>
</div>
<div style="text-align: center; margin-top: -100px;"><font style="color: blue; font-size: 9pt"> <b>T&#7892;NG C&#7908;C THU&#7870;</b> <BR>
<strong>&#272;&#7883;a ch&#7881;:</strong> S&#7889; 123 L&#242; &#272;&#250;c, H&#224; N&#7897;i &nbsp; &nbsp;<strong>&#272;i&#7879;n tho&#7841;i:</strong> (04) 9.724204 - 9.724209 <strong>Fax:</strong> (04) 9.712286 <br>
<strong>Website:</strong> <a href="http://www.gdt.gov.vn" target="_blank">http://www.gdt.gov.vn</a> </font></div>
</html:form>
</body>
<%if(request.getAttribute("login") == "ok"){%>
<script language="javascript">
		window.location  = 'index.do';
	</script>
<%}%>
<%if(request.getAttribute("login") == "loi1"){%>
<script language="javascript">
		alert("\u0110\u0103ng nh\u1EADp kh\u00F4ng th\u00E0nh c\u00F4ng");
	</script>
<%}%>
<%if(request.getAttribute("login") == "loi2"){%>
<script language="javascript">
		alert("Sai t\u00E0i kho\u1EA3n ho\u1EB7c m\u1EADt kh\u1EA9u");
		document.getElementById('name').focus();
	</script>
<%}%>
</html>