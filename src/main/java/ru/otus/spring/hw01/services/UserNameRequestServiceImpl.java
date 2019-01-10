package ru.otus.spring.hw01.services;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

/**
 * Only reads user name
 */

@Service
public class UserNameRequestServiceImpl implements UserNameRequestService {

    private MessageSource messageSource;

    private BundleChoiceDependOnLocale bundle;

    public UserNameRequestServiceImpl(MessageSource messageSource, BundleChoiceDependOnLocale bundle){
        this.messageSource = messageSource;
        this.bundle = bundle;
    }

    public String getUserName() {
        Scanner scanner = new Scanner(System.in);
        Locale locale = bundle.getLocale();
        System.out.print(messageSource.getMessage("welcome.msg", new String[]{"user"}, locale));
        return scanner.nextLine();
    }
}
