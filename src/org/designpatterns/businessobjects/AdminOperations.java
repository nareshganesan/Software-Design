package org.designpatterns.businessobjects;

import java.util.Hashtable;

import org.designpatterns.DataAccessObjects.AdministratorDAO;
import org.designpatterns.DataAccessObjects.DAOFactory;
import org.designpatterns.DataAccessObjects.SupplierDAO;

public class AdminOperations implements BusinessObjects {

	String ResponsePage;
	Hashtable ResponseData = new Hashtable();
	@Override
	public Hashtable apply(Hashtable requestdata) {
		// TODO Auto-generated method stub
		String operation = (String) requestdata.get("operation");
		if (operation.equalsIgnoreCase("showdetails")
				|| operation == "showdetails") {
			System.out.println("Admin Operations : before showdetails");
			ResponseData = showdetails(requestdata);
			System.out.println("Admin Operations : after showdetails");
		}
		if (operation.equalsIgnoreCase("updatedetails")
				|| operation == "updatedetails") {
			System.out.println("Admin Operations : before updatedetails");
			ResponseData = updatedetails(requestdata);
			System.out.println("Admin Operations : after showdetails");
		}
		
		return ResponseData;
	}
	
	
	public Hashtable updatedetails(Hashtable RequestData) {

		
		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		AdministratorDAO MyAdminDAO = MySQLFactory.getAdministratorDAO();
		boolean updatestatus = false;
		updatestatus = MyAdminDAO.updateAdministrator(RequestData);

		ResponsePage = "UpdateAdmin.jsp";

		ResponseData.put("supplier", "");
		ResponseData.put("ResponsePage", ResponsePage);

		return ResponseData;
	}

	public Hashtable showdetails(Hashtable RequestData) {

		

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		AdministratorDAO MyAdminDAO = MySQLFactory.getAdministratorDAO();
		boolean updatestatus = false;
		ResponseData = MyAdminDAO.viewAdminDetails(RequestData);

		ResponsePage = "ViewAdmin.jsp";

		ResponseData.put("supplier", "");
		ResponseData.put("ResponsePage", ResponsePage);

		return ResponseData;
	}
	

}
