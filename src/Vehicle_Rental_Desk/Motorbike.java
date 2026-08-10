package Vehicle_Rental_Desk;

public class Motorbike implements Rentable {

    private String plateNumber;
    private double dailyRate;
    private int engineSize;


    public Motorbike(String plateNumber, double dailyRate, int engineSize) {
        setPlateNumber(plateNumber);
        setDailyRate(dailyRate);
        setEngineSize(engineSize);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {

        if (plateNumber == null || plateNumber.trim().isEmpty()) {
            IO.println("Plate number cannot be empty.");
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
            IO.println("Daily rate must be above 0 and not more than 200.");
        }
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {

        if (engineSize >= 50 && engineSize <= 1500) {
            this.engineSize = engineSize;
        } else {
            IO.println("Engine size must be between 50 and 1500 cc.");
        }
    }

    @Override
    public String getCategory() {
        return "Motorbike";
    }

    @Override
    public double costFor(int days) {

        if (days >= 1 && days <= 30) {
            return dailyRate * days;
        }

        IO.println("Rental days must be from 1 to 30.");
        return 0;
    }

    @Override
    public void printAllInfo() {

        IO.println("[Motorbike] Plate: " + plateNumber + " Rate: " + dailyRate + " OMR/day " + " Engine: " + engineSize);
    }
}
