package com.jwt.auth.repo;

import com.jwt.auth.uw.model.ClientDef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<ClientDef,Long> {
    ClientDef findByTenId(Long code);
}
