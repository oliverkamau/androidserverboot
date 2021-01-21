package com.jwt.auth.repo;

import com.jwt.auth.uw.model.PolicyTrans;
import com.jwt.auth.uw.model.RiskTrans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiskTransRepo extends JpaRepository<RiskTrans,Long> {
    List<RiskTrans> findByPolicy(PolicyTrans code);
}
