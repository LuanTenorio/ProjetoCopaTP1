package com.github.luantenorio.projetocopatp1.referee;

import com.github.luantenorio.projetocopatp1.match.MatchChipDTO;
import com.github.luantenorio.projetocopatp1.match.MatchDAO;
import com.github.luantenorio.projetocopatp1.match.MatchEntity;
import com.github.luantenorio.projetocopatp1.refereeMatch.RefereeMatchEntity;
import com.github.luantenorio.projetocopatp1.refereeMatch.RefereeMatchService;
import com.github.luantenorio.projetocopatp1.users.AccessLevel;
import com.github.luantenorio.projetocopatp1.util.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class FormRefereeController implements DataController<RefereeEntity> {

    private boolean isEdit = false;
    private final RefereeService refereeService = new RefereeService();
    private final MatchDAO matchDAO = new MatchDAO(); // mudar para matchService futuramente
    private final RefereeMatchService refereeMatchService = new RefereeMatchService();

    private RefereeEntity refereeSelected;

    private final List<MatchChipDTO> availableMatches = new ArrayList<>();
    private List<String> selectedMatchIds = new ArrayList<>();

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
    public FlowPane chipContainer;
    @FXML
    public ComboBox<MatchChipDTO> cbMatches;
    @FXML
    public VBox formMatch;


    @FXML
    public void initialize(){
        this.formatCapacityField();
        this.setVisibleDeleteButton(false);
        this.setVisibleFormMatch(false);
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
        List<RefereeMatchEntity> list = selectedMatchIds.stream().map(id -> new RefereeMatchEntity(this.refereeSelected.getId(), id)).toList();
        this.refereeMatchService.assignRefereeToMatch(list, this.refereeSelected.getId());
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

        //Implementar melhor a lógica de hieraquia
        if(Global.getAccessLevel().equals(AccessLevel.ADMIN)){
            this.setVisibleFormMatch(true);
            ZonedDateTime now = ZonedDateTime.now();
            this.setAvailableMatches(now);
            this.drawInitialMatches(now);
            this.setupMatchSelector();
        }
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

    private void setVisibleFormMatch(boolean value) {
        this.formMatch.setVisible(value);
        this.formMatch.setManaged(value);
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

    private void setupMatchSelector() {
        FilteredList<MatchChipDTO> filteredMatches = new FilteredList<>(
                FXCollections.observableArrayList(availableMatches), p -> true
        );

        cbMatches.setItems(filteredMatches);
        TextField editor = cbMatches.getEditor();

        this.setConverter();

        editor.textProperty().addListener((observable, oldValue, newValue) -> {
            MatchChipDTO selectedItem = cbMatches.getSelectionModel().getSelectedItem();

            if (selectedItem != null && selectedItem.name().equals(newValue)) {
                return;
            }

            int caretPosition = editor.getCaretPosition();

            filteredMatches.setPredicate(match -> {
                if (selectedMatchIds.contains(match.id())) {
                    return false;
                }

                if (newValue == null || newValue.isEmpty())
                    return true;

                return match.name().toLowerCase().contains(newValue.toLowerCase().trim());
            });

            editor.positionCaret(caretPosition);

            if (!cbMatches.isShowing() && cbMatches.isFocused() && !filteredMatches.isEmpty()) {
                cbMatches.show();
            }
        });

        cbMatches.setOnAction(event -> {
            MatchChipDTO selectedDto = cbMatches.getSelectionModel().getSelectedItem();

            if (selectedDto != null && !selectedMatchIds.contains(selectedDto.id())) {
                this.addChip(selectedDto);

                Platform.runLater(() -> {
                    cbMatches.getSelectionModel().clearSelection();
                    cbMatches.getEditor().clear();
                });
            }
        });
    }

    private void setConverter(){
        cbMatches.setConverter(new StringConverter<>() {
            @Override
            public String toString(MatchChipDTO object) {
                return object == null ? "" : object.name();
            }

            @Override
            public MatchChipDTO fromString(String string) {
                return cbMatches.getItems().stream()
                        .filter(m -> m.name().equals(string))
                        .findFirst()
                        .orElse(null);
            }
        });
    }

    private void addChip(MatchChipDTO matchDto) {
        selectedMatchIds.add(matchDto.id());

        HBox chip = new HBox();
        chip.getStyleClass().add("chip");

        Label label = new Label(matchDto.name());
        label.getStyleClass().add("chip-label");

        Button closeButton = new Button("X");
        closeButton.getStyleClass().add("chip-close");

        closeButton.setOnAction(e -> {
            chipContainer.getChildren().remove(chip);
            selectedMatchIds.remove(matchDto.id());

            String currentText = cbMatches.getEditor().getText();
            cbMatches.getEditor().setText(currentText + " ");
            cbMatches.getEditor().setText(currentText);
        });

        chip.getChildren().addAll(label, closeButton);
        chipContainer.getChildren().add(chip);
    }

    private void setAvailableMatches(ZonedDateTime time){
        List<MatchEntity> matches = this.matchDAO.findAll();

        for(MatchEntity m : matches)
            if(m.getDate().isAfter(time) && this.refereeService.checksIfRefereeCanRefereeMatch(this.refereeSelected, m))
                this.availableMatches.add(new MatchChipDTO(m.getId(), m.getName()));
    }

    private void drawInitialMatches(ZonedDateTime time){
        this.refereeMatchService.getMatchFromReferee(this.refereeSelected.getId()).stream()
                .filter(m -> m.getDate().isAfter(time))
                .map(m -> new MatchChipDTO(m.getId(), m.getName()))
                .forEach(this::addChip);
    }

}