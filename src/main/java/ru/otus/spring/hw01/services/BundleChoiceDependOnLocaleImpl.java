package ru.otus.spring.hw01.services;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class BundleChoiceDependOnLocaleImpl implements BundleChoiceDependOnLocale {

    @Override
    public Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

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
