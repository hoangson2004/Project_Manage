package com.aps.projectmanage.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    T create(T entity);
    Optional<T> getById(ID id);
    List<T> getAll();
    T update(T entity);
    void deleteById(ID id);
}
