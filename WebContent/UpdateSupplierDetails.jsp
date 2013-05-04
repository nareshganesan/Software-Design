<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,org.designpatterns.DataObjects.*,java.io.*"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Electronic Market</title>
</head>
<body>

Update Your Details here 
<% Supplier supplier = (Supplier) session.getAttribute("supplier"); 
System.out.println("supplier details :" + supplier.getSupplierLastName());
%> 
<form name="Register" action="RequestManager" method="post">
	<TABLE align="center"  WIDTH="60%">
                <tr width="100%">
                    <td >First Name :</td>
					<td> <input type="text" id="supplierfirstname" name="supplierfirstname" value="<%= supplier.getSupplierFirstName()  %>" /> </td>
				</tr>
				 <tr width="100%">
                    <td >Last Name :</td>
					<td> <input type="text" id="supplierlastname" name="supplierlastname" value="<%=supplier.getSupplierLastName() %>" /> </td>
				</tr>
				<tr>
					<td >Email :</td>
					<td> <input type="text" id="supplieremail" name="supplieremail" value="<%=supplier.getSupplierEmail() %>" /> </td>
				</tr>
				<tr>
					<td >Address :</td>
					<td> <input type="text" id="streetaddress" name="streetaddress" value="<%=supplier.getStreetAddress() %>" /> </td>
				</tr>
				<tr>
					<td >City :</td>
					<td> <input type="text" id="city" name="city" value="<%=supplier.getCity() %>" /> </td>
				</tr>
				<tr>
					<td >State :</td>
					<td> <input type="text" id="state" name="state" value="<%=supplier.getState() %>" /> </td>
				</tr>
				<tr>
					<td >Zipcode :</td>
					<td> <input type="text" id="zipcode" name="zipcode" value="<%=supplier.getZIPcode() %>" /> </td>
				</tr>
				<tr>
					<td >Zipcode :</td>
					<td> <input type="text" id="phone" name="phone" value="<%=supplier.getPhone() %>" /> </td>
				</tr>
				<tr>
					<td >Zipcode :</td>
					<td> <input type="text" id="mobile" name="mobile" value="<%=supplier.getMobile() %>" /> </td>
				</tr>
				<tr> 
					<td> <input type="submit" id="updatesupplierdetails" name="updatesupplierdetails" value="Update Details"/> </td>
					<td> <input type="reset" name="reset" value="Clear"/> <input type="hidden" name="service" value="Inbound"/>
					 <input type="hidden" name="feature" value="updatedetails"/></td>
				</tr>
				
	</TABLE>
			
</form>

</body>
</html>