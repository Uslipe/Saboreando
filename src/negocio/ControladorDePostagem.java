package negocio;

import java.util.List;

import dados.Repositorio;
import dados.RepositorioPostagem;
import negocio.beans.Comentario;
import negocio.beans.ContextoTemporario;
import negocio.beans.Cozinhou;
import negocio.beans.Curtida;
import negocio.beans.Experimentou;
import negocio.beans.Postagem;
import negocio.beans.Usuario;

public class ControladorDePostagem {
    private static ControladorDePostagem instancia;
	private ContextoTemporario contextoTemporario;
	private RepositorioPostagem postagemRepositorio;

    private Repositorio<Curtida> curtidaRepositorio;
    private Repositorio<Comentario> comentarioRepositorio;
    private Repositorio<Cozinhou> cozinhouRepositorio;
    private Repositorio<Experimentou> experimentouRepositorio;
    private Repositorio<Usuario> usuarioRepositorio;

    private ControladorDePostagem() {
         this.postagemRepositorio = new RepositorioPostagem();
        
    }

    public static ControladorDePostagem getInstance() {
        if (instancia == null) {
            instancia = new ControladorDePostagem();
        }
        return instancia;
    }

	// Metodos CRUD p/ Comentarios
	public void adicionarComentario(Postagem postagem, Usuario usuario, String textoComentario) {
		Comentario novoComentario = new Comentario(usuario, textoComentario);
		postagem.getComentarios().add(novoComentario);
		comentarioRepositorio.adicionar(novoComentario);
		System.out.println(usuario.getNome() + " comentou na postagem.");
	}

	public void excluirComentario(Postagem postagem, Comentario comentario) {
		if (postagem.getComentarios().contains(comentario)) {
			postagem.getComentarios().remove(comentario);
			comentarioRepositorio.remover(comentario);
			System.out.println("Comentário removido com sucesso.");
		} else {
			System.out.println("O comentário não existe nesta postagem.");
		}
	}

	public void editarComentario(Postagem postagem, Comentario comentario, String novoTexto) {
		if (postagem.getComentarios().contains(comentario)) {
			comentario.setTexto(novoTexto);
			comentarioRepositorio.listarTodos().forEach(c -> {
				if (c.equals(comentario)) {
					c.setTexto(novoTexto);
				}
			});
			System.out.println("Comentário editado com sucesso.");
		} 
		
		else {
			System.out.println("O comentário não existe nesta postagem.");
		}
	}
	// Metodos CRUD p/ Postagens
	
	public void postar(String titulo, String conteudo) {
		Postagem novaPostagem = new Postagem(titulo, conteudo);
		postagemRepositorio.adicionar(novaPostagem);
		contextoTemporario.setPostagemAtual(novaPostagem);
		System.out.println("Postagem criada com sucesso!"); 
	}

	public void editarPostagem(Postagem postagem, String novoTitulo, String novoConteudo) {
		if (postagemRepositorio.listarTodos().contains(postagem)) {
			postagem.setTitulo(novoTitulo);
			postagem.setConteudo(novoConteudo);
			System.out.println("Postagem editada com sucesso.");
		} else {
			System.out.println("A postagem não existe.");
		}
	}

	public void excluirPostagem(Postagem postagem) {
		if (postagemRepositorio.listarTodos().contains(postagem)) {
			postagemRepositorio.remover(postagem);
			System.out.println("Postagem excluída com sucesso!");
		} else {
			System.out.println("A postagem não existe.");
		}
	}
	
	// Metodos CRUD p/ Curtidas
	
	public void adicionarCurtida(Postagem postagem, Usuario usuario) {
		Curtida novaCurtida = new Curtida(postagem, usuario);
		postagem.getCurtidas().add(novaCurtida);
		curtidaRepositorio.adicionar(novaCurtida);
		System.out.println(usuario.getNome() + " curtiu a postagem!");
	}

	public void descurtir(Postagem postagem, Usuario usuario) {
		List<Curtida> curtidas = postagem.getCurtidas();
		Curtida curtidaRemover = null;
		for (Curtida curtida : curtidas) {
			if (curtida.getUsuario().equals(usuario)) {
				curtidaRemover = curtida;
				break;
			}
		}
		
		if (curtidaRemover != null) {
			curtidas.remove(curtidaRemover);
			curtidaRepositorio.remover(curtidaRemover);
			System.out.println(usuario.getNome() + " removeu a curtida da postagem.");
		} 
		
		else {
			System.out.println("Você não curtiu esta postagem.");
		}
	}

	//Gerados automaticamente
	public Repositorio<Cozinhou> getCozinhouRepositorio() {
		return cozinhouRepositorio;
	}

	public void setCozinhouRepositorio(Repositorio<Cozinhou> cozinhouRepositorio) {
		this.cozinhouRepositorio = cozinhouRepositorio;
	}

	public Repositorio<Experimentou> getExperimentouRepositorio() {
		return experimentouRepositorio;
	}

	public void setExperimentouRepositorio(Repositorio<Experimentou> experimentouRepositorio) {
		this.experimentouRepositorio = experimentouRepositorio;
	}

	public Repositorio<Usuario> getUsuarioRepositorio() {
		return usuarioRepositorio;
	}

	public void setUsuarioRepositorio(Repositorio<Usuario> usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}
}