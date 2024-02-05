package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class telaCadastroController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void trocarParaTelaDeLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/application/telaLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
