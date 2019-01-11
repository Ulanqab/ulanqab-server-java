package com.ulanqab.daily.api.user;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {
    private Long uid;
    private String username;
    private String mobile;
    private String password;
    private Integer appId;
    private Timestamp loginAt;
    private Timestamp expiresAt;
    private Boolean isLocked = false;

    public User(String username, String password, Integer appId, Timestamp loginAt, Timestamp expiresAt) {
        this.username = username;
        this.password = password;
        this.appId = appId;
        this.loginAt = loginAt;
        this.expiresAt = expiresAt;
    }

    public User(Long uid, String username, String mobile, String password, Integer appId,
                Timestamp loginAt, Timestamp expiresAt, Boolean isLocked) {
        this.uid = uid;
        this.username = username;
        this.mobile = mobile;
        this.password = password;
        this.appId = appId;
        this.loginAt = loginAt;
        this.expiresAt = expiresAt;
        this.isLocked = isLocked;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Timestamp getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(Timestamp loginAt) {
        this.loginAt = loginAt;
    }

    public Timestamp getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Timestamp expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }


}
