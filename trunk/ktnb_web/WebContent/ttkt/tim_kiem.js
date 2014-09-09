<script>
function setVal(id,name){
  Ext.getCmp('ma_dv_ttkt').setValue(id);
  Ext.getCmp('ten_dv_ttkt').setValue(name);
};

gridStore=new Ext.data.JsonStore({
    url:'jsonstore.do'
	,autoDestroy:true
    ,root: 'data'
    ,totalProperty:'total'
    ,baseParams:{method:'dsttkt'}
    ,idProperty:'id'
    ,fields:['id','ma','loai','hinh_thuc','trang_thai','ten_don_vi_bi','nien_do']
    ,remoteSort:true
});
gridStore.setDefaultSort('ma','asc');
gridStore.on('beforeload',function(s){
    s.setBaseParam('noidung_ttkt',Ext.getCmp('noidung_ttkt').getValue());
    s.setBaseParam('tu_ngay',Ext.getCmp('tu_ngay').getRawValue());
    s.setBaseParam('den_ngay',Ext.getCmp('den_ngay').getRawValue());
    s.setBaseParam('loai_ttkt',Ext.getCmp('loai_ttkt').getValue());
    s.setBaseParam('hinhthuc_ttkt',Ext.getCmp('hinhthuc_ttkt').getValue());
    s.setBaseParam('status_ttkt',Ext.getCmp('status_ttkt').getValue());
    s.setBaseParam('ma_dv_ttkt',Ext.getCmp('ma_dv_ttkt').getValue());
    s.setBaseParam('ma_ttkt',Ext.getCmp('ma_ttkt').getValue());
});

status_ttkts=new Ext.data.ArrayStore({autoDestroy:true,fields:['id','name'],data:[['',tatca],['0','Ch\u01B0a ph\u00E2n c\u00F4ng tr\u01B0\u1EDFng \u0111o\u00E0n'],['1','\u0110\u00E3 ph\u00E2n c\u00F4ng tr\u01B0\u1EDFng \u0111o\u00E0n']]});
status_ttkt={xtype:'combo'
			 ,id:'status_ttkt'
			 ,hiddenName:'status_ttkt'
			 ,fieldLabel:'Tr\u1EA1ng th\u00E1i'
			 ,store:status_ttkts
			 ,displayField:'name'
			 ,valueField:'id'
			 ,typeAhead: true
			 ,triggerAction:'all'
			 ,mode:'local'
			 ,selectOnFocus:true
			 ,forceSelection:true
};

loai_ttkts=new Ext.data.ArrayStore({autoDestroy:true,fields: ['id','name'],data:[['',tatca],['0','\u0110\u1ECBnh k\u1EF3'],['1','\u0110\u1ED9t xu\u1EA5t']]})		
loai_ttkt={xtype:'combo'
		   ,id:'loai_ttkt'
		   ,hiddenName:'loai_ttkt'
 		   ,fieldLabel:'Lo\u1EA1i TTKT'
		   ,store:loai_ttkts
		   ,displayField:'name'
		   ,valueField:'id'
		   ,typeAhead: true
		   ,triggerAction:'all'
		   ,mode:'local'
		   ,selectOnFocus:true
		   ,forceSelection:true
};

hinhthuc_ttkts=new Ext.data.ArrayStore({autoDestroy:true,fields:['id','name'],data:[['',tatca],['0','Thanh tra'],['1','Ki\u1EC3m tra']]});
hinhthuc_ttkt={xtype:'combo'
		   	   ,id:'hinhthuc_ttkt'
			   ,hiddenName:'hinhthuc_ttkt'
			   ,fieldLabel:'H\u00ECnh th\u1EE9c'
			   ,store:hinhthuc_ttkts
			   ,displayField:'name'
			   ,valueField:'id'
			   ,typeAhead: true
			   ,triggerAction:'all'
			   ,mode:'local'
			   ,selectOnFocus:true
			   ,forceSelection:true
};  

donvi_ttkt={
	xtype:'compositefield'
    ,fieldLabel:'\u0110\u01A1n v\u1ECB \u0111\u01B0\u1EE3c TTKT'
    ,items:[{xtype:'textfield',width:60,readOnly:true,id:'ma_dv_ttkt'}
		    ,{xtype:'button',icon:'image/page_white_find.png',handler: function(){
		               setVal('','');
		        	   choncuc="1";
		        	   macuc=maCuc;
		        	   tencuc=tenCuc;
		        	   win=new Ext.Window({width:w,height:h,modal:true,items:new Ext.Panel({id:'lov',width:w,autoHeight:true})});
	        	   	   win.show();
	        	   	   lov=Ext.get('lov');   
		        	   lov.load({url:'system/lov_cqt.js',scripts:true}); 
		      }
		     }
		    ,{xtype:'displayfield',id:'ten_dv_ttkt',cls:'x-form-item-label'}    	 
		  ]
};  
tu_ngay={xtype:'datefield',id:'tu_ngay',fieldLabel:'Th\u1EDDi gian TTKT t\u1EEB',format:'d/m/Y'};
den_ngay={xtype:'datefield',id:'den_ngay',fieldLabel:'\u0110\u1EBFn',format:'d/m/Y'};

