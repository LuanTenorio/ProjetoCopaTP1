package com.github.luantenorio.projetocopatp1.util;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public abstract class Table<T> {

    protected List<T> objetcs = new ArrayList<>();
    private List<T> objectsFiltered = new ArrayList<>();
    private List<T> objectsVisibles = new ArrayList<>();
    private int SIZE_PAGINATION = 10;
    private int totPages;
    private int curPage = 1;
    private int numCollumns;

    public VBox rowsContainer;
    public Label infoPagination;

    protected Table(int numCollumns){
        this.numCollumns = numCollumns;
    }

    protected void renderTable() {
        this.rowsContainer.getChildren().clear();
        this.filterObjects();

        this.totPages = Math.max(1, (int) Math.ceil((double) objectsFiltered.size() / this.SIZE_PAGINATION));

        if(this.curPage > this.totPages)
            this.curPage = this.totPages;

        int initIndex = (this.curPage - 1) * this.SIZE_PAGINATION;
        int endIndex = Math.min(initIndex + this.SIZE_PAGINATION, this.objectsFiltered.size());

        this.objectsVisibles = this.objectsFiltered.subList(initIndex, endIndex);

        for (T e : this.objectsVisibles) {
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

        for(int i = 0; i < this.numCollumns; i++){
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0 / this.numCollumns);
            grid.getColumnConstraints().add(col);
        }

        for(int i = 0; i < labels.length && i < this.numCollumns; i++){
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
            this.objectsFiltered = this.objetcs;
            return;
        }

        this.objectsFiltered = this.objetcs.stream().filter(this::filterCondition).toList(); // this::filterCondition = object -> this.filterCondition(object)
    }

    // Condição que dita se o objeto vai aparecer ou não na tabela
    protected abstract boolean filterCondition(T object);

    // Condição que dita se os filtros estão vazios
    protected abstract boolean isEmptyFilters();

    // Pega todos os filtros
    protected abstract Label[] getLabels(T object);

    protected abstract void onRowClicked(T object);
}
