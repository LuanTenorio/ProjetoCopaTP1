package com.github.luantenorio.projetocopatp1.match;

import java.io.Serializable;
import java.util.UUID;


public class MatchEntity implements Serializable {
    private String id;
    private String date;
    private String time;
    private CompetitionFase fase;
    private MatchStatus status;

    public MatchEntity(String date, String time, CompetitionFase fase, MatchStatus status){
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.time = time;
        this.fase = fase;
        this.status = status;
    }

    public MatchEntity(String id, String date, String time, CompetitionFase fase, MatchStatus status){
        this.id = id;
        this.date = date;
        this.time = time;
        this.fase = fase;
        this.status = status;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getTime(){
        return this.time;
    }

    public void setTime(String time){
        this.time = time;
    }

    public CompetitionFase getFase(){
        return this.fase;
    }

    public void setFase(CompetitionFase fase){
        this.fase = fase;
    }

    public MatchStatus getStatus(){
        return this.status;
    }

    public void setStatus(MatchStatus status){
        this.status = status;
    }

}
