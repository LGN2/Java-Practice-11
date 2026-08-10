package Clinic_Waiting_List;

public class BookedPatient extends AttendableBase {

    private String slotTime;

    public BookedPatient() {
    }

    public BookedPatient(String name, int age, String slotTime) {
        super(name, age);
        this.slotTime = slotTime;
    }

    public String getSlotTime() {
        return slotTime;
    }

    @Override
    public String getPriority() {
        return "Booked";
    }

    @Override
    public int getWaitMinutes() {
        return 10;
    }

    @Override
    public void printAllInfo() {
        IO.println("[Booked] " + getName()
                + ", age " + getAge()
                + ", slot " + getSlotTime()
                + ", waits " + getWaitMinutes() + " min");
    }
}