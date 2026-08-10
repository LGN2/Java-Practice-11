package Shop_Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<Sellable> stock = new ArrayList<>();

    public static void main(String[] args) {
        setup();
        menu();
        sc.close();
    }

    public static void setup() {

        IO.println("--- Single item created at startup ---");

        Product firstProduct = new Product("Rice 5kg", -5, 12);

        firstProduct.printAllInfo();

        stock.add(firstProduct);
    }

    public static Product addProduct() {

        IO.print("Enter product name: ");
        String name = sc.nextLine();

        IO.print("Enter price: ");
        double price = sc.nextDouble();

        IO.print("Enter quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        Product product = new Product(name, price, quantity);

        IO.println("Added.");

        return product;
    }

    public static Service addService() {

        IO.print("Enter service name: ");
        String name = sc.nextLine();

        IO.print("Enter price: ");
        double price = sc.nextDouble();

        IO.print("Enter minutes: ");
        int minutes = sc.nextInt();
        sc.nextLine();

        Service service = new Service(name, price, minutes);

        IO.println("Added.");

        return service;
    }

    public static void printAllStock() {

        IO.println("--- ALL STOCK ---");

        for (Sellable item : stock) {
            item.printAllInfo();
        }
    }

    public static void showTotalValue() {

        double total = 0;

        for (Sellable item : stock) {
            total += item.getPrice();
        }

        IO.println("Total value of stock: %.2f OMR%n" + total);
    }

    public static void menu() {

        boolean exit = false;

        while (exit == false) {

            IO.println();
            IO.println("--- SHOP MENU ---");
            IO.println("1. Add product");
            IO.println("2. Add service");
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


