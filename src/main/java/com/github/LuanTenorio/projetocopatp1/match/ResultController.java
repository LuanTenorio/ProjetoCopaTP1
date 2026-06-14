package com.github.luantenorio.projetocopatp1.match;

import com.github.luantenorio.projetocopatp1.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class ResultController extends Table<MatchEvent> implements DataController<MatchEntity> {

    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnEditarPartida;
    @FXML
    private VBox detalhesRows;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label team1label;
    @FXML
    private Label team2label;

    private MatchEntity selected;

    @FXML
    public void initialize(){
        if (!Permission.hasManagementAccess())
            btnEditarPartida.setVisible(false);
    }

    public ResultController() {
        super(3, 5);
    }

    @Override
    protected boolean filterCondition(MatchEvent object) {
        return true;
    }

    @Override
    protected boolean isEmptyFilters() {
        return true;
    }

    @Override
    protected Label[] getLabels(MatchEvent object) {
        return new Label[]{
                new Label(object.minute()),
                new Label(object.type().toString()),
                new Label(object.description())
        };
    }

    @Override
    public void getData(MatchEntity data) {
        selected = data;
        this.objects = new ArrayList<>(data.getHistory());
        scoreLabel.setText(data.getScore());

        team1label.setText(data.getTeam1().getName());
        team2label.setText(data.getTeam2().getName());

        this.renderTable();
    }

    @FXML
    public void back(){
        Router.navigateTo(ViewName.MATCH);
    }

    @FXML
    public void editMatch(){
        Router.navigateTo(ViewName.UPDATE_MATCH, selected);
    }

    @Override
    protected void renderTable() {
        this.objects.sort((lhs, rhs) ->
                String.CASE_INSENSITIVE_ORDER.compare(lhs.minute(), rhs.minute())
        );
        super.renderTable();
        this.detalhesRows.getChildren().clear();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));

        this.detalhesRows.getChildren().addAll(
                new GridPane[]{
                        createLeftTableRowPane("Status", selected.getStatus().toString()),
                        createLeftTableRowPane("Data", selected.getDate().format(formatter)),
                        createLeftTableRowPane("Horário",
                                String.format("%02d:%02d BRT", selected.getDate().getHour(), selected.getDate().getMinute())
                                ),
                        createLeftTableRowPane("Estádio", selected.getStadium().getName()),
                        createLeftTableRowPane("Fase", selected.getStage().toString())
                }
        );

    }

    @FXML
    protected GridPane createLeftTableRowPane(String title, String value) {
        GridPane grid = new GridPane();
        grid.getStyleClass().add("table-row");

        for(int i = 0; i < 2; i++){
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(50);
            grid.getColumnConstraints().add(col);
        }

        Label[] labels =  {new Label(title), new Label(value)};
        for (int i = 0; i < 2; i++) {
            labels[i].getStyleClass().add("text-row");
            labels[i].setMaxWidth(Double.MAX_VALUE);
            grid.add(labels[i], i, 0);
        }

        return grid;
    }

    @Override
    protected void onRowClicked(MatchEvent object) {

    }
}
