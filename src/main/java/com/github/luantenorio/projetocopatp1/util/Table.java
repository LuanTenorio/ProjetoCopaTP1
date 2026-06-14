package com.github.luantenorio.projetocopatp1.util;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public abstract class Table<T> {

    protected List<T> objects = new ArrayList<>();
    private List<T> filteredObjects = new ArrayList<>();
    private int paginationSize;
    private int totPages;
    private int curPage = 1;
    private final int numColumns;

    public VBox rowsContainer;
    public Label infoPagination;

    protected Table(int numColumns){
        this.numColumns = numColumns;
        paginationSize = 10;
    }

    protected Table(int numColumns, int paginationSize){
        this.numColumns = numColumns;
        this.paginationSize = paginationSize;
    }

    protected void renderTable() {
        this.rowsContainer.getChildren().clear();
        this.filterObjects();

        this.totPages = Math.max(1, (int) Math.ceil((double) filteredObjects.size() / this.paginationSize));

        if(this.curPage > this.totPages)
            this.curPage = this.totPages;

        int initIndex = (this.curPage - 1) * this.paginationSize;
        int endIndex = Math.min(initIndex + this.paginationSize, this.filteredObjects.size());

        List<T> visibleObjects = this.filteredObjects.subList(initIndex, endIndex);

        for (T e : visibleObjects) {
            GridPane linha = createRowTable(e);
            this.rowsContainer.getChildren().add(linha);
        }

        this.infoPagination.setText(this.curPage + " de " + this.totPages);
    }

    protected GridPane createRowTable(T object) {
        GridPane grid = new GridPane();
        grid.getStyleClass().add("table-row");

        grid.setOnMouseClicked(event -> this.onRowClicked(object));

        Label[] labels = this.getLabels(object);

        for(int i = 0; i < this.numColumns; i++){
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0 / this.numColumns);
            grid.getColumnConstraints().add(col);
        }

        for(int i = 0; i < labels.length && i < this.numColumns; i++){
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

    private void filterObjects(){
        if(this.isEmptyFilters()){
            this.filteredObjects = this.objects;
            return;
        }

        this.filteredObjects = this.objects.stream().filter(this::filterCondition).toList(); // this::filterCondition = object -> this.filterCondition(object)
    }

    // Condição que dita se o objeto vai aparecer ou não na tabela
    protected abstract boolean filterCondition(T object);

    // Condição que dita se os filtros estão vazios
    protected abstract boolean isEmptyFilters();

    // Pega todos os filtros
    protected abstract Label[] getLabels(T object);

    protected abstract void onRowClicked(T object);
}
