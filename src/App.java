import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class App extends Application{

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/application/telaLogin.fxml"));
        primaryStage.setTitle("Primeira Tela");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
