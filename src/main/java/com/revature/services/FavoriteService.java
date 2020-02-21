package com.revature.services;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Favorite;
import com.revature.models.Media;
import com.revature.repos.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FavoriteService {

    private FavoriteRepository favRepo;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        super();
        this.favRepo = favoriteRepository;
    }

    @Transactional
    public Favorite saveNewFavorite(Favorite fav) {
        return favRepo.save(fav);
    }

    @Transactional
    public List<Favorite> getFavorites(int id) {
        try {
            return favRepo.findFavoritesById(id);
        }catch (Exception e){
            throw new ResourceNotFoundException("There are no favorites for this user");
        }
    }

    @Transactional
    public List<Favorite> getAll() {
        return favRepo.findAll();
    }
}
