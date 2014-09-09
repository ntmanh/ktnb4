<script>
var KNTCData = [['Khi\u1EBFu n\u1EA1i','1'],['T\u1ED1 c\u00E1o','2'],['Tr\u01B0\u1EDDng h\u1EE3p kh\u00E1c','3']];
var KNTCStore=new Ext.data.ArrayStore({
    fields: ['name', 'value'],
    data : KNTCData
});
var loaiKNTCCombo={
    xtype:'combo',
    store: KNTCStore,
    displayField: 'name',
    valueField: 'value',
    typeAhead: true,
    editable: true,
    mode: 'local',
    forceSelection: true,
    triggerAction: 'all',
    fieldLabel: 'Tr\u01B0\u1EDDng h\u1EE3p',
    emptyText: 'Ch\u1ECDn tr\u01B0\u1EDDng h\u1EE3p...',
    selectOnFocus: true
}
var chungCuMoiData = [['C\u00F3 ch\u1EE9ng c\u1EE9 m\u1EDBi','1'],['Kh\u00F4ng c\u00F3 ch\u1EE9ng c\u1EE9 m\u1EDBi','2']];
var chungCuMoiStore=new Ext.data.ArrayStore({
    fields: ['name', 'value'],
    data : chungCuMoiData
});
var chungCuMoiCombo={
    xtype:'combo',
    store: chungCuMoiStore,
    displayField: 'name',
    valueField: 'value',
    typeAhead: true,
    editable: true,
    mode: 'local',
    forceSelection: true,
    triggerAction: 'all',
    fieldLabel: 'Ch\u1EE9ng c\u1EE9 m\u1EDBi',
    emptyText: 'Ch\u1ECDn tr\u01B0\u1EDDng h\u1EE3p...',
    selectOnFocus: true
}
var stdForm = new Ext.FormPanel({
	title: 'S&#7893; ti&#7871;p d&#226;n',bodyStyle: 'padding:5px',renderTo:contentPanel,autoHeight:true,autoWidth:true,frame:true,
	labelWidth: 150,buttonAlign : 'center',
	items: {
            xtype:'tabpanel',activeTab: 0,defaults:{autoHeight:true, bodyStyle:'padding:10px 25px 10px 10px',autoWidth:true},            
            items:[{            	
            	//Tab thong tin chung
                title:'Th&#244;ng tin chung',layout:'form',defaults: {},defaultType: 'textfield',
                items: [{
                	//FIELDSET Thong tin cong dan
	                xtype: 'fieldset',layout:'column',
	                title: 'Th&#244;ng tin c&#244;ng d&#226;n',autoHeight: true,autoWidth: true,
	                items:[
	                {columnWidth:.5,layout: 'form',border:false,defaults: {bodyStyle:'padding:5px'},
			                	items: [
			                	{xtype: 'textfield',name:"txtNgayTiepCD",fieldLabel: 'Ng&#224;y ti&#7871;p',anchor: '100%'},
			                	{xtype: 'textfield',name:"txtHoTenCD",fieldLabel: 'H&#7885; t&#234;n',anchor: '100%'},
			                	{xtype: 'textfield',name:"txtChucVuCD",fieldLabel: 'Ch&#7913;c v&#7909;',anchor: '100%'},
			                	{xtype: 'textfield',name:"txtNoiCongTacCD",fieldLabel: 'N&#417;i c&#244;ng t&#225;c',anchor: '100%'},
			                	{xtype: 'textfield',name:"txtDiaChi",fieldLabel: '&#272;&#7883;a ch&#7881;',anchor: '100%'},
			                	{xtype: 'textfield',name:"txtSoDienThoai",fieldLabel: 'S&#7889; &#273;i&#7879;n tho&#7841;i',anchor: '100%'}]
			      			},{columnWidth:.5,layout: 'form',border:false,style:'margin-left: 15px',
			                	items: [
			                	{xtype: 'textfield',name:"txtSoCMT",fieldLabel: 'CMT/H&#7897; chi&#7871;u',anchor: '100%'},
			                	{xtype: 'textfield',name:"txtNoiCap",fieldLabel: 'N&#417;i c&#7845;p',anchor: '100%'},
			                	{xtype: 'textfield',name:"txtNgayCap",fieldLabel: 'Ng&#224;y c&#7845;p',anchor: '100%'},
			                	{xtype: 'textfield',name:"txtMST",fieldLabel: 'M&#227; s&#7889; thu&#7871;',anchor: '100%'},
			                	{xtype: 'checkbox',name:"cbxLuatSu",fieldLabel: 'Lu&#7853;t s&#432;',boxLabel: 'C&#243; lu&#7853;t s&#432;',anchor: '100%'}]
			            }]
                	},{
                	//FIELDSET Thong tin can bo tiep dan
	                xtype: 'fieldset',layout:'column',
	                title: 'Th&#244;ng tin c&#225;n b&#7897; ti&#7871;p d&#226;n',autoHeight: true,autoWidth: true,
	                items:[{columnWidth:.5,layout: 'form',border:false,defaults: {bodyStyle:'padding:5px'},
			                	items:[
			                	{xtype: 'textfield',name:"txtNoiTiepCD",fieldLabel: 'N&#417;i ti&#7871;p',anchor: '100%'},
			                	{xtype: 'textfield',name:"txtHoTenCBTD",fieldLabel: 'H&#7885; t&#234;n c&#225;n b&#7897;',anchor: '100%'}]
			      			},{columnWidth:.5,layout: 'form',border:false,style:'margin-left: 15px',
			                	items:[
			                	{xtype: 'textfield',name:"txtChuVuCBTD",fieldLabel: 'Ch&#7913;c v&#7909;',anchor: '100%'},
			                	{xtype: 'textfield',name:"txtBoPhanCongTacCBTD",fieldLabel: 'B&#7897; ph&#7853;n c&#244;ng t&#225;c',anchor: '100%'}]
			            }]
                	},{
                	//FIELDSET Cac truong hop
	                xtype: 'fieldset',layout:'column',
	                title: 'C&#225;c tr&#432;&#7901;ng h&#7907;p',autoHeight: true,autoWidth: true,
	                items:[{columnWidth:.5,layout: 'form',border:false,defaults: {bodyStyle:'padding:5px'},
			                	items:[loaiKNTCCombo]
			      			},{columnWidth:.5,layout: 'form',border:false,style:'margin-left: 15px',
			                	items:[{xtype: 'checkbox',name:"cbxUyQuyen",fieldLabel: 'Kh\u00F4ng ph\u1EA3i khi\u1EBFu n\u1EA1i tr\u1EF1c ti\u1EBFp',boxLabel: '\u0110\u01B0\u1EE3c s\u1EF1 \u1EE7y quy\u1EC1n c\u1EE7a c\u00E1 nh\u00E2n/t\u1ED5 ch\u1EE9c',anchor: '100%'}]
			            }]
                	},{
                	//FIELDSET Truong hop don da duoc giai quyet
	                xtype: 'fieldset',layout:'form',autoHeight: true,autoWidth: true,
	                title: 'Tr&#432;&#7901;ng h&#7907;p &#273;&#417;n &#273;&#227; &#273;&#432;&#7907;c gi&#7843;i quy&#7871;t',
	                items:[{xtype: 'textfield',name:"txtChuVuCBTD2",fieldLabel: 'Ch\u1ECDn h\u1ED3 s\u01A1 \u0111\u00E3 x\u1EED l\u00FD',anchor: '100%'
	                },chungCuMoiCombo,{
            			xtype:'htmleditor',id:'bio',fieldLabel:'Ghi ch\u00FA n\u1ED9i dung m\u1EDBi',height:200,anchor:'98%'
        				}]
                	}]
            },{            
	            //Tab thong tin uy quyen 	
                title:'Th&#244;ng tin &#7911;y quy&#7873;n',layout:'form',defaults: {width: 230},defaultType: 'textfield',
                items: []
            },{            	
            	//Tab noi dung don
                title:'N&#7897;i dung &#273;&#417;n',layout:'form',defaults: {width: 230},defaultType: 'textfield',
                items: []
            }]
        },
        buttons: [{text: 'Ghi'},
        		{text: 'Tho\u00E1t'}
        	]});
</script>