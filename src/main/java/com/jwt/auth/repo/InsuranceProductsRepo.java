package com.jwt.auth.repo;

import com.jwt.auth.quotes.InsuranceQuotes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsuranceProductsRepo extends JpaRepository<InsuranceQuotes,Long> {
    List<InsuranceQuotes> findByCover(String comprehensive);

    List<InsuranceQuotes> findByCoverContainsIgnoreCase(String tpo);

    Long countByCoverContainsIgnoreCase(String cover);
}
