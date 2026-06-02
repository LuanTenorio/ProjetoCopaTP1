package com.github.luantenorio.projetocopatp1.users;

public class RefereeUserEntity extends UserEntity{
    private String experience;

    public RefereeUserEntity(String nome, String email, String pais, String senha, UserStatus status){
        super(nome, email, pais, senha, AccessLevel.REFEREE, status);
    }

    public String getExperience(){
        return this.experience;
    }

    public void setExperience(String experience){
        this.experience = experience;
    }
}
