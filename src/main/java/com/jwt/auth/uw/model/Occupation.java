package com.jwt.auth.uw.model;

import javax.persistence.*;

@Entity
@Table(name = "sys_brk_occupation")
public class Occupation{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "occ_id")
    private Long code;

    @Column(name = "occ_sht_desc")
    private String shortDesc;

    @Column(name = "occ_name")
    private String name;

    @ManyToOne
    @JoinColumn(name="occ_sector_code",nullable=false)
    private SectorDef sector;


    public void setCode(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public SectorDef getSector() {
        return sector;
    }

    public void setSector(SectorDef sector) {
        this.sector = sector;
    }



}

