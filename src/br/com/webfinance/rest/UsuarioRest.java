package br.com.webfinance.rest;

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

import br.com.webfinance.ejb.UsuarioServiceLocal;
import br.com.webfinance.exceptions.FinanceException;
import br.com.webfinance.global.Request;
import br.com.webfinance.global.Response;
import br.com.webfinance.models.Usuario;

@Path("/")
@Stateless
public class UsuarioRest {

	@EJB
	private UsuarioServiceLocal service;

	@POST
	@Path("/usuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Usuario> create(Usuario usuario)  {

		//usuario.setPassword(Util.criptPassword(usuario.getPassword()));
		
		try {
			return service.create(new Request<Usuario>(usuario));
		} catch (Exception e) {
			return null;
		}
	}

	@GET
	@Path("/rest/usuario/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Usuario> retrieve(@PathParam("id") int id) {
		
		try {
			return service.retrieve(new Request<Usuario>(id, new Usuario()));
		} catch (FinanceException e) {
			return null;
		}
	}

	@PUT
	@Path("/rest/usuario/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Usuario> update(@PathParam("id") int id, Usuario usuario){
		try {
			return service.update(new Request<Usuario>(id, usuario));
		} catch (FinanceException e) {
			return null;
		}
	}

	@DELETE
	@Path("/rest/usuario/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Usuario> delete(@PathParam("id") int id) throws Exception {
		return service.delete(new Request<Usuario>(id, new Usuario()));
	}

}
