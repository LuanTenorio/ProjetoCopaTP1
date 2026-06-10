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

    public PlayerEntity createPlayer(PlayerEntity player){
        return this.playerDAO.create(player);
    }

    public boolean updatePlayer(PlayerEntity player){
        return this.playerDAO.update(player);
    }

    public boolean deletePlayer(String id){
        return this.playerDAO.delete(id);
    }

    public void updateTeamIds(List<PlayerEntity> selectedPlayers, String teamId) {
        playerDAO.updateTeamIds(selectedPlayers, teamId);
    }

    public List<PlayerEntity> findTeamLineup(String teamId) {
        List<PlayerEntity> players = this.playerDAO.findAll();

        return players.stream()
                .filter(player -> teamId.equals(player.getTeamId()))
                .toList();
    }

    public void setThisTeamIdToNull(String teamId) {
        playerDAO.setThisTeamIdToNull(teamId);
    }

    public PlayerStatus stringToPlayerStatus(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        return switch (value) {
            case "Ativo" -> PlayerStatus.ACTIVE;
            case "Lesionado" -> PlayerStatus.INJURED;
            case "Suspenso" -> PlayerStatus.SUSPENDED;
            default -> null;
        };

    }
}
