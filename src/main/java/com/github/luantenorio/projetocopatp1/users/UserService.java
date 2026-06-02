package com.github.luantenorio.projetocopatp1.users;

import com.github.luantenorio.projetocopatp1.referee.RefereeEntity;
import com.github.luantenorio.projetocopatp1.users.UserDAO;
import com.github.luantenorio.projetocopatp1.users.UserEntity;
import com.github.luantenorio.projetocopatp1.util.PasswordHasher;
import org.mindrot.jbcrypt.BCrypt;
import java.util.List;


public class UserService {
    private UserDAO userDAO;

    public UserService(){
        this.userDAO = new UserDAO();
    }

    public UserEntity auth(String email, String password){
        List<UserEntity> allUsers= userDAO.findAll();

        for(UserEntity user: allUsers){

            if(user.getEmail().equalsIgnoreCase(email)){

                if(PasswordHasher.check(password, user.getPassword())){
                    return user;
                }
            }
        }

        return null;
    }

    public void register(UserEntity newUser){
        String password = newUser.getPassword();
        String hashedPassword = PasswordHasher.hash(password);
        newUser.setPassword(hashedPassword);
        userDAO.create(newUser);
    }

    public boolean deleteUser(String id){
        return this.userDAO.delete(id);
    }

    public boolean updateUser(UserEntity user){
        return this.userDAO.update(user);
    }

}
