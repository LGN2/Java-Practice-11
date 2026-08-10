package Shop_Inventory;


public class Service extends SellableBase {

    private int minutes;


    public Service(String name, double price, int minutes) {
        super(name, price);
        setMinutes(minutes);
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes > 0) {
            this.minutes = minutes;
        } else {
            this.minutes = 0;
        }
    }

    @Override
    public String getCategory() {
        return "Service";
    }

    @Override
    public void printAllInfo() {
        IO.println("[Service] " + getName() + " OMR " + getPrice() + " min " + getMinutes());
    }
}


