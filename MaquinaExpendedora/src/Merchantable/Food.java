package Merchantable;

public abstract class Food extends Product {
    private double grams;

    public Food(String name, float price, int id, int units, double grams) {
        super(name, price, id, units);
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    public void setGrams(double grams) {
        this.grams = grams;
    }
}
