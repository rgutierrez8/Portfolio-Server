package com.portfolio.server.Repositories;

import com.portfolio.server.Models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{
    
}
