<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Administrator</title>



<script type="text/javascript" src="css/jquery-1.4.2.js"></script>
<script type="text/javascript">
	function lookup(inputString) {
		if (inputString.length == 0) {
			$('#suggestions').hide();
		} else {
			$
					.post(
							"RequestManager?service=Asynchronous&module=Outbound&feature=searchproducts",
							{
								queryString : "" + inputString + ""
							}, function(data) {
								if (data.length > 0) {
									$('#suggestions').show();
									$('#autoSuggestionsList').html(data);
								}
							});
		}
	}
	function fill(thisValue) {
		$('#inputString').val(thisValue);
		setTimeout("$('#suggestions').hide();", 200);
	}
</script>
<style type="text/css">
body {
	font-family: Helvetica;
	font-size: 13px;
	color: #000;
}

h3 {
	margin: 0px;
	padding: 0px;
}

.suggestionsBox {
	position: relative;
	left: 260px;
	margin: 0px 0px 0px 0px;
	width: 200px;
	background-color: #7845DD;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	border: 2px solid #000;
	color: #fff;
}

.suggestionList {
	margin: 0px;
	padding: 0px;
}

.suggestionList li {
	margin: 0px 0px 3px 0px;
	padding: 3px;
	cursor: pointer;
}

.suggestionList li:hover {
	background-color: #DD45CD;
}
</style>

<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>

</head>
<body onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">
	<% 
		/* ############### Java Code ################ */
		//String User = (String) session.getAttribute("username");
		/* ########################################## */
		if (!(null == session.getAttribute("username"))) {
	%>
	Welcome
	<%=session.getAttribute("username").toString()%>
	<a href="RequestManager?service=displayLogout&session=notrequired">Logout</a>
    <% if("supplier" == session.getAttribute("usertype") || session.getAttribute("usertype").toString().equalsIgnoreCase("supplier")){ 
    if(session.getAttribute("updateevent") == "success"){
    
    %>
    <div> Supplier Details Updated </div>
    
    <%} %>
    
	<form method="post" action="RequestManager">
	<div> Supplier :</div>
		<div>
			Search Products : <input type="text" value="" id="inputString"
				onkeyup="lookup(this.value);" onblur="fill();" name="inputString" />
			    <input type="hidden" name="service" value="Inbound" /> 
				<input type="hidden" name="session" value="required" /> 
				<input type="hidden" name="feature" value="searchproducts" /> 
			    <input type="submit" id="search" name="search" /> 
		</div>
		
		<div class="suggestionsBox" id="suggestions" style="display: none;">
			<div class="suggestionList" id="autoSuggestionsList"></div>
		</div>

	</form>
	
  <div> <a href="RequestManager?service=Inbound&featurename=Supplier&operation=showdetails&session=required">Update Details</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
       <a href="RequestManager?service=Inbound&featurename=Supplier&operation=showproductdetails&session=required">Update Product Details</a>
       <a href="RequestManager?service=Inbound&featurename=Supplier&operation=showAddProduct&session=required">Add New Product</a>
  
  </div>

	<%
		}else if("customer" == session.getAttribute("usertype") || session.getAttribute("usertype").toString().equalsIgnoreCase("customer")){
		%>
		<form method="post" action="RequestManager">
	<div> Customer :</div>
		<div>
			Search Products : <input type="text" value="" id="inputString"
				onkeyup="lookup(this.value);" onblur="fill();" name="inputString" />
			    <input type="hidden" name="service" value="Inbound" /> 
				<input type="hidden" name="session" value="required" /> 
				<input type="hidden" name="feature" value="searchproducts" /> 
			    <input type="submit" id="search" name="search" /> 
		</div>
		
		<div class="suggestionsBox" id="suggestions" style="display: none;">
			<div class="suggestionList" id="autoSuggestionsList"></div>
		</div>

	</form>
		
		<%
		}else if("administrator" == session.getAttribute("usertype") || session.getAttribute("usertype").toString().equalsIgnoreCase("administrator")){
		%>
		<form method="post" action="RequestManager">
	<div> Administrator :</div>
		<div>
			Search Products : <input type="text" value="" id="inputString"
				onkeyup="lookup(this.value);" onblur="fill();" name="inputString" />
			    <input type="hidden" name="service" value="Inbound" /> 
				<input type="hidden" name="session" value="required" /> 
				<input type="hidden" name="feature" value="searchproducts" /> 
			    <input type="submit" id="search" name="search" /> 
		</div>
		
		<div class="suggestionsBox" id="suggestions" style="display: none;">
			<div class="suggestionList" id="autoSuggestionsList"></div>
		</div>

	</form>
		
		<%}}else {
		
	%>
	<jsp:forward page="/Home.jsp" />
	<%
		}
		
	%>

</body>
</html>