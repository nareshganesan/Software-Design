package org.designpatterns.services;

import java.util.Hashtable;

import org.designpatterns.businessobjects.BusinessObjectFactory;
import org.designpatterns.businessobjects.BusinessObjects;

public class AuthenticationService implements Service 
{	
	public Hashtable ResponseData = new Hashtable();
	private BusinessObjects BO;
	
	
	@Override
	public Hashtable ExecuteService(Hashtable RequestData) {
		// TODO Auto-generated method stub

		String FeatureName = (String) RequestData.get("feature");
		System.out.println("Auth Service : before execution");
		BO = BusinessObjectFactory.getBusinessObjectbyTyprNameHighConcurrentVersion(FeatureName);
		ResponseData = BO.apply(RequestData);
		System.out.println("Auth Service : after execution");
		return ResponseData;
	}
}
