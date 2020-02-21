package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Media;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.web.dtos.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public User register(User user) {

            user.setRole(Role.MEMBER);
            repo.save(user);
            return user;
    }

    @Transactional
    public User authenticate(Credentials creds) {
        try {
            return repo.findByCredentials(creds);
        }catch(Exception e) {
            throw new AuthenticationException(e.getMessage());
        }
    }

    @Transactional
    public List<User> getAllUsers(){
        return repo.findAll();
    }

    @Transactional
    public List<Media> getFavorites(int id) {
        try {
            List<Media> favs = new ArrayList<>();
            User user = repo.findById(id);
            favs = user.getFavorites();
            return favs;
        }catch(Exception e) {
            throw new ResourceNotFoundException("There are no favorites for this user");
        }
    }

    @Transactional
    public List<Media> getWatchlist(int id) {
        try {
            List<Media> watchList = new ArrayList<>();
            User user = repo.findById(id);
            watchList = user.getWatchList();
            return watchList;
        }catch(Exception e) {
            throw new ResourceNotFoundException("There is no watchlist for this user");
        }
    }
}