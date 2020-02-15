package com.revature.repos;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CrudRepository <T> {

    T save(T newObj);
    List<T> findAll();
    T findById(Integer id);
    void update(T updatedObj);
    void deleteById(Integer id);
}
