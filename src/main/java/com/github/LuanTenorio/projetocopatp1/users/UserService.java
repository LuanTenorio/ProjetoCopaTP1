package com.github.luantenorio.projetocopatp1.users;

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

}
