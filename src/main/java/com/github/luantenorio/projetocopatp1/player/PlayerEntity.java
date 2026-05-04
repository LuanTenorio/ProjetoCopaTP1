package com.github.luantenorio.projetocopatp1.player;

import java.io.Serializable;
import java.util.UUID;

public class PlayerEntity implements Serializable {
    private String id;
    private String name;
    private String pos;
    private int num;
    private int age;
    private PlayerStatus status;
//    String teamId;

    public PlayerEntity(String name, String pos, int num, int age, PlayerStatus status) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.pos = pos;
        this.num = num;
        this.age = age;
        this.status = status;
    }

    public PlayerEntity(String id, String name, String pos, int num, int age, PlayerStatus status) {
        this.id = id;
        this.name = name;
        this.pos = pos;
        this.num = num;
        this.age = age;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }
}
