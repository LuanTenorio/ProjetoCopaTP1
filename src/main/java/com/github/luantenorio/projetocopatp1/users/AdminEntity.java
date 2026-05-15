package com.github.luantenorio.projetocopatp1.users;

public class AdminEntity extends UserEntity {

    public AdminEntity(String nome, String email, String pais, String senha, UserStatus status) {
        super(nome, email, senha, pais, AccessLevel.ADMIN, status);
    }

}
