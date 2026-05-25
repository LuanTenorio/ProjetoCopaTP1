package com.github.luantenorio.projetocopatp1.player;

import com.github.luantenorio.projetocopatp1.util.DAO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlayerDAO extends DAO<PlayerEntity> {

    public PlayerDAO() {
        super("player.bin");
    }

    @Override
    public PlayerEntity create(PlayerEntity entity) {
        List<PlayerEntity> players = this.readFile();

        players.add(entity);
        saveFile(players);

        return entity;
    }

    @Override
    public List<PlayerEntity> findAll() {
        return this.readFile();
    }

    public PlayerEntity findById(String id) {
        return null;
    }

    public boolean update(PlayerEntity entity) {
        return false;
    }

    public boolean updateTeamIds(List<PlayerEntity> selectedPlayers, String teamId) {
        List<PlayerEntity> players = this.readFile();

        Set<String> selectedPlayerIds = selectedPlayers.stream()
                .map(PlayerEntity::getId)
                .collect(Collectors.toSet());

        for (PlayerEntity player : players) {
            if (selectedPlayerIds.contains(player.getId())) {
                player.setTeamId(teamId);
            } else if (teamId.equals(player.getTeamId())) {
                player.setTeamId(null);
            }
        }

        return this.saveFile(players);
    }

    public boolean delete(String id) {
        return false;
    }
}
