package com.github.luantenorio.projetocopatp1.estadium;

import java.util.UUID;

public class EstadiumEntity {
    private String id;
    private String name;
    private String location;
    private int capacity;


    public EstadiumEntity(String name, String location, int capacity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public EstadiumEntity(String id, String name, String location, int capacity) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if(capacity >= 0)
            this.capacity = capacity;
    }
}
