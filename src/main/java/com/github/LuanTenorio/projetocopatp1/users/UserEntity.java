package com.github.luantenorio.projetocopatp1.users;

import java.io.Serializable;
import java.util.UUID;

public abstract class UserEntity implements Serializable {
    private String id;
    private String nome;
    private String email;
    private String senha;
    private AccessLevel accessLevel;

    public UserEntity(String nome, String email, String senha, AccessLevel accessLevel){
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.accessLevel = accessLevel;
    }

    public UserEntity(String id,String nome, String email, String senha, AccessLevel accessLevel){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.accessLevel = accessLevel;
    }



    public String getId(){return this.id;}

    public String getNome(){return this.nome;}

    public String getEmail(){return this.email;}

    public String getSenha() {return senha;}

    public AccessLevel getAccessLevel(){return this.accessLevel;}

    public void setId(String id){this.id = id;}

    public void setNome(String nome) {this.nome = nome;}

    public void setEmail(String email) {this.email = email;}

    public void setAccessLevel(AccessLevel accessLevel) {this.accessLevel = accessLevel;}

}


