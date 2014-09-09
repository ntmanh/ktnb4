<script>
store=new Ext.data.JsonStore({
    url:'jsonstore.do'
    ,autoDestroy:true
    ,root: 'data'
    ,totalProperty:'total'
    ,baseParams:{method:'dscanbo'}
    ,idProperty:'ma_canbo'
    ,fields:['ma_canbo','ten_canbo','ma_phong','ten_phong','ma_cqt','ten_cqt']
    ,remoteSort: true
});
store.setDefaultSort('ma_canbo','asc');

store.on('beforeload',function(s){
    s.setBaseParam('macuc',macuc);
    s.setBaseParam('macqt',macqt);
    s.setBaseParam('maphong',maphong);
});

tbar=new Ext.Toolbar();
if (choncqt=="1")
{
	if (choncuc=="1")
	{
		cucComboStore=new Ext.data.JsonStore({
		    url:'jsonstore.do'
		    ,autoDestroy:true
		    ,root:'data'
		    ,baseParams:{method:'cucComboStore'}
		    ,idProperty:'id'
		    ,fields: ['id','name']
		});
	    cucCombo={
	    	xtype:'combo'
	    	,id:'cucCombo'
	    	,width:80
	     	,store:cucComboStore
		    ,displayField: 'name'
		    ,valueField: 'id'
		    ,value:tencuc
	    	,typeAhead: true
            ,minChars:3
	     	,triggerAction: 'all'
	     	,selectOnFocus: true
	     	,forceSelection: true
	     	,listeners:{select: function(cmb,rec,idx) {
	          macuc=this.value;
	          maphong='*';
	          if (macuc=='000') macqt='00000';
	          else 				macqt='*'; 
	          cqtCombo=Ext.getCmp('cqtCombo');
	          cqtCombo.clearValue();
	          cqtComboStore.load();
	          cqtCombo.setValue(tatca);

	          phongCombo=Ext.getCmp('phongCombo');
	      	  phongCombo.clearValue();
	      	  phongComboStore.load();
	          phongCombo.setValue(tatca);
	          store.load();
	      }
	    }
	    };
	    tbar.add('C\u1EE5c thu\u1EBF:',' ',cucCombo);
    };

    cqtComboStore=new Ext.data.JsonStore({
    url:'jsonstore.do'
    ,autoDestroy:true
    ,root:'data'
    ,baseParams:{method:'cqtComboStore'}
    ,idProperty:'id'
    ,fields: ['id','name']});
    
	cqtComboStore.on('beforeload', function(s){s.setBaseParam('macuc',macuc);});

	cqtCombo={
	xtype:'combo'
	,id:'cqtCombo'
	,width:150
    ,store:cqtComboStore
    ,displayField: 'name'
    ,valueField: 'id'
    ,value:tencqt
    ,editable:false
    ,triggerAction: 'all'
    ,selectOnFocus: true
    ,forceSelection: true
    ,listeners:{select: function(cmb,rec,idx) {
	      macqt=this.getValue();
    	  maphong='*';
	      phongCombo=Ext.getCmp('phongCombo');
	      phongCombo.clearValue();
	      phongComboStore.load();
	      phongCombo.setValue(tatca);
    	  store.load();
      }
     }
 };
 tbar.add(' ','CQ thu\u1EBF:',' ',cqtCombo);
};


phongComboStore=new Ext.data.JsonStore({
    url:'jsonstore.do'
    ,autoDestroy:true
    ,root:'data'
    ,baseParams:{method:'phongComboStore'}
    ,idProperty:'id'
    ,fields: ['id','name']
});
phongComboStore.on('beforeload', function(s){s.setBaseParam('macqt',macqt);});

phongCombo={xtype:'combo'
				,id:'phongCombo'
				,width:150
     			,store:phongComboStore
			    ,displayField:'name'
			    ,valueField:'id'
			    ,value:tenphong
			    ,editable:false
		     	,triggerAction: 'all'
		     	,selectOnFocus: true
		     	,forceSelection: true
		     	,listeners:{select: function(cmb,rec,idx) {
		        	maphong=this.getValue();
			        store.load();
		       }
		     }
};
tbar.add(' ','Ph\u00F2ng:',' ',phongCombo);

new Ext.grid.GridPanel({
  title:'Danh s\u00E1ch c\u00E1n b\u1ED9'
  ,store: store
  ,renderTo: lov
  ,viewConfig:{forceFit:true}
  ,autoHeight:true
  ,loadMask:true
  ,columnLines:true
  ,columns:[
      {dataIndex:'ma_phong',hidden:true}
     ,{dataIndex:'ma_cqt',hidden:true}
	 ,{header:'M\u00E3',dataIndex:'ma_canbo',sortable:true,width:80}
	 ,{header:'T\u00EAn CB',dataIndex:'ten_canbo',sortable:true,width:150}
	 ,{header:'Ph\u00F2ng ban',dataIndex:'ten_phong',sortable:true,width:150}
	 ,{header:'CQT',dataIndex:'ten_cqt',sortable:true,width:150}
  ]
  ,sm:new Ext.grid.RowSelectionModel({singleSelect:true,
  listeners: {
    rowselect: function(sm, index, record){
      rd=record.data;
      setVal(rd.ma_canbo,rd.ten_canbo,rd.ma_cqt,rd.ten_cqt,rd.ma_phong,rd.ten_phong);
      win.close();
    }
  }
  })
  ,bbar:new Ext.PagingToolbar({
		 pageSize:10,
		 store: store,
		 displayInfo: true,
		 displayMsg: '{0} - {1} of {2}',
		 emptyMsg:no_data_found_msg,
		 items:['-','T\u00ECm ki\u1EBFm:',' ',new Ext.ux.form.SearchField({store:store,width:150,emptyText:enter_data_find_msg})]
  })
  ,tbar:tbar 
});
</script>