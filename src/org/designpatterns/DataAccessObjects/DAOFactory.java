package org.designpatterns.DataAccessObjects;



/**
 * @author naresh
 *
 */
public abstract class DAOFactory 
{
	
	
	  // List of DAO types supported by the factory
	  public static final int MySQL = 1;
	  public static final int ORACLE = 2;
	  public static final int SQLServer = 3;
	  

	  // There will be a method for each DAO that can be 
	  // created. The concrete factories will have to 
	  // implement these methods.
	  public abstract CustomerDAO getCustomerDAO();
	  public abstract SupplierDAO getSupplierDAO();
	  public abstract AdministratorDAO getAdministratorDAO();
	 
	  

	  public static DAOFactory getDAOFactory( int whichFactory) 
	  {
	  
	    switch (whichFactory) 
	    {
	      case MySQL: 
	          return new MySQLDAOFactory();
//	      case ORACLE    : 
//	          return new OracleDAOFactory();      
//	      case SQLServer    : 
//	          return new SQLServerDAOFactory();
	      default           : 
	          return null;
	    }
	  }
}
