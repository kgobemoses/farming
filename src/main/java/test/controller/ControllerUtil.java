package test.controller;

import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.ServerEndpoint;
import javax.ws.rs.Path;

import test.config.JaxRSActivator;


public class ControllerUtil {

	public static String fetchPathAnnotationValue(Class<?> clazz) {
		//deal with a WELD bug in Jboss-as-7.1.1.Final (Weld 1.*), Weld creates a proxy of classes that
		//make use of injected Instance created via @Produces, but the proxy class doesn't have any original metadata (e.g. annotations)
		String className = clazz.getCanonicalName();
		if(className.contains("$")){
			className = className.substring(0,className.indexOf("$"));
			try {
				clazz = Class.forName(className);
			} catch (ClassNotFoundException e) {
				return "";
			}
			
		}
		
		String value = null;
		Path path = clazz.getAnnotation(Path.class);
		if(path != null) {
			value = path.value();
		}else {
			ServerEndpoint serverEndpoint = clazz.getAnnotation(ServerEndpoint.class);
			value = serverEndpoint.value();
		}
		
		return value;
	}

	public static String retrieveBaseURL(HttpServletRequest req) throws MalformedURLException {
		return req.getRequestURL().toString()
				.replaceAll(req.getRequestURI(), "")
				.concat(req.getContextPath()+"/"+JaxRSActivator.REST_PATH.concat("/"));
	}

	public static String retrieveAbsolutePath(HttpServletRequest req) throws MalformedURLException {
		return req.getRequestURL().toString();
	}

}
