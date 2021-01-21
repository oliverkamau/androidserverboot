package com.jwt.auth.repo;

import com.jwt.auth.uw.model.AccountDef;
import com.jwt.auth.uw.model.BinderDetails;
import com.jwt.auth.uw.model.BindersDef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinDerRepo extends JpaRepository<BinderDetails,Long> {
    BinderDetails findByBinder(BindersDef def);

    BinderDetails findFirstByBinder(BindersDef def);
}
