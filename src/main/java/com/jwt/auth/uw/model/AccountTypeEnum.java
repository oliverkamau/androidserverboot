package com.jwt.auth.uw.model;

public enum  AccountTypeEnum {

    INS("INS","Insurance Company"),
    IA("IA","Inhouse Agents"),
    SF("SF","Self Fund");

    private String code;
    private String value;

    private AccountTypeEnum(String code,String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}

