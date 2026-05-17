package com.github.luantenorio.projetocopatp1.match;

import com.github.luantenorio.projetocopatp1.util.DAO;

import java.util.List;

public class MatchDAO extends DAO<MatchEntity> {
    public MatchDAO() {
        super("match.bin");
    }

    public MatchEntity create(MatchEntity entity){
        List<MatchEntity> matches = this.readFile();

        matches.add(entity);
        saveFile(matches);

        return entity;
    }

    public List<MatchEntity> findAll() {
        return this.readFile();
    }

    public MatchEntity findById(String id) {
        List<MatchEntity> matches = this.readFile();

        return matches.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean update(MatchEntity entity) {
        List<MatchEntity> matches = this.readFile();
        int sizeOld = matches.size();
        matches.removeIf(matchEntity -> matchEntity.getId().equals(entity.getId()));
        if (matches.size() == sizeOld) return false;
        matches.add(entity);
        saveFile(matches);
        return true;
    }

    //Verificar operações em cascata
    public boolean delete(String id) {
        List<MatchEntity> matches = this.readFile();
        int sizeOld = matches.size();
        matches.removeIf(matchEntity -> matchEntity.getId().equals(id));
        if (matches.size() == sizeOld) return false;
        saveFile(matches);
        return true;
    }

}
