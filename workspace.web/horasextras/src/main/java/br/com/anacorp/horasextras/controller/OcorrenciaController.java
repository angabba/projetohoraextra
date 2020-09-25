package br.com.anacorp.horasextras.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.anacorp.horasextras.dao.OcorrenciaDAO;
import br.com.anacorp.horasextras.model.Ocorrencia;

@CrossOrigin("*")
@RestController
public class OcorrenciaController {
	
	@Autowired
	private OcorrenciaDAO dao;
	
	@GetMapping("/ocorrencias/{id}")
	public Ocorrencia buscarDetalhesPeloId(@PathVariable int id) {
		Ocorrencia oc = dao.findById(id).orElse(null);
		return oc;
		
	}
	
	@GetMapping("/ocorrencias")
	public ArrayList<Ocorrencia> buscarTodas(){
		ArrayList<Ocorrencia> lista;
		lista = (ArrayList<Ocorrencia>)dao.findAll();
		return lista;
	}
	
	@GetMapping("/ocorrencias/status/{status}")
	public ArrayList<Ocorrencia> buscaPorStatus(@PathVariable int status){
		ArrayList<Ocorrencia> lista;
		lista = dao.findByStatus(status);
		return lista;
	}
	
	@PutMapping("/ocorrencias/atualizar")
	public Ocorrencia atualizarOcorrencia(@RequestBody Ocorrencia oc) {
		try {
			dao.save(oc);
			return oc;
		}
		catch(Exception ex) {
			return null;
		}
	}

}
