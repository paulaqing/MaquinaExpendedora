public abstract class Food extends Product{
    private double grams;

    public Food(String name, double price, int[] amount) {
        super( name, price,amount);
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    public void setGrams(double grams) {
        this.grams = grams;
    }
}
