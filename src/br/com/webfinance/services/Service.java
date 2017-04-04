package br.com.webfinance.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.webfinance.exceptions.FinanceException;
import br.com.webfinance.global.HttpStatus;
import br.com.webfinance.global.Mensagem;
import br.com.webfinance.global.Request;
import br.com.webfinance.global.Response;
import br.com.webfinance.models.Entidade;
import br.com.webfinance.util.Error;
import br.com.webfinance.util.Status;
import br.com.webfinance.util.Util;

public class Service<T extends Entidade> implements ServiceLocal<T> {

	@PersistenceContext(unitName = "Finances-PU")
	protected EntityManager em;

	@Override
	public Response<T> create(Request<T> request) throws FinanceException{
		//request.getEntidade().setDataCadastro(Calendar.getInstance());

		Response<T> response = new Response<T>();

		em.persist(request.getEntidade());

		@SuppressWarnings("unchecked")
		T aux = (T) em.find(request.getEntidade().getClass(), request
				.getEntidade().getId());

		if (aux != null) {
			response.setData(aux);
			response.setMensagens(new Status(Mensagem.SUCCESS, Mensagem.INSERT_SUCCESS));
		}else{
			//throw new FinanceException("");
		}

		return response;
	}

	@Override
	public Response<T> retrieve(Request<T> request) throws FinanceException {
		
		Response<T> response = new Response<T>();
		
		@SuppressWarnings("unchecked")
		T aux = (T) em.find(request.getEntidade().getClass(), request.getId());
		
		if (aux != null) {
			@SuppressWarnings("unchecked")
			T retorno = (T) Util.objectClone(aux, new HashMap<Object, Object>());
			response.setData(retorno);
			response.setMensagens(new Status(Mensagem.SUCCESS, Mensagem.RETRIEVE_SUCCESS));
		}else{
			response.setMensagens(new Error(HttpStatus.CODE_404, "Não localizado"));
			//throw new FinanceException("não localizado");
		}

		return response;
	}

	@Override
	public Response<T> update(Request<T> request) throws FinanceException {
		
		Response<T> response = new Response<T>();
		
		@SuppressWarnings("unchecked")
		T aux = (T) em.find(request.getEntidade().getClass(), request.getId());

		if (aux != null) {
			
			request.getEntidade().setId(aux.getId());
			
			em.merge(request.getEntidade());
			
			response.setData(request.getEntidade());
			response.setMensagens(new Status(Mensagem.SUCCESS, Mensagem.ALTER_SUCCESS));
		}else{
			response.setMensagens(new Error(HttpStatus.CODE_304, "Usuário não foi alterado"));
			//throw new FinanceException("Usuário não foi alterado");
		}

		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Response<T> delete(Request<T> request) throws FinanceException {
		
		Response<T> response = new Response<T>();
		
		T aux = request.getEntidade();
		aux = (T) em.find(request.getEntidade().getClass(), request.getId());

		if (aux != null) {
			
			//request.getEntidade().setId(aa.getId());
			
			em.remove(aux);
			response.setMensagens(new Status(Mensagem.SUCCESS, Mensagem.DELETE_SUCCESS));
		}else{
			response.setMensagens(new Error(HttpStatus.CODE_404, "Usuário não foi excluido"));
			//throw new FinanceException("Não encontrado...");
		}
		
		return response;
	}
	
	@Override
	public List<Object> executeJPQL(String jpql, Map<String, Object> parameters){
		Query query = em.createQuery(jpql);

		if (parameters != null) {
			for (String key : parameters.keySet()) {
				query.setParameter(key, parameters.get(key));
			}
		}
		
		// implementar Exception
		@SuppressWarnings("unchecked")
		List<Object> result = query.setMaxResults(10).getResultList();
		
		List<Object> retorno = new ArrayList<Object>();
		
		Object objeto = null;
		Object objetoAux = null;
		
		for(int i = 0; i < result.size(); i++){
			objeto = result.get(i);
			objetoAux = Util.objectClone(objeto, new HashMap<Object, Object>());
			retorno.add(objetoAux);
		}
		
		return retorno;
	}

}	
