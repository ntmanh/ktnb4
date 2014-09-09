<script>
var cucComboStore=new Ext.data.JsonStore({
    url:'jsonstore.do'
    ,autoDestroy:true
    ,root:'data'
    ,baseParams:{method:'cucComboStoreAll'}
    ,idProperty:'id'
    ,fields:['id','name']
});
var cucCombo={
   xtype:'combo'
   ,id:'cucCombo'
   ,width:110
   ,store: cucComboStore
   ,displayField:'name'
   ,valueField:'id'
   ,typeAhead: true
   ,minChars:3
   ,triggerAction: 'all'
   ,selectOnFocus: true
   ,forceSelection: true
   ,listeners: {
      'select': function(cmb,rec,idx) {
         parentId=this.getValue();
         gridStore.load();
      }
   }
};
var gridStore=new Ext.data.JsonStore({
    url:'jsonstore.do'
	,autoDestroy:true
    ,root: 'data'
    ,totalProperty:'total'
    ,baseParams:{method:'dscqt'}
    ,idProperty:'ma'
    ,fields:['ma','ten']
    ,remoteSort:true
});
gridStore.setDefaultSort('ma','asc');
gridStore.on('beforeload',function(s){
    s.setBaseParam('parentId',parentId);
});

var pagingToolbar=new Ext.PagingToolbar({
 pageSize:10
 ,store:gridStore
 ,displayInfo:true
 ,displayMsg: '{0} - {1} of {2}'
 ,emptyMsg: no_data_found_msg 
});

var tbar=new Ext.Toolbar({items:['C&#417; quan thu&#7871;:',' ',cucCombo,' ',
'T\u00ECm ki\u1EBFm:',' ',new Ext.ux.form.SearchField({store:gridStore,width:150,emptyText:enter_data_find_msg})]
});

var grid=new Ext.grid.GridPanel({
  store: gridStore
  ,renderTo:contentPanel
  ,viewConfig:{forceFit:true}
  ,autoHeight:true
  ,loadMask:true
  ,columnLines:true
  ,columns:[{header:'M\u00E3',dataIndex:'ma',sortable:true,width:70}
           ,{header:'T\u00EAn',dataIndex:'ten',sortable:true,width:300}]
  ,bbar:pagingToolbar
  ,tbar:tbar 
});
</script>