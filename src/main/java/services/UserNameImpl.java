package services;

import java.util.Scanner;

public class UserNameImpl implements IUserName {
    public String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");

        return scanner.nextLine();
    }
}
