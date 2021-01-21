package com.jwt.auth.repo;

import com.jwt.auth.uw.model.ClientDef;
import com.jwt.auth.uw.model.PolicyTrans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyRepo extends JpaRepository<PolicyTrans,Long> {



    PolicyTrans findByPolicyId(Long code);


    List<PolicyTrans> findByClientAndAuthStatus(ClientDef code, String a);
}
