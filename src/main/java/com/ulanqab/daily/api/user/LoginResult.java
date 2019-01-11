package com.ulanqab.daily.api.user;

import java.io.Serializable;

public class LoginResult implements Serializable {
    private Long userId;
    private String token;
    private String userName;
    private String avatarUrl;

    public LoginResult(Long userId, String token, String userName, String avatarUrl) {
        this.userId = userId;
        this.token = token;
        this.userName = userName;
        this.avatarUrl = avatarUrl;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
