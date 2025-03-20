package com.aps.projectmanage.domain.repository;

import com.aps.projectmanage.domain.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Integer>  {
}
