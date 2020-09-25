package br.com.isidrocorp.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.hello.model.produto;

// importamos a anotação RestController para informar que a classe hellocontroller atende solicitações web através de URLs

@RestController
public class hellocontroller {
	
// a anotação @GetMapping indica que esse método (sayHello) vai retornar alguma info só que
// ela precisa ser parametrizada com o caminho da URL
	
	@GetMapping("/Hello")
	public String Hello() {
		
		return "Hello World from Spring Boot :)";
	}
	
	@GetMapping("/Produto")
	public produto exibirProduto() {
		produto p = new produto();
		p.setId(1234);
		p.setDescricao("Computador");
		p.setPreco(200.0);
		p.setQtdeEstoque(3);
		
		return p;
	}
	

}
