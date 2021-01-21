package com.jwt.auth.quotes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="self_add_ons")
public class AddOns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addon_id")
    private Long addOnCode;

    @Column(name="addon_name")
    private String addOnName;

    @Column(name="addon_price")
    private BigDecimal addOnPrice;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "selfquote_addon")
    private InsuranceQuotes insuranceQuotes;

    public AddOns() {
    }

    public AddOns(String addOnName, BigDecimal addOnPrice, InsuranceQuotes insuranceQuotes) {
        this.addOnName = addOnName;
        this.addOnPrice = addOnPrice;
        this.insuranceQuotes = insuranceQuotes;
    }

    public InsuranceQuotes getInsuranceQuotes() {
        return insuranceQuotes;
    }

    public void setInsuranceQuotes(InsuranceQuotes insuranceQuotes) {
        this.insuranceQuotes = insuranceQuotes;
    }

    public Long getAddOnCode() {
        return addOnCode;
    }

    public void setAddOnCode(Long addOnCode) {
        this.addOnCode = addOnCode;
    }

    public String getAddOnName() {
        return addOnName;
    }

    public void setAddOnName(String addOnName) {
        this.addOnName = addOnName;
    }

    public BigDecimal getAddOnPrice() {
        return addOnPrice;
    }

    public void setAddOnPrice(BigDecimal addOnPrice) {
        this.addOnPrice = addOnPrice;
    }
}
