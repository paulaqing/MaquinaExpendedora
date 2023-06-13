import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagementTest {
    Management management = new Management();

    @BeforeEach
    void setUp() {
        Management management = new Management();
    }


    @Test
    void getMachineId() {
        assertEquals(3, management.getMachineId(3));

    }

    @Test
    void machineInformation() {
        float moneyOld = management.getMachines().get(2).getMoney().getTotal();
        Money client = new Money();
        client.insert(5.0f, 1);

        management.buyProduct(2, 1, client);
        float moneyNew = management.getMachines().get(2).getMoney().getTotal();
        assertEquals(moneyOld + 1.5f, moneyNew);

    }
}