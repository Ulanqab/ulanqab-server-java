package com.ulanqab.daily.service;

public interface MessageByLocaleService {
    String getMessage(String key);

    String getMessage(String key, Object[] args);
}
