package com.jwt.auth.uw.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="sys_brk_currencies")
public class Currencies{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="cur_code")
    private Long curCode;

    @Column(name="cur_iso_code",unique=true)
    private String curIsoCode;

    @Column(name="cur_name")
    private String curName;

    @Column(name="cur_enabled")
    private Boolean enabled;

    @Column(name="cur_fraction")
    private String fraction;

    @Column(name="cur_fraction_units")
    private Integer fractionUnits;

    @Column(name="cur_round_off")
    private Integer roundOff;



    public Currencies() {
    }

    public Long getCurCode() {
        return this.curCode;
    }

    public void setCurCode(Long curCode) {
        this.curCode = curCode;
    }

    public String getCurIsoCode() {
        return this.curIsoCode;
    }

    public void setCurIsoCode(String curIsoCode) {
        this.curIsoCode = curIsoCode;
    }

    public String getCurName() {
        return this.curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }


    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public Integer getFractionUnits() {
        return fractionUnits;
    }

    public void setFractionUnits(Integer fractionUnits) {
        this.fractionUnits = fractionUnits;
    }

    public Integer getRoundOff() {
        return roundOff;
    }

    public void setRoundOff(Integer roundOff) {
        this.roundOff = roundOff;
    }
}
