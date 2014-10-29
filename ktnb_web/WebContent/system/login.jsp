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
<link rel='stylesheet' type='text/css' href='extjs/xtheme-gray-extend.css' />
<link type="text/css" href="stylesheet/ktnb.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href='extjs/resources/css/ext-all.css'>


<script>
	$( document ).ready(function() {
    	var browserName=navigator.appName; 
		if (browserName!="Microsoft Internet Explorer")
		{
		  alert("Ch\u01B0\u01A1ng tr\u00ECnh ho\u1EA1t \u0111\u1ED9ng t\u1ED1t nh\u1EA5t tr\u00EAn Tr\u00ECnh duy\u1EC7t IE (Internet Explorer) Version 7,8,9.\\nD\u00F9ng tr\u00ECnh duy\u1EC7t kh\u00E1c c\u00F3 th\u1EC3 g\u00E2y l\u1ED7i kh\u00F4ng mong mu\u1ED1n.");  
		  //window.open('close.html','_parent','');
		  //window.close();
		}
		$("#user").focus();
		$("#user,#pass").keyup(function(event){
		    if(event.keyCode == 13){
		        login();
		    }
		});	
	});
	function login()
	{
		if(validateForm())
		{
			document.forms[0].action='loginAction.do';
			document.forms[0].submit();	
		}
		return;
	}
	function validateForm(){
		if($("#user").val()=="")
		{
			alert("Tên đăng nhập không được để trống ! ");
			$("#user").focus();
			return;
		}
		else if($("#pass").val()=="")
		{
			alert("Mật khẩu không được để trống");
			$("#pass").focus();
			return;
		}
		return true;
	}
</script>

<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, no-store, must-revalidate">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
</head>
<body>
<html:form action="loginAction">
<div style="text-align: center">
	<div id="divLogin" style="width: 780px; height: 650px; background-image: url('images/loginBg2.jpg' ); background-repeat: no-repeat; background-position: center;">
	</div>
	<div class="x-shadow" id="ext-gen33" style="z-index: 9002; left: 38%; top: 34%; width: 308px; height: 177px; display: block;"><div class="xst"><div class="xstl"></div><div class="xstc" style="width: 296px;"></div><div class="xstr"></div></div><div class="xsc" style="height: 165px;"><div class="xsml"></div><div class="xsmc" style="width: 296px;"></div><div class="xsmr"></div></div><div class="xsb"><div class="xsbl"></div><div class="xsbc" style="width: 296px;"></div><div class="xsbr"></div></div></div>
	<div id="ext-comp-1005" class=" x-window" style="position: absolute; z-index: 9003; visibility: visible; left: 38%; top: 34%; margin: 0px auto; width: 300px; display: block;">
	<div class="x-window-tl">
		<div class="x-window-tr">
			<div class="x-window-tc">
				<div class="x-window-header x-unselectable" id="ext-gen12">
					<span class="x-window-header-text"></span>
				</div>
			</div>
		</div>
	</div>
		<div class="x-window-bwrap" id="ext-gen13">
			<div class="x-window-ml">
				<div class="x-window-mr">
					<div class="x-window-mc" id="ext-gen16">
						<div class="x-window-body" id="ext-gen14" style="width: 286px; height: auto;">
							<div id="ext-comp-1002" class=" x-panel x-panel-noborder x-form-label-left" style="width: 286px;">
									<div class="x-panel-header x-panel-header-noborder x-unselectable" id="ext-gen20">
										<span class="x-panel-header-text" id="ext-gen25">&#272;&#259;ng nh&#7853;p</span>
									</div>
								<div class="x-panel-bwrap" id="ext-gen21">
									<div class="x-panel-body x-panel-body-noborder x-form" method="POST" id="ext-gen11" style="padding: 15px; width: 256px; background: transparent;">
										<div class="x-form-item " tabindex="-1" id="ext-gen29">
										<label for="user" style="width:100px;" class="x-form-item-label" id="ext-gen30">T&#234;n &#273;&#259;ng nh&#7853;p:</label>
										
											
											<html:text property="userName" size="20" styleClass="x-form-text x-form-field" styleId="user"></html:text>
										
										<div class="x-form-clear-left"></div>
										</div>
										<div class="x-form-item " tabindex="-1" id="ext-gen31">
											<label for="pass" style="width:100px;" class="x-form-item-label" id="ext-gen32">M&#7853;t kh&#7849;u:</label>
												<html:password property="passWord" size="20" styleClass="x-form-text x-form-field" styleId="pass"></html:password>
											<div class="x-form-clear-left"></div>
										</div>
									</div>
									<div class="x-panel-footer x-panel-footer-noborder x-panel-btns" id="ext-gen22" style="width: 276px;">
										<div id="ext-comp-1003" class="x-panel-fbar x-small-editor x-toolbar-layout-ct" style="width: auto;">
											<table cellspacing="0" class="x-toolbar-ct">
												<tbody>
													<tr>
														<td class="x-toolbar-left" align="left">
															<table cellspacing="0">
																<tbody>
																	<tr class="x-toolbar-left-row"></tr>
																</tbody>
															</table>
														</td>
														<td class="x-toolbar-right" align="right">
															<table cellspacing="0" class="x-toolbar-right-ct">
																<tbody>
																	<tr>
																		<td>
																			<table cellspacing="0">
																				<tbody>
																					<tr class="x-toolbar-right-row">
																						<td class="x-toolbar-cell" id="ext-gen27">
																							<table id="ext-comp-1004" cellspacing="0" class="x-btn  x-btn-text-icon" style="width: auto;">
																								<tbody class="x-btn-small x-btn-icon-small-left">
																									<tr>
																										<td class="x-btn-tl"><i>&nbsp;</i></td>
																										<td class="x-btn-tc"></td>
																										<td class="x-btn-tr"><i>&nbsp;</i></td>
																									</tr>
																									<tr>
																										<td class="x-btn-ml"><i>&nbsp;</i></td>
																										<td class="x-btn-mc">
																											<em class="" unselectable="on">
																												<button type="button" id="ext-gen28" class=" x-btn-text" onclick="login();" style="background-image: url(http://localhost:7080/ktnb/image/password.png);">&#272;&#259;ng nh&#7853;p</button>
																											</em>
																										</td>
																										<td class="x-btn-mr"><i>&nbsp;</i></td>
																									</tr>
																									<tr>
																										<td class="x-btn-bl"><i>&nbsp;</i></td>
																										<td class="x-btn-bc"></td>
																										<td class="x-btn-br"><i>&nbsp;</i></td>
																									</tr>
																								</tbody>
																							</table>
																						</td>
																					</tr>
																				</tbody>
																			</table>
																		</td>
																		<td>
																			<table cellspacing="0">
																				<tbody>
																					<tr class="x-toolbar-extras-row"></tr>
																				</tbody>
																			</table>
																		</td>
																	</tr>
																</tbody>
															</table>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
										<div class="x-clear" id="ext-gen24"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="x-window-bl x-panel-nofooter" id="ext-gen15">
				<div class="x-window-br">
					<div class="x-window-bc"></div>
				</div>
			</div>
		</div>
			<a href="#" class="x-dlg-focus" tabindex="-1" id="ext-gen17">&nbsp;</a></div>
