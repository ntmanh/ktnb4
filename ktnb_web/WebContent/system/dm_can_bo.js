<script>
maphong='*';
var status='*',ma_canbo='',ten_canbo='',del_method='';
var columRoleModel1=[
         {header:'Ng&#224;y hi&#7879;u l&#7921;c',dataIndex:'ngay_hieu_luc',width:50}
         ,{header:'T&#234;n',dataIndex:'name',width:200}
         ,{header:'Ch&#7885;n',dataIndex:'select',xtype:'checkcolumn',width:50}];
var columRoleModel=[
         {header:'M&#227;',dataIndex:'id',width:50}
         ,{header:'T&#234;n',dataIndex:'name',width:200}
         ,{header:'Quy&#7873;n',dataIndex:'role',xtype:'checkcolumn',width:50}
      ];
var gridRoleStore=new Ext.data.JsonStore({
    url:'jsonstore.do',autoDestroy:true,root: 'data',baseParams:{method:'dsrole'},idProperty:'id',fields:['id','name','role']
});

var updRole={
        text:'C&#7853;p nh&#7853;t quy&#7873;n',icon:'image/vcard_edit.png',handler:function(){
        var str='';
        Ext.each(gridRole.getStore().getRange(),function(record){
         role=record.data.role;
         if (role=='1'||role=='true') str+=record.data.id+',';
        });
        if (!Ext.isEmpty(str)) str=str.substring(0,str.length-1);
    Ext.Ajax.request({
                  params:{method:'updrole',id:ma_canbo,role:str},url:'ajax.do',
                  success: function(result,request){
                        json=Ext.util.JSON.decode(result.responseText);
                if (json.success) showMsg(json.msg,null);                                                   
                    else                  showErr(json.msg,null); 
                 }
                });
   }
};
var resetPass={id:'resetPass',text:'Reset',icon:'image/bin_closed.png'
    ,hidden:true,handler:function(){
        if (Ext.isEmpty(ma_canbo)) return;
         Ext.Msg.show({
           title      : 'Reset m\u1EADt kh\u1EA9u',
           msg        : 'B\u1EA1n ch\u1EAFc ch\u1EAFn mu\u1ED1n reset m\u1EADt kh\u1EA9u kh\u00F4ng?',
           width      : 300,
           buttons    : Ext.MessageBox.YESNO,
           fn         : myCallbackFunction,
           icon       : Ext.MessageBox.OK
        })
        
   }
};
var exitRole={
        text:'Tho&#225;t',icon:'image/cancel.gif',handler:function(){roleWin.hide();}
};
var gridRole=new Ext.grid.GridPanel({
  title:'Quy&#7873;n',id:'gridRole',store: gridRoleStore,viewConfig:{forceFit:true},width:300,autoHeight:true,
  loadMask:true,columnLines:true,columns:columRoleModel,bbar:[updRole,exitRole]
});

var roleWin=new Ext.Window({
width:300,height:400,autoScroll:true,closeAction:'hide',items:gridRole
});
var gridRoleDataStore=new Ext.data.JsonStore({
    url:'jsonstore.do',autoDestroy:true,root: 'data',baseParams:{method:'dsdata'},idProperty:'id',fields:['ngay_hieu_luc','name','select']
});
var updRoleData={
        text:'C&#7853;p nh&#7853;t',icon:'image/vcard_edit.png',handler:function(){
        var str='';
        var count =0;
        var select={};
        Ext.each(gridRoleData.getStore().getRange(),function(record){
        if(record.data.select){
                count++;
                select = record;
        }
        if(count>=2){
                        alert('Ch\u1EC9 ch\u1ECDn m\u1ED9t b\u1EA3n ghi');
                        return false;
                }
        });
        if(count==0){
                alert('Ch\u01B0a ch\u1ECDn b\u1EA3n ghi n\u00E0o');
                return;
        }if(count>=2){
                return;
        }
    Ext.Ajax.request({
                  params:{method:'chonNsd',id:ma_canbo,name:select.data.name},
                  url:'ajax.do',
                  success: function(result,request){
                        json=Ext.util.JSON.decode(result.responseText);
                if (json.success) showMsg(json.msg,null);                                                   
                    else                  showErr(json.msg,null); 
                 }
                });
   }
};

var exitRoleData={text:'Tho&#225;t',icon:'image/cancel.gif',handler:function(){roleDataWin.hide();}
};
var gridRoleData=new Ext.grid.GridPanel({
  title:'Quy&#7873;n',id:'gridRoleData',store: gridRoleDataStore,viewConfig:{forceFit:true},width:300,
  autoHeight:true,loadMask:true,columnLines:true,columns:columRoleModel1,bbar:[updRoleData,exitRoleData]
});
var roleDataWin=new Ext.Window({
width:300,height:400,autoScroll:true,closeAction:'hide',items:gridRoleData
});

