package com.revature.web.controllers;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Media;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.web.dtos.ErrorResponse;
import com.revature.web.dtos.MediaList;
import com.revature.web.dtos.Principal;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService service) {
        super();
        this.userService = service;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Principal> getAll() {
        List<User> users = userService.getAllUsers();
        List<Principal> principals = new ArrayList<>();
        users.forEach(u -> principals.add(u.extractPrincipal()));
        return principals;
    }

    @GetMapping(value ="/favorites/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MediaList> getFavorites(@PathVariable("id") int id) {
        List<Media> media = userService.getFavorites(id);
        List<MediaList> favorites = new ArrayList<>();
        media.forEach(m -> favorites.add(m.extractMediaList()));
        return favorites;
    }

    @GetMapping(value="/watchlist/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MediaList> getWatchlist(@PathVariable("id") int id) {
        List<Media> media = userService.getWatchlist(id);
        List<MediaList> watchList = new ArrayList<>();
        media.forEach(m -> watchList.add(m.extractMediaList()));
        return watchList;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException e) {

        ErrorResponse err = new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setTimestamp(System.currentTimeMillis());
        err.setStatus(400);
        return err;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException e) {

        ErrorResponse err = new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setTimestamp(System.currentTimeMillis());
        err.setStatus(400);
        return err;
    }
}
