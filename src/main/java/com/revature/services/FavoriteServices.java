package com.revature.services;

import com.revature.models.Favorite;
import com.revature.models.Media;
import com.revature.repos.FavoriteRepository;

import java.util.Set;

public class FavoriteServices {

    private FavoriteRepository favRepo;

    public FavoriteServices(FavoriteRepository repo){
        super();
        this.favRepo = repo;
    }

    public void validate(Favorite newUser){
        String userId = newUser.getOwner().getUserId();
        // ensures that the user is logged in?
        if(userId == null || userId.equals("")){
            // output something
        }else{
            favRepo.findAllByUserId(userId);
        }
    }

    public void addFavorite(Media newMedia){
        favRepo.save(newMedia);
    }

    public void removeFavorite(Media newMedia){
        favRepo.delete(newMedia);
    }

    public void removeList(Set<Media> medias){
        favRepo.deleteAll(medias);
    }
}
