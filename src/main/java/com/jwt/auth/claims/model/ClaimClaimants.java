package com.jwt.auth.claims.model;

import com.jwt.auth.uw.model.ClientDef;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sys_brk_clm_claimants")
public class ClaimClaimants {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clm_clmnt_id")
    private Long claimantId;

    @Column(name = "clm_clmnt_tp",nullable = false)
    private String thirdParty;

    @Column(name = "clm_clmnt_status")
    private String claimantStatus;

    @ManyToOne
    @JoinColumn(name="clm_clmnt_clm_id",nullable=false)
    private ClaimBookings claimBookings;

    @ManyToOne
    @JoinColumn(name="clm_clmnt_client_id")
    private ClientDef client;

    @ManyToOne
    @JoinColumn(name="clm_clmnt_clmnt_id")
    private ClaimantsDef claimant;

    @Column(name = "clm_clmnt_amount")
    private BigDecimal claimAmount;

    @Column(name = "clm_paid_amount")
    private BigDecimal claimPaidAmount;

    public Long getClaimantId() {
        return claimantId;
    }

    public void setClaimantId(Long claimantId) {
        this.claimantId = claimantId;
    }

    public String getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
    }

    public String getClaimantStatus() {
        return claimantStatus;
    }

    public void setClaimantStatus(String claimantStatus) {
        this.claimantStatus = claimantStatus;
    }

    public ClaimBookings getClaimBookings() {
        return claimBookings;
    }

    public void setClaimBookings(ClaimBookings claimBookings) {
        this.claimBookings = claimBookings;
    }

    public ClientDef getClient() {
        return client;
    }

    public void setClient(ClientDef client) {
        this.client = client;
    }

    public ClaimantsDef getClaimant() {
        return claimant;
    }

    public void setClaimant(ClaimantsDef claimant) {
        this.claimant = claimant;
    }

    public BigDecimal getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(BigDecimal claimAmount) {
        this.claimAmount = claimAmount;
    }

    public BigDecimal getClaimPaidAmount() {
        return claimPaidAmount;
    }

    public void setClaimPaidAmount(BigDecimal claimPaidAmount) {
        this.claimPaidAmount = claimPaidAmount;
    }
}
