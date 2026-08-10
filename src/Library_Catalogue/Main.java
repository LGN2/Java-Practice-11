package Library_Catalogue;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<LibraryItem> catalogue = new ArrayList<>();

    public static void main(String[] args) {
        setup();
        menu();
        scanner.close();
    }

    public static void setup() {

        System.out.println("--- Single item created at startup ---");

        Book firstBook = new Book(
                "Clean Code",
                "Robert Martin",
                464,
                "B-01"
        );

        firstBook.printAllInfo();

        catalogue.add(firstBook);
    }

    public static Book addBook() {

        Book book = new Book();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        book.setTitle(title);

        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        book.setAuthor(author);

        System.out.print("Enter pages: ");
        int pages = scanner.nextInt();
        scanner.nextLine();
        book.setPages(pages);

        System.out.print("Enter shelf code: ");
        String shelfCode = scanner.nextLine();
        book.setShelfCode(shelfCode);

        System.out.println("Added.");

        return book;
    }

    public static Magazine addMagazine() {

        Magazine magazine = new Magazine();

        System.out.print("Enter magazine name: ");
        String name = scanner.nextLine();
        magazine.setName(name);

        System.out.print("Enter issue number: ");
        int issueNumber = scanner.nextInt();
        scanner.nextLine();
        magazine.setIssueNumber(issueNumber);

        System.out.print("Enter month: ");
        String month = scanner.nextLine();
        magazine.setMonth(month);

        System.out.print("Enter shelf code: ");
        String shelfCode = scanner.nextLine();
        magazine.setShelfCode(shelfCode);

        System.out.println("Added.");

        return magazine;
    }

    public static void printAll() {

        System.out.println("--- ALL LIBRARY ITEMS ---");

        for (LibraryItem item : catalogue) {
            item.printAllInfo();
        }
    }

    public static void countItems() {

        System.out.println("Total items: " + catalogue.size());
    }

    public static void menu() {

        boolean exit = false;

        while (exit == false) {

            System.out.println();
            System.out.println("--- LIBRARY MENU ---");
            System.out.println("1. Add book");
            System.out.println("2. Add magazine");
            System.out.println("3. Print all");
            System.out.println("4. Count items");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                catalogue.add(addBook());

            } else if (choice == 2) {

                catalogue.add(addMagazine());

            } else if (choice == 3) {

                printAll();

            } else if (choice == 4) {

                countItems();

            } else if (choice == 5) {

                exit = true;
                System.out.println("Goodbye.");

            } else {

                System.out.println("Invalid choice.");
            }
        }
    }
}

