package com.github.luantenorio.projetocopatp1.users;

public class OrganizerEntity extends UserEntity{

    public OrganizerEntity(String nome, String email, String pais, String senha, UserStatus status){
        super(nome, email, senha, pais, AccessLevel.ORGANIZER, status);
    }

}
