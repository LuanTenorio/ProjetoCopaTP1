package com.github.luantenorio.projetocopatp1.player;

import com.github.luantenorio.projetocopatp1.util.DAO;

import java.util.List;

public class PlayerDAO extends DAO<PlayerEntity> {

    public PlayerDAO() {
        super("player.bin");
    }

    @Override
    public PlayerEntity create(PlayerEntity entity) {
        return null;
    }

    @Override
    public List<PlayerEntity> findAll() {
        return List.of();
    }

    public PlayerEntity findById(String id) {
        return null;
    }

    public boolean update(PlayerEntity entity) {
        return false;
    }

    public boolean delete(String id) {
        return false;
    }
}
