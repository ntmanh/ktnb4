<input type="button" value='<bean:message  key="tim_kiem"/>' style="width: 80; margin: 0" class="button" onclick="search();" />
<script language="javascript">    
	$(function(){
    $('input').keydown(function(e){
        if (e.keyCode == 13) {
            search();
            return false;
        }
    });
});
 	function search(){
 		if(!validateForm()) 
 			return;
 		try{
 			selfSearch();
 		}catch(err){ 			
	 		document.forms[0].action = document.forms[0].action.split('?')[0];
	 		document.forms[0].submit();		
 		}
 		
 	}
</script>