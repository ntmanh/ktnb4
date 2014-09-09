<%@ include file="/top.jsp"%>    
<%
	String error_message = (String)request.getSession().getAttribute("error_message");
	request.getSession().removeAttribute("error_message");
	
%>
<% if(error_message == null){%>
	<script>
		alert('B\u1EA1n kh\u00F4ng c\u00F3 quy\u1EC1n truy c\u1EADp ch\u1EE9c n\u0103ng n\u00E0y!'); 
		window.location = "ttkt_index.do"; 	
	</script>	
<%}else{%>
	
<script>
		alert('<%=error_message%>'); 
		try{
			history.back();
		}catch(err){
			window.close();
		}	 	
	</script>	
<%} %>
 


