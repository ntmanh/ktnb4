<script>
function ajax(vMethod)
{
	btn=Ext.getCmp(vMethod);
	btn.setDisabled(true);
	Ext.Ajax.request({     
      params:{method:vMethod,id:parentId}
	  ,url:'ajax.do',timeout:60000
	  ,success: function(result,request){
	  	btn.setDisabled(false);    	
		json=Ext.util.JSON.decode(result.responseText);
	    if (json.success) showMsg(json.msg,null);				                    
		else          	  showErr(json.msg,null); 
	  }
	});	
};

var store=new Ext.data.JsonStore({
    url:'jsonstore.do'
    ,autoDestroy:true
    ,root:'data'
    ,baseParams:{method:'dsdb'}
    ,idProperty:'id'
    ,fields: ['id','name']
});

var form=new Ext.FormPanel({
         bodyStyle:'padding:5px', labelWidth:70, renderTo:contentPanel,
         items:
         [
	         	{
		         	xtype:'fieldset',
		            title: '\u0110\u1ED3ng b\u1ED9 s\u1ED1 li\u1EC7u Cache',
		            collapsible:true,
	                //collapsed: true,
		            autoHeight:true,
		            items:
		            [
				       	{
				       	 xtype: 'button',id:'refreshCache',text:'\u0110\u1ED3ng b\u1ED9 s\u1ED1 li\u1EC7u Cache',icon:'image/database_refresh.png',
				 	     handler:function(){ajax('refreshCache');} 
			            }
		            ]
	             }
         ]
      });
</script>