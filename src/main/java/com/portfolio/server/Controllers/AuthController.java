package com.portfolio.server.Controllers;

import com.portfolio.server.Models.Dto.JwtDto;
import com.portfolio.server.Models.Dto.UserDto;
import com.portfolio.server.Models.User;
import com.portfolio.server.Services.UserService;
import com.portfolio.server.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    JwtUtil jwtUtil;
    
    @PostMapping("/login")
    public JwtDto login(@RequestBody UserDto userDto){
        JwtDto jwt = new JwtDto();
        
        User user = userService.validateCredentials(userDto);

        if(user != null){
            String token = jwtUtil.create(String.valueOf(user.getId()), user.getUsername());            
            
            jwt.setAccessToken(token);
            jwt.setUsername(user.getUsername());
            
            return jwt;
        }
        
        return null;
    }
    
    public boolean validateToken(String token){
        String userId = jwtUtil.getKey(token);
        return userId != null;
    }
}
