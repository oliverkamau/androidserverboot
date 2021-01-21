package com.jwt.auth.repo;

import com.jwt.auth.uw.model.QuoteProTrans;
import com.jwt.auth.uw.model.QuoteTrans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteProRepo extends JpaRepository<QuoteProTrans,Long> {
    QuoteProTrans findByQuoteTrans(QuoteTrans p);
}
