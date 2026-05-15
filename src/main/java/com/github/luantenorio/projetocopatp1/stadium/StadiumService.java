package com.github.luantenorio.projetocopatp1.stadium;

import java.util.List;

public class StadiumService {

    private final StadiumDAO stadiumDAO = new StadiumDAO();

    public List<StadiumEntity> findAll(){
        return this.stadiumDAO.findAll();
    }

    public StadiumEntity createStadium(StadiumEntity stadium){
        return this.stadiumDAO.create(stadium);
    }


}
