package com.jwt.auth.repo;

import com.jwt.auth.uw.model.AccountDef;
import com.jwt.auth.uw.model.AccountTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypesRepo extends JpaRepository<AccountTypes,Long> {
}
