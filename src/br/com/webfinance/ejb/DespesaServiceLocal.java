package br.com.webfinance.ejb;

import javax.ejb.Local;

import br.com.webfinance.models.Despesa;
import br.com.webfinance.services.ServiceLocal;

@Local
public interface DespesaServiceLocal extends ServiceLocal<Despesa> {

}
