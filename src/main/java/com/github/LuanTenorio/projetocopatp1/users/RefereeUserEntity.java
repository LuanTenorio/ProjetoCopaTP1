package com.github.luantenorio.projetocopatp1.users;

public class RefereeUserEntity extends UserEntity{
    private String experience;

    public RefereeUserEntity(String nome, String email, String country, String password, UserStatus status, String experience){
        super(nome, email, password, country, AccessLevel.REFEREE, status);
        this.experience=experience;
    }

    public String getExperience(){
        return this.experience;
    }

    public void setExperience(String experience){
        this.experience = experience;
    }
}
