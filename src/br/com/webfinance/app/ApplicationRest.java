package br.com.webfinance.app;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationRest extends Application {
	
	public ApplicationRest(){
		System.out.println("ApplicationRest()");
	}
}