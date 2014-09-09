<html>
<head>
<link rel='stylesheet' type='text/css' href='extjs/xtheme-gray-extend.css' />
<%@ page pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<link type="text/css" href="stylesheet/ktnb.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href='extjs/resources/css/ext-all.css'>
<script type="text/javascript" src='extjs/adapter/ext/ext-base.js'></script>
<script type="text/javascript" src='extjs/ext-all.js'></script>
<script type="text/javascript" src='extjs/ext-ktnb.js'></script>
<script>	
Ext.onReady(function(){
var browserName=navigator.appName; 

if (browserName!="Microsoft Internet Explorer")
{
  alert("Chương trình hoạt động tốt nhất trên Trình duyệt IE (Internet Explorer) Version 7,8,9.\nDùng trình duyệt khác có thể gây lỗi không mong muốn.");  
  //window.open('close.html','_parent','');
  //window.close();
}
Ext.QuickTips.init();
login=function(){
  form.getForm().submit({
	   	url:'loginAction.do',
	   	waitTitle:'\u0110\u0103ng nh\u1EADp h\u1EC7 th\u1ED1ng', 
        waitMsg:'\u0110ang k\u1EBFt n\u1ED1i....',
	   	success: function(f,action){
	   		window.location='index.do';
	   		/*
	   		window.open("index.do","","menubar=no,toolbar=yes,scrollbars=yes,status=yes,height=800,width=600");
	   		window.opener = "me";
			window.close();
			*/
	   	},
	   	failure: function(f,action){showFailure(action);}	  
	});
};

form=new Ext.FormPanel({
    title:'\u0110\u0103ng nh\u1EADp'
    ,frame: false
    ,border:false
    ,bodyStyle:'padding:15px;background:transparent'
    //,bodyStyle:'padding:5px auto 0 auto;background:transparent',
    //,buttonAlign:'center'
    ,items:[
     {xtype:'textfield', id:'user',fieldLabel:'T\u00EAn \u0111\u0103ng nh\u1EADp',allowBlank: false,minLength:4,maxLength:25,msgTarget:'side',validationEvent:false}
    ,{xtype:'textfield', id:'pass',fieldLabel:'M\u1EADt kh\u1EA9u',inputType:'password',allowBlank:false,minLength:4,maxLength:25,msgTarget:'side',minLengthText:'M\u1EADt kh\u1EA9u ph\u1EA3i d\u00E0i h\u01A1n 4',validationEvent:false}
    ]
	,buttons:[{text:'\u0110\u0103ng nh\u1EADp',icon:'image/password.png',handler:login}]
	,keys:[{key:[Ext.EventObject.ENTER],handler:login}]
});
win=new Ext.Window({
      layout:'form'
      ,width:300
      ,draggable: false
      ,autoHeight:true
      ,style: "margin: 0px auto 0px auto;"
      ,closable:false
      ,resizable:false
      ,header:false
      ,items: [form]
      ,defaultButton:'user'
      ,renderTo: Ext.get('divLogin')
   });
win.show();
win.focus();
});	
var addEvent = function(elem, type, eventHandle) {
    if (elem == null || elem == undefined) return;
    if ( elem.addEventListener ) {
        elem.addEventListener( type, eventHandle, false );
    } else if ( elem.attachEvent ) {
        elem.attachEvent( "on" + type, eventHandle );
    }
};

addEvent(window, "resize", function() { 
	location.reload(true);
});

</script>
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, no-store, must-revalidate">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
</head>
<body>
<div style="text-align: center">
<div id="divLogin"
	style="width: 780px; height: 650px; background-image: url('images/loginBg2.jpg' ); background-repeat: no-repeat; background-position: center;"></div>
</div>
<div style="text-align: center; margin-top: -100px;"><font style="color: blue; font-size: 9pt"> <b>T&#7892;NG C&#7908;C THU&#7870;</b> <BR>
<strong>&#272;&#7883;a ch&#7881;:</strong> S&#7889; 123 L&#242; &#272;&#250;c, H&#224; N&#7897;i &nbsp; &nbsp;<strong>&#272;i&#7879;n tho&#7841;i:</strong> (04) 9.724204 - 9.724209 <strong>Fax:</strong> (04) 9.712286 <br>
<strong>Website:</strong> <a href="http://www.gdt.gov.vn" target="_blank">http://www.gdt.gov.vn</a> </font></div>
</body>
</html>
