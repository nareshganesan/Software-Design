package org.designpatterns.DataAccessObjects;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Properties;

import javax.sql.RowSet;


public class MySQLSupplierDAO implements SupplierDAO {
	
	private Properties properties;
	private Hashtable ResponseData = new Hashtable();

	public MySQLSupplierDAO()
	{
		properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("SQL.properties"));
		} catch (IOException e) {
		}
	}

	@Override
	public boolean insertSupplier(Hashtable RequestData){
		// TODO Auto-generated method stub
		
		boolean registrationdetails = false;
		System.out.println("User Email Provided : " + RequestData.get("username"));
		String customerInsert = properties.getProperty("InsertSupplier");
		PreparedStatement prepStmt;
		try {

			System.out.println( RequestData.get("supp_name").toString() +" "+(int) new Integer(RequestData.get("supp_id").toString()));
			System.out.println((int) new Integer(RequestData.get("supp_account_number").toString()) +" "+ RequestData.get("supp_password").toString());
			
			prepStmt = MySQLDAOFactory.createConnection().prepareStatement(
					customerInsert);
			// prepStmt.setString(1, customer.getFirstname());
			prepStmt.setInt(1, (int) new Integer(RequestData.get("supp_id").toString()));
			prepStmt.setString(2, RequestData.get("supp_name").toString());
			prepStmt.setInt(3, (int) new Integer(RequestData.get("supp_account_number").toString()));
			prepStmt.setString(4, RequestData.get("supp_address").toString());
			prepStmt.setString(5, RequestData.get("supp_password").toString());
			

			int rs1 = prepStmt.executeUpdate();
			if(rs1 == 1){
				registrationdetails = true;
			}
			System.out.println("value of rs1: " + rs1 +""+ registrationdetails);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Supplier not Inserted");
			return registrationdetails;
		}
		System.out.println("Supplier Inserted");
		//custid++;
		//registrationdetails = true;
		return registrationdetails;
		// Implement insert customer here.
		// Return newly created customer number
		// or a -1 on error
		
	}

	@Override
	 public Hashtable viewSupplierDetails(Hashtable RequestData){
		// TODO Auto-generated method stub
		
		String findsupplierproducts = properties.getProperty("viewsupplier");
		System.out.println(findsupplierproducts);
		System.out.println("User Email Provided : " + RequestData.get("username").toString());
		String email = "";
		Hashtable supplier = new Hashtable();
		PreparedStatement prepStmt;
		try {

			prepStmt = MySQLDAOFactory.createConnection().prepareStatement(
					findsupplierproducts);

			prepStmt.setString(1, RequestData.get("username").toString());
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				supplier.put("supp_name",  rs.getString("supp_name"));
				supplier.put("supp_address",  rs.getString("supp_address"));
				supplier.put("supp_account_number",  rs.getString("supp_account_number"));
				
				
				System.out.println("product name : "+rs.getString("productname"));
			} // end while
			if (!(email.equalsIgnoreCase(supplier.get("supp_name").toString()))) {
				supplier = null;
			}
			ResponseData.put("supplierdetails",supplier);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Product not Found for the Supplier");

		}
		
		
		return null;
	}

	@Override
	public boolean findSupplier(Hashtable RequestData) {
		// TODO Auto-generated method stub
		String findsupplier = properties.getProperty("findsupplier");
		System.out.println(findsupplier);
		System.out.println("User Email Provided : " + RequestData.get("username").toString());
		String user = "";
		String pwd = "";
		boolean supplierpresent = false;
		PreparedStatement prepStmt;
		try {

			prepStmt = MySQLDAOFactory.createConnection().prepareStatement(
					findsupplier);

			prepStmt.setString(1, RequestData.get("username").toString());
			System.out.println("User name: "+RequestData.get("username").toString());
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				user = rs.getString("supp_name");
				pwd = rs.getString("supp_password");
				System.out.println("dbusername: "+user);
			} // end while
			if (user.equalsIgnoreCase(RequestData.get("username").toString())) {
				supplierpresent = true;
			} else {
				supplierpresent = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Supplier not Found");

		}
		
		
		return supplierpresent;
	}

	@Override
	public boolean updateSupplier(Hashtable RequestData) {
		// TODO Auto-generated method stub
		
		return true;
		// Implement insert customer here.
		// Return newly created customer number
		// or a -1 on error
		
	}
	
	@Override
	public Hashtable findSupplierProducts(Hashtable RequestData) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	

	@Override
	public boolean updateSupplierProducts(Hashtable RequestData) {
		// TODO Auto-generated method stub
		
		
		String supplieremail = (String) RequestData.get("username");
		//int Productcount = findNoOfSupplierProducts(supplieremail);
		boolean updationresult = false;
		
		
		return updationresult;
	}

	public boolean insertSupplierProduct(Hashtable RequestData){
		// TODO Auto-generated method stub
		return true;
	}


	

}
