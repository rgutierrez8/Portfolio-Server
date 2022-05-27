package com.portfolio.server.Controllers;

import com.portfolio.server.Models.Skill;
import com.portfolio.server.Services.ISkillService;
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
@RequestMapping("/skill")
@CrossOrigin(origins = "*")
public class SkillController {
    
    @Autowired
    private ISkillService service;
    
    @Autowired
    AuthController authController;
    
    @PostMapping("/new")
    public List<Skill> newSkill(@RequestHeader(value = "Authorization") String token, @RequestBody Skill skill){
        if(authController.validateToken(token)){
            service.newSkill(skill);
        }
        
        return service.findAll();
    }
    
    @PutMapping("/update")
    public List<Skill> updateSkill(@RequestHeader(value = "Authorization") String token, @RequestBody Skill update){
        if(authController.validateToken(token)){
            service.updateSkill(update);
        }
        
        return service.findAll();
    }
    
    @DeleteMapping("/delete/{id}")
    public List<Skill> deleteSkilll(@RequestHeader(value = "Authorization") String token, @PathVariable int id){
        if(authController.validateToken(token)){
            service.deleteSkill(id);
        }
        
        return service.findAll();
    }
    
    @GetMapping("/findById/{id}")
    @ResponseBody
    public Skill findById(@PathVariable int id){
        return service.findById(id);
    }
    
    @GetMapping("/findAll")
    @ResponseBody
    public List<Skill> findAll(){
        return service.findAll();
    }
}
