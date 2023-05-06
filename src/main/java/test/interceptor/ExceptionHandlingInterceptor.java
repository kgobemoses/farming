package test.interceptor;

import java.io.Serializable;

import javax.ejb.EJBAccessException;
import javax.ejb.EJBContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExceptionHandling
@Interceptor
public class ExceptionHandlingInterceptor implements Serializable {

	private static final long serialVersionUID = -759440919588413681L;
	private static final Logger log = LoggerFactory.getLogger(ExceptionHandlingInterceptor.class);

	public ExceptionHandlingInterceptor() {
	}

	@AroundInvoke
	public Object handleMethodException(InvocationContext invocationContext) throws Exception {
		try{
			return invocationContext.proceed();
		}catch(EJBAccessException ex){
			EJBContext ctx = null;
			try {
			      InitialContext ic = new InitialContext();
			      ctx = (EJBContext) ic.lookup("java:comp/EJBContext");
			  } catch (NamingException namingException) {
			      throw new IllegalStateException(namingException);
			  }
			if(ctx.getCallerPrincipal().getName().equals("anonymous")){
				log.info("User is Not Loggedin, can't call business method:  "+invocationContext.getMethod());
				return Response.status(Status.UNAUTHORIZED).build();
			}else{
				log.info("User is Not Authorized to call business method invoked by:  "+invocationContext.getMethod());
				return Response.status(Status.FORBIDDEN).build();
			}
		}
	}
}
