package Vehicle_Rental_Desk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<Rentable> r = new ArrayList<>();

    public static void main(String[] args) {
        setup();
        menu();
        sc.close();
    }

    public static void setup() {

        IO.println("--- Single rental created at startup ---");

        Car firstCar = new Car("ABC-123", 20.000, 5);

        firstCar.printAllInfo();

        r.add(firstCar);
    }

    public static Car addCar() {

        IO.print("Enter plate number: ");
        String plateNumber = sc.nextLine();

        IO.print("Enter daily rate: ");
        double dailyRate = sc.nextDouble();

        IO.print("Enter number of seats: ");
        int seats = sc.nextInt();
        sc.nextLine();

        Car car = new Car(
                plateNumber,
                dailyRate,
                seats
        );

        IO.println("Added.");

        return car;
    }

    public static Motorbike addMotorbike() {

        IO.print("Enter plate number: ");
        String plateNumber = sc.nextLine();

        IO.print("Enter daily rate: ");
        double dailyRate = sc.nextDouble();

        IO.print("Enter engine size in cc: ");
        int engineSize = sc.nextInt();
        sc.nextLine();

        Motorbike motorbike = new Motorbike(
                plateNumber,
                dailyRate,
                engineSize
        );

       IO.println("Added.");

        return motorbike;
    }

    public static void printAllRentals() {

        IO.println("--- EVERYTHING ON HIRE ---");

        for (Rentable item : r) {
            item.printAllInfo();
        }
    }

    public static void showTotalIncome() {

        IO.print("Enter rental days: ");
        int days = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (Rentable item : r) {
            total = total + item.costFor(days);
        }

        IO.println("Total income for days:" + days + " " + total + " OMR");
    }

    public static void menu() {

        boolean exit = false;

        while (exit == false) {

            IO.println();
            IO.println("--- VEHICLE RENTAL MENU ---");
            IO.println("1. Add a car");
            IO.println("2. Add a motorbike");
            IO.println("3. Print everything on hire");
            IO.println("4. Show total income");
            IO.println("5. Exit");
            IO.print("Choose: ");

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
                IO.println("Goodbye.");

            } else {

                IO.println("Invalid choice.");
            }
        }
    }
}