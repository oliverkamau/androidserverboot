package com.jwt.auth.repo;

import com.jwt.auth.uw.model.CoverTypesDef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CovertypesRepo extends JpaRepository<CoverTypesDef,Long> {
    CoverTypesDef findByCovNameContainsIgnoreCase(String cover);

    CoverTypesDef findFirstByCovNameContainsIgnoreCase(String cover);
}
