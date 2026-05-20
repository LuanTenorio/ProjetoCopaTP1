package com.github.luantenorio.projetocopatp1.referee;

import java.io.Serializable;
import java.util.UUID;

public class RefereeEntity implements Serializable {

    private final String id;
    private String name;
    private String nationality;
    private int performanceTime;
    private String history;

    public RefereeEntity(String id, String name, String nationality, int performanceTime, String history){
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.performanceTime = performanceTime;
        this.history = history;
    }

    public RefereeEntity(String name, String nationality, int performanceTime, String history){
        this.id = UUID.randomUUID().toString();;
        this.name = name;
        this.nationality = nationality;
        this.performanceTime = performanceTime;
        this.history = history;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getPerformanceTime() {
        return performanceTime;
    }

    public void setPerformanceTime(int performanceTime) {
        this.performanceTime = performanceTime;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
