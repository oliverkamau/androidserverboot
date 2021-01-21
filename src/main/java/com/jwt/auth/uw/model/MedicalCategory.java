package com.jwt.auth.uw.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;

@Entity
@Table(name = "sys_brk_med_category")
public class MedicalCategory {

    @Id
    @SequenceGenerator(name = "medCategorySeq",sequenceName = "med_category_seq",allocationSize=1)
    @GeneratedValue(generator = "medCategorySeq")
    @Column(name = "mc_id")
    private Long id;

    @Column(name = "mc_sht_desc",nullable = false)
    private String shtDesc;

    @Column(name = "mc_desc",nullable = false)
    private String desc;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="mc_policy_id",nullable = false)
    private PolicyTrans policy;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="mc_bd_det_id",nullable = false)
    private BinderDetails binderDetails;

    @Column(name="mc_calc_premium_amt")
    private BigDecimal premium;

    @Column(name="mc_prevcalc_prem_amt")
    private BigDecimal prevPremium;

    @Column(name="mc_computed_prem_amt")
    private BigDecimal computedPremium;

    @Column(name="mc_loading_factor")
    private BigDecimal loadingFactor;

    @Column(name="mc_prevloading_prem")
    private BigDecimal prevLoadingPrem;

    @Column(name="mc_loading_prem")
    private BigDecimal loadingPrem;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="mc_bed_type_id")
    private BedTypes bedTypes;

    @Column(name="mc_bed_cost")
    private BigDecimal bedCost;

    @Column(name = "mc_flag")
    private String categoryStatus;

    @Column(name="mc_stamp_duty")
    private BigDecimal stampDuty;

    @Column(name="mc_ph_fund")
    private BigDecimal phfFund;

    @Column(name="mc_tl")
    private BigDecimal trainingLevy;

    @Column(name="mc_whtx")
    private BigDecimal whtax;

    @Column(name="mc_extras")
    private BigDecimal extras;


    @Column(name="mc_comm_rate")
    private BigDecimal commRate;


    @Column(name="mc_sub_agn_comm_rate")
    private BigDecimal subAgentCommRate;

    @Column(name="mc_comm_amt")
    private BigDecimal commAmt;

    @Column(name="mc_subagent_comm_amt")
    private BigDecimal subAgentComm;

    @Column(name = "mc_issue_card_fee")
    private BigDecimal issueCardFee;

    @Column(name = "mc_reissue_card_fee")
    private BigDecimal reissueCardFee;


    @Column(name = "mc_service_charge")
    private BigDecimal serviceCharge;

    @Column(name = "mc_vat_amt")
    private BigDecimal vatAmount;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShtDesc() {
        return shtDesc;
    }

    public void setShtDesc(String shtDesc) {
        this.shtDesc = shtDesc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PolicyTrans getPolicy() {
        return policy;
    }

    public void setPolicy(PolicyTrans policy) {
        this.policy = policy;
    }

    public BinderDetails getBinderDetails() {
        return binderDetails;
    }

    public void setBinderDetails(BinderDetails binderDetails) {
        this.binderDetails = binderDetails;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getLoadingFactor() {
        return loadingFactor;
    }

    public void setLoadingFactor(BigDecimal loadingFactor) {
        this.loadingFactor = loadingFactor;
    }

    public BigDecimal getLoadingPrem() {
        return loadingPrem;
    }

    public void setLoadingPrem(BigDecimal loadingPrem) {
        this.loadingPrem = loadingPrem;
    }

    public BigDecimal getPrevPremium() {
        return prevPremium;
    }

    public void setPrevPremium(BigDecimal prevPremium) {
        this.prevPremium = prevPremium;
    }


    public BigDecimal getComputedPremium() {
        return computedPremium;
    }

    public void setComputedPremium(BigDecimal computedPremium) {
        this.computedPremium = computedPremium;
    }

    public BigDecimal getPrevLoadingPrem() {
        return prevLoadingPrem;
    }

    public void setPrevLoadingPrem(BigDecimal prevLoadingPrem) {
        this.prevLoadingPrem = prevLoadingPrem;
    }

    public String getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(String categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicalCategory category = (MedicalCategory) o;

        return id != null ? id.equals(category.id) : category.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public BedTypes getBedTypes() {
        return bedTypes;
    }

    public void setBedTypes(BedTypes bedTypes) {
        this.bedTypes = bedTypes;
    }

    public BigDecimal getBedCost() {
        return bedCost;
    }

    public void setBedCost(BigDecimal bedCost) {
        this.bedCost = bedCost;
    }

    public BigDecimal getStampDuty() {
        return stampDuty;
    }

    public void setStampDuty(BigDecimal stampDuty) {
        this.stampDuty = stampDuty;
    }

    public BigDecimal getPhfFund() {
        return phfFund;
    }

    public void setPhfFund(BigDecimal phfFund) {
        this.phfFund = phfFund;
    }

    public BigDecimal getTrainingLevy() {
        return trainingLevy;
    }

    public void setTrainingLevy(BigDecimal trainingLevy) {
        this.trainingLevy = trainingLevy;
    }

    public BigDecimal getWhtax() {
        return whtax;
    }

    public void setWhtax(BigDecimal whtax) {
        this.whtax = whtax;
    }

    public BigDecimal getExtras() {
        return extras;
    }

    public void setExtras(BigDecimal extras) {
        this.extras = extras;
    }

    public BigDecimal getCommRate() {
        return commRate;
    }

    public void setCommRate(BigDecimal commRate) {
        this.commRate = commRate;
    }

    public BigDecimal getSubAgentCommRate() {
        return subAgentCommRate;
    }

    public void setSubAgentCommRate(BigDecimal subAgentCommRate) {
        this.subAgentCommRate = subAgentCommRate;
    }

    public BigDecimal getCommAmt() {
        return commAmt;
    }

    public void setCommAmt(BigDecimal commAmt) {
        this.commAmt = commAmt;
    }

    public BigDecimal getSubAgentComm() {
        return subAgentComm;
    }

    public void setSubAgentComm(BigDecimal subAgentComm) {
        this.subAgentComm = subAgentComm;
    }

    public BigDecimal getIssueCardFee() {
        return issueCardFee;
    }

    public void setIssueCardFee(BigDecimal issueCardFee) {
        this.issueCardFee = issueCardFee;
    }

    public BigDecimal getReissueCardFee() {
        return reissueCardFee;
    }

    public void setReissueCardFee(BigDecimal reissueCardFee) {
        this.reissueCardFee = reissueCardFee;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public BigDecimal getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(BigDecimal vatAmount) {
        this.vatAmount = vatAmount;
    }
}

