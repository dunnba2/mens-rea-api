package com.revature.web.controllers;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Favorite;
import com.revature.services.FavoriteService;
import com.revature.web.dtos.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    private FavoriteService favService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        super();
        this.favService = favoriteService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Favorite saveNewFav(@RequestBody Favorite fav) {
        return favService.saveNewFavorite(fav);
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Favorite> getFavsById(@PathVariable("id") String id) {
        int newId = Integer.parseInt(id);
        return favService.getFavorites(newId);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Favorite> getAll() {
        return favService.getAll();
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
