package com.github.luantenorio.projetocopatp1.match;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MatchController {
    private MatchDAO matchDAO = new MatchDAO();
    private List<MatchEntity> filteredMatches;
    private final int SIZE_PAGINATION = 10;
    private int totPages;
    private int curPage = 1;

    @FXML
    private TextField filterTeam1;

    @FXML
    private TextField filterTeam2;

    @FXML
    private ComboBox<String> filterStage;

    @FXML
    private TextField filterDate;

    @FXML
    private VBox rowsContainer;

    @FXML
    private Label infoPagination;

    @FXML
    public void initialize(){
        ObservableList<String> stages = FXCollections.observableArrayList();
        for(MatchStage type : MatchStage.values()){
            stages.add(type.toString());
        }
        filterStage.setItems(stages);
    }

    public void previousPage(){
        if(this.curPage == 1) return;

        this.curPage--;
        this.renderTable();
    }

    public void nextPage(){
        if(this.curPage == this.totPages) return;

        this.curPage++;
        this.recreateTable();
    }

    private List<MatchEntity> filter() {
        return matchDAO.findAll().stream().filter(
                matchEntity -> {
                    if (!matchEntity.getTeam1().getName().contains(this.filterTeam1.getText().trim())) return false;
                    if (!matchEntity.getTeam2().getName().contains(this.filterTeam2.getText().trim())) return false;
                    String stage = matchEntity.getStage().toString();
                    if (!stage.contains(filterStage.getSelectionModel().getSelectedItem())) return false;
                    ZonedDateTime zonedData = matchEntity.getDate();
                    String data = String.format("%02d/%02d", zonedData.getDayOfMonth(), zonedData.getMonthValue());
                    return data.contains(this.filterDate.getText());
                }

        ).toList();
    }

    @FXML
    private void recreateTable() {
        this.rowsContainer.getChildren().clear();
        this.filteredMatches = this.filter();

        this.totPages = Math.max(1, (int) Math.ceil((double) this.filteredMatches.size() / this.SIZE_PAGINATION));


    }

    @FXML
    private void renderTable(){
        if(this.curPage > this.totPages) //Evita bugs de filtragem
            this.curPage = this.totPages;

        int initIndex = (this.curPage - 1) * this.SIZE_PAGINATION;
        int endIndex = Math.min(initIndex + this.SIZE_PAGINATION, filteredMatches.size());

        List<MatchEntity> tableMatches = filteredMatches.subList(initIndex, endIndex);

        for (MatchEntity e : tableMatches) {
            GridPane linha = createRowTable(e);
            this.rowsContainer.getChildren().add(linha);
        }

        this.infoPagination.setText(this.curPage + " de " + this.totPages);
    }

    private GridPane createRowTable(MatchEntity match) {
        GridPane grid = new GridPane();
        grid.getStyleClass().add("table-row");

        String date = String.format("%02d/%02d", match.getDate().getDayOfMonth(), match.getDate().getMonthValue());

        Label[] labels = {new Label(match.getTeam1().getName()), new Label(match.getTeam2().getName()), new Label(match.getStage().toString()),new Label(date)};
        ColumnConstraints[] cols = {new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints()};

        for(ColumnConstraints col : cols){
            col.setPercentWidth(25);
            grid.getColumnConstraints().add(col);
        }

        for(int i = 0; i < 4; i++){
            labels[i].getStyleClass().add("text-row");
            labels[i].setMaxWidth(Double.MAX_VALUE);
            grid.add(labels[i], i, 0);
        }

        return grid;
    }

    @FXML
    private void navigateToCreateMatch(){

    }
}
