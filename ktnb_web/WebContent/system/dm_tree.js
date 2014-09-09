<script>
var treeComboStore=new Ext.data.JsonStore({
    url:'jsonstore.do'
	,autoDestroy:true
	,root:'data'
	,baseParams:{method:'treeComboStore'}
	,idProperty:'id'
	,fields: ['id','name']
});

var treeCombo={
   xtype: 'combo'
   ,id:'treeCombo'
   ,width:250
   ,fieldLabel:'Danh m\u1EE5c'
   ,store: treeComboStore
   ,displayField: 'name'
   ,valueField: 'id'
   ,editable:false
   ,triggerAction: 'all'
   ,selectOnFocus: true
   ,forceSelection: true
   ,listeners: {
      'select': function(cmb,rec,idx) {
         parentId=this.getValue();//this.getRawValue()
         root=new Ext.tree.AsyncTreeNode({id:parentId,loader:treeLoader});
         tree.setRootNode(root);
      }
   }
};
var treeLoader=new Ext.tree.TreeLoader({url:'jsonstore.do',baseParams:{method:'treeDm',check:'0'}});
var root=new Ext.tree.AsyncTreeNode();
var tree=new Ext.tree.TreePanel({
    	id: 'tree'
    	,renderTo:contentPanel
    	,tbar:new Ext.Toolbar({
    	items:
    	[
    	treeCombo
    	,' 	T\u00ECm ki\u1EBFm:', 
	    	{
	         xtype:'trigger'
	        ,triggerClass:'x-form-clear-trigger'
	        ,onTriggerClick:function() {
				if (!Ext.isEmpty(this.getValue()))
				{
	            	this.setValue('');
                	root.cascade(function(n){n.ui.show();});
                }
	        }
	        ,id:'filter'
	        ,enableKeyEvents:true
	        ,listeners:{
	            keyup:{buffer:300,fn:function(field, e) {
	                if(Ext.EventObject.ESC == e.getKey()) {
	                    field.onTriggerClick();
	                }
	                else 
	                {
	                    root.expand(true);
	                    var val=this.getRawValue();
	                    var re=new RegExp('.*' + val + '.*', 'i');
	                    root.cascade(function(n)
	                    {
	      					if (re.test(n.text)) 
	      					{
	        					n.ui.show();
	        					n.bubble(function(){this.ui.show();});
					        } 
					        else n.ui.hide();  
	    				});
	                }
	            }}
	        }
	    	}]
    	}) 
    	,split: true
    	,autoScroll: true
    	,containerScroll: true
    	,rootVisible:false
    	//,enableDD: true,singleExpand:true,loader:treeLoader
    	,useArrows:true
        ,border: false
        ,root:root
        ,listeners:{click: function(n){
            sbar.setStatus({
            text:n.id
            ,clear: {
	   	     wait:5000,
        	 anim: false,
	         useDefaults: false
    		}
            });
         }
        }
        /*,tools:
        [{id:'minimize',scope: this,handler: function(event, toolEl, panel){root.collapse(true);}}
		 ,{id:'maximize',scope: this,handler: function(event, toolEl, panel){root.expand(true);}}
		]*/
});
function addNode(node)
{
	Ext.Ajax.request({
	   url:'ajax.do'
      ,params:{method:'insdm',id:node.id,name:'New Node'}
      ,success: function(result,request){
		json=Ext.util.JSON.decode(result.responseText);
	    if (json.success) node.appendChild(new Ext.tree.TreeNode({id:json.msg,text:'New Node',leaf: true}));
	    else              showErr(json.msg,null);    
	  }
   });
};

var onAddChild=function(){
 var node=tree.getSelectionModel().getSelectedNode();
 addNode(node);
};

var onAddNode=function(){
 var node=tree.getSelectionModel().getSelectedNode().parentNode;
 addNode(node);	
};

var contextMenu=new Ext.menu.Menu({
   items: [
      {text:'Th\u00EAm DM con',handler:onAddChild}
     ,{text:'Th\u00EAm danh m\u1EE5c',handler:onAddNode}
   ]
});

function onCtxMenu(node){
   node.select();
   contextMenu.show(node.ui.getAnchor());
};
tree.on('contextmenu',onCtxMenu);

/*tree.on('beforemovenode',function(tree,node,oldParent,newParent,index) 
{
   Ext.Ajax.request({
      url:'ajax.do'
      ,params:{method:'movedm',id:node.id,newparentid:newParent.id
      }
   });
});*/


var treeEditor=new Ext.tree.TreeEditor(tree,{allowBlank:false},{ignoreNoChange:true,maxWidth:400,editDelay:200});
treeEditor.on('beforecomplete',function(node,newValue,originalValue) 
{
   Ext.Ajax.request({
   	  url:'ajax.do'	
	  ,params:{method:'upddm',id:node.editNode.id,name:newValue}
	  ,success: function(result,request){
		 	json=Ext.util.JSON.decode(result.responseText);
	        if (!json.success) showErr(json.msg,null); 
	 }
	});
});
</script>