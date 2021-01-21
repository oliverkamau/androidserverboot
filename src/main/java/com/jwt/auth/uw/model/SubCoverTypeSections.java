package com.jwt.auth.uw.model;

import javax.persistence.*;

@Entity
@Table(name="sys_brk_sub_cov_sects")
public class SubCoverTypeSections{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="scs_id")
    private Long scsId;

    @ManyToOne
    @JoinColumn(name="scs_sbcov_code")
    private SubclassCoverTypes subcoverType;

    @Column(name="scs_order")
    private Integer order;

    @Column(name="scs_mandatory")
    private boolean mandatory;

    @Column(name = "ss_integration")
    private String integration;

    @ManyToOne
    @JoinColumn(name="scs_ss_code")
    private SubclassSections subSections;

    public Long getScsId() {
        return scsId;
    }

    public void setScsId(Long scsId) {
        this.scsId = scsId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public SubclassCoverTypes getSubcoverType() {
        return subcoverType;
    }

    public void setSubcoverType(SubclassCoverTypes subcoverType) {
        this.subcoverType = subcoverType;
    }

    public SubclassSections getSubSections() {
        return subSections;
    }

    public void setSubSections(SubclassSections subSections) {
        this.subSections = subSections;
    }

    public String getIntegration() {
        return integration;
    }

    public void setIntegration(String integration) {
        this.integration = integration;
    }
}
