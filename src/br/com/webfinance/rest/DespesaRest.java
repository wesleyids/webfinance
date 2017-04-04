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

import br.com.webfinance.ejb.DespesaServiceLocal;
import br.com.webfinance.exceptions.FinanceException;
import br.com.webfinance.global.Request;
import br.com.webfinance.global.Response;
import br.com.webfinance.models.Despesa;
import br.com.webfinance.models.Usuario;
import br.com.webfinance.response.DespesasResponse;

@Path("/rest/despesa")
@Stateless
public class DespesaRest {

	@EJB
	private DespesaServiceLocal service;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Despesa> create(Despesa despesa) {
		try {
			return service.create(new Request<Despesa>(despesa));
		} catch (FinanceException e) {
			return null;
		}
	}
	
	/*
	 *	ERROR: retornando muitos objetos
	*/
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Despesa> retrieve(@PathParam("id") int id, Usuario usuario) {
		try {
			Despesa despesa = new Despesa();
			despesa.setUsuario(usuario); // não funciona para consulta
			return service.retrieve(new Request<Despesa>(id, despesa));
		} catch (FinanceException e) {
			return null;
		}
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Despesa> update(@PathParam("id") int id, Despesa despesa) {
		try {
			return service.update(new Request<Despesa>(id, despesa));
		} catch (FinanceException e) {
			return null;
		}
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Despesa> delete(@PathParam("id") int id) {
		try {
			return service.delete(new Request<Despesa>(id));
		} catch (FinanceException e) {
			return null;
		}
	}

	@GET
	@Path("all/{usuario_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object retrieveAll(@PathParam("usuario_id") int id) {

		String jpql = "select d from Despesa d where d.usuario.id = :pUsuario_id";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pUsuario_id", id);

		Object list = service.executeJPQL(jpql, params);

		//DespesasResponse response = new DespesasResponse();
		//response.setDespesas(list);
		//return response;
		return new DespesasResponse(list);
	}

}
