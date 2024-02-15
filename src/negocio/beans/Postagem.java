package negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Postagem {
    private static int contador = 0; // Contador para autoincremento de ids
    private int id;
	private String titulo;
	private String conteudo;
	private List<Curtida> curtidas;
	private List<Comentario> comentarios;
	private int qntCurtidas;
	private List<Cozinhou> cozinhou;
	private List<Experimentou> experimentou;
	
	  // Construtor
    public Postagem(String titulo, String conteudo) {
        this.id = getNextId();
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.curtidas = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.qntCurtidas = 0;
        this.cozinhou = new ArrayList<>();
        this.experimentou = new ArrayList<>();
    }
    
    private static int getNextId() {
        return ++contador;
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

    // Metodo p/ calcular qntCurtidas
    public int calcularQntCurtidas() {
        return qntCurtidas;
    }

	public void add(Postagem postagens) {
		// TODO Auto-generated method stub
		
	}
}

