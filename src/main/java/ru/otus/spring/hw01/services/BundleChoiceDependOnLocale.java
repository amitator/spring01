package ru.otus.spring.hw01.services;

import java.util.Locale;

public interface BundleChoiceDependOnLocale {
    Locale getLocale();
    void setLocale(Locale l);
    String selectBundleFile();
}
