package Merchantable;

import Merchantable.Food;

public class GlutenFree extends Food {

    public GlutenFree(String name, float price, int id, int units, double grams) {
        super(name, price, id, units, grams);

    }

    public void upPrice(int porcentage) {
        price = (float) (getPrice() * porcentage);
    }
}
