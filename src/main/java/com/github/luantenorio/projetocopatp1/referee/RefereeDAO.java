package com.github.luantenorio.projetocopatp1.referee;

import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;
import com.github.luantenorio.projetocopatp1.util.DAO;

import java.util.List;

public class RefereeDAO extends DAO<RefereeEntity>  {

    public RefereeDAO() {
        super("referee.bin");
    }

    public RefereeEntity create(RefereeEntity entity) {
        List<RefereeEntity> referee = this.readFile();

        referee.add(entity);
        saveFile(referee);

        return entity;
    }

    public List<RefereeEntity> findAll() {
        return this.readFile();
    }

    public RefereeEntity findById(String id) {
        List<RefereeEntity> referee = this.readFile();

        return referee.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean update(RefereeEntity entity) {
        List<RefereeEntity> referrers = this.findAll();

        for (int i = 0; i < referrers.size(); i++) {
            if (referrers.get(i).getId().equals(entity.getId())) {
                referrers.set(i, entity);
                this.saveFile(referrers);
                return true;
            }
        }

        return false;
    }

    public boolean delete(String id) {
        List<RefereeEntity> refereers = this.findAll();

        for (int i = 0; i < refereers.size(); i++) {
            if (refereers.get(i).getId().equals(id)) {
                refereers.remove(i);
                this.saveFile(refereers);
                return true;
            }
        }

        return false;
    }
}
