package com.portfolio.server.Services;

import com.portfolio.server.Models.Education;
import com.portfolio.server.Repositories.EducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService{

    @Autowired
    public EducationRepository repository;
    
    @Override
    public void newEducation(Education ed) {
        repository.save(ed);
    }

    @Override
    public void updateEducation(Education update) {
        Education ed = findById(update.getId());
        
        ed.setInstitution(update.getInstitution());
        ed.setDateEnd(update.getDateEnd());
        ed.setDescription(update.getDescription());
        ed.setUrlImg(update.getUrlImg());
        
        repository.save(ed);
    }

    @Override
    public void deleteEducation(int id) {
        repository.deleteById(id);
    }

    @Override
    public Education findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Education> findAll() {
        return repository.findAll();
    }
    
}
