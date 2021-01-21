package com.jwt.auth.repo;

import com.jwt.auth.uw.model.AccountDef;
import com.jwt.auth.uw.model.BankBranches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankBranchesRepo extends JpaRepository<BankBranches,Long> {
}
