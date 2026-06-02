package com.github.luantenorio.projetocopatp1.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
    public static String hash(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean check(String password, String savedHash){
        try{
            return BCrypt.checkpw(password, savedHash);
        }catch (Exception e){
            return false;
        }
    }
}
