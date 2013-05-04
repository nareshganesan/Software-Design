package org.designpatterns.DataAccessObjects;

import java.util.Collection;
import java.util.Hashtable;

import javax.sql.RowSet;





public interface AdministratorDAO {
	 public boolean insertAdministrator(Hashtable RequestData);
	  public boolean deleteAdministrator();
	  public boolean findAdmin(Hashtable RequestData);
	  public boolean updateAdministrator(Hashtable RequestData);
	  public Hashtable viewAdminDetails(Hashtable RequestData);
	 

}
