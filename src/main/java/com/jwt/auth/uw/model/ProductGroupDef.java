package com.jwt.auth.uw.model;

import javax.persistence.*;

@Entity
@Table(name="sys_brk_product_grp")
public class ProductGroupDef{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="bpg_code")
    private Long prgCode;

    @Column(name="bpg_desc")
    private String prgDesc;

    @Column(name="bpg_type")
    private String prgType;

    public Long getPrgCode() {
        return prgCode;
    }

    public void setPrgCode(Long prgCode) {
        this.prgCode = prgCode;
    }

    public String getPrgDesc() {
        return prgDesc;
    }

    public void setPrgDesc(String prgDesc) {
        this.prgDesc = prgDesc;
    }

    public String getPrgType() {
        return prgType;
    }

    public void setPrgType(String prgType) {
        this.prgType = prgType;
    }



}

