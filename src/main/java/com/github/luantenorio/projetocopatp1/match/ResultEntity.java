package com.github.luantenorio.projetocopatp1.match;

import java.util.UUID;

public class ResultEntity {
    private String id;
    private String placar;

    public ResultEntity(String placar){
        this.id = UUID.randomUUID().toString();
        this.placar = placar;
    }

    public ResultEntity(String id, String placar){
        this.id = id;
        this.placar = placar;
    }

    public String getPlacar(){
        return this.placar;
    }

    public void setPlacar(String placar){
        this.placar = placar;
    }

    public String getId() {
        return id;
    }
}
