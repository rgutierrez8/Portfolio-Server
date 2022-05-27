package com.portfolio.server.Services;

import com.portfolio.server.Models.Job;
import com.portfolio.server.Repositories.JobRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService implements IJobService{
    
    @Autowired
    public JobRepository repository;

    @Override
    public void newJob(Job job) {
        repository.save(job);
    }

    @Override
    public List<Job> allJobs() {
        return repository.findAll();
    }

    @Override
    public Job findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void updateJob(Job update) {
        Job job = findById(update.getId());
        
        job.setCompany(update.getCompany());
        job.setDescription(update.getDescription());
        job.setDateStart(update.getDateStart());
        job.setDateEnd(update.getDateEnd());
        job.setUrlImg(update.getUrlImg());
        
        repository.save(job);
    }

    @Override
    public void deleteJob(int id) {
        repository.deleteById(id);
    }
    
}
