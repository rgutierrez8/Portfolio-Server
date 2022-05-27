package com.portfolio.server.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String institution;
    private String dateEnd;
    private String description;
    private String urlImg;

    public Education() {
    }

    public Education(int id, String institution, String dateEnd, String description, String urlImg) {
        this.id = id;
        this.institution = institution;
        this.dateEnd = dateEnd;
        this.description = description;
        this.urlImg = urlImg;
    }
    
    
}
