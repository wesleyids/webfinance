package br.com.webfinance.services;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import br.com.webfinance.exceptions.FinanceException;
import br.com.webfinance.global.Request;
import br.com.webfinance.global.Response;
import br.com.webfinance.models.Entidade;

@Local
public interface ServiceLocal<T extends Entidade> {

	public Response<T> create(Request<T> request) throws FinanceException;
	
	public Response<T> retrieve(Request<T> request) throws FinanceException;
	
	public Response<T> update(Request<T> request) throws FinanceException;
	
	public Response<T> delete(Request<T> request) throws FinanceException;
	
	public List<Object> executeJPQL(String jpql, Map<String, Object> parameters);
	
}
