import entity.ToDoListEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Methods.intro();
            Methods.continueMessage();
            Scanner scan = new Scanner(System.in);
            ArrayList<String> items = new ArrayList<String>();

            ToDoListEntity toDo = new ToDoListEntity();
            TypedQuery<ToDoListEntity> viewToDo = entityManager.createNamedQuery("ToDoListEntity.viewList", ToDoListEntity.class);

            int userChoice = 0;
            while (userChoice != -1) {
                userChoice = Integer.parseInt(scan.nextLine());
                switch (userChoice) {
                    case 1:
                        System.out.println("\nWrite your to-do note.");
                        String toDoNote = scan.nextLine();

                        toDo.setTask(toDoNote);
                        entityManager.persist(toDo);

                        System.out.println("\nYour note has been added.");
                        Methods.continueMessage();
                        break;
                    case 2: //FIXME
                        System.out.println("\nEnter the index of the item you wish to delete ");
                        System.out.print("If you don't know the index, enter -1 to cancel, and ");
                        System.out.println("then enter 3 to view the to-do list.");

                        int num = Integer.parseInt(scan.nextLine());

                        entityManager.persist(toDo);
                        entityManager.remove(num);

                        //toDo = entityManager.find(ToDoListEntity.class, num);


                        System.out.println("\nYour note has been deleted.");
                        Methods.continueMessage();
                        break;
                    case 3:
                        System.out.println("\nTo-Do List");

                        for (ToDoListEntity toDoListEntity : viewToDo.getResultList()) {
                            System.out.println("ID: " + toDoListEntity.getId() + " - Task: " + toDoListEntity.getTask());
                        }
                        System.out.println();
                        Methods.continueMessage();
                        break;
                    default:
                        System.out.println("Closing program.");
                }
            }
            scan.close();

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

}

