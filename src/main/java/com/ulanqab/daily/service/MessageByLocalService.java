package com.ulanqab.daily.service;

public interface MessageByLocalService {
    String getMessage(String key);

    String getMessage(String key, Object[] args);
}
