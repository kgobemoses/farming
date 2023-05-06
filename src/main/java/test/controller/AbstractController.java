package test.controller;

import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;

import org.jboss.resteasy.annotations.GZIP;

import test.interceptor.ExceptionHandling;
import test.interceptor.Log;

import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;


@Log
@GZIP
@ExceptionHandling
public class AbstractController {
	protected RepresentationFactory representationFactory;
	protected static final String CONTACT_ADMIN = "If the problem continues, please advice your Administrator";
	protected static final String HIDE = "hide";
	
	public AbstractController(){
		
	}
	
	public AbstractController(RepresentationFactory representationFactory){
		this.representationFactory = representationFactory;
	}	
	
	protected Representation buildResource(HttpServletRequest req, long resourceId, Class<?> controllerClass) throws MalformedURLException {
		Representation resource  = representationFactory.newRepresentation(ControllerUtil.retrieveBaseURL(req)
				.concat(ControllerUtil.fetchPathAnnotationValue(controllerClass).substring(1))
				.concat("/"+resourceId));

		return resource;
	}
	
}
