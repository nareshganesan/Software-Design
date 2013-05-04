package org.designpatterns.DataAccessObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import javax.sql.RowSet;


public interface SupplierDAO {
	 public boolean insertSupplier(Hashtable RequestData);
	  public Hashtable viewSupplierDetails(Hashtable RequestData);
	  public boolean findSupplier(Hashtable RequestData);
	  public Hashtable findSupplierProducts(Hashtable RequestData);
	  public boolean updateSupplier(Hashtable RequestData);
	  public boolean updateSupplierProducts(Hashtable RequestData);
	  public boolean insertSupplierProduct(Hashtable RequestData);

}
