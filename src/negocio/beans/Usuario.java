package negocio.beans;

import java.time.LocalDate;
import  java.util.*;

public class Usuario {
	private String nome;
	private String email;
	private String username;
	private String senha;
	private List<Usuario> seguidores;
	private List<Usuario> seguindo;
	private List<Postagem> minhasPostagens;
	
	public Usuario(String nome, String email, String username, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.username = username;
		this.senha = senha;
		this.minhasPostagens = new ArrayList<>();
	}

	public void adicionarPostagem(Postagem postagem) {
        minhasPostagens.add(postagem);
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Usuario> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(List<Usuario> seguidores) {
		this.seguidores = seguidores;
	}

	public List<Usuario> getSeguindo() {
		return seguindo;
	}

	public void setSeguindo(List<Usuario> seguindo) {
		this.seguindo = seguindo;
	}

	public void setNomeUsuario(String novoNomeUsuario) {
		// TODO Auto-generated method stub
		
	}

	public void setIdade(int novaIdade) {
		// TODO Auto-generated method stub
		
	}

	public void seguir(Usuario usuarioASeguir) {
		// TODO Auto-generated method stub
		
	}

	public void desseguir(Usuario usuarioADesseguir) {
		// TODO Auto-generated method stub
		
	}

}