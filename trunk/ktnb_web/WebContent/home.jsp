<%@ include file="/head.jsp"%>
<script>
var macuc=maCuc,tencuc=tenCuc,macqt=maCqt,tencqt=tenCqt,maphong=maPhong,tenphong=tenPhong;
var tenChucvu="<%=ac.getTenChucvu()%>";
var contentPanel;
var pbar,sbar;
var choncuc,choncqt;
var win,lov;
var w=800,h=600;
function getUrl(url){
	contentPanel.load({url:url,scripts:true});
};
ktnb.menuTree=Ext.extend(Ext.tree.TreePanel,{
     border:false
     ,split:true
     ,lines:true
     ,useArrows:true
     ,rootVisible:false
     ,listeners:{click:function(n){
     	if(n.leaf) 
     	{
     		/*arr=n.attributes.arr;
     		Ext.iterate(arr,function(key, value) {
  				alert(key + ':' + value);
			});*/
     		getUrl(n.id);
     	}
      }
     }
     ,initComponent:function() {
        ktnb.menuTree.superclass.initComponent.apply(this,arguments);
     }
});
Ext.reg('menuTree',ktnb.menuTree);

Ext.onReady(function(){
Ext.QuickTips.init();
topToolbar={xtype:'toolbar',height:30,region:'north',
    items: 
    [
	    nameApp,'->','-',day+', '+date_transaction,'-',tenNsd+'- '+tenChucvu+'- '+tenPhong+'- '+tenCqt,'-',
	    {icon:'image/information.png',text:'Tr\u1EE3 gi\u00FAp',
	     menu:[
		    	  {icon:'image/info.png',text:'T\u00E0i li\u1EC7u tr\u1EE3 gi\u00FAp',handler:function(){window.location='help.do';}},
		    	  {icon:'image/onlinehelp.jpg',text:'H\u1ED7 tr\u1EE3 tr\u1EF1c tuy\u1EBFn',handler:function(){getUrl('system/online.js');}}
	    	  ]
		},
	    '-',{icon:'image/textfield_key.png',text:'\u0110\u1ED5i MK',handler: function(){getUrl('system/pass.js');}},
		'-',{icon:'image/exit.png',text:'Tho\u00E1t',handler: function(){window.location='thoat.do';}},''
	]
};
hethongTree={xtype:'menuTree',root:{expanded:true,children:
				[{text:'DM chung',id:'system/dm_tree.js',leaf:true},
		         {text:'DM C\u00E1n b\u1ED9',id:'system/dm_can_bo.js'
		         //,arr:{method:'xyz',uic:'abc'}
		         ,leaf:true},
		         {text:'DM ph\u00F2ng ban',id:'system/dm_phong.js',leaf:true},
		         {text:'DM Th\u1EDDi h\u1EA1n',id:'system/dm_time.js',leaf:true},
		         {text:'DM c\u01A1 quan thu\u1EBF',id:'system/dm_cqt.js',leaf:true},
		         {text:'\u0110\u1ED3ng b\u1ED9 s\u1ED1 li\u1EC7u',id:'system/refresh.js',leaf:true}
			    ]}
};
baocaoTree={xtype:'menuTree',root:{expanded:true,children:[
    {text:'lov',id:'ttkt/tim_kiem.js',leaf:true}
]}
};
ttktTree={xtype:'menuTree',root:{expanded:true,children:[
		    {text:'extFit',id:'extex/extFit.js',leaf:true},
		    {text:'extTab',id:'extex/extTab.js',leaf:true},
		    {text:'extAccordion',id:'extex/extAccordion.js',leaf:true}
	    ]}
};
kntcTree={xtype:'menuTree',root:{expanded:true,children:[
		  {	text:'S\u1ED5 ti\u1EBFp d\u00E2n',
		    children:[{text:'Ghi s\u1ED5 ti\u1EBFp d\u00E2n',id:'kntc/std/sotiepdan.js',leaf:true}]
		  }
		 ,{text:'X\u1EED l\u00FD h\u1ED3 s\u01A1 qua \u0111\u01B0\u1EDDng v\u0103n th\u01B0',
		    children:[{text:'extFit',id:'extex/extFit.js',leaf:true}]
		  }
		 ,{text:'Ph\u00E2n lo\u1EA1i-X\u1EED l\u00FD \u0111\u01A1n Khi\u1EBFu N\u1EA1i',
		    children:[{text:'Ph\u00E2n lo\u1EA1i,l\u1EADp \u0111\u1EC1 xu\u1EA5t x\u1EED l\u00FD \u0111\u01A1n Khi\u1EBFu n\u1EA1i',id:'kntc/timkiem/timkiem_pl_ldx_kn.js',leaf:true}]
		  }
		 ,{text:'Ph\u00E2n lo\u1EA1i-X\u1EED l\u00FD \u0111\u01A1n t\u1ED1 c\u00E1o',
		    children:[{text:'Ghi s\u1ED5 ti\u1EBFp d\u00E2n',id:'kntc/std/sotiepdan.js',leaf:true}]
		  }
		 ,{text:'C\u00E1c ch\u1EE9c n\u0103ng kh\u00E1c',
		    children:[{text:'T\u00ECm ki\u1EBFm h\u1ED3 s\u01A1',id:'kntc/timkiem/timkiemhoso.js',leaf:true}]
		  }
	    ]
	  }
};    

hethongPanel=new Ext.Panel({stateId:'hethongPanel',title:'H\u1EC7 th\u1ED1ng',items:hethongTree});
baocaoPanel=new Ext.Panel({stateId:'baocaoPanel',title:'B\u00E1o c\u00E1o',items:baocaoTree});
ttktPanel=new Ext.Panel({stateId:'ttktPanel',title:'Thanh tra ki\u1EC3m tra',items:ttktTree});
kntcPanel=new Ext.Panel({stateId:'kntcPanel',title:'Khi\u1EBFu n\u1EA1i t\u1ED1 c\u00E1o',items:kntcTree});
clock=new Ext.Toolbar.TextItem('');
viewport=new Ext.Viewport({layout:'border',defaults:{bodyStyle:'padding:1px',autoScroll:true},
items:[topToolbar
,{
	region:'west'
	,layout:'accordion'
	,border:false
	,split:true
	,collapsible:true
	,collapseMode:'mini'
	,width:200
	,minSize:100
	,layoutConfig:{animate:true}
	,defaults: 
	{
      stateEvents: ["collapse","expand"]
      ,getState:function(){return {collapsed:this.collapsed};}
      ,border:false
    }
	,items:[hethongPanel,baocaoPanel,ttktPanel,kntcPanel]
}
,{
region:'center'
,border:false
,items:new Ext.Panel({border: false,id:'contentPanel'})
,bbar:new Ext.ux.StatusBar({id:'sbar',items:['-',new Ext.ProgressBar({id:'pbar',width:100}),'-',clock,' ']})
,listeners:{render:{fn:function(){
                	Ext.fly(clock.getEl().parent()).addClass('x-status-text-panel').createChild({cls:'spacer'});
			    	Ext.TaskMgr.start({run: function(){Ext.fly(clock.getEl()).update(new Date().format('H:i:s'));},interval:5000});
            		},delay: 100}
           }
}
]
});  
contentPanel=Ext.get('contentPanel');
pbar=Ext.getCmp('pbar');
sbar=Ext.getCmp('sbar');

});	
</script>
</head>
<body>
</body>
</html>
