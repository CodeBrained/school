/*
Cristian King
to-do-item application written in Java with the following features:
- Add a to-do item.
- Delete a to-do item.
- View the to-do item.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Methods.intro();
        Methods.continueMessage();
        Scanner scan = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<String>();

        int userChoice = 0;
        while (userChoice != -1) {
            userChoice = Integer.parseInt(scan.nextLine());
            switch (userChoice) {
                case 1:
                    System.out.println("\nWrite your to-do note.");
                    String toDoNote = scan.nextLine();

                    items.add(toDoNote);
                    System.out.println("\nYour note has been added.");
                    Methods.continueMessage();
                    break;
                case 2:
                    System.out.println("\nEnter the index of the item you wish to delete ");
                    System.out.print("If you don't know the index, enter -1 to cancel, and ");
                    System.out.println("then enter 3 to view the to-do list.");
                    int num = Integer.parseInt(scan.nextLine());
                    items.remove(num);
                    System.out.println("\nYour note has been deleted.");
                    Methods.continueMessage();
                    break;
                case 3:
                    System.out.println("\nTo-Do List");
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println(i + " " + items.get(i));
                    }
                    Methods.continueMessage();
                    break;
                default:
                    System.out.println("Closing program.");
            }
        }
        scan.close();
    }
}