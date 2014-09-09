<%@ page pageEncoding="UTF-8"%>
<script language="Javascript">
$(function() 
{
  $(document).bind('keydown','esc',function(evt){onButton('exit');return false;});
  $(document).bind('keydown','home',function(evt){window.location='index.do';return false;});
  if($('#exit').length>0)
  {
   $('#exit').button({icons:{primary:'ui-icon-close'}}).click(function(){onButton('exit');return false;});
  }
  if($('#search').length>0)
  {
    $('#search').button({icons:{primary:'ui-icon-search'}}).click(function(){onButton('search');return false;});
    $(document).bind('keydown','Shift+s',function(evt){onButton('search');return false;});
  }
  if($('table.data_table').length>0)
  {
    $('table.data_table tbody tr').each(function(index) {$(this).addClass(arrClassName[index%3]);});
    $("table.data_table tbody").delegate("tr", "hover", function(){$(this).toggleClass("highlight");});
  }
  if($('#msgdiv').length>0)
  {
    <logic:present name="msg">
     $('#msgdiv').effect('pulsate',{times:3});
    </logic:present>
  } 
});
</script>
</div>
<div id="bottom">
<table width="100%" border="0" bordercolor="#AEC1F1">
	<tr>
		<td align="center" width="20%" style="color: blue; font-size: 8pt">KTNB Phiên bản <strong><%=ac.getVersionApp()%></strong> <br>
		<script language=JavaScript>
                                                dayname = new Array("Chủ nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bẩy");
                                                monthname = new Array("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
                                                now = new Date();
                                                daynum = now.getDay();
                                                day = dayname[daynum];
                                                date = now.getDate();
                                                monthnum = now.getMonth();
                                                month = monthname[monthnum];
                                                document.write(""+day+", Ngày "+date+"/"+month+"/"+now.getYear()+"");
          </script></td>
		<td align="center" width="70%"><font style="color: blue; font-size: 8pt"> <b>TỔNG CỤC THUẾ</b> <BR>
		<strong>Địa chỉ:</strong> Số 123 Lò Đúc, Hà Nội &nbsp; &nbsp;<strong>Điện thoại:</strong> (04) 9.724204 - 9.724209 <strong>Fax:</strong> (04) 9.712286 <br>
		<strong>Website:</strong> <a href="http://www.gdt.gov.vn" target="_blank">http://www.gdt.gov.vn</a> </font></td>
	</tr>
</table>
</div>
</body>
</html>
<script language="Javascript">
// style js ui
//$(function(){
//	$.each($('[type="button"]'),function(index,value){
//		$(value).button();
//		$(value).css("font-size","11");
//	})
//})
</script>