/*thoigian_ttkt={
	xtype:'compositefield'
	,fieldLabel:'Th\u1EDDi gian TTKT t\u1EEB'
    ,items:[{xtype:'datefield',id:'tu_ngay',format:'d/m/Y'}
            ,{xtype:'label',text:'\u0110\u1EBFn:',width:60,cls:'x-form-item-label'}
    		,{xtype:'datefield',id:'den_ngay',format:'d/m/Y'}
		   ]
};*/  

noidung_ttkt={
   xtype:'superboxselect'
   ,id:'noidung_ttkt'
   ,fieldLabel:'N\u1ED9i dung TTKT'
   ,emptyText:'N\u1ED9i dung TTKT...'
   ,resizable:false
   ,editable:false
   ,displayField:'name'
   ,valueField:'id'
   ,displayFieldTpl:'{name}'
   ,triggerAction: 'all'
   ,store: new Ext.data.JsonStore({
	    url:'jsonstore.do'
	    ,autoDestroy:true
	    ,root:'data'
	    ,baseParams:{method:'dsndttkt'}
	    ,idProperty:'id'
	    ,fields:['id','name']
   })
};

form=new Ext.FormPanel({
   layout:'column'
   ,autoHeight:true
   ,labelWidth:90
   //,bodyStyle:'padding:1px'
   ,defaults:{layout:'form'}
   ,items:
   [
     {columnWidth:.3,defaults:{anchor:'95%'},items:[loai_ttkt,hinhthuc_ttkt,status_ttkt]}
    ,{columnWidth:.25,defaults:{anchor:'95%'},items:[tu_ngay,{xtype:'textfield',fieldLabel:'M\u00E3 cu\u1ED9c TTKT',id:'ma_ttkt'}]}
    ,{columnWidth:.45,items:[den_ngay,donvi_ttkt,noidung_ttkt]}
   ]
   ,buttons:[
   	   { text:'T\u00ECm ki\u1EBFm'
	    ,icon:'image/search.gif'
	    ,handler: function(){gridStore.load();}
	   }
	  ,{text: 'In'
        ,icon:'image/printer.png'
        ,handler: function(){
          win=window.open('report.do','','');
		  win.focus();
        }
       }   
	  ,{text: 'Nh\u1EADp l\u1EA1i'
        ,icon:'image/table_edit.png'
        ,handler: function(){form.getForm().reset();}
       }  
   ]
});
grid=new Ext.grid.GridPanel({
  title:'K\u1EBFt qu\u1EA3 t\u00ECm ki\u1EBFm'
  ,autoHeight:true
  ,store: gridStore
  ,viewConfig:{forceFit:true}
  ,loadMask:true
  ,columnLines:true
  ,columns:[
           new Ext.grid.RowNumberer()
           ,{dataIndex:'id',hidden:true,sortable:true}
  		   ,{header:'M\u00E3',dataIndex:'ma',sortable:true,width:80}
  		   ,{header:'Ni\u00EAn \u0111\u1ED9',dataIndex:'nien_do',sortable:true,width:80}
           ,{header:'Lo\u1EA1i',dataIndex:'loai',sortable:true,width:50
           ,renderer: function(v) {return (v=='0')?'\u0110\u1ECBnh k\u1EF3':'\u0110\u1ED9t xu\u1EA5t';}
            }
           ,{header:'H\u00ECnh th\u1EE9c',dataIndex:'hinh_thuc',sortable:true,width:50
             ,renderer: function(v) {return (v=='0')?'Thanh tra':'Ki\u1EC3m tra';}
           }
           ,{header:'Tr\u1EA1ng th\u00E1i',dataIndex:'trang_thai',sortable:true,width:70}
           ,{header:'\u0110V \u0111\u01B0\u1EE3c TTKT',dataIndex:'ten_don_vi_bi',sortable:true,width:150}
           ]
  ,sm:new Ext.grid.RowSelectionModel({singleSelect:true,
  listeners: {
    rowselect: function(sm, index, record) {
      alert(record.data.id);
    }
  }
  })         
  ,bbar:new Ext.PagingToolbar({pageSize:10,store:gridStore,displayInfo:true,displayMsg: '{0} - {1} of {2}',emptyMsg: no_data_found_msg})
});

new Ext.Panel({
   renderTo:contentPanel
   ,frame:true
   ,title:'T\u00ECm ki\u1EBFm cu\u1ED9c Thanh tra Ki\u1EC3m Tra'
   ,items:[form,grid]
   ,keys:[{key:[Ext.EventObject.ENTER],handler:function(){gridStore.load();}}]
});
</script>
