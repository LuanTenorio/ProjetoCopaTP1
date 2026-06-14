package com.github.luantenorio.projetocopatp1.match;

import com.github.luantenorio.projetocopatp1.stadium.StadiumDAO;
import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;
import com.github.luantenorio.projetocopatp1.team.TeamDAO;
import com.github.luantenorio.projetocopatp1.team.TeamEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class MatchEntity implements Serializable {
    private final String id;
    private String team1Id;
    private String team2Id;
    private ZonedDateTime date;
    private String stadiumId;
    private MatchStage stage;
    private MatchStatus status;
    public static final String DEFAULT_SCORE = "0-0";
    private final Result result = new Result(DEFAULT_SCORE);

    public MatchEntity(String team1Id, String team2Id, ZonedDateTime date, String stadiumId, MatchStage stage) {
        this.id = UUID.randomUUID().toString();
        this.team1Id = team1Id;
        this.team2Id = team2Id;
        this.date = date;
        this.stadiumId = stadiumId;
        this.stage = stage;
        this.status = MatchStatus.SCHEDULED;
    }

    public MatchEntity(String team1Id, String team2Id, ZonedDateTime date, String stadiumId, MatchStage stage, MatchStatus status) {
        this.id = UUID.randomUUID().toString();
        this.team1Id = team1Id;
        this.team2Id = team2Id;
        this.date = date;
        this.stadiumId = stadiumId;
        this.stage = stage;
        this.status = status;
    }

    public MatchEntity(String id, String team1Id, String team2Id, ZonedDateTime date, String stadiumId, MatchStage stage, MatchStatus status) {
        this.id = id;
        this.team1Id = team1Id;
        this.team2Id = team2Id;
        this.date = date;
        this.stadiumId = stadiumId;
        this.stage = stage;
        this.status = status;
    }

    public void setScore(String score){
        if (status != MatchStatus.SCHEDULED){
            this.result.setScore(score);
        }
    }

    public String getScore(){

        return this.status != MatchStatus.SCHEDULED ?
                result.getScore() :
                DEFAULT_SCORE;
    }

    @Unmodifiable
    public Set<MatchEvent> getHistory(){
        return this.status != MatchStatus.SCHEDULED ?
                Collections.unmodifiableSet(result.getHistory()) :
                Collections.emptySet();
    }

    public void removeEvent(MatchEvent event){
        result.removeEvent(event);
    }

    public String getId() {
        return id;
    }

    public void addEvent(String minute, EventType type, String description){
        if (this.status != MatchStatus.SCHEDULED) result.addEvent(minute, type, description);
    }

    public String getTeam1Id() {
        return team1Id;
    }

    public String getTeam2Id() {
        return team2Id;
    }

    public TeamEntity getTeam1() {
        TeamDAO dao = new TeamDAO();
        return dao.findById(team1Id);
    }

    public TeamEntity getTeam2() {
        TeamDAO dao = new TeamDAO();
        return dao.findById(team2Id);
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public String getStadiumId() {
        return stadiumId;
    }

    public void setStage(MatchStage stage) {
        this.stage = stage;
    }

    public MatchStage getStage() {
        return stage;
    }

    public MatchStatus getStatus() {
        return status;
    }

    public void setStatus(MatchStatus status) {
        this.status = status;
        if (status == MatchStatus.SCHEDULED) {
            result.reset();
        }
    }

    public void setTeam1(@NotNull TeamEntity team1) {
        this.team1Id = team1.getId();
    }

    public void setTeam2(@NotNull TeamEntity team2) {
        this.team2Id = team2.getId();
    }

    public StadiumEntity getStadium() {
        StadiumDAO dao = new StadiumDAO();
        return dao.findById(this.stadiumId);
    }

    public String getName() {
        return getTeam1().getName() + " vs " + getTeam2().getName();
    }

    private static class Result implements Serializable {
        private String score;
        private final HashSet<MatchEvent> history = new HashSet<>();

        public Result(String score) {
            this.score = score;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public Set<MatchEvent> getHistory() {
            return history;
        }

        public void addEvent(String minute, EventType type, String description){
            history.add(
                    new MatchEvent(
                            UUID.randomUUID().toString(),
                            minute,
                            type,
                            description
                    )
            );
        }

        public void reset() {
            score = DEFAULT_SCORE;
            history.clear();
        }

        public void removeEvent(MatchEvent event){
            history.remove(event);
        }
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public void setStadium(StadiumEntity stadium) {
        this.stadiumId = stadium.getId();
    }
}