package com.github.luantenorio.projetocopatp1.referee;

import com.github.luantenorio.projetocopatp1.util.DAO;

import java.util.List;

public class RefereeDAO extends DAO<RefereeEntity>  {

    public RefereeDAO() {
        super("referee.bin");
    }

    public RefereeEntity create(RefereeEntity entity) {
        return null;
    }

    public List<RefereeEntity> findAll() {
        return List.of();
    }

    public RefereeEntity findById(String id) {
        return null;
    }

    public boolean update(RefereeEntity entity) {
        return false;
    }

    public boolean delete(String id) {
        return false;
    }
}
