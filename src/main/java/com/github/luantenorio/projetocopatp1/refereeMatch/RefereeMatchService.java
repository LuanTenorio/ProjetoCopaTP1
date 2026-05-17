package com.github.luantenorio.projetocopatp1.refereeMatch;

import com.github.luantenorio.projetocopatp1.match.MatchDAO;
import com.github.luantenorio.projetocopatp1.match.MatchEntity;
import com.github.luantenorio.projetocopatp1.referee.RefereeDAO;
import com.github.luantenorio.projetocopatp1.referee.RefereeEntity;
import com.github.luantenorio.projetocopatp1.referee.RefereeService;

import java.util.ArrayList;
import java.util.List;

public class RefereeMatchService {

    private final RefereeMatchDAO refereeMatchDAO = new RefereeMatchDAO(); // tirar os DAOs e deixar só os services
    private final RefereeService refereeService = new RefereeService();
    private final RefereeDAO refereeDAO = new RefereeDAO();
    private final MatchDAO matchDAO = new MatchDAO();

    public boolean assignRefereeToMatch(RefereeEntity referee, MatchEntity match){
        //precisa dos times
//        if(!this.refereeService.checksIfRefereeCanRefereeMatch(referee, match))
//            return false;

        RefereeMatchEntity refereeMatch = new RefereeMatchEntity(referee.getId(), match.getId());

        this.refereeMatchDAO.create(refereeMatch);

        return true;
    }

    public List<RefereeEntity> getRefereeFromMatch(String matchId){
        List<RefereeEntity> allReferee = this.refereeDAO.findAll();
        List<RefereeEntity> refereeEntities = new ArrayList<>();

        for(RefereeEntity referee : allReferee){
            RefereeMatchEntity refereeMatch = this.refereeMatchDAO.findByIdReferee(referee.getId());

            if(refereeMatch != null)
                refereeEntities.add(this.refereeDAO.findById(referee.getId()));
        }

        return refereeEntities;
    }

    public List<MatchEntity> getMatchFromReferee(String refereeId){
        List<MatchEntity> allMatches = this.matchDAO.findAll();
        List<MatchEntity> matchesEntities = new ArrayList<>();

        for(MatchEntity match : allMatches){
            RefereeMatchEntity refereeMatch = this.refereeMatchDAO.findByIdReferee(match.getId());

            if(refereeMatch != null)
                matchesEntities.add(this.matchDAO.findById(match.getId()));
        }

        return matchesEntities;
    }
}
