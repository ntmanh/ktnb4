<%@ include file="/head.jsp"%> 
<script>	
Ext.onReady(function(){
var str='',parentId='14';
var root=new Ext.tree.AsyncTreeNode({id:parentId,loader:new Ext.tree.TreeLoader({url:'jsonstore.do',baseParams:{method:'treeDm',check:'1'}})});
var ok={
            text: 'Ok',
            handler: function(){
                str=''; 
                var selNodes=tree.getChecked();
                Ext.each(selNodes, function(node){
                    str+=node.id+',';
                });
                if (!Ext.isEmpty(str)) str=str.substring(0,str.length-1);
                Ext.Msg.show({
                    msg: str,
                    icon: Ext.Msg.INFO,
                    minWidth: 200,
                    buttons: Ext.Msg.OK
                });
            }
        };
var tree=new Ext.tree.TreePanel({
    title: 'abc'
    ,height:400
    ,width:900
    //,renderTo: document.body
    ,renderTo:'tree-div'
    ,useArrows:true
    ,autoScroll:true
    ,containerScroll: true
    ,animate:true
    ,root:root
    ,rootVisible: false
    ,border: false
    ,frame: true
	,listeners:{
     'checkchange': function(node, checked){
        if(checked) node.getUI().addClass('complete');
        else        node.getUI().removeClass('complete');
     }
    }
    ,buttons:[ok]
    });
});	
</script>
</head>  
<body>
<div id='tree-div'/>
</body>
</html> 