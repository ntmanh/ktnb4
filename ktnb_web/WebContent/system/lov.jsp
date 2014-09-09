<%@ include file="/head.jsp"%> 
<script>
var macuc,tencuc,macqt,tencqt,maphong,tenphong;
var choncuc,choncqt;
var win,lov;
var w=450,h=350;

/*function setVal(id,name){
 Ext.getCmp('id').setValue(id);
 Ext.getCmp('name').setValue(name);
};*/

function setVal(id,name,ma_cqt,ten_cqt,ma_phong,ten_phong){
 Ext.getCmp('id').setValue(id);
 Ext.getCmp('name').setValue(name);
 Ext.getCmp('ma_cqt').setValue(ma_cqt);
 Ext.getCmp('ten_cqt').setValue(ten_cqt);
 Ext.getCmp('ma_phong').setValue(ma_phong);
 Ext.getCmp('ten_phong').setValue(ten_phong);
};

Ext.onReady(function(){
new Ext.FormPanel({
     width:w
     ,renderTo:document.body
     ,items:[{xtype: 'compositefield'
	          ,items:[
        			 {xtype:'textfield',anchor:'20%',id:'id'}
        			,{xtype:'displayfield',id:'name',cls:'x-form-item-label'}    	 
		        			        	
	            ]
	          }
	          ,{xtype: 'compositefield'
	          ,items:[{xtype:'textfield',anchor:'20%',id:'ma_phong'}
        			 ,{xtype:'displayfield',id:'ten_phong',cls:'x-form-item-label'}    	 
	            ]
	          }
	          ,{xtype: 'compositefield'
	          ,items:[{xtype:'textfield',anchor:'20%',id:'ma_cqt'}
        			 ,{xtype:'displayfield',id:'ten_cqt',cls:'x-form-item-label'}    	 
	                 ]
	          }
	      ]
	     ,buttons:[
	     	
	     		{text:'lov cqt'
		        	,handler: function(){
    	   		       setVal('','');	
		        	   w=450;
		        	   choncuc="1";
		        	   macuc=maCuc;
		        	   tencuc=tenCuc;
		        	   win=new Ext.Window({width:w,height:h,modal:true,items:new Ext.Panel({id:'lov',width:w,autoHeight:true})});
	        	   	   win.show();
	        	   	   lov=Ext.get('lov');   
		        	   lov.load({url:'system/lov_cqt.js',scripts:true}); 
		        	 }
		        	}

		        	,{text:'lov phong'
		        	,handler: function(){
		        	   setVal('','','','');
		        	   w=450;
		        	   choncuc="1";
 	   		           choncqt="1";
 	   		           macuc=maCuc;
		        	   tencuc=tenCuc;
		        	   macqt=maCqt;
		        	   tencqt=tenCqt;
		        	   win=new Ext.Window({width:w,height:h,modal:true,items:new Ext.Panel({id:'lov',width:w,autoHeight:true})});
	        	   	   win.show();
	        	   	   lov=Ext.get('lov');   
		        	   lov.load({url:'system/lov_phong.js',scripts:true}); 
		        	 }
		        	}
		        	,{text:'lov can bo'
		        	,handler: function(){
		        	   setVal('','','','','','');
		        	   w=550;
		        	   choncuc="1";
		        	   choncqt="1";
		        	   macuc=maCuc;
		        	   tencuc=tenCuc;
		        	   macqt=maCqt;
		        	   tencqt=tenCqt;
		        	   maphong=maPhong;
		        	   tenphong=tenPhong;
		        	   win=new Ext.Window({width:w,height:h,modal:true,items:new Ext.Panel({id:'lov',width:w,autoHeight:true})});
	        	   	   win.show();
	        	   	   lov=Ext.get('lov');   
		        	   lov.load({url:'system/lov_can_bo.js',scripts:true}); 
		        	 }
		        	}
		        	
	     	
	     
	     
	     ] 
	});
});	
</script>
</head>  
<body>
</body>
</html> 