var tbar=new Ext.Toolbar();
var editor=new Ext.ux.grid.RowEditor();
var phongEditComboStore=new Ext.data.JsonStore({
    url:'jsonstore.do',root:'data',baseParams:{method:'phongEditComboStore'},
    idProperty:'id',fields: ['id','name']
});
phongEditComboStore.on('beforeload', function(s) {
    s.setBaseParam('macqt',macqt);
});

var chucvuComboStore=new Ext.data.JsonStore({
    url:'jsonstore.do',autoDestroy:true,root:'data',baseParams:{method:'chucvuComboStore'}
    ,idProperty:'id',fields: ['id','name']
});

ktnb.phongComboEditType=Ext.extend(Ext.form.ComboBox,{
     store:phongEditComboStore
     ,displayField:'name',valueField:'id',editable:false,triggerAction: 'all'
     ,selectOnFocus: true,forceSelection: true,initComponent:function() {
        ktnb.phongComboEditType.superclass.initComponent.apply(this);
     }
});
Ext.reg('phongComboEditType',ktnb.phongComboEditType);

ktnb.chucvuComboEditType=Ext.extend(Ext.form.ComboBox,{
     store:chucvuComboStore,displayField:'name',valueField:'id'
     ,editable:false,triggerAction: 'all',selectOnFocus: true
     ,forceSelection: true,initComponent:function() {
        ktnb.chucvuComboEditType.superclass.initComponent.apply(this);
        chucvuComboStore.load();
     }
});
Ext.reg('chucvuComboEditType',ktnb.chucvuComboEditType);

var columModel=[
         {header:'M&#227;',dataIndex:'ma_canbo',sortable:true,width:70}
         ,{header:'T&#234;n CB',dataIndex:'ten_canbo',sortable:true,editor:{xtype:'textfield'},width:100}
         ,{header:'Ch&#7913;c v&#7909;',dataIndex:'ten_chucvu',sortable:true,editor:{xtype:'chucvuComboEditType'},width:80}
         ,{header:'Ph&#242;ng ban',dataIndex:'ten_phong',sortable:true,editor:{xtype:'phongComboEditType'},width:130}
         ,{header:'CQT',dataIndex:'ten_cqt',sortable:true,width:130}
         ,{header:'HL t&#7915;',dataIndex:'ngay_hluc_tu',align:'center',sortable:true,width:70}
         ,{header:'HL &#273;&#7871;n',dataIndex:'ngay_hluc_den',align:'center',sortable:true,width:70}
         ,{header:'T&#234;n NSD',dataIndex:'ten_nsd',sortable:true,width:70}
];
var record=Ext.data.Record.create([
                {name:'ma_canbo',type:'string'},{name:'ten_canbo',type:'string'},{name:'ten_chucvu',type:'string'}
                ,{name:'ten_phong',type:'string'},{name:'ten_cqt',type:'string'},{name:'ngay_hluc_tu',type:'string'}
                ,{name:'ngay_hluc_den',type:'string'},{name:'ten_nsd',type:'string'}]);

function configBtn(){
         resetPass = Ext.getCmp('resetPass');
         resetPass.setVisible(false);
         chonNsd = Ext.getCmp('chonNsd');
         delBtn=Ext.getCmp('deluser');
         updBtn=Ext.getCmp('capnhat');
         updDataBtn=Ext.getCmp('capnhatData');
         delBtn.setVisible(false);
         updBtn.setVisible(false);
         updDataBtn.setVisible(false);
         chonNsd.setVisible(false);
         del_method='';   
         if (status=='is_user'){
           updDataBtn.setVisible(true);
       	   updBtn.setVisible(true);
           delBtn.setVisible(true);
           delBtn.setText('Kh&#243;a');
           delBtn.setIcon('image/lock.png');
           del_method='lock_user';
           resetPass.setVisible(true);
         }else if (status=='is_not_user'){
           //if(tenNsd.toLowerCase()=="internal_ktnb"){
           delBtn.setVisible(true);
           delBtn.setText('T&#7841;o NSD');
           delBtn.setIcon('image/user_add.png');
           del_method='create_user';       
           //}
           chonNsd.setVisible(false);
         }else if (status=='is_locked_user'){
           delBtn.setVisible(true);
           delBtn.setText('M&#7903; kh&#243;a NSD');
           delBtn.setIcon('image/lock_open.png');
       del_method='unlock_user';
         }else if (status=='is_effect'){
           delBtn.setVisible(true);
           delBtn.setText('X&#243;a CB');
           delBtn.setIcon('image/user_delete.png');
       del_method='delete_user';
         }
};

