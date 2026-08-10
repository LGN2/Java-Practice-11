package Gym_Membership_Desk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*
     * Abstraction is provided by the Payable interface because
     * the menu can work with both member types without knowing
     * their specific class.
     *
     * Encapsulation is provided by private fields and setters
     * that validate data before storing it.
     *
     * If memberName were public, the program could do something
     * like member.memberName = ""; and skip the name validation rule.
     */

    static Scanner scanner = new Scanner(System.in);
    static List<Payable> members = new ArrayList<>();

    public static void main(String[] args) {
        setup();
        menu();
        scanner.close();
    }

    public static void setup() {

        System.out.println("--- Single member created at startup ---");

        MonthlyMember firstMember =
                new MonthlyMember(
                        "Sarah Bennett",
                        25,
                        45.000,
                        1001
                );

        firstMember.printAllInfo();

        members.add(firstMember);
    }

    public static MonthlyMember addMonthlyMember() {

        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter monthly fee: ");
        double fee = scanner.nextDouble();

        System.out.print("Enter membership ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        MonthlyMember member =
                new MonthlyMember(
                        name,
                        age,
                        fee,
                        id
                );

        System.out.println("Added.");

        return member;
    }

    public static DayPassVisitor addDayPassVisitor() {

        IO.print("Enter member name: ");
        String name = scanner.nextLine();

        IO.print("Enter age: ");
        int age = scanner.nextInt();

        IO.print("Enter price per visit: ");
        double price = scanner.nextDouble();

        IO.print("Enter number of visits: ");
        int visits = scanner.nextInt();

        IO.print("Enter membership ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        DayPassVisitor visitor =
                new DayPassVisitor(
                        name,
                        age,
                        price,
                        visits,
                        id
                );

        IO.println("Added.");

        return visitor;
    }

    public static void printAllMembers() {

        IO.println("--- ALL MEMBERS ---");

        for (Payable member : members) {
            member.printAllInfo();
        }
    }

    public static void showTotalMonthlyIncome() {

        double total = 0;

        for (Payable member : members) {

            total = total + member.monthlyTotal();
        }

        IO.println("Total monthly income: "+ total +" OMR");
    }

    public static void searchMember() {

        IO.print("Enter name to search: ");
        String searchName = scanner.nextLine();

        boolean found = false;

        for (Payable member : members) {

            if (member.getMemberName().equals(searchName)) {

                member.printAllInfo();
                found = true;
            }
        }

        if (found == false) {

            IO.println("Member not found.");
        }
    }

    public static void menu() {

        boolean exit = false;

        while (exit == false) {

            IO.println();
            IO.println("--- GYM MEMBERSHIP MENU ---");
            IO.println("1. Add a monthly member");
            IO.println("2. Add a day-pass visitor");
            IO.println("3. Print all members");
            IO.println("4. Show total monthly income");
            IO.println("5. Search a member by name");
            IO.println("6. Exit");
            IO.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                members.add(addMonthlyMember());

            } else if (choice == 2) {

                members.add(addDayPassVisitor());

            } else if (choice == 3) {

                printAllMembers();

            } else if (choice == 4) {

                showTotalMonthlyIncome();

            } else if (choice == 5) {

                searchMember();

            } else if (choice == 6) {

                exit = true;
                IO.println("Goodbye.");

            } else {

                IO.println("Invalid choice.");
            }
        }
    }
}