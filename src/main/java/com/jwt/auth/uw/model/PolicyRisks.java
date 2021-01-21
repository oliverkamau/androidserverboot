package com.jwt.auth.uw.model;

import java.math.BigDecimal;
import java.util.Date;

public class PolicyRisks {

    private Long riskId;
    private String riskDesc;
    private String riskShtDesc;
    private Date wef;
    private Date wet;
    private BigDecimal premium;
    private BigDecimal sumInsured;

    public Long getRiskId() {
        return riskId;
    }

    public void setRiskId(Long riskId) {
        this.riskId = riskId;
    }

    public String getRiskDesc() {
        return riskDesc;
    }

    public void setRiskDesc(String riskDesc) {
        this.riskDesc = riskDesc;
    }

    public String getRiskShtDesc() {
        return riskShtDesc;
    }

    public void setRiskShtDesc(String riskShtDesc) {
        this.riskShtDesc = riskShtDesc;
    }

    public Date getWef() {
        return wef;
    }

    public void setWef(Date wef) {
        this.wef = wef;
    }

    public Date getWet() {
        return wet;
    }

    public void setWet(Date wet) {
        this.wet = wet;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }
}
