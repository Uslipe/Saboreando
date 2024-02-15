package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import negocio.ControladorDePostagem;

public class TelaFeedController {
    ControladorDePostagem controlador = ControladorDePostagem.getInstance();

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void trocarParaTelaDeCriarPostagem(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/application/telaCriarPostagem.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void trocarParaTelaPerfil(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/application/telaPerfil.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}