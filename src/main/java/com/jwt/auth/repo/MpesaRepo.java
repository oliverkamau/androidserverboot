package com.jwt.auth.repo;

import com.jwt.auth.mpesa.C2BPaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MpesaRepo extends JpaRepository<C2BPaymentDetails,Long> {
}
