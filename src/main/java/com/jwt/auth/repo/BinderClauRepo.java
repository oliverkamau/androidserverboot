package com.jwt.auth.repo;

import com.jwt.auth.uw.model.AccountDef;
import com.jwt.auth.uw.model.BinderClauses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinderClauRepo extends JpaRepository<BinderClauses,Long> {
}
