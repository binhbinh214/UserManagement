package view;

import java.util.Scanner;
import model.Account;

public class Menu {
    public void displayMenu() {
        System.out.println("====== USER MANAGEMENT SYSTEM ======");
        System.out.println("1. Create a new account");
        System.out.println("2. Login System");
        System.out.println("3. Exit the program");
    }

    public Account getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return new Account(username, password);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}