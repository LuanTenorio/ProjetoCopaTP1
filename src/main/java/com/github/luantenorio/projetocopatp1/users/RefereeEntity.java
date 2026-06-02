package com.github.luantenorio.projetocopatp1.users;

public class RefereeEntity extends UserEntity{
    private String experience;

    public RefereeEntity(String nome, String email, String pais, String senha, UserStatus status){
        super(nome, email, pais, senha, AccessLevel.REFEREE, status);
    }

    public String getExperience(){
        return this.experience;
    }

    public void setExperience(String experience){
        this.experience = experience;
    }
}
