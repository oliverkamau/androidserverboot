package com.jwt.auth.repo;

import com.jwt.auth.uw.model.SubClassDef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubClassRepo extends JpaRepository<SubClassDef,Long> {
    SubClassDef findFirstBySubDescContainsIgnoreCase(String motor_private);
}
