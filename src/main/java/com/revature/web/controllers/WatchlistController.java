package com.revature.web.controllers;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.WatchList;
import com.revature.services.WatchlistService;
import com.revature.web.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    private WatchlistService watchService;

    public WatchlistController(WatchlistService watchlistService) {
        super();
        this.watchService = watchlistService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public WatchList saveNewWatch(@RequestBody WatchList list) {
        return watchService.saveNewWatchlist(list);
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WatchList> getWatchById(@PathVariable("id") String id) {
        int newId = Integer.parseInt(id);
        return watchService.getWatchlist(newId);
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
