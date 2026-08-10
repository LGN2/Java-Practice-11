package Shop_Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Sellable> stock = new ArrayList<>();

    public static void main(String[] args) {
        setup();
        menu();
        scanner.close();
    }

    public static void setup() {

        System.out.println("--- Single item created at startup ---");

        Product firstProduct = new Product("Rice 5kg", -5, 12);

        firstProduct.printAllInfo();

        stock.add(firstProduct);
    }

    public static Product addProduct() {

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product(name, price, quantity);

        System.out.println("Added.");

        return product;
    }

    public static Service addService() {

        System.out.print("Enter service name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter minutes: ");
        int minutes = scanner.nextInt();
        scanner.nextLine();

        Service service = new Service(name, price, minutes);

        System.out.println("Added.");

        return service;
    }

    public static void printAllStock() {

        System.out.println("--- ALL STOCK ---");

        for (Sellable item : stock) {
            item.printAllInfo();
        }
    }

    public static void showTotalValue() {

        double total = 0;

        for (Sellable item : stock) {
            total += item.getPrice();
        }

        System.out.printf(
                "Total value of stock: %.2f OMR%n",
                total
        );
    }

    public static void menu() {

        boolean exit = false;

        while (exit == false) {

            System.out.println();
            System.out.println("--- SHOP MENU ---");
            System.out.println("1. Add product");
            System.out.println("2. Add service");
            IO.println("3. Print stock");
            IO.println("4. Total value");
            IO.println("5. Exit");
            IO.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                stock.add(addProduct());

            } else if (choice == 2) {

                stock.add(addService());

            } else if (choice == 3) {

                printAllStock();

            } else if (choice == 4) {

                showTotalValue();

            } else if (choice == 5) {

                exit = true;
                IO.println("Goodbye.");

            } else {

                IO.println("Invalid choice.");
            }
        }
    }
}


