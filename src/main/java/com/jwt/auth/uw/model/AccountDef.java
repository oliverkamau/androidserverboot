package com.jwt.auth.uw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwt.auth.model.SubAccountTypes;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sys_brk_accounts")
public class AccountDef{
    private static final long serialVersionUID = 1L;

    public AccountDef(String acctId) {
        this.acctId = new Long(acctId);
    }

    public AccountDef() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "acct_id")
    private Long acctId;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "acct_acc_code")
    private AccountTypes accountType;

    @Column(name = "acct_name", nullable = false)
    private String name;

    @Column(name = "acct_sht_desc")
    private String shtDesc;

    @Column(name = "acct_address")
    private String address;

    @Column(name = "acct_phys_address")
    private String physaddress;

    @Column(name = "acct_contact_title")
    private String contactTitle;

    @Column(name = "acct_contact_person")
    private String contactPerson;

    @Column(name = "acct_pin")
    private String pinNo;

    @Column(name = "acct_license_no")
    private String licenseNumber;

    @Lob
    @JsonIgnore
    @Column(name = "acct_photo")
    private byte[] photo;

    @Column(name = "acct_email")
    private String email;

    @Column(name = "acct_phone", nullable = false)
    private String phoneNo;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "acct_brn_code")
    private OrgBranch branch;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "acct_dob")
    private Date dob;

    @Column(name = "acct_status")
    private String status;

    @Transient
    MultipartFile file;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "acct_bnk_code")
    private Banks banks;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "acct_branch_code")
    private BankBranches bankBranches;

    @Column(name = "acct_bnk_account")
    private String bankAccount;

    @Column(name = "acct_paybill")
    private String paybillNumber;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="acct_pmode_id")
    private PaymentModes paymentMode;

    @Column(name = "acct_pay_tel_no")
    private String payTelNo;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "acct_wef")
    private Date wef;


    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "acct_wet")
    private Date wet;

    @ManyToOne
    @JoinColumn(name="acct_sub_account")
    private SubAccountTypes subAccountTypes;

    public SubAccountTypes getSubAccountTypes() {
        return subAccountTypes;
    }

    public void setSubAccountTypes(SubAccountTypes subAccountTypes) {
        this.subAccountTypes = subAccountTypes;
    }

    public Long getAcctId() {
        return acctId;
    }

    public void setAcctId(Long acctId) {
        this.acctId = acctId;
    }

    public AccountTypes getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypes accountType) {
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShtDesc() {
        return shtDesc;
    }

    public void setShtDesc(String shtDesc) {
        this.shtDesc = shtDesc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinNo() {
        return pinNo;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
    }


    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public OrgBranch getBranch() {
        return branch;
    }

    public void setBranch(OrgBranch branch) {
        this.branch = branch;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getPhysaddress() {
        return physaddress;
    }

    public void setPhysaddress(String physaddress) {
        this.physaddress = physaddress;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Banks getBanks() {
        return banks;
    }

    public void setBanks(Banks banks) {
        this.banks = banks;
    }

    public BankBranches getBankBranches() {
        return bankBranches;
    }

    public void setBankBranches(BankBranches bankBranches) {
        this.bankBranches = bankBranches;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getPaybillNumber() {
        return paybillNumber;
    }

    public void setPaybillNumber(String paybillNumber) {
        this.paybillNumber = paybillNumber;
    }

    public PaymentModes getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentModes paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPayTelNo() {
        return payTelNo;
    }

    public void setPayTelNo(String payTelNo) {
        this.payTelNo = payTelNo;
    }

    public Date getWef() {
        return wef;
    }

    public void setWef(Date wef) {
        this.wef = wef;
    }

    public Date getWet() {
        return wet;
    }

    public void setWet(Date wet) {
        this.wet = wet;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }


}

