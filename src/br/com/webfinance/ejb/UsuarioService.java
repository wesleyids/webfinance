package br.com.webfinance.ejb;

import javax.ejb.Stateless;

import br.com.webfinance.models.*;
import br.com.webfinance.services.Service;

@Stateless
public class UsuarioService extends Service<Usuario> implements UsuarioServiceLocal{

}
