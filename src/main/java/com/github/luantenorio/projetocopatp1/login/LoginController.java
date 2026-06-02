package com.github.luantenorio.projetocopatp1.login;

import com.github.luantenorio.projetocopatp1.users.UserEntity;
import com.github.luantenorio.projetocopatp1.users.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private final UserService userService = new UserService();

    @FXML
    private TextField campoEmail;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Button loginBtn;

    @FXML
    private ImageView topoImagem;

    @FXML
    private VBox rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        topoImagem.fitWidthProperty().bind(rootPane.widthProperty());
    }

    @FXML
    protected void login() {

        String emailDigitado = campoEmail.getText();
        String senhaDigitada = campoSenha.getText();

        if(emailDigitado.isEmpty() || senhaDigitada.isEmpty()){
            System.out.println("Por favor, preencha todos os campos");
            return;
        }

        UserEntity usuarioLogado = userService.auth(emailDigitado, senhaDigitada);

        if (usuarioLogado != null) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + usuarioLogado.getNome());
            System.out.println("Tipo de usuário: " + usuarioLogado.getClass().getSimpleName());

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/github/luantenorio/projetocopatp1/view/panel.fxml"));
                Parent newRoot = loader.load();
                Stage curRoot = (Stage) loginBtn.getScene().getWindow();
                curRoot.getScene().setRoot(newRoot);
                curRoot.centerOnScreen();
            } catch (IOException e) {
                System.err.println("Erro ao carregar o painel: " + e.getMessage());
                e.printStackTrace();
            }

        }
        else {
            System.out.println("Falha no login: Email ou senha incorretos.");
        }
    }
}
