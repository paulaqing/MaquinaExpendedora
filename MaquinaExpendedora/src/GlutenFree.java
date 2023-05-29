public class GlutenFree extends Food{
    public GlutenFree( String name, double price, int[] amount) {
        super( name, price,amount);
        this.salable = salable;
    }

    private Salable salable;
    public void upPrice(int porcentage) {
        price=getPrice()*porcentage;
    }
}
