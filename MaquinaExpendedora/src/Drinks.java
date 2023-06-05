public class Drinks extends Product{
    private boolean alcohol;
    private double milimeters;

    public Drinks( String name, double price, int[] amount, boolean alcohol, double milimeters) {
        super( name, price, amount);
        this.alcohol = alcohol;
        this.milimeters = milimeters;
    }

    public boolean isAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    public double getMilimeters() {
        return milimeters;
    }

    public void setMilimeters(double milimeters) {
        this.milimeters = milimeters;
    }
}
