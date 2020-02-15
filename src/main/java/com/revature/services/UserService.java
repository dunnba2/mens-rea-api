package com.revature.services;

import com.revature.dtos.Credentials;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository repo;
    @Autowired
    public UserService(UserRepository repo) {
        this.repo=repo;
    }
    public User register(User u) {
        Role r = new Role(2, "MEMBER");
        u.setRole(r);
        repo.save(u);
        return u;
    }
    public User authenticate(Credentials c) {
        if (c==null || c.getUsername()==null || c.getUsername()=="" || c.getPassword()==null || c.getPassword()=="") {
            throw new InvalidRequestException("Invalid input.  Username and password required.");
        }
        Optional<User> oUser=repo.findByCredentials(c);
        User u=oUser.orElseThrow(AuthenticationException::new);
        return u;
    }
}