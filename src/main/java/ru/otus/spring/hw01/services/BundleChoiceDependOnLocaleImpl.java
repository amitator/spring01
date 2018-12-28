package ru.otus.spring.hw01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw01.config.YAMLConfig;

import java.util.Locale;

@Service
public class BundleChoiceDependOnLocaleImpl implements BundleChoiceDependOnLocale {

    @Autowired
    private YAMLConfig config;

    @Override
    public Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

    @Override
    public String selectBundleFile() {
        Locale currentLocale = getLocale();

        return String.format(config.getBundle(), currentLocale);
    }
}
