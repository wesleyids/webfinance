package br.com.webfinance.ejb;

import javax.ejb.Local;

import br.com.webfinance.models.*;
import br.com.webfinance.services.ServiceLocal;

@Local
public interface UsuarioServiceLocal extends ServiceLocal<Usuario>{

}
