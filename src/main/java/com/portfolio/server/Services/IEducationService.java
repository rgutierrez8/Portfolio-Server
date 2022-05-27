package com.portfolio.server.Services;

import com.portfolio.server.Models.Education;
import java.util.List;


public interface IEducationService {
    
    public void newEducation(Education ed);
    public void updateEducation(Education update);
    public void deleteEducation(int id);
    public Education findById(int id);
    public List<Education> findAll();
}
