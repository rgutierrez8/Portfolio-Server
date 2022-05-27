package com.portfolio.server.Repositories;

import com.portfolio.server.Models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);
}
