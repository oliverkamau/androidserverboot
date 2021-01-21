package com.jwt.auth.uw.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="sys_brk_products")
public class ProductsDef{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="pr_code")
    private Long proCode;

    @Column(name="pr_sht_desc", nullable=false,unique=true)
    private String proShtDesc;

    @Column(name="pr_desc", nullable=false)
    private String proDesc;

    @Column(name="pr_pol_prefix")
    private String proPolPrefix;

    @Column(name="pr_clm_prefix")
    private String proClmPrefix;

    @Column(name="pr_multi_sub_class")
    private boolean multiSubClass;

    @Column(name="pr_renewable")
    private boolean renewable;

    @Column(name="pr_send_ren_alerts")
    private boolean sendRenAlert;

    @Column(name="pr_active")
    private boolean active;

    @Column(name="pr_min_prem")
    private BigDecimal minPrem;

    @Column(name="pr_install_allowed")
    private boolean installAllowed;

    @Column(name="pr_motor_product")
    private boolean motorProduct;

    @Column(name="pr_midnit_exp")
    private boolean midnightExp;

    @Column(name="pr_interface_type")
    private String interfaceType;


    @Column(name="pr_age_appli")
    private String ageApplicable;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="pr_bpg_code",nullable=false)
    private ProductGroupDef proGroup;

    @ManyToOne
    @JoinColumn(name="report_group")
    private ProductReportGroup productReportGroup;

    public ProductReportGroup getProductReportGroup() {
        return productReportGroup;
    }

    public void setProductReportGroup(ProductReportGroup productReportGroup) {
        this.productReportGroup = productReportGroup;
    }

    @Column(name="pr_risk_note")
    private String riskNote;

    @Column(name="pr_ren_notice")
    private String renewalNotice;


    public Long getProCode() {
        return proCode;
    }

    public void setProCode(Long proCode) {
        this.proCode = proCode;
    }

    public String getProShtDesc() {
        return proShtDesc;
    }

    public void setProShtDesc(String proShtDesc) {
        this.proShtDesc = proShtDesc;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public String getProPolPrefix() {
        return proPolPrefix;
    }

    public void setProPolPrefix(String proPolPrefix) {
        this.proPolPrefix = proPolPrefix;
    }

    public String getProClmPrefix() {
        return proClmPrefix;
    }

    public void setProClmPrefix(String proClmPrefix) {
        this.proClmPrefix = proClmPrefix;
    }

    public boolean isMultiSubClass() {
        return multiSubClass;
    }

    public void setMultiSubClass(boolean multiSubClass) {
        this.multiSubClass = multiSubClass;
    }

    public boolean isRenewable() {
        return renewable;
    }

    public void setRenewable(boolean renewable) {
        this.renewable = renewable;
    }

    public ProductGroupDef getProGroup() {
        return proGroup;
    }

    public void setProGroup(ProductGroupDef proGroup) {
        this.proGroup = proGroup;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public BigDecimal getMinPrem() {
        return minPrem;
    }

    public void setMinPrem(BigDecimal minPrem) {
        this.minPrem = minPrem;
    }

    public boolean isInstallAllowed() {
        return installAllowed;
    }

    public void setInstallAllowed(boolean installAllowed) {
        this.installAllowed = installAllowed;
    }

    public boolean isMotorProduct() {
        return motorProduct;
    }

    public void setMotorProduct(boolean motorProduct) {
        this.motorProduct = motorProduct;
    }

    public boolean isMidnightExp() {
        return midnightExp;
    }

    public void setMidnightExp(boolean midnightExp) {
        this.midnightExp = midnightExp;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getAgeApplicable() {
        return ageApplicable;
    }

    public void setAgeApplicable(String ageApplicable) {
        this.ageApplicable = ageApplicable;
    }

    public String getRiskNote() {
        return riskNote;
    }

    public void setRiskNote(String riskNote) {
        this.riskNote = riskNote;
    }

    public String getRenewalNotice() {
        return renewalNotice;
    }

    public void setRenewalNotice(String renewalNotice) {
        this.renewalNotice = renewalNotice;
    }

    public boolean isSendRenAlert() {
        return sendRenAlert;
    }

    public void setSendRenAlert(boolean sendRenAlert) {
        this.sendRenAlert = sendRenAlert;
    }
}

