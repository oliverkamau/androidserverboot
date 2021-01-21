package com.jwt.auth.claims.repo;

import com.jwt.auth.claims.model.ClaimBookings;
import com.jwt.auth.uw.model.PolicyTrans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClaimBookingRepo extends JpaRepository<ClaimBookings,Long> {


    List<ClaimBookings> findByRisk_Policy(PolicyTrans code);
}
