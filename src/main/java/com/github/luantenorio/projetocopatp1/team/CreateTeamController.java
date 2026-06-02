package com.github.luantenorio.projetocopatp1.team;

import com.github.luantenorio.projetocopatp1.player.PlayerEntity;
import com.github.luantenorio.projetocopatp1.player.PlayerService;
import com.github.luantenorio.projetocopatp1.player.PlayerStatus;
import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;
import com.github.luantenorio.projetocopatp1.util.DataController;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class CreateTeamController implements DataController<TeamEntity> {

    private final TeamService teamService = new TeamService();

    private final PlayerService playerService = new PlayerService();

    private ObservableList<PlayerEntity> availablePlayers;

    private ObservableList<PlayerEntity> selectedPlayers;

    private TeamEntity selectedTeam;

    private boolean isEdit = false;

    @FXML
    private TextField txtName;

    @FXML
    private ComboBox<String> groupComboBox;

    @FXML
    private TextField txtCoach;

    @FXML
    private ListView<PlayerEntity> availablePlayersListView;

    @FXML
    private ListView<PlayerEntity> selectedPlayersListView;

    @FXML
    private Label selectedPlayersCountLabel;

    @FXML
    private Button buttonOperate;

    @FXML
    private Button buttonDelete;

    public void initialize() {
        List<PlayerEntity> players = playerService.findPlayersWithoutTeam();

        this.availablePlayers = FXCollections.observableArrayList(players);
        this.selectedPlayers = FXCollections.observableArrayList();

        this.availablePlayersListView.setItems(this.availablePlayers);
        this.selectedPlayersListView.setItems(this.selectedPlayers);

        this.selectedPlayersCountLabel.textProperty().bind(Bindings.size(this.selectedPlayers).asString("Selecionados: %d"));

        this.availablePlayersListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.selectedPlayersListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        this.setVisibleDeleteButton(false);
    }

    public void addSelectedPlayers() {
        List<PlayerEntity> selectedPlayers = new ArrayList<>(this.availablePlayersListView.getSelectionModel().getSelectedItems());

        if (!selectedPlayers.isEmpty()) {
            this.availablePlayers.removeAll(selectedPlayers);
            this.selectedPlayers.addAll(selectedPlayers);
            this.availablePlayersListView.getSelectionModel().clearSelection();
        }
    }

    public void removeSelectedPlayers() {
        List<PlayerEntity> selectedPlayers = new ArrayList<>(this.selectedPlayersListView.getSelectionModel().getSelectedItems());

        if (!selectedPlayers.isEmpty()) {
            this.selectedPlayers.removeAll(selectedPlayers);
            this.availablePlayers.addAll(selectedPlayers);
            this.selectedPlayersListView.getSelectionModel().clearSelection();
        }
    }

    public void operate() {
        if (!isInputValid()) {
            return;
        }
        try {
            if (isEdit) {
                TeamEntity updatedTeam = updateTeam();
                updateTeamIdsForSelectedPlayers(updatedTeam.getId()); //todo: simplificar com currentEntity
            }
            else {
                TeamEntity createdTeam = registerTeam();
                updateTeamIdsForSelectedPlayers(createdTeam.getId());
            }
                backToPreviousView();
        } catch (TeamException e) {
            showInvalidMessage(e.getMessage());
        }
    }

    private TeamEntity registerTeam() {
        return teamService.createTeam(getCurrentEntity());
    }

    private TeamEntity updateTeam() { return teamService.updateTeam(getCurrentEntity()); }

    public void delete(){
        this.teamService.deleteTeam(this.selectedTeam.getId());
        this.backToPreviousView();
    }

    private void updateTeamIdsForSelectedPlayers(String teamId) {playerService.updateTeamIds(selectedPlayers, teamId);}
    
    private void backToPreviousView() {
        Router.navigateTo(ViewName.TEAM);
    }

    private boolean isInputValid() {
        String error = "";

        if (txtName.getText() == null || txtName.getText().trim().isEmpty())
            error += "O campo 'Nome' é obrigatório.\n";

        if (groupComboBox.getValue() == null || groupComboBox.getValue().trim().isEmpty())
            error += "O campo 'Grupo' é obrigatório.\n";

        if (txtCoach.getText() == null || txtCoach.getText().trim().isEmpty())
            error += "O campo 'Técnico' é obrigatório.\n";

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

    private TeamEntity getCurrentEntity(){
        String name = txtName.getText();
        String group = groupComboBox.getValue();
        String coach = txtCoach.getText();

        if (isEdit) {
            return new TeamEntity(selectedTeam.getId(), name, group, coach, this.selectedPlayers);
        }

        return new TeamEntity(name, group, coach, this.selectedPlayers);
    }

    @Override
    public void getData(TeamEntity data) {
        this.selectedTeam = data;
        this.isEdit = true;
        this.buttonOperate.setText("Atualizar");
        this.setVisibleDeleteButton(true);
        setTeam();
    }

    private void setVisibleDeleteButton(boolean value) {
        this.buttonDelete.setVisible(value);
        this.buttonDelete.setManaged(value);
    }

    public void setTeam() {
        txtName.setText(selectedTeam.getName());
        groupComboBox.setValue(selectedTeam.getGroup());
        txtCoach.setText(selectedTeam.getCoach());

        List<PlayerEntity> selectedTeamLineup = playerService.findTeamLineup(selectedTeam.getId());
        this.selectedPlayers.addAll(selectedTeamLineup);
    }
}
