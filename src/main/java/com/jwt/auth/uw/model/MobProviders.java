package com.jwt.auth.uw.model;

import javax.persistence.*;

@Entity
@Table(name="sys_brk_mob_providers")
public class MobProviders {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="provider_id")
    private Long providerId;

    @Column(name="provider_name",nullable=false,unique=true)
    private String providerName;

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}

