package com.revature.services;



import com.revature.models.FavBook;
import com.revature.models.mediatypes.Book;
import com.revature.repos.FavBookRepository;

import java.util.Set;

public class FavBookService {

    private FavBookRepository favRepo;

    public FavBookService(FavBookRepository repo){
        super();
        this.favRepo = repo;
    }

    public void validate(FavBook newUser){
        String userId = newUser.getOwner().getUserId();
        // ensures that the user is logged in? Or has an ID
        if(userId == null || userId.equals("")){
            // output something
        }else{
            favRepo.findAllByUserId(userId);
        }
    }

    public void addFavorite(Book newObj){
        favRepo.save(newObj);
    }

    public void removeFavorite(Book newObj){
        favRepo.delete(newObj);
    }

    public void removeList(Set<Book> books){
        favRepo.deleteAll(books);
    }

}