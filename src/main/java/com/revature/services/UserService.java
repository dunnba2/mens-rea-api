package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.web.dtos.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public User register(User user) {
        try {
            user.setRole(Role.MEMBER);
            repo.save(user);
            return user;
        }catch (Exception e) {
            throw new InvalidRequestException("Username is already taken");
        }

    }

    @Transactional
    public User authenticate(Credentials creds) {
        try {
            return repo.findByCredentials(creds);
        }catch(Exception e) {
            throw new AuthenticationException(e.getMessage());
        }
    }
}