public abstract class Product {

    protected int id;
    protected String name;
    protected double price;
    protected int units;

    public Product(int id, String name, double price) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.units = 10;
    }

    public Product(int id, String name, double price, int[] amount) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.units = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUnits() {
        return this.units[i];
    }

    public void setUnits(int i, int value) {
        this.units[i] = value;
    }

    public void sell(int i) {
        this.amount[i]--;
    }


}
