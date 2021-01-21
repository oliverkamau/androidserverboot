package com.jwt.auth.claims.model;

import javax.persistence.*;

@Entity
@Table(name="sys_brk_activities")
public class ClmStatus {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ca_id")
    private Long caId;

    @Column(name="ca_desc",nullable = false)
    private String activityDesc;

    @Column(name = "ca_prd_type")
    private String periodType;

    @Column(name = "ca_period")
    private Long period;

    @Column(name = "ca_mandatory")
    private boolean mandatory;

    public Long getCaId() {
        return caId;
    }

    public void setCaId(Long caId) {
        this.caId = caId;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
}
