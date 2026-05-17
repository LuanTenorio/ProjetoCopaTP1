package com.github.luantenorio.projetocopatp1.referee;

import com.github.luantenorio.projetocopatp1.util.Countries;
import com.github.luantenorio.projetocopatp1.util.DataController;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FormRefereeController implements DataController<RefereeEntity> {

    private boolean isEdit = false;
    private final RefereeService refereeService = new RefereeService();
    private RefereeEntity refereeSelected;

    @FXML
    public TextField txtName;
    @FXML
    public ComboBox<String> txtNationality;
    @FXML
    public TextField txtPerformanceTime;
    @FXML
    public Button buttonOperate;
    @FXML
    public Button buttonDelete;
    @FXML
    public TextArea txtHistory;


    @FXML
    public void initialize(){
        this.formatCapacityField();
        this.setVisibleDeleteButton(false);
        this.filterCountries();
    }

    public void operate(){
        if(!this.isInputValid())
            return;

        if(this.isEdit)
            this.update();
        else
            this.register();

        this.backToStadiums();
    }

    private void register(){
        this.refereeService.createReferee(this.getCurrentEntity());
    }

    private void update(){
        this.refereeService.updateReferee(this.getCurrentEntity());
    }

    private RefereeEntity getCurrentEntity(){
        String name = txtName.getText();
        String nationality = txtNationality.getEditor().getText().trim();
        int performanceTime = Integer.parseInt(txtPerformanceTime.getText());
        String history = txtHistory.getText();

        if(this.isEdit)
            return new RefereeEntity(this.refereeSelected.getId(), name, nationality, performanceTime, history);

        return new RefereeEntity(name, nationality, performanceTime, history);
    }

    private void formatCapacityField(){
        TextFormatter<String> numberFormatter = new TextFormatter<>(change ->
                change.getText().matches("\\d*") ? change : null
        );

        this.txtPerformanceTime.setTextFormatter(numberFormatter);
    }

    private void backToStadiums(){
        Router.navigateTo(ViewName.REFEREE);
    }

    public void getData(RefereeEntity data) {
        this.refereeSelected = data;
        this.isEdit = true;
        this.setStadium();
        this.buttonOperate.setText("Atualizar");
        this.setVisibleDeleteButton(true);
    }

    private void setStadium(){
        txtName.setText(refereeSelected.getName().trim());
        txtNationality.setValue(refereeSelected.getNationality().trim());
        txtPerformanceTime.setText(String.valueOf(refereeSelected.getPerformanceTime()));
        txtHistory.setText(refereeSelected.getHistory().trim());
    }

    public void delete(){
        this.refereeService.deleteReferee(this.refereeSelected.getId());
        this.backToStadiums();
    }

    private void setVisibleDeleteButton(boolean value) {
        this.buttonDelete.setVisible(value);
        this.buttonDelete.setManaged(value);
    }

    private boolean isInputValid() {
        String error = "";

        if (txtName.getText() == null || txtName.getText().trim().isEmpty())
            error += "O campo 'Nome' é obrigatório.\n";

        String typedNationality = txtNationality.getEditor().getText();

        if (typedNationality == null || typedNationality.trim().isEmpty()) {
            error += "O campo 'Nacionalidade' é obrigatório.\n";
        } else if (!Countries.countries.contains(typedNationality.trim())) {
            error += String.format("%s não é uma nacionalidade válida\n", typedNationality);
        }

        if (txtPerformanceTime.getText() == null || txtPerformanceTime.getText().trim().isEmpty())
            error += "O campo 'Tempo de atuação' é obrigatório.\n";

        if (txtHistory.getText() == null || txtHistory.getText().trim().isEmpty())
            error += "O campo 'Histórico' é obrigatório.\n";

        if (error.isEmpty())
            return true;

        this.showInvalidMessage(error);
        return false;
    }

    private void showInvalidMessage(String error){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Campos inválidos");
        alert.setContentText(error);
        alert.showAndWait();
    }

    private void filterCountries() {
        FilteredList<String> filteredCountries = new FilteredList<>(
                FXCollections.observableArrayList(Countries.countries), p -> true
        );

        txtNationality.setItems(filteredCountries);
        TextField editor = txtNationality.getEditor();

        editor.textProperty().addListener((observable, oldValue, newValue) -> {
            String selectedItem = txtNationality.getSelectionModel().getSelectedItem();
            if (selectedItem != null && selectedItem.equals(newValue)) {
                return;
            }

            int caretPosition = editor.getCaretPosition();

            filteredCountries.setPredicate(country -> {
                if (newValue == null || newValue.isEmpty())
                    return true;

                String searchTerm = newValue.toLowerCase().trim();
                return country.toLowerCase().contains(searchTerm);
            });

            editor.positionCaret(caretPosition);

            if (!txtNationality.isShowing() && txtNationality.isFocused() && !filteredCountries.isEmpty()) {
                txtNationality.show();
            }
        });
    }

}