</div>

<div style="text-align: center; margin-top: -100px;"><font style="color: blue; font-size: 9pt"> <b>T&#7892;NG C&#7908;C THU&#7870;</b> <BR>
<strong>&#272;&#7883;a ch&#7881;:</strong> S&#7889; 123 L&#242; &#272;&#250;c, H&#224; N&#7897;i &nbsp; &nbsp;<strong>&#272;i&#7879;n tho&#7841;i:</strong> (04) 9.724204 - 9.724209 <strong>Fax:</strong> (04) 9.712286 <br>
<strong>Website:</strong> <a href="http://www.gdt.gov.vn" target="_blank">http://www.gdt.gov.vn</a> </font></div>
<div id="ext-comp-1001" class="x-tip" style="position: absolute; z-index: 20002; visibility: hidden; display: none;">
	<div class="x-tip-tl">
		<div class="x-tip-tr">
			<div class="x-tip-tc">
				<div class="x-tip-header x-unselectable" id="ext-gen4">
					<span class="x-tip-header-text"></span>
				</div>
			</div>
		</div>
	</div>
	<div class="x-tip-bwrap" id="ext-gen5">
		<div class="x-tip-ml">
			<div class="x-tip-mr">
				<div class="x-tip-mc" id="ext-gen8">
					<div class="x-tip-body" id="ext-gen6" style="height: auto;"></div>
				</div>
			</div>
		</div>
		<div class="x-tip-bl x-panel-nofooter" id="ext-gen7">
			<div class="x-tip-br">
				<div class="x-tip-bc"></div>
			</div>
		</div>
	</div>
	<div class="x-tip-anchor x-tip-anchor-top" id="ext-gen9" style="z-index: 20003;"></div>
</div>
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
		document.getElementById('user').focus();
	</script>
<%}%>
</html>