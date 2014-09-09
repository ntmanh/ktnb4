<script>
var grid=new Ext.grid.GridPanel({
        title:'H\u1ED7 tr\u1EE3 tr\u1EF1c tuy\u1EBFn'
        ,store:new Ext.data.SimpleStore({fields:['ten','ym','tel']
        ,data:[
        ['Nguyen Binh Dai','isnotnull','0986301253']
 	   ,['Nguyen Thi Hong Linh','linhgdt','0982832804']
		]})
        ,frame: true
        ,autoHeight:true
        ,width:430
        ,columnLines:true
        ,renderTo: contentPanel
        ,sm:new Ext.grid.RowSelectionModel({singleSelect: true})
        ,columns: [
        new Ext.grid.RowNumberer(),
        	{
                header:'T\u00EAn',
                width:150,
                sortable :true, 
                dataIndex:'ten'
            },
            {
                header:'YM',
                width:150,
                dataIndex:'ym',
                renderer: function(v) {
             	  return  "<a href='ymsgr:sendIM?"+v+"'><img border='0' src='http://opi.yahoo.com/online?u="+v+"&m=g&t=5&l=us' alt='Click here to chat' /></a>&nbsp;&nbsp;<a href='ymsgr:sendIM?"+v+"'>"+v+"</a>";
                }
            },
            {
                header:'Mobile',
                width:120,
                sortable :true, 
                dataIndex:'tel'
            }
		]
});		
</script>