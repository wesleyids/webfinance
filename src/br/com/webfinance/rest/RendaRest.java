package br.com.webfinance.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.webfinance.ejb.RendaServiceLocal;
import br.com.webfinance.exceptions.FinanceException;
import br.com.webfinance.global.Request;
import br.com.webfinance.global.Response;
import br.com.webfinance.models.Renda;
import br.com.webfinance.response.RendasResponse;

@Path("/rest/renda")
@Stateless
public class RendaRest {

	@EJB
	private RendaServiceLocal service;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Renda> create(Renda renda){
		try{
			return service.create(new Request<Renda>(renda));
		}catch(FinanceException e){
			return null;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Renda> retrieve(){
		return null;
	}
	
	@PUT
	@Path("/{usuario_id}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Renda> update(@PathParam("id") int id, Renda renda){
		try{
			return service.update(new Request<Renda>(renda));
		}catch(FinanceException e){
			return null;
		}
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Renda> delete(@PathParam("id") int id){
		try{
			return service.delete(new Request<Renda>(id));
		}catch(FinanceException e){
			return null;
		}
	}
	
	@GET
	@Path("/all/{usuario_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object retrieveAll(@PathParam("usuario_id") int id){
		
		String jpql = "select r from Renda r where r.usuario.id = :pUsuario_id";
	
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pUsuario_id", id);

		Object list = service.executeJPQL(jpql, params);
		
		return new RendasResponse(list);
	}
	
}
