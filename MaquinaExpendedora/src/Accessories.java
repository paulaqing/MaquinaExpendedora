public class Accessories extends Product{
    private int boxes;

    public Accessories(int id, String name, double price, int boxes) {
        super( name, price, units);
        this.boxes = boxes;
    }
}
