package com.jwt.auth.repo;

import com.jwt.auth.model.User;
import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);


    User findByUserId(Long clientId);
}
