package com.portfolio.server.Repositories;

import com.portfolio.server.Models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer>{
    
}
