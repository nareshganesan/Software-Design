package org.designpatterns.DataAccessObjects;

import java.sql.*;

import org.designpatterns.constants.Constants;

import com.mysql.jdbc.Connection;

public class MySQLDAOFactory extends DAOFactory 
{
	 public static Connection MySQLConnection;
	
	  // method to create MySQL connections
	  public static Connection createConnection()  throws SQLException 
	  {
		  try {
			Class.forName(Constants.MySQLDRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnection = (Connection) DriverManager.getConnection (Constants.MySQLDBURL+Constants.DatabaseName, Constants.DBUserName, Constants.DBPassword);  
		return MySQLConnection;
	    // Use DRIVER and DBURL to create a connection
		// Recommend connection pool implementation/usage
	  }
	  public static void closeConnection() throws SQLException 
	  {
		  if(MySQLConnection != null)
		  {
			  MySQLConnection.close();
		  }
		
		
	    // Use DRIVER and DBURL to create a connection
		// Recommend connection pool implementation/usage
	  }
	  public CustomerDAO getCustomerDAO() {
	    // CloudscapeCustomerDAO implements CustomerDAO
	    return new MySQLCustomerDAO();
	  }
	  public SupplierDAO getSupplierDAO() {
	    // CloudscapeAccountDAO implements AccountDAO
	    return new MySQLSupplierDAO();
	  }
	  public AdministratorDAO getAdministratorDAO() {
	    // CloudscapeOrderDAO implements OrderDAO
	    return new MySQLAdministratorDAO();
	  }
	
}

