package ru.otus.spring.hw01.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Configuration
public class BundleChoiceDependOnLocaleImpl implements BundleChoiceDependOnLocale {

    @Bean
    @Override
    public Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

    @Bean
    @Override
    public String selectBundleFile() {
        String fileName;
        Locale currentLocale = getLocale();
        switch (currentLocale.getDisplayLanguage()){
            case "en_EN":
                fileName = "data.csv";
                break;
            case "ru_RU":
                fileName = "data_ru.csv";
                break;
            default:
                fileName = "data.csv";
                break;
        }
        return fileName;
    }
}
