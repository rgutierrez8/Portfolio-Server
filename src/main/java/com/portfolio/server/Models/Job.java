package com.portfolio.server.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String company;
    private String description;
    private String dateStart;
    private String dateEnd;
    private String urlImg;

    public Job() {
    }

    public Job(int id, String company, String description, String dateStart, String dateEnd, String urlImg) {
        this.id = id;
        this.company = company;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.urlImg = urlImg;
    }
}
