package Gym_Membership_Desk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    static Scanner sc = new Scanner(System.in);
    static List<Payable> m = new ArrayList<>();

    public static void main(String[] args) {
        setup();
        menu();
        sc.close();
    }

    public static void setup() {

        IO.println("--- Single member created at startup ---");

        MonthlyMember firstMember =
                new MonthlyMember(
                        "Sarah Bennett",
                        25,
                        45.000,
                        1001);

        firstMember.printAllInfo();

        m.add(firstMember);
    }

    public static MonthlyMember addMonthlyMember() {

        IO.print("Enter member name: ");
        String name = sc.nextLine();

        IO.print("Enter age: ");
        int age = sc.nextInt();

        IO.print("Enter monthly fee: ");
        double fee = sc.nextDouble();

        IO.print("Enter membership ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        MonthlyMember member = new MonthlyMember(
                name,
                age,
                fee,
                id);

        IO.println("Added.");

        return member;
    }

    public static DayPassVisitor addDayPassVisitor() {

        IO.print("Enter member name: ");
        String name = sc.nextLine();

        IO.print("Enter age: ");
        int age = sc.nextInt();

        IO.print("Enter price per visit: ");
        double price = sc.nextDouble();

        IO.print("Enter number of visits: ");
        int visits = sc.nextInt();

        IO.print("Enter membership ID: ");
        int id = sc.nextInt();
        sc.nextLine();

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