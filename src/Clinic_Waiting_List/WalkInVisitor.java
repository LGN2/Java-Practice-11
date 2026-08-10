package Clinic_Waiting_List;

public class WalkInVisitor extends AttendableBase {

    private int arrivalOrder;

    public WalkInVisitor() {
    }

    public WalkInVisitor(String name, int age, int arrivalOrder) {
        super(name, age);
        setArrivalOrder(arrivalOrder);
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    public void setArrivalOrder(int arrivalOrder) {
        if (arrivalOrder > 0) {
            this.arrivalOrder = arrivalOrder;
        } else {
            this.arrivalOrder = 1;
        }
    }

    @Override
    public String getPriority() {
        return "Walk-in";
    }

    @Override
    public int getWaitMinutes() {
        return arrivalOrder * 15;
    }

    @Override
    public void printAllInfo() {
        IO.println("[Walk-in] " + getName()
                + " age "
                + getAge()
                + " waits "
                + getWaitMinutes()
                + " min");
    }
}