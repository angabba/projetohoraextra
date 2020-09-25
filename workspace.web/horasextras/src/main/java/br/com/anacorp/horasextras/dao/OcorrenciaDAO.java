package br.com.anacorp.horasextras.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.anacorp.horasextras.model.Ocorrencia;

public interface OcorrenciaDAO extends CrudRepository<Ocorrencia, Integer> {
	
	public ArrayList<Ocorrencia> findByStatus(int Status); 

}
