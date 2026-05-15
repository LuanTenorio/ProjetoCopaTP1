package com.github.luantenorio.projetocopatp1.users;

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

    public boolean update(UserEntity entity) {return false;}


    public boolean delete(String id) {
        return false;
    }


}