var statusComboStore = new Ext.data.ArrayStore({
        fields: ['id','name'],data : [['*','T\u1EA5t c\u1EA3'],['is_user','L\u00E0 NSD']
            ,['is_not_user','Ch\u01B0a l\u00E0 NSD'],['is_locked_user','B\u1ECB kh\u00F3a']
            ,['is_effect','Hi\u1EC7u l\u1EF1c'],['is_not_effect','H\u1EBFt hi\u1EC7u l\u1EF1c']]
});

var statusCombo={
   xtype:'combo',id:'statusCombo',width:80,store:statusComboStore  
   ,displayField:'name',valueField:'id',value:'T\u1EA5t c\u1EA3',typeAhead: true
   //,editable:false
   ,triggerAction: 'all',mode:'local',selectOnFocus:true,forceSelection:true
   ,listeners:{
    'select': function(cmb,rec,idx) {
         status=this.getValue();
         gridStore.load();
         configBtn();
      }
   }
};
tbar.add('      Tr&#7841;ng th&#225;i:  ',statusCombo);

if (cuc<2)
{
        if (cuc<1)
        {
                var cucComboStore=new Ext.data.JsonStore({
                    url:'jsonstore.do',autoDestroy:true,root:'data',baseParams:{method:'cucComboStore'},idProperty:'id',fields: ['id','name']
                });
            var cucCombo={
                xtype:'combo',id:'cucCombo'
                ,width:100,store:cucComboStore,displayField: 'name',valueField: 'id',typeAhead: true
            ,minChars:3,triggerAction: 'all',selectOnFocus: true,forceSelection: true
                ,listeners:{select: function(cmb,rec,idx) {
                  macuc=this.value;maphong='*';
                  if (macuc=='000') macqt='00000';
                  else                          macqt='*'; 
                  cqtCombo=Ext.getCmp('cqtCombo');
                  cqtCombo.clearValue();
                  cqtComboStore.load();
                  cqtCombo.setValue(tatca);

                  phongCombo=Ext.getCmp('phongCombo');
                  phongCombo.clearValue();
                  phongComboStore.load();
                  phongCombo.setValue(tatca);
                  gridStore.load();
                  //them moi
                  phongEditComboStore.load();
                  btnThemmoi=Ext.getCmp('themmoi');
                  if (macqt!='*') btnThemmoi.setVisible(false); 
                          else            btnThemmoi.setVisible(false);
              }
            }
            };
            tbar.add('C&#417; quan thu&#7871;:',' ',cucCombo);
    };

    var cqtComboStore=new Ext.data.JsonStore({
    url:'jsonstore.do',autoDestroy:true,root:'data'
    ,baseParams:{method:'cqtComboStore'}
    ,idProperty:'id',fields: ['id','name']});
        cqtComboStore.on('beforeload', function(s){s.setBaseParam('macuc',macuc);});

        var cqtCombo={
                xtype:'combo',id:'cqtCombo',width:170,store:cqtComboStore
            ,displayField: 'name',valueField: 'id',editable:false,triggerAction: 'all',selectOnFocus: true,forceSelection: true
            ,listeners:{select: function(cmb,rec,idx) {
              macqt=this.getValue();maphong='*';
              phongCombo=Ext.getCmp('phongCombo');
              phongCombo.clearValue();
              phongComboStore.load();
              phongCombo.setValue(tatca);
          gridStore.load();
          //them moi
          phongEditComboStore.load();
          btnThemmoi=Ext.getCmp('themmoi');
          if (macqt!='*') btnThemmoi.setVisible(false); 
                  else            btnThemmoi.setVisible(false);
      }
     }
        };
        tbar.add(' ','CQ thu\u1EBF c\u1EA5p d\u01B0\u1EDBi:',' ',cqtCombo);
};

var phongComboStore=new Ext.data.JsonStore({
    url:'jsonstore.do',autoDestroy:true
    ,root:'data',baseParams:{method:'phongComboStore'}
    ,idProperty:'id',fields: ['id','name']
});

phongComboStore.on('beforeload', function(s) {
    s.setBaseParam('macqt',macqt);
});

