package br.com.webfinance.ejb;

import javax.ejb.Stateless;

import br.com.webfinance.models.Renda;
import br.com.webfinance.services.Service;

@Stateless
public class RendaService extends Service<Renda> implements RendaServiceLocal{

}
