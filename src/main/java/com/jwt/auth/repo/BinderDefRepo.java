package com.jwt.auth.repo;

import com.jwt.auth.uw.model.BindersDef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinderDefRepo extends JpaRepository<BindersDef,Long> {
    BindersDef findByBinNameContainsIgnoreCase(String binder);
}
