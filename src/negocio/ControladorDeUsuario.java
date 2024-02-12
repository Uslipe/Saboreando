package negocio;

import java.util.List;

import dados.Repositorio;
import dados.RepositorioUsuario;
import negocio.beans.Usuario;

public class ControladorDeUsuario {
    private static ControladorDeUsuario instancia;
    private Repositorio<Usuario> repositorioUsuario;

    private ControladorDeUsuario() {
        // Inicialize o repositório de usuários
        this.repositorioUsuario = new RepositorioUsuario();
    }

    public static ControladorDeUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorDeUsuario();
        }
        return instancia;
    }

	// Metodos CRUD p/ Usuarios
	public void criarUsuario(String nome, String email, String username, String senha) {
		Usuario novoUsuario = new Usuario(nome, email, username, senha);
		repositorioUsuario.adicionar(novoUsuario);
		System.out.println("Usuario criado com sucesso!");
	}

	public boolean verificarUsuario(String nomeUsuario, String senha) {
	// Obtém todos os usuários do repositório
	List<Usuario> usuarios = repositorioUsuario.listarTodos();
	
	// Percorre a lista de usuários
	for (Usuario usuario : usuarios) {
		// Verifica se o nome de usuário e senha correspondem
		if (usuario.getUsername().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
			// Usuário encontrado, retorna true
			return true;
		}
	}
	
	// Usuário não encontrado, retorna false
	return false;
}

	public void editarUsuario(Usuario usuario, String novoNome, String novoNomeUsuario, String novaSenha) {
		if (repositorioUsuario.listarTodos().contains(usuario)) {
			usuario.setNome(novoNome);
			usuario.setNomeUsuario(novoNomeUsuario);
			usuario.setSenha(novaSenha);
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
