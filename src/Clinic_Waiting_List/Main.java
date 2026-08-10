package Clinic_Waiting_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Attendable> queue = new ArrayList<>();

    public static void main(String[] args) {
        setup();
        menu();
        scanner.close();
    }

    public static void setup() {

        System.out.println("--- Single item created at startup ---");

        BookedPatient firstPatient =
                new BookedPatient("Sarah Bennett", 150, "09:30");

        firstPatient.printAllInfo();

        queue.add(firstPatient);
    }

    public static BookedPatient addBooked() {

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter slot time: ");
        String slotTime = scanner.nextLine();

        BookedPatient patient =
                new BookedPatient(name, age, slotTime);

        System.out.println("Added.");

        return patient;
    }

    public static WalkInVisitor addWalkIn() {

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter arrival order: ");
        int arrivalOrder = scanner.nextInt();
        scanner.nextLine();

        WalkInVisitor visitor =
                new WalkInVisitor(name, age, arrivalOrder);

        System.out.println("Added.");

        return visitor;
    }

    public static void printQueue() {

        System.out.println("--- CLINIC QUEUE ---");

        for (Attendable item : queue) {
            item.printAllInfo();
        }
    }

    public static void showLongestWait() {

        int longestWait = 0;
        String longestName = "";

        for (Attendable item : queue) {

            if (item.getWaitMinutes() > longestWait) {

                longestWait = item.getWaitMinutes();

                AttendableBase person =
                        (AttendableBase) item;

                longestName = person.getName();
            }
        }

        IO.println("Longest wait: " + longestName + " (" + longestWait + " min)"
        );
    }

    public static void menu() {

        boolean exit = false;

        while (exit == false) {

            IO.println();
            IO.println("--- CLINIC MENU ---");
            IO.println("1. Add booked patient");
            IO.println("2. Add walk-in");
            IO.println("3. Print queue");
            IO.println("4. Longest wait");
            IO.println("5. Exit");
            IO.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                queue.add(addBooked());

            } else if (choice == 2) {

                queue.add(addWalkIn());

            } else if (choice == 3) {

                printQueue();

            } else if (choice == 4) {

                showLongestWait();

            } else if (choice == 5) {

                exit = true;
                IO.println("Goodbye.");

            } else {

                IO.println("Invalid choice.");
            }
        }
    }
}
