package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.ControladorDePostagem;

public class TelaCriarPostagemController {
    ControladorDePostagem controlador = ControladorDePostagem.getInstance();

    @FXML
    private TextField txtTituloPostagem;
    @FXML
    private TextArea txtConteudoPostagem;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void criarPostagem() throws IOException {
        String titulo = txtTituloPostagem.getText();
        String conteudo = txtConteudoPostagem.getText();

        controlador.postar(titulo, conteudo);
        System.out.println("Postagem feita!");
    }

    public void trocarParaTelaFeed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/application/telaFeed.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}