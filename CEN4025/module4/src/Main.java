import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Hashtable;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 2000000;

        arrayListMethod(n);
        linkedListMethod(n);
        hashtableMethod(n);
    }

    public static void arrayListMethod(int n) {
        // Creates new ArrayList to hold n amount of random integers
        ArrayList<Integer> randomArrayList = new ArrayList<>();
        Random random = new Random();

        // Loop that adds n amount of integers to the ArrayList
        for (int i = 0; i < n; i++) {
            randomArrayList.add(random.nextInt(10));
        }
        System.out.println("ArrayList Size: " + randomArrayList.size());

        // Clearing out the ArrayList
        //randomArrayList.clear();
        for (int i = (n-1);  i > -1; i--) {
            randomArrayList.remove(i);
        }
        System.out.println("ArrayList Size: " + randomArrayList.size());
    }

    public static void linkedListMethod(int n) {
        // Creates new LinkedList to hold n amount of random integers
        LinkedList<Integer> randomLinkedList = new LinkedList<Integer>();
        Random random = new Random();

        // Loop that adds n amount of integers to the LinkedList
        for (int i = 0; i < n; i++) {
            randomLinkedList.add(random.nextInt(10));
        }
        System.out.println("LinkedList Size: " + randomLinkedList.size());

        // Clearing out the LinkedList
        //randomLinkedList.clear();
        for (int i = (n-1); i > -1; i--) {
            randomLinkedList.pop();
        }
        System.out.println("LinkedList Size: " + randomLinkedList.size());

    }

    public static void hashtableMethod(int n) {
        // Creates new Hashtable to hold n amount of random integers
        Hashtable<Integer, Integer> randomHashTable = new Hashtable<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            randomHashTable.put(i, random.nextInt(10));
        }
        System.out.println("Hashtable Size: " + randomHashTable.size());

        // Clearing out Hashtable
        //randomHashTable.clear();
        for (int i = (n-1); i > -1; i--) {
            randomHashTable.remove(i);
        }
        System.out.println("Hashtable Size: " + randomHashTable.size());
    }
}