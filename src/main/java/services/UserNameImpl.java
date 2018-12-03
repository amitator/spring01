package services;

import java.util.Scanner;

/**
 * Only reads user name
 */
public class UserNameImpl implements IUserName {
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
