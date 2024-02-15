package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import negocio.ControladorDeUsuario;
import negocio.beans.ContextoTemporario;
import negocio.beans.Usuario;

public class TelaPerfilController {
    private ControladorDeUsuario controladorDeUsuario = ControladorDeUsuario.getInstance();

    @FXML
    private Label labelNome;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelEmail;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {
        String aaa = ContextoTemporario.getInstance().getNome();
        System.out.println(aaa);
        
        // Recuperar o nome de usuário do ContextoTemporario
        String nomeUsuario = ContextoTemporario.getInstance().getNome();
        System.out.println("O NOME DE USUARIO NO CONTEXTO TEMPORARIO É: " + nomeUsuario);
        
        // Buscar o usuário pelo nome de usuário
        Usuario usuario = controladorDeUsuario.buscarUsuarioPorNome(nomeUsuario);
        
        if (usuario != null) {
            labelUsername.setText(usuario.getUsername());
            labelNome.setText(usuario.getNome());
            labelEmail.setText(usuario.getEmail());

        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void trocarParaTelaDeCriarPostagem(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/application/telaCriarPostagem.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void trocarParaTelaFeed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/application/telaFeed.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
