package com.jwt.auth.repo;

import com.jwt.auth.uw.model.AccountDef;
import com.jwt.auth.uw.model.Banks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanksRepo extends JpaRepository<Banks,Long> {
}
