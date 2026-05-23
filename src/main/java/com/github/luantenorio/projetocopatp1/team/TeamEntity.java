package com.github.luantenorio.projetocopatp1.team;

import com.github.luantenorio.projetocopatp1.player.PlayerEntity;
import java.io.Serializable;
import java.util.*;

public class TeamEntity implements Serializable {
    private static final int MIN_PLAYERS = 18;
    private static final int MAX_PLAYERS = 26;
    private String id;
    private String name;
    private String group;
    private String coach;
    private Set<PlayerEntity> lineup;

    public TeamEntity(String name, String  group, String coach) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.group = group;
        this.coach = coach;
        lineup = new HashSet<>();
    }

    public TeamEntity(String id, String name, String  group, String coach) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.coach = coach;
        lineup = new HashSet<>();
    }

    public TeamEntity(String name, String group, String coach, Collection<PlayerEntity> players) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.group = group;
        this.coach = coach;
        this.lineup = new HashSet<>(players);
    }

    public static int getMinPlayers() {
        return MIN_PLAYERS;
    }

    public static int getMaxPlayers() {
        return MAX_PLAYERS;
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

    public Set<PlayerEntity> getLineup() {
        return new HashSet<>(lineup);
    }

    public int getLineupSize() {
        return lineup.size();
    }

    public boolean hasPlayer(PlayerEntity player) {
        return lineup.contains(player);
    }

    public boolean isLineupFull() {
        return lineup.size() >= MAX_PLAYERS;
    }

}
