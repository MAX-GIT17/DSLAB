// Linked List in Java using user input and switch case
// Without using any built-in library functions

import java.util.Scanner;

class Node {
    int data;        // To store data
    Node next;       // To store address of next node
}

class LinkedList {
    Node head;       // Head of the list

    // Function to insert a new node at the end
    void insert(int value) {
        Node newNode = new Node();   // Create a new node
        newNode.data = value;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Inserted " + value + " successfully.");
    }

    // Function to delete a node by value
    void delete(int value) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.data == value) {
            head = head.next;
            System.out.println("Deleted " + value + " successfully.");
            return;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null && temp.data != value) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found!");
        } else {
            prev.next = temp.next;
            System.out.println("Deleted " + value + " successfully.");
        }
    }

    // Function to display all nodes
    void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int choice, value;

        System.out.println("---- Linked List Operations ----");

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    list.insert(value);
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    value = sc.nextInt();
                    list.delete(value);
                    break;

                case 3:
                    list.display();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}