<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function showData(value) {

		xmlHttp = GetXmlHttpObject();
		var url = "RequestManager";
		url = url
				+ "?service=Asynchronous&module=Inbound&feature=searchcustomers&search="
				+ value;
		xmlHttp.onreadystatechange = stateChanged;
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}
	function stateChanged() {
		if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
			var showdata = xmlHttp.responseText;
			document.getElementById("mydiv").innerHTML = showdata;
		}
	}
	function GetXmlHttpObject() {
		var xmlHttp = null;
		try {
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		return xmlHttp;
	}
</script>
</head>
<body>
	<%
		/* ############### Java Code ################ */
		//String User = (String) session.getAttribute("username");
		/* ########################################## */
		if (!(null == session.getAttribute("username"))) {
	%>
	Welcome
	<%=session.getAttribute("username").toString()%>
	<a href="RequestManager?service=displayLogout&session=notrequired">Logout</a>

	<form>
		<table>
			<tr>
				<td>Search Customers : <input type="text" id="searchcustomers"
					name="searchcustomers" onkeyup="showData(this.value);" /></td>
				<td><input type="submit" id="search" name="search" /></td>
			</tr>
			<tr>
				<td><div id="mydiv"></div></td><td></td>
			</tr>
			
				<input ype="hidden" name="service" value="Inbound" />
				<input type="hidden" name="session" value="required" />
				<input type="hidden" name="feature" value="searchcustomers" />
			



		</table>
	</form>


	<%
		} else {
	%>
	<jsp:forward page="/Home.jsp" />
	<%
		}
	%>

</body>
</html>