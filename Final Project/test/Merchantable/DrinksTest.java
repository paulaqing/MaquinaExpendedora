package Merchantable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinksTest {
    Drinks drinks = new Drinks("Coca Cola", 1.5f, 1, 10, false, 500.0f);

    @Test
    void isAlcohol() {
        assertEquals(false, drinks.isAlcohol()
        );
    }

    @Test
    void setAlcohol() {
        assertEquals(false, drinks.isAlcohol()
        );
    }

    @Test
    void getMilimeters() {
        assertEquals(500.0f, drinks.getMilimeters());
    }

    @Test
    void setMilimeters() {
        assertEquals(500.0f, drinks.getMilimeters());
    }
}