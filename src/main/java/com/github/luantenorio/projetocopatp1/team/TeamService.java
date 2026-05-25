package com.github.luantenorio.projetocopatp1.team;

import java.util.List;

public class TeamService {

    private final TeamDAO teamDAO = new TeamDAO();

    public List<TeamEntity> findAll(){
        return this.teamDAO.findAll();
    }

    public TeamEntity createTeam(TeamEntity team) throws TeamException{
        if (team.getLineupSize() < TeamEntity.getMinPlayers()) {
            throw new TeamException.MinimumPlayersException();
        }
        if (team.getLineupSize() > TeamEntity.getMaxPlayers()) {
            throw new TeamException.MaximumPlayersException();
        }
        return this.teamDAO.create(team);
    }

    public TeamEntity updateTeam(TeamEntity team) throws TeamException{
        if (team.getLineupSize() < TeamEntity.getMinPlayers()) {
            throw new TeamException.MinimumPlayersException();
        }
        if (team.getLineupSize() > TeamEntity.getMaxPlayers()) {
            throw new TeamException.MaximumPlayersException();
        }
        if(this.teamDAO.update(team)) return team; else return null;
    }

    public boolean deleteTeam(String id){
        return this.teamDAO.delete(id);
    }

}
