package com.ulanqab.daily.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageByLocaleServiceImpl implements MessageByLocaleService {

    @Autowired
    private MessageSource messageSource;

    @Override
    public String getMessage(String key) {
        return getMessage(key, null);
    }

    @Override
    public String getMessage(String key, Object[] args) {
        Locale local = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, args, local);
    }
}
