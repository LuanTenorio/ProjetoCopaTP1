package com.github.luantenorio.projetocopatp1.team;

import java.util.List;

public class TeamService {

    private final TeamDAO teamDAO = new TeamDAO();

    public List<TeamEntity> findAll(){
        return this.teamDAO.findAll();
    }

    public TeamEntity createTeam(TeamEntity team){
        return this.teamDAO.create(team);
    }

    public boolean updateTeam(TeamEntity team){
        return this.teamDAO.update(team);
    }

    public boolean deleteTeam(String id){
        return this.teamDAO.delete(id);
    }

}
