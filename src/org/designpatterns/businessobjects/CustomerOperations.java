package org.designpatterns.businessobjects;

import java.util.ArrayList;
import java.util.Hashtable;

import org.designpatterns.DataAccessObjects.CustomerDAO;
import org.designpatterns.DataAccessObjects.DAOFactory;


public class CustomerOperations implements BusinessObjects {

	
	String ResponsePage;
	Hashtable ResponseData = new Hashtable();

	@Override
	public Hashtable apply(Hashtable requestdata) {

		// TODO Auto-generated method stub

		String Operation = (String) requestdata.get("operation");
		if (Operation.equalsIgnoreCase("updatedetails")
				|| Operation == "updatedetails") {
			ResponseData = updatedetails(requestdata);
		}
		if (Operation.equalsIgnoreCase("searchproducts")
				|| Operation == "searchproducts") {
			ResponseData = searchproducts(requestdata);
		}
		if (Operation.equalsIgnoreCase("addproductstocart")
				|| Operation == "addproductstocart") {
			ResponseData = addproductstocart(requestdata);
		}
		if (Operation.equalsIgnoreCase("checkout")
				|| Operation == "checkout") {
			ResponseData = orderproducts(requestdata);
		}
		if (Operation.equalsIgnoreCase("viewdetails")
				|| Operation == "viewdetails") {
			ResponseData = viewdetails(requestdata);
		}
		
		return ResponseData;
	}

	public Hashtable searchproducts(Hashtable RequestData) {

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

			ResponseData = MySQLCustomerDAO.searchProducts(RequestData);

			ResponsePage = "Search.jsp";
			ResponseData.put("searchcontent", "");
			ResponseData.put("ResponsePage", ResponsePage);

		
		return ResponseData;
	}

	public Hashtable updatedetails(Hashtable RequestData) {

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

	
		ResponseData = MySQLCustomerDAO.updateCustDetails(RequestData);
		ResponsePage = "Search.jsp";
		ResponseData.put("searchcontent", "");
		ResponseData.put("ResponsePage", ResponsePage);

		
		return ResponseData;
	}

	public Hashtable addproductstocart(Hashtable RequestData) {

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

			ResponseData = MySQLCustomerDAO.addProductstoCart(RequestData);
			ResponsePage = "Search.jsp";
			ResponseData.put("searchcontent", "");
			ResponseData.put("ResponsePage", ResponsePage);

		
		return ResponseData;
	}

	public Hashtable orderproducts(Hashtable RequestData) {

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

			ResponseData = MySQLCustomerDAO.orderProducts(RequestData);
			ResponsePage = "Search.jsp";
			ResponseData.put("searchcontent", "");
			ResponseData.put("ResponsePage", ResponsePage);

		
		return ResponseData;
	}

	public Hashtable viewdetails(Hashtable RequestData) {

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

		
		ResponseData = MySQLCustomerDAO.viewCustDetails(RequestData);
			ResponsePage = "Search.jsp";
			ResponseData.put("searchcontent", "");
			ResponseData.put("ResponsePage", ResponsePage);

		
		return ResponseData;
	}

	

}
