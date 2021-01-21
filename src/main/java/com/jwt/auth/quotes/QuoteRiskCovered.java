package com.jwt.auth.quotes;

import javax.persistence.*;

@Entity
@Table(name="sys_brk_quote_risks_android")
public class QuoteRiskCovered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="insurance_quote_risk")
    private Long quoteRiskId;

    @ManyToOne
    @JoinColumn(name="risk_quote_id")
    private InsuranceQuotes insuranceQuotes;

    @ManyToOne
    @JoinColumn(name="quote_risk_id")
    private RisksCovered risksCovered;

    public Long getQuoteRiskId() {
        return quoteRiskId;
    }

    public void setQuoteRiskId(Long quoteRiskId) {
        this.quoteRiskId = quoteRiskId;
    }

    public InsuranceQuotes getInsuranceQuotes() {
        return insuranceQuotes;
    }

    public void setInsuranceQuotes(InsuranceQuotes insuranceQuotes) {
        this.insuranceQuotes = insuranceQuotes;
    }

    public RisksCovered getRisksCovered() {
        return risksCovered;
    }

    public void setRisksCovered(RisksCovered risksCovered) {
        this.risksCovered = risksCovered;
    }
}
