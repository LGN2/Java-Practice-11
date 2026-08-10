package Shop_Inventory;


public abstract class SellableBase implements Sellable {

    private String name;
    private double price;

    public SellableBase() {
    }

    public SellableBase(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0 && price <= 10000) {
            this.price = price;
        } else {
            System.out.println("Price out of range");
        }
    }

    @Override
    public abstract void printAllInfo();

    @Override
    public abstract String getCategory();
}


