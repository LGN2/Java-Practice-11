package Gym_Membership_Desk;

public class MonthlyMember implements Payable {

    private String memberName;
    private int age;
    private double monthlyFee;
    private final int membershipId;

    public MonthlyMember(
            String memberName,
            int age,
            double monthlyFee,
            int membershipId) {

        setMemberName(memberName);
        setAge(age);
        setMonthlyFee(monthlyFee);

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

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {

        if (monthlyFee > 0 && monthlyFee <= 500) {

            this.monthlyFee = monthlyFee;

        } else {

            System.out.println(
                    "Monthly fee must be above 0 and not more than 500."
            );
        }
    }

    public int getMembershipId() {
        return membershipId;
    }

    @Override
    public double monthlyTotal() {
        return monthlyFee;
    }

    @Override
    public String getMemberName() {
        return memberName;
    }

    @Override
    public void printAllInfo() {

        System.out.printf(
                "[Monthly] ID: %d | Name: %s | Age: %d | Fee: %.2f OMR%n",
                membershipId,
                memberName,
                age,
                monthlyFee
        );
    }
}