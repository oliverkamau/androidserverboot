package com.jwt.auth.repo;

import com.jwt.auth.uw.model.AccountDef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<AccountDef,Long> {
    AccountDef findByShtDescContainsIgnoreCase(String company);
}
