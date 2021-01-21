package com.jwt.auth.uw.model;

import java.util.List;

public class ListWrapper {

    private List<ClientPolicy> clientPolicies;

    public List<ClientPolicy> getClientPolicies() {
        return clientPolicies;
    }

    public void setClientPolicies(List<ClientPolicy> clientPolicies) {
        this.clientPolicies = clientPolicies;
    }
}
