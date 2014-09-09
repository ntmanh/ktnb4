<script>
macuc=maCuc;
macqt=maCqt;

var  record=Ext.data.Record.create([
	{name:'ma',type:'string'}
	,{name:'ten',type:'string'}
	,{name:'ten_cqt',type:'string'}
]);

var columModel=[
     {header:'M\u00E3',dataIndex:'ma',sortable:true,width:70}
    ,{header:'T\u00EAn',dataIndex:'ten',sortable:true,editor:{xtype:'textfield'},width:265}
    ,{header:'T\u00EAn CQT',dataIndex:'ten_cqt',sortable:true,width:265}
];


var gridStore=new Ext.data.JsonStore({
    url:'jsonstore.do'
    ,autoDestroy:true    
    ,root: 'data'
    ,totalProperty:'total'
    ,baseParams:{method:'dsphong'}
    ,idProperty:'ma'
    ,fields:record
    ,remoteSort: true
    ,writer: new Ext.data.JsonWriter()
});
gridStore.setDefaultSort('ma','asc');
gridStore.on('beforeload',function(s){
    s.setBaseParam('macuc',macuc);
    s.setBaseParam('macqt',macqt);
});
gridStore.on('update',function(){gridStore.load();});

editor=new Ext.ux.grid.RowEditor();
var tbar=new Ext.Toolbar();

if (cuc<2){
  if (cuc<1){
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
		   ,typeAhead: true
           ,minChars:3
           ,triggerAction: 'all'
           ,selectOnFocus: true
           ,forceSelection: true
           ,listeners: {
		      'select': function(cmb,rec,idx) {
		          Ext.getCmp('themmoi').setDisabled(true);
		          macuc=this.value;		          
		          macqt='*';
		          cqtCombo=Ext.getCmp('cqtCombo');
		          btnThemmoi=Ext.getCmp('themmoi');
			      if(macuc=='000') {
		         	btnThemmoi.setDisabled(false);
		          }
		          cqtCombo.clearValue();
		          cqtComboStore.load();
		          cqtCombo.setValue(tatca);
		          gridStore.load();
		      }
		   }
		};
		tbar.add(' ','C&#417; quan thu&#7871;:',' ',cucCombo);
   };
   
var cqtComboStore=new Ext.data.JsonStore({
	    url:'jsonstore.do'
        ,autoDestroy:true
	    ,root:'data'
	    ,baseParams:{method:'cqtComboStore'}
	    ,idProperty:'id'
	    ,fields: ['id','name']
	});
cqtComboStore.on('beforeload', function(s){s.setBaseParam('macuc',macuc);});

var cqtCombo={
	   xtype:'combo'
	   ,id:'cqtCombo'
	   ,width:170
	   ,store:cqtComboStore
	   ,displayField: 'name'
	   ,valueField:'id'
	   ,editable:false
	   ,triggerAction: 'all'
	   ,selectOnFocus:true
	   ,forceSelection:true
	   ,listeners: {
	      'select': function(cmb,rec,idx) {
	         macqt=this.getValue();
	         gridStore.load();
	         btnThemmoi=Ext.getCmp('themmoi');
	         if (macqt!='*') btnThemmoi.setDisabled(false); 
	         else            btnThemmoi.setDisabled(false);
	      }
	   }
	};
	tbar.add(' ','CQ thu&#7871; c&#7845;p d&#432;&#7899;i:',' ',cqtCombo);
};	
tbar.add(' ','T\u00ECm ki\u1EBFm:',' ',new Ext.ux.form.SearchField({store:gridStore,width:150,emptyText:enter_data_find_msg}));

var themmoi={
	id:'themmoi'
	,disabled:true
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

</script>