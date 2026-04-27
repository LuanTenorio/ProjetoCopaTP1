package com.github.luantenorio.projetocopatp1.stadium;

import com.github.luantenorio.projetocopatp1.util.DAO;

import java.util.List;

public class StadiumDAO extends DAO<StadiumEntity> {

    public StadiumDAO(){
        super("stadium.bin");
    }

    public StadiumEntity create(StadiumEntity entity){
        List<StadiumEntity> stadiums = this.readFile();

        stadiums.add(entity);
        saveFile(stadiums);

        return entity;
    }

    public List<StadiumEntity> findAll() {
        return this.readFile();
    }

    public StadiumEntity findById(String id) {
        List<StadiumEntity> stadiums = this.readFile();

        return stadiums.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean update(StadiumEntity entity) {
        return false;
    }

    public boolean delete(String id) {
        return false;
    }

}
