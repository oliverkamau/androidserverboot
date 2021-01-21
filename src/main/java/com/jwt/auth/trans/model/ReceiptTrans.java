package com.jwt.auth.trans.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwt.auth.model.User;
import com.jwt.auth.uw.model.AccountDef;
import com.jwt.auth.uw.model.ClientDef;
import com.jwt.auth.uw.model.OrgBranch;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="sys_brk_receipts")
public class ReceiptTrans {

    @Id
    @SequenceGenerator(name = "receiptTransSeq",sequenceName = "receipt_trans_seq",allocationSize=1)
    @GeneratedValue(generator = "receiptTransSeq")
    @Column(name="receipt_id")
    private Long receiptId;

    @Column(name="receipt_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date receiptDate;

    @Column(name="receipt_trans_date")
    private Date receiptTransDate;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="receipt_user")
    private User receiptUser;

    @Column(name="receipt_amount")
    private BigDecimal receiptAmount;

    @Column(name="receipt_amt_words")
    private String amountWords;

    @Transient
    private Long insuranceId;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="receipt_acct_id", nullable = true)
    private AccountDef insurance;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="receipt_collect_id")
    private CollectionAccounts collectionAccount;

    @Transient
    private Long payId;

    @Column(name="receipt_paid_by")
    private String paidBy;

    @Column(name="receipt_payment_ref")
    private String paymentRef;

    @Column(name="receipt_manual_ref")
    private String manualRef;

    @Column(name="receipt_doc_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date documentDate;

    @Column(name="receipt_desc")
    private String receiptDesc;

    @Column(name="receipt_printed")
    private String printed;

    @Column(name="receipt_cancelled")
    private String cancelled;

    @Column(name="receipt_cancel_ref")
    private String cancelledRef;

    @Column(name="receipt_no", nullable=false)
    private String receiptNo;

    @Column(name="receipt_counter")
    private BigInteger counter;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="receipt_cancelled_by")
    private User cancelledBy;

    @Column(name="receipt_cancel_dt")
    private Date cancelledDate;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="receipt_brn_code")
    private OrgBranch branch;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="receipt_ten_id")
    private ClientDef client;

    @Transient
    private Long brnCode;

    @Column(name="receipt_cleared")
    private String cleared;

    @Column(name="receipt_direct",length = 1)
    private String directReceipt;

    @Column(name="receipt_fund",length = 1)
    private String fundReceipt;

    @Column(name = "receipt_cancel_commt")
    private String CancelComment;

    @JsonIgnore
    @OneToMany(mappedBy="receipt")
    private List<ReceiptTransDtls> receiptDtls;

    @Transient
    private List<ReceiptTransDtls> details;




    @XmlTransient
    @ManyToOne
    @JoinColumn(name="receipt_cleared_by")
    private User receiptClearedBy;

    @Column(name="receipt_cleared_date")
    private Date receiptClearedDate;

    @Column(name = "receipt_type")
    private String receiptType;

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Date getReceiptTransDate() {
        return receiptTransDate;
    }

    public void setReceiptTransDate(Date receiptTransDate) {
        this.receiptTransDate = receiptTransDate;
    }

    public User getReceiptUser() {
        return receiptUser;
    }

    public void setReceiptUser(User receiptUser) {
        this.receiptUser = receiptUser;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getAmountWords() {
        return amountWords;
    }

    public void setAmountWords(String amountWords) {
        this.amountWords = amountWords;
    }

    public Long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public AccountDef getInsurance() {
        return insurance;
    }

    public void setInsurance(AccountDef insurance) {
        this.insurance = insurance;
    }

    public CollectionAccounts getCollectionAccount() {
        return collectionAccount;
    }

    public void setCollectionAccount(CollectionAccounts collectionAccount) {
        this.collectionAccount = collectionAccount;
    }

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public String getPaymentRef() {
        return paymentRef;
    }

    public void setPaymentRef(String paymentRef) {
        this.paymentRef = paymentRef;
    }

    public String getManualRef() {
        return manualRef;
    }

    public void setManualRef(String manualRef) {
        this.manualRef = manualRef;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public String getReceiptDesc() {
        return receiptDesc;
    }

    public void setReceiptDesc(String receiptDesc) {
        this.receiptDesc = receiptDesc;
    }

    public String getPrinted() {
        return printed;
    }

    public void setPrinted(String printed) {
        this.printed = printed;
    }

    public String getCancelled() {
        return cancelled;
    }

    public void setCancelled(String cancelled) {
        this.cancelled = cancelled;
    }

    public String getCancelledRef() {
        return cancelledRef;
    }

    public void setCancelledRef(String cancelledRef) {
        this.cancelledRef = cancelledRef;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public BigInteger getCounter() {
        return counter;
    }

    public void setCounter(BigInteger counter) {
        this.counter = counter;
    }

    public User getCancelledBy() {
        return cancelledBy;
    }

    public void setCancelledBy(User cancelledBy) {
        this.cancelledBy = cancelledBy;
    }

    public Date getCancelledDate() {
        return cancelledDate;
    }

    public void setCancelledDate(Date cancelledDate) {
        this.cancelledDate = cancelledDate;
    }

    public OrgBranch getBranch() {
        return branch;
    }

    public void setBranch(OrgBranch branch) {
        this.branch = branch;
    }

    public ClientDef getClient() {
        return client;
    }

    public void setClient(ClientDef client) {
        this.client = client;
    }

    public Long getBrnCode() {
        return brnCode;
    }

    public void setBrnCode(Long brnCode) {
        this.brnCode = brnCode;
    }

    public String getCleared() {
        return cleared;
    }

    public void setCleared(String cleared) {
        this.cleared = cleared;
    }

    public String getDirectReceipt() {
        return directReceipt;
    }

    public void setDirectReceipt(String directReceipt) {
        this.directReceipt = directReceipt;
    }

    public String getFundReceipt() {
        return fundReceipt;
    }

    public void setFundReceipt(String fundReceipt) {
        this.fundReceipt = fundReceipt;
    }

    public String getCancelComment() {
        return CancelComment;
    }

    public void setCancelComment(String cancelComment) {
        CancelComment = cancelComment;
    }

    public List<ReceiptTransDtls> getReceiptDtls() {
        return receiptDtls;
    }

    public void setReceiptDtls(List<ReceiptTransDtls> receiptDtls) {
        this.receiptDtls = receiptDtls;
    }

    public List<ReceiptTransDtls> getDetails() {
        return details;
    }

    public void setDetails(List<ReceiptTransDtls> details) {
        this.details = details;
    }

    public User getReceiptClearedBy() {
        return receiptClearedBy;
    }

    public void setReceiptClearedBy(User receiptClearedBy) {
        this.receiptClearedBy = receiptClearedBy;
    }

    public Date getReceiptClearedDate() {
        return receiptClearedDate;
    }

    public void setReceiptClearedDate(Date receiptClearedDate) {
        this.receiptClearedDate = receiptClearedDate;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }
}