var phongCombo={xtype:'combo'
                                ,id:'phongCombo',width:170,store:phongComboStore,displayField:'name',valueField:'id'
                            ,editable:false,triggerAction: 'all',selectOnFocus: true,forceSelection: true
                        ,listeners:{select: function(cmb,rec,idx) {
                                maphong=this.getValue();gridStore.load();
                       }
                     }
};
tbar.add(' ','Ph\u00F2ng/ban:',' ',phongCombo);
var themmoi={id:'themmoi',text:'Th\u00EAm',icon:'image/add7.jpg',hidden:true
        ,handler:function(){
           editor.stopEditing();
           gridStore.insert(0,new record());
           grid.getSelectionModel().selectRow(0);
           editor.startEditing(0);
   }
};
var chonNsd={id:'chonNsd',text:'Ch&#7885;n ng&#432;&#7901;i d&#249;ng',icon:'image/user_edit.png'
    ,hidden:true,handler:function(){
        if (Ext.isEmpty(ma_canbo)||(status!='is_not_user')) return;
        gridRoleDataStore.load({params:{'parentId':ma_canbo}});
        gridRoleData.setTitle('Ch&#7885;n ng&#432;&#7901;i d&#249;ng');
        roleDataWin.show();
   }
};
var capnhat={id:'capnhat',text:'Quy\u1EC1n truy c\u1EADp',icon:'image/shape_square_key.png'
    ,hidden:true//,disabled:true
        ,handler:function(){
          if (Ext.isEmpty(ma_canbo)||(status!='is_user')) return;
      gridRoleStore.load({params:{'parentId':ma_canbo}});
      gridRole.setTitle('C\u1EADp nh\u1EADt quy\u1EC1n : '+ten_canbo);
      roleWin.show();
   }
};
var capnhatData={id:'capnhatData',text:'Quy\u1EC1n qu\u1EA3n l\u00FD',icon:'image/user_edit.png'
    ,hidden:true,handler:function(){
          if (Ext.isEmpty(ma_canbo)||(status!='is_user')) return;
      gridRoleDataStore.load({params:{'parentId':ma_canbo}});
      gridRoleData.setTitle('C\u1EADp nh\u1EADt : '+ten_canbo);
      roleDataWin.show();
   }
};
var deluser={id:'deluser',hidden:true,handler:function(){
if (Ext.isEmpty(ma_canbo)||Ext.isEmpty(del_method)) return;
msg=Ext.getCmp('deluser').getText()+' : '+ ten_canbo+' ?';
Ext.Msg.show({
 title:'X\u00E1c nh\u1EADn'
 ,msg:msg
 ,buttons:Ext.MessageBox.YESNO
 ,icon: Ext.MessageBox.QUESTION
 ,fn: function(btn){
 if (btn == 'yes'){
        Ext.Ajax.request({
          params:{method:del_method,id:ma_canbo},
          url:'ajax.do',
          success:function(result,request){
                 json=Ext.util.JSON.decode(result.responseText);
             if (json.success){
               showMsg(json.msg,null);
               gridStore.load();                                            
               //del_method=null;
             }
                 else  showErr(json.msg,null); 
          }
        });
  }
 }
});
}
};

var gridStore=new Ext.data.JsonStore({
    url:'jsonstore.do',autoDestroy:true,root: 'data',totalProperty:'total',baseParams:{method:'dscanbo'}
    ,idProperty:'ma_canbo',fields:record,remoteSort: true,writer: new Ext.data.JsonWriter()
});
gridStore.setDefaultSort('ma_canbo','asc');
gridStore.on('beforeload',function(s){
    s.setBaseParam('macuc',macuc);s.setBaseParam('macqt',macqt);s.setBaseParam('maphong',maphong);
    s.setBaseParam('status',status);ma_canbo=null;ten_canbo=null;
});
gridStore.on('update',function(){gridStore.load();});
//displayMsg: '{0}- {1} of {2}',
var pagingToolbar=new Ext.PagingToolbar({
 pageSize:10,store: gridStore,displayInfo: true,displayMsg: '',emptyMsg:no_data_found_msg,
 items:['-','T\u00ECm ki\u1EBFm:',' ',new Ext.ux.form.SearchField({store:gridStore,width:150,emptyText:enter_data_find_msg}),'-',
 themmoi,capnhat,capnhatData,deluser,chonNsd,resetPass]
});

var grid=new Ext.grid.GridPanel({
  store: gridStore,renderTo: contentPanel,viewConfig:{forceFit:true}
  ,autoHeight:true,loadMask:true,columnLines:true,columns:columModel,sm:new Ext.grid.RowSelectionModel({singleSelect:true,
  listeners: {
    rowselect: function(sm, index, record) {
      ma_canbo=record.data.ma_canbo;
      ten_canbo=record.data.ten_canbo;
    }
  }
  })
  ,plugins:[editor]
  ,bbar:pagingToolbar
  ,tbar:tbar 
});
var myCallbackFunction = function(btn) {
                if(btn=='yes'){
                         Ext.Ajax.request({
                                          params:{method:'reset',id:ma_canbo},url:'ajax.do',
                                          success: function(result,request){
                                                json=Ext.util.JSON.decode(result.responseText);
                                        if (json.success) showMsg(json.msg,null);                                                   
                                            else                  showErr(json.msg,null); 
                                         }
                                        });
                }
            }
</script>