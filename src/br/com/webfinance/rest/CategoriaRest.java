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

import br.com.webfinance.ejb.CategoriaServiceLocal;
import br.com.webfinance.exceptions.FinanceException;
import br.com.webfinance.global.Request;
import br.com.webfinance.global.Response;
import br.com.webfinance.models.Categoria;
import br.com.webfinance.response.CategoriasResponse;

@Path("/rest/categoria")
@Stateless
public class CategoriaRest {

	@EJB
	private CategoriaServiceLocal service;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Categoria> create(Categoria categoria){
		try{
			return service.create(new Request<Categoria>(categoria));
		}catch(FinanceException e){
			return null;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response<Categoria> retrieve(@PathParam("id") int id){
		try{
			return service.retrieve(new Request<Categoria>(id, new Categoria()));
		}catch(FinanceException e){
			return null;
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response<Categoria> update(@PathParam("id") int id, Categoria categoria){
		try{
			return service.update(new Request<Categoria>(id, categoria));
		}catch(FinanceException e){
			return null;
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response<Categoria> delete(@PathParam("id") int id){
		try{
			return service.delete(new Request<Categoria>(id, new Categoria()));
		}catch(FinanceException e){
			return null;
		}
	}
	
	@GET
	@Path("/all/{usuario_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object retrieveAll(@PathParam("usuario_id") int id){
		
		String jpql = "select c from Categoria c where c.usuario.id = :pUsuario_id";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pUsuario_id", id);

		Object list = service.executeJPQL(jpql, params);

		return new CategoriasResponse(list);
	}
}
