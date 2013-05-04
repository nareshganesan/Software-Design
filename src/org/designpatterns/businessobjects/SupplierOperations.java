package org.designpatterns.businessobjects;

import java.util.ArrayList;
import java.util.Hashtable;

import org.designpatterns.DataAccessObjects.CustomerDAO;
import org.designpatterns.DataAccessObjects.DAOFactory;
import org.designpatterns.DataAccessObjects.MySQLSupplierDAO;
import org.designpatterns.DataAccessObjects.SupplierDAO;


public class SupplierOperations implements BusinessObjects {

	String ResponsePage;
	Hashtable ResponseData = new Hashtable();

	@Override
	public Hashtable apply(Hashtable requestdata) {
		// TODO Auto-generated method stub
		String operation = (String) requestdata.get("operation");
		if (operation.equalsIgnoreCase("showdetails")
				|| operation == "showdetails") {
			ResponseData = showdetails(requestdata);
		}
		if (operation.equalsIgnoreCase("updatedetails")
				|| operation == "updatedetails") {
			ResponseData = updatedetails(requestdata);
		}
		if (operation.equalsIgnoreCase("showproductdetails")
				|| operation == "showproductdetails") {
			ResponseData = showproductdetails(requestdata);
		}
		if (operation.equalsIgnoreCase("updateproductdetails")
				|| operation == "updateproductdetails") {
			ResponseData = updateproductdetails(requestdata);
		}
		if(operation.equalsIgnoreCase("showAddProduct") || operation ==
				  "showAddProduct") { ResponseData = showAddProduct(requestdata); }
		
		/* if(operation.equalsIgnoreCase("addnewproduct") || operation ==
		 * "addnewproduct") { ResponseData = addnewproduct(requestdata); }
		 * if(operation.equalsIgnoreCase("viewsales") || operation ==
		 * "viewsales") { ResponseData = viewsales(requestdata); }
		 */
		return ResponseData;
	}

	public Hashtable showdetails(Hashtable RequestData) {

	
		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		SupplierDAO MySQLSupplierDAO = MySQLFactory.getSupplierDAO();
		ResponseData = MySQLSupplierDAO.viewSupplierDetails(RequestData);

		ResponsePage = "UpdateSupplierDetails.jsp";

		ResponseData.put("supplier", "");
		ResponseData.put("ResponsePage", ResponsePage);

		return ResponseData;
	}

	public Hashtable updatedetails(Hashtable RequestData) {

		

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		SupplierDAO MySQLSupplierDAO = MySQLFactory.getSupplierDAO();
		boolean updateevent = false;

		updateevent = MySQLSupplierDAO.updateSupplier(RequestData);
		ResponsePage = "WelcomeUser.jsp";
		if (updateevent == true) {
			ResponseData.put("updateevent", "success");
			ResponsePage = "WelcomeUser.jsp";
		} else {
			ResponseData.put("updateevent", "failure");
			ResponsePage = "ErrorPage.jsp";
		}

		ResponseData.put("ResponsePage", ResponsePage);

		return ResponseData;
	}
	
	public Hashtable showproductdetails(Hashtable RequestData) {

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		SupplierDAO MySQLSupplierDAO = MySQLFactory.getSupplierDAO();

		ResponseData = MySQLSupplierDAO.findSupplierProducts(RequestData);
		
		ResponsePage = "UpdateProductDetail.jsp";
		

		ResponseData.put("products", "");
		ResponseData.put("ResponsePage", ResponsePage);

		return ResponseData;
	}

	
	
	public Hashtable updateproductdetails (Hashtable RequestData) {
	   
		   boolean updationresult = false;
		   
		   DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		   SupplierDAO MySQLSupplierDAO = MySQLFactory.getSupplierDAO();
		   
		   updationresult = MySQLSupplierDAO.updateSupplierProducts(RequestData);
		   
		   if (updationresult) {
				ResponsePage = "WelcomeUser.jsp";
			} else {
				ResponsePage = "ErrorPage.jsp";
			}
			ResponseData.put("ResponsePage", ResponsePage);
	   
	   return ResponseData; 
	  }
	   
	public Hashtable showAddProduct(Hashtable RequestData){

			DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
			SupplierDAO MySQLSupplierDAO = MySQLFactory.getSupplierDAO();
			boolean updatestatus = false;
			updatestatus = MySQLSupplierDAO.insertSupplierProduct(RequestData);
			if (updatestatus) {
				ResponsePage = "Home.jsp";
			} else {
				ResponsePage = "ErrorPage.jsp";
			}

			ResponseData.put("ResponsePage", ResponsePage);

			return ResponseData;
	  }
	   
	 

}
