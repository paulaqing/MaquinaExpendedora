public class Accessories extends Product {
    private int boxes;

    public Accessories(String name, float price, int id, int units, int boxes) {
        super(name, price, id, units);
        this.boxes = boxes;
    }
}
