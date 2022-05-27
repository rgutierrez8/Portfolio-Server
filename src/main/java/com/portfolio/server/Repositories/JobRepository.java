package com.portfolio.server.Repositories;

import com.portfolio.server.Models.Job;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>{
    Optional<Job> findByCompany(String company);
}
