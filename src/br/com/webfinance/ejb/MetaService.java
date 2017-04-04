package br.com.webfinance.ejb;

import javax.ejb.Stateless;

import br.com.webfinance.models.Meta;
import br.com.webfinance.services.Service;

@Stateless
public class MetaService extends Service<Meta> implements MetaServiceLocal{

}
