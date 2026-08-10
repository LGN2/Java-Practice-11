package Gym_Membership_Desk;

public class DayPassVisitor implements Payable {

    private String memberName;
    private int age;
    private double pricePerVisit;
    private int visits;
    private final int membershipId;


    public DayPassVisitor(
            String memberName,
            int age,
            double pricePerVisit,
            int visits,
            int membershipId) {

        setMemberName(memberName);
        setAge(age);
        setPricePerVisit(pricePerVisit);
        setVisits(visits);

        if (membershipId > 0) {

            this.membershipId = membershipId;

        } else {

            System.out.println("Membership ID must be above 0.");
            this.membershipId = 1;
        }
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {

        if (memberName == null ||
                memberName.trim().length() < 2) {

            System.out.println(
                    "Member name must be at least 2 characters."
            );

        } else {

            this.memberName = memberName.trim();
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if (age < 14) {

            System.out.println("Too young to register .");

        } else if (age > 90) {

            System.out.println("Age must be between 14 and 90.");

        } else {

            this.age = age;
        }
    }

    public double getPricePerVisit() {
        return pricePerVisit;
    }

    public void setPricePerVisit(double pricePerVisit) {

        if (pricePerVisit > 0) {

            this.pricePerVisit = pricePerVisit;

        } else {

            System.out.println(
                    "Price per visit must be above 0."
            );
        }
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {

        if (visits >= 1 && visits <= 31) {

            this.visits = visits;

        } else {

            System.out.println(
                    "Visits must be from 1 to 31."
            );
        }
    }

    public int getMembershipId() {
        return membershipId;
    }

    @Override
    public double monthlyTotal() {
        return pricePerVisit * visits;
    }

    @Override
    public String getMemberName() {
        return memberName;
    }

    @Override
    public void printAllInfo() {

        System.out.printf(
                "[Day Pass] ID: %d | Name: %s | Age: %d | " +
                        "Price: %.2f OMR | Visits: %d | Total: %.2f OMR%n",
                membershipId,
                memberName,
                age,
                pricePerVisit,
                visits,
                monthlyTotal()
        );
    }
}