package com.github.luantenorio.projetocopatp1.match;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CreateMatchController {

    MatchDAO dao = new MatchDAO();

    @FXML
    private ComboBox<String> inputTeam1;
    @FXML
    private ComboBox<String> inputTeam2;
    @FXML
    private ComboBox<String> inputStage;
    @FXML
    private DatePicker inputDate;
    @FXML
    private TextField inputTime;
    @FXML
    private ComboBox<String> inputStadium;

    @FXML
    public void initialize(){

    }

    public void register(){



        /*MatchEntity match = new MatchEntity(

        );
        dao.create(match);
        Router.NavigateTo(ViewName.MATCH);*/
    }
}
