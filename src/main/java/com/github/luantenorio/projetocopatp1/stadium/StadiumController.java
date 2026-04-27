package com.github.luantenorio.projetocopatp1.stadium;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class StadiumController {

    private List<StadiumEntity> stadiums = new ArrayList<>();
    private List<StadiumEntity> stadiumsFiltered = new ArrayList<>();
    private StadiumDAO stadiumDAO = new StadiumDAO();
    private StadiumEntity activedFilters = new StadiumEntity("", "", 0);
    private List<StadiumEntity> entitiesVisibles = new ArrayList<>();
    private int SIZE_PAGINATION = 10;
    private int totPages;
    private int curPage = 1;

    @FXML
    private TextField filterName;

    @FXML
    private TextField filterLocation;

    @FXML
    private TextField filterCapacity;

    @FXML
    private VBox rowsContainer;

    @FXML
    private Label infoPagination;

    @FXML
    public void initialize(){
        this.stadiums = this.stadiumDAO.findAll();
        this.stadiumsFiltered = this.stadiums;
        this.renderTable();
        this.formatCapacityField();

    }

    private void renderTable() {
        this.rowsContainer.getChildren().clear();
        this.filterEstadiuns();

        this.totPages = Math.max(1, (int) Math.ceil((double) stadiumsFiltered.size() / this.SIZE_PAGINATION));

        if(this.curPage > this.totPages) //Evita bugs de filtragem
            this.curPage = this.totPages;

        int initIndex = (this.curPage - 1) * this.SIZE_PAGINATION;
        int endIndex = Math.min(initIndex + this.SIZE_PAGINATION, this.stadiumsFiltered.size());

        this.entitiesVisibles = this.stadiumsFiltered.subList(initIndex, endIndex);

        for (StadiumEntity e : this.entitiesVisibles) {
            GridPane linha = createRowTable(e);
            this.rowsContainer.getChildren().add(linha);
        }

        this.infoPagination.setText(this.curPage + " de " + this.totPages);
    }

    private GridPane createRowTable(StadiumEntity stadium) {
        GridPane grid = new GridPane();
        grid.getStyleClass().add("table-row");

        Label[] labels = {new Label(stadium.getName()), new Label(stadium.getLocation()), new Label(String.format("%d pessoas", stadium.getCapacity()))};
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

    public void filterName(){
        this.activedFilters.setName(this.filterName.getText().trim());
        this.renderTable();
    }

    public void filterLocation(){
        this.activedFilters.setLocation(this.filterLocation.getText().trim());
        this.renderTable();
    }

    public void filterCapacity(){
        this.activedFilters.setCapacity(this.activedFilters.getCapacity());
        this.renderTable();
    }

    private void filterEstadiuns(){
        String name = this.filterName.getText().trim().toLowerCase();
        String location = this.filterLocation.getText().trim().toLowerCase();
        String capacity = this.filterCapacity.getText().trim();

        if(name.isEmpty() && location.isEmpty() && capacity.isEmpty()){
            this.stadiumsFiltered = this.stadiums;
            return;
        }

        this.stadiumsFiltered = this.stadiums.stream().filter(stadium -> {
            if(!name.isEmpty() && !stadium.getName().trim().toLowerCase().startsWith(name))
                return false;

            if(!location.isEmpty() && !stadium.getLocation().trim().toLowerCase().startsWith(location))
                return false;

            if(!capacity.equals("0") && !String.format("%d", stadium.getCapacity()).startsWith(capacity))
                return false;

            return true;
        }).toList();
    }

    private void formatCapacityField(){
        TextFormatter<String> numberFormatter = new TextFormatter<>(change ->
            change.getText().matches("\\d*") ? change : null
        );

        this.filterCapacity.setTextFormatter(numberFormatter);
    }

}
