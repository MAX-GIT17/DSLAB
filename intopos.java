import java.util.*;

public class simparrop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[100]; 
        int size = n;
		
		for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean running = true;

        while (running) {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Insert
                    System.out.println("1. Insert at Beginning");
                    System.out.println("2. Insert at End");
                    System.out.println("3. Insert at Custom Position");
                    int insertChoice = sc.nextInt();

                    System.out.print("Enter value to insert: ");
                    int val = sc.nextInt();

                    int pos = 0;
                    if (insertChoice == 1) pos = 0;
                    else if (insertChoice == 2) pos = size;
                    else if (insertChoice == 3) {
                        System.out.print("Enter position between (0 to " + size + "): ");
                        pos = sc.nextInt();
                        if (pos < 0 || pos > size) {
                            System.out.println("Invalid position.");
                            break;
                        }
                    } else {
                        System.out.println("Invalid insert choice.");
                        break;
                    }

                    for (int i = size; i > pos; i--) {
                        arr[i] = arr[i - 1];
                    }
                    arr[pos] = val;
                    size++;
                    System.out.println("Inserted successfully.");
                    break;

                case 2: // Delete
                    if (size == 0) {
                        System.out.println("Array is empty!");
                        break;
                    }

                    System.out.println("1. Delete from Beginning");
                    System.out.println("2. Delete from End");
                    System.out.println("3. Delete from Custom Position");
                    int deleteChoice = sc.nextInt();

                    int delPos = 0;
                    if (deleteChoice == 1) delPos = 0;
                    else if (deleteChoice == 2) delPos = size - 1;
                    else if (deleteChoice == 3) {
                        System.out.print("Enter position (0 to " + (size - 1) + "): ");
                        delPos = sc.nextInt();
                        if (delPos < 0 || delPos >= size) {
                            System.out.println("Invalid position.");
                            break;
                        }
                    } else {
                        System.out.println("Invalid delete choice.");
                        break;
                    }

                    for (int i = delPos; i < size - 1; i++) {
                        arr[i] = arr[i + 1];
                    }
                    size--;
                    System.out.println("Deleted successfully.");
                    break;

                case 3: // Display
                    if (size == 0) {
                        System.out.println("Array is empty.");
                    } else {
                        System.out.print("Array: ");
                        for (int i = 0; i < size; i++) {
                            System.out.print(arr[i] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 4: // Exit
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
