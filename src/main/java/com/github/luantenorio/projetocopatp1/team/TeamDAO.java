package com.github.luantenorio.projetocopatp1.team;

import com.github.luantenorio.projetocopatp1.util.DAO;

import java.util.ArrayList;
import java.util.List;

public class TeamDAO extends DAO<TeamEntity> {

    public TeamDAO() {
        super("team.bin");
    }

    @Override
    public TeamEntity create(TeamEntity entity) {
        List<TeamEntity> teams = this.readFile();

        teams.add(entity);
        saveFile(teams);

        return entity;
    }

    @Override
    public List<TeamEntity> findAll() {
        return this.readFile();
    }

    @Override
    public TeamEntity findById(String id) {
        List<TeamEntity> teams = this.readFile();

        return teams.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean update(TeamEntity entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
