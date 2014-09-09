<%@ include file="/top.jsp" %>
<%@ page pageEncoding="UTF-8"%>
<h3 class="Header">DANH SÁCH DANH MỤC</h3>
<html:form action="/ktnb_dm.do?method=show" >
<input type="hidden"  name="ma" id="ma" />
 <div style="width: 400px;">
	<table cellpadding="0" cellspacing="0" class="display" id="hs_table" width="50%">
		<thead>
			<tr class="TdHeaderList" align="center">
				<th width="5%">STT</th>
				<th width="10%">Mã</th>
				<th width="85%">Tên</th>
			</tr>	
		</thead>
		<tbody>
			<tr>
				<td colspan="3" class="dataTables_empty">Đang lấy dữ liệu....</td>
			</tr>
		</tbody>							
	</table>
	</div>	
	<table width="100%">
		<tr>    
		    <td align="right">
		      <input type="button" style="width: 60" class="button" value='Đóng' name="B3" onclick="window.close();">
		    </td>
		</tr>
	</table>
</html:form>
<script type="text/javascript" charset="utf-8"> 
var oTable;
$(function(){	
	$('#ma').val('');	
	$("#hs_table tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	    var iPos=oTable.fnGetPosition(event.target.parentNode);
		var aData=oTable.fnGetData(iPos);
	 	$('#ma').val(aData[1]+','+aData[2]);
	 	selectDatas();
	});		
    var url='ktnb_dm.do?method=search';
   	oTable=$("#hs_table").dataTable({ "sDom":'T<"clear">lfrtip',"sScrollY": "200px","bSort": false,"bFilter":false, "bProcessing": true,"bServerSide": true, "sAjaxSource":url, "oLanguage":language,"sPaginationType": "full_numbers" }).fnSetFilteringDelay(2000);	   	   	
});
function selectDatas(){
	opener.setDatas($('#ma').val());
	window.close();
}

</script>
</body>
</html>


