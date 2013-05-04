package org.designpatterns.DataAccessObjects;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Properties;

import javax.sql.RowSet;



public class MySQLAdministratorDAO implements AdministratorDAO {

	private Properties properties;
	public MySQLAdministratorDAO(){
		properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("SQL.properties"));
		} catch (IOException e) {
		}

	}
	
	@Override
	public boolean insertAdministrator(Hashtable RequestData){
		// TODO Auto-generated method stub
		boolean registrationdetails = false;
		System.out.println("User Email Provided : " + RequestData.get("username"));
		String customerInsert = properties.getProperty("InsertAdmin");
		PreparedStatement prepStmt;
		try {

			System.out.println( RequestData.get("admin_name").toString() );
			System.out.println((int) new Integer(RequestData.get("admin_password").toString()) );
			
			prepStmt = MySQLDAOFactory.createConnection().prepareStatement(
					customerInsert);
			// prepStmt.setString(1, customer.getFirstname());
			
			prepStmt.setString(1, RequestData.get("admin_name").toString());
			
			prepStmt.setString(2, RequestData.get("admin_password").toString());
			

			int rs1 = prepStmt.executeUpdate();
			if(rs1 == 1){
				registrationdetails = true;
			}
			System.out.println("value of rs1: " + rs1 +""+ registrationdetails);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Admin not Inserted");
			return registrationdetails;
		}
		System.out.println("Admin Inserted");
		//custid++;
		//registrationdetails = true;
		return registrationdetails;
		// Implement insert customer here.
		// Return newly created customer number
		// or a -1 on error
	}

	@Override
	public boolean deleteAdministrator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findAdmin(Hashtable RequestData) {
		// TODO Auto-generated method stub
		String findcustomer = properties.getProperty("AuthenticateAdmin"); // needs to be updated with proper query
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
				user = rs.getString("admin_name");
				pwd = rs.getString("admin_password");
				
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
			System.out.println("Admin not Found");

		}
		return customerPresent;
		
	}

	@Override
	public boolean updateAdministrator(Hashtable RequestData){
		// TODO Auto-generated method stub
		return false;
	}

	public Hashtable viewAdminDetails(Hashtable RequestData) {
		return null;
	}


}
