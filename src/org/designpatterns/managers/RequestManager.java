package org.designpatterns.managers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.designpatterns.constants.Constants;
import org.designpatterns.services.Service;
import org.designpatterns.services.ServiceFactory;

/**
 * Servlet implementation class RequestManager
 */
@WebServlet("/RequestManager")
public class RequestManager extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Hashtable RequestData = new Hashtable();
	private Hashtable ResponseData = new Hashtable();
	private String ServiceName = new String();
	private Object service;
	private Service IService;
	private String ResponsePage;
	private ServletContext context;
	private String[] customersArray;
	private String customername;
	private HttpSession session;
	private Properties properties;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
		
	}

	/*
	 * All the Request are processed based on the kind of service. Requires:
	 * service parameter. Modifies: request and forwards / redirects the request
	 * to Module Manager.
	 */
	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		ServletContext context;
		// Validate the session every time
		validateSession(request, response);
		// get all the request data from the request object
		RequestData = getRequestData(request, response);

		// Service parameter decides what kind of service needs to be processed on the request.
		ServiceName = (String) RequestData.get("service");
		System.out.println("Service Name : " + ServiceName);

		// If Service parameter starts with display* then its just a request to displaya view pay which will follow
		// the pattern display* in the parameter value itself.
		if (ServiceName.startsWith("display")
				|| ServiceName.contains("display")) {
			if (((String) RequestData.get("session"))
					.equalsIgnoreCase("notrequired")
					|| ((String) RequestData.get("session")) == "notrequired") {
				ResponsePage = "/"
						+ ServiceName.substring(7, ServiceName.length())
						+ ".jsp";
				removePreviousRequestData();
				setResponseDatatoSession(RequestData);
				context = this.getServletContext();
				RequestDispatcher requestDispatcher = context
						.getRequestDispatcher(ResponsePage);
				requestDispatcher.forward(request, response);
			} else {
				// If the service parameter starts with display* but the view page requires a authentication then 
				// this part takes care of it.
				String username = (String) session.getAttribute("username");
				String password = (String) session.getAttribute("password");
				IService = ServiceFactory
						.getServicebyTyprNameHighConcurrentVersion("Authentication");
				ResponseData = IService.ExecuteService(RequestData);
				removePreviousRequestData();
				setResponseDatatoSession(ResponseData);

				// session.setAttribute("ResponseData", ResponseData);
				if (ResponseData.get("Authentication").toString()
						.equalsIgnoreCase("success")
						|| ResponseData.get("Authentication").toString() == "success") {
					ResponsePage = "/"
							+ ServiceName.substring(7, ServiceName.length())
							+ ".jsp";
				} else {
					ResponsePage = "/"
							+ (String) ResponseData.get(Constants.RESPONSEPAGE);
				}
				context = this.getServletContext();
				RequestDispatcher requestDispatcher = context
						.getRequestDispatcher(ResponsePage);
				requestDispatcher.forward(request, response);

			}

		}  else {

			// If the service parameter has the service mentioned then this place dynamically handles the request to the
			// Service Factory.
			
			IService = ServiceFactory
					.getServicebyTyprNameHighConcurrentVersion(ServiceName);
			System.out.println("RM before Service : " );
			ResponseData = IService.ExecuteService(RequestData);
			removePreviousRequestData();
			setResponseDatatoSession(ResponseData);
			System.out.println("RM after Service : " );
			 session.setAttribute("ResponseData", ResponseData);
			ResponsePage = "/"
					+ (String) ResponseData.get(Constants.RESPONSEPAGE);
			context = this.getServletContext();
			RequestDispatcher requestDispatcher = context
					.getRequestDispatcher(ResponsePage);
			requestDispatcher.forward(request, response);

		}

	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub

		super.init();
		// properties = new Properties();
		// try {
		// properties.load(getClass().getResourceAsStream("SQL.properties"));
		// } catch (IOException e) {
		// }
	}

	//Gets the data from the session and adds it to the session.
	protected Hashtable getRequestData(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String paramValue = request.getParameter(paramName);
			System.out.println("Request Data collected : " + paramName
					+ " : " + paramValue);
			//session.setAttribute(paramName, paramValue);
			RequestData.put(paramName, paramValue);
		}
		if(!(null == session.getAttribute("username"))){
			RequestData.put("username", session.getAttribute("username"));
			System.out.println("Request Data collected : username : " + session.getAttribute("username"));
		}
		if(!(null == session.getAttribute("usertype"))){
			RequestData.put("usertype", session.getAttribute("usertype"));
			System.out.println("Request Data collected : username : " + session.getAttribute("usertype"));
		}
		
		return RequestData;

	}

	// Adds the Response data to the session
	protected void setResponseDatatoSession(Hashtable Responsedata)
			throws IOException, ServletException {

		Enumeration parameterNames = Responsedata.keys();
		while (parameterNames.hasMoreElements()) {
			String paramName = (String) parameterNames.nextElement();
			Object paramValue = Responsedata.get(paramName);
			System.out.println("Response Data added to session : " + paramName
					+ " : " + paramValue);
			if(Responsedata.get("username").toString() != null){
			session.setAttribute(paramName, paramValue);}
			RequestData.put(paramName, paramValue);
		}

	}

	protected void removePreviousRequestData() throws IOException, ServletException{
		Enumeration parameterNames = session.getAttributeNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = (String) parameterNames.nextElement();
			//if(!(paramName.equalsIgnoreCase("username") || paramName.equalsIgnoreCase("usertype"))){
				 session.removeAttribute(paramName);
					//System.out.println("Date removed from session : " + paramName);
					//session.setAttribute(paramName, paramValue);
			//}
			
			
		}
		
	}
	// Validates the Session for new or inactive
	protected void validateSession(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		session = request.getSession(false);

		if (session == null) {
			session = request.getSession();
			session.setMaxInactiveInterval(30 * 60);
		} else {
			if ((session.getCreationTime() - session.getLastAccessedTime()) > (30 * 60)) {
				session.invalidate();
			}
		}
	}

}
