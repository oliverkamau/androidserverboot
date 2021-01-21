package com.jwt.auth.repo;

import com.jwt.auth.uw.model.AccountDef;
import com.jwt.auth.uw.model.BedTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BedRepo extends JpaRepository<BedTypes,Long> {
}
