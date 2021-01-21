package com.jwt.auth.uw.model;

public class ClaimsBean {

private Long claimId;
private String claimNo;
private String lossDate;
private String claimDate;
private String Peril;
private String status;

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getLossDate() {
        return lossDate;
    }

    public void setLossDate(String lossDate) {
        this.lossDate = lossDate;
    }


    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    public String getPeril() {
        return Peril;
    }

    public void setPeril(String peril) {
        Peril = peril;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
