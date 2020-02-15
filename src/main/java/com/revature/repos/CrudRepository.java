package com.revature.repos;

import java.util.List;
import java.util.Optional;


public interface CrudRepository <T> {

    T save(T newObj);
    List<T> findAll();
    Optional<T> findById(Integer id);
    Boolean update(T updatedObj);
    Boolean deleteById(Integer id);
}
