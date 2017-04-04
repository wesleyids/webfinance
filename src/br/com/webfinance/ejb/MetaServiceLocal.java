package br.com.webfinance.ejb;

import javax.ejb.Local;

import br.com.webfinance.models.Meta;
import br.com.webfinance.services.ServiceLocal;

@Local
public interface MetaServiceLocal extends ServiceLocal<Meta>{

}
