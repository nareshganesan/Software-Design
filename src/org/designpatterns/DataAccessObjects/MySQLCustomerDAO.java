package org.designpatterns.DataAccessObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Properties;

import javax.sql.RowSet;


import org.designpatterns.constants.Constants;


public class MySQLCustomerDAO implements CustomerDAO {

	private Properties properties;
	private static int custid = 3;
	private Hashtable ResponseData = new Hashtable();

	public MySQLCustomerDAO() {
		// initialization
		properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("SQL.properties"));
		} catch (IOException e) {
		}
	}

	@Override
	 public Hashtable orderProducts(Hashtable RequestData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findCustomer(java.util.Hashtable RequestData) {
		// TODO Auto-generated method stub
		String findcustomer = properties.getProperty("AuthenticateCustomer"); // needs to be updated with proper query
		System.out.println("query : "+findcustomer);
		System.out.println("User Email Provided : " + RequestData.get("username").toString());
		String user = null;
		String pwd = null;
		
		
		boolean customerPresent = false;
		PreparedStatement prepStmt;
		try {

			prepStmt = MySQLDAOFactory.createConnection().prepareStatement(
					findcustomer);

			prepStmt.setString(1, RequestData.get("username").toString()); // username
			 // password
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				user = rs.getString("username");
				pwd = rs.getString("cust_password");
				
				System.out.println(user);
			} // end while
			if (user.equalsIgnoreCase(RequestData.get("username").toString())) {
				customerPresent = true;
			} else {
				customerPresent = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Customer not Found");

		}
		return customerPresent;
		
		
	}

	@Override
	public boolean insertCustomer(java.util.Hashtable RequestData) {
		// TODO Auto-generated method stub
		
		boolean registrationdetails = false;
		System.out.println("User Email Provided : " + RequestData.get("username"));
		String customerInsert = properties.getProperty("InsertCustomer");
		PreparedStatement prepStmt;
		try {

			System.out.println(custid +" "+ RequestData.get("username").toString() +" "+(int) new Integer(RequestData.get("cust_credit_number").toString()));
			System.out.println(RequestData.get("cust_shipping_address").toString() +" "+ RequestData.get("cust_billing_address").toString());
			System.out.println(RequestData.get("cust_password").toString());
			prepStmt = MySQLDAOFactory.createConnection().prepareStatement(
					customerInsert);
			// prepStmt.setString(1, customer.getFirstname());
			prepStmt.setInt(1, (int) new Integer(RequestData.get("cust_id").toString()));
			prepStmt.setString(2, RequestData.get("username").toString());
			prepStmt.setInt(3, (int) new Integer(RequestData.get("cust_credit_number").toString()));
			prepStmt.setString(4, RequestData.get("cust_shipping_address").toString());
			prepStmt.setString(5, RequestData.get("cust_billing_address").toString());
			prepStmt.setString(6, RequestData.get("cust_password").toString());

			int rs1 = prepStmt.executeUpdate();
			if(rs1 == 1){
				registrationdetails = true;
			}
			System.out.println("value of rs1: " + rs1 +""+ registrationdetails);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Customer not Inserted");
			return registrationdetails;
		}
		System.out.println("Customer Inserted");
		custid++;
		//registrationdetails = true;
		return registrationdetails;
		// Implement insert customer here.
		// Return newly created customer number
		// or a -1 on error
	
	}

	@Override
	 public Hashtable searchProducts(Hashtable RequestData){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hashtable viewCustDetails (Hashtable RequestData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hashtable updateCustDetails(Hashtable RequestData) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	 public Hashtable addProductstoCart(Hashtable RequestData){
		// TODO Auto-generated method stub
		return null;
	}

	

	
}