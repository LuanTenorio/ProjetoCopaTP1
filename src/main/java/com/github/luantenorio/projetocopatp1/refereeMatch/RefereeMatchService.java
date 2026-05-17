package com.github.luantenorio.projetocopatp1.refereeMatch;

import com.github.luantenorio.projetocopatp1.match.MatchEntity;
import com.github.luantenorio.projetocopatp1.referee.RefereeEntity;

public class RefereeMatchService {

    private final RefereeMatchDAO refereeMatchDAO = new RefereeMatchDAO();

    public boolean assignRefereeToMatch(RefereeEntity referee, MatchEntity match){
        if(
            match.getTeam1().getCountry().trim().equalsIgnoreCase(referee.getNationality().trim()) ||
            match.getTeam2().getCountry().trim().equalsIgnoreCase(referee.getNationality().trim())
        )
            return false;

        RefereeMatchEntity refereeMatch = new RefereeMatchEntity(referee.getId(), match.getId());

        this.refereeMatchDAO.create(refereeMatch);

        return true;
    }
}
