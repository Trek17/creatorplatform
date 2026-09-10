package com.trek.creatorplatform.user;

import com.trek.creatorplatform.user.dto.CreateUserRequest;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    boolean existsByEmail(String requestEmail);
    boolean existsByUsername(String requestUsername);
}
