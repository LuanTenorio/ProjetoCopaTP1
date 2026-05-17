package com.github.luantenorio.projetocopatp1.referee;

import java.util.List;

public class RefereeService {

    private final RefereeDAO refereeDAO = new RefereeDAO();

    public List<RefereeEntity> findAll(){
        return this.refereeDAO.findAll();
    }

    public RefereeEntity createReferee(RefereeEntity referee){
        return this.refereeDAO.create(referee);
    }

    public boolean updateReferee(RefereeEntity stadium){
        return this.refereeDAO.update(stadium);
    }

    public boolean deleteReferee(String id){
        return this.refereeDAO.delete(id);
    }

}
