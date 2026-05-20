package com.github.luantenorio.projetocopatp1.refereeMatch;

import com.github.luantenorio.projetocopatp1.util.DAO;

import java.util.List;

public class RefereeMatchDAO extends DAO<RefereeMatchEntity> {
    public RefereeMatchDAO() {
        super("refereMatch.bin");
    }

    public RefereeMatchEntity create(RefereeMatchEntity entity) {
        var refereeMatch = this.find(entity);

        if(refereeMatch != null)
            return refereeMatch;

        List<RefereeMatchEntity> referee = this.readFile();

        referee.add(entity);
        saveFile(referee);

        return entity;
    }

    public void createMany(List<RefereeMatchEntity> entities){
        List<RefereeMatchEntity> referee = this.readFile();

        for(RefereeMatchEntity rm : entities){
            var refereeMatch = this.find(rm);

            if(refereeMatch != null)
                continue;

            referee.add(rm);
        }

        saveFile(referee);
    }

    public List<RefereeMatchEntity> findAll() {
        return this.readFile();
    }

    public RefereeMatchEntity find(RefereeMatchEntity refereeMatch) {
        List<RefereeMatchEntity> referee = this.readFile();

        return referee.stream()
                .filter(s -> s.getIdReferee().equals(refereeMatch.getIdReferee()) && s.getIdMatch().equals(refereeMatch.getIdMatch()))
                .findFirst().orElse(null);
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
        boolean isDeleted = this.delete(entity);

        if(!isDeleted)
            return false;

        this.create(entity);

        return true;
    }

    public boolean delete(RefereeMatchEntity refereeMatch) {
        List<RefereeMatchEntity> refereers = this.findAll();

        for (int i = 0; i < refereers.size(); i++)
            if (refereers.get(i).getIdReferee().equals(refereeMatch.getIdReferee()) && refereers.get(i).getIdMatch().equals(refereeMatch.getIdMatch()))
                refereers.remove(i);

        this.saveFile(refereers);
        return true;
    }

    public void deleteAllByReferee(String id) {
        List<RefereeMatchEntity> refereers = this.findAll();

        for (int i = 0; i < refereers.size(); i++)
            if (refereers.get(i).getIdReferee().equals(id))
                refereers.remove(i);

        this.saveFile(refereers);
    }

    public boolean deletAllByMatch(String id) {
        List<RefereeMatchEntity> refereers = this.findAll();

        for (int i = 0; i < refereers.size(); i++)
            if (refereers.get(i).getIdReferee().equals(id))
                refereers.remove(i);

        this.saveFile(refereers);
        return true;
    }

    public List<RefereeMatchEntity> findAllByRefereeId(String refereeId){
        return this.readFile().stream().filter(rm -> rm.getIdReferee().equals(refereeId)).toList();
    }

}
