package com.jwt.auth.repo;

import com.jwt.auth.uw.model.AccountDef;
import com.jwt.auth.uw.model.AccountsDocs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDocRepo extends JpaRepository<AccountsDocs,Long> {
}
