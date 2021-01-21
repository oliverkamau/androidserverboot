package com.jwt.auth.uw.model;

import javax.persistence.*;

@Entity
@Table(name = "sys_brk_sectors")
public class SectorDef{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sector_id")
    private Long code;

    @Column(name = "sector_sht_desc")
    private String shortDesc;

    @Column(name = "sector_name")
    private String name;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

