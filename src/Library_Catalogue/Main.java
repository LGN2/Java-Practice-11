package Library_Catalogue;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<LibraryItem> catalogue = new ArrayList<>();

    public static void main(String[] args) {
        setup();
        menu();
        sc.close();
    }

    public static void setup() {

        IO.println("--- Single item created at startup ---");

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

        IO.print("Enter title: ");
        String title = sc.nextLine();
        book.setTitle(title);

        IO.print("Enter author: ");
        String author = sc.nextLine();
        book.setAuthor(author);

        IO.print("Enter pages: ");
        int pages = sc.nextInt();
        sc.nextLine();
        book.setPages(pages);

        IO.print("Enter shelf code: ");
        String shelfCode = sc.nextLine();
        book.setShelfCode(shelfCode);

        IO.println("Added.");

        return book;
    }

    public static Magazine addMagazine() {

        Magazine magazine = new Magazine();

        IO.print("Enter magazine name: ");
        String name = scanner.nextLine();
        magazine.setName(name);

        IO.print("Enter issue number: ");
        int issueNumber = scanner.nextInt();
        scanner.nextLine();
        magazine.setIssueNumber(issueNumber);

        IO.print("Enter month: ");
        String month = scanner.nextLine();
        magazine.setMonth(month);

        IO.print("Enter shelf code: ");
        String shelfCode = scanner.nextLine();
        magazine.setShelfCode(shelfCode);

        IO.println("Added.");

        return magazine;
    }

    public static void printAll() {

        IO.println("--- ALL LIBRARY ITEMS ---");

        for (LibraryItem item : catalogue) {
            item.printAllInfo();
        }
    }

    public static void countItems() {

        IO.println("Total items: " + catalogue.size());
    }

    public static void menu() {

        boolean exit = false;

        while (exit == false) {

            IO.println();
            IO.println("--- LIBRARY MENU ---");
            IO.println("1. Add book");
            IO.println("2. Add magazine");
            IO.println("3. Print all");
            IO.println("4. Count items");
            IO.println("5. Exit");
            IO.print("Choose: ");

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
                IO.println("Goodbye.");

            } else {

                IO.println("Invalid choice.");
            }
        }
    }
}

