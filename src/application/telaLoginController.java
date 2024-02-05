package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class telaLoginController {

    @FXML private TextField txtUsername;
    @FXML private PasswordField txtSenha;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login(ActionEvent event) throws IOException {
        verificarLogin();
    }

    private void verificarLogin() throws IOException {
        if (txtUsername.getText().toString().equals("teste") && txtSenha.getText().toString().equals("123")) {
            System.out.println("Login bem-sucedido. Redirecionando para a próxima tela.");
            carregarProximaTela("/application/telaFeed.fxml");
        } 
        else if (txtUsername.getText().isEmpty() || txtSenha.getText().isEmpty()) {
            System.out.println("Elemento vazio");
        } 
        else {
            System.out.println("Login errado");
        }
    }

    public void trocarParaTelaDeCadastro(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/application/telaCadastro.fxml"));
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