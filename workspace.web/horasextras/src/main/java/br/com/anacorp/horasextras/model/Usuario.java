package br.com.anacorp.horasextras.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // indica que a classe usuário é uma entidade armazenável em banco de dados
@Table(name="itmn232_usuario") // especificar o nome da tabela do banco de dados
public class Usuario {
	
	@Id														// indico que o atributo é uma Primary Key 
	@Column(name="id_usuario")								// indico o nome da coluna
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// indico que o id será incrementado automaticamente
	private int id;
	
	@Column(name="nome_usuario", length=100)
	private String nome;
	
	@Column(name="email_usuario", length=100, unique=true)
	private String email;
	
	@Column(name="racf", length=7, unique=true)
	private String racf;
	
	@Column(name="senha", length=50)
	private String senha;
	
	@Column(name="link_foto", length=255)
	private String linkFoto;
	
	@Column(name="gestor")
	private int gestor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	public int getGestor() {
		return gestor;
	}
	public void setGestor(int gestor) {
		this.gestor = gestor;
	}
	
	@OneToMany(mappedBy="colaborador", cascade=CascadeType.ALL) //relacionamento 1colaborador para N ocorrências. O cascade permite atualização na tabela de ocorrência a partir da atualização de usuários
	@JsonIgnoreProperties("colaborador")                        //tirar o looping de retorno da pesquisa. precisa ter quando tem 1:N
	private List<Ocorrencia> listaOcorrencias;
	
	public List<Ocorrencia> getListaOcorrencias() {
		return listaOcorrencias;
	}
	public void setListaOcorrencias(List<Ocorrencia> listaOcorrencias) {
		this.listaOcorrencias = listaOcorrencias;
	}
	
	
	
}
