package com.portfolio.server.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;
    private int average;
    private String urlImg;

    public Skill() {
    }

    public Skill(int id, String name, int average, String urlImg) {
        this.id = id;
        this.name = name;
        this.average = average;
        this.urlImg = urlImg;
    }
}
