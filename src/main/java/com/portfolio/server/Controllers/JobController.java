package com.portfolio.server.Controllers;

import com.portfolio.server.Models.Job;
import com.portfolio.server.Repositories.JobRepository;
import com.portfolio.server.Services.IJobService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = "*")
public class JobController {
    
    @Autowired
    private IJobService service;
    
    @Autowired
    private JobRepository repository;
    
    @Autowired
    private AuthController authController;
    
    @PostMapping("/new")
    public List<Job> newJob(@RequestHeader(value = "Authorization") String token, @RequestBody Job job){
        if(authController.validateToken(token)){
            service.newJob(job);
        }
        
        return repository.findAll();
    }
    
    @PutMapping("/update")
    public Job updateJob(@RequestHeader(value = "Authorization") String token, @RequestBody Job update){
        
        if(authController.validateToken(token)){
            service.updateJob(update);
        }
        
        Job job = service.findById(update.getId());
        
        return job;
    }
    
    @DeleteMapping("/delete/{id}")
    public List<Job> deleteJob(@RequestHeader(value = "Authorization") String token, @PathVariable int id){
        if(authController.validateToken(token)){
            service.deleteJob(id);
        }
        
        return service.allJobs();
    }
    
    @GetMapping("/find/{id}")
    @ResponseBody
    public Job findById(@PathVariable int id){
        return service.findById(id);
    }
    
    @GetMapping("findAll")
    @ResponseBody
    public List<Job> findAll(){
        return service.allJobs();
    }
}
