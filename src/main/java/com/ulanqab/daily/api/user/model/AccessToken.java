package com.ulanqab.daily.api.user.model;

import java.io.Serializable;

public class AccessToken implements Serializable {

    private String access_token;
    private String expires_in;
    private Integer errcpde;
    private String errmsg;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public Integer getErrcpde() {
        return errcpde;
    }

    public void setErrcpde(Integer errcpde) {
        this.errcpde = errcpde;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
