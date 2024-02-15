package negocio.beans;

public class ContextoTemporario {
    private static ContextoTemporario instancia;
    private String nome;
    private String username;
    private String email;
    private Postagem postagemAtual;

    private ContextoTemporario() {}

    public static ContextoTemporario getInstance() {
        if (instancia == null) {
            instancia = new ContextoTemporario();
        }
        return instancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public Postagem getPostagemAtual() {
        return postagemAtual;
    }

    public void setPostagemAtual(Postagem postagemAtual) {
        this.postagemAtual = postagemAtual;
    }
}
