package com.jwt.auth.uw.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@Entity
@Table(name="sys_brk_towns")
//@NamedQuery(name="Town.findAll", query="SELECT t FROM Town t")
public class Town{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ct_code")
    private Long ctCode;

    @Column(name="ct_name")
    private String ctName;


    @Column(name="ct_sht_desc")
    private String ctShtDesc;



    //bi-directional many-to-one association to County
    @XmlTransient
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ct_county_code")
    @JsonBackReference
    private County county;

    public Town() {
    }

    public Long getCtCode() {
        return this.ctCode;
    }

    public void setCtCode(Long ctCode) {
        this.ctCode = ctCode;
    }

    public String getCtName() {
        return this.ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName;
    }


    public String getCtShtDesc() {
        return this.ctShtDesc;
    }

    public void setCtShtDesc(String ctShtDesc) {
        this.ctShtDesc = ctShtDesc;
    }


    public County getCounty() {
        return this.county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

}
