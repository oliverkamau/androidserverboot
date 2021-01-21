package com.jwt.auth.repo;

import com.jwt.auth.quotes.RisksCovered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RisksCoveredRepo extends JpaRepository<RisksCovered,Long> {
}
