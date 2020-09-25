package br.com.anacorp.horasextras.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.anacorp.horasextras.dao.UsuarioDAO;
import br.com.anacorp.horasextras.model.Usuario;

//RestController para EXPOR as URLs (API)
@CrossOrigin("*")
@RestController
public class UsuarioController {

	// precisa acessar o banco de dados
	
	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ArrayList<Usuario> buscarTodos(){
		ArrayList<Usuario> lista;
		
		lista = (ArrayList<Usuario>)dao.findAll();
		return lista;
				
	}
	
	@PostMapping("/usuarios/login")
	public ResponseEntity<Usuario> logarUsuario(@RequestBody Usuario dadosLogin) {
		Usuario resultado = dao.findByRacf(dadosLogin.getRacf());
		if (resultado != null) {
			if(resultado.getSenha().equals(dadosLogin.getSenha())) {
				resultado.setSenha("******");
				return ResponseEntity.ok(resultado);
			}
			else {
				return ResponseEntity.status(401).build();
			}
			
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
}
