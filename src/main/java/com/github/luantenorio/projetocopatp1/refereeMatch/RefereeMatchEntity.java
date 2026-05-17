package com.github.luantenorio.projetocopatp1.refereeMatch;

import java.io.Serializable;

public class RefereeMatchEntity implements Serializable {
    private final String idReferee;
    private final String idMatch;

    public RefereeMatchEntity(String idReferee, String idMatch) {
        this.idMatch = idMatch;
        this.idReferee = idReferee;
    }

    public String getIdReferee() {
        return idReferee;
    }

    public String getIdMatch() {
        return idMatch;
    }
}
