package negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Postagem {
	private String titulo;
	private String conteudo;
	private List<Curtida> curtidas;
	private List<Comentario> comentarios;
	private int qntCurtidas;
	private List<Cozinhou> cozinhou;
	private List<Experimentou> experimentou;
	private List<Usuario> usuarios;
	
	  // Construtor
    public Postagem(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.curtidas = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.qntCurtidas = 0;
        this.cozinhou = new ArrayList<>();
        this.experimentou = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Get e Set
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public List<Curtida> getCurtidas() {
        return curtidas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public int getQntCurtidas() {
        return qntCurtidas;
    }

    public List<Cozinhou> getCozinhou() {
        return cozinhou;
    }

    public List<Experimentou> getExperimentou() {
        return experimentou;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    // Metodo p/ calcular qntCurtidas
    public int calcularQntCurtidas() {
        return qntCurtidas;
    }

	public void add(Postagem postagens) {
		// TODO Auto-generated method stub
		
	}
}

