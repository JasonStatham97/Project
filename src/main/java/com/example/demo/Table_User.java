package com.example.demo;

import javax.persistence.*;


@Entity
@Table(name= "user")
public class Table_User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int ID;
    private String name;
    private String password;
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
