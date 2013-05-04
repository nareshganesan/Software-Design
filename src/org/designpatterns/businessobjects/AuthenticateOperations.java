package org.designpatterns.businessobjects;

import java.util.Hashtable;

import org.designpatterns.DataAccessObjects.AdministratorDAO;
import org.designpatterns.DataAccessObjects.CustomerDAO;
import org.designpatterns.DataAccessObjects.DAOFactory;
import org.designpatterns.DataAccessObjects.SupplierDAO;



public class AuthenticateOperations implements BusinessObjects {

	public DAOFactory MySQLFactory;
	CustomerDAO MySQLCustomerDAO;
	SupplierDAO MySQLSupplierDAO;
	AdministratorDAO MySQLAdministratorDAO;
	public Hashtable ResponseData = new Hashtable();
	public String ResponsePage = null;
	
	
	@Override
	public Hashtable apply(Hashtable requestdata) {
		// TODO Auto-generated method stub
		
		String Operation = (String) requestdata.get("operation");
		
		if (Operation.equalsIgnoreCase("Authenticate")
				|| Operation == "Authenticate") {
			ResponseData = authenticateuser(requestdata);
		}
		
		if(Operation.equalsIgnoreCase("Register") || Operation == "Register") {
			ResponseData = registeruser(requestdata);
		}
		return ResponseData;
	}
	public Hashtable authenticateuser(Hashtable RequestData) {
			
			boolean UserPresence = false;
			String usertype = RequestData.get("module").toString();
			MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
			// Create a DAO
			if(RequestData.get("module") == "customer" || RequestData.get("module").toString().equalsIgnoreCase("customer")){
				
				MySQLCustomerDAO =  MySQLFactory.getCustomerDAO();
				UserPresence = MySQLCustomerDAO.findCustomer(RequestData);
				
				if(UserPresence == true )
				{
					ResponseData.put("updateevent", "success");
					//ResponseData.put("username", RequestData.get("username").toString());
					ResponseData.put("usertype", usertype);
					ResponsePage = "WelcomeUser.jsp";
				}
				else{
					ResponseData.put("updateevent", "failure");
					ResponsePage = "ErrorPage.jsp";
				}
				ResponseData.put("username", RequestData.get("username").toString());
				ResponseData.put("ResponsePage", ResponsePage);
			}
			if(RequestData.get("module") == "supplier" || RequestData.get("module").toString().equalsIgnoreCase("supplier")){
					
					MySQLSupplierDAO =  MySQLFactory.getSupplierDAO();
					UserPresence = MySQLSupplierDAO.findSupplier(RequestData);
					
					if(UserPresence == true )
					{
						ResponseData.put("updateevent", "success");
						ResponseData.put("usertype", usertype);
						ResponsePage = "WelcomeUser.jsp";
					}
					else{
						ResponseData.put("updateevent", "failure");
						ResponsePage = "ErrorPage.jsp";
					}
					ResponseData.put("username", RequestData.get("username").toString());
					ResponseData.put("ResponsePage", ResponsePage);
				
			}
			if(RequestData.get("module") == "administrator" || RequestData.get("module").toString().equalsIgnoreCase("administrator")){
				
				MySQLAdministratorDAO =  MySQLFactory.getAdministratorDAO();
					UserPresence = MySQLAdministratorDAO.findAdmin(RequestData);
					
					if(UserPresence == true )
					{
						ResponseData.put("updateevent", "success");
						ResponseData.put("usertype", usertype);
						ResponsePage = "WelcomeUser.jsp";
					}
					else{
						ResponseData.put("updateevent", "failure");
						ResponsePage = "ErrorPage.jsp";
					}
					ResponseData.put("username", RequestData.get("username").toString());
					ResponseData.put("ResponsePage", ResponsePage);
				
			}
			
			
			return ResponseData;
	}
	public Hashtable registeruser(Hashtable RequestData) {
			
			boolean UserPresence = false;
			String usertype = RequestData.get("module").toString();
			MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
			// Create a DAO
			if(RequestData.get("module") == "customer" || RequestData.get("module").toString().equalsIgnoreCase("customer"))
				{
					CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();
					UserPresence = MySQLCustomerDAO.insertCustomer(RequestData);
					if(UserPresence == true )
					{
						ResponseData.put("updateevent", "success");
						ResponseData.put("usertype", usertype);
						ResponsePage = "WelcomeUser.jsp";
					}
					else{
						ResponsePage = "ErrorPage.jsp";
						ResponseData.put("updateevent", "failure");
					}
					ResponseData.put("username", RequestData.get("username").toString());
					ResponseData.put("ResponsePage", ResponsePage);
				}
				if(RequestData.get("module") == "supplier" || RequestData.get("module").toString().equalsIgnoreCase("supplier"))
					{
						SupplierDAO MySQLSupplierDAO = MySQLFactory.getSupplierDAO();
				
						
						UserPresence = MySQLSupplierDAO.insertSupplier(RequestData);
						if(UserPresence == true )
						{
							ResponseData.put("updateevent", "success");
							ResponseData.put("usertype", usertype);
							ResponsePage = "WelcomeUser.jsp";
						}
						else{
							ResponsePage = "ErrorPage.jsp";
							ResponseData.put("updateevent", "failure");
						}
						ResponseData.put("username",  RequestData.get("username").toString());
						ResponseData.put("ResponsePage", ResponsePage);
					}
					if(RequestData.get("module") == "administrator" || RequestData.get("module").toString().equalsIgnoreCase("administrator"))
						{
							AdministratorDAO MySQLAdminDAO = MySQLFactory.getAdministratorDAO();
							UserPresence = MySQLAdminDAO.insertAdministrator(RequestData);
							if(UserPresence == true )
							{
								ResponseData.put("updateevent", "success");
								ResponseData.put("usertype", usertype);
								ResponsePage = "WelcomeUser.jsp";
							}
							else{
								ResponsePage = "ErrorPage.jsp";
								ResponseData.put("updateevent", "failure");
							}
							ResponseData.put("username", RequestData.get("username").toString());
							ResponseData.put("ResponsePage", ResponsePage);
						}
			return ResponseData;
		}

}
