package com.github.luantenorio.projetocopatp1.match;

import com.github.luantenorio.projetocopatp1.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class FormResultController extends Table<MatchEvent> implements DataController<MatchEntity> {

    private MatchEntity selected;

    @FXML
    private ComboBox<String> inputStatus;
    @FXML
    private TextField inputScore;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnNovoEvento;
    @FXML
    private Button btnOperar;

    public FormResultController() {
        super(3, 5);
    }

    @FXML
    public void initialize(){
        ObservableList<String> status = FXCollections.observableArrayList();
        for(MatchStatus type : MatchStatus.values()){
            status.add(type.toString());
        }
        inputStatus.setItems(status);

        this.renderTable();
    }

    @Override
    public void getData(MatchEntity data) {
        selected = data;
        this.objects = new ArrayList<>(data.getHistory());
        this.inputStatus.getSelectionModel().select(data.getStatus().toString());
        this.inputScore.setText(data.getScore());
        this.renderTable();
    }

    @FXML
    public void back(){
        Router.navigateTo(ViewName.UPDATE_MATCH, selected);
    }

    @FXML
    public void newEvent(){
        Router.navigateTo(ViewName.CREATE_EVENT, new Tuple<>(selected, null));
    }

    @FXML
    public void operate(){
        String status = inputStatus.getSelectionModel().getSelectedItem();
        if(status != null) selected.setStatus(MatchStatus.findByName(status));

        if (inputScore.getText() != null)
            selected.setScore(inputScore.getText());
        else selected.setScore(MatchEntity.DEFAULT_SCORE);
        back();
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
    protected void onRowClicked(MatchEvent object) {
        Router.navigateTo(ViewName.UPDATE_EVENT, new Tuple<>(selected, object));
    }

    @Override
    protected void renderTable() {
        this.objects.sort((lhs, rhs) ->
                String.CASE_INSENSITIVE_ORDER.compare(lhs.minute(), rhs.minute())
        );
        super.renderTable();
    }

    @Override
    protected boolean filterCondition(MatchEvent object) {return false;}
    @Override
    protected boolean isEmptyFilters() {return true;}
}
