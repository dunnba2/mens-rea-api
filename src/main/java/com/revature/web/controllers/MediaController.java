package com.revature.web.controllers;

import com.revature.models.Media;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Media saveNewMedia(Media media) {
        return mediaService.saveNewMedia(media);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getAllMedia() {
        return mediaService.getAllMedia();
    }

    @GetMapping(value = "/Book", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getAllBooks() {
        String type = "BOOK";
        return mediaService.getAllMediaByType(type);
    }

    @GetMapping(value = "/Show", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getAllShows() {
        String type = "SHOW";
        return mediaService.getAllMediaByType(type);
    }

    @GetMapping(value = "/Movie", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getAllMovies() {
        String type = "MOVIE";
        return mediaService.getAllMediaByType(type);
    }

    @PostMapping(value = "/favorites", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveNewFavorite(User user, Media media) {
        mediaService.saveToFavorites(user, media);
    }

    @PostMapping(value = "/watchlist", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveToWatchlist(User user, Media media) {
        mediaService.saveToWatchlist(user, media);
    }

    @GetMapping(value = "/favorites/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getFavorites(@PathVariable int id) {
        return mediaService.getFavorites(id);
    }

    @GetMapping(value = "/watchlist/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Media> getWatchlist(@PathVariable int id) {
        return mediaService.getWatchlist(id);
    }
}
