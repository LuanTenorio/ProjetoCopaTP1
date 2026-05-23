package com.github.luantenorio.projetocopatp1.player;

import java.util.List;

public class PlayerService {

    private final PlayerDAO teamDAO = new PlayerDAO();

    public List<PlayerEntity> findAll(){
        return this.teamDAO.findAll();
    }

    public PlayerEntity createStadium(PlayerEntity team){
        return this.teamDAO.create(team);
    }

    public boolean updateStadium(PlayerEntity team){
        return this.teamDAO.update(team);
    }

    public boolean deleteStadium(String id){
        return this.teamDAO.delete(id);
    }

}
