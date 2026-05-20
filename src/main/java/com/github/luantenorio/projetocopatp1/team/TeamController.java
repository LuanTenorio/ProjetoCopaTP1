package com.github.luantenorio.projetocopatp1.team;

import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.ViewName;

public class TeamController {
    public void navigateToCreateTeam() {
        Router.navigateTo(ViewName.CREATE_TEAM);
    }
}
