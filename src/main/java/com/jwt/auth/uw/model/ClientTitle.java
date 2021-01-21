package com.jwt.auth.uw.model;

import javax.persistence.*;

@Entity
@Table(name="sys_brk_client_titles")
public class ClientTitle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="cnt_title_id")
    private Long titleId;

    @Column(name="cnt_title",nullable=false,unique=true)
    private String titleName;

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }



}

