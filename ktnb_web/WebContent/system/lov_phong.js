<script>
store=new Ext.data.JsonStore({
    url:'jsonstore.do'
    ,autoDestroy:true    
    ,root: 'data'
    ,totalProperty:'total'
    ,baseParams:{method:'dsphong'}
    ,idProperty:'ma'
    ,fields:['ma','ten','ma_cqt','ten_cqt']
    ,remoteSort: true
});
store.setDefaultSort('ma','asc');
store.on('beforeload',function(s){
    s.setBaseParam('macuc',macuc);
    s.setBaseParam('macqt',macqt);
});
tbar=new Ext.Toolbar();
if (choncqt=="1"){
  if (choncuc=="1") {
	cucComboStore=new Ext.data.JsonStore({
	    url:'jsonstore.do'
	    ,autoDestroy:true
	    ,root:'data'
	    ,baseParams:{method:'cucComboStore'}
	    ,idProperty:'id'
	    ,fields: ['id','name']
	});
		
	cucCombo={
	   xtype: 'combo'
	   ,width:100
	   ,store: cucComboStore
	   ,displayField: 'name'
	   ,valueField: 'id'
	   ,value:tencuc
	   ,typeAhead: true
       ,minChars:3
	   ,triggerAction: 'all'
	   ,selectOnFocus: true
	   ,forceSelection: true
	   ,listeners: {
	      'select': function(cmb,rec,idx) {
	          macuc=this.value;
	          macqt='*';
	          cqtCombo=Ext.getCmp('cqtCombo');
	          cqtCombo.clearValue();
	          cqtComboStore.load();
	          cqtCombo.setValue(tatca);
	          gridStore.load();
	      }
	   }
	};
	tbar.add(' ','C\u1EE5c thu\u1EBF:',' ',cucCombo);
};
   
    cqtComboStore=new Ext.data.JsonStore({
	    url:'jsonstore.do'
        ,autoDestroy:true
	    ,root:'data'
	    ,baseParams:{method:'cqtComboStore'}
	    ,idProperty:'id'
	    ,fields: ['id','name']
	});
	cqtComboStore.on('beforeload',function(s){s.setBaseParam('macuc',macuc);});
	
	cqtCombo={
	   xtype:'combo'
	   ,id:'cqtCombo'
	   ,width:170
	   ,store:cqtComboStore
	   ,displayField:'name'
	   ,valueField:'id'
	   ,value:tencqt
	   ,editable:false
	   ,triggerAction:'all'
	   ,selectOnFocus:true
	   ,forceSelection:true
	   ,listeners: {
	      'select': function(cmb,rec,idx) {
	         macqt=this.getValue();
	         gridStore.load();
	      }
	   }
	};
	tbar.add(' ','CQ thu\u1EBF:',' ',cqtCombo);
};	
new Ext.grid.GridPanel({
  title:'Danh s\u00E1ch ph\u00F2ng ban'
  ,store: store
  ,renderTo:lov
  ,viewConfig:{forceFit:true}
  ,autoHeight:true
  ,loadMask:true
  ,columnLines:true
  ,columns:[
     {dataIndex:'ma_cqt',hidden:true}
    ,{header:'M\u00E3',dataIndex:'ma',sortable:true,width:70}
    ,{header:'T\u00EAn',dataIndex:'ten',sortable:true,width:190}
    ,{header:'CQT',dataIndex:'ten_cqt',sortable:true,width:190}
   ]
  ,sm:new Ext.grid.RowSelectionModel({singleSelect:true,
   listeners:{rowselect:function(sm,index,record){
      rd=record.data;
      setVal(rd.ma,rd.ten,rd.ma_cqt,rd.ten_cqt);
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
	 items:['-','T\u00ECm ki\u1EBFm:',' ',new Ext.ux.form.SearchField({store:store,width:120,emptyText:enter_data_find_msg})]
 })
 ,tbar:tbar
});
</script>