package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class telaLoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void trocarParaTelaDeCadastro(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/application/telaCadastro.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}