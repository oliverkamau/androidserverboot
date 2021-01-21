package com.jwt.auth.trans.repo;

import com.jwt.auth.trans.model.ReceiptTransDtls;
import com.jwt.auth.uw.model.PolicyTrans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceiptDetailsRepo extends JpaRepository<ReceiptTransDtls,Long> {

    List<ReceiptTransDtls> findByPolicy(PolicyTrans code);
}
