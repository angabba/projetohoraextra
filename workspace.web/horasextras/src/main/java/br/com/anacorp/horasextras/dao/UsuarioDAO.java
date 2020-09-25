package br.com.anacorp.horasextras.dao;

import org.springframework.data.repository.CrudRepository;
import br.com.anacorp.horasextras.model.Usuario;

public interface UsuarioDAO extends CrudRepository <Usuario, Integer> {

	public Usuario findByRacf(String racf);
	

	
	
}
