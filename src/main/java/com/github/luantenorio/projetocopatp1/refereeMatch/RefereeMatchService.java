package com.github.luantenorio.projetocopatp1.refereeMatch;

import com.github.luantenorio.projetocopatp1.match.MatchDAO;
import com.github.luantenorio.projetocopatp1.match.MatchEntity;
import com.github.luantenorio.projetocopatp1.referee.RefereeEntity;
import com.github.luantenorio.projetocopatp1.referee.RefereeService;

import java.util.ArrayList;
import java.util.List;

public class RefereeMatchService {

    private final RefereeMatchDAO refereeMatchDAO = new RefereeMatchDAO(); // tirar os DAOs e deixar só os services
    private final RefereeService refereeService = new RefereeService();
    private final MatchDAO matchDAO = new MatchDAO();

    public boolean assignRefereeToMatch(List<RefereeMatchEntity> refereeMatchEntities, String refereeId){
        var list = refereeMatchEntities.stream()
                .filter(rm -> this.refereeService.checksIfRefereeCanRefereeMatch(refereeService.findById(rm.getIdReferee()), matchDAO.findById(rm.getIdMatch()))).toList();

        this.refereeMatchDAO.deleteAllByReferee(refereeId);

        if(list.isEmpty())
            return false;

        list.forEach(m -> System.out.println(matchDAO.findById(m.getIdMatch()).getName()));


        this.refereeMatchDAO.createMany(list);
        return true;
    }

    public List<RefereeEntity> getRefereeFromMatch(String matchId) {
        List<RefereeEntity> refereeEntities = new ArrayList<>();

        List<RefereeMatchEntity> refereeMatchEntities = this.refereeMatchDAO.findAllByMatchId(matchId);

        if (refereeMatchEntities == null || refereeMatchEntities.isEmpty())
            return refereeEntities;

        for (RefereeMatchEntity rm : refereeMatchEntities) {
            RefereeEntity arbitroReal = this.refereeService.findById(rm.getIdReferee());

            if (arbitroReal != null)
                refereeEntities.add(arbitroReal);
        }

        return refereeEntities;
    }

    public List<MatchEntity> getMatchFromReferee(String refereeId) {
        List<MatchEntity> matchesEntities = new ArrayList<>();

        List<RefereeMatchEntity> refereeMatchEntities = this.refereeMatchDAO.findAllByRefereeId(refereeId);

        if (refereeMatchEntities == null || refereeMatchEntities.isEmpty())
            return matchesEntities;

        for (RefereeMatchEntity rm : refereeMatchEntities) {
            MatchEntity match = this.matchDAO.findById(rm.getIdMatch());

            if(match != null)
                matchesEntities.add(match);
        }

        return matchesEntities;
    }
}
