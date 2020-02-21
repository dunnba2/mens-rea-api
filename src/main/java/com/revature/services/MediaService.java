package com.revature.services;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Media;
import com.revature.models.MediaTypes;
import com.revature.models.User;
import com.revature.repos.MediaRepository;
import com.revature.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MediaService {

    private MediaRepository mediaRepo;
    private UserRepository userRepo;

    @Autowired
    public MediaService(MediaRepository repo, UserRepository userRepo) {
        super();
        this.mediaRepo = repo;
        this.userRepo = userRepo;
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
        try {
            return mediaRepo.findAllByTypeAndSearch(search, type);
        }catch (Exception e) {
            throw new ResourceNotFoundException("Could not find any media by that search");
        }

    }
}
