package com.jwt.auth.uw.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="sys_brk_clnt_docs")
public class ClientDocs {

    @Id
    @SequenceGenerator(name = "clntDocSeq",sequenceName = "client_docs_seq",allocationSize=1)
    @GeneratedValue(generator = "clntDocSeq")
    @Column(name="cd_id")
    private Long cdId;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="cd_client_id")
    private ClientDef clientDef;

    @Column(name = "cd_file_id")
    private String fileId;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name="cd_prospect_id")
    private ProspectDef prospectDef;

    @Column(name = "cd_loc_name")
    private String uploadedFileName;

    @Column(name = "cd_verifier")
    private String checkSum;

    @Column(name = "cd_content_type")
    private String contentType;

    @ManyToOne
    @JoinColumn(name="cd_req_code",nullable=false)
    private RequiredDocs requiredDoc;


    public String getUploadedFileName() {
        return uploadedFileName;
    }

    public void setUploadedFileName(String uploadedFileName) {
        this.uploadedFileName = uploadedFileName;
    }

    public String getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }

    public ClientDef getClientDef() {
        return clientDef;
    }

    public void setClientDef(ClientDef clientDef) {
        this.clientDef = clientDef;
    }

    public RequiredDocs getRequiredDoc() {
        return requiredDoc;
    }

    public void setRequiredDoc(RequiredDocs requiredDoc) {
        this.requiredDoc = requiredDoc;
    }

    public ProspectDef getProspectDef() {
        return prospectDef;
    }

    public void setProspectDef(ProspectDef prospectDef) {
        this.prospectDef = prospectDef;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}

