package com.aps.projectmanage.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    T create(T dto);
    Optional<T> getById(ID id);
    List<T> getAll();
    T update(T dto, ID id);
    void deleteById(ID id);
}
