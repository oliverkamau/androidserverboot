package com.jwt.auth.uw.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="sys_brk_sub_covertypes")
public class SubclassCoverTypes{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="sc_id")
    private Long scId;

    @ManyToOne
    @JoinColumn(name="sc_sub_code")
    private SubClassDef subclass;

    @ManyToOne
    @JoinColumn(name="sc_cov_code")
    private CoverTypesDef coverTypes;

    @Column(name="sc_def_cover")
    private boolean defaultCoverType;

    @Column(name="sc_min_prem")
    private BigDecimal minPrem;



    public Long getScId() {
        return scId;
    }

    public void setScId(Long scId) {
        this.scId = scId;
    }

    public SubClassDef getSubclass() {
        return subclass;
    }

    public void setSubclass(SubClassDef subclass) {
        this.subclass = subclass;
    }

    public CoverTypesDef getCoverTypes() {
        return coverTypes;
    }

    public void setCoverTypes(CoverTypesDef coverTypes) {
        this.coverTypes = coverTypes;
    }

    public boolean isDefaultCoverType() {
        return defaultCoverType;
    }

    public void setDefaultCoverType(boolean defaultCoverType) {
        this.defaultCoverType = defaultCoverType;
    }

    public BigDecimal getMinPrem() {
        return minPrem;
    }

    public void setMinPrem(BigDecimal minPrem) {
        this.minPrem = minPrem;
    }

}

