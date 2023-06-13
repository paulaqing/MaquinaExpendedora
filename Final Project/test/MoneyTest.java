import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    Money money = new Money();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        money.insert(1.0f, 10);
        money.insert(2.0f, 5);
        money.insert(5.0f, 10);
        money.insert(20.0f, 10);
    }

    @org.junit.jupiter.api.Test
    void getTotal() {

        assertEquals(270.f, money.getTotal());
    }

    @org.junit.jupiter.api.Test
    void getCoins() {
        assertEquals(10, money.getCoins(1.0f));
        assertEquals(5, money.getCoins(2.0f));
        assertEquals(10, money.getCoins(5.0f));
        assertEquals(10, money.getCoins(20.0f));
    }

    @org.junit.jupiter.api.Test
    void add() {
        Money money2 = new Money();
        money2.insert(1.0f, 10);
        money2.insert(2.0f, 5);
        money2.insert(5.0f, 10);
        money2.insert(20.0f, 10);

        money.add(money2);
        assertEquals(540.f, money.getTotal());
    }
}