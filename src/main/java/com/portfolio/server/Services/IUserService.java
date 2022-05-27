package com.portfolio.server.Services;

import com.portfolio.server.Models.Dto.UserDto;
import com.portfolio.server.Models.User;
import java.util.Optional;

public interface IUserService {
    
    public String EncryptPass(String password);
    public void create(User user);
    public void loadData();
    public User getData(int id);
    public void updateData(User update);
    public Optional<User> findByUsername(String username);
    public User validateCredentials(UserDto userDto);
}
