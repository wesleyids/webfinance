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

import br.com.webfinance.ejb.MetaServiceLocal;
import br.com.webfinance.exceptions.FinanceException;
import br.com.webfinance.global.Request;
import br.com.webfinance.global.Response;
import br.com.webfinance.models.Meta;
import br.com.webfinance.response.MetasResponse;

@Path("/rest/meta")
@Stateless
public class MetaRest {

	@EJB
	private MetaServiceLocal service;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Meta> create(Meta meta){
		try{
			return service.create(new Request<Meta>(meta));
		}catch(FinanceException e){
			return null;
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Meta> retrieve(@PathParam("id") int id){
		try{
			return service.retrieve(new Request<Meta>(id, new Meta()));
		}catch(FinanceException e){
			return null;
		}
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Meta> update(@PathParam("id") int id, Meta meta){
		try{
			return service.update(new Request<Meta>(id, meta));
		}catch(FinanceException e){
			return null;
		}
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Meta> delete(@PathParam("id") int id){
		try{
			return service.delete(new Request<Meta>(id));
		}catch(FinanceException e){
			return null;
		}
	}
	
	@GET
	@Path("/all/{usuario_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object retrieveAll(@PathParam("usuario_id") int id){

		String jpql = "select m from Meta m where m.usuario.id = :pUsuario_id";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pUsuario_id", id);

		Object list = service.executeJPQL(jpql, params);

		return new MetasResponse(list);
	}
}
