package com.jwt.auth.uw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@Entity
@Table(name="sys_brk_subclasses")
public class SubClassDef{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="sub_id")
    private Long subId;

    @Column(name="sub_sht_desc",nullable=false,unique=true)
    private String subShtDesc;

    @Column(name="sub_desc",nullable=false)
    private String subDesc;

    @Column(name="sub_status",nullable=false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name="sub_cl_code",nullable=false)
    private ClassesDef classDef;

    @Column(name="sub_rsk_uniq",nullable=false)
    private boolean riskUnique;

    @Column(name="sub_risk_format")
    private String riskFormat;


    @XmlTransient
    @JsonIgnore
    @OneToMany(mappedBy="subclass")
    private List<ProductSubclasses> prodSubclasses;


    @XmlTransient
    @JsonIgnore
    @OneToMany(mappedBy="subclass")
    private List<SubclassCertTypes> subclassCertTypes;

    public List<SubclassCertTypes> getSubclassCertTypes() {
        return subclassCertTypes;
    }

    public void setSubclassCertTypes(List<SubclassCertTypes> subclassCertTypes) {
        this.subclassCertTypes = subclassCertTypes;
    }

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public String getSubShtDesc() {
        return subShtDesc;
    }

    public void setSubShtDesc(String subShtDesc) {
        this.subShtDesc = subShtDesc;
    }

    public String getSubDesc() {
        return subDesc;
    }

    public void setSubDesc(String subDesc) {
        this.subDesc = subDesc;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ClassesDef getClassDef() {
        return classDef;
    }

    public void setClassDef(ClassesDef classDef) {
        this.classDef = classDef;
    }

    public boolean isRiskUnique() {
        return riskUnique;
    }

    public void setRiskUnique(boolean riskUnique) {
        this.riskUnique = riskUnique;
    }

    public List<ProductSubclasses> getProdSubclasses() {
        return prodSubclasses;
    }

    public void setProdSubclasses(List<ProductSubclasses> prodSubclasses) {
        this.prodSubclasses = prodSubclasses;
    }

    public String getRiskFormat() {
        return riskFormat;
    }

    public void setRiskFormat(String riskFormat) {
        this.riskFormat = riskFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubClassDef that = (SubClassDef) o;

        return subId.equals(that.subId);

    }

    @Override
    public int hashCode() {
        return subId.hashCode();
    }
}

