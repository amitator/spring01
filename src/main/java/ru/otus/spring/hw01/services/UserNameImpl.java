package ru.otus.spring.hw01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

/**
 * Only reads user name
 */

@Service
public class UserNameImpl implements UserName {
    /**
     *
     * @return User name
     */

    @Autowired
    private MessageSource messageSource;

    public UserNameImpl(MessageSource messageSource){}

    public String getUserName() {
        Scanner scanner = new Scanner(System.in);
        Locale locale = LocaleContextHolder.getLocale();
        System.out.print(messageSource.getMessage("welcome.msg", new String[]{"user"}, locale));
        return scanner.nextLine();
    }
}
