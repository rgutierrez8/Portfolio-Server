package com.portfolio.server.Controllers;

import com.portfolio.server.Models.Project;
import com.portfolio.server.Services.IProjectService;
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
@RequestMapping("/project")
@CrossOrigin(origins = "*")
public class ProjectController {
    
    @Autowired
    private IProjectService service;
    
    @Autowired
    AuthController authController;
    
    @PostMapping("/new")
    public List<Project> newProject(@RequestHeader(value = "Authorization") String token, @RequestBody Project pro){
        if(authController.validateToken(token)){
            service.createProject(pro);
        }
        
        return service.findAll();
    }
    
    @PutMapping("/update")
    public Project updateProject(@RequestHeader(value = "Authorization") String token, @RequestBody Project update){
        if(authController.validateToken(token)){
            service.updateProject(update);
        }
        
        return service.findById(update.getId());
    }
    
    @DeleteMapping("/delete/{id}")
    public List<Project> deleteProject(@RequestHeader(value = "Authorization") String token, @PathVariable int id){
        if(authController.validateToken(token)){
            service.deleteProject(id);
        }
        
        return service.findAll();
    }
    
    @GetMapping("/findById/{id}")
    @ResponseBody
    public Project findById(@PathVariable int id){
        return service.findById(id);
    }
    
    @GetMapping("/findAll")
    @ResponseBody
    public List<Project> findAll(){
        return service.findAll();
    }
}
