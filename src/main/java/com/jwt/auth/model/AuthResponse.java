package com.jwt.auth.model;

import java.util.List;

public class AuthResponse {

    private  String token;

    private  String username;

    private String type;

    private String realName;

    private Long clientId;

    private List<String> roles;

    private Integer expired;

    private Integer policies;

    private Integer quotes;

    private String phone;

    public AuthResponse() {
    }

    public AuthResponse(String token, String username, String type, String realName, Long clientId, List<String> roles, Integer expired, Integer policies, Integer quotes, String phone) {
        this.token = token;
        this.username = username;
        this.type = type;
        this.realName = realName;
        this.clientId = clientId;
        this.roles = roles;
        this.expired = expired;
        this.policies = policies;
        this.quotes = quotes;
        this.phone = phone;
    }

    public String getJwt() {
        return token;
    }

    public void setJwt(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getExpired() {
        return expired;
    }

    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    public Integer getPolicies() {
        return policies;
    }

    public void setPolicies(Integer policies) {
        this.policies = policies;
    }

    public Integer getQuotes() {
        return quotes;
    }

    public void setQuotes(Integer quotes) {
        this.quotes = quotes;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
