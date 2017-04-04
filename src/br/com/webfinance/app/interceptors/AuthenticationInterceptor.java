package br.com.webfinance.app.interceptors;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

import br.com.webfinance.global.HttpStatus;

@Provider
@ServerInterceptor
public class AuthenticationInterceptor implements PreProcessInterceptor{

	@Override
	public ServerResponse preProcess(HttpRequest request, ResourceMethod methodInvoke)
			throws Failure, WebApplicationException {
		
		String url = request.getPreprocessedPath();
		
		HttpHeaders headers = request.getHttpHeaders();
		final List<String> authorization = headers.getRequestHeader("Authorization");
		
		String token = "wids 0987654321234567890";
		
		if(url.contains("/rest")){
			String auth = "";
			
			if(authorization != null){
				auth = authorization.get(0);
			}
			
			if(auth.equals(token)){
				return null;
			}
		}else if(url.contains("/login")){
			return null;
		}
		
		return new ServerResponse("Access denied for this resource", HttpStatus.CODE_401, new Headers<Object>());
	}

}
