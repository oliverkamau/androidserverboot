package com.jwt.auth.repo;

import com.jwt.auth.uw.model.PolicyTrans;
import com.jwt.auth.uw.model.QuoteRiskTrans;
import com.jwt.auth.uw.model.QuoteTrans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRiskRepo extends JpaRepository<QuoteRiskTrans,Long> {

    List<QuoteRiskTrans> findByProductTrans_QuoteTrans(QuoteTrans code);
}
