<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.*,org.designpatterns.DataObjects.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>

<script type="text/javascript"> 

function showproductdetails(product) 
{
	var tablevisibility = document.getElementById("productdetails");
	var tableheadervisibility = document.getElementById("productheader");
	var tablerowclass = document.getElementsByClassName("productedit")
	var tablerowvisibility = document.getElementById(product);
	
	if(!(product == "")){
		tablevisibility.style.display="block";
		tableheadervisibility.style.display="block";
		tablerowvisibility.style.display = "block";
	}
	else
		{
			tablevisibility.style.display="none";
			tableheadervisibility.style.display="none";
			tablerowvisibility.style.display="none";
		}
	
	
	
	
}

</script>
</head>
<body>

 <% 
    	    ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
    	    Product product = new Product();
    	    String productname = new String();%>
    	    
    	     <select name="productlist" id="productlist" onchange="showproductdetails(this.value)">
    	
    	<option value="" > Select a Product </option> 
    	<% 
		    for(int i = 0; i < products.size(); i++)
		    {
		    	//product = products.get(i);
		    	productname = ((Product)products.get(i)).getProductname(); 
    		%>
    		
		<option value="<%=productname%>" > <%= productname%> </option> 
		 
		
		<%  } %>
		</select>
    
    <form name="UpdateProductDetails" action="RequestManager" method="post">
    
   
	 <!-- style="display:none" -->
    
    <table id="productdetails" style="display:none" align="center" width="80%">
    <tr id="productheader" > <td width="15%"> Product Name</td> <td width="7.5%"> Product Price</td> <td width="25%">Brief Desc</td>  <td width="30%"> Description</td> <td width="15%"> Imagename </td> <td width="7.5%">Quantity</td></tr> 
    <% 
		    for(int j =0; j < products.size(); j++){
		    	product = products.get(j);
		    	String productid = Integer.toString(product.getProductid()) ;
		    	String productidindex = "product"+j+ "id";
		    	productname = product.getProductname();
		    	String nameid = "product"+j+ "name";
		    	String productprice = product.getProductprice();
		    	String priceid = "product"+j+ "price";
		    	String briefdisc = product.getBriefdisc();
		    	String briefdiscid = "product"+j+ "briefdisc";
		    	String description = product.getDescription();
		    	String descriptionid = "product"+j+ "description";
		    	String imagename = product.getImagename();
		    	String imagenameid = "product"+j+ "imagename";
		    	String quantity = product.getQuantity();
		    	String quantityid = "product"+j+ "quantity";
		    	product = new Product();
		    	
     %>
     <!-- style="display:none" -->
<tr id="<%=productname %>" style="display:none" class="productedit"> 
	   <td> <input type="text" id="<%= nameid %>"  name="<%= nameid %>" value="<%=productname %>" /> </td> 
       <td> <input type="text" id="<%= priceid %>" name="<%= priceid %>" value="<%=productprice %>" /> </td> 
       <td> <input type="text" id="<%= briefdiscid %>"  name="<%= briefdiscid %>" value="<%=briefdisc %>" />  </td> 
       <td> <input type="text" id="<%= descriptionid %>" name="<%= descriptionid %>" value=" <%=description %>" /> </td> 
       <td> <input type="text" id="<%= imagenameid %>" name="<%= imagenameid %>" value=" <%=imagename %> " /> </td> 
       <td> <input type="text" id="<%= quantityid %>" name="<%= quantityid %>" value=" <%=quantity %> " /> </td> </tr>
	   <td><input type="hidden" id="<%= productidindex %>" name="<%= productidindex %>" value=" <%=productid %> " /></td>
		
<%    }%>
</table>

 <input type="hidden" name="service" value="Inbound" /> 
				<input type="hidden" name="session" value="required" /> 
				<input type="hidden" name="feature" value="updateproductdetails" /> 
			    <input type="submit" id="UpdateProduct" name="UpdateProduct" /> 
</form>
 <div> <a href="RequestManager?service=displayWelcomeUser&feature=showdetails&session=required">Home</a> </div>


</body>
</html>