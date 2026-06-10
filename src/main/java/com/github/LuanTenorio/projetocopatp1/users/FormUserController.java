package com.github.luantenorio.projetocopatp1.users;

import com.github.luantenorio.projetocopatp1.util.DataController;
import com.github.luantenorio.projetocopatp1.util.PasswordHasher;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FormUserController implements DataController<UserEntity> {

    @FXML private TextField txtName;
    @FXML private TextField txtEmail;
    @FXML private TextField txtCountry;
    @FXML private PasswordField txtPassword;
    @FXML private ComboBox<String> txtRole;
    @FXML private ComboBox<String> txtStatus;
    @FXML private Button buttonOperate;
    @FXML private Button buttonDelete;

    private final UserService userService = new UserService();
    private UserEntity userSelected;
    private boolean isEdit = false;

    @FXML
    public void initialize() {
        setVisibleDeleteButton(false);
    }

    @Override
    public void getData(UserEntity user) {
        this.userSelected = user;
        this.isEdit = true;
        this.buttonOperate.setText("Atualizar");
        this.setVisibleDeleteButton(true);
        fillFields();
    }

    private UserEntity getCurrentEntity() {
        String name = txtName.getText();
        String email = txtEmail.getText();
        String country = txtCountry.getText();
        String role = txtRole.getValue();
        String statusStr = txtStatus.getValue();
        String password = txtPassword.getText();

        // Regra para a Senha na Edição:
        // Se o campo estiver vazio e for uma edição, recuperamos a senha criptografada antiga
        if (this.isEdit && (password == null || password.isEmpty())) {
            password = this.userSelected.getPassword();
        }

        // Mapeia o status selecionado para o seu Enum UserStatus
        UserStatus status = (statusStr != null && statusStr.equalsIgnoreCase("Ativo"))
                ? UserStatus.ACTIVE
                : UserStatus.INACTIVE;

        UserEntity user;

        // Instancia o tipo exato de objeto baseado na função selecionada no ComboBox
        switch (role) {
            case "Administrador":
                user = new AdminEntity(name, email, country, password, status);
                break;
            case "Organizador":
            case "Operador": // Mapeia ambas as possibilidades do FXML
                user = new OrganizerEntity(name, email, country, password, status);
                break;
            case "Árbitro":
                // Passa o parâmetro extra do árbitro se a sua classe RefereeUserEntity exigir
                user = new RefereeUserEntity(name, email, country, password, status, "0");
                break;
            default:
                user = new AdminEntity(name, email, country, password, status);
                break;
        }

        // SE FOR EDIÇÃO: Preserva o ID original do usuário selecionado.
        // Isso é vital para que o método userDAO.update() encontre o registro certo no arquivo .bin
        if (this.isEdit) {
            user.setId(this.userSelected.getId());
        }

        return user;
    }


    private void fillFields() {
        txtName.setText(userSelected.getName()); // ou getNome(), dependendo da sua entidade
        txtEmail.setText(userSelected.getEmail());
        txtCountry.setText(userSelected.getCountry());

        txtRole.setValue(userService.translateLevel(userSelected));

        txtStatus.setValue(userSelected.getStatus().toString());
        txtPassword.setPromptText("Deixe em branco para manter a atual");
    }

    @FXML
    public void operate() {
        if (!isInputValid()) return;

        if (this.isEdit) {
            this.update();
        } else {
            this.register();
        }

        Router.navigateTo(ViewName.USER);
    }

    @FXML
    public void delete() {
        userService.deleteUser(userSelected.getId());
        Router.navigateTo(ViewName.USER);
    }

    private void setVisibleDeleteButton(boolean value) {
        this.buttonDelete.setVisible(value);
        this.buttonDelete.setManaged(value);
    }

    private boolean isInputValid() {

        return true;
    }

    private void register() {
        UserEntity novoUsuario = getCurrentEntity();

        userService.register(novoUsuario);
    }

    private void update() {
        UserEntity usuarioAtualizado = getCurrentEntity();

        String senhaDigitada = txtPassword.getText();
        if (senhaDigitada != null && !senhaDigitada.isEmpty()) {
            usuarioAtualizado.setPassword(PasswordHasher.hash(senhaDigitada));
        }

        userService.updateUser(usuarioAtualizado);
    }

}