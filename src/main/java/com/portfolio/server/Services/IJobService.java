package com.portfolio.server.Services;

import com.portfolio.server.Models.Job;
import java.util.List;



public interface IJobService {
    
    public void newJob(Job job);
    public List<Job> allJobs();
    public Job findById(int id);
    public void updateJob(Job update);
    public void deleteJob(int id);
}
