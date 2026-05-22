package com.github.luantenorio.projetocopatp1.team;

import java.util.List;

public class TeamService {

    private final TeamDAO teamDAO = new TeamDAO();

    public List<TeamEntity> findAll(){
        return this.teamDAO.findAll();
    }

    public TeamEntity createStadium(TeamEntity team){
        return this.teamDAO.create(team);
    }

    public boolean updateStadium(TeamEntity team){
        return this.teamDAO.update(team);
    }

    public boolean deleteStadium(String id){
        return this.teamDAO.delete(id);
    }

}
