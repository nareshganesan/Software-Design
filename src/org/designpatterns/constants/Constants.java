package org.designpatterns.constants;


public class Constants {
	
	/* Authentication or/and Registration Module Module
	 * Constants related to Authentication Module goes here.
	 * 
	 */
	public static final String AUTHENTICATIONMANAGER = "/AuthenticationManager";
	public static final String RESPONSEPAGE = "ResponsePage";
	
	public static final String SERVICE = "Service";
	public static final String SERVICEPACKAGE = "org.designpatterns.services.";
	
	public static final String FEATUREPACKAGE = "org.designpatterns.features.";
	public static final String FEATURE = "Feature";
	
	public static final String BUSINESSOBJECTPACKAGE = "org.designpatterns.businessobjects.";
	public static final String OPERATION = "Operations";
	
	
	
	/* Things to follow in a JSP
	 * 1. service parameter needs to either mention a Service Name or have a display tag in the service name
	 * if it requires only a JSP view page.
	 * 2. feature parameter needs to either mention a feature of the service and cannot be null.
	 * 3. session parameter has to be either required or notrequired. if any authentication needs to be done
	 * then session parameter needs to be required else not required.
	 * 
	 */
	
	
	/*
	 * Database Connectivity Parameters
	 * 
	 */
	public static final String MySQLDRIVER = "com.mysql.jdbc.Driver";
    public static final String MySQLDBURL = "jdbc:mysql://localhost/";
    public static final String DatabaseName = "ElectronicMarket";
    public static final String DBUserName = "naresh";
    public static final String DBPassword = "mydream";
    
	
	

}
