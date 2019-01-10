package ru.otus.spring.hw01.services;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw01.config.YAMLConfig;

import java.util.Locale;

@Service
public class BundleChoiceDependOnLocaleImpl implements BundleChoiceDependOnLocale {

    private YAMLConfig config;

    private Locale locale = LocaleContextHolder.getLocale();

    public BundleChoiceDependOnLocaleImpl(YAMLConfig yamlConfig){
        this.config = yamlConfig;
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public void setLocale(Locale l){
        locale = l;
    }

    @Override
    public String selectBundleFile() {
        Locale currentLocale = getLocale();

        return String.format(config.getBundle(), currentLocale);
    }
}
