package br.com.webfinance.ejb;

import javax.ejb.Local;

import br.com.webfinance.models.Renda;
import br.com.webfinance.services.ServiceLocal;

@Local
public interface RendaServiceLocal extends ServiceLocal<Renda>{

}
