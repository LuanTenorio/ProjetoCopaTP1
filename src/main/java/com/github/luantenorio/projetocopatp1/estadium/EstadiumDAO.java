package com.github.luantenorio.projetocopatp1.estadium;

import com.github.luantenorio.projetocopatp1.util.DAO;

import java.util.List;

public class EstadiumDAO extends DAO<EstadiumEntity> {

    public EstadiumDAO(){
        super("stadium.bin");
    }

    public EstadiumEntity create(EstadiumEntity entity){
        List<EstadiumEntity> estadiuns = this.readFile();

        estadiuns.add(entity);
        saveFile(estadiuns);

        return entity;
    }

    public List<EstadiumEntity> findAll() {
        return this.readFile();
    }

    public EstadiumEntity findById(String id) {
        List<EstadiumEntity> estadiuns = this.readFile();

        return estadiuns.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean update(EstadiumEntity entity) {
        return false;
    }

    public boolean delete(String id) {
        return false;
    }

}
