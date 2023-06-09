package Merchantable;

import Merchantable.Food;

public class Gluten extends Food {
    public Gluten(String name, float price, int id, int units, double grams) {
        super(name, price, id, units, grams);
    }

    public void upPrice(int porcentage) {
        price = (float) (getPrice() * porcentage);
    }
}
