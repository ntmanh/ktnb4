<%@ include file="/top_bar.jsp"%>
<html:form action="xxx.do?method=exe">
	<html:hidden property="result" />
	<div id="tab_kntc" style="background-color: transparent">
	<ul>
		<li><a href="#tab_query" class="tabTitle">Querry</a></li>
		<li><a href="#tab_query_kntc" class="tabTitle">Querry Hay
		D&#249;ng KNTC</a></li>
		<li><a href="#tab_query_ttkt" class="tabTitle"> Querry Hay
		D&#249;ng TTKT </a></li>
	</ul>
	<div id="tab_query">
	<ul class="liMenu">
		<table style="margin-left: -15px; width: 700px;">
			<tr>
				<td><html:textarea property="querry" style="width: 650px;"
					rows="5"></html:textarea></td>
				<td><input type="button" class="button" value='Run' id="btnRun"
					onclick="run();" style="height: 60px;"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><b
					style="text-align: center;">K&#7871;t qu&#7843;</b>
				<div id="txtResult"
					style="width: 700px; height: 300px; overflow: scroll; border: 1px solid #CCC; text-align: left;"></div>
				</td>
			</tr>
		</table>
	</ul>
	</div>
	<div id="tab_query_kntc">
	<ul class="liMenu">
		<div style="margin-left: -15px; width: 720px; overflow: scroll;">
		<table border="1" style="overflow: scroll">
			<tr>
				<th style="width: 200px">M&#244; t&#7843;</th>
				<th>Querry</th>
			</tr>
			<tr>
				<td class="hideextra">Lay thong tin count ho so KNTC</td>
				<td class="hideextra">SELECT h.MA_CQT, h.TEN_CQT, COUNT (*),
				h.LOAI_KNTC FROM KTNB_OWNER.KNTC_HO_SO_HDR h WHERE h.MA_HS_CHA is
				null GROUP BY h.TEN_CQT, h.MA_CQT, h.LOAI_KNTC ORDER BY h.MA_CQT</td>
			</tr>
		</table>
		</div>
	</ul>
	</div>
	<div id="tab_query_ttkt">
	<ul class="liMenu">
		T&#7889;ng querry m&#7851;u v&#224;o &#273;&#226;y!
	</ul>
	</div>
	</div>
</html:form>
<script type="text/javascript" language="javascript">
    $(function()
    {
        var tab_select=jQuery.fn.readCookie("TABI");
        var tabOpts={selected:tab_select,select:function(event,tab){jQuery.fn.createCookie("TABI",tab.index);}}; 
        $("#tab_kntc").tabs(tabOpts);
        $("#tab_kntc").removeClass("ui-corner-all");
        $("#tab_kntc").children().removeClass("ui-corner-all");      
  
        if(isExist('txtResult'))
            document.getElementById('txtResult').innerHTML = document.forms[0].result.value;
    });

    function run(){
        document.forms[0].action="xxx.do?method=exe";
        document.forms[0].submit();
    }
</script>
<%@ include file="/bottom.jsp"%>
