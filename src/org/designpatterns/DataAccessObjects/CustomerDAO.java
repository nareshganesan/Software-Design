
package org.designpatterns.DataAccessObjects;

import java.util.ArrayList;
import java.util.Hashtable;


public interface CustomerDAO {
	  
	  public Hashtable orderProducts(Hashtable RequestData);
	  public boolean findCustomer(Hashtable RequestData);
	  public boolean insertCustomer(Hashtable RequestData);
	  public Hashtable searchProducts(Hashtable RequestData);
	  public Hashtable updateCustDetails(Hashtable RequestData);
	  public Hashtable viewCustDetails (Hashtable RequestData);
	  public Hashtable addProductstoCart(Hashtable RequestData);
	 
	  
	}