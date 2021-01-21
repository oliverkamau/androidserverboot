package com.jwt.auth.uw.model;

import java.util.List;

public class DataTable <T>{
    private Long clientId;
    private List<T> data;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
