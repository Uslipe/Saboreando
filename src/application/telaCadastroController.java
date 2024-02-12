package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import negocio.ControladorDeUsuario;

public class telaCadastroController {
 private ControladorDeUsuario controladorDeUsuario = ControladorDeUsuario.getInstance();

    @FXML private TextField txtNomeCompleto;
    @FXML private TextField txtUsername;
    @FXML private TextField txtEmail;
    @FXML private PasswordField txtSenha;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void Cadastrar() throws IOException {
        // Obtenha dados do formulário de cadastro
        String nome = txtNomeCompleto.getText();
        String email = txtEmail.getText();
        String nomeUsuario = txtUsername.getText();
        String senha = txtSenha.getText();

        // Crie um novo usuário e adicione à lista
        controladorDeUsuario.criarUsuario(nome, email, nomeUsuario, senha);

        carregarProximaTela("/application/telaLogin.fxml");

        System.out.println("Cadastro bem-sucedido!");
    }

    public void trocarParaTelaDeLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/application/telaLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void carregarProximaTela(String caminho) throws IOException {
        // Carregar a FXML da próxima tela
        FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
        Parent novaTela = loader.load();

        // Configurar o controlador, se necessário (use getController() para acessar métodos no controlador)
        // Exemplo:
        // SuaClasseController controller = loader.getController();
        // controller.configurarAlgumaCoisa();

        // Configurar a Scene com a nova tela
        Scene novaScene = new Scene(novaTela);

        // Configurar o Stage
        Stage novoStage = new Stage();
        novoStage.setTitle("Tela");
        novoStage.setScene(novaScene);

        // Fechar a tela de login
        Stage stageAtual = (Stage) txtUsername.getScene().getWindow();
        stageAtual.close();

        // Exibir a nova tela
        novoStage.show();
    }
}
