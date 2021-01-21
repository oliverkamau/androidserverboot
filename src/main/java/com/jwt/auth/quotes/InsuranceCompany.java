package com.jwt.auth.quotes;

import javax.persistence.*;

@Entity
@Table(name="insurance_companies")
public class InsuranceCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="company_id")
    private Long companyId;

    @Column(name="insurance_company")
    private String company;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
