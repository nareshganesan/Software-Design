<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Market Place for Electronic Products.</title>
</head>
<body>

<form name="Login" action="RequestManager" method="post">
	<TABLE  WIDTH="100%">
                <tr width="100%">
                    <td >Username :</td>
					<td> <input type="text" id="userName" name="username"/> </td>
				</tr>
				<tr>
					<td >Password :</td>
					<td> <input type="password" id="passWord" name="password"/> </td>
				</tr>
				<tr> 
					<td>Usertype :</td>
					<td> <input type="radio"  name="module" value="supplier"> Supplier </input> </td>
					<td> <input type="radio"  name="module" value="customer"> Customer </input> </td>
					<td> <input type="radio"  name="module" value="administrator"> Administrator </input> </td>
				</tr>
				<tr> 
					<td> <input type="submit" id="loginsubmit" name="loginSubmit" value="Login"/> </td>
					<td> <input type="reset" name="reset" value="Clear"/> <input type="hidden" name="service" value="Authentication"/>
					<input type="hidden" name="session" value="required"/>
					<input type="hidden" name="feature" value="Authenticate"/>
					<input type="hidden" name="operation" value="Authenticate"/></td>
				</tr>
				
	</TABLE>
			
</form>
</body>
</html>