package com.jwt.auth.claims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jwt.auth.model.User;
import com.jwt.auth.uw.model.RiskTrans;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sys_brk_clm_bookings")
public class ClaimBookings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clm_id")
    private Long clmId;

    @Column(name = "clm_no",unique = true,nullable = false)
    private String claimNo;

    @Column(name = "clm_date",nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date clmDate;

    @Column(name = "clm_loss_date",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lossDate;

    @ManyToOne
    @JoinColumn(name="clm_risk_id",nullable=false)
    private RiskTrans risk;

    @Column(name = "clm_time",nullable = false)
    private String claimTime;

    @Column(name = "clm_status",nullable = false)
    private String claimStatus;

    @Column(name = "clm_rejected")
    private boolean claimRejected;

    @Column(name = "clm_status_dt",nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date statusDate;

    @Column(name = "clm_loss_desc",length = 2000)
    private String lossDesc;

    @ManyToOne
    @JoinColumn(name="clm_booked_by",nullable=false)
    private User bookedBy;

    @Column(name = "clm_booked_dt",nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date bookedDate;

    @Column(name = "clm_next_rvw_dt",nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date nextReviewDate;

    @Column(name = "clm_liability_adm")
    private boolean liabilityAdmission;

    @ManyToOne
    @JoinColumn(name="clm_status_id",nullable=false)
    private ClmStatus activity;

    @Column(name = "clm_party_blame")
    private String partyToBlame;

    @Column(name = "clm_insurer_dt")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date insurerDate;

    public Long getClmId() {
        return clmId;
    }

    public void setClmId(Long clmId) {
        this.clmId = clmId;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public Date getClmDate() {
        return clmDate;
    }

    public void setClmDate(Date clmDate) {
        this.clmDate = clmDate;
    }

    public Date getLossDate() {
        return lossDate;
    }

    public void setLossDate(Date lossDate) {
        this.lossDate = lossDate;
    }

    public RiskTrans getRisk() {
        return risk;
    }

    public void setRisk(RiskTrans risk) {
        this.risk = risk;
    }

    public String getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(String claimTime) {
        this.claimTime = claimTime;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public boolean isClaimRejected() {
        return claimRejected;
    }

    public void setClaimRejected(boolean claimRejected) {
        this.claimRejected = claimRejected;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public String getLossDesc() {
        return lossDesc;
    }

    public void setLossDesc(String lossDesc) {
        this.lossDesc = lossDesc;
    }

    public User getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(User bookedBy) {
        this.bookedBy = bookedBy;
    }

    public Date getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(Date bookedDate) {
        this.bookedDate = bookedDate;
    }

    public Date getNextReviewDate() {
        return nextReviewDate;
    }

    public void setNextReviewDate(Date nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }

    public boolean isLiabilityAdmission() {
        return liabilityAdmission;
    }

    public void setLiabilityAdmission(boolean liabilityAdmission) {
        this.liabilityAdmission = liabilityAdmission;
    }

    public ClmStatus getActivity() {
        return activity;
    }

    public void setActivity(ClmStatus activity) {
        this.activity = activity;
    }

    public String getPartyToBlame() {
        return partyToBlame;
    }

    public void setPartyToBlame(String partyToBlame) {
        this.partyToBlame = partyToBlame;
    }

    public Date getInsurerDate() {
        return insurerDate;
    }

    public void setInsurerDate(Date insurerDate) {
        this.insurerDate = insurerDate;
    }
}
