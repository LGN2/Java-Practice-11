package Vehicle_Rental_Desk;

public interface Rentable {

    void printAllInfo();

    double costFor(int days);

    String getCategory();

    String getPlateNumber();
}