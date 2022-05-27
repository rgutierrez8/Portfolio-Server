package com.portfolio.server.Services;

import com.portfolio.server.Models.Skill;
import java.util.List;


public interface ISkillService {
    
    public void newSkill(Skill skill);
    public void updateSkill(Skill update);
    public void deleteSkill(int id);
    public Skill findById(int id);
    public List<Skill> findAll();
}
