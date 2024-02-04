package negocio;

import dados.Repositorio;
import dados.RepositorioUsuario;
import negocio.beans.Usuario;

public class ControladoraDeUsuario {
	    private Repositorio<Usuario> repositorioUsuario;

	    public ControladoraDeUsuario(Repositorio<Usuario> repositorioUsuario2) {
			// TODO Auto-generated constructor stub
		}

		public void ControladoraUsuario(Repositorio<Usuario> repositorioUsuario) {
	        this.repositorioUsuario = repositorioUsuario;
	    }

	    // Metodos CRUD p/ Usuarios
	    public void criarUsuario(String nome, String username, String senha, int idade) {
	        Usuario novoUsuario = new Usuario(nome, username, senha, idade);
	        repositorioUsuario.adicionar(novoUsuario);
	        System.out.println("Usuario criado com sucesso!");
	    }

	    public void editarUsuario(Usuario usuario, String novoNome, String novoNomeUsuario, String novaSenha, int novaIdade) {
	    	if (repositorioUsuario.listarTodos().contains(usuario)) {
	    		usuario.setNome(novoNome);
	    		usuario.setNomeUsuario(novoNomeUsuario);
	    		usuario.setSenha(novaSenha);
	    		usuario.setIdade(novaIdade);
	            System.out.println("Usuario editado com sucesso.");
	        } else {
	            System.out.println("O usuario nao existe.");
	        }
	    }

	    public void excluirUsuario(Usuario usuario) {
	        if (repositorioUsuario.listarTodos().contains(usuario)) {
	            repositorioUsuario.remover(usuario);
	            System.out.println("Usuario excluido com sucesso!");
	        } else {
	            System.out.println("O usuario nao existe.");
	        }
	    }

	    // Metodos extra p/ usuarios
	    public void seguirUsuario(Usuario seguidor, Usuario usuarioASeguir) {
	        if (!seguidor.equals(usuarioASeguir) && !seguidor.getSeguindo().contains(usuarioASeguir)) {
	            seguidor.seguir(usuarioASeguir);
	            System.out.println(seguidor.getNome() + " comecou a seguir " + usuarioASeguir.getNome());
	        } else {
	            System.out.println("Nao foi possivel seguir o usuario.");
	        }
	    }

	    public void desseguirUsuario(Usuario usuarioAlice, Usuario usuarioBob) {
	        if (usuarioAlice.getSeguindo().contains(usuarioBob)) {
	            usuarioAlice.desseguir(usuarioBob);
	            System.out.println(usuarioAlice.getNome() + " deixou de seguir " + usuarioBob.getNome());
	        } else {
	            System.out.println("Nao foi possivel deixar de seguir o usuario.");
	        }
	    }
	}
