package com.jwt.auth.uw.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="sys_brk_countries")
public class Country{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="cou_code")
    private Long couCode;

    @Column(name="cou_name",unique=true)
    private String couName;

    @Column(name="cou_sht_desc",unique=true)
    private String couShtDesc;

    @Column(name="cou_prefix",unique=true)
    private String prefix;


    public Country() {
    }

    public Long getCouCode() {
        return this.couCode;
    }

    public void setCouCode(Long couCode) {
        this.couCode = couCode;
    }

    public String getCouName() {
        return this.couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public String getCouShtDesc() {
        return this.couShtDesc;
    }

    public void setCouShtDesc(String couShtDesc) {
        this.couShtDesc = couShtDesc;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }



}
