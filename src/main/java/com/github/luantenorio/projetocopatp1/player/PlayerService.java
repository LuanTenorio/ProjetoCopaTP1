package com.github.luantenorio.projetocopatp1.player;

import javafx.collections.ObservableList;

import java.util.List;

public class PlayerService {

    private final PlayerDAO playerDAO = new PlayerDAO();

    public List<PlayerEntity> findAll(){
        return this.playerDAO.findAll();
    }

    public List<PlayerEntity> findPlayersWithoutTeam() {
        List<PlayerEntity> players = this.playerDAO.findAll();

        return players.stream()
                .filter(player -> player.getTeamId() == null)
                .toList();
    }

    public PlayerEntity createPlayer(PlayerEntity team){
        return this.playerDAO.create(team);
    }

    public boolean updatePlayer(PlayerEntity team){
        return this.playerDAO.update(team);
    }

    public boolean deletePlayer(String id){
        return this.playerDAO.delete(id);
    }

    public void updateTeamIds(List<PlayerEntity> selectedPlayers, String teamId) {
        playerDAO.updateTeamIds(selectedPlayers, teamId);
    }
}
