package com.portfolio.server.Controllers;

import com.portfolio.server.Models.User;
import com.portfolio.server.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.server.Services.IUserService;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController 
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private IUserService service;
    
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private AuthController authController;
    
    @GetMapping("/loadData")
    public void loadData(){
        service.loadData();
    }
    
    @GetMapping("/view")
    @ResponseBody
    public User viewUser(){
        return service.getData(1);
    }
    
    @PutMapping("/update")
    public User updateUser(@RequestHeader(value = "Authorization") String token, @RequestBody User pers){
        if(authController.validateToken(token)){
            service.updateData(pers);
        }
        //service.updateData(pers);
        User user = service.findByUsername(pers.getUsername()).get();
        
        return user;
        
    }
    
    @GetMapping("/findByUsername/{username}")
    @ResponseBody
    public Optional<User> findByUsername(@PathVariable String username){
        return repository.findByUsername(username);
    }
}
