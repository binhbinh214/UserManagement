package controller;

import model.Account;
import model.Model;
import view.Menu;

import java.util.Scanner;

public class UserManagement {
    private Model model;
    private Menu view;

    public UserManagement(Model model, Menu view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            view.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    Account newAccount = view.getInput();
                    try {
                        model.addAccount(newAccount);
                        view.displayMessage("Account created successfully.");
                    } catch (Exception e) {
                        view.displayMessage("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    Account loginAccount = view.getInput();
                    Account foundAccount = model.find(loginAccount);
                    if (foundAccount != null) {
                        view.displayMessage("Login successful");
                    } else {
                        view.displayMessage("Invalid username or password");
                    }
                    break;
                case 3:
                    view.displayMessage("Exiting the program");
                    break;
                default:
                    view.displayMessage("Invalid choice. Try again.");
            }
        } while (choice != 3);
    }
}