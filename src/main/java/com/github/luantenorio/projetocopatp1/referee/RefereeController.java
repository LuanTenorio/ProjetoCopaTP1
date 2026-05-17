package com.github.luantenorio.projetocopatp1.referee;

import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;
import com.github.luantenorio.projetocopatp1.util.Table;
import javafx.scene.control.Label;

public class RefereeController extends Table<StadiumEntity>  {

    RefereeService refereeService = new RefereeService();

    public RefereeController(){
        super(3);
    }

    protected boolean filterCondition(StadiumEntity object) {
        return false;
    }

    protected boolean isEmptyFilters() {
        return false;
    }

    protected Label[] getLabels(StadiumEntity object) {
        return new Label[0];
    }

    protected void onRowClicked(StadiumEntity object) {

    }
}
