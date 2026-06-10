package com.github.luantenorio.projetocopatp1.users;

import com.github.luantenorio.projetocopatp1.util.DataController;
import com.github.luantenorio.projetocopatp1.util.PasswordHasher;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class FormUserController implements DataController<UserEntity> {

    @FXML private TextField txtName;
    @FXML private TextField txtEmail;
    @FXML private TextField txtCountry;
    @FXML private PasswordField txtPassword;
    @FXML private ComboBox<String> txtRole;
    @FXML private ComboBox<String> txtStatus;
    @FXML private TextField txtExperience;
    @FXML private VBox vboxExperience;
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

    @FXML
    public void onRoleChanged() {
        boolean isReferee = "Árbitro".equals(txtRole.getValue());
        vboxExperience.setVisible(isReferee);
        vboxExperience.setManaged(isReferee);
    }

    private UserEntity getCurrentEntity() {
        String name = txtName.getText();
        String email = txtEmail.getText();
        String country = txtCountry.getText();
        String role = txtRole.getValue();
        String statusStr = txtStatus.getValue();
        String password = txtPassword.getText();
        String experience = txtExperience.getText();

        // regra para a senha
        // se o campo estiver vazio e for uma edição, recuperamos a senha criptografada antiga
        if (this.isEdit && (password == null || password.isEmpty())) {
            password = this.userSelected.getPassword();
        }

        UserStatus status = (statusStr != null && statusStr.equalsIgnoreCase("Ativo"))
                ? UserStatus.ACTIVE
                : UserStatus.INACTIVE;

        UserEntity user;

        // instancia o tipo exato de objeto
        switch (role) {
            case "Administrador":
                user = new AdminEntity(name, email, country, password, status);
                break;
            case "Organizador":
                user = new OrganizerEntity(name, email, country, password, status);
                break;
            case "Árbitro":
                user = new RefereeUserEntity(name, email, country, password, status, "0");
                break;
            default:
                user = new AdminEntity(name, email, country, password, status);
                break;
        }

        // mantem o ID original do usuário selecionado se for edição.
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

        // se for árbitro, preenche e exibe o campo de experiência
        if (userSelected instanceof RefereeUserEntity) {
            String exp = ((RefereeUserEntity) userSelected).getExperience();
            txtExperience.setText(exp != null ? exp : "");
            vboxExperience.setVisible(true);
            vboxExperience.setManaged(true);
        }
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