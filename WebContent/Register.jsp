<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Register Any Type of User Here

<form name="Register" action="RequestManager" method="post">
	<TABLE  WIDTH="100%">
	 <tr><td> Customers</td> <td> </td></tr>
	 <tr width="100%">
                    <td >User id :</td>
					<td> <input type="text" id="cust_id" name="cust_id"/> </td>
				</tr>
                <tr width="100%">
               
                    <td >Username :</td>
					<td> <input type="text" id="username" name="username"/> </td>
				</tr>
				 <tr width="100%">
                    <td >Credit Card No :</td>
					<td> <input type="text" id="cust_credit_number" name="cust_credit_number"/> </td>
				</tr>
				<tr>
					<td >Shipping Address :</td>
					<td> <input type="text" id="cust_shipping_address" name="cust_shipping_address"/> </td>
				</tr>
				<tr>
					<td >Billing Address :</td>
					<td> <input type="text" id="cust_billing_address" name="cust_billing_address"/> </td>
				</tr>
				<tr>
					<td >Password :</td>
					<td> <input type="password" id="cust_password" name="cust_password"/> </td>
				</tr>
				
				<tr> <td>Supplier Register Here :</td><td> </td> </tr>
				 <tr width="100%">
                    <td >User id :</td>
					<td> <input type="text" id="supp_id" name="supp_id"/> </td>
				</tr>
				<tr>
					<td >User name :</td>
					<td> <input type="text" id="supp_name" name="supp_name"/> </td>
				</tr>
				<tr>
					<td >Account No :</td>
					<td> <input type="text" id="supp_account_number" name="supp_account_number"/> </td>
				</tr>
				<tr>
					<td >Address :</td>
					<td> <input type="text" id="supp_address" name="supp_address"/> </td>
				</tr>
				<tr>
					<td >Password :</td>
					<td> <input type="password" id="supp_password" name="supp_password"/> </td>
				</tr>
				<tr> <td> Administrators Register Here </td> <td> </td> </tr>
				<tr>
					<td >User name :</td>
					<td> <input type="text" id="admin_name" name="admin_name"/> </td>
				</tr>
				<tr>
					<td >Password :</td>
					<td> <input type="password" id="admin_password" name="admin_password"/> </td>
				</tr>
				<tr> 
					<td>Usertype :</td>
					<td> <input type="radio"  name="module" value="supplier"> Supplier </input> </td>
					<td> <input type="radio"  name="module" value="customer"> Customer </input> </td>
					<td> <input type="radio"  name="module" value="administrator"> Administrator </input> </td>
				</tr>
				<tr> 
					<td> <input type="submit" id="registersubmit" name="registerSubmit" value="Register"/> </td>
					<td> <input type="reset" name="reset" value="Clear"/> <input type="hidden" name="service" value="Authentication"/>
					 <input type="hidden" name="feature" value="Authenticate"/>
					 <input type="hidden" name="operation" value="Register"/></td>
				</tr>
				
	</TABLE>
			
</form>
</body>
</html>