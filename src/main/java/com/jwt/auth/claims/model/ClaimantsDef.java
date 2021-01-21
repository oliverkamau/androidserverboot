package com.jwt.auth.claims.model;

import com.jwt.auth.uw.model.Occupation;

import javax.persistence.*;

@Entity
@Table(name = "sys_brk_claimants")
public class ClaimantsDef {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clmnt_id")
    private Long claimantId;

    @Column(name = "clmnt_surname",nullable = false)
    private String surname;

    @Column(name = "clmnt_othernames",nullable = false)
    private String otherNames;

    @ManyToOne
    @JoinColumn(name="clmnt_occup")
    private Occupation occupation ;

    @Column(name = "clmnt_idno")
    private String idNumber;

    @Column(name = "clmnt_address",length = 500)
    private String address;

    @Column(name = "clmnt_mob_no",nullable = false)
    private String mobileNo;

    public Long getClaimantId() {
        return claimantId;
    }

    public void setClaimantId(Long claimantId) {
        this.claimantId = claimantId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
