package com.portfolio.server.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String phone;
    private String title;
    private String description;
    private String address;
    private String urlImg;
    private String banner;

    public User() {
    }

    public User(int id, String name, String lastName, String email, String username, String password, String phone, String title, String description, String address, String urlImg, String banner) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.title = title;
        this.description = description;
        this.address = address;
        this.urlImg = urlImg;
        this.banner = banner;
    }    
}
