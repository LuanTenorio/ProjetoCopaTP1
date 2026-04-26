package com.github.luantenorio.projetocopatp1.estadium;

import com.github.luantenorio.projetocopatp1.interfaces.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EstadiumDAO implements Persistence<EstadiumEntity> {

    public EstadiumEntity create(EstadiumEntity entity){

//        EstadiumEntity estadium = new EstadiumEntity(name, location, capacity);
        return null;
    }

    public List<EstadiumEntity> findAll() {
        var arr = new ArrayList<EstadiumEntity>();
        for(int i = 1; i <= 15; i++)
            arr.add(new EstadiumEntity("est " + i, "bsb " + i, 10000 * i));
        for(int i = 1; i <= 15; i++)
            arr.add(new EstadiumEntity("espet " + i, "bahia " + i, 10000 * i));
        for(int i = 1; i <= 15; i++)
            arr.add(new EstadiumEntity("peppa " + i, "pig " + i, 10000 * i));

        return arr;
    }

    public EstadiumEntity find(UUID id) {
        return null;
    }

    public boolean update(EstadiumEntity entity) {
        return false;
    }

    public boolean delete(UUID id) {
        return false;
    }

}
