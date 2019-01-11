package com.ulanqab.daily.wrapper;



import com.ulanqab.daily.Constants.STATUS_CODE;

import java.io.Serializable;

public class UlanqabResponse<T> implements Serializable {

    private int statusCode;
    private String statusMessage;
    private T data;
    private Long timestamp = System.currentTimeMillis();

    public UlanqabResponse() {
        this(STATUS_CODE.SUCCESS);
    }

    public UlanqabResponse(int statusCode) {
        this(statusCode, "");
    }

    public UlanqabResponse(String statusMessage) {
        this(STATUS_CODE.SUCCESS, statusMessage);
    }

    public UlanqabResponse(int statusCode, String statusMessage) {
        this(null, statusCode, statusMessage);
    }

    public UlanqabResponse(T data) {
        this(data, STATUS_CODE.SUCCESS);
    }

    public UlanqabResponse(T data, int statusCode) {
        this(data, statusCode, "");
    }

    public UlanqabResponse(T data, int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
