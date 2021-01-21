package com.jwt.auth.quotes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="sys_brk_android_perils")
public class RisksCovered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="peril_id")
    private Long perilId;

    @Column(name="peril_description")
    private String description;


    public RisksCovered(String description) {
        this.description = description;
    }

    public Long getPerilId() {
        return perilId;
    }

    public void setPerilId(Long perilId) {
        this.perilId = perilId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
