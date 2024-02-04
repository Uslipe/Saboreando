package dados;

import negocio.beans.Postagem;
import negocio.beans.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPostagem implements Repositorio<Postagem> {

    private List<Postagem> postagens;
	private Postagem postagem;

    public RepositorioPostagem() {
        this.postagens = new ArrayList<>();
    }

    @Override
    public List<Postagem> listarTodos() {
        return new ArrayList<>(postagens); // Retorna uma cópia da lista para evitar modificações indesejadas
    }

    @Override
    public void adicionar(Postagem postagem) {
        postagens.add(postagem);
    }

    @Override
    public void remover(Postagem postagem) {
        postagens.remove(postagem);
    }

    @Override
    public void inserir(Postagem postagens) {
    	postagens.add(postagem);
    }
    
    // Método extra para buscar uma postagem pelo título
    public Postagem buscarPorTitulo(String titulo) {
        for (Postagem postagem : postagens) {
            if (postagem.getTitulo().equals(titulo)) {
                return postagem;
            }
        }
        return null; // Retorna null se não encontrar a postagem com o título fornecido
    }

    /**
     * @return a cópia da lista de postagens
     */
    public List<Postagem> getPostagens() {
        return new ArrayList<>(postagens);
    }

    /**
     * Define a lista de postagens.
     *
     * @param postagens a nova lista de postagens
     */
    public void setPostagens(List<Postagem> postagens) {
        this.postagens = new ArrayList<>(postagens);
    }

	@Override
	public Usuario buscarPorNomeUsuario(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Postagem postagem) {
		// TODO Auto-generated method stub
		
	}
}
