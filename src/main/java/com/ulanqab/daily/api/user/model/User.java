package com.ulanqab.daily.api.user.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {
    private Long uid;
    private String nickName;
    private String thirdId;
    private String avatar;
    private Integer role;
    private Timestamp loginAt;
    private Timestamp expiresAt;
    private Boolean isLocked = false;

    public User() {
    }

    public User(String thirdId, String nickName, String avatar, Timestamp loginAt, Timestamp expiresAt) {
        this.thirdId = thirdId;
        this.nickName = nickName;
        this.avatar = avatar;
        this.loginAt = loginAt;
        this.expiresAt = expiresAt;
    }


    public User(Long uid, String thirdId, String nickName, String avatar, Integer role, Timestamp loginAt, Timestamp expiresAt, Boolean isLocked) {
        this.uid = uid;
        this.thirdId = thirdId;
        this.nickName = nickName;
        this.avatar = avatar;
        this.role = role;
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

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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
