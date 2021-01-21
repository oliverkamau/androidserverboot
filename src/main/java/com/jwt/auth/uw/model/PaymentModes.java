package com.jwt.auth.uw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;

@Entity
@Table(name="sys_brk_payment_modes")
public class PaymentModes{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="pm_id")
    private Long pmId;

    @Column(name="pm_sh_desc",nullable=false,unique=true)
    private String pmShtDesc;

    @Column(name="pm_desc")
    private String pmDesc;

    @Column(name="pm_max_val")
    private BigDecimal pmMaxValue;

    @Column(name="pm_min_val")
    private BigDecimal pmMinValue;

    @XmlTransient
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="pm_co_id")
    private CoaSubAccounts subAccounts;

    public Long getPmId() {
        return pmId;
    }

    public void setPmId(Long pmId) {
        this.pmId = pmId;
    }

    public String getPmShtDesc() {
        return pmShtDesc;
    }

    public void setPmShtDesc(String pmShtDesc) {
        this.pmShtDesc = pmShtDesc;
    }

    public String getPmDesc() {
        return pmDesc;
    }

    public void setPmDesc(String pmDesc) {
        this.pmDesc = pmDesc;
    }

    public BigDecimal getPmMaxValue() {
        return pmMaxValue;
    }

    public void setPmMaxValue(BigDecimal pmMaxValue) {
        this.pmMaxValue = pmMaxValue;
    }

    public BigDecimal getPmMinValue() {
        return pmMinValue;
    }

    public void setPmMinValue(BigDecimal pmMinValue) {
        this.pmMinValue = pmMinValue;
    }


    public CoaSubAccounts getSubAccounts() {
        return subAccounts;
    }

    public void setSubAccounts(CoaSubAccounts subAccounts) {
        this.subAccounts = subAccounts;
    }
}

