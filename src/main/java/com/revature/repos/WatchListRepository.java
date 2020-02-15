package com.revature.repos;

import com.revature.models.Media;

import java.util.List;
import java.util.Optional;


public class WatchListRepository implements CrudRepository<Media> {
    @Override
    public Media save(Media newObj) {
        return null;
    }

    @Override
    public List<Media> findAll() {
        return null;
    }

    @Override
    public Optional<Media> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Media updatedObj) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}
