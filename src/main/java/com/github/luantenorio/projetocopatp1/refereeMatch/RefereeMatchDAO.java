package com.github.luantenorio.projetocopatp1.refereeMatch;

import com.github.luantenorio.projetocopatp1.util.DAO;

import java.util.List;

public class RefereeMatchDAO extends DAO<RefereeMatchEntity> {
    public RefereeMatchDAO() {
        super("refereMatch.bin");
    }

    public RefereeMatchEntity create(RefereeMatchEntity entity) {
        List<RefereeMatchEntity> referee = this.readFile();

        referee.add(entity);
        saveFile(referee);

        return entity;
    }

    public List<RefereeMatchEntity> findAll() {
        return this.readFile();
    }

    public RefereeMatchEntity findById(String id) {
        RefereeMatchEntity refereeMatchEntity = this.findByIdReferee(id);

        if(refereeMatchEntity == null)
            refereeMatchEntity = this.findByIdMatch(id);

        return refereeMatchEntity;
    }

    public RefereeMatchEntity findByIdReferee(String id) {
        List<RefereeMatchEntity> referee = this.readFile();

        return referee.stream().filter(s -> s.getIdReferee().equals(id)).findFirst().orElse(null);
    }

    public RefereeMatchEntity findByIdMatch(String id) {
        List<RefereeMatchEntity> referee = this.readFile();

        return referee.stream().filter(s -> s.getIdMatch().equals(id)).findFirst().orElse(null);
    }

    public boolean update(RefereeMatchEntity entity) {
        boolean isDeleted = this.delete(entity.getIdReferee());

        if(!isDeleted)
            return false;

        this.create(entity);

        return true;
    }

    public boolean delete(String id) {
        boolean isDeleted = this.deleteByReferee(id);

        if(!isDeleted)
            isDeleted = this.deleteByMatch(id);

        return isDeleted;
    }

    public boolean deleteByReferee(String id) {
        List<RefereeMatchEntity> refereers = this.findAll();

        for (int i = 0; i < refereers.size(); i++) {
            if (refereers.get(i).getIdReferee().equals(id)) {
                refereers.remove(i);
                this.saveFile(refereers);
                return true;
            }
        }

        return false;
    }

    public boolean deleteByMatch(String id) {
        List<RefereeMatchEntity> refereers = this.findAll();

        for (int i = 0; i < refereers.size(); i++) {
            if (refereers.get(i).getIdReferee().equals(id)) {
                refereers.remove(i);
                this.saveFile(refereers);
                return true;
            }
        }

        return false;
    }

}
