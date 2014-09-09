Ext.BLANK_IMAGE_URL='extjs/resources/images/default/s.gif';
Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
Ext.ns('ktnb');
var now=new Date();
var date_transaction=now.format('d/m/Y');
var dayarr=new Array("Ch&#7911; nh&#7853;t", "Th&#7913; Hai", "Th&#7913; Ba", "Th&#7913; T&#432;", "Th&#7913; N&#259;m", "Th&#7913; S&#225;u", "Th&#7913; B&#7849;y");
var day=dayarr[now.getDay()];
var no_data_found_msg='Kh\u00F4ng t\u00ECm th\u1EA5y b\u1EA3n ghi n\u00E0o';
var enter_data_find_msg='T\u00ECm ki\u1EBFm...';
var nameApp="<div style='color:#3764a0;font:bold 11px tahoma;'>KI\u1EC2M TRA N\u1ED8I B\u1ED8</div>";
var tatca='T\u1EA5t c\u1EA3';
var parentId='';

function showMsg(message,title){
   Ext.Msg.show({
      title:((Ext.isEmpty(title))?'Th\u00F4ng b\u00E1o':title)
      ,msg: message
      ,buttons: Ext.MessageBox.OK
      ,icon: Ext.MessageBox.INFO
     });
};

function showErr(message,title){
   Ext.Msg.show({
      title:((Ext.isEmpty(title))?'Th\u00F4ng b\u00E1o l\u1ED7i':title)
      ,msg: message
      ,modal:true
      ,buttons: Ext.MessageBox.OK
      ,icon: Ext.MessageBox.ERROR
     });
};

function showFailure(action) {
 var fType=action.failureType;
 if (fType==Ext.form.Action.CLIENT_INVALID)  		showMsg('D\u1EEF li\u1EC7u kh\u00F4ng h\u1EE3p l\u1EC7!'); 
 else if (fType==Ext.form.Action.CONNECT_FAILURE) 	showMsg('Server communication failure: '+ action.response.status+' '+action.response.statusText); 
 else if (fType==Ext.form.Action.SERVER_INVALID) 	showErr(action.result.msg); 
};
