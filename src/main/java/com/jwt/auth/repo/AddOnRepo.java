package com.jwt.auth.repo;

import com.jwt.auth.quotes.AddOns;
import com.jwt.auth.quotes.InsuranceQuotes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddOnRepo extends JpaRepository<AddOns,Long> {
    List<AddOns> findByInsuranceQuotes(InsuranceQuotes p);
}
