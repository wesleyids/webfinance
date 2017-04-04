package br.com.webfinance.ejb;

import javax.ejb.Stateless;

import br.com.webfinance.models.Despesa;
import br.com.webfinance.services.Service;

@Stateless
public class DespesaService extends Service<Despesa> implements DespesaServiceLocal{
	
}
