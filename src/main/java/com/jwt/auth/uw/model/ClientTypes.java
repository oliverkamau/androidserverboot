package com.jwt.auth.uw.model;

import javax.persistence.*;

@Entity
@Table(name="sys_brk_client_types")
public class ClientTypes {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="cnt_type_id")
    private Long typeId;

    @Column(name="cnt_type",nullable=false)
    private String clientType;

    @Column(name="cnt_type_desc",nullable=false)
    private String typeDesc;

    public ClientTypes() {
    }


    public ClientTypes(String clientType, String typeDesc) {
        this.clientType = clientType;
        this.typeDesc = typeDesc;
    }


    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }



}

