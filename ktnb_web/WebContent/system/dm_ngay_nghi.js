<script>
var nam = (new Date()).getFullYear();

var columModel=[
     {header:'M\u00E3',dataIndex:'ma',sortable:true,width:70}
    ,{header:'Ng\u00E0y ngh\u1EC9',dataIndex:'ngay_nghi',sortable:true,editor:{xtype:'textfield'},width:265}
    ,{header:'M\u00F4 t\u1EA3',dataIndex:'mo_ta',sortable:true,editor:{xtype:'textfield'},width:265}
];

var  record=Ext.data.Record.create([
	{name:'ma',type:'string'}
	,{name:'ngay_nghi',type:'string'}
	,{name:'mo_ta',type:'string'}
]);

var gridStore=new Ext.data.JsonStore({
    url:'jsonstore.do'
    ,autoDestroy:true    
    ,root: 'data'
    ,totalProperty:'total'
    ,baseParams:{method:'dsngaynghi'}
    ,idProperty:'ma'
    ,fields:record
    ,remoteSort: true
    ,writer: new Ext.data.JsonWriter()
});

gridStore.setDefaultSort('ma','asc');

gridStore.on('beforeload',function(s){
    s.setBaseParam('nam',nam);
});

gridStore.on('update',function(){gridStore.load();});

gridStore.on('create',function(){gridStore.load();});

gridStore.on('afteredit',function(){gridStore.load();});

editor=new Ext.ux.grid.RowEditor();
var tbar=new Ext.Toolbar();

namComboStore=new Ext.data.JsonStore({
    url:'jsonstore.do'
    ,autoDestroy:true
    ,root:'data'
    ,baseParams:{method:'namComboStore'}
    ,idProperty:'id'
    ,fields: ['id','name']
});

namCombo={
   xtype: 'combo'
   ,width:100
   ,store: namComboStore
   ,displayField: 'name'
   ,valueField: 'id'
   ,typeAhead: true
         ,minChars:3
         ,triggerAction: 'all'
         ,selectOnFocus: true
         ,forceSelection: true
         ,listeners: {
      	 'select': function(cmb,rec,idx) {
          nam=this.value;		                   
          gridStore.load();
      }
   },
   value: nam
}
tbar.add(' ','Ch\u1ECDn n\u0103m:',' ',namCombo);

var themmoi={
	id:'themmoi'
	,text:'Th\u00EAm m\u1EDBi'
	,icon:'image/add7.jpg'
	,handler:function(){
  	   editor.stopEditing();
	   gridStore.insert(0,new record());
	   grid.getSelectionModel().selectRow(0);
	   editor.startEditing(0);
   }
};

pagingToolbar=new Ext.PagingToolbar({
 pageSize:10,
 store: gridStore,
 displayInfo: true,
 displayMsg: '{0} - {1} of {2}',
 emptyMsg:no_data_found_msg,
 items:['-',themmoi,'-']

});

new Ext.grid.GridPanel({
  store: gridStore
  ,renderTo:contentPanel
  ,viewConfig:{forceFit:true}
  ,autoHeight:true
  ,loadMask:true
  ,columnLines:true
  ,columns:columModel
  ,plugins: [editor]
  ,bbar:pagingToolbar
  ,tbar:tbar
});

gridStore.load();
</script>