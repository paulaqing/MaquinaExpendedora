import Interface.State;
import Merchantable.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineTest {
    Machine machine = new Machine(1);

    @BeforeEach
    void setUp() {
        Money money = new Money();
        money.insert(1.0f, 10);
        money.insert(2.0f, 5);
        money.insert(5.0f, 10);
        money.insert(20.0f, 10);
        machine.setMoney(money);

        Product bread = new Gluten("Bread", 1.0f, 1, 10, 500.f);
        Product cocaCola = new Drinks("Coca Cola", 1.5f, 1, 10, false, 500.0f);
        Product biscuits = new GlutenFree("Biscuits", 2.0f, 1, 10, 500.f);
        machine.getProducts().add(bread);
        machine.getProducts().add(cocaCola);
        machine.getProducts().add(biscuits);

    }

    @Test
    void getProducts() {
        assertEquals(3, machine.getProducts().size());
    }

    @Test
    void getMoney() {
        assertEquals(270.0f, machine.getMoney().getTotal());

    }

    @Test
    void getState() {
        assertEquals(State.NORMAL, machine.getState());
    }
}