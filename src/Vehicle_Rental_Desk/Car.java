package Vehicle_Rental_Desk;

public class Car implements Rentable {

    private String plateNumber;
    private double dailyRate;
    private int seats;

    // This field is read-only because the insurance fee is
    // always fixed at 5.000 for every car. It should not be
    // changed by the user, so it has a getter but no setter.
    private final double insuranceFee = 5.000;

    public Car() {
    }

    public Car(String plateNumber, double dailyRate, int seats) {
        setPlateNumber(plateNumber);
        setDailyRate(dailyRate);
        setSeats(seats);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {

        if (plateNumber == null || plateNumber.trim().isEmpty()) {
            System.out.println("Plate number cannot be empty.");
        } else {
            this.plateNumber = plateNumber;
        }
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {

        if (dailyRate > 0 && dailyRate <= 200) {
            this.dailyRate = dailyRate;
        } else {
            System.out.println("Daily rate must be above 0 and not more than 200.");
        }
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {

        if (seats >= 2 && seats <= 7) {
            this.seats = seats;
        } else {
            System.out.println("Car must have between 2 and 7 seats.");
        }
    }

    public double getInsuranceFee() {
        return insuranceFee;
    }

    @Override
    public String getCategory() {
        return "Car";
    }

    @Override
    public double costFor(int days) {

        if (days >= 1 && days <= 30) {
            return (dailyRate * days) + insuranceFee;
        }

        System.out.println("Rental days must be from 1 to 30.");
        return 0;
    }

    @Override
    public void printAllInfo() {

        System.out.printf(
                "[Car] Plate: %s | Rate: %.3f OMR/day | Seats: %d%n",
                plateNumber,
                dailyRate,
                seats
        );
    }
}