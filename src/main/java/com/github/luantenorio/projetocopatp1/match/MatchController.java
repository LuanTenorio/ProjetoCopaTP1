package com.github.luantenorio.projetocopatp1.match;

import com.github.luantenorio.projetocopatp1.stadium.StadiumDAO;
import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;

import java.util.ArrayList;
import java.util.List;

public class MatchController {
    private List<MatchEntity> matches = new ArrayList<>();
    private List<MatchEntity> matchesFiltered = new ArrayList<>();
    private MatchDAO matchDAO = new MatchDAO();
    private StadiumEntity activedFilters = new StadiumEntity("", "", 0);
    private List<StadiumEntity> entitiesVisibles = new ArrayList<>();
    private int SIZE_PAGINATION = 10;
    private int totPages;
    private int curPage = 1;
}
