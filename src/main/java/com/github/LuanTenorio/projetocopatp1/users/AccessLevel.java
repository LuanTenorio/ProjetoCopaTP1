package com.github.luantenorio.projetocopatp1.users;

public enum AccessLevel{
    ADMINISTRADOR(1),
    ORGANIZADOR(2),
    ARBITRO(3);

    private final int level;

    AccessLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return level;
    }
}
