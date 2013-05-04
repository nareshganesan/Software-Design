<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.*,org.designpatterns.DataObjects.*,java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

Register a New Product 

 <% String[] Categories = new String[100];
					Categories = (String[]) session.getAttribute("categories"); 
					String categoryname = new String(); %>
<form name="AddProduct" action="RequestManager" method="post">

  <div>Category : <select name="category" id="category" >
    	
    	<option value="" Selected> Select a Category </option> 
    	<% 
		    for(int i = 0; i < Categories.length; i++)
		    {
		    	
		    	categoryname = Categories[i]; 
    		%>
    		
		<option value="<%=Categories[i]%>" > <%= Categories[i]%> </option> 
		 
		
		<%  } %>
		</select></div>
	<TABLE  WIDTH="100%">
                <tr width="100%">
                    <td >Product Name :</td>
					<td> <input type="text" id="productname" name="productname"/> </td>
				</tr>
				 <tr width="100%">
                    <td >Product Price :</td>
					<td> <input type="text" id="productprice" name="productprice"/> </td>
				</tr>
				<tr>
					<td >List Price :</td>
					<td> <input type="text" id="listprice" name="listprice"/> </td>
				</tr>
				<tr>
					<td >Imagename :</td>
					<td> <input type="password" id="imagename" name="imagename"/> </td>
				</tr>
				<tr>
					<td >Quantity :</td>
					<td> <input type="text" id="quantity" name="quantity"/> </td>
				</tr>
				<tr>
					<td >Description :</td>
					<td> <input type="text" id="description" name="description"/> </td>
				</tr>
				<tr>
					<td >Brief Desc :</td>
					<td> <input type="text" id="briefdisc" name="briefdisc"/> </td>
				</tr>
				<tr>
					<td></td>
					<td>  
    	    
    	   </td>
					
				
				</tr>
				
				
				<tr> 
					<td> <input type="submit" id="addproductsubmit" name="addproductSubmit" value="Add"/> </td>
					<td> <input type="reset" name="reset" value="Clear"/> <input type="hidden" name="service" value="Inbound"/>
					 <input type="hidden" name="feature" value="addproduct"/></td>
				</tr>
				
	</TABLE>
			
</form>

</body>
</html>