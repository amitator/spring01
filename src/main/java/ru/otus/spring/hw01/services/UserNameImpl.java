package ru.otus.spring.hw01.services;

import java.util.Scanner;

/**
 * Only reads user name
 */

public class UserNameImpl implements UserName {
    /**
     *
     * @return User name
     */
    public String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");

        return scanner.nextLine();
    }
}
