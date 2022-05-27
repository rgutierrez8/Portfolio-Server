package com.portfolio.server.Services;

import com.portfolio.server.Models.Dto.UserDto;
import com.portfolio.server.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.server.Repositories.UserRepository;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    public UserRepository repository;
    
    
    @Override
    public void loadData() {
        if(getData(1) == null){
            User user = new User();
            
            user.setName("Ramón");
            user.setLastName("Gutierrez");
            user.setEmail("ramongutierrez523@gmail.com");
            user.setUsername("winnions");
            user.setPassword(EncryptPass("123456")); //Password == 123456
            user.setPhone("+5493865348279");
            user.setTitle("Full Stack Web Developer");
            user.setDescription("Técnico en desarrollo de software | Desarrollador web autodidacta, proactivo, fácil adaptación, con ganas de seguir aprendiendo y mejorando mis skills");
            user.setAddress("Concepción - Tucumán");
            user.setUrlImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5EMR4jMOgBDIwMpHE3lVxAh99JGBcyg6uxHj2zUCCEtMmCFp5zfaZVPRqYyYW6gDolts&usqp=CAU");
            user.setBanner("https://idimad360.com/wp-content/uploads/2021/08/Inteligencia-Artificial-Programadores-del-futuro-Idimad-360.jpg");
            
            repository.save(user);
        }
    }
    
    public void create(User user){
        repository.save(user);
    }
    
    @Override
    public User getData(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void updateData( User update) {
        User user = findByUsername(update.getUsername()).get();

        
        user.setName(update.getName());
        user.setLastName(update.getLastName());
        user.setEmail(update.getEmail());
        user.setUsername(update.getUsername());
        user.setPassword(update.getPassword());
        user.setPhone(update.getPhone());
        user.setTitle(update.getTitle());
        user.setDescription(update.getDescription());
        user.setAddress(update.getAddress());
        user.setUrlImg(update.getUrlImg());
        user.setBanner(update.getBanner());
        
        repository.save(user);
    }  

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User validateCredentials(UserDto userDto) {
        User user = findByUsername(userDto.getUsername()).get();
        

        if(user.getUsername() == ""){

            return null;
        }
        
        if(!EncryptPass(userDto.getPassword()).equals(user.getPassword())){
            return null;
        }

        return user;       
    }

    @Override
    public String EncryptPass(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
            }
            return hashtext;
        }catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
