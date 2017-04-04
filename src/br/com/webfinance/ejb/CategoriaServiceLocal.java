package br.com.webfinance.ejb;

import javax.ejb.Local;

import br.com.webfinance.models.Categoria;
import br.com.webfinance.services.ServiceLocal;

@Local
public interface CategoriaServiceLocal extends ServiceLocal<Categoria>{

}
