package dados;

import java.util.List;

import negocio.beans.Postagem;
import negocio.beans.Usuario;

public interface Repositorio<T> {
	 List<T> listarTodos();
	    void adicionar(T item);
	    void remover(T item);
	    
		Usuario buscarPorNomeUsuario(String string);
		void inserir(Postagem postagem);
		void eliminar(Postagem postagem);
		
}