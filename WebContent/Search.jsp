<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,org.designpatterns.DataObjects.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body>
<%String service = (String) session.getAttribute("service"); %>
<%if(service.equals("Inbound") || service == "Inbound"){ 
    ArrayList<Customer> customers = (ArrayList<Customer>) session.getAttribute("searchcontent");
    Customer customer = new Customer();%>
    <table><tr> <td> First Name</td> <td> Last Name</td> <td> Email</td></tr> 
    <% 
    for(int i =0; i < customers.size(); i ++){
    	customer = customers.get(i);
    	String customerfname = customer.getFirstname();
    	String customerlname = customer.getLastname();
    	String customeremail = customer.getEmail();
 
%><tr> <td> <%=customerfname %></td> <td> <%=customerlname %></td> <td> <%=customeremail %></td>

<%    }%>
</table>

<%}%>

</body>
</html>