package com.portfolio.server.Controllers;

import com.portfolio.server.Models.Education;
import com.portfolio.server.Services.IEducationService;
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
@RequestMapping("/education")
@CrossOrigin(origins = "*")
public class EducationController {
    
    @Autowired
    private IEducationService service;
    
    @Autowired
    AuthController authController;
    
    @PostMapping("/new")
    public List<Education> newEducation(@RequestHeader(value = "Authorization") String token, @RequestBody Education ed){
        if(authController.validateToken(token)){
            service.newEducation(ed);
        }
        
        return service.findAll();
    }
    
    @PutMapping("/update")
    public Education updateEducation(@RequestHeader(value = "Authorization") String token, @RequestBody Education ed){
        if(authController.validateToken(token)){
            service.updateEducation(ed);
        }
        
        return service.findById(ed.getId());
    }
    
    @DeleteMapping("/delete/{id}")
    public List<Education> deleteEducation(@RequestHeader(value = "Authorization") String token, @PathVariable int id){
        if(authController.validateToken(token)){
            service.deleteEducation(id);
        }
        
        return service.findAll();
    }
    
    @GetMapping("/findById/{id}")
    @ResponseBody
    public Education findById(@PathVariable int id){
        return service.findById(id);
    }
    
    @GetMapping("/findAll")
    @ResponseBody
    public List<Education> findAll(){
        return service.findAll();
    }
}
