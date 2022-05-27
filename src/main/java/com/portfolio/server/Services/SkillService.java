package com.portfolio.server.Services;

import com.portfolio.server.Models.Skill;
import com.portfolio.server.Repositories.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{

    @Autowired
    public SkillRepository repository;
    
    @Override
    public void newSkill(Skill skill) {
        repository.save(skill);
    }

    @Override
    public void updateSkill(Skill update) {
        Skill skill = findById(update.getId());
        
        skill.setName(update.getName());
        skill.setAverage(update.getAverage());
        skill.setUrlImg(update.getUrlImg());
        
        repository.save(skill);
    }

    @Override
    public void deleteSkill(int id) {
        repository.deleteById(id);
    }

    @Override
    public Skill findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Skill> findAll() {
        return repository.findAll();
    }
    
}
