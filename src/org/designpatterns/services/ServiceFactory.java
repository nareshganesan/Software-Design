package org.designpatterns.services;

import java.util.HashMap;
import java.util.Map;

import org.designpatterns.constants.Constants;

public class ServiceFactory {
	
	private static Map<String, Service> Services = new HashMap<String, Service>();
	private static Service IService;
	
	private ServiceFactory(String Service) {
    }
	
	public static Service getServicebyTyprNameHighConcurrentVersion(String ServiceName) {
        if (!Services.containsKey(ServiceName)) {
                synchronized (Services) {
                        // Check again, after having acquired the lock to make sure
                        // the instance was not created meanwhile by another thread
                        if (!Services.containsKey(ServiceName)) {
                                // Lazy initialisation
                        	try {
								IService = (Service) Class.forName(
										Constants.SERVICEPACKAGE + ServiceName
												+ Constants.SERVICE).newInstance();
							} catch (InstantiationException e) {
								// TODO Auto-generated catch block
								System.out
								.println("Service could not be instantiated inside Service Factory");
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.out
								.println("Service could not be accessed inside Service Factory");
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.out
								.println("Service not Found during inside Service Factory");
							}
                        	Services.put(ServiceName, IService);
                        }
                }
        }

        return Services.get(ServiceName);
	}

}
