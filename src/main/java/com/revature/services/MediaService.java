package com.revature.services;

import com.revature.models.Media;
import com.revature.models.MediaTypes;
import com.revature.models.User;
import com.revature.repos.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MediaService {

    private MediaRepository mediaRepo;

    @Autowired
    public MediaService(MediaRepository repo) {
        super();
        this.mediaRepo = repo;
    }

    @Transactional
    public Media saveNewMedia(Media media) {
        return mediaRepo.save(media);
    }

    @Transactional
    public List<Media> getAllMedia() {
        return mediaRepo.findAll();
    }

    @Transactional
    public List<Media> getAllMediaByType(MediaTypes type) {
        return mediaRepo.findAllByType(type);
    }

    @Transactional
    public List<Media> getAllByTypeAndSearch(String search, MediaTypes type) {
        return mediaRepo.findAllByTypeAndSearch(search, type);
    }

    @Transactional
    public void saveToFavorites(User user, Media media) {
        mediaRepo.saveToFavorites(user, media);
    }

    @Transactional
    public void saveToWatchlist(User user, Media media) {
        mediaRepo.saveToWatchlist(user, media);
    }

    @Transactional
    public List<Media> getFavorites(int id) {
        return mediaRepo.findFavorites(id);
    }

    @Transactional
    public List<Media> getWatchlist(int id) {
        return mediaRepo.findWatchlist(id);
    }

    @Transactional
    public List<Media> deleteFromFavorites(User user, Media media){
        return mediaRepo.removeFromFavorites(user, media);
    }

    @Transactional
    public List<Media> deleteFromWatchlist(User user, Media media){
        return mediaRepo.removeFromWatchList(user, media);
    }
}
