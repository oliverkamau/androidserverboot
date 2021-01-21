package com.jwt.auth.uw.model;

import javax.persistence.*;

@Entity
@Table(name="sys_brk_coa_sub")
public class CoaSubAccounts {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="co_Id")
    private Long coId;

    @Column(name="co_code",nullable = false,unique = true)
    private String code;

    @Column(name="co_name",nullable = false)
    private String name;

    @Column(name="co_int_account",nullable = false)
    private String integration;

    @Column(name="co_accounts_order",nullable = false)
    private String accountsOrder;

    @ManyToOne
    @JoinColumn(name="co_main_acc_id")
    private CoaMainAccounts mainAccounts;

    @Transient
    private String applLevel;

    @Transient
    private Long revId;

    public Long getCoId() {
        return coId;
    }

    public void setCoId(Long coId) {
        this.coId = coId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntegration() {
        return integration;
    }

    public void setIntegration(String integration) {
        this.integration = integration;
    }

    public String getAccountsOrder() {
        return accountsOrder;
    }

    public void setAccountsOrder(String accountsOrder) {
        this.accountsOrder = accountsOrder;
    }

    public CoaMainAccounts getMainAccounts() {
        return mainAccounts;
    }

    public void setMainAccounts(CoaMainAccounts mainAccounts) {
        this.mainAccounts = mainAccounts;
    }

    public String getApplLevel() {
        return applLevel;
    }

    public void setApplLevel(String applLevel) {
        this.applLevel = applLevel;
    }

    public Long getRevId() {
        return revId;
    }

    public void setRevId(Long revId) {
        this.revId = revId;
    }
}

