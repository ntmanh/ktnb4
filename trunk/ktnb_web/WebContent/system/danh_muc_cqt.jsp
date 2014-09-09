<%@ include file="/top_bar_system.jsp"%> 
<%@ page pageEncoding="UTF-8"%>
<script>   
var macuc=maCuc,tencuc=tenCuc,macqt=maCqt,tencqt=tenCqt,maphong=maPhong,tenphong=tenPhong;
var tenChucvu="<%=ac.getTenChucvu()%>";
var contentPanel;
var pbar,sbar;
var choncuc,choncqt;
var win,lov;
var w=450,h=350;
function getUrl(url){
	contentPanel.load({url:url,scripts:true});
};
Ext.onReady(function(){  
clock=new Ext.Toolbar.TextItem('');
var p = new Ext.Panel({  
        title: '<a href="index_system.do" style="text-decoration:none;"> Hệ thống </a> >> Danh mục cơ quan thuế',   
        width: 780,        
       	items:new Ext.Panel({border: false,id:'contentPanel'}),
        applyTo:'content'
    });
contentPanel=Ext.get('contentPanel');
pbar=Ext.getCmp('pba');
sbar=Ext.getCmp('sbar');
contentPanel.load({url:'system/dm_cqt.js',scripts:true});
});	
</script>
 <%@ include file="/bottom.jsp"%>
