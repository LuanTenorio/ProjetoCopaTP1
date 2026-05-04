package com.github.luantenorio.projetocopatp1.team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class TeamEntity implements Serializable {
    private static final int MIN_PLAYERS = 18;
    private static final int MAX_PLAYERS = 26;
    private String id;
    private String name;
    private String group;
    private String coach;
//    private List<PlayerEntity> lineup;

    public TeamEntity(String name, String  group, String coach) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.group = group;
        this.coach = coach;
//        lineup = new ArrayList<>();
    }

    public TeamEntity(String id, String name, String  group, String coach) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.coach = coach;
//        lineup = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

//    public List<PlayerEntity> getLineup () {
//        return new ArrayList<>(lineup);
//    }

//    public int getLineupSize() {
//        return lineup.size();
//    }

//    public void addPlayer(PlayerEntity player) {
//        if (player == null) return;
//        if (player.getTeamId != null) return;
//        if (TeamEntity.hasPlayer(player)) return;
//        if (lineup.size() >= MAX_PLAYERS) return;
//        lineup.add(player);
//        player.setTeamId(id);
//    }

//    public void removePlayer(PlayerEntity player) {
//        if (player == null) return;
//        if (!TeamEntity.hasPlayer(player)) return;
//        lineup.remove(player);
//        player.setTeamId(null);
//    }

//    public boolean hasPlayer(PlayerEntity player) {
//        return lineup.contains(player);
//    }

//    public boolean isLineupFull() {
//        return lineup.size() >= MAX_PLAYERS;
//    }

//    public boolean hasMinimumPlayers() {
//        return lineup.size() >= MIN_PLAYERS;
//    }
}
