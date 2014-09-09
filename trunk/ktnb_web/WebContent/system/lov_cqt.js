<script>
store=new Ext.data.JsonStore({
    url:'jsonstore.do'
	,autoDestroy:true
    ,root: 'data'
    ,totalProperty:'total'
    ,baseParams:{method:'dscqt'}
    ,idProperty:'ma'
    ,fields:['ma','ten']
    ,remoteSort:true
});
store.setDefaultSort('ma','asc');
store.on('beforeload',function(s){
    s.setBaseParam('parentId',macuc);
});

tbar=new Ext.Toolbar();
if (choncuc=="1") {
	cucComboStore=new Ext.data.JsonStore({
		url:'jsonstore.do'
	    ,autoDestroy:true
	    ,root:'data'
	    ,baseParams:{method:'cucComboStoreAll'}
	    ,idProperty:'id'
	    ,fields:['id','name']
	});
	cucCombo={
	   xtype:'combo'
	   ,id:'cucCombo'
	   ,width:100
	   ,store:cucComboStore
	   ,displayField:'name'
	   ,valueField:'id'
   	   //,value:tencuc
	   ,typeAhead:true
       ,minChars:3
	   ,triggerAction: 'all'
	   ,selectOnFocus: true
	   ,forceSelection: true
	   ,listeners: {
	      'select': function(cmb,rec,idx) {
	         macuc=this.getValue();
	         store.load();
	      }
	   }
	};
	tbar.add(' ','C\u1EE5c thu\u1EBF:',' ',cucCombo);
};

tbar.add(' ','T\u00ECm ki\u1EBFm:',' ',new Ext.ux.form.SearchField({id:'searchField',store:store,width:150,emptyText:enter_data_find_msg}));

new Ext.grid.GridPanel({
  title:'Danh s\u00E1ch c\u01A1 quan thu\u1EBF'
  ,store: store
  ,renderTo:lov
  ,autoHeight:true
  ,viewConfig:{forceFit:true}
  ,loadMask:true
  ,columnLines:true
  ,columns:[{header:'M\u00E3',dataIndex:'ma',sortable:true,width:70}
           ,{header:'T\u00EAn',dataIndex:'ten',sortable:true,width:200}
           ]
  ,sm:new Ext.grid.RowSelectionModel({singleSelect:true,
   listeners:{rowselect:function(sm,index,record){
      rd=record.data;
      setVal(rd.ma,rd.ten);
      win.close();
    }
   }
  })         
  ,bbar:new Ext.PagingToolbar({
 	pageSize:10
	,store:store
 	,displayInfo:true
 	,displayMsg: '{0} - {1} of {2}'
 	,emptyMsg: no_data_found_msg 
   })
  ,tbar:tbar 
});
</script>