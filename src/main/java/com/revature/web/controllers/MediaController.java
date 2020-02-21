package com.revature.web.controllers;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Media;
import com.revature.models.MediaTypes;
import com.revature.models.User;
import com.revature.services.MediaService;
import com.revature.web.dtos.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/media")
public class MediaController {

    private MediaService mediaService;

    @Autowired
    public MediaController(MediaService service) {
        super();
        this.mediaService = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Media saveNewMedia(@RequestBody Media media) {
        return mediaService.saveNewMedia(media);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getAllMedia() {
        return mediaService.getAllMedia();
    }

    @GetMapping(value = "/Book", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getAllBooks() {
        MediaTypes type = MediaTypes.BOOK;
        return mediaService.getAllMediaByType(type);
    }

    @GetMapping(value = "/{search}/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getAllBySearchAndType(@PathVariable("search") String search, @PathVariable("type") String mediaType) {
        MediaTypes type;
        switch(mediaType) {
            case "Book":
                type = MediaTypes.BOOK;
                break;
            case "Movie":
                type = MediaTypes.MOVIE;
                break;
            default:
                type = MediaTypes.SHOW;
                break;
        }
        return mediaService.getAllByTypeAndSearch(search, type);
    }

    @GetMapping(value = "/Show", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getAllShows() {
        MediaTypes type = MediaTypes.SHOW;
        return mediaService.getAllMediaByType(type);
    }

    @GetMapping(value = "/Movie", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getAllMovies() {
        MediaTypes type = MediaTypes.MOVIE;
        return mediaService.getAllMediaByType(type);
    }

    @PostMapping(value = "/favorites/{id}/{mediaId}")
    public void saveNewFavorite(@PathVariable("id") int id, @PathVariable("mediaId") int mediaId) {

        mediaService.saveToFavorites(id, mediaId);
    }
    //changes

    @PostMapping(value = "/watchlist/{id}/{mediaId}")
    public void saveToWatchlist(@PathVariable("id") int id, @PathVariable("mediaId") int mediaId) {
        mediaService.saveToWatchlist(id, mediaId);
    }

    @GetMapping(value = "/favorites/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getFavorites(@PathVariable("id") int id) {
        return mediaService.getFavorites(id);
    }

    @GetMapping(value = "/watchlist/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getWatchlist(@PathVariable("id") int id) {
        return mediaService.getWatchlist(id);
    }

    /* the deletion implementation might need some adjustments */
    @GetMapping(value = "/removefav", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteFromFavorites (@RequestBody User user, Media media) {
        mediaService.deleteFromFavorites(user, media);
    }

    @GetMapping(value = "/removewatch", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteFromWatchlist (@RequestBody User user, Media media) {
        mediaService.deleteFromWatchlist(user, media);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidRequestException(InvalidRequestException e) {

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