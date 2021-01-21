package com.jwt.auth.uw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@Entity
@Table(name="sys_brk_clauses")
public class ClausesDef{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="clau_id")
    private Long clauId;

    @Column(name="clau_sht_desc",nullable=false,unique = true)
    private String clauShtDesc;

    @Column(name="clau_header",nullable=false)
    private String clauHeading;

    @Column(name="clau_editable",nullable=false)
    private boolean editable;

    @Column(name="clau_wording",nullable=false)
    @Lob
    private String clauWording;

    @XmlTransient
    @JsonIgnore
    @OneToMany(mappedBy="clause")
    private List<SubclassClauses> subClauses;


    @Column(name="clau_type")
    private String clauseType;


    public Long getClauId() {
        return clauId;
    }

    public void setClauId(Long clauId) {
        this.clauId = clauId;
    }

    public String getClauShtDesc() {
        return clauShtDesc;
    }

    public void setClauShtDesc(String clauShtDesc) {
        this.clauShtDesc = clauShtDesc;
    }

    public String getClauHeading() {
        return clauHeading;
    }

    public void setClauHeading(String clauHeading) {
        this.clauHeading = clauHeading;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getClauWording() {
        return clauWording;
    }

    public void setClauWording(String clauWording) {
        this.clauWording = clauWording;
    }

    public List<SubclassClauses> getSubClauses() {
        return subClauses;
    }

    public void setSubClauses(List<SubclassClauses> subClauses) {
        this.subClauses = subClauses;
    }

    public String getClauseType() {
        return clauseType;
    }

    public void setClauseType(String clauseType) {
        this.clauseType = clauseType;
    }
}

