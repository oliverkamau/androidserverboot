package com.jwt.auth.uw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@Entity
@Table(name="sys_brk_sections")
public class SectionsDef {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="sc_id")
    private Long id;

    @Column(name="sc_sht_desc",nullable=false,unique=true)
    private String shtDesc;

    @Column(name="sc_desc",nullable=false)
    private String desc;

    @Column(name="sc_type",nullable=false)
    @Enumerated(EnumType.STRING)
    private SectionTypes type;

    @XmlTransient
    @JsonIgnore
    @OneToMany(mappedBy="section")
    private List<SubclassSections> sections;

    @XmlTransient
    @JsonIgnore
    @OneToMany(mappedBy="section")
    private List<MedicalCovers> medicalCovers;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShtDesc() {
        return shtDesc;
    }

    public void setShtDesc(String shtDesc) {
        this.shtDesc = shtDesc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



    public SectionTypes getType() {
        return type;
    }

    public void setType(SectionTypes type) {
        this.type = type;
    }

    public List<SubclassSections> getSections() {
        return sections;
    }

    public void setSections(List<SubclassSections> sections) {
        this.sections = sections;
    }


    public List<MedicalCovers> getMedicalCovers() {
        return medicalCovers;
    }

    public void setMedicalCovers(List<MedicalCovers> medicalCovers) {
        this.medicalCovers = medicalCovers;
    }
}

