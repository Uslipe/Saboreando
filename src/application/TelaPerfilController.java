package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class TelaPerfilController {
    @FXML private Label labelNome;
    @FXML private Label labelUsername;
    @FXML private Label labelEmail;

    private String nomeUsuarioPesquisa;

    public void setUsuarioLogado(String usuario) {
        nomeUsuarioPesquisa = usuario;
    }

}
