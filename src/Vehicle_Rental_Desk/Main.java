package Vehicle_Rental_Desk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*
     * Abstraction is provided by the Rentable interface because
     * the menu works with Rentable objects instead of specific classes.
     *
     * Encapsulation is provided by private fields and getters/setters
     * that control how values are stored and validated.
     */

    static Scanner scanner = new Scanner(System.in);
    static List<Rentable> rentals = new ArrayList<>();

    public static void main(String[] args) {
        setup();
        menu();
        scanner.close();
    }

    public static void setup() {

        System.out.println("--- Single rental created at startup ---");

        Car firstCar = new Car("ABC-123", 20.000, 5);

        firstCar.printAllInfo();

        rentals.add(firstCar);
    }

    public static Car addCar() {

        System.out.print("Enter plate number: ");
        String plateNumber = scanner.nextLine();

        System.out.print("Enter daily rate: ");
        double dailyRate = scanner.nextDouble();

        System.out.print("Enter number of seats: ");
        int seats = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(
                plateNumber,
                dailyRate,
                seats
        );

        System.out.println("Added.");

        return car;
    }

    public static Motorbike addMotorbike() {

        System.out.print("Enter plate number: ");
        String plateNumber = scanner.nextLine();

        System.out.print("Enter daily rate: ");
        double dailyRate = scanner.nextDouble();

        System.out.print("Enter engine size in cc: ");
        int engineSize = scanner.nextInt();
        scanner.nextLine();

        Motorbike motorbike = new Motorbike(
                plateNumber,
                dailyRate,
                engineSize
        );

        System.out.println("Added.");

        return motorbike;
    }

    public static void printAllRentals() {

        System.out.println("--- EVERYTHING ON HIRE ---");

        for (Rentable item : rentals) {
            item.printAllInfo();
        }
    }

    public static void showTotalIncome() {

        System.out.print("Enter rental days: ");
        int days = scanner.nextInt();
        scanner.nextLine();

        double total = 0;

        for (Rentable item : rentals) {
            total = total + item.costFor(days);
        }

        System.out.printf(
                "Total income for %d days: %.3f OMR%n",
                days,
                total
        );
    }

    public static void menu() {

        boolean exit = false;

        while (exit == false) {

            System.out.println();
            System.out.println("--- VEHICLE RENTAL MENU ---");
            System.out.println("1. Add a car");
            System.out.println("2. Add a motorbike");
            System.out.println("3. Print everything on hire");
            System.out.println("4. Show total income");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                rentals.add(addCar());

            } else if (choice == 2) {

                rentals.add(addMotorbike());

            } else if (choice == 3) {

                printAllRentals();

            } else if (choice == 4) {

                showTotalIncome();

            } else if (choice == 5) {

                exit = true;
                System.out.println("Goodbye.");

            } else {

                System.out.println("Invalid choice.");
            }
        }
    }
}