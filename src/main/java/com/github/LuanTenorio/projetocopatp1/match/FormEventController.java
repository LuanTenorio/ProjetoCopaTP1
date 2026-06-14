package com.github.luantenorio.projetocopatp1.match;

import com.github.luantenorio.projetocopatp1.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class FormEventController implements DataController<Tuple<MatchEntity, MatchEvent>> {
    MatchEntity selectedMatch;
    MatchEvent selectedEvent;

    @FXML
    private ExtendedNumericalTextField inputMinute;
    @FXML
    private ComboBox<String> inputType;
    @FXML
    private TextField inputDescription;
    @FXML
    private Button operateBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button back;

    private boolean isEdit;

    @FXML
    public void initialize(){
        ObservableList<String> eventTypes = FXCollections.observableArrayList();
        for(EventType type : EventType.values()){
            eventTypes.add(type.toString());
        }
        inputType.setItems(eventTypes);
        deleteBtn.setVisible(false);

        isEdit = false;
    }

    public void warn(String erro){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Campos inválidos");
        alert.setContentText(erro);
        alert.showAndWait();
    }

    public void operate(){
        if (!checkInputs()) return;

        if (isEdit) selectedMatch.removeEvent(selectedEvent);
        selectedMatch.addEvent(
                this.inputMinute.getText(),
                EventType.findByName(this.inputType.getSelectionModel().getSelectedItem()),
                this.inputDescription.getText()
        );

        back();
    }

    @FXML
    public void back(){
        Router.navigateTo(ViewName.UPDATE_RESULT, selectedMatch);
    }

    @FXML
    public void delete(){
        selectedMatch.removeEvent(selectedEvent);
        back();
    }

    @Override
    public void getData(Tuple<MatchEntity, MatchEvent> data) {
        this.selectedMatch = data.first();
        this.selectedEvent = data.second();
        if (selectedEvent == null) return; // nao eh edicao!
        this.isEdit = true;
        this.setEvent();
        this.deleteBtn.setVisible(true);
    }

    private boolean checkInputs(){
        if (inputType.getSelectionModel().getSelectedItem() == null) {
            warn("Nenhum tipo selecionado!");
            return false;
        }
        if (inputMinute.getText().isBlank()) {
            warn("Minuto faltando!");
            return false;
        }

        return true;
    }

    private void setEvent() {
        inputType.getSelectionModel().select(selectedEvent.type().toString());
        inputMinute.setText(selectedEvent.minute());
        inputDescription.setText(selectedEvent.description());
    }
}
