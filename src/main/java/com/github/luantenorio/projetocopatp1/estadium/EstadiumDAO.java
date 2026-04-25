package com.github.luantenorio.projetocopatp1.estadium;

import java.util.ArrayList;

public class EstadiumDAO {

    public EstadiumEntity createEstadium(String name, String location, int capacity){

//        EstadiumEntity estadium = new EstadiumEntity(name, location, capacity);
        return null;
    }

//    Retornar tudo e fazer a paginação no componente
    public ArrayList<EstadiumEntity> estadiumPagination() {
        var arr = new ArrayList<EstadiumEntity>();
        for(int i = 1; i <= 45; i++)
            arr.add(new EstadiumEntity("est " + i, "bsb " + i, 10000 * i));

        return arr;
    }

}
