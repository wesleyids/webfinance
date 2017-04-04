package br.com.webfinance.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.spi.NotFoundException;

import br.com.webfinance.ejb.UsuarioServiceLocal;
import br.com.webfinance.models.Credenciais;

@Path("/login")
@Stateless
public class LoginRest {

	@EJB
	private UsuarioServiceLocal service;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String autenticar(Credenciais credenciais){
		
		String jpql = "select u from Usuario u where u.email = :pEmail and u.password = :pPassword ";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pEmail", credenciais.getEmail());
		params.put("pPassword", credenciais.getPassword());
		
		Object usuario = service.executeJPQL(jpql, params);
	
		if(usuario == null){
			throw new NotFoundException("Usuario não encontrado");
		}
		
		String token = "{ \"token\" : \"wids 0987654321234567890\"}";
		
		return token;
	}
	
}
