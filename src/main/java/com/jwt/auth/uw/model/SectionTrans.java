package com.jwt.auth.uw.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;

@Entity
@Table(name="sys_brk_rsk_limits")
public class SectionTrans implements Cloneable {

    @Id
    @SequenceGenerator(name = "myLimitsSeq",sequenceName = "risk_limits_seq",allocationSize=1)
    @GeneratedValue(generator = "myLimitsSeq")
    @Column(name="sect_id")
    private Long sectId;

    @XmlTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sect_risk_id")
    private RiskTrans risk;

    @Transient
    private Long riskId;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="sect_sec_id",nullable=false)
    private SectionsDef section;

    @Column(name="sect_prem")
    private BigDecimal prem;

    @Column(name="sect_calc_prem")
    private BigDecimal calcprem;

    @Column(name="sect_amount")
    private BigDecimal amount;

    @Column(name="sect_rate")
    private BigDecimal rate;

    @Column(name="sect_div_fact",nullable=false)
    private BigDecimal divFactor;

    @Column(name="sect_free_limit")
    private BigDecimal freeLimit;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="sect_prem_id")
    private PremRatesDef premRates;

    @Column(name="sect_compute")
    private boolean compute;

    @Column(name="sect_multi_rate")
    private BigDecimal multiRate;


    @Column(name="sect_expired")
    private String expired;

    @ManyToOne
    @JoinColumn(name="sect_sect_id")
    private SectionTrans prevSection;


    @Column(name="sect_but_charge_prem")
    private BigDecimal butchargePrem;

    @Column(name="sect_but_charge_si")
    private BigDecimal butchargeSumInsured;

    public Long getSectId() {
        return sectId;
    }

    public void setSectId(Long sectId) {
        this.sectId = sectId;
    }

    public RiskTrans getRisk() {
        return risk;
    }

    public void setRisk(RiskTrans risk) {
        this.risk = risk;
    }

    public SectionsDef getSection() {
        return section;
    }

    public void setSection(SectionsDef section) {
        this.section = section;
    }

    public BigDecimal getPrem() {
        return prem;
    }

    public void setPrem(BigDecimal prem) {
        this.prem = prem;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getDivFactor() {
        return divFactor;
    }

    public void setDivFactor(BigDecimal divFactor) {
        this.divFactor = divFactor;
    }

    public BigDecimal getFreeLimit() {
        return freeLimit;
    }

    public void setFreeLimit(BigDecimal freeLimit) {
        this.freeLimit = freeLimit;
    }

    public boolean isCompute() {
        return compute;
    }

    public void setCompute(boolean compute) {
        this.compute = compute;
    }

    public PremRatesDef getPremRates() {
        return premRates;
    }

    public void setPremRates(PremRatesDef premRates) {
        this.premRates = premRates;
    }

    public BigDecimal getMultiRate() {
        return multiRate;
    }

    public void setMultiRate(BigDecimal multiRate) {
        this.multiRate = multiRate;
    }


    public BigDecimal getCalcprem() {
        return calcprem;
    }

    public void setCalcprem(BigDecimal calcprem) {
        this.calcprem = calcprem;
    }

    public Long getRiskId() {
        return riskId;
    }

    public void setRiskId(Long riskId) {
        this.riskId = riskId;
    }


    public SectionTrans getPrevSection() {
        return prevSection;
    }

    public void setPrevSection(SectionTrans prevSection) {
        this.prevSection = prevSection;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public BigDecimal getButchargePrem() {
        return butchargePrem;
    }

    public void setButchargePrem(BigDecimal butchargePrem) {
        this.butchargePrem = butchargePrem;
    }

    public BigDecimal getButchargeSumInsured() {
        return butchargeSumInsured;
    }

    public void setButchargeSumInsured(BigDecimal butchargeSumInsured) {
        this.butchargeSumInsured = butchargeSumInsured;
    }

    @Override
    public String toString() {
        return "SectionTrans{" +
                "sectId=" + sectId +
                ", section=" + section +
                ", prem=" + prem +
                ", calcprem=" + calcprem +
                ", amount=" + amount +
                ", rate=" + rate +
                ", divFactor=" + divFactor +
                ", freeLimit=" + freeLimit +
                ", premRates=" + premRates +
                ", compute=" + compute +
                ", multiRate=" + multiRate +
                ", expired=" + expired +
                ", butchargePrem=" + butchargePrem +
                ", butchargeSumInsured=" + butchargeSumInsured +

                '}';
    }
}

