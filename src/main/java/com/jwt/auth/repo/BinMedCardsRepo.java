package com.jwt.auth.repo;

import com.jwt.auth.uw.model.AccountDef;
import com.jwt.auth.uw.model.BinderMedicalCards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinMedCardsRepo extends JpaRepository<BinderMedicalCards,Long> {
}
