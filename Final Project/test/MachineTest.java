import Interface.State;
import Merchantable.Drinks;
import Merchantable.Food;
import Merchantable.Gluten;
import Merchantable.GlutenFree;
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

        Gluten gluten = new Gluten("Bread", 1.5f, 1, 10,  500.0f);
        Drinks drinks = new Drinks("Coca Cola", 1.5f, 1, 10, false, 500.0f);
        GlutenFree glutenFree = new GlutenFree("Biscuits", 1.5f, 1, 10,  500.0f);


    }

    @Test
    void getProducts() {
        assertEquals("Bread, Coca Cola, Biscuits", machine.getProducts().size());
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