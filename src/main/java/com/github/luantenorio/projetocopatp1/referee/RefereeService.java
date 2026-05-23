package com.github.luantenorio.projetocopatp1.referee;

import com.github.luantenorio.projetocopatp1.match.MatchEntity;
import com.github.luantenorio.projetocopatp1.team.TeamEntity;

import java.util.List;

public class RefereeService {

    private final RefereeDAO refereeDAO = new RefereeDAO();

    public List<RefereeEntity> findAll(){
        return this.refereeDAO.findAll();
    }

    public RefereeEntity findById(String id){
        return this.refereeDAO.findById(id);
    }

    public RefereeEntity createReferee(RefereeEntity referee){
        return this.refereeDAO.create(referee);
    }

    public boolean updateReferee(RefereeEntity referee){
        return this.refereeDAO.update(referee);
    }

    public boolean deleteReferee(String id){
        return this.refereeDAO.delete(id);
    }

    public boolean checksIfRefereeCanRefereeMatch(RefereeEntity referee, MatchEntity match){
        TeamEntity team1 = match.getTeam1();
        TeamEntity team2 = match.getTeam2();

        return  team1 != null && team2 != null &&
                !team1.getCountry().trim().equalsIgnoreCase(referee.getNationality().trim()) &&
                !team2.getCountry().trim().equalsIgnoreCase(referee.getNationality().trim());
    }

    public void deleteAll(){
        this.refereeDAO.clearAll();
    }

}
