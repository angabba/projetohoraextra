package br.com.anacorp.horasextras.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.anacorp.horasextras.dao.AtividadeDAO;
import br.com.anacorp.horasextras.model.Atividade;

@CrossOrigin("*")
@RestController
public class AtividadeController {
	
	@Autowired
	private AtividadeDAO dao;
	
	@GetMapping("/atividades")
	public ArrayList<Atividade> buscarAtividades(){
		ArrayList<Atividade> lista;
		
		lista = (ArrayList<Atividade>)dao.findAll();
		return lista;
	}

}
