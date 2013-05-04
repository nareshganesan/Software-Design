package org.designpatterns.managers;

import java.util.Hashtable;

import org.designpatterns.services.Service;

public class ServiceManager {
	
	private Service service;
	private Hashtable RequestData;
	
	 // Constructor
    public ServiceManager(Service serviceLayerClass ,Hashtable RequestData) {
        this.service = serviceLayerClass;
        this.RequestData = RequestData;
    }
 
    public Hashtable callService(int a, int b) {
        return service.ExecuteService(RequestData);
    }
	
}
