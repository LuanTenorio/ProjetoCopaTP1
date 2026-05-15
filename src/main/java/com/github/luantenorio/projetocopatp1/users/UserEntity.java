package com.github.luantenorio.projetocopatp1.users;

import java.io.Serializable;
import java.util.UUID;

public abstract class UserEntity implements Serializable {
    private String id;
    private String nome;
    private String email;
    private String country;
    private String senha;
    private AccessLevel accessLevel;
    private UserStatus status;


    public UserEntity(String nome, String email, String senha, String country, AccessLevel accessLevel, UserStatus status){
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.country = country;
        this.accessLevel = accessLevel;
        this.status = status;
    }

    public UserEntity(String id,String nome, String email, String senha, String country, AccessLevel accessLevel, UserStatus status){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.country = country;
        this.accessLevel = accessLevel;
        this.status = status;
    }



    public String getId(){return this.id;}

    public String getNome(){return this.nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getEmail(){return this.email;}

    public void setEmail(String email) {this.email = email;}

    public String getSenha() {return senha;}

    public AccessLevel getAccessLevel(){return this.accessLevel;}

    public void setAccessLevel(AccessLevel accessLevel) {this.accessLevel = accessLevel;}

    public UserStatus getStatus(){ return this.status;}

    public void setStatus(UserStatus status){this.status = status;}

}


