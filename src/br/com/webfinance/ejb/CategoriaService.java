package br.com.webfinance.ejb;

import javax.ejb.Stateless;

import br.com.webfinance.models.Categoria;
import br.com.webfinance.services.Service;

@Stateless
public class CategoriaService extends Service<Categoria> implements CategoriaServiceLocal{

}
