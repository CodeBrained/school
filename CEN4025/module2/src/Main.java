/*
Cristian King
to-do-item application written in Java with the following features:
- Add a to-do item.
- Delete a to-do item.
- View the to-do item.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to the to-do list application.");
        System.out.println("Enter '1' to add an item.");
        System.out.println("Enter '2' to delete an item.");
        System.out.println("Enter '3' to view your to-do item list.");
        System.out.println("Enter '-1' to quit.");

        Scanner scan = new Scanner(System.in);
        int userChoice = 0;
        while (userChoice != -1) {
            userChoice = scan.nextInt();
            if (userChoice == 1) {
                // add item
                System.out.println("add item");
            } else if (userChoice == 2) {
                // delete item
                System.out.println("delete item");
            } else if (userChoice == 3) {
                // view list
                System.out.println("view list");
            }

        }
    }
}