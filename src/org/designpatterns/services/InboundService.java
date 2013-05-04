package org.designpatterns.services;

import java.util.Hashtable;
/*
 * Inbound Service is for the Suppliers
 * services offered:
 * Supplier Update Details
 * Supplier Update Products Details
 * Supplier Add New Product
 * Supplier view Sales History
 */

import org.designpatterns.businessobjects.BusinessObjectFactory;
import org.designpatterns.businessobjects.BusinessObjects;
import org.designpatterns.constants.Constants;


public class InboundService implements Service {

	public Hashtable ResponseData = new Hashtable();
	private BusinessObjects BO;
	@Override
	public Hashtable ExecuteService(Hashtable RequestData) {
	// TODO Auto-generated method stub

		String FeatureName = (String) RequestData.get("featurename");
		System.out.println("Inbound Service : before execution");
		BO = BusinessObjectFactory.getBusinessObjectbyTyprNameHighConcurrentVersion(FeatureName);
		ResponseData = BO.apply(RequestData);
		System.out.println("Inbound Service : after execution");
		return ResponseData;
	}
	
}
