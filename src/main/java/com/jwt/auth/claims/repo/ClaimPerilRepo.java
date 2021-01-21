package com.jwt.auth.claims.repo;

import com.jwt.auth.claims.model.ClaimBookings;
import com.jwt.auth.claims.model.ClaimPerils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimPerilRepo extends JpaRepository<ClaimPerils,Long> {
    ClaimPerils findByClaimBookings(ClaimBookings clmId);
}
