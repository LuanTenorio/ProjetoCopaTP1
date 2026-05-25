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
        List<StadiumEntity> stadiums = this.findAll();

        for (int i = 0; i < stadiums.size(); i++) {
            if (stadiums.get(i).getId().equals(entity.getId())) {
                stadiums.set(i, entity);
                this.saveFile(stadiums);
                return true;
            }
        }

        return false;
    }

    public boolean delete(String id) {
        List<StadiumEntity> stadiums = this.findAll();

        for (int i = 0; i < stadiums.size(); i++) {
            if (stadiums.get(i).getId().equals(id)) {
                stadiums.remove(i);
                this.saveFile(stadiums);
                return true;
            }
        }

        return false;
    }

}
