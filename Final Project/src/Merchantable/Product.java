package Merchantable;

public abstract class Product {
    protected String name;
    protected float price;
    protected int id;
    protected int units;


    public Product(String name, float price, int id, int units) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.units = units;
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

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                ", units=" + units +
                '}';
    }
}
