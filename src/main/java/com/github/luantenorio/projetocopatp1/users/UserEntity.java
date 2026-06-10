package com.github.luantenorio.projetocopatp1.users;

import java.io.Serializable;
import java.util.UUID;

public abstract class UserEntity implements Serializable {
    private String id;
    private String name;
    private String email;
    private String country;
    private String password;
    private AccessLevel accessLevel;
    private UserStatus status;


    public UserEntity(String name, String email, String password, String country, AccessLevel accessLevel, UserStatus status){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.accessLevel = accessLevel;
        this.status = status;
    }

    public UserEntity(String id,String name, String email, String password, String country, AccessLevel accessLevel, UserStatus status){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.accessLevel = accessLevel;
        this.status = status;
    }



    public String getId(){return this.id;}

    public String getName(){return this.name;}

    public void setName(String name) {this.name = name;}

    public String getEmail(){return this.email;}

    public void setEmail(String email) {this.email = email;}

    public String getCountry(){return  this.country;}

    public void setCountry(String country){this.country = country;}

    public String getPassword() {return password;}

    public void setPassword(String password){this.password = password;}

    public AccessLevel getAccessLevel(){return this.accessLevel;}

    public void setAccessLevel(AccessLevel accessLevel) {this.accessLevel = accessLevel;}

    public UserStatus getStatus(){ return this.status;}

    public void setStatus(UserStatus status){this.status = status;}

}


