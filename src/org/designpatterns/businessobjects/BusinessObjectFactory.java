package org.designpatterns.businessobjects;

import java.util.HashMap;
import java.util.Map;

import org.designpatterns.constants.Constants;
import org.designpatterns.services.Service;

public class BusinessObjectFactory {
		
		private static Map<String, BusinessObjects> BOs = new HashMap<String, BusinessObjects>();
		private static BusinessObjects IBusinessObjects;
		
		private BusinessObjectFactory(String FeatureName) {
	    }
		
		public static BusinessObjects getBusinessObjectbyTyprNameHighConcurrentVersion(String FeatureName) {
	        if (!BOs.containsKey(FeatureName)) {
	                synchronized (BOs) {
	                        // Check again, after having acquired the lock to make sure
	                        // the instance was not created meanwhile by another thread
	                        if (!BOs.containsKey(FeatureName)) {
	                                // Lazy initialisation
	                        	try {
	                        		IBusinessObjects = (BusinessObjects) Class.forName(
											Constants.BUSINESSOBJECTPACKAGE + FeatureName
													+ Constants.OPERATION).newInstance();
								} catch (InstantiationException e) {
									// TODO Auto-generated catch block
									System.out
									.println("BusinessObject could not be instantiated inside Service Factory");
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									System.out
									.println("BusinessObject could not be accessed inside Service Factory");
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									System.out
									.println("BusinessObject not Found during inside Service Factory");
								}
	                        	BOs.put(FeatureName, IBusinessObjects);
	                        }
	                }
	        }

	        return BOs.get(FeatureName);
		}




}
