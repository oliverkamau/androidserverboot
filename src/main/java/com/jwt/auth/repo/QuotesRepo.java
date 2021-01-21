package com.jwt.auth.repo;

import com.jwt.auth.uw.model.ClientDef;
import com.jwt.auth.uw.model.ClientQuotes;
import com.jwt.auth.uw.model.QuoteTrans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotesRepo extends JpaRepository<QuoteTrans,Long> {

    List<QuoteTrans> findByClientAndQuoteIdGreaterThan(ClientDef code, long l);

    List<QuoteTrans> findByClient(ClientDef code);

    List<QuoteTrans> findByClientAndQuotStatus(ClientDef code, String a);

    QuoteTrans findByQuoteId(Long code);
}
