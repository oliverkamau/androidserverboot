package com.jwt.auth.quotes;



import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name="sys_brk_android_quotes")
public class InsuranceQuotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quote_id")
    private Long quoteId;



    @Column(name="insurance_binder")
    private String binder;

    @Column(name="insurance_cover")
    private String cover;

    @Column(name="insurance_premium")
    private BigDecimal premium;

    @Column(name="insurance_sumInsured")
    private BigDecimal sumInsured;

    @ManyToOne
    @JoinColumn(name="underwriter")
    private InsuranceCompany insuranceCompany;


    public InsuranceQuotes() {
    }

    public InsuranceQuotes(InsuranceCompany insuranceCompany, String binder, String cover, BigDecimal premium, BigDecimal sumInsured) {
        this.insuranceCompany = insuranceCompany;
        this.binder = binder;
        this.cover = cover;
        this.premium = premium;
        this.sumInsured = sumInsured;
    }

    public Long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }


    public String getBinder() {
        return binder;
    }

    public void setBinder(String binder) {
        this.binder = binder;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }


}
