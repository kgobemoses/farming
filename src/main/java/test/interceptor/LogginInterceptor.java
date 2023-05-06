package test.interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Log
@Interceptor
public class LogginInterceptor implements Serializable {

	private static final long serialVersionUID = -759440919588413681L;
	private static final Logger log = LoggerFactory.getLogger(LogginInterceptor.class);

	public LogginInterceptor() {
	}

	@AroundInvoke
	public Object logMethodInvocation(InvocationContext invocationContext) throws Exception {
		log.info("Invoking Method: "+ invocationContext.getMethod().getDeclaringClass().getName()+"."
				+ invocationContext.getMethod().getName());
		
		Object results = invocationContext.proceed();
		
		log.info("Completed Method: "+ invocationContext.getMethod().getDeclaringClass().getName()+"."
				+ invocationContext.getMethod().getName());
		
		return results ;
	}
}
