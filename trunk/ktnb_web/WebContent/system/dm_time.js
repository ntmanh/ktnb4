<script>
var timeComboStore=new Ext.data.ArrayStore({
        fields: ['id','name']
        ,data:[['12','Th\u1EDDi h\u1EA1n Thanh tra Ki\u1EC3m tra']
	    ,['1701','Th\u1EDDi h\u1EA1n Khi\u1EBFu n\u1EA1i']
	    ,['1703','Th\u1EDDi h\u1EA1n T\u1ED1 c\u00E1o']]
});

var timeCombo={
   xtype:'combo'
   ,width:170
   ,store:timeComboStore
   ,displayField:'name'
   ,valueField:'id'
   ,typeAhead: true
   ,triggerAction:'all'
   ,mode:'local'
   ,selectOnFocus:true
   ,forceSelection:true
   ,listeners:{
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
    ,baseParams:{method:'dstime'}
    ,idProperty:'ma'
    ,fields:['ma','ten','thoigian']
	,writer: new Ext.data.JsonWriter()
});
gridStore.on('beforeload',function(s){s.setBaseParam('parentId',parentId);});
gridStore.on('update',function(){gridStore.load();});
var editor=new Ext.ux.grid.RowEditor();
var tbar=new Ext.Toolbar({items:timeCombo});
var grid=new Ext.grid.GridPanel({
  store: gridStore
  ,renderTo:contentPanel
  ,autoHeight:true
  ,columnLines:true
  ,columns:[
	  {header:'M\u00E3',dataIndex:'ma',width:100}
	 ,{header:'T\u00EAn',dataIndex:'ten',width:450}
	 ,{header:'Ng\u00E0y',dataIndex:'thoigian',width:50,editor:{xtype:'spinnerfield',minValue: 1,maxValue: 90,defaultValue:1,incrementValue:1}}
   ]
  ,plugins:[editor]
  ,tbar:tbar
});
</script>