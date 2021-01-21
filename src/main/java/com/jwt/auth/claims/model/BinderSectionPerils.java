package com.jwt.auth.claims.model;

import com.jwt.auth.uw.model.BinderDetails;
import com.jwt.auth.uw.model.SectionsDef;

import javax.persistence.*;

@Entity
@Table(name="sys_brk_bind_sect_prls")
public class BinderSectionPerils {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="bsp_id")
    private Long bspId;

    @ManyToOne
    @JoinColumn(name="bsp_sper_code",nullable=false)
    private SubclassPerils subclassPeril;

    @ManyToOne
    @JoinColumn(name="bsp_sect_code",nullable=false)
    private SectionsDef sectionsDef;

    @ManyToOne
    @JoinColumn(name="bsp_det_code",nullable=false)
    private BinderDetails binderDetail;

    public Long getBspId() {
        return bspId;
    }

    public void setBspId(Long bspId) {
        this.bspId = bspId;
    }

    public SubclassPerils getSubclassPeril() {
        return subclassPeril;
    }

    public void setSubclassPeril(SubclassPerils subclassPeril) {
        this.subclassPeril = subclassPeril;
    }

    public SectionsDef getSectionsDef() {
        return sectionsDef;
    }

    public void setSectionsDef(SectionsDef sectionsDef) {
        this.sectionsDef = sectionsDef;
    }

    public BinderDetails getBinderDetail() {
        return binderDetail;
    }

    public void setBinderDetail(BinderDetails binderDetail) {
        this.binderDetail = binderDetail;
    }
}
