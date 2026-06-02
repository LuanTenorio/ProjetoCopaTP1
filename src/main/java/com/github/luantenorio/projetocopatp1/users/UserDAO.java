package com.github.luantenorio.projetocopatp1.users;

import com.github.luantenorio.projetocopatp1.referee.RefereeEntity;
import com.github.luantenorio.projetocopatp1.refereeMatch.RefereeMatchDAO;
import com.github.luantenorio.projetocopatp1.users.UserEntity;
import com.github.luantenorio.projetocopatp1.util.DAO;

import java.util.List;

public class UserDAO extends DAO<UserEntity>{

    public UserDAO(){super("users.bin");}

    public UserEntity create(UserEntity entity){
        List<UserEntity> users = this.readFile();

        users.add(entity);
        saveFile(users);

        return entity;
    }

    public List<UserEntity> findAll() {
        return this.readFile();
    }

    public UserEntity findById(String id) {
        List<UserEntity> users = this.readFile();

        return users.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }



    public boolean update(UserEntity entity) {
        List<UserEntity> users = this.findAll();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(entity.getId())) {
                users.set(i, entity);
                this.saveFile(users);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String id) {
        List<UserEntity> users = this.findAll();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.remove(i);
                this.saveFile(users);
                return true;
            }
        }

        return false;
    }


}
