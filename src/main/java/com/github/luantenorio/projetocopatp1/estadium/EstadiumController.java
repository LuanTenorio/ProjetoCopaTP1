package com.github.luantenorio.projetocopatp1.estadium;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class EstadiumController {

    private ArrayList<EstadiumEntity> estadiuns = new ArrayList<>();
    private EstadiumDAO estadiumDAO = new EstadiumDAO();
    private List<EstadiumEntity> entitiesVisibles = new ArrayList<>();
    private int SIZE_PAGINATION = 10;
    private int totPages;
    private int curPage = 1;

    @FXML
    private VBox rowsContainer;

    @FXML
    private Label infoPagination;

    @FXML
    public void initialize(){
        this.estadiuns = this.estadiumDAO.estadiumPagination();
        this.renderTable();
    }

    private void renderTable() {
        this.rowsContainer.getChildren().clear();

        this.totPages = (int) Math.ceil((double) estadiuns.size() / this.SIZE_PAGINATION);
        int initIndex = (this.curPage - 1) * this.SIZE_PAGINATION;
        int endIndex = Math.min(initIndex + this.SIZE_PAGINATION, this.estadiuns.size());

        this.entitiesVisibles = this.estadiuns.subList(initIndex, endIndex);

        for (EstadiumEntity e : this.entitiesVisibles) {
            GridPane linha = createRowTable(e);
            this.rowsContainer.getChildren().add(linha);
        }

        this.infoPagination.setText(this.curPage + " de " + this.totPages);
    }

    private GridPane createRowTable(EstadiumEntity estadium) {
        GridPane grid = new GridPane();
        grid.getStyleClass().add("table-row");

        Label[] labels = {new Label(estadium.getName()), new Label(estadium.getLocation()), new Label(String.format("%d pessoas", estadium.getCapacity()))};
        ColumnConstraints[] cols = {new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints()};

        for(ColumnConstraints col : cols){
            col.setPercentWidth(33.33);
            grid.getColumnConstraints().add(col);
        }

        for(int i = 0; i < 3; i++){
            labels[i].getStyleClass().add("text-row");
            labels[i].setMaxWidth(Double.MAX_VALUE);
            grid.add(labels[i], i, 0);
        }

        return grid;
    }

    public void previousPage(){
        if(this.curPage == 1) return;

        this.curPage--;
        this.renderTable();
    }

    public void nextPage(){
        if(this.curPage == this.totPages) return;

        this.curPage++;
        this.renderTable();
    }

}
