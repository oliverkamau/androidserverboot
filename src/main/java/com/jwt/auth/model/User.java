package com.jwt.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwt.auth.uw.model.AccountDef;
import com.jwt.auth.uw.model.OrgBranch;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Cacheable(true)
@Table(name ="sys_brk_users")
public class User{

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long userId;

    @Column(name="user_username")
    private String username;

    @Column(name="user_email")
    private String email;

    @Column(name="user_name")
    private String name;

    @Column(name="user_status")
    private String enabled;

    @Column(name="user_password")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "user_reset_pwd")
    private String resetPass;

    @Column(name = "user_test_client")
    private Long userClient;

    @ManyToOne
    @JoinColumn(name="user_sub_account")
    private SubAccountTypes subAccountTypes;

    @ManyToOne
    @JoinColumn(name="user_sub_agent")
    private AccountDef accountDef;

    @ManyToOne
    @JoinColumn(name="branch")
    private OrgBranch orgBranch;

    @Column(name="user_last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column(name="user_last_ip")
    private String lastIP;

    @Transient
    private String marketer;


    public User(User user) {
        this.userId = user.userId;
        this.username = user.username;
        this.name = user.name;
        this.password = user.password;
        this.enabled=user.enabled;
        this.email = user.email;
        this.confirmPassword= confirmPassword;
        this.lastLogin=new Date();
        this.lastIP = user.lastIP;
    }

    public User() {

    }

    public OrgBranch getOrgBranch() {
        return orgBranch;
    }

    public void setOrgBranch(OrgBranch orgBranch) {
        this.orgBranch = orgBranch;
    }

    public SubAccountTypes getSubAccountTypes() {
        return subAccountTypes;
    }

    public void setSubAccountTypes(SubAccountTypes subAccountTypes) {
        this.subAccountTypes = subAccountTypes;
    }

    public String getMarketer() {
        return marketer;
    }

    public void setMarketer(String marketer) {
        this.marketer = marketer;
    }

    public AccountDef getAccountDef() {
        return accountDef;
    }

    public void setAccountDef(AccountDef accountDef) {
        this.accountDef = accountDef;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getResetPass() {
        return resetPass;
    }

    public void setResetPass(String resetPass) {
        this.resetPass = resetPass;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return username;
    }

    public String getLastIP() {
        return lastIP;
    }

    public void setLastIP(String lastIP) {
        this.lastIP = lastIP;
    }

    public Long getUserClient() {
        return userClient;
    }

    public void setUserClient(Long userClient) {
        this.userClient = userClient;
    }
}
