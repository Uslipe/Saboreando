package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.beans.Postagem;
import negocio.beans.Usuario;
	
public class RepositorioUsuario implements Repositorio<Usuario> {
	    private List<Usuario> usuarios;

	    public RepositorioUsuario() {
	        this.usuarios = new ArrayList<>();
	    }

	    @Override
	    public List<Usuario> listarTodos() {
	        return usuarios;
	    }

	    @Override
	    public void adicionar(Usuario usuario) {
	        usuarios.add(usuario);
	    }

	    @Override
	    public void remover(Usuario usuario) {
	        usuarios.remove(usuario);
	    }

		@Override
		public Usuario buscarPorNomeUsuario(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void inserir(Postagem postagem) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void eliminar(Postagem postagem) {
			// TODO Auto-generated method stub
			
		}
	}