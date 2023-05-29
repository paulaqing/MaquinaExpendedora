public class Gluten extends Food implements Salable{
    public Gluten( String name, double price, int[] amount) {
        super( name, price, amount);
    }

    @Override
    public boolean isAvalaible() {
        return false;
    }

    @Override
    public void upPrice(int porcentage) {
        price=getPrice()*porcentage;
    }
}
