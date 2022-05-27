package com.portfolio.server.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;
    private String description;
    private String urlGit;
    private String urlImg;

    public Project() {
    }

    public Project(int id, String name, String description, String urlGit, String urlImg) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urlGit = urlGit;
        this.urlImg = urlImg;
    }
}
