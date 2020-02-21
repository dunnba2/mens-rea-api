package com.revature.services;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.WatchList;
import com.revature.repos.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WatchlistService {

    private WatchlistRepository watchRepo;

    @Autowired
    public WatchlistService(WatchlistRepository watchlistRepository) {
        super();
        this.watchRepo = watchlistRepository;
    }

    @Transactional
    public WatchList saveNewWatchlist(WatchList list) {
        return watchRepo.save(list);
    }

    @Transactional
    public List<WatchList> getWatchlist(int id) {
        try {
            return watchRepo.findWatchlistById(id);
        }catch (Exception e) {
            throw new ResourceNotFoundException("There is no watchlist for this user");
        }
    }
}
