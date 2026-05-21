package com.github.luantenorio.projetocopatp1.team;

import com.github.luantenorio.projetocopatp1.player.PlayerEntity;
import com.github.luantenorio.projetocopatp1.player.PlayerStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.List;

public class CreateTeamController {

    private final ObservableList<PlayerEntity> availablePlayers = FXCollections.observableArrayList();
    private final ObservableList<PlayerEntity> selectedPlayers = FXCollections.observableArrayList();

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
    private Button addPlayerButton;

    @FXML
    private Button removePlayerButton;

    @FXML
    public void initialize() {
        this.availablePlayers.addAll(
                new PlayerEntity("Neymar", "ATA", 1, 0, PlayerStatus.ACTIVE),
                new PlayerEntity("Vini Jr", "ATA", 2, 0, PlayerStatus.ACTIVE),
                new PlayerEntity("Casemiro", "DEF", 3, 0, PlayerStatus.INJURED),
                new PlayerEntity("Lucas Paquetá", "ATA", 4, 0, PlayerStatus.INJURED),
                new PlayerEntity("Martinelli", "MEI", 5, 0, PlayerStatus.ACTIVE)
        );

        this.availablePlayersListView.setItems(this.availablePlayers);
        this.selectedPlayersListView.setItems(this.selectedPlayers);

        this.availablePlayersListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.selectedPlayersListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private void addSelectedPlayers() {
        List<PlayerEntity> selectedPlayers = new ArrayList<>(this.availablePlayersListView.getSelectionModel().getSelectedItems());

        if (!selectedPlayers.isEmpty()) {
            this.availablePlayers.removeAll(selectedPlayers);
            this.selectedPlayers.addAll(selectedPlayers);
            this.availablePlayersListView.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void removeSelectedPlayers() {
        List<PlayerEntity> selectedPlayers = new ArrayList<>(this.selectedPlayersListView.getSelectionModel().getSelectedItems());

        if (!selectedPlayers.isEmpty()) {
            this.selectedPlayers.removeAll(selectedPlayers);
            this.availablePlayers.addAll(selectedPlayers);
            this.selectedPlayersListView.getSelectionModel().clearSelection();
        }
    }

}
