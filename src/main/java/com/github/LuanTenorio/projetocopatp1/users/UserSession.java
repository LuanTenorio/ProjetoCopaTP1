package com.github.luantenorio.projetocopatp1.users;

public class UserSession {
    //instancia a sessao na memória do aplicativo
    private static UserSession instance;
    //objeto de usuário que está logado
    private UserEntity loggedUser;

    private UserSession(){}

    public static UserSession getInstance(){
        if(instance == null){
            instance = new UserSession();
        }
        return instance;
    }


    public UserEntity getLoggedUser(){
        return loggedUser;
    }

    public void setLoggedUser(UserEntity loggedUser){this.loggedUser = loggedUser;}

    public void loggout(){
        this.loggedUser = null;
    }

    public boolean isLoggedIn(){
        return loggedUser != null;
    }
}
