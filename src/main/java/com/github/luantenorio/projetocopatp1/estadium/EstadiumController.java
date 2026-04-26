package com.github.luantenorio.projetocopatp1.estadium;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class EstadiumController {

    private ArrayList<EstadiumEntity> estadiuns = new ArrayList<>();
    private List<EstadiumEntity> estadiunsFiltered = new ArrayList<>();
    private EstadiumDAO estadiumDAO = new EstadiumDAO();
    private EstadiumEntity activedFilters = new EstadiumEntity("", "", 0);
    private List<EstadiumEntity> entitiesVisibles = new ArrayList<>();
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
        this.estadiuns = this.estadiumDAO.estadiumPagination();
        this.estadiunsFiltered = this.estadiuns;
        this.renderTable();
        this.formatCapacityField();

    }

    private void renderTable() {
        this.rowsContainer.getChildren().clear();
        this.filterEstadiuns();

        this.totPages = Math.max(1, (int) Math.ceil((double) estadiunsFiltered.size() / this.SIZE_PAGINATION));

        if(this.curPage > this.totPages) //Evita bugs de filtragem
            this.curPage = this.totPages;

        int initIndex = (this.curPage - 1) * this.SIZE_PAGINATION;
        int endIndex = Math.min(initIndex + this.SIZE_PAGINATION, this.estadiunsFiltered.size());

        this.entitiesVisibles = this.estadiunsFiltered.subList(initIndex, endIndex);

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

        System.out.println(capacity);

        if(name.isEmpty() && location.isEmpty() && capacity.isEmpty()){
            this.estadiunsFiltered = this.estadiuns;
            return;
        }

        this.estadiunsFiltered = this.estadiuns.stream().filter(estadium -> {
            if(!name.isEmpty() && !estadium.getName().trim().toLowerCase().startsWith(name))
                return false;

            if(!location.isEmpty() && !estadium.getLocation().trim().toLowerCase().startsWith(location))
                return false;

            if(!capacity.equals("0") && !String.format("%d", estadium.getCapacity()).startsWith(capacity))
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
