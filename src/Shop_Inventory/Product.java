package Shop_Inventory;


public class Product extends SellableBase {

    private int quantity;


    public Product(String name, double price, int quantity) {
        super(name, price);
        setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 1 && quantity <= 100) {
            this.quantity = quantity;
        } else {
            IO.println("Quantity must be 1 to 100.");
        }
    }

    @Override
    public String getCategory() {
        return "Product";
    }

    @Override
    public void printAllInfo() {
        IO.println("[Product] " + getName() +  getPrice() +" OMR  qty " + getQuantity());
    }
}

